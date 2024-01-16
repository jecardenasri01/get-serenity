package serenity.stepsDefinition.step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import serenity.EjecucionServicios.ok_JsonGet;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class Step_ObtenerTC {

    @Given("data Obtener TC")
    public void dataObtenerTC() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("TEAM");

    }


    @When("^services Ok")
    public void servicesOk() {

        String user = "jeisson.cardenas";
         String key = "z6eiuoog34juw4azrtoqg4efdk6bshktnwo6stculdibple3zoqq";
         String endpoint = "https://dev.azure.com/MetLife-LATAM/ProVida_WebSite_Cloud/";
         String recurso = "_apis/test/Plans/29176/Suites/79344/points?api-version=7.0";

        theActorInTheSpotlight().attemptsTo(ok_JsonGet.ejecutar(user, key, endpoint, recurso));

        theActorInTheSpotlight().should(
                seeThatResponse( "User details should be correct",
                        response -> response.statusCode(200)
                )
        );
    }
    @When("^services Failed")
    public void servicesFailed() {

        String user = "jeisson.cardenas";
        String key = "iboid5y5to2gwvngycohwyixg4k3sxbbz7xvwrnyqqybeyyea7la";
        String endpoint = "https://dev.azure.com/MetLife-Global/Chile%20Digital%20Customer";
        String recurso = "/_apis/test/Plans/1799492/Suites/1805732/points?api-version=7.0";

        theActorInTheSpotlight().attemptsTo(ok_JsonGet.ejecutar(user, key, endpoint, recurso));


    }
    @Then("^response")
    public void response(){
        theActorInTheSpotlight().should(
                seeThatResponse( "User details should be correct",
                        response -> response.statusCode(200)
                )
        );
    }
}
