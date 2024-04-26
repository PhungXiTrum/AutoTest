package ThuLao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class QuanLyCapBac_TimKiem_GV {
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
  		System.out.println("Truy cập thành công vào trang Quản lý Cấp bậc - PASS");
  	}
    	else {
    		System.out.println("Truy cập thất bại - Lỗi nút button Cấp bậc GV - False");		
   	
   	}
	}
	@Test(priority = 2)
	public void TimKiem_GV()throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("HaoTest123");
		Thread.sleep(2000);
		
		WebElement Message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr/td[3]"));
        if (Message.isDisplayed() && Message.getText().equals("Test Duy")) {
        	System.out.println("Thông báo: Tìm kiếm thành công Giảng Viên Phân Công - PASS");
        } else {
        	System.out.println("Thông báo lỗi không hiển thị hoặc nội dung không chính xác");
        }
        
        
		
}
	@Test(priority = 3)
	public void TimKiem_MonHoc_TheoCumTuTat()throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Hao");
		Thread.sleep(2000);
		
		WebElement Message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[2]/td[3]"));
        if (Message.isDisplayed() && Message.getText().equals("Test Hao")) {
        	System.out.println("Thông báo: Tìm kiếm thành công theo từ viết tắt - PASS");
        } else {
        	System.out.println("Thông báo lỗi không hiển thị hoặc nội dung không chính xác");
        }
        Thread.sleep(2000);
        WebElement TenGV = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[2]/td[3]"));
        String HienThi_TimKiem = TenGV.getText();

        String Tu_TimKiem = "Hao";

        if (HienThi_TimKiem.contains(Tu_TimKiem)) {
            System.out.println("Thông tin Giảng viên tìm kiếm đúng - Fass");
        } else {
            System.out.println("Thông báo: Lỗi chức năng tìm kiếm theo cụm - False");
        }
	}
	@Test(priority = 4)
	public void TimKiem_MonHoc_KhongTonTai()throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("WWWWWW");
		Thread.sleep(2000);
		
		WebElement Message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr/td"));
        if (Message.isDisplayed() && Message.getText().equals("Không tìm thấy kết quả")) {
        	System.out.println("Thông báo: Không tìm thấy kết quả - PASS");
        } else {
        	System.out.println("Thông báo lỗi không hiển thị hoặc nội dung không chính xác");
        }
        
        
		
}
	@AfterClass
	   public void teardown() {
	       // Đóng trình duyệt
	        driver.quit();
	   }

}
