package Term;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ViewListTerm {
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
        Thread.sleep(3000);
    }
    @Test(priority = 0)
    public void loginTest() throws InterruptedException {
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        driver.findElement(By.id("OpenIdConnect")).click();
        Thread.sleep(2000);
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
        Thread.sleep(1000);
    }
    @Test(priority = 1)
    public void TruyCap_HocKy() throws InterruptedException {
        // Mở chức năng học kỳ
    	driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
	public void HienThiDuLieu() throws InterruptedException {
	    //Xem số lượng danh sách học kỳ
		//cick mở dropdown
	    driver.findElement(By.name("tblTerm_length")).click();
	    // Lặp qua từng phần tử trong dropdown và click vào từng mục
	    String[] values = {"10", "25", "50", "-1"};
	    for (String value : values) {
	        // Click vào từng mục
	        driver.findElement(By.cssSelector("option[value='" + value + "']")).click();
	        Thread.sleep(1000);
	        //thông báo cho từng dữ liệu đã chọn
	        System.out.println("Đã chọn hiển thị " + value + " dữ liệu.");
	    }
	}
    @AfterTest
    public void teardown() {
    	driver.close();
    }
}
