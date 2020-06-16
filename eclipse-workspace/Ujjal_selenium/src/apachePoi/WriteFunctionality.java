package apachePoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteFunctionality {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = null;
		try {
			File src= new File("C:\\Users\\Sujjal\\Desktop\\ApachePoi\\Practice2.xlsx");
			FileInputStream fis= new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet1=workbook.getSheetAt(0);
			
			sheet1.getRow(0).createCell(3).setCellValue("Relation");
			 sheet1.getRow(1).createCell(3).setCellValue("Myself");
			 sheet1.getRow(2).createCell(3).setCellValue("No one");
			 sheet1.getRow(3).createCell(3).setCellValue("Friend");
			 sheet1.getRow(4).createCell(3).setCellValue("Mad Friend");
			 
			 FileOutputStream fos= new FileOutputStream(new File("C:\\Users\\Sujjal\\Desktop\\ApachePoi\\Practice2.xlsx"));
			 workbook.write(fos);
			 fos.close();
			 
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
		
		workbook.close();

	}

}
