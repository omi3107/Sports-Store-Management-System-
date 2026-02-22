package sports.store.management.system;
import java.sql.*;
import sports.store.management.system.Conn;
public class Conn {
    Connection c;
    Statement s;
    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///gearupsportsstore", "root", "Omkar$3107");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
