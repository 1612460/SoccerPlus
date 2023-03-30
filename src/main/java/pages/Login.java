package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver){
        this.driver = driver;
    }

    public void login(){
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("cbanishan");
        driver.findElement(By.xpath("//input[@id='password-login']")).sendKeys("cba123456");
        driver.findElement(By.xpath("//button[contains(text(),'ログイン')]")).click();
    }

}