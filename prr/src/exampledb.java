
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import org.sqlite.JDBC;

public class exampledb {

	private static String url1 = "jdbc:sqlite:D:/Downloads/DB.Browser.for.SQLite-3.12.2-win64/bd.db";
	private static exampledb instance = null;

	public static synchronized exampledb getInstance() throws SQLException {
		if (instance == null)
			instance = new exampledb();
		return instance;
	}

	private Connection connection;

	exampledb() throws SQLException {
		DriverManager.registerDriver(new JDBC());
		this.connection = DriverManager.getConnection(url1);
	}

	public String check() {
		try {
			Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(url1)) {
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM city");
				
				//List cityList = new LinkedList();
				String data="";
				while (resultSet.next()) {
					city city = new city();
					int id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					String numberPeople = resultSet.getString(3);
					data = data+id+" "+name+" "+numberPeople+"\n";
					//System.out.println(id+" "+name+" "+numberPeople);
					/*city.setID(resultSet.getInt(1));
					city.setName(resultSet.getString(2));
					city.setnumberPeople(resultSet.getString(3));
					cityList.add(city);*/
				}
				conn.close();
				return data;
			}

		} catch (Exception ex) {
			return ex.toString();
		}
		
	}

}
