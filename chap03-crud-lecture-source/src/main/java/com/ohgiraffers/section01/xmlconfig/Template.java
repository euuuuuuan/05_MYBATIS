package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {

        if(sqlSessionFactory == null) {

            String resource = "com/ohgiraffers/section01/xmlconfig/mybatis-config.xml";
        }
    }
}
