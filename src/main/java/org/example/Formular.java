package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class Formular {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    public void uklid(){
        //Pre tatvorenie okna prehliadaca
        driver.close();
        //Pre zrusenie objektu driver
        driver.quit();
    }

    @Test
    public void Formular() {
        //Prikaz na prepnutie na stranku
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        //Prikaz pre najdenie a vpisanie prvku
        driver.findElement(By.id("name")).sendKeys("Mario Folk");
        driver.findElement(By.id("email")).sendKeys("email@email.com");
        //Prikaz pre najdenie prvku a klik nan
        driver.findElement(By.id("gender")).click();
        // //*[@id="practiceForm"]/div[3]/div/div/div[2]/input
        driver.findElement(By.xpath("//*[@id=\"practiceForm\"]/div[3]/div/div/div[2]/input")).click();
        //Validace, zda jsou radiobuttony zaskrtnuty
        assertTrue(driver.findElement(By.xpath("//*[@id=\"practiceForm\"]/div[3]/div/div/div[2]/input")).isSelected());
        //assertFalse(driver.findElement(By.id("gender")).isSelected(),"Radiobutton je zaskrtnuty :(");
    }
}