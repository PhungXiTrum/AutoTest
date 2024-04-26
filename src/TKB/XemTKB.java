	package TKB;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeTest;
	import org.openqa.selenium.support.ui.WebDriverWait;
	public class XemTKB {
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
	  		@Test(priority = 2)
	  		public void ThuLao() throws InterruptedException{
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/ul[1]/li[4]/a[1]")).click();
		  		Thread.sleep(2000); //click vào TKB
		  		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/ul[1]/li[4]/ul[1]/li[3]/a[1]")).click();
		  		Thread.sleep(2000); // click vào phần xem TKB
		  		}
	  		@Test(priority = 3)
	  		public void HHvaHV() throws InterruptedException{
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/span[1]/span[1]")).click();
	  			Thread.sleep(5000); // Click vào ô học kỳ
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[2]/span[1]/span[1]/input[1]")).sendKeys("999");
	  			Thread.sleep(5000); // Điền thông tin học kỳ
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[2]/span[1]/span[2]/ul[1]/li[1]")).click();
	  			Thread.sleep(5000); // Click vào học kỳ muốn chọn
	  			
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[1]/span[1]/span[1]")).click();
	  			Thread.sleep(5000); // Click vào ô tuần
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[2]/span[1]/span[1]/input[1]")).sendKeys("Tuần 16");
	  			Thread.sleep(5000); // Điền thông tin Tuần
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[2]/span[1]/span[2]/ul[1]/li[1]")).click();
	  			Thread.sleep(5000); // Click vào tuần muốn chọn
	  			
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/span[1]/span[1]/span[1]")).click();
	  			Thread.sleep(5000); // Click vào ô giảng viên
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/span[2]/span[1]/span[1]/input[1]")).sendKeys("Minh Quân");
	  			Thread.sleep(5000); // Điền thông tin giảng viên
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/span[2]/span[1]/span[2]/ul[1]/li[3]")).click();
	  			Thread.sleep(5000); // Click vào giảng viên muốn chọn
	  		}
	  		@AfterTest
		 	   public void teardown() {
		 	       // Đóng trình duyệt
		 	        driver.close();
		 	   }
	  		}
	  			
	

