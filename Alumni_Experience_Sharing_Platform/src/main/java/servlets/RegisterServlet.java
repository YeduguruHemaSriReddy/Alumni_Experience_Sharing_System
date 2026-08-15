package servlets;

import dao.UserDAO;
import model.User;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        if(!email.endsWith("@srit.ac.in")){
            response.getWriter().println("Only college email allowed");
            return;
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        boolean status = UserDAO.registerUser(user);

        if(status){
            response.sendRedirect("login.jsp");
        }else{
            response.getWriter().println("Registration failed");
        }
    }
}