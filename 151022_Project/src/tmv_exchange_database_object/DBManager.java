package tmv_exchange_database_object;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	private static Connection connection;

	static {
		System.out.println("Initializing DB connection");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/Students", "root",
							"mysql");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		Runtime.getRuntime().addShutdownHook(new Thread() {

			@Override
			public void run() {
				System.out.println("shutting down DB connection");
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		});

	}

	// ----------------------------------------------------------------------------
	public static <T> T get(Class<T> clazz, int id) {

		String tableName = clazz.getSimpleName().toLowerCase();

		try {
			PreparedStatement st = connection.prepareStatement("select * from "
					+ tableName + " where id = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			T t = load(rs, clazz);
			return t;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------------------------------------------------------------------------
	private static <T> T load(ResultSet rs, Class<T> clazz) throws SQLException {

		rs.next();
		try {
			T t = clazz.newInstance();

			ResultSetMetaData metaData = rs.getMetaData();
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				String name = metaData.getColumnName(i);
				char[] charArray = name.toCharArray();
				charArray[0] = name.toUpperCase().charAt(0);

				String setterName = "set" + new String(charArray);
				Method setter = clazz.getMethod(setterName, String.class);
				setter.invoke(t, rs.getString(i));
			}

			return t;

		} catch (InstantiationException | IllegalAccessException
				| NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------------------------------------------------------------------------
	public static Student get(int id) {
		System.out.println("get");

		try {
			Statement st = connection.createStatement();

			ResultSet rs = st.executeQuery("select * from student where id = "
					+ id);

			Student student = getStudent(rs);

			return student;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------------------------------------------------------------------------
	private static Student getStudent(ResultSet rs) throws SQLException {
		Student st = new Student();
		if (!rs.next()) {
			return null;
		}
		st.id = rs.getString(1);
		st.name = rs.getString(2);
		st.stip = rs.getString(3);
		return st;
	}

	// ----------------------------------------------------------------------------
	public static <T> void save(Class<T> clazz, T t) {

		System.out.println("save");

		String tableName = clazz.getSimpleName().toLowerCase();
		// System.out.println(tableName);

		try {
			PreparedStatement st = connection.prepareStatement("select * from "
					+ tableName);

			ResultSet rs = st.executeQuery();

			rs.next();
			String query = "INSERT INTO " + tableName + "(";
			ResultSetMetaData metaData = rs.getMetaData();
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				if (i == metaData.getColumnCount())
					query += metaData.getColumnName(i) + ") ";
				else
					query += metaData.getColumnName(i) + ", ";
			}
			query += "VALUES(";
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				if (i == metaData.getColumnCount())
					query += "?" + ")";
				else
					query += "?" + ", ";
			}
//			System.out.println("Query:" + query);

//			Student student = (Student) t;
//			st = connection.prepareStatement(query);
//			st.setInt(1, Integer.parseInt(student.getId()));
//			st.setString(2, student.getName());
//			st.setInt(3, Integer.parseInt(student.getStip()));
//			System.out.println("Query:" + st.toString());
//			st.executeUpdate();

			saveInstance(clazz, t, query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// ----------------------------------------------------------------------------
	public static <T> void saveInstance(Class<T> clazz, T t, String query) {

		//Узнать как получить student из clazz и t !!!
		Student student = (Student) t;
		
		PreparedStatement st;
		try {
			st = connection.prepareStatement(query);
			st.setInt(1, Integer.parseInt(student.getId()));
			st.setString(2, student.getName());
			st.setInt(3, Integer.parseInt(student.getStip()));
//			System.out.println("Query:" + st.toString());
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
