package com.learn.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * auth:hjd
 */
public class SqlSessionFactoryUtils {
    /**
     *  SqlSessionFactory Object
     */
    private static SqlSessionFactory sqlSessionFactory = null;
    /**
     *  class thread lock
     */
    private static final Class CLASS_LOCK = SqlSessionFactory.class;
    /**
     * privtae construct
     */
    private SqlSessionFactoryUtils() {}
    /**
     * create SqlSessionFactory
     */
    public static SqlSessionFactory initSqlsessionFactory() {
        String source = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(source);
        } catch (IOException ex) {
            Logger.getLogger(SqlSessionFactoryUtils.class.getName()).log(Level.SEVERE,null,ex);
        }
        synchronized (CLASS_LOCK){
            if(sqlSessionFactory == null)
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        return sqlSessionFactory;
    }
    /**
     * open sqlsession
     */
    public static SqlSession openSqlSession(){
        if(sqlSessionFactory == null)
            initSqlsessionFactory();
        return sqlSessionFactory.openSession();
    }
}
