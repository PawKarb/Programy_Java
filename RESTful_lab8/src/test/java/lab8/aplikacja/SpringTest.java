package lab8.aplikacja;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lab8.aplikacja.controller.StudentController;
import lab8.aplikacja.domain.Student;
import lab8.aplikacja.repository.StudentRepository;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class SpringTest {
	
	@Autowired 
	private StudentController controller;
	
	@Autowired
	private StudentRepository repo;
	
	@Test
	void testFindById() {
		assertNotNull(controller.viewOne(1L));
	}
	@Test
	void testNewStudent() {
		Student testStudent = new Student();
		testStudent.setImie("Robert");
		
		Student created = controller.newStudent(testStudent);
		
		assertThat(created.getImie(),is(testStudent.getImie()));
	}

}
