package com.college.feedback;

import java.sql.SQLException;

public class FeedbackService {
    private final FeedbackDAO dao;

    public FeedbackService() {
        this.dao = new FeedbackDAO();
    }

    public void processFeedback(Feedback feedback) throws SQLException, IllegalArgumentException {
        // Basic validation
        if (feedback.getName() == null || feedback.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (feedback.getEmail() == null || !feedback.getEmail().contains("@")) {
            throw new IllegalArgumentException("Valid email is required");
        }
        if (feedback.getDepartment() == null || feedback.getDepartment().trim().isEmpty()) {
            throw new IllegalArgumentException("Department is required");
        }
        if (feedback.getYear() == null || feedback.getYear().trim().isEmpty()) {
            throw new IllegalArgumentException("Year is required");
        }
        if (feedback.getOverallRating() < 1 || feedback.getOverallRating() > 5) {
            throw new IllegalArgumentException("Overall rating must be between 1 and 5");
        }
        if (feedback.getRecommendation() == null || feedback.getRecommendation().trim().isEmpty()) {
            throw new IllegalArgumentException("Recommendation is required");
        }

        if (feedback.getComments() != null && feedback.getComments().length() > 500) {
            throw new IllegalArgumentException("Comments cannot exceed 500 characters");
        }

        dao.save(feedback);
    }
}
