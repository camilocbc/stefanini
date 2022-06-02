package pageObjects;





import io.vavr.control.Try;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@DefaultUrl("https://www.travelocity.com/")
public class vueloRedondoPageObject extends PageObject {

    utilities utilities;
     Select select ;


    //Elementos
    private String btn_Vuelos = "//span[contains(text(),'Flights')]";
    private String btn_ViajeRedondo = "//span[contains(text(),'Roundtrip')]";
    private String btn_Origen = "//button[@data-stid='location-field-leg1-origin-menu-trigger']";
    private String txt_Origen = "location-field-leg1-origin";
    private String btn_Destino = "//button[@data-stid='location-field-leg1-destination-menu-trigger']";
    private String txt_Destino = "location-field-leg1-destination";
    private String btn_lugar = "//div[2]/ul/li[1]/button";
    private String btn_fechaInicioVuelo = "d1-btn";
    private String btn_fechaFinVuelo ="d2-btn";
    private String lbl_fechaInicio = "//div[1]/h2[@class=\"uitk-date-picker-month-name uitk-type-medium\"]";
    private String lbl_fechaFin = "//*[@id='wizard-flight-tab-roundtrip']/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/h2";
    private String btn_Next = "//button[@data-stid='date-picker-paging'][2]";
    private String date_MesInicio= "//div[2]/div[1]/table/tbody//td/button";
    private String date_MesFin= "//div[2]/div[2]/table/tbody//td/button";
    private String btn_DoneDate = "//button[@data-stid='apply-date-picker']";
    private String btn_Search = "//button[@data-testid='submit-button']";
    private String select_SortBy = "listings-sort";
    private String lbl_TimeForFly = "//div[@data-test-id='journey-duration'][1]";
    private String btn_ResultFlys = "//*[@id=\"AQryAQrcAXY1LXNvcy01MmFmZjVkOGYyNTQ1MmJlMjI5MDU0MDY3OWNhNzY2Mi0wLTEtMX4yLlN-QVFvRUNJSHhCQklIQ05RRUVBY1lHeWdDV0FKd0FBfkFRb2pDaUVJenBZQkVnTTJORGtZaTVBQklJdTRBU2phcjQ4Q01LcXdqd0k0VUVBQVdBRUtKQW9pQ002V0FSSUVNVGN5TUJpTHVBRWdpNUFCS08tOWp3SXd2YjZQQWpoSFFBQllBUklLQ0FFUUFSZ0JLZ0pPU3hnQklnUUlBUkFCS0FJb0F5Z0VNQTARKVyPwvWYUEAiAQEqBRIDCgExEj8KFgoKMjAyMi0wNi0xNRIDTEFTGgNMQVgKFgoKMjAyMi0wNi0xNhIDTEFYGgNMQVMSBxIFQ09BQ0gaAhABIAI=\"]/div/div/div/button/span";


    //Metodos para interactuar con los elementos del sitio web


    public void clickVuelvos(){
        find(By.xpath(btn_Vuelos)).click();


    }
    public void clickViajeRedondo(){
        find(By.xpath(btn_ViajeRedondo)).click();
    }
    public void clickOrigen(){
        find(By.xpath(btn_Origen)).click();
    }
    public void txtOrigen(String LugarOrigen){



        find(By.id(txt_Origen)).sendKeys(LugarOrigen);
        find(By.id(txt_Origen)).sendKeys(Keys.ENTER);

    }
    public void clickDestino(){
        WebElement element = find(By.xpath(btn_Destino));
        element.click();
    }
    public void txtDestino(String LugarDestino){
        find(By.id(txt_Destino)).sendKeys(LugarDestino);
        find(By.id(txt_Destino)).sendKeys(Keys.ENTER);
    }

    public void clickLugar()  {




        try {
            find(By.xpath(btn_lugar)).click();
        }catch (Exception e){

        }
    }



    public void btnfechaInicioVuelo(){
        find(By.id(btn_fechaInicioVuelo)).click();

    }

// datapicker
// Metodo para seleccionar la fecha de inicio del viaje.
    public void fechaInicioVuelo(String fechaInicio) {


            String diaInicio = fechaInicio.split("-")[0];
            String mesInicio = fechaInicio.split("-")[1];
            String anoInicio = fechaInicio.split("-")[2];
            fechaInicio  = mesInicio+ " " + anoInicio;
          System.out.println(fechaInicio);

            String lbl_InicioFecha = find(By.xpath(lbl_fechaInicio)).getText().trim();
        System.out.println(lbl_InicioFecha);


            while ((!lbl_InicioFecha.equals(fechaInicio))){
                btn_Next();
                lbl_InicioFecha = find(By.xpath(lbl_fechaInicio)).getText().trim();

            }

        List<WebElementFacade> date_inicio = findAll(date_MesInicio);

            for (WebElementFacade e : date_inicio){
                System.out.println(e.getAttribute("data-day").trim());
                    if (e.getAttribute("data-day").trim().equals(diaInicio)){
                        e.click();
                        break;
                    }

            }


    }

