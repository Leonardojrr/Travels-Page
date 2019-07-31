var username = document.getElementById("user_id");
var password = document.getElementById("password");

function login(){

    let data;

    if(username.value.match(/^\w+@\w+.com/)){
        data = "email=";
    }
    else{
        data = "username=";
    }

    let params = {
        method:"GET",
        headers: new Headers({'Content-Type':"application/json"}),
    }

    fetch("http://localhost:8080/Travels/LoginServlet?"+data+username.value+"&password="+password.value,params).then(resp => resp.json()).then( data => {

        console.log(data);

      }
    )
}