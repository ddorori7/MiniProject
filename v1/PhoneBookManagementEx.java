package v1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class PhoneBookManagementEx {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Contact> contacts = new ArrayList<>();

	public static void main(String[] args) {
		
		load(); // ContactData.txt 파일 불러오기
		
		boolean run = true;
		while (run) {
			System.out.println("*************************************");
			System.out.println("*          전화번호 관리 프로그램          *");
			System.out.println("*************************************");
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.print(">메뉴번호: ");

			int menuNum = 0;
			try {
				menuNum = sc.nextInt();
			} catch (Exception e){
				String err = sc.nextLine();
			}
			switch (menuNum) {
			case 1: // 리스트 목록
				printList(contacts);
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
		
		save(); // ContactData.txt 저장
		sc.close();
	} // main 끝

	
	
	public static void addList() { // 등록
		System.out.println("<2.등록>");
		System.out.print(">이름: ");
		String name = sc.next();
		System.out.print(">휴대전화:");
		String hp = sc.next();
		System.out.print(">집전화: ");
		String tel = sc.next();

		Contact newContact = new Contact(name, hp, tel);
		contacts.add(newContact);
		System.out.println("[등록되었습니다]");
	} // addList() end

	public static void delete() { // 삭제
		System.out.println("<3.삭제>");
		System.out.print(">번호: ");
		int num = sc.nextInt();
		contacts.remove(num - 1);
		System.out.println("[삭제되었습니다]");
	} // delete() end

	public static void search() { // 검색
		System.out.println("<4.검색>");
		System.out.print(">이름: ");
		String keyword = sc.next();
		ArrayList<Contact> result = new ArrayList<Contact>();
		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);
			if (contact.getName().contains(keyword)) {
				result.add(contact);
			} // if 끝
		} // for 끝
		printList(result);
	} // search() end

	public static void printList(ArrayList<Contact> con) {
		if (con.size() < 1) {
			System.out.println("결과가 없습니다.");
		} else {
			for (int i = 0; i < con.size(); i++) {
				Contact contact = con.get(i);
				System.out.println((i + 1) + ". " 
				+ contact.getName() 
				+ "\t" + contact.getHp() 
				+ "\t" + contact.getTel());
			}
		}
	} //printList end

	public static void load() {
		File file = new File(System.getProperty("user.dir") + "\\v1\\ContactData.txt");
		try { // 파일을 불러와서
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) { // 라인을 읽어서
				StringTokenizer st = new StringTokenizer(line, ",");
				// "," 단위로 분절해서
				Contact contact = new Contact( // 객체생성
						st.nextToken(), st.nextToken(), st.nextToken());
				contacts.add(contact); // ArrayList안에 객체 넣기
			} // while end
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // load() end
	
	public static void save() {
		try {
			FileWriter fw = new FileWriter(System.getProperty("user.dir") 
					+ "\\v1\\ContactData.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i =0; i < contacts.size(); i++) {
				Contact contact = contacts.get(i);
				
				String name = contact.getName();
				String hp = contact.getHp();
				String tel = contact.getTel();
				
				StringJoiner strJoiner = new StringJoiner(",");
				
				strJoiner.add(name);
				strJoiner.add(hp);
				strJoiner.add(tel);
				bw.write(strJoiner.toString()+"\n");
			} // for문 end
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // save() end
	
	
}
