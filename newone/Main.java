import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/sdp";
    private static final String USER = "postgres";
    private static final String PASS = "1987";

    private static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            String sql = "SELECT * FROM car";
            Scanner scanner = new Scanner(System.in);
            Connection connection = connect();
            SecondAction action = new SecondAction();
            System.out.println(" [1] add" + "\n [2] delete" + "\n [3] show" + "\n [4] to exit");
            int choice = scanner.nextInt();
            if (choice == 1){
                System.out.print("Enter car brand: ");
                String carBrand = scanner.next();
                System.out.print("Enter car year: ");
                int carYear = scanner.nextInt();
                System.out.print("Enter car cost: ");
                int carCost = scanner.nextInt();
                action.add(connection, carBrand, carYear, carCost);
            } else if (choice == 2) {
                System.out.print("Enter car brand to delete: ");
                String carBrand = scanner.next();
                action.delete(connection, carBrand);
            } else if (choice == 3) {
                action.showAllCars(connection);
            } else if (choice == 4) {
                System.exit(1);
            }
        }
    }
}