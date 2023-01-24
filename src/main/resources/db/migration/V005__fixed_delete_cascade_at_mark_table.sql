ALTER TABLE student_rating.mark
    DROP CONSTRAINT student_id_fkey
    , ADD  CONSTRAINT student_id_fkey
    FOREIGN KEY (fk_student_id) REFERENCES student_rating.student (id) ON DELETE CASCADE;