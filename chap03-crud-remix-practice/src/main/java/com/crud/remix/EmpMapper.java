package com.crud.remix;

import java.util.List;

public interface EmpMapper {
    List<EmpDTO> selectAllEmp();


    EmpDTO selectEmpByCode(int code);

    EmpDTO selectEmpByName(String name);

    int registEmp(EmpDTO emp);

    int modifyEmp(EmpDTO emp);

    int deleteEmp(int code);
}
