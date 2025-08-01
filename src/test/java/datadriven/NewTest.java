package datadriven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;
import java.util.Iterator;

public class NewTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\punee\\eclipse-workspace\\Project3DataDrivenFramework\\Driver\\chromedriver.exe");
    	
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--guest"); // Launch Chrome in guest mode
    	



    	
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Print the title of the page
        
        //driver.get("http://localhost/addressbook/index.php");
        driver.get("http://localhost/addressbook/newEntry.php");
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("//////////////////////////////////////////////");

        
    }
    

    


    @Test(dataProvider = "getTestData")
    public void addressbookTest(String entryType, String firstName, String lastName, String businessName,
                                String address1, String address2, String address3, String city, String province, String country, String postalCode,
                                String email1, String email2, String email3,
                                String phone1Type, String phone1Number, String phone2Type, String phone2Number, String phone3Type, String phone3Number,
                                String webSite1, String webSite2, String webSite3) {

        // Use driver to fill in your form fields, e.g.:
        driver.findElement(By.name("addr_type")).sendKeys(entryType);
        driver.findElement(By.name("addr_first_name")).sendKeys(firstName);
        driver.findElement(By.name("addr_last_name")).sendKeys(lastName);
        driver.findElement(By.name("addr_business")).sendKeys(businessName);
        driver.findElement(By.name("addr_addr_line_1")).sendKeys(address1);
        driver.findElement(By.name("addr_addr_line_2")).sendKeys(address2);
        driver.findElement(By.name("addr_addr_line_3")).sendKeys(address3);
        driver.findElement(By.name("addr_city")).sendKeys(city);
        driver.findElement(By.name("addr_region")).sendKeys(province);
        driver.findElement(By.name("addr_country")).sendKeys(country);
        driver.findElement(By.name("addr_post_code")).sendKeys(postalCode);
        driver.findElement(By.name("addr_email_1")).sendKeys(email1);
        driver.findElement(By.name("addr_email_2")).sendKeys(email2);
        driver.findElement(By.name("addr_email_3")).sendKeys(email3);
        driver.findElement(By.name("addr_phone_1_type")).sendKeys(phone1Type);
        driver.findElement(By.name("addr_phone_1")).sendKeys(phone1Number);
        driver.findElement(By.name("addr_phone_2_type")).sendKeys(phone2Type);
        driver.findElement(By.name("addr_phone_2")).sendKeys(phone2Number);
        driver.findElement(By.name("addr_phone_3_type")).sendKeys(phone3Type);
        driver.findElement(By.name("addr_phone_3")).sendKeys(phone3Number);
        driver.findElement(By.name("addr_web_url_1")).sendKeys(webSite1);
        driver.findElement(By.name("addr_web_url_2")).sendKeys(webSite2);
        driver.findElement(By.name("addr_web_url_3")).sendKeys(webSite3);

        // Add submission or verification steps here
         driver.findElement(By.id("submit_button")).click();
    }

    @AfterMethod
    public void teardown() {
        if(driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "getTestData")
    public Iterator<Object[]> getData() {
        return CSVDataProvider.getDataFromCSV();
    }

}
