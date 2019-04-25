package servletPackage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogikPackage.*;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private String getListe(String suchbegriff) {
    	String retVal = "";
    	MainService mainServ = new MainService(EdbKind.MYSQL,"testdb","localhost","3306","root","root");
		
		List<FilmModel> sut = mainServ.getFilmListe("Fight CLub");
		
		for(int i = 0; i < sut.size(); i++) {				
			retVal = sut.get(i).getBezeichnung();
		}    	
    	return retVal;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served 08452 at: ").append(request.getContextPath());
		response.getWriter().append("<b>hallo</b>World");
		String s = getListe("Fight CLub");
		response.getWriter().append(s);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
