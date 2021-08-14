package org.stackroute.jdbc.Doa;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.stackroute.jdbc.entity.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		String query = "insert into student(id,name,city) value(?,?,?)";
		int res = this.jdbcTemplate.update(query, student.getId() ,student.getName(),student.getCity());
		return res;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int update(Student student) {
		// update query
		String query = "update student set name =? , city =? where id =?";
		int res = this.jdbcTemplate.update(query , student.getName(),student.getCity(),student.getId());
		return res;
	}

	public int delete(int studentId) {
		// delete query
		String query = "delete from student where id=?";
		int res = this.jdbcTemplate.update(query , studentId);
		return res;
	}

	public Student getStudent(int studentId) {
		// selecting single data
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}
	

}
