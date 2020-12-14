package com.tutorialspoint;



import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		StudentDaoImpl studentdaoImpl=(StudentDaoImpl)context.getBean("studentJDBCTemplate");
		System.out.println("----record creation---");
		studentdaoImpl.create("Zara", 11);
		studentdaoImpl.create("Nuha", 2);
		studentdaoImpl.create("Ayan", 15);
		System.out.println("---listing mutiple records---");
		List<Student> students=studentdaoImpl.listStudents();
		for(Student record:students) {
		  System.out.println("ID"+record.getId()+" Name"+record.getName()+" Age"+record.getAge());
		}
		System.out.println("---Updating Record with ID=4----");   
		studentdaoImpl.update(4,20);
		
		System.out.println("---listing record with ID=4---");
		Student student=studentdaoImpl.getStudent(4);
		System.out.println("ID"+student.getId()+" Name"+student.getName()+" Age"+student.getAge());
	}

}
