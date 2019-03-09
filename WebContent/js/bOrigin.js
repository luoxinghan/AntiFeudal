function validate(originForm) {
	if (originForm.country.value == "") {
		swal("请填写国家！")
		return false;
	} else if (originForm.priority.value == "") {
		swal("请填写优先级！")
		return false;
	}
	return true;
}

function isNumber(str) // 判断是否为非负整数
{
	var rx = /^[0-9]+$/;
	return rx.test(str);
}

function deleteOrigin(id) {
	swal({ 
	  title: "确定删除吗？", 
	  text: "删除后该地区的图片将不能在前台展示！", 
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
		  window.location.href="OriginDelete?id=" + id + "&s=1";
		  swal("删除", "你的地区成功被删除。", "success"); 
	  } else {
		  swal("取消", "我保命了！", "error"); 
	  }
	})
};

function recoverOrigin(id) {
	swal({ 
	  title: "确定恢复吗？", 
	  text: "恢复后该地区的图片将在前台展示！", 
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
		  window.location.href="OriginDelete?id=" + id + "&s=0";
		  swal("恢复", "你的地区成功恢复。", "success"); 
	  } else {
		  swal("取消", "请圣上好好考虑！", "error"); 
	  }
	})
};