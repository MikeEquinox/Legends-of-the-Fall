package tmv_family;

/**
 * @author teleginmv
 * package prints family data from database Family
 * you need to input family data from console:
 * Enter NAME <space> YEAR OF BIRTH <space> HEIGHT <space> WEIGHT <ENTER>
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.mysql.jdbc.PreparedStatement;

public class Family {

	private static final int relative = 10;
	final static String DB_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_CONNECTION = "jdbc:mysql://localhost/family";
	final static String DB_USER = "root";
	final static String DB_PASSWORD = "mysql";

	public static void main(String[] args) {

		String query;
		Connection connection = null;
		String line;
		String[] lineSplitted;
		//String[] name = { "Olly", "Polly", "Kent" };
		//Integer[] year = { 2009, 1982, 1980 };
		//Integer[] height = { 112, 156, 167 };
		//Integer[] weight = { 17, 62, 73 };
		String[] name = new String[relative]; 
		Integer[] year = new Integer[relative]; 
		Integer[] height = new Integer[relative]; 
		Integer[] weight = new Integer[relative]; 
		int counterS = 0; //number of input strings

		System.out.println("Starting...");
		System.out
				.println("Enter NAME <space> YEAR OF BIRTH <space> HEIGHT <space> WEIGHT <ENTER>");
		System.out.println("Type \"quit\" + <ENTER> to exit.");
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if(line.compareTo("quit") == 0) break;
			Pattern pattern = Pattern.compile(" ");
			int i = 0;
			lineSplitted = pattern.split(line);
			name[counterS] = lineSplitted[i];
			try {
			year[counterS] = Integer.valueOf(lineSplitted[i+1]);
			height[counterS] = Integer.valueOf(lineSplitted[i+2]);
			weight[counterS] = Integer.valueOf(lineSplitted[i+3]);
			counterS++;
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			System.err.println("Incorrect input: Enter NAME <space> YEAR OF BIRTH <space> HEIGHT <space> WEIGHT <ENTER>");
			}
		}

		try {
			connection = getDBConnection();
//			System.out.println(connection.getClass().getCanonicalName());
			Statement statement = connection.createStatement(); // create
			
			query = "CREATE TABLE Family(FirstName varchar(255) not NULL PRIMARY KEY,"
					+ " Year INTEGER not NULL, Height INTEGER not NULL, Weight INTEGER not NULL)";
			try {
				statement.executeUpdate(query);
				System.out.println("Table created.");
			} catch (SQLException e) {
				System.err.println("Table already exists.");
			}

			// PreparedStatement preparedStatement = null;
			query = "INSERT INTO Family(FirstName, Year, Height, Weight) VALUES(?, ?, ?, ?)";
			PreparedStatement preparedStatement = (PreparedStatement) connection
					.prepareStatement(query);

			for (int counter = 0; counter < counterS; counter++) {
				try {
					preparedStatement.setString(1, name[counter]);
					preparedStatement.setInt(2, year[counter]);
					preparedStatement.setInt(3, height[counter]);
					preparedStatement.setInt(4, weight[counter]);
				} catch (SQLException e) {
					System.err.println("Table already fulfilled.");
				}

				preparedStatement.executeUpdate();
			}

			queryAndPrint(statement, "SELECT * FROM Family");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close(); // close connection
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		System.out.println("Finished.");

	}

	private static void queryAndPrint(Statement statement, String query) {
		try {
			ResultSet rs = statement.executeQuery(query);
			print(rs);
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void print(ResultSet rs) throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		int columns = metaData.getColumnCount();

		System.out.println("My family:");
		while (rs.next()) { // / process result
			for (int i = 1; i <= columns; i++) {
				System.out.print(rs.getString(i) + " ");
			}
			System.out.println();
		}
	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

}
