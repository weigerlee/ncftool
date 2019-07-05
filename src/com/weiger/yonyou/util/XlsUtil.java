package com.weiger.yonyou.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.weiger.yonyou.vo.SprInfo;
import com.weiger.yonyou.vo.XLSRecord;

public class XlsUtil {
	
	
	private static final String EXCEL_XLS = "xls";  
	private static final String EXCEL_XLSX = "xlsx";  
	
	public void writeFile(String fileUrl,int sheetIndex,int rowIndex,int colIndex,double valus) {
		XSSFWorkbook wb = null;
		InputStream ifs = null;
		OutputStream ofs = null;
		String filePath = fileUrl;
		try {
			// 设置要读取的文件路径
			ifs = new FileInputStream(filePath);
			// HSSFWorkbook相当于一个excel文件，HSSFWorkbook是解析excel2007之前的版本（xls）
			// 之后版本使用XSSFWorkbook（xlsx）
			wb = new XSSFWorkbook(ifs);

			// 获得sheet工作簿HSSFSheet
			XSSFSheet sheet = wb.getSheetAt(sheetIndex);
			// 获得行HSSFRow
			XSSFRow row = sheet.getRow(2);
			// 获得行中的列，即单元格HSSFCell
			XSSFCell cell = row.getCell(12);
			// 获得单元格中的值
			double msg = cell.getNumericCellValue();
			System.out.println(msg);

			row = sheet.getRow(rowIndex);
			if (row == null) {
				row = sheet.createRow(colIndex);
			}

			cell = row.getCell(colIndex);
			if (cell == null) {
				cell = row.createCell(1);
			}
			cell.setCellValue(valus);
			ofs = new FileOutputStream(filePath);
			wb.write(ofs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public XLSRecord readFile(String url,int sheetIndex,int rowIndex) {
		
		
		ArrayList<String> columnList = new ArrayList<String>();
		
		try {
			
			File file = new File(url);
			FileInputStream in = new FileInputStream(file);
			
			XSSFWorkbook wb = new XSSFWorkbook(in);
			
			Sheet sheet = wb.getSheetAt(sheetIndex); //取得“测试.xlsx”中的第一个表单
			
			int firstRowNum = sheet.getFirstRowNum();
			int lastRowNum = sheet.getLastRowNum();
			
			XLSRecord rd=new XLSRecord();
			rd.setRow(rowIndex);
			
			
			Row row = null;
			Cell cell_a = null;
			
			row = sheet.getRow(rowIndex);//取得第i行 （从第二行开始取，因为第一行是表头）
			
			cell_a = row.getCell(2);//取得i行的第一列
			rd.setAppName(cell_a.getStringCellValue());
			
			cell_a = row.getCell(3);//取得i行的第一列
			rd.setBusiAction(cell_a.getStringCellValue());
			cell_a = row.getCell(11);//取得i行的第一列
			double cellValue = cell_a.getNumericCellValue();
			rd.setValue_2d(cellValue);
			cell_a = row.getCell(12);//取得i行的第一列
			double cellValue3 = cell_a.getNumericCellValue();
			rd.setValue_3d(cellValue3);
			return rd;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
	
	public void writeFileLL(String fileUrl,int sheetIndex,int rowIndex,SprInfo info) {
		XSSFWorkbook wb = null;
		InputStream ifs = null;
		OutputStream ofs = null;
		String filePath = fileUrl;
		try {
			// 设置要读取的文件路径
			ifs = new FileInputStream(filePath);
			// HSSFWorkbook相当于一个excel文件，HSSFWorkbook是解析excel2007之前的版本（xls）
			// 之后版本使用XSSFWorkbook（xlsx）
			wb = new XSSFWorkbook(ifs);

			// 获得sheet工作簿HSSFSheet
			XSSFSheet sheet = wb.getSheetAt(sheetIndex);
			// 获得行HSSFRow
			XSSFRow row = sheet.getRow(rowIndex);
			// 获得行中的列，即单元格HSSFCell
			XSSFCell cell = row.getCell(8);
			cell.setCellValue(info.getDownloadByte());
			
			 cell = row.getCell(9);
			cell.setCellValue(info.getUploadByte());
			
			 cell = row.getCell(10);
				cell.setCellValue(info.getConsCount());
				 cell = row.getCell(11);
					cell.setCellValue(info.getSqlsCount());
					
					
					 cell = row.getCell(12);
					cell.setCellValue(info.getDownloadByte3d());
					
					 cell = row.getCell(13);
					cell.setCellValue(info.getUploadByte3d());
					
					 cell = row.getCell(14);
						cell.setCellValue(info.getConsCount3d());
						 cell = row.getCell(15);
							cell.setCellValue(info.getSqlsCount3d());
			
			
			ofs = new FileOutputStream(filePath);
			wb.write(ofs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<SprInfo> readFileAllre(String url,int sheetIndex,int beginrow) {
		
		
		ArrayList<String> columnList = new ArrayList<String>();
		
		try {
			
			File file = new File(url);
			FileInputStream in = new FileInputStream(file);
			
			XSSFWorkbook wb = new XSSFWorkbook(in);
			
			Sheet sheet = wb.getSheetAt(sheetIndex); //取得“测试.xlsx”中的第一个表单
			
			int firstRowNum = sheet.getFirstRowNum();
			int lastRowNum = sheet.getLastRowNum();
			
			List<SprInfo> list =new ArrayList<SprInfo>();
			
			for(int i = beginrow;i<lastRowNum;i++) {
				
				SprInfo sprInfo =new SprInfo();
				Row row = sheet.getRow(i);
				
				sprInfo.setRowNo(i);
				
				Cell cell_a = row.getCell(2);//取得i行的第一列
				sprInfo.setAppcode(cell_a.getStringCellValue());
				
				Cell cell_b = row.getCell(3);//取得i行的第一列
				sprInfo.setActionName(cell_b.getStringCellValue());
				
//				Cell cell_c = row.getCell(8);//取得i行的第一列
//				sprInfo.setDownloadByte(cell_a.getNumericCellValue());
//				
//				Cell cell_d = row.getCell(9);//取得i行的第一列
//				sprInfo.setUploadByte(cell_a.getNumericCellValue());
//				Cell cell_e = row.getCell(10);//取得i行的第一列
//				sprInfo.setSqlsCount(cell_a.getNumericCellValue());
//				Cell cell_f = row.getCell(11);//取得i行的第一列
//				sprInfo.setConsCount(cell_a.getNumericCellValue());
				list.add(sprInfo);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XlsUtil tr = new XlsUtil();
		// tr.readFile();
		//tr.writeFile();
		
		//System.out.println(tr.readFile("D:\\单点效率验证报告.xlsx",4,2,11));
	}
}
