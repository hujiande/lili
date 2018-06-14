package test;

import com.learn.chapter2.mapper.RoleMapper;
import com.learn.chapter2.po.Role;
import com.learn.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class MyBatisTest_chapter2 {

    @Test
    public void test(){
        SqlSession sqlSession = null;
        try {
            sqlSession =  SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setNote("测试插入");
            role.setRoleName("后管");
            roleMapper.insertRole(role);
//            roleMapper.delRole(4);
            sqlSession.commit();
        }catch (Exception ex){
            sqlSession.rollback();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }


    }
}
