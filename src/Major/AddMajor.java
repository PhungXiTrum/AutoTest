package Major;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AddMajor {
    public String baseUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
    String driverPath = "C:\\chromedriver.exe";
    public WebDriver driver;
    @BeforeTest
    public void setUp() throws InterruptedException {
        System.out.println("CHAY TRINH DUYET CHROME");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    @Test(priority = 0)
    public void loginTest() throws InterruptedException {
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        driver.findElement(By.id("OpenIdConnect")).click();
        Thread.sleep(3000);
        // Nhập tên người dùng
        driver.findElement(By.id("i0116")).sendKeys("quang.2174802010492@vanlanguni.vn");
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(2000);
        // Nhập mật khẩu
        driver.findElement(By.id("i0118")).sendKeys("VLU16012003");
        // Nhấp vào nút Đăng nhập
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(15000);
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(5000);
        // Thao tác tay để xác nhận 2 lớp
        String expectedUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.toString().equalsIgnoreCase(expectedUrl.toString())) {
            System.out.println("Đăng nhập thành công tài khoản VLU - PASS");
        } else {
            System.out.println("Tài khoản không đúng - Thất bại");
        }
    }
    @Test(priority = 1)
    public void TruyCap_Ngành() throws InterruptedException {
        // Mở chức năng học kỳ
    	driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        String expectedUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Major";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.toString().equalsIgnoreCase(expectedUrl.toString())) {
            System.out.println("Hiển thị trang Ngành - PASS");
        } else {
            System.out.println("Có lỗi xảy ra - Thất bại");
        }
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void Add_Major() throws InterruptedException {
    	//Thêm ngành
    	driver.findElement(By.xpath("//*[@id=\"tblMajor_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
    	Thread.sleep(1000);
    	//Mã ngành
    	driver.findElement(By.id("id")).sendKeys("AT242");
    	Thread.sleep(1000);
    	//Tên ngành
    	driver.findElement(By.id("name")).sendKeys("Automation Testing");
    	Thread.sleep(1000);
    	//Tên viết tắt
    	driver.findElement(By.id("abbreviation")).sendKeys("AT");
    	Thread.sleep(1000);
    	//Chọn CTDT
    	driver.findElement(By.id("select2-program_type-container")).click();
        WebElement CTDT = driver.findElement(By.id("program_type"));
        CTDT.findElement(By.xpath("//*[@id=\"program_type\"]/option[2]")).click();
        Thread.sleep(1000);
        //Ấn lưu
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);
		WebElement Message = driver.findElement(By.id("toast-container"));
        if (Message.isDisplayed() && Message.getText().equals("Lưu thành công!")) {
        	System.out.println("Lưu thành công! - PASS");
        } else {
        	System.out.println("Mã ngành này đã tồn tại! - FAIL");
        }
    }
    @Test(priority = 3)
    public void Eror_Mes() throws InterruptedException {
    	driver.findElement(By.xpath("//*[@id=\"tblMajor_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
    	Thread.sleep(1000);
    	//Mã ngành
    	driver.findElement(By.id("id")).sendKeys("");
    	Thread.sleep(1000);
    	//Tên ngành
    	driver.findElement(By.id("name")).sendKeys("");
    	Thread.sleep(1000);
    	//Tên viết tắt
    	driver.findElement(By.id("abbreviation")).sendKeys("");
    	Thread.sleep(1000);
        //Ấn lưu
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(5000);
        // Thông báo lỗi mã ngành
        WebElement ErrorMessage1 = driver.findElement(By.id("id-error"));
        if (ErrorMessage1.isDisplayed() && ErrorMessage1.getText().equals("Bạn chưa nhập mã ngành")) {
        	System.out.println("Thông báo: Bạn chưa nhập mã ngành - PASS");
        } else {
        	System.out.println("Thông báo hiển thị không chính xác - FAIL");
        }
        // Thông báo lỗi tên ngành
        WebElement ErrorMessage2 = driver.findElement(By.id("name-error"));
        if (ErrorMessage2.isDisplayed() && ErrorMessage2.getText().equals("Bạn chưa nhập tên ngành")) {
        	System.out.println("Thông báo: Bạn chưa nhập tên ngành - PASS");
        } else {
        	System.out.println("Thông báo hiển thị không chính xác - FAIL");
        }
        // Thông báo lỗi tên viết tắt của ngành
        WebElement ErrorMessage3 = driver.findElement(By.id("abbreviation-error"));
        if (ErrorMessage3.isDisplayed() && ErrorMessage3.getText().equals("Bạn chưa nhập tên viết tắt của ngành")) {
        	System.out.println("Thông báo: Bạn chưa nhập tên viết tắt của ngành - PASS");
        } else {
        	System.out.println("Thông báo hiển thị không chính xác - FAIL");
        }
        // Thông báo lỗi chưa chọn CTDT
        WebElement ErrorMessage4 = driver.findElement(By.id("program_type-error"));
        if (ErrorMessage4.isDisplayed() && ErrorMessage4.getText().equals("Bạn chưa chọn CTĐT")) {
        	System.out.println("Thông báo: Bạn chưa chọn CTĐT - PASS");
        } else {
        	System.out.println("Thông báo hiển thị không chính xác - FAIL");
        }
    }
    @AfterTest
    public void teardown() {
    	driver.close();
    }
}
