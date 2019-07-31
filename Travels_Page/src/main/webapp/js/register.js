var firstname = document.getElementById("firstname");
var email = document.getElementById("email");
var username = document.getElementById("username");
var address = document.getElementById("address");
var phone = document.getElementById("phone");
var password = document.getElementById("password");
var re_password = document.getElementById("re_password");
var vp;
var ve;


function verifyEmail(){
    if(email.value.match(/^\w+@\w+.com$/)){
        email.style.border = "2px solid #76ff03";
        ve = true;
    }
    else{
        email.style.border = "2px solid #f44336";
        ve = false;
    }
}


function verifyPassword(){
    if(re_password.value===password.value){
        re_password.style.border = "2px solid #76ff03";
        vp = true;
    }
    else{
        re_password.style.border = "2px solid #f44336";
        vp = false;
    }
}


function regist(){
    if(vp && ve){
        let data = {
            username: username.value,
            password: password.value,
            email: email.value,
            name: firstname.value,
            number: phone.value,
            address: address.value
        }
        let params = {
            method:"POST",
            headers: new Headers({'Content-Type': 'application/json'}),
            body: JSON.stringify(data)
        }
        fetch("http://localhost:8080/Travels/RegisterServlet",params).then(response => response.json()).then(data =>{
            if(data.status === 200){
                localStorage.setItem("userData",JSON.stringify(data.data));
                location.href = "../index.html";
            }
        });
    }
    else{
        alert("One field is wrong")
    }
}
