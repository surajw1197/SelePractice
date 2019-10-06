package ddtDemos;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingFromExcel {
  @Test
  public void readFromExcel() throws Exception {
	  
	  File file = new File("C:\\Users\\Suraj\\Desktop\\Demo.xlsx");
	  FileInputStream fin = new FileInputStream(file);
	  XSSFWorkbook workbook = new XSSFWorkbook(fin);
	  XSSFSheet sheet = workbook.getSheetAt(0);
	  
	  int rowCount = sheet.getLastRowNum();
	  System.out.println("Total no of rows:"+rowCount);
	  
	  for(int i=1;i<=rowCount;i++) {
		  String username = sheet.getRow(i).getCell(0).getStringCellValue();
		  String password = sheet.getRow(i).getCell(1).getStringCellValue();
		  System.out.println("Username : "+username+" Password : "+password);
		  
	  }
	  workbook.close();
	  
	  
  }
}
