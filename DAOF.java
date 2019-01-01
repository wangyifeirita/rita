package ͼ���ѯϵͳ;
public class DAOF {
	private static DAOF instance;	//����instanceΪ������
	static{
		instance = new DAOF();	//newһ���������instance
	}	
	private DAOF(){//���캯��
	}	
	public static DAOF getInstance(){
		return instance;					//����һ���������instance
	}	
	public static BookDAO getBookDAO(){
		BookDAO bookDAO = new BookDAOM();
		return bookDAO;
	}
	public static LocationDAO getLocationDAO(){
				LocationDAO locationDAO = new LocationDAOM();
				return locationDAO;
			}
	public static UserDAO getUserDAO(){
				UserDAO userDAO = new UserDAOM();
				return userDAO;
			}
	public static BillDAO getBillDAO(){
		BillDAO billDAO = new BillDAOM();
		return billDAO;
	}
}
