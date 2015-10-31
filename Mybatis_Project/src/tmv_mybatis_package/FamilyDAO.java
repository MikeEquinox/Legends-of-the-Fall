package tmv_mybatis_package;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author teleginmv
 * DAO
 */ 

/*
MyBatis utility class to get SqlSessionFactory. 
Using SqlSession.getMapper(), we retrieve mapper interface
implementation by MyBatis and call the methods declared
in interface as given in DAO class.
*/

public class FamilyDAO {

	private static SqlSessionFactory sqlSessionFactory;
	
	public void insertFamily(Family family) {
		  SqlSession session = getSqlSessionFactory().openSession();	
		  FamilyMapper mapper = session.getMapper(FamilyMapper.class);
		  mapper.insertFamily(family);
		  session.commit();
		  session.close();
		}
		public void updateFamily(Family family) {
		  SqlSession session = getSqlSessionFactory().openSession();	
		  FamilyMapper mapper = session.getMapper(FamilyMapper.class);
		  mapper.updateFamily(family);
		  session.commit();
		  session.close();
		}
		public void deleteFamily(String name) {
		  SqlSession session = getSqlSessionFactory().openSession();	
		  FamilyMapper mapper = session.getMapper(FamilyMapper.class);
		  mapper.deleteFamily(name);
		  session.commit();
		  session.close();
		}
		public Family getName(String name) {
		  SqlSession session = getSqlSessionFactory().openSession();	
		  FamilyMapper mapper = session.getMapper(FamilyMapper.class);
		  Family family = mapper.getName(name);
		  session.close();
		  return family;
		}
		
		public List<Family> getFamily() {
			 SqlSession session = getSqlSessionFactory().openSession();	
			  FamilyMapper mapper = session.getMapper(FamilyMapper.class);
			  List<Family> familyList = mapper.getFamily();
			  session.close();
			  return familyList;
		}
		
		
		
		public SqlSessionFactory getSqlSessionFactory() {
		try {
			Reader resourceReader = Resources.getResourceAsReader("tmv_mybatis_package/config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceReader);
			
			sqlSessionFactory.getConfiguration().addMapper(FamilyMapper.class);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
		}
}
