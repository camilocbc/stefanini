package steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pageObjects.vueloRedondoPageObject;

import java.text.ParseException;

public class vueloRedondoStep {


        vueloRedondoPageObject stefaniniPO;


      public void iniciarNavegador(){

          stefaniniPO.open();

      }
    @Step
      public void BuscarVuelosRedondos(String LugarOrigen,String LugarDestino, String fechaInicio, String fechaFin){

          stefaniniPO.clickVuelvos();
          stefaniniPO.clickViajeRedondo();
          stefaniniPO.clickOrigen();
          stefaniniPO.txtOrigen(LugarOrigen);
      //    stefaniniPO.clickLugar();
          stefaniniPO.clickDestino();
          stefaniniPO.txtDestino(LugarDestino);
        //  stefaniniPO.clickLugar();
          stefaniniPO.btnfechaInicioVuelo();
          stefaniniPO.fechaInicioVuelo(fechaInicio);
          stefaniniPO.fechaFinVuelo(fechaFin);
          stefaniniPO.clickDoneDate();
          stefaniniPO.clickSearch();
      }
    @Step
      public void SeleccionarCajaFiltros(String list) throws ParseException {
          stefaniniPO.assertSelectOption(list);


      }
    @Step
      public void ValidarTiempoVuelo()  {
        stefaniniPO.assertTimeForFly();

      }



}
