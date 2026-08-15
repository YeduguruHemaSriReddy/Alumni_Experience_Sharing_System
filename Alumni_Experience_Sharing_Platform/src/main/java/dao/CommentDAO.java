package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Comment;

public class CommentDAO {

    public static boolean addComment(Comment comment) {

        boolean status = false;

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO comments(post_id,user_id,comment_text) VALUES(?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, comment.getPostId());
            ps.setInt(2, comment.getUserId());
            ps.setString(3, comment.getCommentText());

            ps.executeUpdate();

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}