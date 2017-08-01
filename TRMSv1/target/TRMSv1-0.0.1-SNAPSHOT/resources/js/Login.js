window.onload = function() {
    document.getElementById("submitbtn").addEventListener("click", handleEvent, false);
}

function handleEvent() {


    var usr = document.getElementById("username").value;
    var pwd = document.getElementById("password").value;

    //Check if user provided the required input
    if (usr && pwd) {
        $.ajax({
            type: "POST",
            url: "Login",
            data: "login=" + JSON.stringify(login()),
            success: function(response,status,xhr) {
                window.location.href = xhr.getResponseHeader("Location");
            },
            error: function(response) {
                displayAlert(response.responseText);
            }
        });
    } else if (usr === "" && pwd !== "") {
        displayAlert("Missing username.");
    } else if (pwd === "" && usr !== "") {
        displayAlert("Missing password.");
    } else {
        displayAlert("Missing username and password.");
    }

}

function login() {
    var login = {}
    login.username = document.getElementById("username").value;
    login.password = document.getElementById("password").value;

    return login;
}

//Display a customer message to the user
function displayAlert(info) {

    //usr information is missing display in the proper tag
    var divContainer = document.getElementById("divmsg");
    var msg = document.createElement("strong");

    divContainer.className = "alert alert-danger";
    msg.innerHTML = info;

    //Check for previous alert and delete if it exists
    if (divContainer.innerHTML !== "") {
        divContainer.innerHTML = "";
    }

    divContainer.appendChild(msg);
}