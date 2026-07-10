CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(100) NOT NULL,
    registration_date DATE NOT NULL
);

CREATE TABLE Events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    city VARCHAR(100) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    status ENUM('upcoming', 'completed', 'cancelled') NOT NULL,
    organizer_id INT,
    FOREIGN KEY (organizer_id) REFERENCES Users(user_id)
);

CREATE TABLE Sessions (
    session_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    title VARCHAR(200) NOT NULL,
    speaker_name VARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE Registrations (
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    registration_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE Feedback (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comments TEXT,
    feedback_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE Resources (
    resource_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    resource_type ENUM('pdf', 'image', 'link') NOT NULL,
    resource_url VARCHAR(255) NOT NULL,
    uploaded_at DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

INSERT INTO Users (user_id, full_name, email, city, registration_date) VALUES
(1, 'Alice Johnson', 'alice@example.com', 'New York', '2024-12-01'),
(2, 'Bob Smith', 'bob@example.com', 'Los Angeles', '2024-12-05'),
(3, 'Charlie Lee', 'charlie@example.com', 'Chicago', '2024-12-10'),
(4, 'Diana King', 'diana@example.com', 'New York', '2025-01-15'),
(5, 'Ethan Hunt', 'ethan@example.com', 'Los Angeles', '2025-02-01');

INSERT INTO Events (event_id, title, description, city, start_date, end_date, status, organizer_id) VALUES
(1, 'Tech Innovators Meetup', 'A meetup for tech enthusiasts.', 'New York', '2025-06-10 10:00:00', '2025-06-10 16:00:00', 'upcoming', 1),
(2, 'AI & ML Conference', 'Conference on AI and ML advancements.', 'Chicago', '2025-05-15 09:00:00', '2025-05-15 17:00:00', 'completed', 3),
(3, 'Frontend Development Bootcamp', 'Hands-on training on frontend tech.', 'Los Angeles', '2025-07-01 10:00:00', '2025-07-03 16:00:00', 'upcoming', 2);

INSERT INTO Sessions (session_id, event_id, title, speaker_name, start_time, end_time) VALUES
(1, 1, 'Opening Keynote', 'Dr. Tech', '2025-06-10 10:00:00', '2025-06-10 11:00:00'),
(2, 1, 'Future of Web Dev', 'Alice Johnson', '2025-06-10 11:15:00', '2025-06-10 12:30:00'),
(3, 2, 'AI in Healthcare', 'Charlie Lee', '2025-05-15 09:30:00', '2025-05-15 11:00:00'),
(4, 3, 'Intro to HTML5', 'Bob Smith', '2025-07-01 10:00:00', '2025-07-01 12:00:00');

INSERT INTO Registrations (registration_id, user_id, event_id, registration_date) VALUES
(1, 1, 1, '2025-05-01'),
(2, 2, 1, '2025-05-02'),
(3, 3, 2, '2025-04-30'),
(4, 4, 2, '2025-04-28'),
(5, 5, 3, '2025-06-15');

INSERT INTO Feedback (feedback_id, user_id, event_id, rating, comments, feedback_date) VALUES
(1, 3, 2, 4, 'Great insights!', '2025-05-16'),
(2, 4, 2, 5, 'Very informative.', '2025-05-16'),
(3, 2, 1, 3, 'Could be better.', '2025-06-11');

INSERT INTO Resources (resource_id, event_id, resource_type, resource_url, uploaded_at) VALUES
(1, 1, 'pdf', 'https://portal.com/resources/tech_meetup_agenda.pdf', '2025-05-01 10:00:00'),
(2, 2, 'image', 'https://portal.com/resources/ai_poster.jpg', '2025-04-20 09:00:00'),
(3, 3, 'link', 'https://portal.com/resources/html5_docs', '2025-06-25 15:00:00');

SELECT e.* FROM Registrations r JOIN Events e ON r.event_id = e.event_id JOIN Users u ON r.user_id = u.user_id WHERE e.status = 'upcoming' AND e.city = u.city ORDER BY e.start_date;

SELECT event_id, AVG(rating) FROM Feedback GROUP BY event_id HAVING COUNT(feedback_id) >= 10 ORDER BY AVG(rating) DESC;

SELECT * FROM Users WHERE user_id NOT IN (SELECT user_id FROM Registrations WHERE registration_date >= DATE_SUB('2026-07-10', INTERVAL 90 DAY));

SELECT event_id, COUNT(session_id) FROM Sessions WHERE TIME(start_time) >= '10:00:00' AND TIME(end_time) <= '12:00:00' GROUP BY event_id;

SELECT e.city, COUNT(DISTINCT r.user_id) FROM Registrations r JOIN Events e ON r.event_id = e.event_id GROUP BY e.city ORDER BY COUNT(DISTINCT r.user_id) DESC LIMIT 5;

SELECT event_id, SUM(CASE WHEN resource_type = 'pdf' THEN 1 ELSE 0 END) AS pdf_count, SUM(CASE WHEN resource_type = 'image' THEN 1 ELSE 0 END) AS image_count, SUM(CASE WHEN resource_type = 'link' THEN 1 ELSE 0 END) AS link_count FROM Resources GROUP BY event_id;

SELECT u.full_name, f.rating, f.comments, e.title FROM Feedback f JOIN Users u ON f.user_id = u.user_id JOIN Events e ON f.event_id = e.event_id WHERE f.rating < 3;

SELECT e.event_id, e.title, COUNT(s.session_id) FROM Events e LEFT JOIN Sessions s ON e.event_id = s.event_id WHERE e.status = 'upcoming' GROUP BY e.event_id, e.title;

SELECT organizer_id, status, COUNT(event_id) FROM Events GROUP BY organizer_id, status;

SELECT DISTINCT event_id FROM Registrations WHERE event_id NOT IN (SELECT DISTINCT event_id FROM Feedback);

SELECT registration_date, COUNT(user_id) FROM Users WHERE registration_date >= DATE_SUB('2026-07-10', INTERVAL 7 DAY) GROUP BY registration_date;

SELECT event_id, COUNT(session_id) FROM Sessions GROUP BY event_id HAVING COUNT(session_id) = (SELECT MAX(session_count) FROM (SELECT COUNT(session_id) AS session_count FROM Sessions GROUP BY event_id) AS temp);

SELECT e.city, AVG(f.rating) FROM Feedback f JOIN Events e ON f.event_id = e.event_id GROUP BY e.city;

SELECT event_id, COUNT(registration_id) FROM Registrations GROUP BY event_id ORDER BY COUNT(registration_id) DESC LIMIT 3;

SELECT s1.event_id, s1.session_id AS session_1, s2.session_id AS session_2 FROM Sessions s1 JOIN Sessions s2 ON s1.event_id = s2.event_id AND s1.session_id < s2.session_id WHERE (s1.start_time < s2.end_time AND s1.end_time > s2.start_time);

SELECT * FROM Users WHERE registration_date >= DATE_SUB('2026-07-10', INTERVAL 30 DAY) AND user_id NOT IN (SELECT DISTINCT user_id FROM Registrations);

SELECT speaker_name, COUNT(session_id) FROM Sessions GROUP BY speaker_name HAVING COUNT(session_id) > 1;

SELECT * FROM Events WHERE event_id NOT IN (SELECT DISTINCT event_id FROM Resources);

SELECT e.event_id, e.title, (SELECT COUNT(registration_id) FROM Registrations r WHERE r.event_id = e.event_id) AS total_registrations, AVG(f.rating) AS avg_rating FROM Events e LEFT JOIN Feedback f ON e.event_id = f.event_id WHERE e.status = 'completed' GROUP BY e.event_id, e.title;

SELECT u.user_id, u.full_name, COUNT(DISTINCT r.event_id) AS events_registered, COUNT(DISTINCT f.feedback_id) AS feedbacks_submitted FROM Users u LEFT JOIN Registrations r ON u.user_id = r.user_id LEFT JOIN Feedback f ON u.user_id = f.user_id GROUP BY u.user_id, u.full_name;

SELECT user_id, COUNT(feedback_id) FROM Feedback GROUP BY user_id ORDER BY COUNT(feedback_id) DESC LIMIT 5;

SELECT user_id, event_id, COUNT(registration_id) FROM Registrations GROUP BY user_id, event_id HAVING COUNT(registration_id) > 1;

SELECT DATE_FORMAT(registration_date, '%Y-%m') AS reg_month, COUNT(registration_id) FROM Registrations WHERE registration_date >= DATE_SUB('2026-07-10', INTERVAL 12 MONTH) GROUP BY reg_month ORDER BY reg_month;

SELECT event_id, AVG(TIMESTAMPDIFF(MINUTE, start_time, end_time)) FROM Sessions GROUP BY event_id;

SELECT * FROM Events WHERE event_id NOT IN (SELECT DISTINCT event_id FROM Sessions);
