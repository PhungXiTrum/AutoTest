package Term;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class UpdateStatusTerm {
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
        Thread.sleep(10000);
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
    public void TrangThaiHocKy() throws InterruptedException {
        // Lấy WebElement của checkbox sau khi thực hiện click
        WebElement checkbox = driver.findElement(By.xpath("//input[@class='form-check-input user-status']"));
        // Lưu trạng thái của checkbox trước khi thay đổi
        boolean isCheckboxCheckedInitially = checkbox.isSelected();
        // Thực hiện thay đổi trạng thái của checkbox
        checkbox.click();
        // Chờ cho hiển thị thông báo
        waitForToastMessage();
        // Lấy lại element checkbox sau khi trạng thái đã thay đổi
        checkbox = driver.findElement(By.xpath("//input[@class='form-check-input user-status']"));
        // Kiểm tra xem có hiển thị thông báo "Cập nhật trạng thái thành công!" không
        boolean isSuccessToastDisplayed = isToastMessageDisplayed("Cập nhật trạng thái thành công!");
        // Kiểm tra trạng thái của checkbox sau khi thay đổi
        boolean isCheckedAfter = checkbox.isSelected();
        // In ra màn hình tùy thuộc vào trạng thái của checkbox sau khi thay đổi và thông báo cập nhật thành công
        if ((isCheckboxCheckedInitially && !isCheckedAfter) && isSuccessToastDisplayed) {
            System.out.println("Cập nhật trạng thái thành công - Khóa - PASS");
        } else if ((!isCheckboxCheckedInitially && isCheckedAfter) && isSuccessToastDisplayed) {
            System.out.println("Cập nhật trạng thái thành công - Mở - PASS");
        } else {
            System.out.println("Cập nhật trạng thái không thành công - FAIL");
        }
        
        // Thực hiện thay đổi trạng thái của checkbox lần 2
        checkbox.click();
        waitForToastMessage();
        // Lấy lại element checkbox sau khi trạng thái đã thay đổi lần 2
        checkbox = driver.findElement(By.xpath("//input[@class='form-check-input user-status']"));
        // Kiểm tra xem có hiển thị thông báo "Cập nhật trạng thái thành công!" không
        boolean isSuccessToastDisplayed1 = isToastMessageDisplayed("Cập nhật trạng thái thành công!");
        // Kiểm tra trạng thái của checkbox sau khi thay đổi lần 2
        boolean isCheckedAfter1 = checkbox.isSelected();
        // In ra màn hình tùy thuộc vào trạng thái của checkbox sau khi thay đổi lần 2 và thông báo cập nhật thành công
        if ((!isCheckboxCheckedInitially && !isCheckedAfter1) && isSuccessToastDisplayed1) {
            System.out.println("Cập nhật trạng thái thành công - Khóa - PASS");
        } else if ((isCheckboxCheckedInitially && isCheckedAfter1) && isSuccessToastDisplayed1) {
            System.out.println("Cập nhật trạng thái thành công - Mở - PASS");
        } else {
            System.out.println("Cập nhật trạng thái không thành công - FAIL");
        }
    }
    private void waitForToastMessage() throws InterruptedException {
        // Thời gian chờ tùy chọn, có thể điều chỉnh
        Thread.sleep(2000); 
    }

    private boolean isToastMessageDisplayed(String message) {
        try {
            WebElement toastMessage = driver.findElement(By.xpath("//*[@id='toast-container']/div/div"));
            String toastText = toastMessage.getText();
            return toastText.contains(message);
        } catch (Exception e) {
        	System.out.print("đã xảy ra lỗi" +e.getMessage());
            return false;
        }
    }
    @AfterTest
    public void teardown() {
    	driver.close();
    }
}
