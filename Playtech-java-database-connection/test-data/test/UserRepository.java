import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository {
    private static final Statement DatabaseConnection = null;

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Loome SQL-päringu
            String sql = "SELECT * FROM Users";

            // Loome PreparedStatement objekti
            PreparedStatement statement = connection.prepareStatement(sql);

            // Täidame päringu ja saame tulemused
            ResultSet resultSet = statement.executeQuery();

            // Käime läbi tulemused
            while (resultSet.next()) {
                // Võtame väljade väärtused
                String userId = resultSet.getString("USER_ID");
                String username = resultSet.getString("USERNAME");
                double balance = resultSet.getDouble("BALANCE");
                String country = resultSet.getString("COUNTRY");
                int frozen = resultSet.getInt("FROZEN");
                double depositMin = resultSet.getDouble("DEPOSIT_MIN");
                double depositMax = resultSet.getDouble("DEPOSIT_MAX");
                double withdrawMin = resultSet.getDouble("WITHDRAW_MIN");
                double withdrawMax = resultSet.getDouble("WITHDRAW_MAX");

                // Prindime välja võetud andmed
                System.out.println(userId + ", " + username + ", " + balance + ", " + country + ", " +
                                   frozen + ", " + depositMin + ", " + depositMax + ", " + withdrawMin +
                                   ", " + withdrawMax);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
