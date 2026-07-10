import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {
    private String url = "jdbc:sqlite::memory:";

    public void insert(int id, String name) {
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement("INSERT INTO students VALUES (?, ?)")) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (Exception e) {}
    }

    public void update(int id, String name) {
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement("UPDATE students SET name = ? WHERE id = ?")) {
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        try (Connection conn = DriverManager.getConnection(dao.url)) {
            conn.createStatement().execute("CREATE TABLE students (id INT PRIMARY KEY, name VARCHAR(50))");
        } catch (Exception e) {}
        dao.insert(1, "Alice");
        dao.update(1, "Alice Smith");
    }
}