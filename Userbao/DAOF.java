package Userbao;
public class DAOF {
	private static DAOF instance;	
	static{
		instance = new DAOF();	
	}	
	private DAOF(){//���캯��
	}	
	public static DAOF getInstance(){
		return instance;					
	}	
	public static UserDAO getUserDAO(){
				UserDAO userDAO = new userDAOM();
				return userDAO;
			}
}
