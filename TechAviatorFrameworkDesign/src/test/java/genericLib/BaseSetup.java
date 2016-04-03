package genericLib;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

public class BaseSetup {
	
 public WebDriver driver;

 @Parameters({ "browser" })
  @BeforeMethod
  public void LaunchApp(String browname) {
	 
	 if (browname.equals("Firefox")) {
		 driver= new FirefoxDriver();
		 
	} else if (browname.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Softwares\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();		

	} else if (browname.equals("InternetExplorer")) {		
		System.setProperty("webdriver.ie.driver", "C:\\Selenium Softwares\\IEDriver64bit\\IEDriverServer.exe");
		driver= new InternetExplorerDriver();	
	
	}
	  
	 driver.get("http://books.rediff.com/");
	 System.out.println("Successfully launched the " +browname +"Browser");
  }

  @AfterMethod
  public void TearDown() {
	 
	  driver.close();
	  System.out.println("Succcessfully closed the Browser");
  }

}
