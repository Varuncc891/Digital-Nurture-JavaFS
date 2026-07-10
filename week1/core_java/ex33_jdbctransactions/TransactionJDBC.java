import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionJDBC {
    public static void main(String[] args) {
        String url = "jdbc:sqlite::memory:";
        try (Connection conn = DriverManager.getConnection(url)) {
            conn.createStatement().execute("CREATE TABLE accounts (id INT PRIMARY KEY, balance DOUBLE)");
            conn.createStatement().execute("INSERT INTO accounts VALUES (1, 1000.0)");
            conn.createStatement().execute("INSERT INTO accounts VALUES (2, 500.0)");

            conn.setAutoCommit(false);
            try (PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
                 PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?")) {
                
                debit.setDouble(1, 200.0);
                debit.setInt(2, 1);
                debit.executeUpdate();

                credit.setDouble(1, 200.0);
                credit.setInt(2, 2);
                credit.executeUpdate();

                conn.commit();
                System.out.println("Transaction committed");
            } catch (Exception ex) {
                conn.rollback();
                System.out.println("Transaction rolled back");
            }
        } catch (Exception e) {}
    }
}