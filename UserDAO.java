package ͼ���ѯϵͳ;
import java.util.List;
public interface UserDAO{
			public void insertUser(User stu);//�������루��������
			public void updateUser(User stu);//�������£��ģ�����
			public void deleteUser(String sid);//����ɾ������
			public User getUser(String sid);//������ѯһ��ѧ����Ϣ�ķ���
			public List<User> getUserByC(String sql);// ������ѯ���ѧ����Ϣ�ķ���
}