package lab7.aplikacja.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab7.aplikacja.domain.*;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long>{
	
	List<Note> findByOrderByTimestampDesc();
}
