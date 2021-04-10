package fiis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws SQLException {
        new Design();  
        dbConnector();
    }

    static Connection con=null;
	public static Connection dbConnector() {
		String dburl="jdbc:oracle:thin:@localhost:1521:xe";
        String username="geo";
        String password="Aurelia";
        
        try {
			con=DriverManager.getConnection(dburl, username,password);
			System.out.println("Conectat la baza de date!");
			return con;
			//con.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			
			return null;
		}
		
	}
}
