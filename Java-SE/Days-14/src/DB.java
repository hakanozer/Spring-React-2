import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:8889/java_se";
    private final String username = "root";
    private final String password = "root";

    private Connection conn = null;

    public Connection connect() {
        try {
            if ( conn != null || conn.isClosed() )
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connecton Success");
        }catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        return conn;
    }

}
