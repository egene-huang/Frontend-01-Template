package mysql.insert.daily;

import mysql.MysqlConn;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
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
        long start = System.currentTimeMillis();
        for (int i = 0; i < range; i++) {
            long skuId = new Random(100000L).nextLong();
            skuId = skuId * (-1L);
            preparedStatement.setLong(1, skuId + Long.parseLong("" + i));
            preparedStatement.setDate(2, new Date(System.currentTimeMillis()));
            preparedStatement.setBigDecimal(3, new BigDecimal("2323.9"));
            preparedStatement.addBatch();
            if (i % 10000 == 0) {
                preparedStatement.executeBatch();
                connection.commit();
                preparedStatement.clearBatch();
                continue;
            }
        }
        preparedStatement.executeBatch();
        connection.commit();
        System.out.println("耗时: " + (System.currentTimeMillis() - start));
    }
}
