package co.com.choucair.formacion.proyectoNueve.tasks;


import co.com.choucair.formacion.proyectoNueve.model.Lista;
import co.com.choucair.formacion.proyectoNueve.userinterface.PageWebYellow;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

import java.util.List;


public class Start implements Task {
    private PageWebYellow pageWebYellow;
    private List<Lista> datacampos;
    
    public Start(List<Lista> datacampos){
        this.datacampos =datacampos;
    }

    public static Start thePageY(List<Lista> datacampos) {
        return Tasks.instrumented(Start.class, datacampos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(pageWebYellow),
                Enter.theValue(datacampos.get(0).getBanks()).into(PageWebYellow.KEYWORD),
                Enter.theValue(datacampos.get(0).getCity()).into(PageWebYellow.WHERE),
                Click.on(PageWebYellow.SEARCH)

                );
    }
}
