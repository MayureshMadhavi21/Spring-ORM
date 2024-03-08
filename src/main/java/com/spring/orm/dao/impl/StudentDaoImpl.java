package com.spring.orm.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDaoImpl {
    
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//save student
	@Transactional
	public int insert(Student student) {
		
        int result =(Integer)this.getHibernateTemplate().save(student);		
		return result;
		
	}
	
	//get single row
	public Student getStudent(int studentId) {
		Student student  = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	//get all rows
    public List<Student> getAllStudents(){
    	List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }
    
    //deleting row
    @Transactional
    public void deleteStudent(int studentId) {
    	Student student  = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
    }
    
    //update row
    @Transactional
    public void updateStudent(Student student) {
    	this.hibernateTemplate.update(student);
    }
}
