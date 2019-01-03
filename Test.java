import java.util.Scanner;
import Billbao.*;
import Bookbao.*;
import Locationbao.*;
import Userbao.*;
public class Test {
	   public static void main(String args[]) {
	    	System.out.println("请输入用户名：");
	    	Scanner ReadStr=new Scanner(System.in);
	    	String sad=ReadStr.nextLine();
	    	System.out.println("请输入密码：");
	    	String cry=ReadStr.nextLine();
	    	UserDAOM qwq=new UserDAOM();
	    	qwq.login(sad,cry);
	    	System.out.println("请输入要查询的书名：");	
		    String bookn=ReadStr.nextLine();
		    BookDAOM bookdx=new BookDAOM();
		    bookdx.Search(bookn);
		    System.out.println("请输入要查询位置的图书的条码号：");	
			String code=ReadStr.nextLine();
			LocationDAOM locationdx=new LocationDAOM();
			locationdx.getLocation(code);
			System.out.println("是否要查询账户罚单，是请输'Yes',否请输入'No'");
			
			System.out.println("请输入要查询的用户名：");
	    	Scanner =new Scanner(System.in);
	    	String sad=ReadStr.nextLine();
	    	BillDAOM qwq=new BillDAOM();
	    	qwq.Search(sad);
	    	
	    }
}
