window.onload = function() {
    document.getElementById("submitbtn").addEventListener("click", handleEvent, false);
}

function handleEvent(){
    $.post("ReimbursementForm.html",makeForm(),function(response,status){
        console.log("")
    });
}

function makeForm(){
    var Form = {};
    form.date = document.getElementById("date").value;
    form.location = document.getElementById("location").value;
    form.cost = document.getElementById("cost").value;
    form.timeStamp = document.getElementById("time").value;
    form.description = document.getElementById("description").value;
    form.gradingformat = document.getElementById("gradingformat").value;
    form.justification = document.getElementById("justification").value;
    form.eventtype = document.getElementById("eventtype").value;
}