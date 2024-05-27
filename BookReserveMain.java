package jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookReserveMain {
	public static void main(String[] args) {
		while(true) {
			
			System.out.println("원하시는 메뉴를 입력해 주세요.");
			System.out.println("1.책 등록");
			System.out.println("2.회원 등록");
			System.out.println("3.책 예약");
			System.out.println("3.책 반납");
			System.out.println("4.종료");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			
			if(n==4) {
				System.out.println("종료");
				break;
			}	
			switch(n){
			case 1:
				System.out.println("책 이름 : ");
				Scanner bookName1 = new Scanner(System.in);
				String bn1 = bookName1.nextLine();
				System.out.println("책 Serial No : ");
				int no = bookName1.nextInt();
			
     			BookInfo book = new BookInfo();
				book.BookinfoRegist(bn1,no);
				break;
			case 2:
				
				break;
			case 3:
				System.out.println("예약할 책 이름 : ");
				Scanner bookName2 = new Scanner(System.in);
				String bn2 = bookName2.nextLine();
				System.out.println("예약자명: ");
				String ui = bookName2.nextLine();
				ReserveInfo ri = new ReserveInfo();
				ri.BookReserveInfo(bn2,ui);
				break;
			default:
				break;
			}
			
		}
		
	}
}
