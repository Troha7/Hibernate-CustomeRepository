-- Creating a table
CREATE TABLE IF NOT EXISTS student_rating.student
(
    id      SERIAL CONSTRAINT pk_student_id PRIMARY KEY,
    name    TEXT NOT NULL,
    email   TEXT NOT NULL
);