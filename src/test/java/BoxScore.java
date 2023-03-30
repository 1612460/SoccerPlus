import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Login;

import static jdk.nashorn.internal.objects.Global.print;

public class BoxScore{
    WebDriver driver;
    Login login;
    @BeforeTest
    public void init(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://soccer-plus.jp/login");
    }

    @Test
    public void TC01() throws InterruptedException {
        login = new Login(driver);
        login.login();
        driver.get("https://soccer-plus.jp/scorebook/matches/265/stat");

        synchronized (driver) {
            driver.wait(1000);
        }

        int rows = 15;
        int columns = 30;
        int [][] data = new int[rows][columns];
        for(int i = 5; i < columns; i++){
            for (int j = 1; j < rows; j++){
                data[j][i] = Integer.parseInt(driver.findElement(By.xpath("//tbody/tr["+j+"]/td["+i+"]")).getText());
//                System.out.print(data[j][i]);
            }
        }
        System.out.print(data[10][10]);

        int goal = 0;
        for (int j = 1; j <rows; j++){
            goal += data[j][5];
        }
        System.out.print(goal);


    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
