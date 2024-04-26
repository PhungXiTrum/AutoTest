	package TKB;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeTest;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.WebDriverWait;
	public class Export {
		public String baseUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
		String driverPath = "C:\\chromedriver.exe";
		public WebDriver driver;
		public WebDriverWait wait;
		@BeforeTest
			public void setUp()throws InterruptedException {
				System.out.println("CHAY TRINH DUYET CHROME");
				System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Automatic\\chromedriver.exe");
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
	        driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("quan.207ct28416@vanlanguni.vn");
	        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
	        Thread.sleep(2000);
	        // Nhập mật khẩu
	        driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("VLU23112002");
	        // Nhấp vào nút Đăng nhập
	        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
	        Thread.sleep(15000);
	    
	        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
	        Thread.sleep(10000);
			// thao tác tay để xác nhận 2 lớp 
	        String expectedUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
	        String actualUrl = driver.getCurrentUrl();
	        if (actualUrl.toString().equalsIgnoreCase(expectedUrl.toString())) {
	            System.out.println("Đăng nhập thành công tài khoản VLU - PASS");
	        } else {
	            System.out.println("Tài khoản không đúng - Thất bại");
	        }
		}
		@Test(priority = 1)
		public void TruyCap_PhanCong_GiangVien()throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[4]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[4]/ul/li[2]/a")).click();
			Thread.sleep(2000);
			String expectedUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Timetable/Assign";
	  		String actualUrl = driver.getCurrentUrl();
	  		if(actualUrl.toString().equalsIgnoreCase(expectedUrl.toString())) {
	  		System.out.println("Truy cập thành công vào trang Phân Công Giảng Viên - PASS");
	  	}
	    	else {
	    		System.out.println("Truy cập thất bại - Lỗi nút button phân công - False");		
	   	
	   	}
		}
		@Test(priority = 2)
		public void Xem_ThongTin_PhanCong()throws InterruptedException {
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]")).click();
			Thread.sleep(2000);
			WebElement Message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[1]"));
	        if (Message.isDisplayed() && Message.getText().equals("Lập trình hướng đối tượng")) {
	        	System.out.println("Thông báo: Xem thành công thông tin phân công - PASS");
	        } else {
	        	System.out.println("Thông báo lỗi không hiển thị - lỗi chức năng xem thông tin - False");
	        }
	        
	}
		@Test(priority = 3)
		public void Xem_ThongTin_PhanCong_KhongTonTai()throws InterruptedException {
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[2]")).click();
			Thread.sleep(4000);
			WebElement Message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/h4"));
	        if (Message.isDisplayed() && Message.getText().equals("Chưa có dữ liệu")) {
	        	System.out.println("Thông báo: Chưa có dữ liệu - PASS");
	        } else {
	        	System.out.println("Hiển thị thông tin sai - lỗi chức năng xem thông tin - False");
	        }
	        
	}
		@Test(priority = 4)
		public void Xem_ThongTin_PhanCong_TheoMonHoc()throws InterruptedException {
			driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Timetable/Assign");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"assignLecturerDiv\"]/div[2]/div[1]/div[4]/span[1]/span[1]/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"assignLecturerDiv\"]/div[2]/div[1]/div[4]/span[2]/span/div/button[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"assignLecturerDiv\"]/div[2]/div[1]/div[4]/span[1]/span[1]/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[2]/span/span/ul/li[1]")).click();
			Thread.sleep(2000);
			WebElement Message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[2]/td[1]"));
	        if (Message.isDisplayed() && Message.getText().equals("Cấu trúc dữ liệu và giải thuật")) {
	        	System.out.println("Thông báo: Xem thông tin theo môn học - PASS");
	        } else {
	        	System.out.println("Hiển thị thông tin sai - lỗi chức năng xem thông tin - False");
	        }
	        
	}
		@Test(priority = 5)
		public void Xem_ThongTin_PhanCong_TheoTenGianVien()throws InterruptedException {
			driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Timetable/Assign");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"assignLecturerDiv\"]/div[2]/div[1]/div[5]/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"assignLecturerDiv\"]/div[2]/div[1]/div[5]/span[2]/span/div/button[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"assignLecturerDiv\"]/div[2]/div[1]/div[5]/span")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/span/ul/li[4]")).click();
			Thread.sleep(2000);
			WebElement Message = driver.findElement(By.xpath("//*[@id=\"289987\"]"));
	        if (Message.isDisplayed() && Message.getText().equals("N.C.P Duy")) {
	        	System.out.println("Thông báo: Xem thông tin theo tên giảng viên - PASS");
	        } else {
	        	System.out.println("Hiển thị thông tin sai - lỗi chức năng xem thông tin - False");
	        }
	        
	}
		@Test(priority = 6)
		public void Xem_ThongTin_GiangVien_ChuaPhanCong()throws InterruptedException {
			driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Timetable/Assign");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"assignLecturerDiv\"]/div[2]/div[1]/div[5]/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"assignLecturerDiv\"]/div[2]/div[1]/div[5]/span[2]/span/div/button[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"assignLecturerDiv\"]/div[2]/div[1]/div[5]/span")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/span/ul/li[1]")).click();
			Thread.sleep(2000);
			WebElement Message = driver.findElement(By.xpath("//*[@id=\"290010\"]"));
	        if (Message.isDisplayed() && Message.getText().equals("Chưa phân")) {
	        	System.out.println("Thông báo: Xem thông tin giảng viên chưa phân công - PASS");
	        } else {
	        	System.out.println("Hiển thị thông tin sai - lỗi chức năng xem thông tin - False");
	        }
	        
	}
		@AfterTest
		   public void teardown() {
		       // Đóng trình duyệt
		        driver.quit();
		   }
	}
	  		
	
