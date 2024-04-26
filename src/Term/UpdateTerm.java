package Term;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class UpdateTerm {
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
    public void CapNhatHocKy() throws InterruptedException {
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[9]/a[1]")).click();
    	Thread.sleep(1000);
        WebElement startYearDropdown = driver.findElement(By.id("select2-start_year-container"));
        startYearDropdown.click();
        Thread.sleep(1000); 
        WebElement startYearOption = driver.findElement(By.id("select2-start_year-results"));
        startYearOption.findElement(By.xpath("//option[text()='2024']")).click();
        driver.findElement(By.id("select2-start_year-container")).click();
        Thread.sleep(1000); 

        WebElement endYearDropdown = driver.findElement(By.id("select2-end_year-container"));
        endYearDropdown.click();
        Thread.sleep(1000); 
        WebElement endYearOption = driver.findElement(By.id("select2-end_year-results"));
        endYearOption.findElement(By.xpath("//option[text()='2025']")).click();
        driver.findElement(By.id("select2-end_year-container")).click();
        Thread.sleep(1000); 

        WebElement inputStartWeek = driver.findElement(By.id("start_week"));
        inputStartWeek.clear();
        inputStartWeek.sendKeys("5");
        
        WebElement inputStartDate = driver.findElement(By.cssSelector("[type='text'][placeholder='Chọn ngày bắt đầu']"));
        inputStartDate.click();    
        Thread.sleep(2000);
        selectDateFromFlatpickr("16 Tháng ba, 2024"); // Chọn ngày 16/3/2024
        Thread.sleep(2000);
        
        // Nhập giá trị cho ô input Tiết tối đa
        WebElement inputMaxLesson = driver.findElement(By.id("max_lesson"));
        inputMaxLesson.clear();
        inputMaxLesson.sendKeys("6");
        // Nhập giá trị cho ô input Lớp tối đa
        WebElement inputMaxClass = driver.findElement(By.id("max_class"));
        inputMaxClass.clear();
        inputMaxClass.sendKeys("3");
        Thread.sleep(2000);
        // Submit form (có thể thực hiện các bước kiểm tra tiếp theo sau khi submit)
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);
		WebElement Message = driver.findElement(By.xpath("/html/body/div[4]/div/div"));
        if (Message.isDisplayed() && Message.getText().equals("Cập nhật thành công!")) {
        	System.out.println("Cập nhật thành công! - PASS");
        } else {
        	System.out.println("Cập nhật thất bại! - FAIL");
        }
    }
    // Hàm để chọn ngày từ lịch flatpickr
    public void selectDateFromFlatpickr(String date) {
        // Sử dụng JavascriptExecutor để thiết lập giá trị trực tiếp cho ô input ngày tháng
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1]", driver.findElement(By.cssSelector("[type='text'][placeholder='Chọn ngày bắt đầu']")), date);
    }

    @AfterTest
    public void teardown() {
    	driver.close();
    }
}

