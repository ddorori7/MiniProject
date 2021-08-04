package v1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PhoneBookManagementEx {

	static Scanner sc = new Scanner(System.in);
	static Contact[] contacts = null;
	static ArrayList<Contact> con = new ArrayList<>();

	public static void main(String[] args) {

		File file = new File(System.getProperty("user.dir") + "\\v1\\ContactData.txt");
		try { // 파일을 불러와서
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) { // 라인을 읽어서
				StringTokenizer st = new StringTokenizer(line, ",");
				// "," 단위로 분절해서
				Contact contacts = new Contact( // 객체생성
						st.nextToken(), st.nextToken(), st.nextToken());
				con.add(contacts); // ArrayList안에 객체 넣기
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean run = true;

		while (run) {
			System.out.println("*************************************");
			System.out.println("*          전화번호 관리 프로그램          *");
			System.out.println("*************************************");
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.print(">메뉴번호: ");

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

		} // while문 끝
		
		// 다시 파일에 저장하기
		

	}

	public static void showList() { // 전화번호 리스트 출력
		for(int i = 0; i < con.size(); i++) {
			Contact contact = con.get(i);
			System.out.println(
					(i+1)+". "+contact.getName()+"\t"+contact.getHp()+"\t"+contact.getTel());
		}
		
	}

	public static void addList() { // 등록

		System.out.println("<2.등록>");
		System.out.print(">이름: ");
		String name = sc.next();
		System.out.print(">휴대전화:");
		String hp = sc.next();
		System.out.print(">집전화: ");
		String tel = sc.next();

		Contact newContact = new Contact(name, hp, tel);
		con.add(newContact);
		System.out.println("[등록되었습니다]");

	}

	public static void delete() { // 삭제
		System.out.println("<3.삭제>");
		System.out.print(">번호: ");
		int num = sc.nextInt();
		con.remove(num - 1);
		System.out.println("[삭제되었습니다]");
	}

	public static void search() { // 검색
		con.
	}


}
