import java.util.Scanner;
import Billbao.*;
import Bookbao.*;
import Locationbao.*;
import Userbao.*;
public class Test {
	   public static void main(String args[]) {
	    	System.out.println("�������û�����");
	    	Scanner ReadStr=new Scanner(System.in);
	    	String sad=ReadStr.nextLine();
	    	System.out.println("���������룺");
	    	String cry=ReadStr.nextLine();
	    	UserDAOM qwq=new UserDAOM();
	    	qwq.login(sad,cry);
	    	System.out.println("������Ҫ��ѯ��������");	
		    String bookn=ReadStr.nextLine();
		    BookDAOM bookdx=new BookDAOM();
		    bookdx.Search(bookn);
		    System.out.println("������Ҫ��ѯλ�õ�ͼ�������ţ�");	
			String code=ReadStr.nextLine();
			LocationDAOM locationdx=new LocationDAOM();
			locationdx.getLocation(code);
			System.out.println("�Ƿ�Ҫ��ѯ�˻�������������'Yes',��������'No'");
			
			System.out.println("������Ҫ��ѯ���û�����");
	    	Scanner =new Scanner(System.in);
	    	String sad=ReadStr.nextLine();
	    	BillDAOM qwq=new BillDAOM();
	    	qwq.Search(sad);
	    	
	    }
}
