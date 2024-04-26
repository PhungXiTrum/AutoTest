package Term;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DeleteTerm {
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
        Thread.sleep(5000);
        // Nhập tên người dùng
        driver.findElement(By.id("i0116")).sendKeys("quang.2174802010492@vanlanguni.vn");
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(3000);
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
    public void KiemHocKy() throws InterruptedException {
    	// mở lại học kỳ
    	driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
        Thread.sleep(2000);
        // Nhập ô tìm kiếm 
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys("242");
        Thread.sleep(2000);
        WebElement Message = driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody"));
        if (Message.isDisplayed() && Message.getText().equals("Không tìm thấy kết quả")) {
        	System.out.println("Không tìm thấy kết quả - Học kỳ chưa được tạo - PASS");
        } else {
        	System.out.println("Tìm thấy học kỳ - PASS");
        }
    }
    @Test(priority = 2)
    public void XoaHocKy() throws InterruptedException {
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[9]/a[2]")).click();
    	Thread.sleep(2000);
    	//Xác nhận xóa
    	driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
    	Thread.sleep(2000);
		WebElement Message = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
		// Lấy văn bản của thông báo
        String toastMessage = Message.getText();
        // Kiểm tra xem thông báo có chứa "Xóa thành công!" không
        if (toastMessage.equals("Xoá thành công!")) {
            System.out.println("Xóa thành công! - PASS");
        } else {
            System.out.println("Xóa thất bại - FAIL");
        }
        Thread.sleep(2000);
    }
    @AfterTest
    public void teardown() {
    	driver.close();
    }
}
