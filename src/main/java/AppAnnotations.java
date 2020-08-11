import mapper.StudentMapper;
import model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class AppAnnotations {

    public static void main(String[] args) throws IOException {
        var reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        var sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        var session = sqlSessionFactory.openSession();
        session.getConfiguration().addMapper(StudentMapper.class);
        var studentMapper = session.getMapper(StudentMapper.class);

        //Create a new student object
        Student student = new Student(
                "zara",
                "eee",
                90,
                123412341,
                "zara@gmail.com"
        );

        System.out.println(student);

        //Insert student data
        studentMapper.insert(student);
        System.out.println("record inserted successfully");
        System.out.println(student);
        session.commit();
        session.close();
    }
}
