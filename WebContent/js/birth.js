window.onload = function(){
	var audio = document.getElementById('music');
	audio.muted = false;
	swal({
		title : "给小仙女的小提示",
		text : "小仙女，打开右下角背景音乐更配哦！",
		type : "warning",
		showCancelButton : false,
		closeOnConfirm : false
	});
}
function moveImg(list, index) {
	for (var i = 0; i < list.length; i++) {
		if (list[i].className == 'opa-on') {// 清除li的透明度样式
			list[i].className = '';
		}
	}
	list[index].className = 'opa-on';
}
function moveIndex(list, num) {// 移动小圆圈
	for (var i = 0; i < list.length; i++) {
		if (list[i].className == 'on') {// 清除li的背景样式
			list[i].className = '';
		}
	}
	list[num].className = 'on';
}
var imgList = document.getElementById('img').getElementsByTagName('li');
var list = document.getElementById('index').getElementsByTagName('li');
var index = 0;
var timer;

for (var i = 0; i < list.length; i++) {// 鼠标覆盖上哪个小圆圈，图片就移动到哪个小圆圈，并停止
	list[i].index = i;
	list[i].onmouseover = function() {
		var clickIndex = parseInt(this.index);
		index = clickIndex;

		moveImg(imgList, index);
		moveIndex(list, index);
		clearInterval(timer);
	};
	list[i].onmouseout = function() {// 移开后继续轮播
		play();
	};

}

var nextMove = function() {
	index += 1;
	if (index >= 9) {
		index = 0
	}
	moveImg(imgList, index);
	moveIndex(list, index);
};
var play = function() {
	timer = setInterval(function() {
		nextMove();
	}, 3000);
};
play();

function showLetter(){
	changeLetterHun();
	setTimeout(showContent,"2000");
	showBt();
}

function hideLetter(){
	hideContent();
	hideBt();
	setTimeout(changeLetterZero,"500");
}

function changeLetterHun(){
	var letter = document.getElementById('letter');
	letter.style.height = '100%';
	letter.style.zIndex = '2';
}

function changeLetterZero(){
	var letter = document.getElementById('letter');
	letter.style.height = '0%';
	setTimeout(changeLetterIndex, "2500");
	
}

function changeLetterIndex(){
	var letter = document.getElementById('letter');
	letter.style.zIndex = '-1';
}

function showContent(){
	var content = document.getElementById('content');
	content.style.opacity = '1';
}

function hideContent(){
	var content = document.getElementById('content');
	content.style.opacity = '0';
}

function showBt(){
	var bt = document.getElementById('hide_button');
	bt.style.opacity = '1';
}

function hideBt(){
	var bt = document.getElementById('hide_button');
	bt.style.opacity = '0';
}

function changeTheContent(){
	var content = document.getElementById('content');
	if(content.getAttribute('opacity') == '1'){
		content.style.opacity = '0';
	} else {
		content.style.opacity = '1';
	}
}