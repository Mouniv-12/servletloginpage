package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Students;

@WebServlet("/update")
public class Update extends HttpServlet{
protected void dopost(HttpServletRequest req,HttpServletResponse rsp){
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		Long Mobile=Long.parseLong("mobile");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
	}

Students student=new Students();
student.setId(id);
student.setEmail(email);
student.setPassword(password);
student.setMobile(mobile);
student.setName(name);
d

}
