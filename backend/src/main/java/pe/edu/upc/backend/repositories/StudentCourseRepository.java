package pe.edu.upc.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.backend.entities.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
}
