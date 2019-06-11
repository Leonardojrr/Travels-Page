var container = document.createElement("div"); //Contenedor de la pagina
container.classList = "container";
document.body.appendChild(container); //Inclusion del contenedor al body

var h = new Header(); //Se instancia la clase header que me genera un header regular
h.insertarHeader(container,"media/logo.png","#","#","#","Iniciar Sesión");//Me inicia el metodo para insertar el header

/**
 * Tracking
 */

 var tracking_div = document.createElement("div");//Div contenedor del tracking section
 tracking_div.id = "tracking_div";
 container.appendChild(tracking_div);

 var tracking_t1 = document.createElement("h3");
 tracking_t1.id = "tracking_t1";
 tracking_t1.innerHTML = "Busca el recorrido de tu vuelo";
 tracking_div.appendChild(tracking_t1);

 var tracking_input = document.createElement("input");
 tracking_input.id = "tracking_input";
 tracking_input.placeholder = "Coloca el número de tu vuelo";
 tracking_div.appendChild(tracking_input);
 
 var tracking_button = document.createElement("button");
 tracking_button.id = "tracking_button";
 tracking_button.innerHTML = "Buscar";
 tracking_div.appendChild(tracking_button);


