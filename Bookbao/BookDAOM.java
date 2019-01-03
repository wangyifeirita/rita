package Bookbao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class BookDAOM extends DAOBase implements BookDAO {
	      
		    
		    public Book Search (String sid){
		    String sql= "SELECT * FROM Book WHERE bookname=?";
		    PreparedStatement pStatement=null;
		    Connection connection = null;
		    ResultSet rs = null;
		    DAOBase base=new DAOBase();
		    Book stu=new Book();
		    try { 
                   connection = base.getConnection();
		           pStatement=connection.prepareStatement(sql);
			       pStatement.setString(1,sid);
			       rs=pStatement.executeQuery();
			while(rs.next()){				
				stu.setbarcode(rs.getString("barcode"));
				stu.setbookname(rs.getString("bookname"));
				stu.setreponsible(rs.getString("responsible"));
				stu.setpublisher(rs.getString("publisher"));
				stu.setprice(rs.getString("price"));
				stu.setcatalog(rs.getString("catalog"));
				stu.setISBN(rs.getString("ISBN"));
				stu.setcontent(rs.getString("content"));
				stu.setCDservice(rs.getString("CDservice"));
				stu.setcarrier(rs.getString("carrier"));
				stu.setprimeresonsible(rs.getString("primeresponsible"));
				stu.setsecresonsible(rs.getString("secresonsible"));
				stu.settheme(rs.getString("theme"));
				stu.setCLclassification(rs.getString("CLclassification"));
				System.out.println(stu.getbarcode()+"     "+stu.getbookname()+" "+stu.getreponsible()+" "+stu.getpublisher()+" "+stu.getprice()+" "+stu.getcatalog()
				+" "+stu.getISBN()+" "+stu.getcontent()+" "+stu.getCDservice()+" "+stu.getcarrier()+" "+stu.getprimeresonsible()+" "+stu.getsecresonsible()+" "+stu.gettheme()+" "+stu.getCLclassification());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pStatement!=null)
				try {
					pStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}
	
}