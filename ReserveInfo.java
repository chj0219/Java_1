package jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ReserveInfo {
	public void BookReserveInfo(String s, String n) {
		Connection conn = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.107:1521/xe","system","1234");
			
			String sql = "select * from BOOKINFO WHERE BOOKID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				sql = "" + "INSERT INTO RESERVEINFO (USERID,BOOKID,RESERVE_DTTM,RETURN_DTTM)" + "VALUES (?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,n);
				pstmt.setString(2,s);
				pstmt.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
				pstmt.setDate(4,java.sql.Date.valueOf(java.time.LocalDate.now().plusDays(7)));
			
			}
			
			int row = pstmt.executeUpdate();
			
				if(row==1)
					System.out.println("예약되었습니다.");
				else
					System.out.println("예약에 실패했습니다.");
			
	
			
			pstmt.close();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			 if (rs != null) {
	                try {
	                    rs.close();
	                } catch (SQLException e) {
	                	
	                    e.printStackTrace();
	                }
	            }
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {}
			}
		}
	}
}
