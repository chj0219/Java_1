package jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfo {
	public void BookReserveInfo(String s, int n) {
		Connection conn = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.107:1521/xe","system","1234");
			
			String sql = "select * from BOOKINFO WHERE BOOKNAME = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s);
			rs = pstmt.executeQuery();
			if(rs != null) {
				sql = "" + "INSERT INTO RESERVEINFO (USERID,BOOKNAME,)" + "VALUES (?,?,?,?)";
				pstmt.setString(1,);
				pstmt.setString(2,);
				pstmt.setDate(3,);
				pstmt.setDate(4,);
			}
			else {
				System.out.println("책이 없습니다.");
			}
			
			
			
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
