package Userbao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class UserDAOM implements UserDAO
{
	public User login(String username,String password)
	{
		String sql="Select userid,password From User where userid=? and password=?";
		DAOBase base=new DAOBase();
		Connection connection = null;
		PreparedStatement pStatement =null;
		ResultSet rSet =null;
			
		try{
			connection = base.getConnection();
			pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, username);
            pStatement.setString(2, password);

            rSet = pStatement.executeQuery();
			if(rSet.next()){
                User u = new User();
                u.setuserid(username);
                u.setpassword(password);
                return u;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            base.release(connection,pStatement,rSet);
        }
        return null;
    }
	    //¼ì²é
    public boolean check(String username) {
        // TODO Auto-generated method stub
		String sql="Select userid,password From User where userid=? ";
		DAOBase util=new DAOBase();
		Connection connection = null;
		PreparedStatement pStatement =null;
		ResultSet rSet =null;

        try {
        	connection = util.getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, username);
            rSet = pStatement.executeQuery();

            if(rSet.next()){
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        	util.release(connection,pStatement,rSet);
        }
        return false;
    }

}