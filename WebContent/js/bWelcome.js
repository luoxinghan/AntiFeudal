function validate(suggestForm) {
	if (suggestForm.title.value == "") {
		swal("发送意见请填写标题！")
		return false;
	} else if (suggestForm.suggestion.value == ""){
		swal("请填写投诉内容！")
		return false;
	}	
	return true;
}
