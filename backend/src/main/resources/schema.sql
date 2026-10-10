CREATE TABLE IF NOT EXISTS feedback (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    department VARCHAR(100) NOT NULL,
    year VARCHAR(50) NOT NULL,
    overall_rating INT NOT NULL CHECK (overall_rating BETWEEN 1 AND 5),
    organization_rating INT NOT NULL CHECK (organization_rating BETWEEN 1 AND 5),
    content_rating INT NOT NULL CHECK (content_rating BETWEEN 1 AND 5),
    venue_rating INT NOT NULL CHECK (venue_rating BETWEEN 1 AND 5),
    recommendation VARCHAR(20) NOT NULL,
    liked_most TEXT,
    comments TEXT,
    event_name VARCHAR(255) NOT NULL,
    submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
