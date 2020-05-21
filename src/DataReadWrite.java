import java.io.*;
import java.sql.*;
import java.util.*;

public class DataReadWrite {
	Connection con;
	
	public DataReadWrite(){
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/java_project_final","root","");
			if(con != null) {
				System.out.println("Database Connected...");
			}else {
				System.out.println("Database Connection Failed..!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	} 
	
	public boolean writeToFile(DiaryClass diaryDatas) {
		try{		
			Statement stmt=con.createStatement();  
			int rs=stmt.executeUpdate("INSERT INTO diary (title, text, dateTime) VALUES ('"+diaryDatas.getTitle()+"','"+diaryDatas.getText()+"','"+diaryDatas.getNow()+"')");  
			if(rs>0) {
				return true;
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}  
		return false;
	}
	
	public ArrayList<DiaryClass> readFromFile() {
		ArrayList<DiaryClass> diaryList = new ArrayList<DiaryClass>();
		 try {
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT * FROM diary");
			 DiaryClass u;
            while(rs.next()){
                u = new DiaryClass(rs.getString("title"), rs.getString("text"), rs.getString("dateTime"));
                
                diaryList.add(u);
            }
             
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        }
		 return diaryList;
	}
	
	public boolean userExists(String username, String password) {
		 try {
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"'");
			 if(rs.next()) {
				 return true;
			 }
             
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        }
		 return false;
	}
	
	public boolean changePassword(String username, String password) {
		try{		
			Statement stmt=con.createStatement();  
			int rs=stmt.executeUpdate("UPDATE users SET password='"+password+"' WHERE username='"+username+"'");  
			if(rs>0) {
				return true;
			}
			//con.close();
		}catch(Exception e){
			System.out.println(e);
		}  
		return false;
	}
	
	
}
