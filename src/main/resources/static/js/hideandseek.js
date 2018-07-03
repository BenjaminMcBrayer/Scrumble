
/*function hideshowNPl1() {
	var s1 = document.getElementById("nP");
	var s2 = document.getElementById("nPl1");
	if (s1.options[s1.selectedIndex].text == "1"
			|| s1.options[s1.selectedIndex].text == "2") {
		s2.style.visibility = "hidden";
		document.getElementById("nPl1").style.visibility = "visible";
	}
}*/

function hideshowPlayer1() {
	var s1 = document.getElementById("nPl1");
	var s2 = document.getElementById("register1");
	var s3 = document.getElementById("login1");
	if (s1.options[s1.selectedIndex].text == "Yes") {
		s2.style.visibility = "hidden";
		document.getElementById("register1").style.visibility = "visible";
	}
	if (s1.options[s1.selectedIndex].text == "No") {
		s3.style.visibility = "hidden";
		document.getElementById("login1").style.visibility = "visible";
	}
}

/*function hideshowLogin1() {
	var s1 = document.getElementById("login1");
	s1.style.visibility = "hidden";
	document.getElementById("login1").style.visibility = "visible";
}*/

function hide() {
	//document.getElementById("nPl1").style.visibility = "hidden";
	//document.getElementById("nPl2").style.visibility = "hidden";
	document.getElementById("register1").style.visibility = "hidden";
	document.getElementById("login1").style.visibility = "hidden";
	//document.getElementById("register2").style.visibility = "hidden";
	//document.getElementById("login2").style.visibility = "hidden";
}
/*
 * function hideshow() { var s1 = document.getElementById("nP"); var s2 =
 * document.getElementById("welcome1"); var s3 =
 * document.getElementById("nPl1"); var s4 = document.getElementById("login1");
 * var s5 = document.getElementById("nPl2"); var s6 =
 * document.getElementById("login2"); var s7 = document.getElementById("nP");
 * var s8 = document.getElementById("add1"); var s8 =
 * document.getElementById("add2");
 * 
 * if (s3.options[s3.selectedIndex].text == "Yes") { s4.style.visibility =
 * "visible"; s8.style.visibility = "hidden";
 * document.getElementById("login1").style.visibility = "hidden";
 * document.getElementById("login2").style.visibility = "hidden";
 * document.getElementById("add1").style.visibility = "visible"; } if
 * (s3.options[s3.selectedIndex].text == "No") { s4.style.visibility = "hidden";
 * s6.style.visibility = "hidden"; s8.style.visibility = "hidden";
 * document.getElementById("login").style.visibility = "visible";
 * document.getElementById("addPlayer").style.visibility = "hidden"; }
 * if(s7.options[s7.selectedIndex].text == 2){ if
 * (s5.options[s5.selectedIndex].text == "Yes") { s8.style.visibility =
 * "hidden"; document.getElementById("login2").style.visibility = "hidden";
 * document.getElementById("addPlayer").style.visibility = "hidden ";
 * document.getElementById("addPlayer2").style.visibility = "visible"; } if
 * (s5.options[s5.selectedIndex].text == "No") { s6.style.visibility = "hidden";
 * s8.style.visibility = "hidden";
 * document.getElementById("login2").style.visibility = "visible";
 * document.getElementById("addPlayer2").style.visibility = "hidden"; } } }
 */