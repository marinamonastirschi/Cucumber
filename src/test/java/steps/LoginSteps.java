package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Log;


public class LoginSteps extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        // to launch chrome browser
     /* driver = new ChromeDriver();
      driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
      driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); */
        openBrowserAndNavigateToURL();


    }

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        //creating the object of the class to access all the web elements from it
        // LoginPage loginPage = new LoginPage();
        //WebElement usernameField = driver.findElement(By.id("txtUsername"));
        // WebElement passwordField = driver.findElement(By.id("txtPassword"));
        //entering the credentials
        // usernameField.sendKeys(ConfigReader.getPropertyValue("username"));
        // passwordField.sendKeys(ConfigReader.getPropertyValue("password"));
        // we are calling DOMConfigurator which is asking for the file which we used
        // to integrate logs in our project
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("My batch 16 test case starts here");
        sendText(ConfigReader.getPropertyValue("username"), loginPage.usernameField);
        Log.info("my username has been added");
        sendText(ConfigReader.getPropertyValue("password"), loginPage.passwordField);
        Log.info("my password has been added");
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        //LoginPage loginPage = new LoginPage();
        // WebElement loginButton = driver.findElement(By.name("Submit"));
        // loginButton.click();
        click(loginPage.loginButton);
    }

    @Then("user is successfully logged in the application")
    public void user_is_successfully_logged_in_the_application() {
        System.out.println("logged in");
    }

    @When("user enters ess username and password")
    public void user_enters_ess_username_and_password() {
        // LoginPage loginPage = new LoginPage();
        // WebElement usernameField = driver.findElement(By.id("txtUsername"));
        // WebElement passwordField = driver.findElement(By.id("txtPassword"));
        //logged in via normal employee
        // usernameField.sendKeys("dalima123");
        // passwordField.sendKeys("Hum@nhrm123");
        sendText("dalima", loginPage.usernameField);
        sendText("Hum@nhrm123", loginPage.passwordField);
      //  System.out.println(10/0);
    }

    @When("user enters invalid admin username and password")
    public void user_enters_invalid_admin_username_and_password() {
        // LoginPage loginPage = new LoginPage();
        // WebElement usernameField = driver.findElement(By.id("txtUsername"));
        // WebElement passwordField = driver.findElement(By.id("txtPassword"));
        // usernameField.sendKeys("admin123");
        // passwordField.sendKeys("Hum@nhrm123");
        sendText("admin123", loginPage.usernameField);
        sendText("humn", loginPage.passwordField);
    }

    @Then("error message is displayed")
    public void error_message_is_displayed() {
        System.out.println("error message is displayed");
    }

    @When("user enters {string} and {string} and verifying the {string} for the combinations")
    public void user_enters_and_and_verifying_the_for_the_combinations(String username, String password, String errorMessageExpected) {
// we need to write here the code to match
        sendText(username, loginPage.usernameField);
        sendText(password, loginPage.passwordField);
        click(loginPage.loginButton);
        // fetching the error message from the web element
        String errorMessageActual = loginPage.errorMessageField.getText();
        //error message coming from feature file too which we can compare
        Assert.assertEquals("values do not match",errorMessageExpected, errorMessageActual);
    }
}
