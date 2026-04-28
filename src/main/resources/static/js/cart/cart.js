const create = document.getElementById("create")

create.addEventListener("click", ()=>{
	let pn = create.getAttribute("data-pn")
	
	let p = new URLSearchParams()
	p.append('productNum', pn)
	console.log(pn)
	
	fetch("../cart/create", {
		method:"POST",
		headers: {
		        "Content-Type": "application/x-www-form-urlencoded"
		},
		body:p

	})
	.then(r => r.text())
	.then(r => {
		if(r.trim()>0){
			let flag = confirm("장바구니로 이동하시겠습니까?")
			if(flag) {
				location.href = "../cart/list"
			}
		} else{
			alert("로그인이 필요한 서비스입니다.")
			location.href = "../member/login"
		}
	})
})