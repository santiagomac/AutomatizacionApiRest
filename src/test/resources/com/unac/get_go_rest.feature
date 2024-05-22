Feature: automatizacion de rest api - pom
  yo como estudiente de calidad de software
  necesito construir una peticion a una api
  para aprender a automtizar servicios

  Scenario: consultar un usuario con metodo get
    Given se establece la base url "https://gorest.co.in/"
    When se consulta en el endpoint "public/v2/users/"  por id "6919898"
    Then se valida que el status code 200 y que contenga el nombre "Ekaling Prajapat"

  Scenario: actualiazr un usuario con metodo PUT
    Given se establece la base url "https://gorest.co.in/"
    When se consulta el endpoint "public/v2/users/" por id "6919898" con el metodo PUT con el nombre "Ekaling Prajapat" y el email "ekaling_prajapat@gmail.com"
    Then se valida que el status code 200, que contenga el nombre "Ekaling Prajapat" y el email "ekaling_prajapat@gmail.com"
