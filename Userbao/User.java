package Userbao;
public class User {
	private String userid;
	private String password;
	public String getuserid() {
		return userid;
	}
	public void setuserid(String userid) {
		if(userid==null){
			System.out.println("�û�������Ϊ��!");
		}
		this.userid = userid;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		if(password==null){
			System.out.println("���벻��Ϊ��!");
		}
		this.password = password;
	}
}

