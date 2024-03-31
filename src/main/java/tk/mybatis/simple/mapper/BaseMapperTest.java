package tk.mybatis.simple.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.BeforeClass;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class BaseMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    public SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) throws ScriptException {
        int x =10;

//        String sta0= "11";
//        System.out.println("直接数字转换: " + Integer.valueOf(sta0)); // 可直接数字
//
//        String sta = x + " + " + x + " + 11";
//        String sta1 = "11+11";

//        ScriptEngineManager mgr = new ScriptEngineManager();
//        ScriptEngine engine = mgr.getEngineByName("javascript");
//        String foo ="40+2";
//        System.out.println(engine.eval(foo));
        String str="10.125";
        String regex = "\\d{0,-1}\\.\\d{0,3}";

//        Integer.parseInt("1s");
        System.out.println(str.matches(regex));
    }

//
//        System.out.println("sta: " + Integer.parseInt(String.valueOf(11+11)));
//        System.out.println("sta1: " + Integer.getInteger(sta1));
//        System.out.println("valueOf sta1: " + Integer.valueOf(sta1));

//        Boolean b = Boolean.valueOf(sta);



//        List<String> list = new ArrayList<>();
//
//        List<String> sub = new ArrayList<String>();
//        sub=null;
//
//        list.addAll(sub);
//
//        System.out.println(list);
    }