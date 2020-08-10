import model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class AppInsert {

    public static void main(String[] args) throws IOException {
        var reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        var sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        var session = sqlSessionFactory.openSession();

        //Create a new student object
        Student student = new Student(
                "Mohammad",
                "It",
                80,
                984803322,
                "Mohammad@gmail.com"
        );

        System.out.println(student);

        //Insert student data
        session.insert("Student.insert", student);
        System.out.println("record inserted successfully");
        System.out.println(student);
        session.commit();
        session.close();
    }
}
