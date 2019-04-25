package businessLogikPackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dataBasePackage.*;

public class MainService {	
	private DatabaseObject bo;
	
	public MainService(EdbKind dbKind, String dataBase, String host, String port, String pw, String usr) {
		bo = new DatabaseObject();		
		bo.setDBkind(dbKind);
		bo.setDataBase(dataBase);
		bo.setHost(host);
		bo.setPort(port);
		bo.setPW(pw);
		bo.setUsr(usr);		
	}
	
	public int Login(String usr, String pw) {
		int retVal = 0;
		LoginService login = new LoginService(usr,pw);
		return retVal;
	}
		
	public List<FilmModel> getFilmListe(String Suchbegriff) {		
		
		String query = "SELECT BEZEICHNUNG,ID FROM FILM WHERE BEZEICHNUNG LIKE '%" + Suchbegriff + "%'";
		
		List<FilmModel> retListe = new ArrayList<FilmModel>();
		
		ResultSet ResultSetFilmSuchListe = bo.getResultSetFromQuery(query);
		
		try {
			while(ResultSetFilmSuchListe.next()) {
				retListe.add(new FilmModel(ResultSetFilmSuchListe.getString(1),ResultSetFilmSuchListe.getInt(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retListe;
	}
}