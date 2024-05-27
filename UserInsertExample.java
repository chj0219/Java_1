package jdbc_test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UserInsertExample {
	
public static void main(String[] args) {
	Connection conn = null;
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.107:1521/xe","system","1234");
		
		String sql = "" + "INSERT INTO users (userid,username,userpassword,userage,usermail)" + "VALUES (?,?,?,?,?)";
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "KKK");
		pstmt.setString(2, "김강운");
		pstmt.setString(3, "12399");
		pstmt.setInt(4, 8);
		pstmt.setString(5, "kkk@mycompany.com");
		
		pstmt.close();
		
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {}
		}
	}
	
	}
}
