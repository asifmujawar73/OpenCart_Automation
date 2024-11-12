package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups = { "Sanity", "Regression", "Master" }) // "Datadriven"
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {

//		Loading confige.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());

		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

//			os
			if (os.equalsIgnoreCase("Windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);

			} else {
				System.out.println("Invalied browser");
				return;
			}

//			browser
			switch (br.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("Invalied browser");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		}

//		local
		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid browser name...");
				return;
			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" }) // , "Datadriven keeping out bcoz its take lot time to
																// execute.
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	// Replaces the deprecated method randomAlphabetic with Random + SecureRandom
	public String randomeString() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		SecureRandom random = new SecureRandom();
		StringBuilder result = new StringBuilder(5);
		for (int i = 0; i < 5; i++) {
			result.append(characters.charAt(random.nextInt(characters.length())));
		}
		return result.toString();
	}

	// Replaces the deprecated method randomNumeric with Random
	public String randomeNumber() {
		Random random = new Random();
		StringBuilder result = new StringBuilder(10);
		for (int i = 0; i < 10; i++) {
			result.append(random.nextInt(10)); // Generates digits 0-9
		}
		return result.toString();
	}

	// Generates alphanumeric string with a combination of alphabetic and numeric
	// parts
	public String randomAlphaNumeric() {
		String alphabetic = randomeString();
		String numeric = randomeNumber().substring(0, 3); // Only get the first 3 digits

		return (alphabetic + "@" + numeric);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}
}
