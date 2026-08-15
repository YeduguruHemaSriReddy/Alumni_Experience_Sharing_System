package servlets;

import dao.DBConnection;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/updateMentorship")
public class MentorshipServlet extends HttpServlet {

protected void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{

try{

int id=Integer.parseInt(request.getParameter("id"));
String action=request.getParameter("action");

Connection conn=DBConnection.getConnection();

String sql="UPDATE mentorship_requests SET status=? WHERE id=?";

PreparedStatement ps=conn.prepareStatement(sql);

ps.setString(1,action);
ps.setInt(2,id);

ps.executeUpdate();

response.sendRedirect("alumni/mentorshipRequests.jsp");

}catch(Exception e){
e.printStackTrace();
}

}
}