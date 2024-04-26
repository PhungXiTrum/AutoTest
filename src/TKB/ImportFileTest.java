	package TKB;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeTest;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.WebDriverWait;
	public class ImportFileTest {
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
	        Thread.sleep(10000);
	    
	        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
	        Thread.sleep(10000);
	        String expectedUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
	        String actualUrl = driver.getCurrentUrl();
	        if (actualUrl.toString().equalsIgnoreCase(expectedUrl.toString())) {
	            System.out.println("Đăng nhập thành công tài khoản VLU - PASS");
	        } else {
	            System.out.println("Tài khoản không đúng - Thất bại");
	        }
		}
	  		@Test(priority = 1)
	  		public void ImportTKB() throws InterruptedException{
	  		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/ul[1]/li[4]/a[1]")).click();
	  		Thread.sleep(2000);
	  		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/ul[1]/li[4]/ul[1]/li[1]/a[1]/span[1]")).click();
	  		Thread.sleep(2000);
	  		}
	  		//Chọn học kì và ngành
	  		@Test(priority = 2)
	  		public void Import() throws InterruptedException{
	  		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/span[1]/span[1]/span[1]")).click();
	  		Thread.sleep(2000);
	  		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/span[2]/span[1]/span[2]/ul[1]/li[3]")).click();
	  		Thread.sleep(2000);
	  		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/span[1]/span[1]/span[1]")).click();
	  		Thread.sleep(2000);
	  		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/span[2]/span[1]/span[2]/ul[1]/li[44]")).click();
	  		Thread.sleep(2000);
	  		}
	  		//Import file csv
	  		@Test(priority = 3)
	  		public void DragAndDrop() throws InterruptedException{
	  			WebElement ImportCSV = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]"));
	  	  		ImportCSV.click();
	  	  		Thread.sleep(15000);
	  	  		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/button[1]")).click();
	  	  		Thread.sleep(5000);
	  	  		WebElement NextImport = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[1]"));
	  	  		NextImport.click();
	  	  		Thread.sleep(70000);
	  	  		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[1]")).click();
	  	  		Thread.sleep(2000);
	  	  		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[1]")).click();
	  	  		Thread.sleep(3000);
	  	  		}
	   @AfterTest
	   public void teardown() {
	       // Đóng trình duyệt
	        driver.close();
	   }
	}
	
	
