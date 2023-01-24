ALTER TABLE student_rating.mark ADD FOREIGN KEY (fk_student_id)
    REFERENCES student_rating.student (id) ON DELETE CASCADE;