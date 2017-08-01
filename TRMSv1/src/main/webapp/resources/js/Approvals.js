"use strict"

$(document).ready(function(){
	$.post("Approvals",function(data){processForms(JSON.parse(data))});
});

function processForms(forms){
	var formsTable = document.getElementById("formstable");
	for(var form in forms){
		var tr = document.createElement("tr");
		var x = forms[form];
		for(var i in x){
			var td = document.createElement("td");
			td.innerHTML = x[i];
			tr.append(td);
		}
		var td = document.createElement("td");
		
		var approveButton = document.createElement("button");
		approveButton.setAttribute("Class", "btn btn-success");
		approveButton.setAttribute("id", x.formid);
		approveButton.addEventListener("click", approve, false);
		approveButton.innerHTML = "Approve";
		td.append(approveButton);
		tr.append(td);
		
		var td2 = document.createElement("td");
		var denyButton = document.createElement("button");
		denyButton.setAttribute("Class", "btn btn-danger");
		denyButton.setAttribute("id", x.formid);
		denyButton.addEventListener("click", deny, false);
		denyButton.innerHTML = "Deny";
		td2.append(denyButton);
		tr.append(td2);
		formsTable.append(tr);
	}
}

function approve(element){
	console.log(element.srcElement.id);
	$.get("Approvals", "approval=approve&formid="+element.srcElement.id + "&approverid=" +location.search.substring(1));
	
}

function deny(element){
	console.log(element.srcElement.id);
	$.get("Approvals", "approval=deny&formid="+element.srcElement.id  + "&approverid=" +location.search.substring(1));
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