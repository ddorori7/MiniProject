package v1;




import java.util.Scanner;



public class PhoneBookManagementEx {
	
	static Scanner sc = new Scanner(System.in);

	
	
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
		Contact[] phoneBooks = load();
		// 삭제
		save(phoneBooks);
	}
	
	public static void search() { // 검색
		
		
	}
	
	public static Contact[] load() {
		return null; //파일에서 읽어옴
		
	}
	
	public static void save(Contact[] contacts) { // 파일에 다시 저장함

	}	
}
