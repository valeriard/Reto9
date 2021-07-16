package co.com.choucair.formacion.proyectoNueve.interaction;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Set;

public class AbrirNuevaPestaña implements Interaction {
    private static WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
    @Override
    public <T extends Actor> void performAs(T actor) {
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindow =driver.getWindowHandles();


    }
}
