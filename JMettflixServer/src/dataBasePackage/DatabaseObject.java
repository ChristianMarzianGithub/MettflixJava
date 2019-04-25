package dataBasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import businessLogikPackage.*;

public class DatabaseObject {
    
    private String dataBase;
    private String usr;
    private String pw;    
    private String port;
    private String host;
    private EdbKind dbKind;
    
    public EdbKind getDBkind(){
        return this.dbKind;
    }
    
    public void setDBkind(EdbKind dbKind){
        this.dbKind = dbKind;
    }
    
    public String getHost(){
        return this.host;
    }
    
    public void setHost(String host){
        this.host = host;
    }
        
    public String getPort(){
        return this.port;
    }
    
    public void setPort(String port){
        this.port = port;
    }
    
    public String getPW(){
        return pw;
    }
    
    public void setPW(String pw){
        this.pw = pw;
    }
    
    
    public String getUsr(){
        return this.usr;
    };
    
    public void setUsr(String usr){
        this.usr = usr;
    };
    
    
    public String getDataBase(){
        return this.dataBase;
    }
    public void setDataBase(String dataBase){
        this.dataBase = dataBase;
    }
    
    public Connection getCon(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:" + this.dbKind.toString() + "://" + this.host + ":" + this.port +"/" + this.dataBase + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",this.usr,this.pw);
            
        } catch (SQLException ex) {
            //Logger.getLogger(DatabaseObject.class.getName()).log(Level.SEVERE, null, ex);
        	System.out.println(ex.getMessage());
        }
        return con;
    }
    
    public Statement getStatement(Connection con){
        Statement stmt = null; 
        try{
            stmt = con.createStatement();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return stmt;     
    }
    
    public ResultSet getResultSetFromQuery(String query){
        Statement stmt;
        ResultSet rs = null;
        try {			
                Connection con = getCon();
                stmt = getStatement(con);
                rs=stmt.executeQuery(query);                
                /*
                while(rs.next()){
                    System.out.println(rs.getInt(1));
                }   
                */                       
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }  
        return rs;
    }

	public int login(String usr, String pw) {
		int retVal = 0;
		ResultSet ResultSetLogin = getResultSetFromQuery("SELECT USR, PW FROM LOGIN WHERE USR ='" 
		+ usr 
		+ "' AND PW ='" 
		+ pw 
		+ "'" );
		
		try {
			ResultSetLogin.next();
			if(ResultSetLogin.getString(1).contentEquals(usr) && ResultSetLogin.getString(2).contentEquals(pw)) {
				retVal = 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return retVal;
	}
}