package mysql.insert.order;


import mysql.MysqlConn;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

/**
 * <br/>
 * User: eugene <br/>
 * Date&Time: 2021/5/16 21:32
 */
public class OrderInsert {

    static String insert_sql = "insert into order_info" +
            "(order_id, amount, pin, payment_amount, payment_time, site, create_time, update_time) " +
            "values(?,?,?,?,?,?,?,?)";
    public static void main(String[] args) throws Exception{
        //test
//        insert_non();
//        insert_batch(); //耗时: 141165
//        insert_obo(); //耗时: 1942203
    }

    public static void insert_obo()throws Exception {
        int range = 1000000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < range; i++) {
            insert_non();
        }
        System.out.println("耗时: " + (System.currentTimeMillis() - start));
    }

    public static void insert_batch()throws Exception {
        int range = 1000000;
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Connection connection = MysqlConn.MYSQL_CONN.getConnection();
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(insert_sql);
        long start = System.currentTimeMillis();
        for (int i = 0; i < range; i++) {
            preparedStatement.setLong(1, Long.valueOf(i + 3));
            preparedStatement.setBigDecimal(2, new BigDecimal("2323.9"));
            preparedStatement.setString(3, "pin_test");
            preparedStatement.setBigDecimal(4, new BigDecimal("1234.9"));
            preparedStatement.setTimestamp(5, now);
            preparedStatement.setString(6, "1");
            preparedStatement.setTimestamp(7, now);
            preparedStatement.setTimestamp(8, now);
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

    public static void insert_non() throws Exception {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Connection connection = MysqlConn.MYSQL_CONN.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(insert_sql);
        preparedStatement.setLong(1, 2l);
        preparedStatement.setBigDecimal(2, new BigDecimal("2323.9"));
        preparedStatement.setString(3, "pin_test");
        preparedStatement.setBigDecimal(4, new BigDecimal("1234.9"));
        preparedStatement.setTimestamp(5, now);
        preparedStatement.setString(6, "1");
        preparedStatement.setTimestamp(7, now);
        preparedStatement.setTimestamp(8, now);
        preparedStatement.execute();
        System.out.println("preparedStatement 执行成功");
    }
}
