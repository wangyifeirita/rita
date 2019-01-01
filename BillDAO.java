package 图书查询系统;
import java.util.List;
public interface BillDAO{
			public void insertBill(Bill stu);//声明插入（增）方法
			public void updateBill(Bill stu);//声明更新（改）方法
			public void deleteBill(String sid);//声明删除方法
			public Bill getBill(String sid);
			public List<Bill> getBillByC(String sql);
}

