package org.base.classes;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static JavascriptExecutor js;

	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void edgeBrowserLaunch() {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	public static void maxWindow() {
		driver.manage().window().maximize();
	}

	public static void launchURL(String url) {
		driver.get(url);
	}

	public static void getCurrentPageDetails() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void getURL() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void sendText(WebElement refName, String text) {
		refName.sendKeys(text);
	}

	public static void click(WebElement refName) {
		refName.click();
	}

	public static void dragAnddrop(WebElement from, WebElement to) {
		a = new Actions(driver);
		a.dragAndDrop(from, to).perform();
	}

	public static void moveToelement(WebElement target) {
		a = new Actions(driver);
		a.moveToElement(target).perform();
	}

	public static void doubleClick(WebElement target) {
		a = new Actions(driver);
		a.doubleClick(target).perform();
	}

	public static void rightClick(WebElement refName) {
		a = new Actions(driver);
		a.contextClick(refName).perform();
	}

	public static void robot() throws AWTException {
		r = new Robot();
	}

	public static void alertOk() {
		Alert ok = driver.switchTo().alert();
		ok.accept();
	}

	public static void alertCancel() {
		Alert cancel = driver.switchTo().alert();
		cancel.dismiss();
	}

	public static void alertSendText(String enterThetext) {
		Alert text = driver.switchTo().alert();
		text.sendKeys(enterThetext);
	}

	public static void alertGetText() {
		Alert getTxt = driver.switchTo().alert();
		getTxt.getText();
	}

	public static void jsSendKeys(String enterTheValue, WebElement refName) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + enterTheValue + "')", refName);
	}

	public static void jsGetAttribute(WebElement refName) {
		js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute('value')", refName);
	}

	public static void jsClick(WebElement refName) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", refName);
	}

	public static void jsPageUp(WebElement refName) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", refName);
	}

	public static void jsPageDown(WebElement refName) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", refName);
	}

	public static void dropValue(WebElement element, int passIndex) {
		Select s = new Select(element);
		s.selectByIndex(passIndex);

	}

	public static void takeScreenShot(String enterImageNameandImageFormat) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File fromDefault = ts.getScreenshotAs(OutputType.FILE);
		File toLocation = new File(
				"C:\\Users\\sathi\\eclipse-workspace\\Maven_Example\\ScreenShots\\" + enterImageNameandImageFormat);
		FileUtils.copyFile(fromDefault, toLocation);
	}

	public static void sendValueToTables(Sheet sheetRefName, int rowNum, int cellNum, String cellValue) {
		Row row = sheetRefName.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		cell.setCellValue(cellValue);

	}

	public static void createRowAndCellOf10(Sheet sheetRefName) {
		for (int i = 0; i < 10; i++) {
			Row createRow = sheetRefName.createRow(i);
			for (int j = 0; j < 10; j++) {
				Cell createCell = createRow.createCell(j);
			}
		}

	}

	public static String excelValueRead(String copyPathnameFromLocalDisk, String sheetName, int rowNum, int cellNum)
			throws IOException {
		File f = new File(copyPathnameFromLocalDisk);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		int cellType = cell.getCellType();
		String value = "";
		if (cellType == 1) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
			value = simpleDate.format(d);
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			value = String.valueOf(l);
		}
		return value;

	}

	public static void getRowAndCellValue(String pathname, String sheetName, int rowNum, int cellNum, String equalValue,
			String newValue) throws IOException {
		File f = new File(pathname);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String stringCellValue = cell.getStringCellValue();
		if (stringCellValue.equals(equalValue)) {
			cell.setCellValue(newValue);
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}
}