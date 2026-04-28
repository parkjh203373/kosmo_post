const id1 = document.getElementById("id1")
const ch = document.getElementsByClassName("ch")

id1.addEventListener("click", function(){
	for(let c of ch){
		c.checked = id1.checked
	}
})

for(let c of ch){
	c.addEventListener("click", function(){
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