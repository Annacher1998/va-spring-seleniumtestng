package com.cybertek.tests.webTables;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class webTableTest extends TestBase {


    @BeforeMethod
    public void setUp() {
        driver.get(ConfigurationReader.get("url"));
    }
    @Test
    public void printTable() {
        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());
    }


    @Test
    public void tableSize(){
        //TODO number of columns
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number of columns: "+ headers.size());

        //TODO number of row including header
        List<WebElement> rowWithHeaders=driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("Number of rows: "+ rowWithHeaders.size());


        //TODO number row without headers

        List<WebElement> rowsWithOutHeaders = driver.findElements(By.xpath(("//table[@id='table1']/tbody/tr")));
        System.out.println("Number of rowsWithOutHeaders : "+rowsWithOutHeaders.size());




    }
    @Test
    public void getWholeRow(){
        WebElement row=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        System.out.println("Row #1 : "+row.getText());
//
//        WebElement row2=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
//        System.out.println("Row #2 : "+row2.getText());


        int index=2;
        String rowXPath="//table[@id='table1']/tbody/tr["+index+"]";
        row=driver.findElement(By.xpath(rowXPath));
        System.out.println("Row #2 : "+ row.getText());




    }

    //get all cells from certain row

    @Test
    public void getCellsinRow(){
        List<WebElement> cellsInRow=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        cellsInRow.forEach(cell-> System.out.println(cell.getText()));
        System.out.println("cellsInROw.size(): "+cellsInRow.size());


        int index=3;
        String cellInRowXpath="//table[@id='table1']/tbody/tr["+index+"]/td";
       cellsInRow=driver.findElements(By.xpath(cellInRowXpath));
        cellsInRow.forEach(cell-> System.out.println(cell.getText()));
    }

    //get certain cell

    @Test
    public void getCertainCellTest(){
        WebElement cell=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[2]"));
        System.out.println(cell.getText());


    }

@Test
public void getCellMethodTest(){
       WebElement cell= getCell(3,4);
    Assert.assertEquals(cell.getText(),"$100.00");
cell=getCell(4,5);
        Assert.assertEquals(cell.getText(),"http://www.timconway.com");
}
    public WebElement getCell(int rotIndex,int colIndex) {
        String xPath = "//table[@id='table1']/tbody/tr["+rotIndex+"]/td["+colIndex+"]";
        return driver.findElement(By.xpath(xPath));

    }

    // go to a the page
    //click on email
    //verify email column is sorted in asserting order

    @Test
    public void columnSortTest() {
        //click on column email
        //get all columns names
        //click on col email
        List<WebElement> colNames = getAllColumnsNames();
        System.out.println(colNames);
        for (WebElement colName : colNames) {
            if (colName.getText().equals("Email")) {
                colName.click();
            }
        }
        //get all data under the Email
        //get the index of the Email
        int colIndex = getColumnIndex("Email");
        System.out.println(colIndex);
        String Xpath = "//table[@id='table1']/tbody/tr/td[" + colIndex + "]";
        List<WebElement> allEmails = driver.findElements(By.xpath(Xpath));
        allEmails.forEach(email -> System.out.println(email.getText()));

        for(int i=0;i<allEmails.size()-1;i++){
            String email1=allEmails.get(i).getText();
            String email2=allEmails.get(i+1).getText();
            Assert.assertTrue(email1.compareTo(email2)<0);
        }
    }

        private List<WebElement> getAllColumnsNames() {

        List<WebElement> cols=driver.findElements(By.xpath("//table[@id='table1']//th"));

        return cols;
    }

    private int getColumnIndex(String col){
        List<WebElement>cols=getAllColumnsNames();
     for(int i=0;i<cols.size();i++){
         if(cols.get(i).getText().equals(col)){
             return i+1;

         }
     }
     return 0;
    }
}





