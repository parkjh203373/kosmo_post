const create = document.getElementById("create")
const review_add = document.getElementById("review_add")
const review_contents = document.getElementById("review_contents")
const review_list = document.getElementById("review_list")

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

review_add.addEventListener("click", ()=>{
	let contents = review_contents.value
	let productNum = create.getAttribute("data-pn")
	let star = document.getElementById("review_star").value;
	
	if(contents.trim()==""){
		alert("댓글 내용을 입력해주세요.")
		return
	}
	
	let p = new URLSearchParams()
	p.append('productNum', productNum)
	p.append('reviewContents', contents)
	p.append('reviewStar', star);
	
	fetch("../review/add", {
		method: "POST",
		headers: {
			"Content-Type": "application/x-www-form-urlencoded"
		},
		body: p
	})
	.then(d => d.text())
	.then(d => {
		if(d.trim() > 0){
			alert("댓글이 등록되었습니다.")
			review_contents.value = ""
			getList()
		} else {
			alert("로그인이 필요한 서비스입니다.");
			location.href = "../member/login";
		}
			
	})
})

function getList(){
	let productNum = create.getAttribute("data-pn")
	
	fetch("../review/list?productNum=" + productNum)
	.then(d => d.text())
	.then(d => {
		review_list.innerHTML = d
	})
}

getList()