package mapper;

import model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {

    @Select("SELECT * FROM STUDENT")
    List<Student> getAll();

    @Select("SELECT * FROM STUDENT WHERE ID = #{id}")
    Student getById(int id);

    @Update("UPDATE STUDENT SET EMAIL = #{email}, NAME = #{name}, BRANCH = #{branch}, PERCENTAGE = #{percentage}, PHONE = #{phone} WHERE ID = #{id}")
    void update(Student student);

    @Delete("DELETE from STUDENT WHERE ID = #{id}")
    void delete(int id);

    @Insert("INSERT INTO STUDENT (NAME, BRANCH, PERCENTAGE, PHONE, EMAIL ) VALUES (#{name}, #{branch}, #{percentage}, #{phone}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Student student);
}
