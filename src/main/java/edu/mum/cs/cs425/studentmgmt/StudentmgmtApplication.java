package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.service.ClassroomService;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;
import edu.mum.cs.cs425.studentmgmt.service.TranscriptService;

@SpringBootApplication
public class StudentmgmtApplication implements CommandLineRunner {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private TranscriptService transcriptService;
	@Autowired
	private ClassroomService classroomService;

	public static void main(String[] args) {
		SpringApplication.run(StudentmgmtApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Student s1 = new Student("000-61-001", "Anna", "Lynn", 
								"Smith", 3.45f, LocalDate.of(2019, 5, 24));
		
		Transcript t1 = new Transcript("BS Computer Science");
		
		s1.setTranscript(t1);
		t1.setStudent(s1);
		//studentService.save(s);
		
		Student s2 = new Student("000-61-002", "Abebe", "Beso", 
				"Bela", 3.45f, LocalDate.of(2019, 8, 3));
		Transcript t2 = new Transcript("MS Computer Science");
		s2.setTranscript(t2);
		t2.setStudent(s2);
		
		Classroom c = new Classroom("McLaughlin building", "M105");
		//s1.setClassroom(c);
		s2.setClassroom(c);
		List<Student> st = new ArrayList<Student>();
		st.add(s1);
		st.add(s2);
		c.setStudents(st);
		classroomService.save(c);
		
	}

}
