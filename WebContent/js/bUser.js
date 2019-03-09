function validate(userForm) {
	if (userForm.account.value == "") {
		swal("请填写账户！")
		return false;
	} else if (userForm.username.value == "") {
		swal("请填写用户名！")
		return false;
	} else if (userForm.password.value == "") {
		swal("请填写密码！")
		return false;
	} else if (userForm.phone.value == "") {
		swal("请填写手机号！")
		return false;
	}
	return true;
}

function deleteUser(id) {
	swal({ 
	  title: "确定锁定吗？", 
	  text: "锁定后该用户就不能使用登陆后的权限了！", 
	  type: "warning",
	  showCancelButton: true, 
	  confirmButtonColor: "#DD6B55",
	  confirmButtonText: "确定", 
	  cancelButtonText: "取消",
	  closeOnConfirm: true, 
	  closeOnCancel: false	
	},
	function(isConfirm){ 
	  if (isConfirm) {
		  window.location.href="UserDelete?id=" + id + "&s=1";
		  swal("锁定", "此用户被可怜的锁定了。", "success"); 
	  } else {
		  swal("取消", "替他谢谢您！", "error"); 
	  }
	})
};

function recoverUser(id) {
	swal({ 
	  title: "确定恢复吗？", 
	  text: "恢复后该用户将可以肆意妄为！", 
	  type: "warning",
	  showCancelButton: true, 
	  confirmButtonColor: "#2ed573",
	  confirmButtonText: "确定", 
	  cancelButtonText: "取消",
	  closeOnConfirm: true, 
	  closeOnCancel: false	
	},
	function(isConfirm){ 
	  if (isConfirm) {
		  window.location.href="UserDelete?id=" + id + "&s=0";
		  swal("恢复", "这个用户重获自由。", "success"); 
	  } else {
		  swal("取消", "还是把他关起来吧！", "error"); 
	  }
	})
};