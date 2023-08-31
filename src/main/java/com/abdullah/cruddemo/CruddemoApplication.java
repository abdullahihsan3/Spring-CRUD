package com.abdullah.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.abdullah.cruddemo.dao.StudentDAO;
import com.abdullah.cruddemo.entity.Student;

@SpringBootApplication()
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return Runner ->{
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//getStudentList(studentDAO);
			//findStudentByLastName(studentDAO);
			//findStudentByFirstName(studentDAO);
			//updateFirstNameById(studentDAO);
			//updateLastNameById(studentDAO);
			//updateLastNameOfAllStudents(studentDAO);
			//deleteById(studentDAO);
			//deleteByLastName(studentDAO);

		};
	}

	private void deleteByLastName(StudentDAO studentDAO) {
		studentDAO.deleteByLastName("Ihsan");
	}

	private void deleteById(StudentDAO studentDAO) {
		studentDAO.deleteById(1);
	}

	private void updateLastNameOfAllStudents(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		student.setFirstName("abdull");
		student.setLastName("ihsihs");
		student.setEmail("abdul@gmail.com");
		studentDAO.update(student);
	}

	private void updateLastNameById(StudentDAO studentDAO) {
		System.out.println(studentDAO.updateLastNameById(1,"Ihs"));
	}

	private void updateFirstNameById(StudentDAO studentDAO) {
		System.out.println(studentDAO.updateFirstNameById(1,"Abdul"));
	}

	private void findStudentByFirstName(StudentDAO studentDAO) {
		System.out.println(studentDAO.findByFirstName("Abdullah"));
	}

	private void findStudentByLastName(StudentDAO studentDAO) {
		System.out.println(studentDAO.findByLastName("Abdullah"));
	}

	private void getStudentList(StudentDAO studentDAO) {
		System.out.println(studentDAO.findAll());
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.findById(1));
	}
	
	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		Student student = new Student("Abdullah", "Ihsan", "abdullah.ihsan3@gmail.com");
		Student student1 = new Student("Maham", "Ihsan", "maham.ihsan3@gmail.com");
		Student student2 = new Student("Ainan", "Ihsan", "ainan.ihsan3@gmail.com");
		
		//Save the student object
		studentDAO.save(student);
		studentDAO.save(student1);
		studentDAO.save(student2);
		//Display the saved student
		System.out.println(student.getId());
		//save the student objects
	}

	private void createStudent(StudentDAO studentDAO) {
		//Create the student object
		Student student = new Student("Abdullah", "Ihsan", "abdullah.ihsan3@gmail.com");
		//Save the student object
		studentDAO.save(student);
		//Display the saved student
		System.out.println(student.getId());
	}

}
