function login(){
	var loginDiv = document.getElementById('cont_form_login');
	var loginBt = document.getElementById('login_bt');
	loginDiv.style.display = "block";
	loginBt.style.opacity = "0";
	setTimeout(function() {
		loginDiv.style.opacity = "1";
	}, 400);

	setTimeout(function() {
		loginBt.style.display = "none";
	}, 200);
}

function back(){
	var loginDiv = document.getElementById('cont_form_login');
	var loginBt = document.getElementById('login_bt');
	loginBt.style.display = "block";
	loginDiv.style.opacity = "0";
	setTimeout(function() {
		loginBt.style.opacity = "1";
	}, 400);

	setTimeout(function() {
		loginDiv.style.display = "none";
	}, 200);
}