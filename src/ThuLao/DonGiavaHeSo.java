	package ThuLao;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeTest;
	import org.openqa.selenium.support.ui.WebDriverWait;
	public class DonGiavaHeSo {
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
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/ul[1]/li[6]/a[1]")).click();
		  		Thread.sleep(2000); //click vào Thù lao
		  		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/ul[1]/li[6]/ul[1]/li[2]/a[1]")).click();
		  		Thread.sleep(2000); // click vào phần Đơn giá và hệ số
		  		}
	  		@Test(priority = 3)
	  		public void QuanLyDonGiavaHeSo() throws InterruptedException{
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/span[1]/span[1]")).click();
	  			Thread.sleep(5000); // Click chọn vào ô năm học
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[2]/span[1]/span[1]/input[1]")).sendKeys("2023 - 2024");
	  			Thread.sleep(5000); // Điền thông tin năm học
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[2]/span[1]/span[2]/ul[1]/li[1]")).click();
	  			Thread.sleep(5000); // Click vào năm học muốn chọn
	  			
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]/a[1]/i[1]")).click();
	  			Thread.sleep(5000); // Click vào ô chỉnh sửa
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[2]/input[1]")).sendKeys("10000000");
	  			Thread.sleep(5000); // Điền thông tin Đơn giá
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[3]/button[2]")).click();
	  			Thread.sleep(5000); // Click vào nút lưu
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]/a[2]/i[1]")).click();
	  			Thread.sleep(5000); // Click vào nút xóa
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[1]")).click();
	  			Thread.sleep(5000); // Click vào nút xác nhận xóa
	  		}
	  			
	  		@Test(priority = 4)
		  	public void HeSo() throws InterruptedException{
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/a[1]")).click();
	  			Thread.sleep(5000); // Click vào ô Hệ số
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/a[1]/i[1]")).click();
	  			Thread.sleep(5000);//Click vào ô chỉnh sửa
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[1]/div[1]/div[1]/span[2]/button[1]")).click();
	  			Thread.sleep(5000); // Click vào ô Tăng
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[1]/div[1]/div[1]/span[1]/button[1]")).click();
	  			Thread.sleep(5000); // Click vào ô Giảm
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[1]/div[2]/div[1]/span[2]/button[1]")).click();
	  			Thread.sleep(5000); // Click vào ô Tăng
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[1]/div[2]/div[1]/span[1]/button[1]")).click();
	  			Thread.sleep(5000); // Click vào ô Giảm
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[2]/div[1]/div[1]/span[2]/button[1]")).click();
	  			Thread.sleep(5000); // Click vào ô Tăng
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[2]/div[1]/div[1]/span[1]/button[1]")).click();
	  			Thread.sleep(5000); // Click vào ô Giảm
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[2]/div[2]/div[1]/span[2]/button[1]")).click();
	  			Thread.sleep(5000); // Click vào ô Tăng
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[2]/div[2]/div[1]/span[1]/button[1]")).click();
	  			Thread.sleep(5000); // Click vào ô Giảm
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[3]/button[2]")).click();
	  			Thread.sleep(5000); // Click vào nút lưu
	  			}
	
	  		@AfterTest
	 	   public void teardown() {
	 	       // Đóng trình duyệt
	 	        driver.close();
	 	   }
	  		}
	  		
	  			
	
