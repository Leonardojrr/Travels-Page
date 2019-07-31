class Header{
    insertarHeader(lugarDeHeader, imagen, link1, link2, link3, botonUsuario){
        var header_nav = document.createElement("nav"); //Nav del Header
        header_nav.id = "header_nav";
        header_nav.classList = "navbar navbar-expand-lg navbar-dark bg-dark";
        lugarDeHeader.appendChild(header_nav);// Inclusion del Nav al lugar deseado 

        var header_logo_a = document.createElement("a"); //Div del para el logo dentro del header
        header_logo_a.id = "header_logo_a";
        header_logo_a.classList = "navbar-brand col-1";
        header_logo_a.href = "#";
        header_nav.appendChild(header_logo_a); //Inclusion de Div del logo al header

        var header_logo = new Image(); //Nueva Imagen para el Logo
        header_logo.id = "header_logo";
        header_logo.width = 50;
        header_logo.height=50;
        header_logo.src = imagen; //"imagen", se pasa por parametro y es la ruta de la imagen del logo
        header_logo_a.appendChild(header_logo);//Inlcusion de la imagen del logo al div del logo

        var header_links_div = document.createElement("div"); //Div de los links que tiene el header
        header_links_div.classList = "collapse navbar-collapse col-11";
        header_links_div.id = "header_links_div";   
        header_nav.appendChild(header_links_div);//Inclusion del div a header

        var header_links_ul = document.createElement("ul");
        header_links_ul.id = "header_links_ul";
        header_links_ul.classList = "navbar-nav mr-auto";
        header_links_div.appendChild(header_links_ul);

        var user_link_li  = document.createElement("li");
        user_link_li.classList = "nav-item dropdown";
        header_links_ul.appendChild(user_link_li);

        var user_link_title = document.createElement("a");
        user_link_title.classList = "nav-link dropdown-toggle";
        user_link_title.id = "user_link_title";
        user_link_title.href = "#";
        user_link_li.appendChild(user_link_title);
        
    }
}