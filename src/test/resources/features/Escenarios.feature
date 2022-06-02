@VueloRedondo
Feature: Pruebas Automatizacion Stefanini
  @Caso1
  Scenario Outline: Consulto vuelvos y valido el tiempo.
    Given Ingreso al travelocity
    When Busco Vuelo Redondo <LugarOrigen> <LugarDestino> <fechaInicio> <fechaFin>
    Then  Validar Tiempo de Vuelo
    And  Validar Por Orden <list>



    Examples:
      | LugarOrigen | LugarDestino | fechaInicio | fechaFin | list |
      | "LAS" | "LAX" | "1-August-2022"  | "1-October-2022" |  "Duration (Shortest)"  |
      #| "LAS" | "LAX" | "1-August-2022"  | "1-October-2022" |  "Duration (Longest)"  |
     # | "LAS" | "LAX" | "1-August-2022"  | "1-October-2022" |  "Price (Lowest)  |