package servletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.simple.JSONArray;

import businessLogikPackage.EdbKind;
import businessLogikPackage.FilmModel;
import businessLogikPackage.MainService;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String Suchergebnis;
	
	private String getSuchergebnis() {
		return this.Suchergebnis;
	}
	
	private void setSuchergebnis(String Suchergebnis) {
		this.Suchergebnis = Suchergebnis;
	}
	
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
    
    private JSONArray getListe(String suchbegriff) {
    	JSONArray retVal = new JSONArray();
    	MainService mainServ = new MainService(EdbKind.MYSQL,"testdb","localhost","3306","root","root");
		
		List<FilmModel> sut = mainServ.getFilmListe(suchbegriff);
		
		JSONObject jObject;
		for(int i = 0; i < sut.size(); i++) {		
			jObject = new JSONObject();
			jObject.put(	"bezeichnung",sut.get(i).getBezeichnung());
			jObject.put(	"id",sut.get(i).getId());			
			retVal.add(jObject);
		}    	
    	return retVal;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		/*
		response.getWriter().append("<html>");
		response.getWriter().append("<head>");
		response.getWriter().append("</head>");
		response.getWriter().append("<body>");
		
		//response.getWriter().append( );
		
		
		response.getWriter().append("Suchergebnisse: <br>");
		String s = getListe("Fight Club");
		response.getWriter().append(s);
		response.getWriter().append("<body>");
		response.getWriter().append("</html>");
		*/
		/*
		// Ausgabe als HTML-Seite
        
		response.setContentType("text/html;charset=UTF-8");
         
        // Ausgabe durchführen
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("    </head>");
        out.println();
        out.println("    <body style=\"line-height: 1.5em;\">");
        out.println(System.getProperty("user.dir"));        
        out.println("        <form method=\"post\">");
        out.println("            <b>Suche:</b><br />");
        out.println("            <input type=\"text\" name=\"suchbegriff\" /><br />");        
        out.println("            <input type=\"submit\" value=\"Absenden\" />");
        out.println("        </form>");
        out.println("    </body>");
        out.println("</html>");
        out.close();
        */
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
        
        // Ausgabe als HTML-Seite
        response.setContentType("text/html;charset=UTF-8");
         
        // Ausgabe durchführen
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>Formulardaten - Java EE Servlet Code-Beispiel</title>");
        out.println();
        out.println("        <meta charset=\"utf-8\" />");
        out.println();
        out.println("        <meta name=\"robots\" content=\"noindex,nofollow\" />");
        out.println("        <meta name=\"publisher\" content=\"Homepage-Webhilfe\" />");
        out.println("    </head>");
        out.println();
        out.println("    <body style=\"line-height: 1.5em;\">");
        out.println("        <b>Ergebnisse zu : '" + request.getParameter("suchbegriff") + "'</b><br />");
        String s = getListe(request.getParameter("suchbegriff"));
        out.println(s);
        
        
        out.println("    </body>");
        out.println("</html>");
        out.close();
        */
		JSONArray asdf = getListe(request.getParameter("suchbegriff"));
		
		response.getWriter().print(asdf);
	}
}
