package mysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * <br/>
 * User: eugene <br/>
 * Date&Time: 2021/5/16 21:40
 */
public class MysqlConn {
    public static final MysqlConn MYSQL_CONN = new MysqlConn();

    private String jdbc_driver = "com.mysql.jdbc.Driver";
    private String jdbc_url = "jdbc:mysql://localhost:3306/MY_DB";
    private String jdbc_user = "root";
    private String jdbc_password = "hyjstrive";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private MysqlConn() {
        try {
            Class.forName(jdbc_driver);
            connection = DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_password);
            System.out.println("连接数据库成功!");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
