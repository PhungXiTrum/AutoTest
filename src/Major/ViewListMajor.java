package Major;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ViewListMajor {
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
    }
    @Test(priority = 2)
	public void HienThiDuLieu() throws InterruptedException {
	    //Xem số lượng danh sách học kỳ
	    driver.findElement(By.name("tblMajor_length")).click();
	    // Lặp qua từng phần tử trong dropdown và click vào từng mục
	    String[] values = {"10", "25", "50", "-1"};
	    for (String value : values) {
	        // Click vào từng mục
	        driver.findElement(By.cssSelector("option[value='" + value + "']")).click();
	        Thread.sleep(1000);
	        //thông báo cho từng dữ liệu đã chọn
	        System.out.println("Đã chọn hiển thị " + value + " dữ liệu - PASS");
	    }
	}
    @AfterTest
    public void teardown() {
    	driver.close();
    }
}
