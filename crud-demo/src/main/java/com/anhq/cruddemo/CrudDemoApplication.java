package com.anhq.cruddemo;

import com.anhq.cruddemo.dao.StudentDAO;
import com.anhq.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			//createStudent(studentDAO);
			createMultiStudent(studentDAO);
			//readStudent(studentDAO);
			//findAllStudent(studentDAO);
			//findStudentByFirstname(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students....");
		int row=studentDAO.deleteAll();
		System.out.println("Deleted "+row+" rows");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId= 6;
		System.out.println("Deleting Student :"+studentId);
		studentDAO.delete(studentId);
		System.out.println("Deleted");
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("Getting student have id: "+ studentId);
		Student student = studentDAO.findById(studentId);

		student.setFirstName("Huy");
		System.out.println("Updating student.....");
		studentDAO.update(student);
		System.out.println("Updated!!!");
	}

	private void findStudentByFirstname(StudentDAO studentDAO) {
		List<Student> studentList= studentDAO.findByFirstname("An");
		for(Student std:studentList){
			System.out.println(std);
		}
	}

	private void findAllStudent(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		for(Student std:studentList){
			System.out.println(std);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Retrive student with id 1");
		Student idOne= studentDAO.findById(2);
		System.out.println(idOne);
	}

	private void createMultiStudent(StudentDAO studentDAO) {
		System.out.println("creating 3 student object ....");
		Student student = new Student("An", "Quang", "helloworld@gmail");
		Student student1 = new Student("Loi", "Quang", "helloworld@gmail");
		Student student2 = new Student("Thoa", "Quang", "helloworld@gmail");

		System.out.println("Saving Students");
		studentDAO.save(student);
		studentDAO.save(student1);
		studentDAO.save(student2);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("...Creating new student object....");
		Student student = new Student("test", "test", "helloworld@gmail");
		studentDAO.save(student);
		System.out.println("Saved Student: Generate Id: "+ student.getId());
	}
}
