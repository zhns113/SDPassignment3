import java.sql.*;

public interface FirstAction {
    void add(Connection connection, String carBrand, int carYear, int carCost) throws SQLException;
    void delete(Connection connection, String carBrand) throws SQLException;
}
