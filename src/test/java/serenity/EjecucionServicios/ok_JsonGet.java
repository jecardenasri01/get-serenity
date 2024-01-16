package serenity.EjecucionServicios;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;


public class ok_JsonGet implements Task {

    public String user;
    public String key;
    public String endpoint;
    public String recurso;

    public ok_JsonGet(String user, String key, String endpoint, String recurso) {
        this.user = user;
        this.key = key;
        this.endpoint = endpoint;
        this.recurso = recurso;
    }
    public static ok_JsonGet ejecutar(String user, String key, String endpoint, String recurso) {
        return new ok_JsonGet( user,  key,  endpoint,  recurso);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(endpoint));
        actor.attemptsTo(
                Get.resource(recurso).
                        with(request -> request.auth().preemptive().basic(user, key).contentType("application/json; charset=utf-8")
                        )
        );

    }
}
