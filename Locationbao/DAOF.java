package Locationbao;
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
	public static LocationDAO getLocationDAO(){
		LocationDAO locationDAO = new LocationDAOM();
		return locationDAO;
	}
	
}