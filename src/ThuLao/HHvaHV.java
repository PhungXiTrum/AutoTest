	package ThuLao;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeTest;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.WebDriverWait;
	public class HHvaHV {
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
	  		Thread.sleep(2000); //click vào phần thù lao
	  		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/ul[1]/li[6]/ul[1]/li[1]/a[1]")).click();
	  		Thread.sleep(2000); // click vào phần học hàm và học vị 
	  		}
	  		@Test(priority = 3)
	  		public void HH_HV() throws InterruptedException{
	  			WebElement ThemHHvaHV = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]"));
	  			ThemHHvaHV.click(); // click vào Thêm HH và HV mới
	  			Thread.sleep(5000);
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[1]/input[1]")).sendKeys("TNMQ");
	  			Thread.sleep(5000); // Điền mã học hàm học vị
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[2]/input[1]")).sendKeys("Công Nghệ Phần Mềm");
	  			Thread.sleep(5000); // Điền tên học hàm học vị
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[3]/div[1]/span[2]/button[1]")).click();
	  			Thread.sleep(5000); // click vào dấu cộng của thứ tự
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[3]/div[1]/span[1]/button[1]")).click();
	  			Thread.sleep(5000);// click vào dấu trừ của thứ tự
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[4]/button[2]")).click();
	  			Thread.sleep(5000);// click vào nút lưu
	  			}
	  		@Test(priority = 4)
	  		public void Activities() throws InterruptedException{
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]/input[1]")).sendKeys("TNMQ");
	  			Thread.sleep(5000);// click vào thanh tìm kiếm với sendKeys được yêu cầu
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/a[1]/i[1]")).click();
	  			Thread.sleep(5000);// click vào nút chỉnh sửa
	  			WebElement infoElement = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[2]/input[1]"));
	  			infoElement.clear();
	  			Thread.sleep(5000);// xóa thông tin đã tạo
	  			String newinfo = "new information";
	  			infoElement.sendKeys("Khoa học dữ liệu");
	  			Thread.sleep(5000);// Điền vào thông tin mới
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[4]/button[2]")).click();
	  			Thread.sleep(5000);// click vào nút lưu
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/a[2]/i[1]")).click();
	  			Thread.sleep(5000);// click vào nút xóa
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[1]")).click();
	  			Thread.sleep(5000);// Xác nhận xóa
	  		}
	  		// Cấp bậc
	  		@Test(priority = 5)
	  		public void CapBac() throws InterruptedException{
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
	  			Thread.sleep(5000);// click vào Cấp bậc
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]")).click();
	  			Thread.sleep(5000);// click vào Thêm Cấp bậc mới
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[1]/div[1]/span[1]/span[1]/span[1]")).click();
	  			Thread.sleep(5000);// Click chọn học hàm học vị
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[1]/div[1]/span[2]/span[1]/span[2]/ul[1]/li[3]")).click();
	  			Thread.sleep(5000);// Click chọn phần học hàm học vị đã chọn
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[2]/input[1]")).sendKeys("TNMQ");
	  			Thread.sleep(5000);// Điền vào Mã cấp bậc với sendKeys được yêu cầu
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[3]/button[2]")).click();
	  			Thread.sleep(5000);// click vào nút lưu
	  		}
	  			@Test(priority = 6)
		  		public void Activities2() throws InterruptedException{
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]/input[1]")).sendKeys("TNMQ");
	  			Thread.sleep(5000);// click vào thanh tìm kiếm với sendKeys được yêu cầu
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/a[1]/i[1]")).click();
	  			Thread.sleep(5000);// click vào nút chỉnh sửa
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[1]/div[1]/span[1]/span[1]/span[1]")).click();
	  			Thread.sleep(5000);// Click chọn học hàm học vị
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[1]/div[1]/span[2]/span[1]/span[2]/ul[1]/li[5]")).click();
	  			Thread.sleep(5000);// Click chọn phần học hàm học vị muốn sửa đổi
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[3]/button[2]")).click();
	  			Thread.sleep(5000);// click vào nút lưu
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/a[2]/i[1]")).click();
	  			Thread.sleep(5000);// click vào nút xóa
	  			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[1]")).click();
	  			Thread.sleep(5000);// Xác nhận xóa

	  		}
	  		@AfterTest
	 	   public void teardown() {
	 	       // Đóng trình duyệt
	 	        driver.close();
	 	   }
	  		}
	  			
	
