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
		
		 //设置编码格式
		/**
		 * request是接收
		 * 是用来接收浏览器发给你的数据的
		 * 你这一步设置的是你接收数据时候的字符集
		 */
		//request.setCharacterEncoding("utf-8");
		/**
		 * response是发送。
		 * 这一步设置的是你发送数据时候的字符集
		 */
		response.setCharacterEncoding("utf-8");
		/**
		 * 这一步为什么这么写呢？你只是定义一个字符集，不用加text、html；吧？
		 */
		//response.setCharacterEncoding("text/html;utf-8");
	
		PrintWriter out=response.getWriter();
		//获取页面信息
		String user_id=request.getParameter("user_id");
		
		//生成对象
		Users users=new Users();
		//null ""
		users.setUser_id(Integer.parseInt(user_id));
		//service
	IUsers iUsers=new UsersImpl();
	//执行
	Users users2=iUsers.findUsersById(users);
	//给前端传值
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
		  * 这边不要用这个print，这个好像并没有什么用，
		  * 你若是想向浏览器输出值得话，用write，
		  */
//		 out.print(buffer.toString());	
		 out.write(buffer.toString());
		 /**
		  * 这个是刷新，因为若是达不到一定的数据量，服务器端并不会向浏览器发送数据，
		  * 所以你需要每次都强制刷新一次
		  */
		 out.flush();
	 }else{
//		 out.print("1");
		 out.write("1");
		 out.flush();
	 }
	}

}
 