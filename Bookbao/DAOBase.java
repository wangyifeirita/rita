package Bookbao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DAOBase implements DAO {//ʵ��DAO�ӿ��е����ӷ���
			@Override
			public Connection getConnection() {//ʵ������
				Connection connection = null;		
				try {
					//����JDBC����
					String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
					//���ӷ����������ݿ�sample
					String url = "jdbc:sqlserver://192.168.124.38:1433; databaseName=Library Inquiry System";
//����url=���ݿ����ϵͳ�ı�ʶ+���ݿ����ϵͳ�ĵ�ַ��ip+�˿ڣ�+ʹ�õ����ݿ�ʵ������
					String user="Emma";
					String password="123456";
					try{
						Class.forName(driverName);//��������
					}catch (ClassNotFoundException e) {
					System.out.println("�޷��ҵ�������!");
					e.printStackTrace();
					}
					//��������
					connection = DriverManager.getConnection(url,user,password);
					System.out.println("Connection Successful!"); //������ӳɹ� ����̨���
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();     
				}
				return connection;
			}
}

