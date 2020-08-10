import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class AppSelectAll {

    public static void main(String[] args) throws IOException {
        var reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        var sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        var session = sqlSessionFactory.openSession();

        //select contact all contacts
        var students = session.selectList("Student.getAll");

        students.forEach(System.out::println);

        System.out.println("Records Read Successfully ");
        session.commit();
        session.close();
    }
}
