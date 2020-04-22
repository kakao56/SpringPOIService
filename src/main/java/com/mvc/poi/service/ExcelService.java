package com.mvc.poi.service;

import javax.servlet.http.HttpServletResponse;

public interface ExcelService {

	void downEmpList(HttpServletResponse response);

	void upEmpList(HttpServletResponse response);

}
