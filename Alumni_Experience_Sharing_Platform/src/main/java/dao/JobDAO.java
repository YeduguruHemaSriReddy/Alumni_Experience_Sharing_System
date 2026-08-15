package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Job;

public class JobDAO {

    public static boolean postJob(Job job) {

        boolean status = false;

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO jobs(alumni_id,company,role,description,location) VALUES(?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, job.getAlumniId());
            ps.setString(2, job.getCompany());
            ps.setString(3, job.getRole());
            ps.setString(4, job.getDescription());
            ps.setString(5, job.getLocation());

            ps.executeUpdate();

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}