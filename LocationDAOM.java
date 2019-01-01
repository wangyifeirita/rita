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
import ͼ���ѯϵͳ.Location;
public class LocationDAOM extends DAOBase implements LocationDAO {
			@SuppressWarnings("resource")
			public static void Input(Location stu) throws IOException{
				Scanner ReadStr=new Scanner(System.in);
				System.out.println("������һ�����ߵ���Ϣ��");
		 		System.out.println("�ݲصأ�");			 
				stu.setroom(ReadStr.nextLine());
		 		System.out.println("����ţ�");
		 		stu.setcallnumber(ReadStr.nextLine());
		 		System.out.println("����״̬��");
		 		stu.setstate(ReadStr.nextLine());
			}
			private static final String CREATE_LOCATION_SQL ="INSERT INTO LOCATION values(?,?,?,?,?,?)";
			@Override
			public void insertLocation(Location stu) {//ʵ�ֲ��뷽��������
				Connection connection = null;
				PreparedStatement pst = null;
				try{
					connection = getConnection();//�������ݿ�
					Input(stu);
					pst = connection.prepareStatement(CREATE_LOCATION_SQL);
					pst.setString(1, stu.getroom());
					pst.setString(2, stu.getcallnumber());
					pst.setString(3, stu.getstate());
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
			public void updateLocation(Location stu) {//ʵ�ָ��£��ģ�����
				// TODO Auto-generated method stub
				try{
					Connection connection = null;
					Statement stmt = null;
					int rs;
					try {
						connection = getConnection();//�������ݿ�
						Scanner ReadStr=new Scanner(System.in);
						System.out.println("������Ҫ���µĹݲصأ�");	 
						stmt = connection.createStatement();
						String sql = "delete from Student where userid=";
						rs= stmt.executeUpdate(sql+ReadStr.nextLine());
						insertLocation(stu);
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
			public void deleteLocation(String sid) {//ʵ��ɾ������
				// TODO Auto-generated method stub
				Connection connection = null;
				Statement stmt = null;
				int rs ;
				try {
					connection = getConnection();//�������ݿ�
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("������Ҫɾ���Ĺݲصأ�");		 
			 		sid=ReadStr.nextLine();
					stmt = connection.createStatement();
					String sql = "delete from Location where userid=";
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
			private static final String SEARCH_LOCATIONC1 = "SELECT userid,password FROM User WHERE userid=";
			@Override
			public Location getLocation(String sid) {
				// TODO Auto-generated method stub
				Connection connection = null;
				Statement stmt = null;
				ResultSet rs = null;
				Location stu = new Location();
				try{
					connection = getConnection();
					stmt = connection.createStatement();			
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("������Ҫ��ѯ�Ĺݲصأ�");		 
					sid=ReadStr.nextLine();
					String endsql = null;
					endsql = SEARCH_LOCATIONC1 +Integer.parseInt(sid);
					rs=stmt.executeQuery(endsql);
					while(rs.next()){				
						stu.setroom(rs.getString("room"));
						stu.setcallnumber(rs.getString("callnumber"));
						stu.setstate(rs.getString("state"));
						System.out.println(stu.getroom()+"     "+stu.getcallnumber()+" "+stu.getstate());
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
			private static final String SEARCH_LOCATIONC = "SELECT userid,password FROM User";
			@Override
			public List<Location> getLocationByC(String sql) {
				List<Location> locations = new ArrayList<Location>();
				Connection connection = null;
				Statement stmt = null;
				ResultSet rs = null;
				try{
					connection = getConnection();
					stmt = connection.createStatement();
					String endsql = null;
					if(sql.equals("")){
						endsql = SEARCH_LOCATIONC;
					}else{
						endsql = SEARCH_LOCATIONC + " WHERE "+sql;
					}
					rs=stmt.executeQuery(endsql);
					while(rs.next()){
						Location location = new Location();
						location.setroom(rs.getString("room"));
						location.setcallnumber(rs.getString("callnumber"));
						location.setstate(rs.getString("state"));
						locations.add(location);			
					}
					for(int i=0;i<locations.size();i++){
						Location s = new Location();
				 		s=locations.get(i);
				 		System.out.println(s.getroom()+"     "+s.getcallnumber()+" "+s.getstate());
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
				return locations;
			}
}
