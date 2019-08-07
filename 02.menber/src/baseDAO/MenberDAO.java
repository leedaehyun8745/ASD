package baseDAO;

import java.util.List;

import model.Menber;

public interface MenberDAO {
	
	List<Menber> selectAll();
	Menber selectByno(int no);
	Menber selectByid(String id);
	
	boolean insert(Menber menber);
	boolean update(Menber menber);
	boolean delete(int no);
}
