package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SlideBar {
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
    		System.out.println("Tài khoản không đúng - Thất bại");
    	}
  		}
	@Test(priority = 1)
	public void hideslidebar() throws InterruptedException {
	    try {
	        WebElement slidebarButton = driver.findElement(By.xpath("//li[@class='nav-item nav-toggle']/a"));
	        slidebarButton.click();
	        Thread.sleep(2000);
	        // Kiểm tra xem slide bar đã được ẩn chưa
	        if (!slidebarButton.isDisplayed()) {
	            System.out.println("Ân Slide bar - PASS");
	        } else {
	            System.out.println("Ân Slide bar - FAIL");
	        }
	    } catch (Exception e) {
	        System.out.println("Đã xảy ra lỗi: " + e.getMessage() + " - Fail");
	    }
	}
	   @AfterTest
	   public void teardown() {
	       // Đóng trình duyệt
	        driver.close();
	   }
}