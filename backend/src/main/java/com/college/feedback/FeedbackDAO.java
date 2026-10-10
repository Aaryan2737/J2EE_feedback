package com.college.feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class FeedbackDAO {
    
    public void save(Feedback feedback) throws SQLException {
        String sql = "INSERT INTO feedback (name, email, department, year, overall_rating, " +
                     "organization_rating, content_rating, venue_rating, recommendation, " +
                     "liked_most, comments, event_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                     
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, feedback.getName());
            stmt.setString(2, feedback.getEmail());
            stmt.setString(3, feedback.getDepartment());
            stmt.setString(4, feedback.getYear());
            stmt.setInt(5, feedback.getOverallRating());
            stmt.setInt(6, feedback.getOrganizationRating());
            stmt.setInt(7, feedback.getContentRating());
            stmt.setInt(8, feedback.getVenueRating());
            stmt.setString(9, feedback.getRecommendation());
            
            String likedMostStr = feedback.getLikedMost() != null ? 
                feedback.getLikedMost().stream().collect(Collectors.joining(",")) : "";
            stmt.setString(10, likedMostStr);
            
            stmt.setString(11, feedback.getComments());
            stmt.setString(12, feedback.getEventName());
            
            stmt.executeUpdate();
        }
    }
}
