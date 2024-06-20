package com.crud.remix;

import java.util.List;

public interface EmpMapper {
    List<EmpDTO> selectAllEmp();


    EmpDTO selectEmpByCode(int code);
}
