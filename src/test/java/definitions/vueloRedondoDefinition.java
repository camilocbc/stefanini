package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.vueloRedondoStep;

public class vueloRedondoDefinition {
    @Steps
    vueloRedondoStep vueloRedondoStep;

    @Given("^Ingreso al travelocity$")
    public void ingresoAlTravelocity() {
        vueloRedondoStep.iniciarNavegador();
    }

    @When("^Busco Vuelo Redondo \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void buscoVueloRedondo(String LugarOrigen,String LugarDestino, String fechaInicio, String fechaFin) throws Exception {
        vueloRedondoStep.BuscarVuelosRedondos(LugarOrigen,LugarDestino,fechaInicio,fechaFin);
    }



    @Then("^Validar Tiempo de Vuelo$")
    public void validarTiempoDeVuelo() throws Exception {
        vueloRedondoStep.ValidarTiempoVuelo();
    }

    @Then("^Validar Por Orden \"([^\"]*)\"$")
    public void validarPorOrden(String List) throws Exception {
        vueloRedondoStep.SeleccionarCajaFiltros(List);
    }


}
