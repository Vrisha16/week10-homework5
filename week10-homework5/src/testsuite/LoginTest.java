package testsuite;
/*Create the package ‘testsuite’ and create the following
class inside the ‘testsuite’ package.
 1. LoginTest*/

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl ="https://courses.ultimateqa.com/";
    @Before
    public void setup(){openBrowser(baseurl);}
    @Test
    public void test1() throws InterruptedException {
    WebElement loginLink = driver.findElement(By.className("signin"));
        loginLink.click();

    WebElement welcomeMessage=driver.findElement(By.xpath("//h1[contains(text(),'Worldclass Automation Training!')]"));

    String actualMessage = welcomeMessage.getText();
    String expectedMessage = "Worldclass Automation Training!";
        Assert.assertEquals("Verifying WelcomeMessage", expectedMessage,actualMessage);
}

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Navigate to the base URL
        driver.get ("https://courses.ultimateqa.com/");

        // Click on the 'Sign In' link
        driver.findElement(By.linkText("Sign In")).click();

        // Verify the text 'Welcome Back!'
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() {
        // Navigate to the base URL
        driver.get ("https://courses.ultimateqa.com/");

        // Click on the 'Sign In' link
        driver.findElement(By.linkText("Sign In")).click();

        // Enter invalid username
        String invalidUsername = "invalid_username";
        driver.findElement(By.id("username")).sendKeys(invalidUsername);

        // Enter invalid password
        String invalidPassword = "invalid_password";
        driver.findElement(By.id("password")).sendKeys(invalidPassword);

        // Click on Login button
        driver.findElement(By.id("login-button")).click();

        //  'Invalid email or password.'
        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = driver.findElement(By.cssSelector(".error-message")).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void tearDown() { closeBrowser();
}
}








