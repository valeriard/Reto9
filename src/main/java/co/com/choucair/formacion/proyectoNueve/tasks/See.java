package co.com.choucair.formacion.proyectoNueve.tasks;


import co.com.choucair.formacion.proyectoNueve.interaction.CrearExcel;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;


public class See implements Task {

    private static WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
    private static final Logger LOGGER = Logger.getLogger(See.class.getName());


    public static See ListBanks() {
        return Tasks.instrumented(See.class);
    }
   public String titulos[] = new String[11];
    String bancos[] = new String[15];
    String listalinks[] = new String[10];
    @Override
    public <T extends Actor> void performAs(T actor) {
        String listabancos[] = new String[15];
        String basura[] = new String[15];
        List<WebElement> allBanks = driver.findElements(By.xpath("//span[@class='semibold'][contains(.,'')]"));
        List<WebElement> allLinks = driver.findElements(By.xpath("//a[contains(.,'www')]"));
        for (int i = 0; i <= 13; i++) {
            listabancos[i] = allBanks.get(i).getText();
            boolean isNumeric = StringUtils.isNumeric(listabancos[i]);  //Compruebo si una cadena es un numero
            if (isNumeric == true) {
                basura[i] = listabancos[i];
            } else {
                bancos[i] = listabancos[i];
            }
        }
        String aux="";
        for (int j = 0; j < bancos.length - 1; j++) {
            for(int k=0; k< bancos.length-1;k++){
            if (bancos[k] == null) {
                aux=bancos[k];
                bancos[k] = bancos[k + 1];
                bancos[k+1]=aux;
            }
            }
        }System.out.println(Arrays.toString(bancos));
        for (int l = 0; l < 10; l++) {
            listalinks[l] = allLinks.get(l).getText();
        }System.out.println(Arrays.toString(listalinks));

        openWebPages(listalinks);
        change(listalinks);
        Comprobar(titulos,listalinks);
        //int tamano= bancos.length;
        //CrearExcel.CrearExcel(bancos,listalinks,tamano);

        }

    public void openWebPages (String[] array){
        for(int i = 0; i < array.length; ++i) {
            String selectLinkOpenInNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
            driver.findElement(By.linkText(array[i])).sendKeys(selectLinkOpenInNewTab);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void change(String[] array) {
        Set<String> Nrototalventanas = driver.getWindowHandles();
        int Nroventana = Nrototalventanas.size();
        for (int VentanaIndex = Nroventana - 1; VentanaIndex > 0; --VentanaIndex) {
            driver.switchTo().window(Nrototalventanas.toArray()[VentanaIndex].toString());
            titulos[VentanaIndex] = driver.getTitle();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } System.out.println(Arrays.toString(titulos));

    }
    public void Comprobar(String[] array1,String[] array2 ){
        String[] listabancos2 = new String[10];
        for(int i=0; i < 10 ; i++){
        if(titulos[i] == listalinks[i]){
            listabancos2[i]= titulos[i];
        }}

        }//System.out.println(Arrays.toString(titulos));

    }





