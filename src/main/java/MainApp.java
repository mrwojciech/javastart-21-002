import java.sql.*;

public class MainApp {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://cilnx10.ectsp.thlab.s3:5432/user_registry?characterEncoding=utf8&currentSchema=user_registry";
        String username = "user_registry";
        String password = "12qw";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM user_registry.tenants;";
        //String query = "SELECT * FROM user_registry.user_tenants";
        ResultSet resultSet = statement.executeQuery(query);
        int n = 1;
        while (resultSet.next()) {
            String col;
            for (int i = 1; i <= 15; i++) {
                col = resultSet.getString(i);
                System.out.print(col + " ");
            }
            System.out.println();
        }
        connection.close();
    }
}