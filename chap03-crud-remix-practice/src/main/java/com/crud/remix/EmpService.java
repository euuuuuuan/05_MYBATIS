package com.crud.remix;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.crud.remix.Template.getSqlSession;

public class EmpService {
    private EmpMapper empMapper;

    public List<EmpDTO> sellectAllEmp() {
        SqlSession sqlSession = getSqlSession();

        empMapper = sqlSession.getMapper(EmpMapper.class);
        /* .class : 클래스 리터럴은 클래스를 식별하는 데 사용되며,
         클래스의 메타데이터를 얻거나 클래스 타입을 나타내는 데 사용*/
        List<EmpDTO> empList = empMapper.selectAllEmp();

        sqlSession.close();

        return empList;
    }

    public EmpDTO selectEmpByCode(int code) {
        SqlSession sqlSession = getSqlSession();
        empMapper = sqlSession.getMapper(EmpMapper.class);
        EmpDTO emp = empMapper.selectEmpByCode(code);
        sqlSession.close();

        return emp;
    }

    public EmpDTO selectEmpByName(String name) {
        SqlSession sqlSession = getSqlSession();
        empMapper = sqlSession.getMapper(EmpMapper.class);
        EmpDTO emp = empMapper.selectEmpByName(name);
        sqlSession.close();

        return emp;
    }

    public boolean registEmp(EmpDTO emp) {
        SqlSession sqlSession = getSqlSession();
        empMapper = sqlSession.getMapper(EmpMapper.class);
        int result = empMapper.registEmp(emp);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true : false;

    }

    public boolean modifyEmp(EmpDTO emp) {
        SqlSession sqlSession = getSqlSession();
        empMapper = sqlSession.getMapper(EmpMapper.class);
        int result = empMapper.modifyEmp(emp);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true : false;
    }

    public boolean deleteEmp(int code) {
        SqlSession sqlSession = getSqlSession();

        empMapper = sqlSession.getMapper(EmpMapper.class);
        int result = empMapper.deleteEmp(code);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0 ? true : false;
    }
}
