function validate(storyForm) {
	if (storyForm.articleTitle.value == "") {
		swal("请填写标题！")
		return false;
	} else if (storyForm.articleContent.value == ""){
		swal("请填写文章内容！")
		return false;
	}	
	return true;
}

function isNumber(str) // 判断是否为非负整数
{
	var rx = /^[0-9]+$/;
	return rx.test(str);
}

function deleteStory(id) {
	swal({ 
	  title: "确定删除吗？", 
	  text: "删除后将故事将对不再在前台展示！", 
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
		  window.location.href="StoryDelete.sr?id=" + id + "&s=1";
		  swal("删除", "该故事成功被删除。", "success"); 
	  } else {
		  swal("取消", "该故事未被删除。", "error"); 
	  }
	})
};

function recoverStory(id) {
	swal({ 
	  title: "确定恢复吗？", 
	  text: "恢复后该故事将在前台被所有人可见！", 
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
		  window.location.href="StoryDelete.sr?id=" + id + "&s=0";
		  swal("恢复", "此故事成功恢复。", "success"); 
	  } else {
		  swal("取消", "此故事未被恢复。", "error"); 
	  }
	})
};