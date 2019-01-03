package Bookbao;
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
	
}