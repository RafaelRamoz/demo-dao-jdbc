import db.DB;
import java.sql.Connection;

public class App {
    public static void main(String[] args) throws Exception {
        
        Connection conn = DB.getConnection();

        System.out.println(conn);
    }
}
