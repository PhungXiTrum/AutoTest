package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteUser {
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
        driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("VLU02072002");
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
	public void TruyCap_NguoiDung()throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a/span")).click();
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/User");
		Thread.sleep(2000);
}
	@Test(priority = 2)
	public void Xoa_NguoiDung()throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("haoautotest.207ct47746@vanlanguni.vn");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr/td[7]/a[2]/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("haoautotest.207ct47746@vanlanguni.vn");
		WebElement Message = driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody"));
        if (Message.isDisplayed() && Message.getText().equals("Không tìm thấy kết quả")) {
        	System.out.println("Không tìm thấy kết quả - Xóa thành công! - PASS");
        } else {
        	System.out.println("Chưa xóa được người dùng - Thông báo hệ thống lỗi");
        }
        
	}


}
