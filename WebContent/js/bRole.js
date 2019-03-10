function validate(roleForm) {
	if (roleForm.roleName.value == "") {
		swal("请填写角色名！")
		return false;
	}
	return true;
}

function isNumber(str) // 判断是否为非负整数
{
	var rx = /^[0-9]+$/;
	return rx.test(str);
}

function deleteRole(id) {
	swal({ 
	  title: "确定删除吗？", 
	  text: "删除后将没有此角色了！请确保没有任何一个用户绑定此角色！", 
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
		  window.location.href="RoleDelete.rl?id=" + id + "&s=1";
		  swal("删除", "该角色成功被删除。", "success"); 
	  } else {
		  swal("取消", "该角色未被删除。", "error"); 
	  }
	})
};

function recoverRole(id) {
	swal({ 
	  title: "确定恢复吗？", 
	  text: "恢复后该角色将可以被分配到用户上！", 
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
		  window.location.href="RoleDelete.rl?id=" + id + "&s=0";
		  swal("恢复", "此角色成功恢复。", "success"); 
	  } else {
		  swal("取消", "此角色未被恢复。", "error"); 
	  }
	})
};