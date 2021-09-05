package mysql.insert.daily;

import mysql.MysqlConn;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;

/**
 * <br/>
 * User: eugene <br/>
 * Date&Time: 2021/9/4 23:04
 */
public class DailyPriceInsert {
    static String insert_sql = "insert into daily_price" +
            "(sku_id, dt_day, price) " +
            "values(?,?,?)";

    public static void main(String[] args) throws Exception{
        insert_batch();
    }

    public static void insert_batch()throws Exception {
        int range = 1000000;
        Connection connection = MysqlConn.MYSQL_CONN.getConnection();
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(insert_sql);
        PreparedStatement preparedStatement_yesterday = connection.prepareStatement(insert_sql);
        long now = System.currentTimeMillis();
        long start = now;
        LocalDate localDate = LocalDate.now().minusDays(1);
        long yesterday_mill = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        for (int i = 0; i < range; i++) {
            long skuId = new Random(100000L).nextLong();
            if (skuId < 0) {
                skuId = skuId * (-1L);
            }
            preparedStatement.setLong(1, skuId + Long.parseLong("" + i));
            preparedStatement_yesterday.setLong(1, skuId + Long.parseLong("" + i));
            preparedStatement.setDate(2, new Date(now));
            preparedStatement_yesterday.setDate(2, new Date(yesterday_mill));
            preparedStatement.setBigDecimal(3, new BigDecimal("2323.9"));
            preparedStatement_yesterday.setBigDecimal(3, new BigDecimal("2322.9"));
            preparedStatement.addBatch();
            preparedStatement_yesterday.addBatch();
            System.out.println("now = " + new Date(now));
            System.out.println("yesterday_mill = " + new Date(yesterday_mill));
            if (i % 10000 == 0) {
                /*preparedStatement.executeBatch();
                preparedStatement_yesterday.executeBatch();
                connection.commit();
                preparedStatement.clearBatch();
                preparedStatement_yesterday.clearBatch();*/
                continue;
            }
        }
        /*preparedStatement.executeBatch();
        preparedStatement_yesterday.executeBatch();
        connection.commit();*/
        System.out.println("耗时: " + (System.currentTimeMillis() - start));
    }
}
