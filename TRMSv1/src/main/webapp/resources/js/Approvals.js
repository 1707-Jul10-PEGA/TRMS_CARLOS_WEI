"use strict"
$(document).ready(function(){
	var forms;
	$.post("Approvals",function(data){processForms(data)});
});

function processForms(forms){
	var formsTable = document.getElementById("formstable");
	console.log(forms);
	for(form in forms){
		var tr = document.createElement("tr");
		var td = document.createElement("td");
		
		for(var i in form){
			console.log(form[i]);
		}
		/*form.formid
		form.userid
		form.date
		form.timestamp
		form.location
		form.description
		form.cost
		form.gradingFormat
		form.eventType
		form.justification*/
		
		
	}
}

window.onload = function(){
	
	document.getElementById("approveforms").addEventListener("click", function(){redirect(this)}, false);
	document.getElementById("reimbursement").addEventListener("click", function(){redirect(this)}, false);
	document.getElementById("logout").addEventListener("click", function(){redirect(this)}, false);
}

function redirect(element){
	event.stopPropagation();
	if(element.id == "approveforms") {
		window.location.href = "/TRMSv1/Approvals.html" + location.search.substring(); //redirects to self
	}else if (element.id == "reimbursement") {
		window.location.href = "/TRMSv1/ReimbursementForm.html" + location.search.substring();
	}else if (element.id == "logout") {
		window.location.href = "/TRMSv1/LoginPage.html" + location.search.substring();
	}
}