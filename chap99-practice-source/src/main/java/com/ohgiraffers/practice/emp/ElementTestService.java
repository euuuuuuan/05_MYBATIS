package com.ohgiraffers.practice.emp;

import com.ohgiraffers.common.EmpDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementTestService {

    private ElementTestMapper mapper;

    public void associationTest() {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<EmpDTO> empList = mapper.associationTest();

        for (EmpDTO emp : empList) {
            System.out.println(emp);
        }
        sqlSession.close();

    }

    public void collectionTest() {

    }
}
