package com.tutorialspoint;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.*;

public class StudentMapper implements RowMapper<Student>{
  public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
	  Student stu=new Student();
	  stu.setAge(rs.getInt("age"));
	  stu.setId(rs.getInt("id"));
	  stu.setName(rs.getString("name"));
	  return stu;  
	  
}
}