package tryer.persistence.jdbc;

import java.sql.*;
import java.util.concurrent.TimeUnit;

import static java.sql.Connection.TRANSACTION_REPEATABLE_READ;

/**
 * Imported MySQL connector: mysql-connector-java , which has a driver: com.mysql.cj.jdbc.Driver
 */
public class JdbcRunner {

    /**
     * Properties to establish connection
     */
    private final String URL = "jdbc:mysql://localhost:3306/flip";
    private final String USER = "root";
    private final String PASSWORD = "root";

    public void runQuery() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            st.executeUpdate("INSERT INTO `books` (`title`, `author`, `pages_read`) VALUES ('Hibernate', 'hz', 20)");
            ResultSet allBooks = st.executeQuery("SELECT * FROM books");

            int count = 0;
            while (allBooks.next()) {
                allBooks.updateInt(4, 20 + count);
                allBooks.updateRow();
                count++;
            }

            System.out.println("Total number of books:" + count);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void transactionExample() {

        try (Connection c1 = DriverManager.getConnection(URL, USER, PASSWORD)) {

            c1.setTransactionIsolation(TRANSACTION_REPEATABLE_READ);
            c1.setAutoCommit(false);
            Statement s1 = c1.createStatement();
            s1.executeUpdate("INSERT INTO `books` (`id`, `title`, `author`, `pages_read`) VALUES ('105', 'Transactions', 'hz', 0)");

            c1.commit();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private Runnable write1() {
        return ()->{
            System.out.println("write1() started");
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                System.out.println("First connection created");

                conn.setTransactionIsolation(TRANSACTION_REPEATABLE_READ);
                conn.setAutoCommit(false);
                System.out.println("Transaction started");

                Statement statement = conn.createStatement();
                statement.executeUpdate("INSERT INTO `books` (`id`, `title`, `author`, `pages_read`) VALUES ('107', 'write1', 'hz', 0)");
                System.out.println("First write occurred");

                System.out.println("write1 waits");
                TimeUnit.SECONDS.sleep(30);

                conn.commit();
                System.out.println("Transaction committed");

            } catch (SQLException | InterruptedException ex) {
                ex.printStackTrace();
            }
        };
    }

    private Runnable write2() {
        return () -> {
            System.out.println("write2() started");
            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
                Statement statement = con.createStatement();
                System.out.println("Second connection created");

                statement.executeQuery("SELECT * FROM books WHERE id=108");
                System.out.println("First write occurred");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        };
    }


    //second write gets blocked until the first transaction is committed
    public void dirtyReadExample() throws InterruptedException {
        new Thread(write1()).start();
        TimeUnit.SECONDS.sleep(5);
        new Thread(write2()).start();
    }

    public static void main(String[] args) throws SQLException, InterruptedException {

        JdbcRunner example = new JdbcRunner();

    }

}
