package ͼ���ѯϵͳ;
import java.util.List;
public interface LocationDAO{
			public void insertLocation(Location stu);//�������루��������
			public void updateLocation(Location stu);//�������£��ģ�����
			public void deleteLocation(String sid);//����ɾ������
			public Location getLocation(String sid);
			public List<Location> getLocationByC(String sql);
}
