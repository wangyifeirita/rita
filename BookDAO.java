package ͼ���ѯϵͳ;
import java.util.List;
public interface BookDAO{
			public void insertBook(Book stu);//�������루��������
			public void updateBook(Book stu);//�������£��ģ�����
			public void deleteBook(String sid);//����ɾ������
			public Book getBook(String sid);//������ѯһ��ѧ����Ϣ�ķ���
			public List<Book> getBookByC(String sql);// ������ѯ���ѧ����Ϣ�ķ���
}