package com.college.feedback;

import java.util.List;

public class Feedback {
    private String name;
    private String email;
    private String department;
    private String year;
    private int overallRating;
    private int organizationRating;
    private int contentRating;
    private int venueRating;
    private String recommendation;
    private List<String> likedMost;
    private String comments;
    private String eventName;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }
    
    public int getOverallRating() { return overallRating; }
    public void setOverallRating(int overallRating) { this.overallRating = overallRating; }
    
    public int getOrganizationRating() { return organizationRating; }
    public void setOrganizationRating(int organizationRating) { this.organizationRating = organizationRating; }
    
    public int getContentRating() { return contentRating; }
    public void setContentRating(int contentRating) { this.contentRating = contentRating; }
    
    public int getVenueRating() { return venueRating; }
    public void setVenueRating(int venueRating) { this.venueRating = venueRating; }
    
    public String getRecommendation() { return recommendation; }
    public void setRecommendation(String recommendation) { this.recommendation = recommendation; }
    
    public List<String> getLikedMost() { return likedMost; }
    public void setLikedMost(List<String> likedMost) { this.likedMost = likedMost; }
    
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
    
    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }
}
