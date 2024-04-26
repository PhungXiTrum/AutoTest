package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddUser {
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
	public void ThemNguoiDung_Moi()throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button/span")).click();
		Thread.sleep(2000);
}
	@Test(priority = 3)
	public void Tao_NguoiDung()throws InterruptedException {
		WebElement Input_MaGiangVien = driver.findElement(By.xpath("//*[@id=\"staff_id\"]"));
		Input_MaGiangVien.sendKeys("6666666"); // Mã giảng viên không đc trùng với mã đã có trên hệ thống
		WebElement Input_TenGiangVien = driver.findElement(By.xpath("//*[@id=\"full_name\"]"));
		Input_TenGiangVien.sendKeys("Nguyễn Nhật Hào Test");
		WebElement Input_EmailGiangVien = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		Input_EmailGiangVien.sendKeys("haoautotest.207ct47746@vanlanguni.vn"); // Email giảng viên không được trùng với Email đã có trên hệ thống
		
		driver.findElement(By.xpath("//*[@id=\"select2-type-container\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"type\"]/option[2]")).click();

		driver.findElement(By.xpath("//*[@id=\"role_id\"]/option[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();
		Thread.sleep(2000);
		WebElement Message = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
        if (Message.isDisplayed() && Message.getText().equals("Lưu thành công!")) {
        	System.out.println("Thông báo: Lưu thành công! - PASS");
        } else {
        	System.out.println("Thông báo lỗi không hiển thị hoặc nội dung không chính xác");
        }
        
	}
}
