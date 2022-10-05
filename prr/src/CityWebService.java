import java.sql.SQLException;


public class CityWebService {

	public String output(int a) {
		try {
			exampledb exampledb = new exampledb();
			String result = exampledb.check();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return e.toString();	
		}		
	}

}
