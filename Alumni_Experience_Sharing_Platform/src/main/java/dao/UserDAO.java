package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDAO {

    // REGISTER USER
    public static boolean registerUser(User user) {

        boolean status = false;

        try {

            Connection conn = DBConnection.getConnection();

            // Check if email already exists
            String checkQuery = "SELECT * FROM users WHERE email=?";
            PreparedStatement checkPs = conn.prepareStatement(checkQuery);
            checkPs.setString(1, user.getEmail());

            ResultSet checkRs = checkPs.executeQuery();

            if (checkRs.next()) {
                // Email already exists
                return false;
            }

            String sql = "INSERT INTO users(name,email,password,role,status) VALUES(?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());

            // Default status pending until admin approves
            ps.setString(5, "pending");

            ps.executeUpdate();

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // LOGIN USER
    public static User loginUser(String email, String password) {

        User user = null;

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE email=? AND password=? AND status='approved'";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                user.setStatus(rs.getString("status"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}