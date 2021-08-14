package org.stackroute.jdbc.Doa;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.stackroute.jdbc.entity.Student;

public class RowMapperImpl implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student stud = new Student();
		stud.setId(rs.getInt(1));
		stud.setName(rs.getString(2));
		stud.setCity(rs.getString(3));
		return stud;
	}
	

}
