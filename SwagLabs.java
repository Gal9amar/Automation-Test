package homeWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabs {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		swagLabsLogIn(driver, "standard_user", "secret_sauce");
		addToCart(driver);
		checkOutInformation(driver, "gal", "amar", "102030");
		finish(driver);

	}

	public static void swagLabsLogIn(WebDriver driver, String userName, String password) {

		System.out.println("**********************");
		System.out.println("swagLabsLogIn method -  START");

		// active by ID
		driver.findElement(By.cssSelector("#user-name")).sendKeys(userName);
		System.out.println("done entering username: " + userName);

		// active by ID
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		System.out.println("done entering password: " + password);

		// active by ID
		driver.findElement(By.cssSelector("#login-button")).click();
		System.out.println("done clicking on login button");

		System.out.println("swagLabsLogIn method -  END");

	}

	public static void addToCart(WebDriver driver) {

		System.out.println("**********************");
		System.out.println("addToCart method -  START");

		// click on add to cart
		driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
		System.out.println("done clicking on add to cart button");
		// click on cart icon
		driver.findElement(By.cssSelector(".shopping_cart_link")).click();
		System.out.println("done clicking on cart icon");
		// click on checkout button
		driver.findElement(By.cssSelector("#checkout")).click();
		System.out.println("done clicking on checkout button");

		System.out.println("addToCart method -  END");

	}

	public static void checkOutInformation(WebDriver driver, String firstName, String lastName, String zipCode) {

		System.out.println("**********************");
		System.out.println("checkOutInformation method -  START");

		// add first name to field
		driver.findElement(By.cssSelector("#first-name")).sendKeys(firstName);
		System.out.println("done inserting first name: " + firstName);
		// add last name to field
		driver.findElement(By.cssSelector("#last-name")).sendKeys(lastName);
		System.out.println("done inserting last name: " + lastName);
		// add zip code to field
		driver.findElement(By.cssSelector("#postal-code")).sendKeys(zipCode);
		System.out.println("done inserting zipcode: " + zipCode);
		// pressing continue button
		driver.findElement(By.cssSelector("#continue")).click();

		System.out.println("checkOutInformation method -  END");

	}

	public static void finish(WebDriver driver) throws InterruptedException {

		System.out.println("**********************");
		System.out.println("finish method -  START");

		// press finish button
		driver.findElement(By.cssSelector("#finish")).click();
		System.out.println("done clicking on finish button");

		// check if order is finish by catch "thank you" text on screen
		String expected = "THANK YOU FOR YOUR ORDER";
		String actual = driver.findElement(By.cssSelector("#checkout_complete_container>h2")).getText();

		if (expected.equals(actual)) {

			String url = driver.getCurrentUrl();
			if (url.equals("https://www.saucedemo.com/checkout-complete.html")) {
				System.out.println("Current URL: " + url);
				System.out.println(expected + " Program Ended have a nice score !!!");
				System.out.println("--------------------");
				System.out.println("Test Case 01  - PASS");
				System.out.println("--------------------");
			} else {
				System.err.println("ERROR - url does not match");
			}

		} else {

			System.err.println("ERROR CHECK YOUR CODE");
		}
		System.out.println("finish method -  END");
		System.out.println("**********************");

		// alert message for ending program
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('Program Is Ending. Have A Nice Day');");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.quit();

	}
}
