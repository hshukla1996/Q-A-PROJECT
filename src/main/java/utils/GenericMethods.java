package utils;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/*  This method enables to check if file is down loaded */

public class GenericMethods{

	private static final WebDriver driver = null;

	protected WebDriverWait wait1;
	static Wait<WebDriver> wait;
	static WebDriverWait webDriverWait;

	public GenericMethods() {

		PageFactory.initElements(driver, this);
	}

	public static boolean isFileDownloaded(String downloadPath, String fileName) {

		try {
			File dir = new File(downloadPath);
			File[] dirContents = dir.listFiles();

			for (int i = 0; i < dirContents.length; i++) {
				if (dirContents[i].getName().contains(fileName)) {
					// File has been found, it can now be deleted:

					dirContents[i].delete();
					return true;
				}
			}
		}

		catch (Exception e) {
			System.out.println("Exception occured ::File not found::" + e.getMessage());
		}

		return false;
	}

	/* This method enables find out one broken links on the web page */

	public static String aBrokelink(WebElement link) {

		String returnValue = "";
		String linkUrl = link.getAttribute("href");

		try {
			URL url = new URL(linkUrl);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			int code = connection.getResponseCode();

			if (code == 200 && !link.getText().isEmpty()) {

				returnValue = link.getText().trim() + " link is working";

			} else if (code == 200 && link.getText().isEmpty()) {

				returnValue = link.getText().trim() + "no link text" + " but is working link";

			} else if (code != 200 && !link.getText().isEmpty()) {

				returnValue = link.getText().trim() + " link is not working";

			} else if (code != 200 && link.getText().isEmpty()) {

				returnValue = link.getText().trim() + "no link text" + " and is not working";
			}

		} catch (Exception e) {
			System.out.println("Exception occured::: Link does not work ::" + e.getMessage());

		}

		return returnValue;

	}

	/* This method enables find out all broken links on the web page 
	@throws Exception
	*/
	public static void aaBrokeLinks() throws Exception {

		ArrayList<String> NoTextNoWork = new ArrayList<String>();
		ArrayList<String> NoTextButWorking = new ArrayList<String>();
		ArrayList<String> LinkNotWorking = new ArrayList<String>();
		ArrayList<String> LinkWorking = new ArrayList<String>();

		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement each : links) {

			String linkUrl = each.getAttribute("href");

			try {
				URL url = new URL(linkUrl);

				HttpURLConnection connection = (HttpURLConnection) url.openConnection();

				int code = connection.getResponseCode();

				if (code == 200 && !each.getText().isEmpty()) {
					LinkWorking.add(linkUrl);
					System.out.println(each.getText() + " is working");
				} else if (code == 200 && each.getText().isEmpty()) {
					NoTextButWorking.add(linkUrl);

				} else if (code != 200 && !each.getText().isEmpty()) {
					LinkNotWorking.add(linkUrl);

				} else if (code != 200 && each.getText().isEmpty()) {
					NoTextNoWork.add(linkUrl);
				}

			} catch (Exception e) {
				System.out.println("Exeption occured::Link dosen't work" + e.getMessage());

			}

		}

		System.out.println("Link is NOT working " + LinkNotWorking.size());
		System.out.println("There is NO linkText and also the link is NOT working= " + NoTextNoWork.size());
		System.out.println("link is working but There is NO link text= " + NoTextButWorking.size());
		System.out.println("The number of working links= " + LinkWorking.size());

	}

	/** Method that will enable to select a/all check box of many check boxes
	@param webelement element;
	@param	String value;
	@throws Exception
      */

	public static void checkBox(List<WebElement> element, String value) throws Exception {

		try {
			String ElementValue = null;

			for (int i = 0; i < element.size(); i++) {

				WebElement EachElement = element.get(i);

				ElementValue = EachElement.getText();

				if (ElementValue.contains(value) & EachElement.isEnabled()) {

					EachElement.click();
				}
			}

			if ((value.equalsIgnoreCase("all"))) {

				for (int i = 0; i < element.size(); i++) {

					WebElement AllElement = element.get(i);

					AllElement.click();
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println("Exception occured:: NoSuchElementException::" + e.getMessage());
		} 
	}
	
	/**
	 * Method that will wait for element to be different categories
	 * 
	 * @param WebElement element, int time
	 * @throws Exception
	 */
	public static void waitForElementBeVisible(WebElement element, int time) throws Exception {

		try {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			System.out.println("Exception occured::No such element::" + e.getMessage());
		}
	}

	
	public static void waitForElementBeClickable(WebElement element, int time) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException e) {
			System.out.println("Exception occured:: NoSuchElementException::" + e.getMessage());
		}
	}

	public static void waitForElementBeClickable(By locator, int time) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (NoSuchElementException e) {
			System.out.println("Exception occured:: NoSuchElementException::" + e.getMessage());
		}
	}

	/** Method that will enable to upload a file 
	@param WebElement elementSendkey, WebElement elementUpload,	WebElement elementDisplayed, String filePath;
	@throws Exception
	*/
	public static void uploadFile(WebElement elementSendkey, WebElement UploadButton, String filePath)
			throws Exception {

		try {
			Thread.sleep(3000);
			waitForElementBeVisible(elementSendkey, 60);
			elementSendkey.sendKeys(filePath);
			waitForElementBeClickable(UploadButton, 60);
			UploadButton.click();
			Thread.sleep(2000);

		} catch (NoSuchElementException e) {
			System.out.println("Exception occured:: NoSuchElementException::" + e.getMessage());
		} 
	}
}
