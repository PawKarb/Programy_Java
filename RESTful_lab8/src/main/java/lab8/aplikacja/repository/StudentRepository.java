package lab8.aplikacja.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab8.aplikacja.domain.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Optional<Student> findById(Long id);
}
