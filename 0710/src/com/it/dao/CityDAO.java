package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.it.bean.City;
import com.it.bean.Prov;
import com.it.utils.JDBCUtils;

/**
 * 
 * 
* <p>
 * Title:
 * 
 *
 * </p>
 * <p>
 * Description:com.it.dao2.CityDAO.java
 * </p>
 * <p>
 * Copyright: Copyright (c) j2se 8.0
 * </p>
 * <p>
 * date: 2018��8��20�� ����3:49:14
 * </p>
 * <p>
 * Company: gy
 * </p>
 * 
 * @author zxy
 */

public class CityDAO {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	
	public void addCity(City city) {
	      //1 ��дsql
		String sql = "insert into city values(?,?,?)";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		 //3 �������
		 Object params[] = {city.getCity_id(),city.getProv_id(),city.getCity_name()};
	
		 try {
				int rows= queryRunner.update(sql, params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				throw new RuntimeException("���ʧ��!!");
			}finally {
				//�ͷ���Դ�����ݿ����ӳ�
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("�ر���Դʧ��!");
				}
			
			
		}
	}

	public void updCity(City city) {
	      //1 ��дsql
		String sql = "update  city set city_name=?,prov_id=? where city_id=?";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		 //3 �������
		 Object params[] = {city.getCity_name(),city.getProv_id(),city.getCity_id()};
	
		 try {
				int rows= queryRunner.update(sql, params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				throw new RuntimeException("�޸�ʧ��!!");
			}finally {
				//�ͷ���Դ�����ݿ����ӳ�
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("�ر���Դʧ��!");
				}
			
			
		}
	}
	
	public void delCity(City city) {
	      //1 ��дsql
		String sql = "delete from city where city_id=?";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		 //3 �������
		 Object params[] = {city.getCity_id()};
	
		 try {
				int rows= queryRunner.update(sql, params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				throw new RuntimeException("ɾ��ʧ��!!");
			}finally {
				//�ͷ���Դ�����ݿ����ӳ�
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("�ر���Դʧ��!");
				}
			
			
		}
	}
	
	public List<City> queryAll(City city) {
		        //��дsql
				String sql = "select * from city where 1=1 ";
				if(city!=null){
					if(!"".equals(city.getCity_id()) && city.getCity_id()!=null){
						sql+=" and city_id like '%"+city.getCity_id()+"%'";
					}
					if(!"".equals(city.getCity_name()) && city.getCity_name()!=null){
						sql+=" and city_name like '%"+city.getCity_name()+"%'";
					}
					if(!"".equals(city.getProv_id()) && city.getProv_id()!=null){
						sql+=" and prov_id like '%"+city.getProv_id()+"%'";
					}
				}
				//�������City��Ϣ
				List<City> listC = null;
				
				try {
					 listC = queryRunner.query(sql, new BeanListHandler<>(City.class));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("��ѯ����ʧ��!");
				}
				finally {
					//�ͷ���Դ�����ݿ����ӳ�
					try {
						DbUtils.close(JDBCUtils.getConnections());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException("�ر���Դʧ��!");
					}
				}
				
		return listC;
	}
	
	public City findById(City city) {
		 //��дsql
		String sql = "select * from city where city_id=? ";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		 //3 �������
		 Object params[] = {city.getCity_id()};
		 City listC = null;
		 try {
			 listC = queryRunner.query(sql, new BeanHandler<City>(City.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��������ʧ��!");
		}
		finally {
			//�ͷ���Դ�����ݿ����ӳ�
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("�ر���Դʧ��!");
			}
		}
		
		return listC;
	}
	
	public List<City> queryCitysByProvId(Prov prov) {
		 //��дsql
		String sql = "select * from city where prov_id=? ";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		 //3 �������
		 Object params[] = {prov.getProv_id()};
		 List<City> citys = null;
		 try {
			citys = queryRunner.query(sql, new BeanListHandler<City>(City.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��������ʧ��!");
		}
		finally {
			//�ͷ���Դ�����ݿ����ӳ�
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("�ر���Դʧ��!");
			}
		}
		
		return citys;
	}
}
