

$(document).ready(function(){
	$.post("ApprovalsServlet",function(data){console.log(data)})
});

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