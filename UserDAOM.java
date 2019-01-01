package ͼ���ѯϵͳ;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ͼ���ѯϵͳ.User;
public class UserDAOM extends DAOBase implements UserDAO {
			@SuppressWarnings("resource")
			public static void Input(User stu) throws IOException{
				Scanner ReadStr=new Scanner(System.in);
				System.out.println("������һ�����ߵ���Ϣ��");
		 		System.out.println("�û�����");			 
				stu.setuserid(ReadStr.nextLine());
		 		System.out.println("���룺");
		 		stu.setpassword(ReadStr.nextLine());
			}
			private static final String CREATE_USER_SQL ="INSERT INTO USER values(?,?,?,?,?,?)";
			@Override
			public void insertUser(User stu) {//ʵ�ֲ��뷽��������
				Connection connection = null;
				PreparedStatement pst = null;
				try{
					connection = getConnection();//�������ݿ�
					Input(stu);//����ѧ����Ϣ
					pst = connection.prepareStatement(CREATE_USER_SQL);
					pst.setString(1, stu.getuserid());
					pst.setString(2, stu.getpassword());
					int row=pst.executeUpdate();
					System.out.println("�ɹ�������"+row+"������!");
					pst.close();
					connection.close();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(pst!=null)
						try {
							pst.close();
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
			}
			@Override
			public void updateUser(User stu) {//ʵ�ָ��£��ģ�����
				//��ɾ�����ٲ��룻Ҳ���������е�update [table] set ��=ֵ������
				// TODO Auto-generated method stub
				try{
					Connection connection = null;
					Statement stmt = null;
					int rs;
					try {
						connection = getConnection();//�������ݿ�
						Scanner ReadStr=new Scanner(System.in);
						System.out.println("������Ҫ�����û�����");	 
						stmt = connection.createStatement();
						String sql = "delete from Student where userid=";
						rs= stmt.executeUpdate(sql+ReadStr.nextLine());
						insertUser(stu);
						stmt.close();		
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						if(stmt!=null)
							try {
								stmt.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				}catch(Exception e){
					e.printStackTrace();
				}			
			}
			@Override
			public void deleteUser(String sid) {//ʵ��ɾ������
				// TODO Auto-generated method stub
				Connection connection = null;
				Statement stmt = null;
				int rs ;
				try {
					connection = getConnection();//�������ݿ�
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("������Ҫɾ�����û�����");		 
			 		sid=ReadStr.nextLine();
					stmt = connection.createStatement();
					String sql = "delete from User where userid=";
					rs = stmt.executeUpdate(sql+Integer.parseInt(sid));//���ؽ��
					System.out.println("�ɹ�ɾ����"+rs+"������!");
					stmt.close();		
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(stmt!=null)
						try {
							stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
			private static final String SEARCH_USERC1 = "SELECT userid,password FROM User WHERE userid=";
			@Override
			public User getUser(String sid) {
				// TODO Auto-generated method stub
				Connection connection = null;
				Statement stmt = null;
				ResultSet rs = null;
				User stu = new User();
				try{
					connection = getConnection();
					stmt = connection.createStatement();			
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("������Ҫ��ѯ���û�����");		 
					sid=ReadStr.nextLine();
					String endsql = null;
					endsql = SEARCH_USERC1 +Integer.parseInt(sid);
					rs=stmt.executeQuery(endsql);
					while(rs.next()){				
						stu.setuserid(rs.getString("userid"));
						stu.setpassword(rs.getString("password"));
						System.out.println(stu.getuserid()+"     "+stu.getpassword());
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
					if(stmt!=null)
						try {
							stmt.close();
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
			private static final String SEARCH_USERC = "SELECT userid,password FROM User";
			@Override
			public List<User> getUserByC(String sql) {
				List<User> users = new ArrayList<User>();
				Connection connection = null;
				Statement stmt = null;
				ResultSet rs = null;
				try{
					connection = getConnection();
					stmt = connection.createStatement();
					String endsql = null;
					if(sql.equals("")){
						endsql = SEARCH_USERC;
					}else{
						endsql = SEARCH_USERC + " WHERE "+sql;
					}
					rs=stmt.executeQuery(endsql);
					while(rs.next()){
						User user = new User();
						user.setuserid(rs.getString("userid"));
						user.setpassword(rs.getString("password"));
						users.add(user);			
					}
					for(int i=0;i<users.size();i++){
				 		User s = new User();
				 		s=users.get(i);
				 		System.out.println(s.getuserid()+"     "+s.getpassword());
					 }
					rs.close();
					stmt.close();
					connection.close();
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
					if(stmt!=null)
						try {
							stmt.close();
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
				return users;
			}
}
