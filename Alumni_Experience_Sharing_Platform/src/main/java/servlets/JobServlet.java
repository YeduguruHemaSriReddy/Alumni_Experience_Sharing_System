package servlets;

import dao.DBConnection;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import model.User;

@WebServlet("/postJob")
public class JobServlet extends HttpServlet {

protected void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{

try{

HttpSession session=request.getSession();

User user=(User)session.getAttribute("user");

Connection conn=DBConnection.getConnection();

String sql="INSERT INTO jobs(alumni_id,company,role,location,description) VALUES(?,?,?,?,?)";

PreparedStatement ps=conn.prepareStatement(sql);

ps.setInt(1,user.getId());
ps.setString(2,request.getParameter("company"));
ps.setString(3,request.getParameter("role"));
ps.setString(4,request.getParameter("location"));
ps.setString(5,request.getParameter("description"));

ps.executeUpdate();

response.sendRedirect("../student/jobBoard.jsp");

}catch(Exception e){
e.printStackTrace();
}

}
}