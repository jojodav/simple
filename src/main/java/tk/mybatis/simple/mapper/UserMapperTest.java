package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.Date;
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

    @Test
    public void testSelectRolesByUserId(){
        SqlSession sqlSession=getSqlSession();

        try{
            UserMapper userMappers=sqlSession.getMapper(UserMapper.class);

            List<SysRole> roleList= userMappers.selectRolesByUserId(1L);
            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size()>0);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert(){
        SqlSession sqlSession=getSqlSession();

        try{
            UserMapper userMappers=sqlSession.getMapper(UserMapper.class);

            SysUser user=new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            //用一个任意的 byte【】代替图测试，正式的数据库当然要产生图
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            //插入完成后，返回的行数，只为后结的判断。
            int result=userMappers.insert(user);
            //只插入一条数据
            Assert.assertEquals(1,result);
            Assert.assertNull(user.getId());
        }finally {
            //为了不影响其它测试，这里选择回滚
            //由于默认的sqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2(){
        SqlSession sqlSession=getSqlSession();

        try{
            UserMapper userMappers=sqlSession.getMapper(UserMapper.class);

            SysUser user=new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            //用一个任意的 byte【】代替图测试，正式的数据库当然要产生图
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            //插入完成后，返回的行数，只为后结的判断。
            int result=userMappers.insert2(user);
            //只插入一条数据
            Assert.assertEquals(1,result);

            //由于 .xml 中使用使用useGeneratedKeys 获得 数据库新生成的ID,并赋值给 Id,所以这时id有值了
            Assert.assertNotNull(user.getId());
        }finally {
            //为了不影响其它测试，这里选择回滚
            //由于默认的sqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }


    @Test
    public void testInsert3(){
        SqlSession sqlSession=getSqlSession();

        try{
            UserMapper userMappers=sqlSession.getMapper(UserMapper.class);

            SysUser user=new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            //用一个任意的 byte【】代替图测试，正式的数据库当然要产生图
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            //插入完成后，返回的行数，只为后结的判断。
            int result=userMappers.insert3(user);
            //只插入一条数据
            Assert.assertEquals(1,result);

            //由于 .xml 中使用使用useGeneratedKeys 获得 数据库新生成的ID,并赋值给 Id,所以这时id有值了
            Assert.assertNotNull(user.getId());
        }finally {
            //为了不影响其它测试，这里选择回滚
            //由于默认的sqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testupdate(){
        SqlSession sqlSession=getSqlSession();

        try{
            UserMapper userMappers=sqlSession.getMapper(UserMapper.class);

            SysUser user=userMappers.selectById(1L);

            Assert.assertEquals("admin",user.getUserName());

            user.setUserName("admin_test");
            user.setUserEmail("test@mybatis.tk");

            //插入完成后，返回的行数，只为后结的判断。
            int result=userMappers.updateById(user);
            //只插入一条数据
            Assert.assertEquals(1,result);

            user=userMappers.selectById(1L);

            //由于 .xml 中使用使用useGeneratedKeys 获得 数据库新生成的ID,并赋值给 Id,所以这时id有值了
            Assert.assertEquals("admin_test",user.getUserName());
        }finally {
            //为了不影响其它测试，这里选择回滚
            //由于默认的sqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}