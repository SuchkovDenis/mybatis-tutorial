import model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class AppUpdate {

    public static void main(String[] args) throws IOException {
        var reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        var sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        var session = sqlSessionFactory.openSession();

        //select a particular student  by  id
        Student student = session.selectOne("Student.getById", 1);
        System.out.println(student);
        System.out.println("Record Read Successfully");

        //Set new values to the mail and phone number of the student
        student.setEmail("mohamad123@yahoo.com");
        student.setPhone(12345);

        //Update the student record
        session.update("Student.update",student);
        System.out.println("Record updated successfully");
        session.commit();

        //verifying the record
        Student std = session.selectOne("Student.getById", 1);
        System.out.println("Details of the student after update operation");
        System.out.println(std.toString());

        session.close();
    }
}
