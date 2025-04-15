package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataIntoExcelFile {
	public static void main(String[] args) throws Throwable {
		// Step1:-path connection
		FileInputStream fis = new FileInputStream("./src/test/resources/textData.xlsx");

		// step2:- keeps the workbook/excelfile in read mode
		Workbook book = WorkbookFactory.create(fis);

		// step3:- Navigating expected sheet
		Sheet sheet = book.getSheet("Sheet1");

		// step4:-Navigating expected row---->row value starts from 0
		Row row = sheet.createRow(4);
	

		// step5:- Navigating expected cell---->cell value starts from 0
		Cell cell = row.createCell(5);
		cell.setCellValue("Shaima");
		FileOutputStream fos=new FileOutputStream("./src/test/resources/textData.xlsx");
		book.write(fos);
		book.close();
	}

}
