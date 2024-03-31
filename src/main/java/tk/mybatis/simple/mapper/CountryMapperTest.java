package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;
import tk.mybatis.simple.model.Country;

import java.util.List;

/**
 * @author Jodav
 *
 */
public class CountryMapperTest extends BaseMapperTest {

    @Test
    public void testSelectAll() {
        try (SqlSession sqlSession = getSqlSession()) {
            List<Country> countryList = sqlSession.selectList(
                    "selectAll");
            printCountryList(countryList);
        } catch (Exception e) {
            System.out.println("这是一个不能");
        }
    }

    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n",
                    country.getId(),
                    country.getCountryName(),
                    country.getCountryCode());

        }
    }

}
