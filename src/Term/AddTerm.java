package Term;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AddTerm {
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
        String expectedUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Term";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.toString().equalsIgnoreCase(expectedUrl.toString())) {
            System.out.println("Chuyển sang trang học kỳ- PASS");
        } else {
            System.out.println("Có lỗi xảy ra - Thất bại");
        }
        Thread.sleep(1000);
    }
    @Test(priority = 2)
    public void ThemHocKy() throws InterruptedException {
        // Ấn nút thêm học kỳ
    	driver.findElement(By.xpath("//*[@id=\"tblTerm_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();        
    	Thread.sleep(2000);
        // Tìm và nhập giá trị cho ô input Học kỳ
        WebElement inputHocKy = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input"));
        inputHocKy.sendKeys("242");
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
        selectCurrentDateFromFlatpickr();
        Thread.sleep(2000);
        inputStartDate.click();
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
        Thread.sleep(2000);
		WebElement Message = driver.findElement(By.xpath("/html/body/div[4]/div/div"));
        if (Message.isDisplayed() && Message.getText(	).equals("Lưu thành công!")) {
        	System.out.println("Lưu thành công! - PASS");
        } else {
        	System.out.println("Học kỳ nãy đã được tạo trong hệ thống - FAIL");
        }
    }
    @Test(priority = 3)
    public void Eror_Mes() throws InterruptedException {
    	// Ấn nút thêm học kỳ
    	driver.findElement(By.xpath("//*[@id=\"tblTerm_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();        
    	Thread.sleep(2000);
        // Tìm và nhập giá trị cho ô input Học kỳ
        WebElement inputHocKy = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input"));
        inputHocKy.sendKeys("");
        WebElement startYearDropdown = driver.findElement(By.id("select2-start_year-container"));
        startYearDropdown.click();
        Thread.sleep(1000); 
        WebElement startYearOption = driver.findElement(By.id("select2-start_year-results"));
        startYearOption.findElement(By.xpath("//option[text()='2026']")).click();
        driver.findElement(By.id("select2-start_year-container")).click();
        Thread.sleep(1000); 

        WebElement inputStartDate = driver.findElement(By.cssSelector("[type='text'][placeholder='Chọn ngày bắt đầu']"));
        inputStartDate.clear();    
        Thread.sleep(2000);
        
        // Submit form (có thể thực hiện các bước kiểm tra tiếp theo sau khi submit)
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);
		WebElement Message = driver.findElement(By.xpath("/html/body/div[4]/div/div"));
        if (Message.isDisplayed() && Message.getText(	).equals("Lưu thành công!")) {
        	System.out.println("Lưu thành công! - PASS");
        } else {
        	System.out.println("Học kỳ nãy đã được tạo trong hệ thống - FAIL");
        }
    }
    // Hàm để chọn ngày từ lịch flatpickr và đảm bảo ngày được hiển thị trong ô input
    public void selectCurrentDateFromFlatpickr() throws InterruptedException {
        // Tìm và nhấp vào phần tử ngày hiện tại trên lịch flatpickr
        WebElement currentDayElement = driver.findElement(By.xpath("//span[@class='flatpickr-day today']"));
        currentDayElement.click();
        
        // Chờ 1 giây để đảm bảo rằng ngày đã được chọn thành công
        Thread.sleep(1000);
    }
    
    @AfterTest
    public void teardown() {
    	driver.close();
    }
}