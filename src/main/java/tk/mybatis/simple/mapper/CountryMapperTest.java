package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;
import tk.mybatis.simple.model.Country;

import java.util.List;

public class CountryMapperTest extends BaseMapperTest {

    @Test
    public void testSelectAll(){
        SqlSession sqlSession=getSqlSession();
        try{
            List<Country> countryList=sqlSession.selectList(
                    "tk.mybatis.simple.mapper.countryMapper.selectAll");
            printCountryList(countryList);
        }finally {
            sqlSession.close() ;
        }
    }

    private void printCountryList(List<Country> countryList){
        for (Country country: countryList) {
             System.out.printf("%-4d%4s%4s\n",
                     country.getId(),
                     country.getCountryName(),
                     country.getCountryCode());

        }
    }

}
