package fileReaders;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelReader {
    static FileInputStream file =null;

    public static FileInputStream getFileInputStream() {
        String filePath =System.getProperty("user.dir")+"/src/test/java/data/UserData.xlsx";
        File srcFile = new File(filePath);
        try{file = new FileInputStream(srcFile);

            System.out.println("File readied");
        }
        catch (Exception e){
            System.out.println("File not readied");
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println(file.toString());
        return file;
    }

    public Object[][] getData() throws Exception {
        file = getFileInputStream();
        System.out.println("sheet readied");
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);
        System.out.println("sheet2 readied");
            int totalNumberOfRows = (sheet.getLastRowNum()+1);
            int totalNumberOfCols = 4;
            String[][] arrayExcelData = new String[totalNumberOfRows][totalNumberOfCols];
            for(int i = 0; i< totalNumberOfRows; i++){
                for (int j=0; j<totalNumberOfCols ;j++)
                {
                    System.out.println("cells read");
                    XSSFRow row = sheet.getRow(i);
                    arrayExcelData[i][j] = row.getCell(j).toString();
                }
            }

            wb.close();
            return arrayExcelData;


    }
}
