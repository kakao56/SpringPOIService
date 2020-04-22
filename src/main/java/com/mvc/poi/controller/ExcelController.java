package com.mvc.poi.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.poi.service.ExcelService;

@Controller
public class ExcelController {

	@Resource(name="excelService")
	private ExcelService excelService;
	
	@RequestMapping("/excelDownload")
    public void excelDownload(Map<String, Object> model, HttpServletResponse response) throws Exception{
        
        excelService.downEmpList(response);         
 
    }
	@RequestMapping("/excelUpload")
	public void excelUpload(Map<String, Object> model, HttpServletResponse response) throws Exception{
		
		excelService.upEmpList(response);         
		
	}
}
