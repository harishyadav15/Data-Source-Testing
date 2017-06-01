package LogicMonitor;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import LogicMonitor.PageObjects;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DataSource {

	static WebDriver driver;

	private String URL ;

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		URL =  "https://sbdevqademo.logicmonitor.com/santaba/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	
	
	

	@Test(priority = 0)
	public void create() {
		PageObjects.username(driver, "saiharish");
		PageObjects.password(driver, "Salman@15");
		PageObjects.loginTab(driver);
		PageObjects.settingsTab(driver);
		PageObjects.datasourcesTab(driver);
		PageObjects.collectorTab(driver);
		PageObjects.addTab(driver);
		PageObjects.datasourceOption(driver);
		PageObjects.nameDataSource(driver, "CPU Monitor");
		PageObjects.displayNameDataSource(driver);
		PageObjects.descriptionDataSource(driver, "To monitor the usage of CPU");
		PageObjects.groupDataSource(driver, "Collector");
		PageObjects.appliesToButton(driver);
		PageObjects.selectDevices(driver);
		PageObjects.plusButton(driver);
		PageObjects.textBox(driver, "192.168.193.1");
		PageObjects.deviceSaveButton(driver);
		PageObjects.testButton(driver);
		PageObjects.saveButton(driver);
		PageObjects.testAppliesToButton(driver);
		PageObjects.collectEvery(driver);
		PageObjects.collectMethod(driver);
		PageObjects.classCollectorAttribute(driver, "Win32_PerfRawData_PerfOS_Processor");
		PageObjects.indexCollectorProperty(driver, "name");
		PageObjects.indexValueProperty(driver, "_Total");
		PageObjects.addDataPoint(driver);
		PageObjects.nameDataPoint(driver, "PercentProcessorTime");
		PageObjects.descriptionDataPoint(driver, "Gives the value of CPU Percent Processor Time");
		PageObjects.wmiClassAttribute(driver, "PercentProcessorTime");
		PageObjects.metricType(driver);
		PageObjects.minValue(driver, "1");
		PageObjects.maxValue(driver, "10000000");
		PageObjects.alertTab(driver);
		PageObjects.alertInterval(driver);
		PageObjects.saveDataPoint(driver);
		PageObjects.addDataPoint(driver);
		PageObjects.complexDataPoint(driver);
		PageObjects.nameComplexDataPoint(driver, "CPUBusyPercent");
		PageObjects.descComplexDataPoint(driver, "Gives the value of CPU busy percent");
		PageObjects.expression(driver, "100-(PercentProcessorTime/100000)");
		PageObjects.minComplexValue(driver, "1");
		PageObjects.maxComplexValue(driver, "100");
		PageObjects.alertThreshold(driver);
		PageObjects.thresholdValue(driver, "90");
		PageObjects.alertNoData(driver);
		PageObjects.complexSaveButton(driver);
		PageObjects.dataSourceSaveButton(driver);

		String text = PageObjects.dataSource(driver).getText();
		System.out.println(text);
		Assert.assertEquals("CPU Monitor", text);

	}
	

	 @Test(priority = 1)
	public void view() {
		PageObjects.username(driver, "saiharish");
		PageObjects.password(driver, "Salman@15");
		PageObjects.loginTab(driver);
		PageObjects.settingsTab(driver);
		PageObjects.datasourcesTab(driver);
		PageObjects.collectorTab(driver);
		PageObjects.dataSource(driver).click();
		String actualText = PageObjects.dataSourceTitle(driver).getText();
		Assert.assertEquals("CPU Monitor", actualText);

	}

	@Test(priority = 4)
	public void update() {
		PageObjects.username(driver, "saiharish");
		PageObjects.password(driver, "Salman@15");
		PageObjects.loginTab(driver);
		PageObjects.settingsTab(driver);
		PageObjects.datasourcesTab(driver);
		PageObjects.collectorTab(driver);
		PageObjects.dataSource(driver).click();
		PageObjects.nameDataSource(driver, "CPU Monitoring System");
		PageObjects.displayNameDataSource(driver);
		PageObjects.dataSourceSaveButton(driver);
		String text = PageObjects.updateElement(driver).getText();
		Assert.assertEquals("Update Reasons", text);
		PageObjects.updateTextBox(driver, "To modify data source name.");
		PageObjects.submitButton(driver);

	}
	
	@Test(priority = 2)
	public void updateNegative1() {
		PageObjects.username(driver, "saiharish");
		PageObjects.password(driver, "Salman@15");
		PageObjects.loginTab(driver);
		PageObjects.settingsTab(driver);
		PageObjects.datasourcesTab(driver);
		PageObjects.collectorTab(driver);
		PageObjects.dataSource(driver).click();
		PageObjects.nameDataSource(driver, "%^&**");
		
		PageObjects.dataSourceSaveButton(driver);
		

	}
	@Test(priority = 3)
	public void updateNegative2() {
		PageObjects.username(driver, "saiharish");
		PageObjects.password(driver, "Salman@15");
		PageObjects.loginTab(driver);
		PageObjects.settingsTab(driver);
		PageObjects.datasourcesTab(driver);
		PageObjects.collectorTab(driver);
		PageObjects.dataSource(driver).click();
		PageObjects.nameDataSource(driver, " ");
		PageObjects.dataSourceSaveButton(driver);
		

	}

	@Test(priority = 5)
	public void delete() {
		PageObjects.username(driver, "saiharish");
		PageObjects.password(driver, "Salman@15");
		PageObjects.loginTab(driver);
		PageObjects.settingsTab(driver);
		PageObjects.datasourcesTab(driver);
		PageObjects.collectorTab(driver);
		PageObjects.deleteDataSource(driver).click();
		PageObjects.deleteLink(driver);
		PageObjects.okButton(driver);
		

	}
	

	@AfterMethod
	public void afterMethod() {
		
	}

}
