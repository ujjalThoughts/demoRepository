package apachePoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;


public class Practice1 {
	
	public static void main(String[] args) throws IOException{
		
		XSSFWorkbook workbook = null;
		try {
			File src= new File("C:\\Users\\Sujjal\\Desktop\\ApachePoi\\Practice excel.xlsx");
			FileInputStream fis= new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet1=workbook.getSheetAt(0);
			
			 System.out.print(sheet1.getRow(0).getCell(0).getStringCellValue()+" ");
			 System.out.print(sheet1.getRow(0).getCell(1).getStringCellValue()+"   ");
			 System.out.println(sheet1.getRow(0).getCell(2).getStringCellValue());
			 
			 System.out.print(sheet1.getRow(1).getCell(0).getNumericCellValue()+" "+" ");
			 System.out.print(sheet1.getRow(1).getCell(1).getStringCellValue()+" "+" ");
			 System.out.println(sheet1.getRow(1).getCell(2).getStringCellValue());
			 
			 System.out.print(sheet1.getRow(2).getCell(0).getNumericCellValue()+" "+" ");
			 System.out.print(sheet1.getRow(2).getCell(1).getStringCellValue()+" "+" ");
			 System.out.println(sheet1.getRow(2).getCell(2).getStringCellValue());
			 
			 System.out.print(sheet1.getRow(3).getCell(0).getNumericCellValue()+" "+" ");
			 System.out.print(sheet1.getRow(3).getCell(1).getStringCellValue()+" "+" ");
			 System.out.println(sheet1.getRow(3).getCell(2).getStringCellValue());
			 
			 System.out.print(sheet1.getRow(4).getCell(0).getNumericCellValue()+" ");
			 System.out.print(sheet1.getRow(4).getCell(1).getStringCellValue()+"   ");
			 System.out.println(sheet1.getRow(4).getCell(2).getStringCellValue());
			 
			 
			 sheet1.getRow(0).createCell(3).setCellValue("Relation");
			 sheet1.getRow(1).createCell(3).setCellValue("Myself");
			 sheet1.getRow(2).createCell(3).setCellValue("No one");
			 sheet1.getRow(3).createCell(3).setCellValue("Friend");
			 sheet1.getRow(4).createCell(3).setCellValue("Mad Friend");
			 
			 FileOutputStream fos= new FileOutputStream(new File("C:\\\\Users\\\\Sujjal\\\\Desktop\\\\ApachePoi\\\\Practice excel.xlsx"));
			 workbook.write(fos);
			 fos.close();
			 
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
		
		workbook.close();
		
	}
}