package com.orangehrm.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	private XSSFWorkbook book;
	private XSSFSheet sheet;

	public ReadData(String filename, String sheetname) throws Throwable {
		String filepath = ".\\src\\test\\resources\\testdata\\" + filename + ".xlsx";
		FileInputStream instream = new FileInputStream(filepath);
		book = new XSSFWorkbook(instream);
		sheet = book.getSheet(sheetname);
	}

	public String getExcelSheetCellDada(int row, int cell) throws Throwable {

		return sheet.getRow(row).getCell(cell).getStringCellValue();
	}

	public List<String> getExcelSheetRowDada(int row) throws Throwable {
		int cells = sheet.getRow(row).getLastCellNum();
		List<String> fullRowData = new ArrayList<>();
		for (int i = 0; i < cells; i++) {
			String celldata = sheet.getRow(row).getCell(i).getStringCellValue();
			fullRowData.add(celldata);
		}
		return fullRowData;
	}

	public String[][] getExcelSheetFullDada() throws Throwable {
		int rows = sheet.getLastRowNum();
		int cells = sheet.getRow(0).getLastCellNum();

		String info[][] = new String[rows][cells];

		int k = 0, l;

		for (int i = 1; i <= rows; i++) {
			l = 0;
			for (int j = 0; j < cells; j++) {
				// System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
				info[k][l++] = sheet.getRow(i).getCell(j).getStringCellValue();

			}

			k++;

		}
		return info;

	}

	public List<String> getExcelSheetColumnDada(String colname) throws Throwable {

		int cells = sheet.getRow(0).getLastCellNum();
		List<String> firstRowdata = new ArrayList<>();

		int columnIndex = 0;
		for (int i = 0; i < cells; i++) {
			String data = sheet.getRow(0).getCell(i).getStringCellValue();
			firstRowdata.add(data);

			if (data.equals(colname)) {
				columnIndex = firstRowdata.indexOf(colname);
			}
		}
		System.out.println("columnIndex = " + columnIndex);

		List<String> fullColdata = new ArrayList<>();
		int totalRows = sheet.getLastRowNum();
		for (int i = 1; i <= totalRows; i++) {
			String colsdata = sheet.getRow(i).getCell(columnIndex).getStringCellValue();
			// System.out.println(colsdata);
			fullColdata.add(colsdata);
		}
		System.out.println("Top Hedding Data :" + firstRowdata);
		System.out.println("Full Column Data : " + fullColdata);

		return fullColdata;

	}
}
