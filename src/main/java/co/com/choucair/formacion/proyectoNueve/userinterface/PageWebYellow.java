package co.com.choucair.formacion.proyectoNueve.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.paginasamarillas.com.co/")
public class PageWebYellow extends PageObject {
    public static final Target KEYWORD = Target.the("Search Keyword: Banco")
            .located(By.xpath("//INPUT[@id='keyword']"));
    public static final Target WHERE = Target.the("Search Location: Medellin")
            .located(By.xpath("//INPUT[@id='locality']"));
    public static final Target SEARCH = Target.the("Search ")
            .located(By.xpath("//BUTTON[@id='buscar']"));
}
