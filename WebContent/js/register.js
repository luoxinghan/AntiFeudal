function conformInfo() {
	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;
	var repassword = document.getElementById('repassword').value;
	var phonenumber = document.getElementById('phonenumber').value;
	if (username == '' || username == undefined || username == null) {
		swal("请填写用户名！")
		event.preventDefault();
	} else if (phonenumber == '' || phonenumber == undefined
			|| phonenumber == null) {
		swal("电话号码是必填项！");
		event.preventDefault();
	} else if (password == '' || password == undefined || password == null) {
		swal("请填写密码！")
		event.preventDefault();
	} else if (repassword == '' || repassword == undefined
			|| repassword == null) {
		swal("请再次填写密码！");
		event.preventDefault();
	} else if (repassword != password) {
		swal("密码不一致！");
		event.preventDefault();
	}
}
