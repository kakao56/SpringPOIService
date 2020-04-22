package com.mvc.poi.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Service;

import com.mvc.poi.dao.ExcelDao;
import com.mvc.poi.service.ExcelService;
import com.mvc.poi.vo.EmpVO;

@Service("excelService")
public class ExcelServiceImpl implements ExcelService {

	@Resource(name = "excelDao")
	private ExcelDao excelDao;

	@Override
	public void downEmpList(HttpServletResponse response) {

		List<EmpVO> empList = excelDao.getEmpList();

		SXSSFWorkbook wb = new SXSSFWorkbook();
		SXSSFSheet sheet = wb.createSheet("empList");
		wb.setCompressTempFiles(true); // 임시파일(gb) 압축해서 메모리 아끼기 (성능 저하)

		sheet.trackAllColumnsForAutoSizing();

		Row row = null;
		Cell cell = null;
		int rowCount = 0;
		int cellCount = 0;

		CellStyle headStyle = wb.createCellStyle();
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);
		headStyle.setFillForegroundColor(HSSFColorPredefined.GREY_25_PERCENT.getIndex());
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headStyle.setAlignment(HorizontalAlignment.CENTER);

		CellStyle strBodyStyle = wb.createCellStyle();
		strBodyStyle.setBorderTop(BorderStyle.THIN);
		strBodyStyle.setBorderBottom(BorderStyle.THIN);
		strBodyStyle.setBorderLeft(BorderStyle.THIN);
		strBodyStyle.setBorderRight(BorderStyle.THIN);

		// head Cell 생성

		row = sheet.createRow(rowCount++);

		cell = row.createCell(cellCount++);
		cell.setCellStyle(headStyle);
		cell.setCellValue("EMPNO");

		cell = row.createCell(cellCount++);
		cell.setCellStyle(headStyle);
		cell.setCellValue("ENAME");

		cell = row.createCell(cellCount++);
		cell.setCellStyle(headStyle);
		cell.setCellValue("JOB");

		cell = row.createCell(cellCount++);
		cell.setCellStyle(headStyle);
		cell.setCellValue("MGR");

		cell = row.createCell(cellCount++);
		cell.setCellStyle(headStyle);
		cell.setCellValue("HIREDATE");

		cell = row.createCell(cellCount++);
		cell.setCellStyle(headStyle);
		cell.setCellValue("SAL");

		cell = row.createCell(cellCount++);
		cell.setCellStyle(headStyle);
		cell.setCellValue("COMM");

		cell = row.createCell(cellCount++);
		cell.setCellStyle(headStyle);
		cell.setCellValue("DEPTNO");

		for (int i = 0; i < cellCount; i++) {// head 가로폭 자동

			sheet.autoSizeColumn(i);
			sheet.setColumnWidth(i, (sheet.getColumnWidth(i)) + 512);

		}

		sheet.untrackAllColumnsForAutoSizing();

		// 데이터 Cell 생성
		for (EmpVO emp : empList) {
			row = sheet.createRow(rowCount++);
			cellCount = 0;

			cell = row.createCell(cellCount++);
			cell.setCellValue(emp.getEMPNO());
			cell.setCellStyle(strBodyStyle);

			cell = row.createCell(cellCount++);
			cell.setCellValue(emp.getENAME());
			cell.setCellStyle(strBodyStyle);

			cell = row.createCell(cellCount++);
			cell.setCellValue(emp.getJOB());
			cell.setCellStyle(strBodyStyle);

			cell = row.createCell(cellCount++);
			cell.setCellValue(emp.getMGR());
			cell.setCellStyle(strBodyStyle);

			cell = row.createCell(cellCount++);
			cell.setCellValue(emp.getHIREDATE());
			cell.setCellStyle(strBodyStyle);

			cell = row.createCell(cellCount++);
			cell.setCellValue(emp.getSAL());
			cell.setCellStyle(strBodyStyle);

			cell = row.createCell(cellCount++);
			cell.setCellValue(emp.getCOMM());
			cell.setCellStyle(strBodyStyle);

			cell = row.createCell(cellCount++);
			cell.setCellValue(emp.getDEPTNO());
			cell.setCellStyle(strBodyStyle);

		}

		response.setHeader("Content-disposition", "attachment; filename= empTest.xlsx");
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

		try {

			ServletOutputStream out = response.getOutputStream();
			out.flush();
			wb.write(out);
			out.flush();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			if (wb != null) {
				wb.dispose();
			}
			
		}

	}

	@Override
	public void upEmpList(HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Workbook wb = null;
		List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
		
		try {

			wb = WorkbookFactory.create(new FileInputStream("C:\\Users\\KIM\\Downloads\\empTest.xlsx"));
			
			Sheet sheet = wb.getSheetAt(0);
			int a = sheet.getLastRowNum();
			int b = sheet.getRow(0).getLastCellNum();

			List<String> keyList = new ArrayList<String>();
			
			for (int i = 0; i < b; i++) {
				
				keyList.add((sheet.getRow(0).getCell(i)) == null ? null: sheet.getRow(0).getCell(i).toString());
			}
			
			for (int i = 1; i < a+1; i++) {
				
				Map<String, String> data = new HashMap<String, String>();
				
				for (int j = 0; j < b; j++) {
					
					data.put(keyList.get(j), (sheet.getRow(i).getCell(j)) == null ? null: sheet.getRow(i).getCell(j).toString());
					
				}
			
				dataList.add(data);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			if(wb != null) {
				try {
					wb.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		}
		
		excelDao.insertEmpList(dataList);
		
	}
}
