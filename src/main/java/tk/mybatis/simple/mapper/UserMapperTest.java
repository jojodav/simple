package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById(){
        SqlSession sqlSession=getSqlSession();

        try{
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

            SysUser user=userMapper.selectById(1L);
            Assert.assertNotNull(user);
            Assert.assertEquals("admin",user.getUserName());
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void testSelectAll(){
        SqlSession sqlSession=getSqlSession();

        try{
            UserMapper userMappers=sqlSession.getMapper(UserMapper.class);

            List<SysUser> userList= userMappers.selectAll();
            Assert.assertNotNull(userList);
            Assert.assertTrue(userList.size()>0);
        }finally {
            sqlSession.close();
        }
    }
}