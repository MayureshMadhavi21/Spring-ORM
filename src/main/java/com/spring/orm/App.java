package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.impl.StudentDaoImpl;
import com.spring.orm.entities.Student;;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
		StudentDaoImpl studentDaoImpl = context.getBean("StudentDaoImpl", StudentDaoImpl.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {
			System.out.println("Press 1 for add new Student");
			System.out.println("Press 2 for display all students");
			System.out.println("Press 3 for get detail of single student");
			System.out.println("Press 4 for delete student");
			System.out.println("Press 5 for update student");
			System.out.println("Press 6 for exit");
			int input = 1;
			try {
				input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					// add a new student
					//taking inputs from user
					System.out.println("Enter user id :");
					int id = Integer.parseInt(br.readLine());
					System.out.println("Enter user name :");
					String name = br.readLine();
					System.out.println("Enter user city :");
					String city = br.readLine();
					
					//student object created
					Student student = new Student();
					student.setStudentId(id);
					student.setStudentName(name);
					student.setStudentCity(city);
					
					//student insert operation
					int r = studentDaoImpl.insert(student);
					System.out.println(r+" Student added");
					System.out.println("************************");
					System.out.println();
					break;
				case 2:
					// display all students
					System.out.println("************************");
					List<Student> allStudents = studentDaoImpl.getAllStudents();
					for(Student st : allStudents) {
						System.out.println(st);
					}
					System.out.println("************************");
					System.out.println();
					break;
				case 3:
					// display single student
					System.out.println("************************");
					System.out.println("Enter user id");
					int userId = Integer.parseInt(br.readLine());
					Student student3 = studentDaoImpl.getStudent(userId);
					System.out.println(student3);
					System.out.println("************************");
					break;
				case 4:
					// delete student
					System.out.println("************************");
					System.out.println("Enter user id");
					int userId4 = Integer.parseInt(br.readLine());
					studentDaoImpl.deleteStudent(userId4);
					System.out.println("************************");
					break;
				case 5:
					// update student
					System.out.println("************************");
					System.out.println("Enter user id :");
					int id1 = Integer.parseInt(br.readLine());
					System.out.println("Enter user name :");
					String name1 = br.readLine();
					System.out.println("Enter user city :");
					String city1 = br.readLine();
					
					//student object created
					Student student5 = new Student();
					student5.setStudentId(id1);
					student5.setStudentName(name1);
					student5.setStudentCity(city1);
					studentDaoImpl.updateStudent(student5);
					System.out.println("************************");
					break;
				case 6:
					// exit
					go = false;
					break;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("Input is "+input);
				System.out.println("Invalid Input try with another one !!");
				System.out.println(e.getMessage());
			}

		}
		System.out.println("Thanks, you are exited , see u soon");
		((AbstractApplicationContext) context).close();
	}
}
