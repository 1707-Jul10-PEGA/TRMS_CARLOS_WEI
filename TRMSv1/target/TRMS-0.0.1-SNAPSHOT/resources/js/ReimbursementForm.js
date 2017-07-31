window.onload = function() {
    document.getElementById("submitbtn").addEventListener("click", handleEvent, false);
}

function handleEvent() {
    $.ajax({
        type: "POST",
        url: "ReimbursementForm",
        data: "form=" + JSON.stringify(makeForm()),
        success: console.log("hello"),
        dataType: 'application/x-www-form-urlencoded'
    });
}

function makeForm() {
    var form = {};
    form.date = document.getElementById("date").value;
    form.location = document.getElementById("location").value;
    form.cost = document.getElementById("cost").value;
    form.timestamp = document.getElementById("time").value;
    form.description = document.getElementById("description").value;
    form.gradingformat = document.getElementById("gradingformat").value;
    form.justification = document.getElementById("justification").value;
    form.eventtype = document.getElementById("eventtype").value;
    return form;
}