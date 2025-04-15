package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchDataFromPdfFile {
	public static void main(String[] args) throws Throwable {
		File file = new File("./src/test/resources/pdfdata.pdf");
		PDDocument doc = PDDocument.load(file);

		// pagecount
		int pages = doc.getNumberOfPages();
		System.out.println(pages);

		// Read COntent
		PDFTextStripper pdfData = new PDFTextStripper();
		// String Data = pdfData.getText(doc);
		// System.out.println(Data);

		pdfData.setStartPage(4);
		String pageData = pdfData.getText(doc);
		System.out.println(pageData);

		/*
		 * pdfData.setStartPage(2); pdfData.setEndPage(3); String pageData =
		 * pdfData.getText(doc); System.out.println(pageData);
		 */
	}
}
