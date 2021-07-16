package co.com.choucair.formacion.proyectoNueve.stepdefinitions;

import co.com.choucair.formacion.proyectoNueve.model.Lista;
import co.com.choucair.formacion.proyectoNueve.tasks.See;
import co.com.choucair.formacion.proyectoNueve.tasks.Start;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ProyectoNueveStepDefinitions {

    @Before
    public void initialConfiguration(){
        setTheStage(new OnlineCast());
    }

    @Given("^I want to consult in the search fields$")
    public void iWantToConsultInTheSearchFields(List<Lista> data) {
        theActorCalled("I").wasAbleTo(Start.thePageY(data));

    }

    @When("^The information of these is displayed$")
    public void theInformationOfTheseIsDisplayed() {
        theActorInTheSpotlight().attemptsTo(See.ListBanks());
    }

    @Then("^I verify that the link on the website leads to the corresponding bank$")
    public void iVerifyThatTheLinkOnTheWebsiteLeadsToTheCorrespondingBank() {

    }



}
