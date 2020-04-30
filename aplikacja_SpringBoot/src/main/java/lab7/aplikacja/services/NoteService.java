package lab7.aplikacja.services;

import java.util.List;


import lab7.aplikacja.domain.*;

public interface NoteService {
	List<Note> listOfNotes();
	void addNote(Note n);
}
