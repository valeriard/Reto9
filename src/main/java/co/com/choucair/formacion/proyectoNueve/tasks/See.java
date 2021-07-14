package co.com.choucair.formacion.proyectoNueve.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

import java.util.logging.Logger;


public class See implements Task {
    private static WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
    private static final Logger LOGGER = Logger.getLogger(See.class.getName());

    public static See ListBanks() {
        return Tasks.instrumented(See.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElement> allBanks = driver.findElements(By.xpath("//span[@class='semibold'][contains(.,'')]"));
        String auxiliar;
        String Bancos;
        for (int i=0; i < 14; i++){
         try{
             auxiliar = allBanks.get(i).getText();
            boolean isNumeric = StringUtils.isNumeric(auxiliar);  //Compruebo si una cadena es un numero
            if(isNumeric == false){
                Bancos = auxiliar;
                System.out.println(Bancos);
            }

         }catch (Exception e){
             LOGGER.info("Error text property was not found");
            }

        }
    }
}