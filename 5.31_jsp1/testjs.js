document.getElementById("result").style.display = "none";

function signUp() {
	document.getElementById("regform").style.display = "none";
	document.getElementById("rname").innerHTML = document.form1.name.value;
	document.getElementById("rmail").innerHTML = document.form1.email.value;
	document.getElementById("result").setAttribute("style", "display: block; background-color:KhaKi;");
}