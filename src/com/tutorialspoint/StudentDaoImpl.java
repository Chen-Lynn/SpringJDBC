package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private String SQL;
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource=ds;
		this.jdbcTemplateObject=new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String name, Integer age) {
		SQL="insert into Student(name, age) value(?,?)";
		jdbcTemplateObject.update(SQL, name, age);
		System.out.println("Create record Name="+name+" Age="+age);
		return;
	}

	@Override
	public Student getStudent(Integer id) {
		SQL="select * from student where id=?";
		Student student=jdbcTemplateObject.queryForObject(SQL, new Object[] {id}, new StudentMapper());
		//Student student=jdbcTemplateObject.query(SQL,new StudentMapper());
		return student;
	}

	@Override
	public List<Student> listStudents() {
		SQL="select * from student";
		List<Student> students=jdbcTemplateObject.query(SQL,new StudentMapper());
		return students;
	}

	@Override
	public void delete(Integer id) {
		SQL="delete from student where id=?";
		jdbcTemplateObject.update(SQL,id);
		System.out.println("Deleted record with ID="+id);
		return;
	}

	@Override
	public void update(Integer id, Integer age) {
	    SQL="update student set age=? where id=?";
	    jdbcTemplateObject.update(SQL,age,id);
	    System.out.println("Updated record with ID="+id+" Age="+age);
	    return;
	}

}
