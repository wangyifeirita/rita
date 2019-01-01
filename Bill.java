package 图书查询系统;
public class Bill {
	private String billid;
	private String money;
	private String date;
	public String getbillid() {
		return billid;
	}
	public void setbillid(String billid) {
		if(billid==null){
			System.out.println("罚单号不能为空!");
		}
		this.billid = billid;
	}
	public String getmoney() {
		return money;
	}
	public void setmoney(String money) {
		if(money==null){
			System.out.println("罚金不能为空!");
		}
		this.money =money;
	}
	public String getdate() {
		return date;
	}
	public void setdate(String date) {
		if(date==null){
			System.out.println("日期不能为空!");
		}
		this.date =date;
	}
}
