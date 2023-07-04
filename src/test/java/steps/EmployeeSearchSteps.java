package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;


public class EmployeeSearchSteps extends CommonMethods {

    @When("user clicks on PIM option and Employee list option")
    public void user_clicks_on_pim_option_and_employee_list_option() {
        //we are clicking on pim and emp list option
      //  WebElement pim = driver.findElement(By.id("menu_pim_viewPimModule"));
       // pim.click();
        click(dashboardPage.pimOption);
       // WebElement EmpListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        click(dashboardPage.empListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
       // WebElement searchIdTextBox = driver.findElement(By.id("empsearch_id"));
        // searchIdTextBox.sendKeys("780852");
        sendText("54469A", employeeSearchPage.idTextField);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
       // WebElement searchBtn = driver.findElement(By.id("searchBtn"));
       // searchBtn.click();
        click(employeeSearchPage.searchButton);
    }

    @Then("user is able to see employee information")
    public void user_is_able_to_see_employee_information() {
        System.out.println("Employee is displayed");
    }

    @When("user enters valid employee name in name text box")
    public void user_enters_valid_employee_name_in_name_text_box() {
       // WebElement empNameField = driver.findElement(By.id("empsearch_employee_name_empName"));
       // empNameField.sendKeys("Zhuldyz Azim");
        sendText("Zhuldyz", employeeSearchPage.nameTextField);
    }
}
