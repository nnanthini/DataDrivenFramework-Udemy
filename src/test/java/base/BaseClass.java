package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static WebDriver driver = null;
	public static Properties configProperties = new Properties();
	public static Properties pathProperties = new Properties();
	public static FileInputStream fis = null;
	public static Logger log = Logger.getLogger("appLogger");

	@BeforeSuite
	public void setUp() {

		String configFilePath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\properties\\config.properties";
		File configFile = new File(configFilePath);

		try {
			fis = new FileInputStream(configFile);
			configProperties.load(fis);
			log.info("Loading config properties file");
		} catch (Throwable t) {
			// TODO Auto-generated catch block
			log.debug(t.getMessage());
			
		}

		String pathFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\path1.properties";
		File pathFile = new File(pathFilePath);

		try {
			fis = new FileInputStream(pathFile);
			pathProperties.load(fis);
			log.info("Loading path properties file");
		} catch (Throwable t) {
			// TODO Auto-generated catch block
			log.debug(t.getMessage());
		}

		if (driver == null) {

			if (configProperties.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				log.info("Initialising Chrome Driver");

			} else if (configProperties.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
				log.info("Initialising Firefox Driver");

			}
			if (configProperties.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				log.info("Initialising IE Driver");

			}

		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String url = configProperties.getProperty("url");
		driver.get(url);
		log.info("Navigating to url "+url);
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();

	}

}
