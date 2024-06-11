package com.anhq.cruddemo;

import com.anhq.cruddemo.dao.AppDAO;
import com.anhq.cruddemo.entity.Instructor;
import com.anhq.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			//createInstructor(appDAO);
			//findById(appDAO);
			//deleteById(appDAO);
			//findInstructorDetailById(appDAO);
			deleteInstructorDetailById(appDAO);
		};
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		int id=4;
		System.out.println("Deleting Instructor Detail with id :"+id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Deleted!!!");
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		int id=1;
		System.out.println("Finding Instructor Detail with Id : "+id);
		InstructorDetail tempInstructorDetail= appDAO.findInstructorDetailById(id);
		System.out.println("Instructor Detail with id= "+id+" is :"+tempInstructorDetail);
		System.out.println("Associate instructor is "+tempInstructorDetail.getInstructor());
	}

	private void deleteById(AppDAO appDAO) {
		int id=2;
		System.out.println("Deleting Instructor with id :"+id);
		appDAO.deleteById(id);
		System.out.println("Deleted!!!");
	}

	private void findById(AppDAO appDAO) {
		int id =2;

		System.out.println("Finding instructor ID : "+ id);
		Instructor instructor= appDAO.findInstructorById(id);

		System.out.println("My instructor is: "+instructor);
		System.out.println("the associate instructor detail only: "+ instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		InstructorDetail instructorDetail= new InstructorDetail("lam bao", "zing.com.vn");
		Instructor instructor= new Instructor("lai", "van sam", "sam89@gmail.com");
		instructor.setInstructorDetail(instructorDetail);
		appDAO.save(instructor);
		System.out.println("Save Instructor Success");
	}
}
