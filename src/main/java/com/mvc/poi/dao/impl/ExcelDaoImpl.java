package com.mvc.poi.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.poi.dao.ExcelDao;
import com.mvc.poi.vo.EmpVO;

@Repository("excelDao")
public class ExcelDaoImpl implements ExcelDao{
	
	@Autowired
	SqlSessionTemplate sst;

	@Override
	public List<EmpVO> getEmpList() {
		// TODO Auto-generated method stub
		return sst.selectList("mapper.selectEmpList");
	}

	@Override
	public void insertEmpList(List<Map<String, String>> dataList) {
		// TODO Auto-generated method stub
		
		try {
				for (Map<String, String> data : dataList) {
					
					sst.insert("mapper.insertEmpList", data);
					
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
