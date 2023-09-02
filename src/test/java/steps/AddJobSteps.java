package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.CommonMethods;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class AddJobSteps extends CommonMethods {
    String title;
    String jDescription;
    String jobNote;

    @Then("user clicks on the admin button")
    public void user_clicks_on_the_admin_button() {
        click(dashboardPage.adminButton);
    }

    @Then("user clicks on the job button")
    public void user_clicks_on_the_job_button() {
        click(dashboardPage.adminJobButton);
    }

    @Then("user clicks on Job Titles")
    public void user_clicks_on_job_titles() {
        click(dashboardPage.adminJobJobTitleButton);
    }

    @Then("user clicks on the add button")
    public void user_clicks_on_the_add_button() {
        click(jobPage.addButton);
    }

    @Then("user enters job {string} title")
    public void user_enters_job_title(String jobTitle) {
        sendText(jobTitle, jobPage.jobTitleF);
        title = jobTitle;
    }

    @Then("user enters job description {string}")
    public void user_enters_job_description(String jobDescription) {
        sendText(jobDescription, jobPage.jobDescF);
        jDescription = jobDescription;
    }

    @Then("user enters job note {string}")
    public void user_enters_job_note(String note) {
        sendText(note, jobPage.jobNoteF);
        jobNote = note;
    }

    @Then("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
click(jobPage.jobSvBtn);
    }

    @Then("verify data is stored properly in database")
    public void verify_data_is_stored_properly_in_database() {
        String query="select * from ohrm_job_title where job_title='"+title+"' and job_description='"+jDescription+"' and note='"+jobNote+"';";
        List<Map<String, String>> data = DBUtils.fetch(query);
        Map<String,String> firstROw=data.get(0);
        String jTitleBE=firstROw.get("job_title");
        String jDescBE=firstROw.get("job_description");
        String jNoteBE=firstROw.get("note");

        Assert.assertEquals(title,jTitleBE);
        Assert.assertEquals(jDescription,jDescBE);
        Assert.assertEquals(jobNote,jNoteBE);
    }

}
