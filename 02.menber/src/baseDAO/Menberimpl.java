package baseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import model.Menber;

public class Menberimpl extends BaseDAO implements MenberDAO{

	private static final String INSERT_SELECT_INTO_SQL="insert into menber values(seq_menber.nextval ,?,?,?,?,?)";
	private static final String SELECT_ALL_SQL = "SELECT * FROM MENBER";
	private static final String SELECT_BY_NO_SQL = "select * from menber where no = ?";
	private static final String UPDATE_SELCET_SQL= "update menber set id = ? ,password = ? , name = ? , gender = ? ,birth =? where no = ?";
	@Override
	public boolean insert(Menber menber) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		try {
			connection = getConnection();
			
			preparedStatement = connection.prepareStatement(INSERT_SELECT_INTO_SQL);
			preparedStatement.setString(1, menber.getId());
			preparedStatement.setString(2, menber.getPassword());
			preparedStatement.setString(3, menber.getName());
			preparedStatement.setString(4, menber.getGender());
			preparedStatement.setString(5, menber.getBirth());
			
			int rowCount = preparedStatement.executeUpdate();
			if (rowCount >0) {
				result = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return result;
	}
	@Override
	public List<Menber> selectAll() {
		List<Menber> menbers = new ArrayList<Menber>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet= null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SELECT_ALL_SQL);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Menber menber = new Menber();
				
				menber.setNo(resultSet.getInt("no"));
				menber.setId(resultSet.getString("id"));
				menber.setPassword(resultSet.getString("password"));
				menber.setName(resultSet.getString("name"));
				menber.setGender(resultSet.getString("gender"));
				menber.setBirth(resultSet.getString("birth"));
				
				menbers.add(menber);
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menbers;
	}
	@Override
	public Menber selectByno(int no) {
		Menber menber = new Menber();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SELECT_BY_NO_SQL);
			preparedStatement.setInt(1, no);
			resultSet = preparedStatement.executeQuery();  
			
			while (resultSet.next()) {
				menber.setNo(resultSet.getInt("no"));
				menber.setId(resultSet.getString("id"));
				menber.setPassword(resultSet.getString("password"));
				menber.setName(resultSet.getString("name"));
				menber.setGender(resultSet.getString("gender"));
				menber.setBirth(resultSet.getString("birth"));	
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return menber;
	}
	@Override
	public boolean update(Menber menber) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = getConnection();
			
			preparedStatement = connection.prepareStatement(UPDATE_SELCET_SQL);
			preparedStatement.setString(1, menber.getId());
			preparedStatement.setString(2, menber.getPassword());
			preparedStatement.setString(3, menber.getPassword());
			preparedStatement.setString(4, menber.getGender());
			preparedStatement.setString(5, menber.getBirth());
			preparedStatement.setInt(6,menber.getNo());
			
			int rowCount = preparedStatement.executeUpdate();
			if (rowCount>0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return result;
	}
	@Override
	public boolean delete(int no) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Menber selectByid(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
