package phonebook.v2;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PhoneBookApp {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		boolean run = true;
		while (run) {
			System.out.println("*************************************");
			System.out.println("*          전화번호 관리 프로그램          *");
			System.out.println("*************************************");
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.print(">메뉴번호: ");

			int menuNum = 0;
			try {
				menuNum = scanner.nextInt();
			} catch (Exception e) {
				String err = scanner.nextLine();
			}

			switch (menuNum) {
			case 1: // 리스트 목록
				printList();
				break;
			case 2: // 리스트등록
				insertPhoneBook();
				break;
			case 3: // 삭제
				deletePhoneBook();
				break;
			case 4: // 검색
				searchPhoneBook();
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
		} // while문 끝

		scanner.close();

	} // main end

	private static void printList() { // 리스트 목록 -완료!

		//		DAO 생성
		PhoneBookDAO dao = new PhoneBookDAOImpl();

		List<PhoneBookVO> list = dao.getList();
		Iterator<PhoneBookVO> it = list.iterator();

		while (it.hasNext()) {
			PhoneBookVO vo = it.next();
			System.out.printf("%d\t%s\t%s\t%s%n", 
					vo.getId(), vo.getName(),vo.getHp(),vo.getTel());
		}
		
	}// printList() end

	private static void searchPhoneBook() { // 검색 -완료!

		System.out.println("<4.검색>");
		System.out.print(">이름: ");
		String keyword = scanner.next();

		PhoneBookDAO dao = new PhoneBookDAOImpl();

		List<PhoneBookVO> list = dao.search(keyword);
		Iterator<PhoneBookVO> it = list.iterator();
	
		while (it.hasNext()) {
			PhoneBookVO vo = it.next();
			System.out.printf("%d.\t%s\t%s\t%s%n",
					vo.getId(), vo.getName(), vo.getHp(), vo.getTel());
		}
	} // search() end

	private static void insertPhoneBook() { // 리스트등록 -완료!
		System.out.println("<2.등록>");
		System.out.print(">이름: ");
		String name = scanner.next();
		System.out.print(">휴대전화:");
		String hp = scanner.next();
		System.out.print(">집전화: ");
		String tel = scanner.next();

		PhoneBookVO vo = new PhoneBookVO(name, hp, tel);
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		boolean success = dao.insert(vo);
		System.out.println((success ? "[등록되었습니다]" : "[등록에 실패했습니다]"));

	} // insertPhoneBook() end
	
	private static void deletePhoneBook() { // 삭제하기
		
		System.out.print("저자번호:");
		long id = scanner.nextLong();
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		
		boolean success = dao.delete(id);
		
		System.out.println((success ? "[삭제되었습니다]": "[삭제가 되지 않았습니다.]"));
		
	} // deletePhoneBook() end
	
	
}
