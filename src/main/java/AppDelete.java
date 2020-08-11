import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class AppDelete {

    public static void main(String[] args) throws IOException {
        var reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        var sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        var session = sqlSessionFactory.openSession();

        //Delete operation
        session.delete("Student.deleteById", 2);
        System.out.println("Record deleted successfully");
        session.commit();
        session.close();
    }
}
