package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelFile {
	public static void main(String[] args) throws Throwable {
		// Step1:-path connection
		FileInputStream fis = new FileInputStream("./src/test/resources/textData.xlsx");

		// step2:- keeps the workbook/excelfile in read mode
		Workbook book = WorkbookFactory.create(fis);

		// step3:- Navigating expected sheet
		Sheet sheet = book.getSheet("Sheet1");

		// step4:-Navigating expected row---->row value starts from 0
		Row row = sheet.getRow(4);
	

		// step5:- Navigating expected cell---->cell value starts from 0
		Cell cell = row.getCell(1);
		
		DataFormatter format= new DataFormatter();
		String excelData = format.formatCellValue(cell);
	
		System.out.println(excelData);

	}

}
