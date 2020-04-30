package lab7.aplikacja.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lab7.aplikacja.domain.*;
import lab7.aplikacja.services.NoteService;

@Controller
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@GetMapping(value = "/note")
    public String form(Model model) {
		model.addAttribute("note", new Note());
		model.addAttribute("notes", noteService.listOfNotes());
        return "note";
	}
	@PostMapping(value = "/note")
	public String add(Note note ) {
		noteService.addNote(note);
		return "redirect:note";
	}
}
