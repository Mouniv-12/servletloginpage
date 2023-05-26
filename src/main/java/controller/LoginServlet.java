package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Students;

@WebServlet("/login")

public class LoginServlet extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String email=req.getParameter("email");
//    long mobile=Long.parseLong(email);
    String password=req.getParameter("password");
    
    
    StudentDao dao=new StudentDao();
    Students student;
    
    
    try{
    	  long mobile1=Long.parseLong(email);
    	  student=dao.fetch(mobile1);
    }
    catch(NumberFormatException e){
    	 student=dao.fetch(email);
    }
    if(student==null)
    {
    	resp.getWriter().print("<h1>Inavild email/mobile<h1>");
    	req.getRequestDispatcher("Loginpage.html").include(req, resp);
    }
//    else{
//    	if(student.getPassword().equals(password)){
//    	resp.getWriter().print("<h1>Login sucessfull<h1>");
//    	resp.getWriter().print("<div style='background-color:red'>");
//    	resp.getWriter().print("<table border='1'"
//   			    + ""
//    			+ ">"
//    			+"<tr>"
//    			+"<th>Id</th>"
//    			+"<th>Name</th>"
//    			+"<th>Email</th>"
//    			+"<th>mobile</th>"
//    			+"<th>Password</th>"
//    			+"</tr>"
//    			+"<tr>"
//   			    +"<th>"+student.getId()+"</th>"
//   			    +"<th>"+student.getName()+"</th>"
//    			+"<th>"+student.getEmail()+"</th>"
//    			+"<th>"+student.getMobile()+"</th>"
//    			+"<th>"+student.getPassword()+"</th>"
//     			+"</tr>"
//    		     +"</table>");
//    	resp.getWriter().print("</div><br><br>");
//    	
//    	resp.getWriter().print("<div style='background-colour:yellow'>");
//		resp.getWriter().print("<table border='1'>"
//				+ "<tr>"
//				+"<th>Id</th>"
//				+"<th>Name</th>"
//				+"<th>mobile</th>"
//				+"<th>Email</th>"
//				+"<th>password</th>"
//				+ "</tr>");
//		
//		List<Students>list=dao.fetch();
//		
//		for(Students stud : list) {
//			resp.getWriter()
//			.print("<tr>"
//					+"<th>"+stud.getId()+"</th>"
//					+"<th>"+stud.getName()+"</th>"
//					+"<th>"+stud.getMobile()+"</th>"
//					+"<th>"+stud.getPassword()+"</th>"
//					+"<th>"+stud.getEmail()+"</th>"
//					+ "</tr>");
//					
//		}
//		resp.getWriter().print("</table");
    	
    	else{
    		if(student.getPassword().equals(password)){
    			resp.getWriter().print("<h1>login Success</h1>");
    			req.setAttribute("student", student);
    			req.setAttribute("list", dao.fetch());
    			req.getRequestDispatcher("Success.jsp").include(req,resp);
    		}else{
    		resp.getWriter().print("<h1>Invalid Password</h1>");
    		req.getRequestDispatcher("Loginpage.html").include(req, resp);
    	}
    }		 	
    
    }
  }


