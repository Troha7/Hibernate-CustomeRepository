-- Creating a table
CREATE TABLE IF NOT EXISTS student_rating.mark
(
    id              SERIAL,
    fk_student_id   INTEGER CONSTRAINT student_id_fkey
                    REFERENCES student_rating.student,
    discipline      TEXT NOT NULL,
    value           INTEGER
);