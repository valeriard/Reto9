package co.com.choucair.formacion.proyectoNueve.interaction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Esperar  implements Interaction {

    private static final Logger LOGGER = Logger.getLogger(Esperar.class.getName());
    private int tiempo;

    public Esperar (int tiempo){
        this.tiempo=tiempo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(tiempo);
        try{Thread.sleep(tiempo);}catch (InterruptedException e){
            LOGGER.log(Level.WARNING,"time of fail ejecution", e);
            Thread.currentThread().interrupt();
        }
    }
    public static Esperar esperar(int tiempo){
        return new Esperar(tiempo);
    }
}
