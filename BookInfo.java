package jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookInfo {
	public void BookinfoRegist(String s, int n) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.107:1521/xe","system","1234");
			
			String sql = "" + "INSERT INTO bookinfo (bookid,bookno,userid)" + "VALUES (?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s);
			pstmt.setInt(2, n);
			pstmt.setString(3, "def");
			
			int row = pstmt.executeUpdate();
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
