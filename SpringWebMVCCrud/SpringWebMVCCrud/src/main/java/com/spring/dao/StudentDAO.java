package com.spring.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bean.Student;

public class StudentDAO {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// save student
	@Transactional
	public int insert(Student student) {
		// insert
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

	// get the single data(object)
	public Student getStudent(int studentId) {
		Student student = (Student) this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}

	// get all students(all rows)
	public List<Student> getAllStudents() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}

	// deleting the data
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = (Student) this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}

	// updating data...
	@Transactional
	public void updateStudent(Student s) {
		this.hibernateTemplate.update(s);
	}

}
