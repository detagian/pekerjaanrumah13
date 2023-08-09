package com.example.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class HomePage {

    By productTitle = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    By sortOption = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");

    private ArrayList<String> Expected_Sort_Item_Name_List = new ArrayList<>();
    private ArrayList<String> Actual_Sort_Item_Name_List = new ArrayList<>();
    private ArrayList<String> PricePromo = new ArrayList<>();
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateOnHomePage() {
        WebElement productElement = driver.findElement(productTitle);
        assertTrue(productElement.isDisplayed());
        assertEquals("Sauce Labs Backpack", productElement.getText());
    }

    public void  clickSortOptionByCharacterDescending(){
        //get all items name store into a list

        int countInventoryItem = driver.findElements(By.className("inventory_item")).size();

        for (int i = 1; i <=countInventoryItem ; i++) {
            WebElement Item_Name = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div["+i+"]/div[2]/div[1]/a"));
            Expected_Sort_Item_Name_List.add(Item_Name.getText());
        }
        // by default it showing A-Z now, from stored list we reverse manually to get descending list
        Expected_Sort_Item_Name_List.sort(Collections.reverseOrder());

        //action to get descending item list from UI
        Select CharacterDescendingOption = new Select(driver.findElement(sortOption));
        CharacterDescendingOption.selectByVisibleText("Name (Z to A)");

        //get all items name that sorted Z-A store into a list
        for (int i = 1; i <=countInventoryItem ; i++) {
            WebElement Item_Name = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div["+i+"]/div[2]/div[1]/a"));
            Actual_Sort_Item_Name_List.add(Item_Name.getText());
        }

    }
    public void verifySortByCharacterDescending(){
        boolean result = false;
        for (int i=0;i<Actual_Sort_Item_Name_List.size(); i++){
            if (Actual_Sort_Item_Name_List.get(i).equals(Expected_Sort_Item_Name_List.get(i))){
                result = true;
            }else{
                fail("Items is NOT Descendingly sorted");
            }
        }
        assertTrue(result);
    }
    public void verifyPriceUnderPromo(int price){
        int countInventoryItem = driver.findElements(By.className("inventory_item")).size();
        for (int i = 1; i <=countInventoryItem ; i++) {
            WebElement Item_Price = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div["+i+"]/div[2]/div[2]/div"));
            PricePromo.add(Item_Price.getText().replaceAll("^.",""));
            System.out.println();
            if( (Float.parseFloat(PricePromo.get(i-1))) <= 50.0){
                assertTrue(true);
            }else {
                fail("Price "+PricePromo.get(i-1)+" is bigger than " + price+ " for ");
            }
        }
    }


}
