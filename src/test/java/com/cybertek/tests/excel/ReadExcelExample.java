package com.cybertek.tests.excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadExcelExample {
    //takes
    private FileInputStream fileInputStream;
    //represent the excel file
    private Workbook workbook;
    private Sheet workSheet;


    @BeforeMethod
    public void setUp() throws IOException {
        //location of the excel file
        String filePath = "src/main/resources/Countries.xlsx";
        //create input string from using the file path
        fileInputStream = new FileInputStream(filePath);
        //create the workbook object
        workbook = WorkbookFactory.create(fileInputStream);
        //    workSheet =workbook.getSheetAt(1);
        workSheet = workbook.getSheet("Countries");


    }


    @AfterMethod
    public void tearDown() throws IOException {
        workbook.close();
        fileInputStream.close();
    }


    @Test
    public void readName() {
        //getSheetName --> returns the name of the current sheet

        String sheetName = workSheet.getSheetName();
        System.out.println("sheet name= " + sheetName);

        int rowCount = workSheet.getLastRowNum();
        System.out.println("row count= " + rowCount);

        //get the first row
        //getLastCellNum--> index of the last cell
        int colCount = workSheet.getRow(0).getLastCellNum();
        System.out.println("col count= " + colCount);


    }

    @Test
    public void readSingleCell() {
        //first select row
//Row --> represents a single row

        //getRow--> gets row from the sheet 0 based
        Row row = workSheet.getRow(6);

        //select certain cell from the row
        //Cell --> represents a single cell
        //row.getCell()--> return single cell,0 bases
        Cell cell = row.getCell(0);

        //gets the value as a String
        String value = cell.toString();
        System.out.println("value = " + value);


    }

    @Test
    public void tabletoMap() {
        int rowCount = workSheet.getLastRowNum();
        Map<String, String> countryMap = new HashMap<>();

        for (int i = 0; i <= rowCount; i++) {
            Row currentRow = workSheet.getRow(i);
            String country = currentRow.getCell(0).toString();
            String capitals = currentRow.getCell(1).toString();
            countryMap.put(country, capitals);
        }
        System.out.println(countryMap);
    }

    @Test
    public void tableToListOfMaps() {
        // convert the  our table to List<Map<String, String>>
        int rowCount = workSheet.getLastRowNum();

        List<Map<String, String>> list = new ArrayList<>();
        for (int i = 1; i <= rowCount; i++) {
            Map<String, String> map = new HashMap<>();
            Row currentRow = workSheet.getRow(i);
            String country = currentRow.getCell(0).toString();
            String capital = currentRow.getCell(1).toString();
            map.put("Country", country);
            map.put("Capital", capital);

            list.add(map);
        }
        System.out.println(list);
        System.out.println(list.get(5));
        System.out.println(list.get(5).get("Country"));


    }



}
