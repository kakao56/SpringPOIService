package com.mvc.poi.dao;

import java.util.List;
import java.util.Map;

import com.mvc.poi.vo.EmpVO;

public interface ExcelDao {

	List<EmpVO> getEmpList();

	void insertEmpList(List<Map<String, String>> dataList);

}
