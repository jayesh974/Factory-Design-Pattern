package factory;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactoryWithSupplierImpl {
	
	private DriverFactoryWithSupplierImpl() {}
	
	private final static Supplier<WebDriver> CHROME = () -> {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	};
	
	private final static Supplier<WebDriver> FIREFOX = () -> {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	};
	
	private final static Supplier<WebDriver> OPERA = () -> {
		WebDriverManager.operadriver().setup();
		return new OperaDriver();
	};
	
	private static final Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);
	
	static {
		MAP.put(BrowserType.CHROME, CHROME);
		MAP.put(BrowserType.FIREFOX, FIREFOX);
		MAP.put(BrowserType.OPERA, OPERA);
	}
	
	public static WebDriver getDriver(BrowserType browser) {
		return MAP.get(browser).get();
	}
	
}
