package ͼ���ѯϵͳ;
import java.util.List;
public interface BillDAO{
			public void insertBill(Bill stu);//�������루��������
			public void updateBill(Bill stu);//�������£��ģ�����
			public void deleteBill(String sid);//����ɾ������
			public Bill getBill(String sid);
			public List<Bill> getBillByC(String sql);
}

