package dataBaseTestPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import businessLogikPackage.EdbKind;
import dataBasePackage.*;


public class DataBaseObjectMySQLTest {
	EdbKind dbKind = EdbKind.MYSQL;
    @Test
    public void TestgetResultSetFromQuery() throws SQLException{
		DatabaseObject x = new DatabaseObject();
                x.setDataBase("testdb");
                x.setUsr("root");
                x.setPW("root");
                x.setPort("3306");
                x.setHost("127.0.0.1");
                x.setDBkind(dbKind);                
                ResultSet retVal = x.getResultSetFromQuery("SELECT * FROM TESTTABLE");                
                retVal.next();
                assertTrue(retVal.getInt(1) == 23);
                retVal.close();
    }
        
    @Test
    public void TestSetDataBase(){
        String dataBase = "testDB";
        DatabaseObject x = new DatabaseObject();
                x.setDataBase(dataBase);
                assertTrue(x.getDataBase() == dataBase);
    }
    
    @Test
    public void TestSetUsr(){
        String usr = "root";
        DatabaseObject x = new DatabaseObject();
                x.setUsr(usr);
                assertTrue(x.getUsr() == usr);
    }
    
    @Test
    public void TestSetPW(){
        String pw = "root";
        DatabaseObject x = new DatabaseObject();
                x.setPW(pw);
                assertTrue(x.getPW() == pw);
    }
    
    @Test
    public void TestSetPort(){
        String port = "3306";
        DatabaseObject x = new DatabaseObject();
                x.setPort(port);
                assertTrue(x.getPort() == port);
    }
    
    @Test
    public void TestSetHost(){
        String host = "localhost";
        DatabaseObject x = new DatabaseObject();
                x.setHost(host);
                assertTrue(x.getHost() == host);
    }
    
    @Test
    public void TestSetDBKind(){
        DatabaseObject x = new DatabaseObject();
        x.setDBkind(dbKind);
        assertTrue(x.getDBkind() == dbKind);
    }
    
    @Test
    public void TestGetCon_ReturnNull(){
        DatabaseObject x = new DatabaseObject();
                x.setDataBase("testDB");
                x.setUsr("root");
                x.setPW("root");
                x.setPort("3305");
                x.setHost("localhost");
                x.setDBkind(dbKind);
        assertTrue(x.getCon() == null);   
    }
    
    @Test
    public void TestGetCon_ReturnValidConnection(){
        DatabaseObject x = new DatabaseObject();
                x.setDataBase("testDB");
                x.setUsr("root");
                x.setPW("root");
                x.setPort("3306");
                x.setHost("localhost");
                x.setDBkind(dbKind);
        assertTrue(x.getCon() != null);   
    }
    
    @Test
    public void TestGetStatement_ReturnStatement(){
        DatabaseObject x = new DatabaseObject();
                x.setDataBase("testDB");
                x.setUsr("root");
                x.setPW("root");
                x.setPort("3306");
                x.setHost("localhost");
                x.setDBkind(dbKind);
        assertTrue(x.getStatement(x.getCon()) != null);   
    }
    
    @Test
    public void TestLogin() throws SQLException {
    	DatabaseObject x = new DatabaseObject();
        x.setDataBase("testDB");
        x.setUsr("root");
        x.setPW("root");
        x.setPort("3306");
        x.setHost("localhost");
        x.setDBkind(dbKind);
        String usr = "peter";
        String pw = "geheim01";        
        
        assertTrue(x.login(usr, pw) == 1);
    }
}