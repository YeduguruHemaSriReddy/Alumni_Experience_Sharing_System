package servlets;

import dao.DBConnection;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/requestMentorship")
public class RequestMentorshipServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            HttpSession session = request.getSession();
            User student = (User) session.getAttribute("user");

            int studentId = student.getId();

            int alumniId = Integer.parseInt(request.getParameter("alumniId"));
            String message = request.getParameter("message");

            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO mentorship_requests(student_id, alumni_id, message, status) VALUES(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setInt(2, alumniId);
            ps.setString(3, message);
            ps.setString(4, "Pending");

            ps.executeUpdate();

            response.sendRedirect("../student/studentDashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}