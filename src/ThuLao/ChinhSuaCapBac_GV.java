package ThuLao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChinhSuaCapBac_GV {
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
        driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("hao.207ct47746@vanlanguni.vn");
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
	public void TruyCap_ThuLao_QuanLyCapBacGV()throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a/span")).click();
		Thread.sleep(2000);
		String expectedUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/LecturerRank";
  		String actualUrl = driver.getCurrentUrl();
  		if(actualUrl.toString().equalsIgnoreCase(expectedUrl.toString())) {
  		System.out.println("Truy cập thành công vào trang Quản lý môn học - PASS");
  	}
    	else {
    		System.out.println("Truy cập thất bại - Lỗi nút button phân công - False");		
   	
   	}
	}
	
	@Test(priority = 2)
	public void TimKiem_GV()throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Hao Test 123");
		Thread.sleep(2000);
		
		WebElement Message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr/td[3]"));
        if (Message.isDisplayed() && Message.getText().equals("Hao Test 123")) {
        	System.out.println("Thông báo: Tìm kiếm thành công Giảng Viên Phân Công - PASS");
        } else {
        	System.out.println("Thông báo lỗi không hiển thị hoặc nội dung không chính xác");
        }
	}
	
	@Test(priority = 3)
	public void KiemTra_ThongBao_ChinhSua_ThongTin_CapBac()throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr/td[5]/a/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/div/span[1]/span[1]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[2]/ul/li[10]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[4]/button[2]")).click();
		Thread.sleep(2000);
  		WebElement Message = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
        if (Message.isDisplayed() && Message.getText().equals("Cập nhật thành công!")) {
        	System.out.println("Thông báo: Chỉnh sửa cập nhật thành công - PASS");
        } else {
        	System.out.println("Hiển thị thông báo sai  - False");
        }
        
	}
	
	@Test(priority = 4)
	public void KiemTra_KetQua_ChinhSua_CapBac()throws InterruptedException {
		// Kiểm tra thông tin đã đc lưu chưa
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/LecturerRank");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Hao Test 123");
		Thread.sleep(2000);
		
  		WebElement Message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr/td[4]"));
        if (Message.isDisplayed() && Message.getText().equals("1")) {
        	System.out.println("Thông báo: Lưu thành công - PASS");
        } else {
        	System.out.println("Thông tin chỉnh sửa chưa được lưu  - False");
        }
        
	}
	@AfterClass
    public void tearDown() {
        driver.close();
    }

}
