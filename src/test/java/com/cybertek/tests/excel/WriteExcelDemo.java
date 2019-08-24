package com.cybertek.tests.excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelDemo {



    @Test
    public void writeExcelDemo() throws IOException {

        FileInputStream fileInputStream=new FileInputStream("src/main/resources/Countries.xlsx");

        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet workSheet=workbook.getSheet("Countries");

        //get first row and 3rd column
        Cell colName=workSheet.getRow(0).getCell(2);

       //enter value to the cell
      if(colName==null){
          //createCell--> creates a cell in the worksheet in the given index
          //if cell is null we cannot write to it, we need to call create first
          colName=workSheet.getRow(0).createCell(2);
      }

      colName.setCellValue("Result");


      int rowCount=workSheet.getLastRowNum();
        System.out.println("rowCount = "+rowCount);
//for loop to iterate
        for(int i=1;i<=rowCount;i++){
            Row currentRow=workSheet.getRow(i);
            Cell cell=currentRow.getCell(2);
            if (cell == null) {
                cell=currentRow.createCell(2);
            }
            cell.setCellValue("PASS");

}






        FileOutputStream fileOutputStream=new FileOutputStream("src/main/resources/Countries.xlsx");
        //write th changes to the file and save
        workbook.write(fileOutputStream);


        //close connections
        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();








    }


}
