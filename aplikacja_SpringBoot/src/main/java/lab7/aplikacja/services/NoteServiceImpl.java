package lab7.aplikacja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab7.aplikacja.domain.Note;
import lab7.aplikacja.repositories.NoteRepo;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteRepo repo;
	
	@Override
	public List<Note> listOfNotes() {
		return repo.findByOrderByTimestampDesc();
	}

	@Override
	public void addNote(Note n) {
		repo.save(n);
	}

}
