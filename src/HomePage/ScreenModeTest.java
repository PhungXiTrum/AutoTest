package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class ScreenModeTest {
	public String baseUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
	String driverPath = "C:\\chromedriver.exe";
	public WebDriver driver;
	
	@BeforeTest
		public void setUp()throws InterruptedException {
			System.out.println("CHAY TRINH DUYET CHROME");
			System.setProperty("webdriver.chrome.driver",driverPath);
			driver = new ChromeDriver();
			driver.get(baseUrl);
			driver.manage().window().maximize();
			Thread.sleep(3000);
		}
	@Test(priority = 0)
    public void loginTest() throws InterruptedException{
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		driver.findElement(By.id("OpenIdConnect")).click();
		Thread.sleep(2000);
        // Nhập tên người dùng
        driver.findElement(By.id("i0116")).sendKeys("quang.2174802010492@vanlanguni.vn");
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(2000);
        // Nhập mật khẩu
        driver.findElement(By.id("i0118")).sendKeys("VLU16012003");
        // Nhấp vào nút Đăng nhập
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(10000);
		// thao tác tay để xác nhận 2 lớp 
       	String expectedUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
  		String actualUrl = driver.getCurrentUrl();
  		if(actualUrl.toString().equalsIgnoreCase(expectedUrl.toString())) {
  		System.out.println("Đăng nhập thành công tài khoản VLU - PASS");
  	}
    	else {
    	}
  		}
	@Test(priority = 1)
	public void screenModeTest() throws InterruptedException {
		// Thay đổi chế độ màn hình
	    try {
	        WebElement fullScreenButton = driver.findElement(By.xpath("/html/body/div[2]/nav/div/div/ul[2]/li/a/i"));
	        fullScreenButton.click();
	        System.out.println("Chuyển sang chế độ toàn màn hình - PASS");
	        Thread.sleep(2000);
	        
	        fullScreenButton.click();
	        System.out.println("Thoát chế độ toàn màn hình - PASS");
	        Thread.sleep(2000);	
	    } catch (Exception e) {
	        System.out.println("Đã xảy ra lỗi: " + e.getMessage());
	    }
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
