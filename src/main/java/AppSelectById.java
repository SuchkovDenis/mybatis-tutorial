import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class AppSelectById {

    public static void main(String[] args) throws IOException {
        var reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        var sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        var session = sqlSessionFactory.openSession();

        //select a particular student  by  id
        var student = session.selectOne("Student.getById", 1);

        System.out.println(student);

        System.out.println("Record Read Successfully");
        session.commit();
        session.close();
    }
}
