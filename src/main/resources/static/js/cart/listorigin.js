const id1 = document.getElementById("id1")
const ch = document.getElementsByClassName("ch")
const del = document.getElementsByClassName("del")
const del2 = document.getElementById("del2")
const list = document.getElementById("list")

function getList(){
	fetch("./cartList")
	.then(r => r.text())
	.then(r => {
		r = r.trim()
		list.innerHTML = r
	})
}

id1.addEventListener("click", ()=>{
	for(let c of ch){
		c.checked = id1.checked
	}
})

for(let c of ch){
	c.addEventListener("click", ()=>{
		let count = 0
		
		for(let c of ch){
			if(c.checked){
				count++
			}
		}
		
		if(count == ch.length){
			id1.checked = true
		} else{
			id1.checked = false
		}

	})
}

for(let d of del){
	d.addEventListener("click", (e)=>{
		const productNum = e.target.getAttribute("data-product-num")
		// let productNum = d.previousElementSibling.getAttribute("data-product-num")
		const row = e.target.closest("tr")
		
		fetch("./delete", {
			method:"POST",
			headers: {
				"Content-Type": "application/x-www-form-urlencoded"
			},
			body:"productNum=" + productNum
		})
		.then(d => d.text())
		.then(d => {
			if(d.trim()>0){
				row.remove()
			} else{
				alert("삭제 실패")
			}
		})
	})
}

del2.addEventListener("click", ()=>{
	const checkedBox = document.querySelectorAll(".ch:checked")
	
	if(checkedBox.length == 0){
		alert("삭제할 상품을 선택해주세요.")
		return
	}
	
	if(!confirm("선택한 상품들을 삭제하시겠습니까?")) return
	
	checkedBox.forEach(c => {
		const productNum = c.getAttribute("data-product-num")
		const row = c.closest("tr")
		
		fetch("./delete", {
			method:"POST",
			headers: {
				"Content-Type": "application/x-www-form-urlencoded"
			},
			body:"productNum=" + productNum
		})
		.then(d => d.text())
		.then(d => {
			if(d.trim()>0){
				row.remove()
			} else{
				alert("삭제 실패")
			}
			
			const remain = document.querySelectorAll(".ch")
			if(remain.length == 0){
				id1.checked = false
			}
		})
	})
})