    public void btn_Next(){

        find(By.xpath(btn_Next)).click();
    }

    public void clickDoneDate(){
        WebElement element = find(By.xpath(btn_DoneDate));
        element.click();

    }

    public void btnfechaFinVuelo(){
        find(By.id(btn_fechaFinVuelo)).click();

    }
    // datapicker
    // Metodo para seleccionar la fecha de fin del viaje.
    public void fechaFinVuelo(String fechaFin) {


        String diaFin = fechaFin.split("-")[0];
        String mesFin = fechaFin.split("-")[1];
        String anoFin = fechaFin.split("-")[2];
        fechaFin  = mesFin + " " + anoFin;
        System.out.println(fechaFin);

        String lbl_InicioFin = find(By.xpath(lbl_fechaFin)).getText().trim();


        while ((!lbl_InicioFin.equals(fechaFin))){
            btn_Next();
            lbl_InicioFin = find(By.xpath(lbl_fechaFin)).getText().trim();

        }

        List<WebElementFacade> date_Fin = findAll(By.xpath(date_MesFin));

        for (WebElementFacade e : date_Fin){
            System.out.println(e.getAttribute("data-day").trim());
            if (e.getAttribute("data-day").trim().equals(diaFin)){
                e.click();
                break;
            }

        }


    }
    public void clickSearch(){
        WebElement element = find(By.xpath(btn_Search));
        element.click();
        utilities.esperaMiliseg(40000);
    }
    public Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }

    //Metodo para validar si existe la caja de orden

    public void assertSelectOption(String list) throws ParseException {
       WebElement mainSelect =  find(By.id(select_SortBy));

      select = getSelect(mainSelect);
    List<WebElement> options = select.getOptions();
    boolean option = false;
    for (WebElement e : options) {
        if (e.getText().equals(list)) {
            option = true;
            e.click();
            if (e.getText().equals("Duration (Shortest)")){
                assertTimeForFlyShortest();
            }else if (e.getText().equals("Duration (Longest)")){
                assertTimeForFlyLongest();
            }else {


            }
            break;
        }
    }
    assertTrue("si existe la opcion ", option);
}

    //Metodo para validar el orden de la lista de resultados de menor a mayor.
    public void assertTimeForFlyShortest() throws ParseException {
        DateFormat  dateFormat = new SimpleDateFormat("HH:mm");
        Date comparar[] = new Date[25];
        String hora ;
        boolean bool = false;
        int contador = 1;
        int contador1 = 1;
        List <WebElementFacade> lista = findAll(By.xpath(lbl_TimeForFly));

        for (WebElementFacade e : lista) {
            hora = e.getText();
            String minutos = hora.split("h ")[1];
            minutos = minutos.split("m ")[0];
            hora = hora.split("h ")[0] + ":" + minutos;
            System.out.println(hora);

            comparar[contador] = dateFormat.parse(hora);
            System.out.println( comparar[contador]);
            contador++;
        }
        for (WebElementFacade e : lista){
            if ((comparar[contador1].before(comparar[contador1+1]))){
                System.out.println(comparar[contador1]);

                bool = true;
            }else {

                bool = false;
            }


            contador1++;

        }
        assertTrue("Esta ordenado de menor a mayor?.",bool);

    }

    public void assertTimeForFly(){
        boolean bool = false;

            try {
                WebElement element = find(By.xpath(lbl_TimeForFly));
                element.isDisplayed();
                bool = true;

                }catch (Exception e){

                bool = false;

            }
        assertTrue("Hora de vuelo visible?", bool);

    }

    //Metodo para validar el orden de la lista de resultados de mayor a menor.
    public void assertTimeForFlyLongest() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm");
        Date comparar[] = new Date[0];
        String hora ;
        boolean bool = false;
        int contador = 0;
        List <WebElementFacade> lista = findAll(By.xpath(lbl_TimeForFly));

        for (WebElementFacade e : lista) {
            hora =e.getText();
            hora = hora.split("h ")[0] + ":" + hora.split("m ")[0];
            System.out.println(hora);
            comparar[contador] = dateFormat.parse(hora);
            if ((comparar[contador].compareTo(comparar[contador+1]) > 1)){
                System.out.println(comparar[contador]);

                bool = true;
            }else {

                bool = false;
            }

            contador++;


        }
        assertTrue("Esta ordenado de mayor a menor?.",bool);

    }








}
