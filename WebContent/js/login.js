function login() {
	swal({
		title : "请阅读",
		text : "因为网站还不成熟，所以注册时用最简单的密码即可。\n直接使用此账户：用户名123456 密码：123456",
		type : "warning",
		showCancelButton : false,
		closeOnConfirm : false
	});
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

function unRegister() {
	swal({
		title : "请阅读",
		text : "对不起，除了罗菱小仙女之外的人都不能注册。",
		type : "warning",
		showCancelButton : false,
		closeOnConfirm : false
	});
}

function back() {
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