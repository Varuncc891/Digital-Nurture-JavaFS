import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasicJDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:sqlite::memory:";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE students (id INT PRIMARY KEY, name VARCHAR(50))");
            stmt.execute("INSERT INTO students VALUES (1, 'Alice')");
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("name"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}