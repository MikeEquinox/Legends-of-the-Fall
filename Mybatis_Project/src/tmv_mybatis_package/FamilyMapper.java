package tmv_mybatis_package;

/**
 * @author teleginmv
 * Mapper
 */ 

/*In MyBatis annotation, we use interface and declare our methods
for database query . The required input in query are passed
as an argument in method. If we pass POJO as argument, 
MyBatis will retrieve properties name and its value required
for query input. 
*/

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FamilyMapper {

	@Results({
        @Result(property = "name", column = "FirstName"),
        @Result(property = "year", column = "Year"),
        @Result(property = "height", column = "Height"),
        @Result(property = "weight", column = "Weight")
      })
	@Select("SELECT * FROM Family WHERE FirstName = #{name}")
	Family getName(String name);
	
	@Results({
		@Result(property = "name", column = "FirstName"),
		@Result(property = "year", column = "Year"),
		@Result(property = "height", column = "Height"),
		@Result(property = "weight", column = "Weight")
	})
	@Select("SELECT * FROM Family")
	List<Family> getFamily();
	
	@Insert("INSERT into Family(FirstName, Year, Height, Weight) VALUES(#{name}, #{year}, #{height}, #{weight})")
	void insertFamily(Family family);
	
	@Update("UPDATE Family SET FirstName=#{name}, Year =#{year}, Height =#{height}, Weight =#{weight} WHERE FirstName =#{name}")
	void updateFamily(Family family);
	
	@Delete("DELETE FROM Family WHERE FirstName =#{name}")
	void deleteFamily(String name);

	
}
