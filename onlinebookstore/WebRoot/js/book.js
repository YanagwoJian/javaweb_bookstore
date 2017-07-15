function login() {
	
		if(document.form.id.value =="") {
			alert("账号不能为空");
			return false;
		}
		
		else if(document.form.pwd1.value=="") {
			alert("密码不能为空");
			return false;
		}
		
		else {
			return true;
		}
}


function userFunction() {
	
	
	if(document.myform.id.value=="") {
		alert("账号不能为空");
		return false;
	}
	
	else if(document.myform.pwd1.value=="") {
		alert("密码不能为空");
		return false;
	}
		
	
	else if(document.myform.pwd1.value!= document.myform.pwd2.value) {
		alert("两次输入密码不同");
		return false;
	}
	
	
	else if(document.myform.name.value=="") {
		alert("名字不能为空");
		return false;
	}
	else {
		return true;
	}
}


function changePassword() {
	
	var pwd1 = document.form.pwd1;
	var pwd2 = document.form.pwd2;
	var pwd3 = document.form.pwd3;
	
	if(pwd1.value == "" || pwd2.value == "" || pwd3.value == "") {
		alert("密码不能为空");
		return false;
	}
	
	else if(pwd2.value != pwd3.value) {
		alert("两次输入新密码不同");
		return false;
	}
	else if(pwd1.value == pwd2.value) {
		alert("旧密码与新密码不能相同");
		return false;
	}
	else {
		return true;
	}
}


function changeinfo() {
	var phone = document.myform.phone;
	var name = document.myform.name;
	
	if(name.value =="") {
		alert("名字不能为空");
		return false;
	}
	else if(phone.value =="") {
		alert("电话不能为空");
		return false;
	}else {
		return true;
	}
}