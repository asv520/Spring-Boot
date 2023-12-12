package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		//Java Lambda Expression. Will be executed after the spring beans have been loaded.
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentID = 1;
		System.out.println("Deleting student id: " + studentID);
		studentDAO.delete(studentID);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id:primary key
		int studentId = 1;
		System.out.println("Retrieving student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to 'Scooby'
		System.out.println("Updating the student...");
		myStudent.setFirstName("Scooby");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated the student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Wick");

		//display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Kyle", "Crane", "Crane16@luv2code.com");

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theID = tempStudent.getId();
		System.out.println("Saved Student. Generated id: " + theID);

		//retrieve student based on the id: Primary Key
		System.out.println("Retrieving student with id: " + theID);
		Student myStudent = studentDAO.findById(theID);

		//display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple students

		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("John", "Wick", "JohnWick@luv2code.com");
		Student tempStudent2 = new Student("Arthur", "Morgan", "Arthur@luv2code.com");
		Student tempStudent3 = new Student("Niko", "Bellic", "Niko@luv2code.com");

		//save the student objects

		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student objects...");
		Student tempStudent = new Student("John", "Doe", "John@luv2code.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved Student! Generated Id: " + tempStudent.getId());
	}
}
