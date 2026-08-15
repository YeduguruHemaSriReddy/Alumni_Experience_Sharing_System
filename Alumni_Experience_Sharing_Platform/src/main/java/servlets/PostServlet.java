package servlets;

import dao.DBConnection;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import model.User;

@WebServlet("/createPost")
public class PostServlet extends HttpServlet {

protected void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{

try{

HttpSession session=request.getSession();
User user=(User)session.getAttribute("user");

int userId=user.getId();

String title=request.getParameter("title");
String content=request.getParameter("content");

Connection conn=DBConnection.getConnection();

String sql="INSERT INTO posts(user_id,title,content) VALUES(?,?,?)";

PreparedStatement ps=conn.prepareStatement(sql);

ps.setInt(1,userId);
ps.setString(2,title);
ps.setString(3,content);

ps.executeUpdate();

response.sendRedirect("../viewPosts.jsp");

}catch(Exception e){
e.printStackTrace();
}

}
}