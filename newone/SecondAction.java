import java.sql.*;

public class SecondAction implements FirstAction{
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/sdp";
    private static final String USER = "postgres";
    private static final String PASS = "1987";

    public void add(Connection connection, String carBrand, int carYear, int carCost) throws SQLException {
        String sql = "INSERT INTO car (carbrand, caryear, carcost) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, carBrand);
            pstmt.setInt(2, carYear);
            pstmt.setInt(3, carCost);
            pstmt.executeUpdate();
        }
    }

    public void delete(Connection connection, String carBrand) throws SQLException {
        String sql = "DELETE FROM car WHERE carbrand = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, carBrand);
            pstmt.executeUpdate();
        }
    }

    public void showAllCars(Connection connection) throws SQLException {
        String sql = "SELECT * FROM car";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("1) " + rs.getString(1) + ", " + rs.getInt(2) + ", " + rs.getInt(3));
            }
        }
    }
}
