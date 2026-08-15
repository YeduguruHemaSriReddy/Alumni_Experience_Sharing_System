package servlets;

import dao.UserDAO;
import model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = UserDAO.loginUser(email, password);

        if (user != null) {

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            String role = user.getRole();

            if (role.equals("admin")) {

                response.sendRedirect(request.getContextPath() + "/adminDashboard.jsp");

            } 
            else if (role.equals("alumni")) {

                response.sendRedirect(request.getContextPath() + "/alumni/alumniDashboard.jsp");

            } 
            else if (role.equals("student")) {

                response.sendRedirect(request.getContextPath() + "/student/StudentDashboard.jsp");

            }

        } else {

            response.getWriter().println("Invalid login or admin approval pending");

        }
    }
}