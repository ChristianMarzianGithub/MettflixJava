package businessLogikPackageTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import businessLogikPackage.*;

class BusinessLogikTest {

	@Test
	void getFilmListeTest() throws SQLException {
		//public List<FilmModel> getFilmListe(String Suchbegriff) throws SQLException
		MainService mainServ = new MainService(EdbKind.MYSQL,"testDB","localhost","3306","root","root");
		List<FilmModel> sut = mainServ.getFilmListe("Fight CLub");
		assertTrue(sut.size() == 1);
	}
}