package lab8.aplikacja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lab8.aplikacja.domain.Student;
import lab8.aplikacja.exception.ResourceNotFoundException;
import lab8.aplikacja.repository.StudentRepository;


@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	@GetMapping("/students")
	public List<Student> all(){
		return repo.findAll();
	}
	@GetMapping("/students/{id}")
	public Student viewOne(@PathVariable Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	@PostMapping("/students")
	public Student newStudent(@RequestBody Student newStudent) {
	    return repo.saveAndFlush(newStudent);
	 }
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable Long id) {
	    repo.deleteById(id);
	  }
	 @PutMapping("/students/{id}")
	 public Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {

	   return repo.findById(id)
	      .map(student -> {
	        student.setImie(newStudent.getImie());
	        student.setNazwisko(newStudent.getNazwisko());
	        student.setWiek(newStudent.getWiek());
	        student.setIndeks(newStudent.getIndeks());
	        student.setKierunek(newStudent.getKierunek());
	        return repo.save(student);
	      })
	      .orElseGet(() -> {
	        newStudent.setId(id);
	        return repo.save(newStudent);
	      });
	  }

}
