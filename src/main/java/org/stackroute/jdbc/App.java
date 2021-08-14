package org.stackroute.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.stackroute.jdbc.Doa.StudentDao;
import org.stackroute.jdbc.entity.Student;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(javaConfig.class);
        
        StudentDao studentdao = (StudentDao) context.getBean("studentDao");
        
      //insert data
    	Student stud = new Student();
    	stud.setId(013);
    	stud.setName("Bat-man");
    	stud.setCity("WashingtonDC");
    	
    	int r = studentdao.insert(stud);
    	if(r>0) {
    		System.out.println("Added"+r);    		
    	}
    }
}
