console.log("Form.js")

const add = document.getElementById("add")
const result = document.getElementById("result")
const create = document.getElementById("create")

//create.addEventListener("click", ()=>{
//	let form = new FormData()//<form></form>
//	form.append("boardTitle", "ajax title")//<input type="text">
//	form.append("boardWriter", "ajax writer")
//	form.append("boardContents", "ajax contents")
	
//	fetch("./create", {
//		method:"POST",
//		body:form
//	}).then(res=>res.text)
//	.then(res=>console.log(res))
//})

// <input type="file" name="attach" class="form-control">

let idx = 1
let count = 1

add.addEventListener("click", function(){

    if (count > 5) {
        alert("최대 5개만 넣을 수 있습니다.");
        return;
    }

    let d = document.createElement("div")
    d.id = `id${idx}`
    d.classList.add("input-group", "mb-2");

    let i = document.createElement("input")
    i.type = "file"
    i.name = "attach"
    i.classList.add("form-control")

    let b = document.createElement("button")
    b.type = "button"
    b.innerText = "X"
    b.setAttribute("data-id", `id${idx}`)
    b.classList.add("c")

    d.append(i)
    d.append(b)

    result.append(d)

    count++

    idx++

})

result.addEventListener("click", function(e){
    if(e.target.classList.contains("c")){
        // let di = e.target.getAttribute("data-id")
        // document.getElementById(di).remove()
        e.target.parentElement.remove()
        count--
    }
})