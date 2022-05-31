function addItem() {
	let todo = document.getElementById("item");
	let list = document.getElementById("todolist");
	let listitem = document.createElement("li");

	listitem.className = "d-flex list-group-item list-group-item-ationc list-group-item-warning";

	let xbtn = document.createElement("button");

	xbtn.className = "btn-close ms-auto"

	xbtn.onclick = function(e) {
		let pnode = e.target.parentNode;
		list.removeChild(pnode);
	}

	listitem.innerText = todo.value;
	listitem.append(xbtn);
	list.appendChild(listitem);

	todo.value = "";
	todo.focus();
}