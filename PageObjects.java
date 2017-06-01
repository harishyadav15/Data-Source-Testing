package LogicMonitor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjects {

	static WebElement element = null;

	public static WebElement username(WebDriver driver, String uname) {

		element = driver.findElement(By.id("username"));
		element.sendKeys(uname);
		return element;
	}

	public static WebElement password(WebDriver driver, String psswd) {

		element = driver.findElement(By.id("password"));
		element.sendKeys(psswd);
		return element;
	}

	public static WebElement loginTab(WebDriver driver) {

		element = driver.findElement(By.id("btn-login"));
		element.click();
		return element;
	}

	public static WebElement settingsTab(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='left-nav']/ul/li[7]/a")));
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		
		return element;
	}

	public static WebElement datasourcesTab(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//a[@href='#datasources']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		
		element.click();
		return element;
	}

	public static WebElement collectorTab(WebDriver driver) {

		
		element = driver.findElement(By.xpath("//div[@title='Collector']"));

		
		element.click();
		return element;
	}

	public static WebElement addTab(WebDriver driver) {

		element = driver.findElement(By.id("btn-add-menu"));
		element.click();
		return element;
	}

	public static WebElement datasourceOption(WebDriver driver) {

		element = driver.findElement(By.xpath("//li[@id='btn-add-single']/a"));
		element.click();
		return element;
	}

	public static WebElement nameDataSource(WebDriver driver, String datasourceName) {

		element = driver.findElement(By.id("name"));
		element.clear();
		element.sendKeys(datasourceName);
		return element;
	}

	public static WebElement displayNameDataSource(WebDriver driver) {

		element = driver.findElement(By.id("displayName"));
		element.click();
		return element;
	}

	public static WebElement descriptionDataSource(WebDriver driver, String description) {

		element = driver.findElement(By.id("description"));
		element.sendKeys(description);
		return element;
	}

	public static WebElement groupDataSource(WebDriver driver, String groupName) {

		element = driver.findElement(By.id("group"));
		element.sendKeys(groupName);
		return element;
	}

	public static WebElement appliesToButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@class='btn-applies-to lm-button small gray']"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		return element;
	}

	public static WebElement selectDevices(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id='dialog-content']/div/div[3]/div[1]/label"));
		element.click();
		return element;
	}

	public static WebElement plusButton(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@id='deviceTable']/table/thead/tr/th[3]/div/button"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		return element;
	}

	public static WebElement textBox(WebDriver driver, String deviceName) {

		element = driver.findElement(By.xpath("//input[@class='editable-control ui-autocomplete-input']"));
		element.sendKeys(deviceName);
		return element;
	}

	public static WebElement deviceSaveButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@class='lm-button small-small blue save-btn']"));
		element.click();
		return element;
	}

	public static WebElement testButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@class='lm-button animate left gray btn-foot-test']"));
		element.click();
		return element;
	}

	public static WebElement saveButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {

			element = driver.findElement(By.xpath("//button[@class='lm-button animate left blue btn-save']"));
			wait.until(ExpectedConditions.stalenessOf(element));
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@class='lm-button animate left blue btn-save']")));
		element.click();
		return element;
	}

	public static WebElement testAppliesToButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@class='lm-button animate gray left applies-to-test']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		return element;
	}

	public static WebElement collectEvery(WebDriver driver) {

		element = driver.findElement(By.id("collectInterval"));
		Select sel = new Select(element);
		sel.selectByIndex(0);
		return element;
	}

	public static WebElement collectMethod(WebDriver driver) {

		element = driver.findElement(By.id("collectMethod"));
		Select sel = new Select(element);
		sel.selectByValue("wmi");
		return element;
	}

	public static WebElement classCollectorAttribute(WebDriver driver, String className) {

		element = driver.findElement(By.id("queryClass"));
		element.sendKeys(className);
		return element;
	}

	public static WebElement indexCollectorProperty(WebDriver driver, String indexName) {

		element = driver.findElement(By.id("queryIndex"));
		element.sendKeys(indexName);
		return element;
	}

	public static WebElement indexValueProperty(WebDriver driver, String indexValue) {

		element = driver.findElement(By.id("queryValue"));
		element.sendKeys(indexValue);
		return element;
	}

	public static WebElement addDataPoint(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@class='btn-add-datapoint lm-button blue small']"));
		element.click();
		return element;
	}

	public static WebElement nameDataPoint(WebDriver driver, String dataPointName) {

		element = driver
				.findElement(By.xpath("//input[@class='validate[required,funcCall[LM.utils.validateDatapointName]]']"));
		element.clear();
		element.sendKeys(dataPointName);
		return element;
	}

	public static WebElement descriptionDataPoint(WebDriver driver, String dataPointDescription) {

		element = driver.findElement(By.xpath(".//textarea[@style='height: 67px;']"));
		element.sendKeys(dataPointDescription);
		return element;
	}

	public static WebElement wmiClassAttribute(WebDriver driver, String wmiAttribute) {

		element = driver.findElement(By.name("userParam1"));
		element.sendKeys(wmiAttribute);
		return element;
	}

	public static WebElement metricType(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[3]/div/select[@name='type']"));
		Select sel = new Select(element);
		sel.selectByIndex(2);
		return element;
	}

	public static WebElement minValue(WebDriver driver, String minValidValue) {

		element = driver.findElement(By.id("datapoint-min"));
		element.sendKeys(minValidValue);
		return element;
	}

	public static WebElement maxValue(WebDriver driver, String maxValidValue) {

		element = driver.findElement(By.id("datapoint-max"));
		element.sendKeys(maxValidValue);
		return element;
	}

	public static WebElement alertTab(WebDriver driver) {

		element = driver.findElement(By.xpath("//select[@name='alertForNoData']"));
		Select sel = new Select(element);
		sel.selectByValue("2");
		return element;
	}

	public static WebElement alertInterval(WebDriver driver) {

		element = driver.findElement(By.xpath("//select[@name='alertTransitionInterval']"));
		Select sel = new Select(element);
		sel.selectByIndex(2);
		return element;
	}

	public static WebElement saveDataPoint(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@class='lm-button animate blue btn-save']"));
		element.click();
		return element;
	}

	public static WebElement complexDataPoint(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[1]/label[@for='complex-datapoint']"));
		element.click();
		return element;
	}

	public static WebElement nameComplexDataPoint(WebDriver driver, String complexDataPointName) {

		element = driver
				.findElement(By.xpath("//input[@class='validate[required,funcCall[LM.utils.validateDatapointName]]']"));
		element.clear();
		element.sendKeys(complexDataPointName);
		return element;
	}

	public static WebElement descComplexDataPoint(WebDriver driver, String complexDescription) {

		element = driver
				.findElement(By.xpath("//label[@helper-label-name='description']//following-sibling::textarea"));
		element.sendKeys(complexDescription);
		return element;
	}

	public static WebElement expression(WebDriver driver, String expression) {

		element = driver.findElement(By.id("complex-post-processor-parma"));
		element.sendKeys(expression);
		return element;
	}

	public static WebElement minComplexValue(WebDriver driver, String minValue) {

		element = driver.findElement(By.xpath("//input[@name='minValue']"));
		element.sendKeys(minValue);
		return element;
	}

	public static WebElement maxComplexValue(WebDriver driver, String maxValue) {

		element = driver.findElement(By.xpath("//input[@name='maxValue']"));
		element.sendKeys(maxValue);
		return element;
	}

	public static WebElement alertThreshold(WebDriver driver) {

		element = driver.findElement(By.xpath("//select[@class='alert-expr-op']"));
		Select sel = new Select(element);
		sel.selectByValue(">=");
		return element;
	}

	public static WebElement thresholdValue(WebDriver driver, String thresholdValue) {

		element = driver.findElement(By.xpath("//input[@class='alert-expr-value inline']"));
		element.sendKeys(thresholdValue);
		return element;
	}

	public static WebElement alertNoData(WebDriver driver) {

		element = driver.findElement(By.xpath("//select[@name='alertForNoData']"));
		Select sel = new Select(element);
		sel.selectByValue("2");
		return element;
	}

	public static WebElement complexSaveButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@class='lm-button animate blue btn-save']"));
		element.click();
		return element;
	}

	public static WebElement dataSourceSaveButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@class='lm-button right blue btn-save animate']"));
		element.click();
		return element;
	}

	public static WebElement dataSource(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[@title='CPU Monitor']"));
		return element;
	}

	public static WebElement dataSourceTitle(WebDriver driver) {

		element = driver.findElement(By.xpath("//h1[@class='main-title']"));
		return element;
	}

	public static WebElement updateElement(WebDriver driver) {

		element = driver.findElement(By.xpath("//span[@class='head-title-txt']"));
		return element;
	}

	public static WebElement updateTextBox(WebDriver driver, String updateText) {

		element = driver.findElement(By.xpath("//input[@class='prompt-value validate[required]']"));
		element.sendKeys(updateText);
		return element;
	}

	public static WebElement submitButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@class='lm-button animate blue btn-submit']"));
		element.click();
		return element;
	}

	public static WebElement deleteLink(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@class='btn-delete left link-btn']")); 
		element.click();
		return element;
	}

	public static WebElement okButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@class='lm-button animate blue btn-ok']"));
		element.click();
		return element;
	}
	
	public static WebElement deleteDataSource(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[@title = 'CPU Monitoring System']"));
		
		return element;
	}


}
