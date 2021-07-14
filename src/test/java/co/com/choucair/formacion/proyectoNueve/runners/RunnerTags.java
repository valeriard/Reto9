package co.com.choucair.formacion.proyectoNueve.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions (features = "src/test/resources/features/proyectoNueve.feature",
        tags = "@Tag1",
       glue = "co.com.choucair.formacion.proyectoNueve.stepdefinitions",
        snippets = SnippetType.CAMELCASE )

public class RunnerTags {
}

