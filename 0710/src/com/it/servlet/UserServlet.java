package com.it.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.bean.Users;
import com.it.service.IUsers;
import com.it.service.UsersImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/UserServlet", 
				"/user.do"
		})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */ 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //���ñ����ʽ
		/**
		 * request�ǽ���
		 * �������������������������ݵ�
		 * ����һ�����õ������������ʱ����ַ���
		 */
		//request.setCharacterEncoding("utf-8");
		/**
		 * response�Ƿ��͡�
		 * ��һ�����õ����㷢������ʱ����ַ���
		 */
		response.setCharacterEncoding("utf-8");
		/**
		 * ��һ��Ϊʲô��ôд�أ���ֻ�Ƕ���һ���ַ��������ü�text��html���ɣ�
		 */
		//response.setCharacterEncoding("text/html;utf-8");
	
		PrintWriter out=response.getWriter();
		//��ȡҳ����Ϣ
		String user_id=request.getParameter("user_id");
		
		//���ɶ���
		Users users=new Users();
		//null ""
		users.setUser_id(Integer.parseInt(user_id));
		//service
	IUsers iUsers=new UsersImpl();
	//ִ��
	Users users2=iUsers.findUsersById(users);
	//��ǰ�˴�ֵ
	StringBuffer buffer=new StringBuffer();
	 if(users2!=null){
		 buffer.append("{");
		 buffer.append("\"user_id\"");
		 buffer.append(":");
		 buffer.append("\""+users2.getUser_id()+"\"");
		 buffer.append(",");
		 buffer.append("\"user_name\"");
		 buffer.append(":");
		 buffer.append("\""+users2.getUser_name()+"\"");
		 buffer.append(",");
		 buffer.append("\"user_age\"");
		 buffer.append(":");
		 buffer.append("\""+users2.getUser_age()+"\"");
		 buffer.append(",");
		 buffer.append("\"user_weight\"");
		 buffer.append(":");
		 buffer.append("\""+users2.getUser_weight()+"\"");
		 buffer.append("}");
		 
		 System.out.println(buffer.toString());
		 /**
		  * ��߲�Ҫ�����print���������û��ʲô�ã�
		  * ������������������ֵ�û�����write��
		  */
//		 out.print(buffer.toString());	
		 out.write(buffer.toString());
		 /**
		  * �����ˢ�£���Ϊ���Ǵﲻ��һ�������������������˲�������������������ݣ�
		  * ��������Ҫÿ�ζ�ǿ��ˢ��һ��
		  */
		 out.flush();
	 }else{
//		 out.print("1");
		 out.write("1");
		 out.flush();
	 }
	}

}
 