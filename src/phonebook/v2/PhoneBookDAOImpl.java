package phonebook.v2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookDAOImpl implements PhoneBookDAO {

	// 접속 코드(커넥션 확보)
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, "C##BITUSER", "bituser");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		}
		return conn;
	} // getConnection() end

	@Override
	public List<PhoneBookVO> getList() { // 전체 목록
		
		List<PhoneBookVO> list = new ArrayList<PhoneBookVO>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
		
			String sql = "SELECT id, name, hp, tel FROM phone_book" + 
							"ORDER BY id";
			rs = stmt.executeQuery(sql);
			
			// 루프: 객체화
			while (rs.next()) {
				Long id = rs.getLong(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String tel = rs.getString(4);
				
				PhoneBookVO vo = new PhoneBookVO(id, name, hp, tel);
				
				list.add(vo);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	} //getList() end
	

	@Override
	public List<PhoneBookVO> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(PhoneBookVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PhoneBookVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
