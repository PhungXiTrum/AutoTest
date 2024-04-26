package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
public class UpdateUserProfile {
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
			Thread.sleep(2000);
		}
	@Test(priority = 0)
    public void loginTest() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id=\"details-button\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"proceed-link\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"OpenIdConnect\"]")).click();
		Thread.sleep(2000);
        // Nhập tên người dùng
        driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("quang.2174802010492@vanlanguni.vn");
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        Thread.sleep(2000);
        // Nhập mật khẩu
        driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("VLU16012003");
        // Nhấp vào nút Đăng nhập
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        Thread.sleep(10000);
    
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
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
	public void updateUser() throws InterruptedException {
		//Ấn vào hồ sơ người dùng
		driver.findElement(By.id("dropdown-user")).click();
		driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[1]")).click();
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Account/Update");
	    // Nhập mã giảng viên nếu trường staff_id trống
	    WebElement staffIdInput = driver.findElement(By.id("staff_id"));
	    if (staffIdInput.getAttribute("value").isEmpty()) {
	        staffIdInput.sendKeys("2174802010492");
	    }
	    Thread.sleep(2000);
	    // Nhập tên người dùng nếu trường full_name trống
	    WebElement fullNameInput = driver.findElement(By.id("full_name"));
	    if (fullNameInput.getAttribute("value").isEmpty()) {
	        fullNameInput.sendKeys("Nguyễn Nhật Quang");
	    }
	    Thread.sleep(2000);
	    // Ấn nút cập nhật
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/button")).click();
	    Thread.sleep(2000);
	    // Xác nhận cập nhật
	    WebElement Message = driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]"));
        if (Message.isDisplayed() && Message.getText().equals("Cập nhật thành công!")) {
        	System.out.println("Cập nhật thành công! - PASS");
        } else {
        	System.out.println("Cập nhật thất bại! - FAIL");
        }
	    driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
    }
	@AfterClass
	public void teardown() {
		driver.close();
	}
}