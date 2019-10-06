package ddtDemos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class CreateWorkbookDemo {
  @Test
  public void createWoorkBook() throws Exception {
	  XSSFWorkbook workbook = new XSSFWorkbook();
	  FileOutputStream out = new FileOutputStream(new File("demo.xlsx"));
	  workbook.write(out);
	  out.close();
	  System.out.println("demo.xlsx wriiten successfully");
	  
  }
}
