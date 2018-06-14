package test;

import com.learn.chapter3.enums.Sex;
import com.learn.chapter3.mapper.UserMapper;
import com.learn.chapter3.po.User;
import com.learn.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;


public class MyBatisTest_chapter3 {

    @Test
    public void test(){
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUseName("Ivy");
            user.setCnname("胡建德");
            user.setBirthday(new Date());
            user.setSex(Sex.MALE);
            user.setEmail("593595854@qq.com");
            user.setMobile("18225869578");
            user.setNote("是一个超级无敌大帅哥");
            userMapper.insertUser(user);
            sqlSession.commit();
        } catch (Exception ex){
            System.out.println(ex);
            sqlSession.rollback();
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
