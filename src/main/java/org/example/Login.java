package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class Login {
  private WebDriver driver;

  @BeforeAll
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "/home/et/Stiahnuté/SkillmeaZakladyProgramovania/SkillmeaSelenium/src/main/resources/chromedriver");
    driver = new ChromeDriver();
  }

  @Test
  public void testLogin() {
    driver.get("https://www.tutorialspoint.com/selenium/practice/login.php");
    driver.findElement(By.id("password")).sendKeys("Heslo12345");
    driver.findElement(By.id("email")).sendKeys("novyemail@novyemail.com");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    assertEquals("Welcome, Login In", driver.findElement(By.xpath("//*[@id=\"signInForm\"]/h1")).getText());
  }
}
