package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static final String url = "jdbc:oracle:thin:"+
			"@jmacias-project-1-db.chjmzdlcvbbv.us-east-2.rds.amazonaws.com" +
			":1521:ORCL";
	// jdbc: oracle:thin:@hostname:1521:ORCL
	
	public static Connection getConnectionUsingProp() throws IOException, SQLException {
		
		try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		Properties prop = new Properties();
		prop.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties"));
		return DriverManager.getConnection(url, prop);
	}
}
