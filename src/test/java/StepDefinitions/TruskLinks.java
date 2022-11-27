package StepDefinitions;

import WebPages.GooglePages.ResultsPage;
import WebPages.GooglePages.SearchPage;
import WebPages.TruskPages.WelcomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TruskLinks {
    private SearchPage searchPageGoogle;
    private ResultsPage resultsPage;
    private WelcomePage welcomePage;
    public TruskLinks(){
        searchPageGoogle=new SearchPage();
        resultsPage=new ResultsPage();
        welcomePage=new WelcomePage();
    }


    @Given("the user on the google page {string}")
    public void theUserOnTheGooglePageGoogleUrl(String GoogleURL) throws InterruptedException {
        searchPageGoogle.VerifytheCurrentLink(GoogleURL);
    }

    @And("the user verify that the search bar is empty")
    public void theUserVerifyThatTheSearchBarIsEmpty() {

    }

    @Then("the user fill the search bar with the word {string}")
    public void theUserFillTheSearchBarWithTheWordTrusk(String searchElements) throws InterruptedException {
        searchPageGoogle.fillThefieldinGoogleBarSearch(searchElements);
    }


    @When("the user hits the button")
    public void theUserHitsTheButton() throws InterruptedException {
        searchPageGoogle.ClickOntheGoogleSearchButton();

    }

    @Then("the first result must contain this keywords {string}")
    public void theFirstResultMustContainThisKeywordsKeywords(String keyword) {
        resultsPage.UserVerifytheFirstResult(keyword);
    }

    @When("the user click on the first result")
    public void theUserClickOnTheFirstResult() {
        resultsPage.UserClickOntheFirstLink();
    }

    @Then("the user must verify that he is redirected to this link {string}")
    public void theUserMustVerifyThatHeIsRedirectedToThisLinkTruskLink(String link) {
        resultsPage.userVerifythecurrentLink(link);
    }

    @When("the user click on {string}")
    public void theUserClickOnDevenirTrusker(String elements) {
        welcomePage.UserClickonTheLink(elements);
    }

    @Then("the user is redirected to right link {string}")
    public void theUserIsRedirectedToRightLink(String arg0) {
        welcomePage.theUserisRedirectedTotheCorrectURL(arg0);
    }
}
