const create = document.getElementById("create")
const review_add = document.getElementById("review_add")
const review_contents = document.getElementById("review_contents")
const review_list = document.getElementById("review_list")
const review_update = document.getElementsByClassName("review_update")
const review_del = document.getElementsByClassName("review_del")
const update_save = document.getElementById("update_save");
const contents_update = document.getElementById("contents_update")
const star_update = document.getElementById("star_update")

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

review_list.addEventListener("click", (e)=>{
    // 클릭된 요소가 삭제 버튼인지 확인
    if(e.target.classList.contains("review_del")){
        if(!confirm("정말로 삭제하시겠습니까?")) return

        let reviewNum = e.target.getAttribute("data-num")
        let p = new URLSearchParams()
        p.append("reviewNum", reviewNum)

        fetch("../review/delete", {
            method: "POST",
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
            body: p
        })
        .then(r => r.text())
        .then(r => {
            if(r.trim() > 0){
                alert("삭제되었습니다.")
                getList()
            } else {
                alert("삭제 실패: 본인만 삭제 가능하거나 로그인이 필요합니다.")
            }
        })
    }

	if (e.target.classList.contains("review_update")) {
        const reviewNum = e.target.getAttribute("data-num")
		const oldStar = e.target.getAttribute("data-star")
		const oldContents = e.target.getAttribute("data-contents")

        contents_update.value = oldContents
		star_update.value = oldStar

        update_save.setAttribute("data-num", reviewNum)
    }
})

update_save.addEventListener("click", () => {
    const reviewNum = update_save.getAttribute("data-num");
    const newContents = contents_update.value
	const newStar = star_update.value

    if(newContents.trim() == "") {
        alert("수정할 내용을 입력해주세요.")
        return
    }

    let p = new URLSearchParams()
    p.append('reviewNum', reviewNum)
    p.append('reviewContents', newContents)
	p.append('reviewStar', newStar)

    fetch("../review/update", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: p
    })
    .then(r => r.text())
    .then(r => {
        if(r.trim() > 0) {
            alert("수정이 완료되었습니다.")
			$('#review_modal').modal('hide')
            getList()
        } else {
            alert("수정 실패: 권한이 없거나 오류가 발생했습니다.")
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

