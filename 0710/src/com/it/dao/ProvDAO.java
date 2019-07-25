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
 * Description:com.it.dao.ProvDAO.java
 * </p>
 * <p>
 * Copyright: Copyright (c) j2se 8.0
 * </p>
 * <p>
 * date: 2018��8��21�� ����10:52:22
 * </p>
 * <p>
 * Company: gy
 * </p>
 * 
 * @author zxy
 */

public class ProvDAO {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	public void addProv(Prov prov) {
	      //1 ��дsql
		String sql = "insert into prov values(?,?)";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		 //3 �������
		 Object params[] = {prov.getProv_id(),prov.getProv_name()};
	
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
	
	

	public void updProv(Prov prov) {
	      //1 ��дsql
		String sql = "update  prov set prov_name=? where prov_id=?";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		 //3 �������
		 Object params[] = {prov.getProv_id(),prov.getProv_id()};
	
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
	
	public void delProv(Prov prov) {
	      //1 ��дsql
		String sql = "delete from prov where prov_id=?";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		 //3 �������
		 Object params[] = {prov.getProv_id()};	
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
	
	public List<Prov> queryAll(Prov prov) {
		//1 ��дsql
		String sql = "select * from Prov where 1=1";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		
		 if(prov!=null){
			 if(!"".equals(prov.getProv_id()) && prov.getProv_id()!=null){
					sql+=" and prov_id like '%"+prov.getProv_id()+"%'";
				}
			 if(!"".equals(prov.getProv_name()) && prov.getProv_name()!=null){
					sql+=" and prov_name like '%"+prov.getProv_name()+"%'";
				}
		 }
		 List<Prov> listP = null;
		 try {
			listP = queryRunner.query(sql, new BeanListHandler<>(Prov.class));
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
		 
		 
		 //ִ��
		return listP;
	}
	
	public Prov findById(Prov prov) {
		 //��дsql
		String sql = "select * from prov where prov_id=? ";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		 //3 �������
		 Object params[] = {prov.getProv_id()};
		 Prov provs  = null;
		try {
			provs =  queryRunner.query(sql, new BeanHandler<Prov>(Prov.class), params);
		    
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
		return provs;
	}
}
	
