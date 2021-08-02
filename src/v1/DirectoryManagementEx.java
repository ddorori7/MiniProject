package v1;

import java.io.Writer;
import java.util.Scanner;



public class DirectoryManagementEx {
	static String filePath = "directoryData.txt";
	static Scanner sc = new Scanner(System.in);
	static Writer fileWriter = null;
	
	
	public static void main(String[] args) {
		
		
		
		
		boolean run = true;
		
		while(run) {
			System.out.println("*************************************");
			System.out.println("*          전화번호 관리 프로그램          *");
			System.out.println("*************************************");
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.print(">메뉴번호: " );
			
			int menuNum = sc.nextInt();
			switch (menuNum) {
			case 1: // 리스트 목록
				showList();
				break;
			case 2: // 등록
				addList();
				break;
			case 3: // 삭제
				delete();
				break;
			case 4: // 검색
				search();
				break;
			case 5: // 종료
				System.out.println("*************************************");
				System.out.println("*          감사합니다          *");
				System.out.println("*************************************");
				run = false;
				break;
			default:
				System.out.println("[다시입력해주세요]");
				break;
			} // switch문 끝
			
			
			
			
		}// while문 끝
		
		
		
		
	}
	
	public static void showList() { // 전화번호 리스트 출력
		
		
	}
	
	public static void addList() { // 등록
		
	
		
		
		
	}
	
	public static void delete() { // 삭제
		
	}
	
	public static void search() { // 검색
		
	}

}
