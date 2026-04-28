console.log("member join")

const username = document.getElementById("username")
const username_result = document.getElementById("username_result")
const password = document.getElementById("password")
const password_result = document.getElementById("password_result")
const passwordCheck = document.getElementById("passwordCheck")
const passwordCheck_result = document.getElementById("passwordCheck_result")
const btn = document.getElementById("btn")
const frm = document.getElementById("frm")
const name = document.getElementById("name")
const phone = document.getElementById("phone")
const email = document.getElementById("email")
const birth = document.getElementById("birth")
let idCheck = false

//id 입력안하면 "id 입력해주세요" 출력
username.addEventListener("blur", function(){
	if(username.value==""){
		username_result.innerText="ID를 입력해주세요"
	} else{
		username_result.innerText=""
	}
})

username.addEventListener("blur", function(){
	if(username.value === ""){
		idCheck = false
		return;
	}
	
	console.log("start")

	fetch(`./idCheck?username=${username.value}`)
	.then(res => res.text())
	.then(res => {
		if(res.trim()=='1'){
			console.log("중복 아님")
			username_result.innerText="사용 가능한 ID입니다."
			idCheck = true
		} else{
			console.log("중복")
			username_result.innerText="중복된 ID입니다."
			idCheck = false
		}
	})

	console.log("finish")
	
})

//pw 6글자 미만이면 "6글자 이상 입력해주세요" 출력
password.addEventListener("blur", function(){
	if(password.value.length<6){
		password_result.innerText="6자 이상 입력해주세요"
	} else{
		password_result.innerText=""
	}
})

password.addEventListener("focus", function(){	
	
	if(username.value==""){
		alert("ID를 입력해주세요.")
		username.focus()
		return
	}
	
	if(!idCheck){
		alert("ID 중복 확인을 해주세요.")
		username.focus()
		return
	}
	
	
})


//pw확인 일치하는지 여부 출력 후 일치하지 않으면 pw확인 부분 지우기
passwordCheck.addEventListener("blur", function(){
	if(password.value==passwordCheck.value){
		passwordCheck_result.innerText="비밀번호 일치"
	} else {
		passwordCheck_result.innerText="비밀번호 불일치"
		passwordCheck.value=""
	}
})

//submit 하면 상황에 맞게 alert 출력
btn.addEventListener("click", function(){
	if(username.value==""){
		alert("ID를 입력해주세요.")
		username.focus()
		return
	}
	
	if(!idCheck){
		alert("ID 중복 확인을 해주세요.")
		username.focus()
		return
	}
	
	if(password.value.length<6){
		alert("비밀번호를 확인해주세요.")
		password.focus()
		return
	}
	
	if(password.value!=passwordCheck.value){
		alert("비밀번호가 일치하지 않습니다.")
		passwordCheck.focus()
		return
	}
	
	if(name.value == ""){
	    alert("이름을 입력해주세요.");
	    name.focus();
	    return;
	}
	
	if(phone.value==""){
		alert("핸드폰 번호를 입력해주세요.")
		phone.focus()
		return
	}
		
	if(email.value==""){
		alert("이메일을 입력해주세요.")
		email.focus()
		return
	}	
	
	if(birth.value==""){
		alert("출생년월일을 입력해주세요.")
		birth.focus()
		return
	}
	
	frm.submit()

})
