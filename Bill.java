package ͼ���ѯϵͳ;
public class Bill {
	private String billid;
	private String money;
	private String date;
	public String getbillid() {
		return billid;
	}
	public void setbillid(String billid) {
		if(billid==null){
			System.out.println("�����Ų���Ϊ��!");
		}
		this.billid = billid;
	}
	public String getmoney() {
		return money;
	}
	public void setmoney(String money) {
		if(money==null){
			System.out.println("������Ϊ��!");
		}
		this.money =money;
	}
	public String getdate() {
		return date;
	}
	public void setdate(String date) {
		if(date==null){
			System.out.println("���ڲ���Ϊ��!");
		}
		this.date =date;
	}
}
