function dni(){
	do{
		var input= prompt("Inserta tu numero de dni","");
		if(input == null) return;
		var numero = Number(input);
	}while(isNaN(numero) || input === "");
	numero %= 23; 
	var letras = ["T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"];
	alert("Tu letra es: " + letras[numero]);
}

function imc(){
	do{
		var input= prompt("Introduce tu peso en KG");
		if(input == null) return;
		var peso = Number(input);
	}while(isNaN(peso) || input === "");
	
	do{
		input = prompt("Introduce tu altura en m");
		if(input == null) return;
		var altura = Number(input);
	}while(isNaN(altura) || input === "");
	
	var imc = (peso / altura**2).toFixed(2);
	
	if(imc <= 18){
		alert("Tu IMC es: " + imc + " y tu clasificacion es de peso bajo");
	}else if(imc < 25){
		alert("Tu IMC es: " + imc + " y tu clasificacion es normal");
	}else if (imc < 27) {
		alert("Tu IMC es: " + imc + " y tu clasificacion es de sobrepeso");
	}else if (imc < 30) {
		alert("Tu IMC es: " + imc + " y tu clasificacion es obesidad grado I");
	}else if(imc < 40){
		alert("Tu IMC es: " + imc + " y tu clasificacion es de obesidad grado II");
	}else {
		alert("Tu IMC es: " + imc + " y tu clasificacion es de obesidad grado III");
	};
}

function adivinar(){
	var numero = parseInt(Math.random() * 99 + 1);
	var time = Date.now();
	var helper = new Array()
	var inputs = new Array();
	
	do{
		var input = prompt("Introduce un numero");
		inputs.push(input);
		if(input == null) {return;}
		if(input === "") continue;
		if(numero > input){
			alert("el numero es mayor");
			helper.push("mayor")
		}else if (input > numero) {
			alert("el numero es menor");
			helper.push("menor");
		};
		
	}while( input != numero);
	helper[helper.length] = "Winner!!"
	time = (Date.now()-time)/1000;
	
	document.getElementById("canvas").innerHTML = "<table id=\"tabla\" class=\"table table-striped\"><tr><th>Intento #</th><th>Numero</th><th>Ayuda</th></tr></table>";
	
	for(var i=0; i<inputs.length;i++){
		var table = document.getElementById("tabla");
		var intento = i +1;
		table.innerHTML = table.innerHTML + "<tr><td>"+ intento +"</td><td>" + inputs[i] + "</td><td>" + helper[i] + "</td></tr>";
	}

	alert("Bingo!! Has tardado " + time + " segundos, Puedes mejorarlo?");

}

function media(){
	var inputs = new Array();
	do{
		var input = prompt("Introduce un numero o \"fin\" para finalizar");
		
		if(input == null) {return;}
		
		var number = Number(input);

		if(!isNaN(number)) {
			inputs.push(number);
		}
		
	}while( input != "fin");

	var suma = 0;
	for( var i in inputs) suma += inputs[i];
	
	var media = suma / inputs.length;

	document.getElementById("canvas").innerHTML = "<table class=\"table table-striped\">" +
	"<tr><th>Cantidad de numeros</th><th>suma</th><th>media</th></tr>" + 
	"<tr><td>" + inputs.length + "</td><td>" + suma + "</td><td>" + media + "</td></tr></table>";
}

function conversion(){
	
	do{
		var moneda = prompt("inserte el tipo de moneda","EUR o USD");
		if(moneda == null) return;
	}while(moneda != "EUR" && moneda != "USD");

	do{
		var input = prompt("Introduce la cantidad");
		if(input == null) return;
		var cantidad = Number(input);
	}while(isNaN(cantidad) || input === "");
	
	switch(moneda){
		case "EUR":
			cantidad = cantidad * 1.12;
			alert("La cantidad es: $" + cantidad.toFixed(2))
			break;
		case "USD":
			cantidad = cantidad * 0.90;
			alert("La cantidad es: " + cantidad.toFixed(2) + "€")
			break;
	}
}

function parImpar(){

	do{
		var input = prompt("Introduce un numero");
		if(input == null) return;
		var numero = Number(input);
	}while(isNaN(numero) || input === "");

	var valor = numero%2 == 0 ? "Par" : "Impar";
	alert("el numero es: " + valor);
}

function ordenar(){
	var inputs = new Array();
	do{
		var input = prompt("Introduce un numero");
		var number = Number(input);
		if(input != null && input != "") {
			if(!isNaN(number)) inputs.push(number);
		}
	}while(input != null);

	inputs.sort(function(a,b) {
		return a - b;
	});

	document.getElementById("canvas").innerHTML = "<h2 class=\"h2\">Numeros ordenados</h2><ul id=\"numeros\" class=\"pagination\"></ul>"

	for( var i in inputs){
		var ul = document.getElementById("numeros");
		ul.innerHTML = ul.innerHTML + "<li><a href=\"#\">" + inputs[i] + "</a></li>";
	}
}

function fecha(){
	do{
		var input = prompt("introduce un dia ente 1 y 31");
		if(input == null) return;
		var day = Number(input);
		if(isNaN(day)) day = 0;
	}while(day < 1 || day > 31 );

	do{
		input = prompt("introduce un mes ente 1 y 12");
		if(input == null) return;
		var month = Number(input);
		if(isNaN(month)) month = 0;
	}while(month < 1 || month > 12);

	do{
		input = prompt("introduce un año ente 1950 y 2013");
		if(input == null) return;
		var year = Number(input);
		if(isNaN(year)) year = 0;
	}while(year < 1950 || year > 2013);
	
	var weekday = ["Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"];
	var monthName;

	switch(month){
		case 1:
			monthName = "Enero";
			break;
		case 2:
			monthName = "Febrero";
			break;
		case 3:
			monthName = "Marzo";
			break;
		case 4:
			monthName = "Abril";
			break;
		case 5:
			monthName = "Mayo";
			break;
		case 6:
			monthName = "Junio";
			break;
		case 7:
			monthName = "Julio";
			break;
		case 8:
			monthName = "Agosto";
			break;
		case 9:
			monthName = "Septiembre";
			break;
		case 10:
			monthName = "Octubre";
			break;
		case 11:
			monthName = "Noviembte";
			break;
		case 12:
			monthName = "Diciembre";
			break;
	}
	var date = new Date(year + "/" + month + "/" + day);
	var cadena = "<div class=\"well\">" + weekday[date.getDay()] + ", " + day + " de " + monthName + " de " + year + "</div>";
	document.getElementById("canvas").innerHTML = cadena;
}

function rangos(){

	var a = prompt("Inserte el valor A");
	var b = prompt("Inserte el valor B");

	if (a == null || b == null) return;

	a = Number(a);
	b = Number(b);
	
	if(isNaN(a) || isNaN(b)) rangos();
	if(Number(a) > Number(b)) rangos();
	
	var canvas = document.getElementById("canvas");
	canvas.innerHTML =  "<h2 class=\"h2\">Numeros descendentes</h2><ul id=\"numerosdes\" class=\"pagination\"></ul>";
	canvas.innerHTML += "<h2 class=\"h2\">Numeros ascendentes</h2><ul id=\"numerosasc\" class=\"pagination\"></ul>";
	canvas.innerHTML += "<table id=\"sumas\" class=\"table table-striped\"></table>";
	var ascendente = document.getElementById("numerosasc");
	var descendente = document.getElementById("numerosdes");
	var sumaTotales = 0;
	var sumaImpar = 0;
	var sumaPar = 0;
	var numDescInicial = b;

	for(var i = a+1; i < b; i++){

		sumaTotales += i;
		numDescInicial--;

		if(i%2 == 0){
			sumaPar += i;
		}else{
			sumaImpar += i;
		}

		document.getElementById("sumas").innerHTML = "<tr><th>Sumas totales</th><th>Suma impar</th><th>Suma par</th></tr>" +
													 "<tr><td>" + sumaTotales + "</td><td>" + sumaImpar + "</td><td>" + sumaPar + "</td></tr>";
		ascendente.innerHTML += "<li><a href=\"#\">" + i + "</a></li>";	
		descendente.innerHTML += "<li><a href=\"#\">" + numDescInicial + "</a></li>";

	}
}

function tablasMultiplicar(){

	var canvas = document.getElementById("auxiliar");
	var valor = 1;

	for (var row = 0; row < 10; row++){

		canvas.innerHTML += "<div id=\"row" + row + "\" class=\"row\"><div>";
		var rowHTML = document.getElementById("row" + row);

		for (var col = 0; col < 10; col++) {

			rowHTML.innerHTML += "<div id=\"col" + valor + "\" class=\"tabla col-md-1 col-sm-2 col-xs-3\"></div>";
			var colHTML = document.getElementById("col" + valor);
			var tabla= "<table class=\"table table-bordered\">";
			
			for(var i = 0; i<= 10;i++){
				var resultado = valor * i;
				tabla += "<tr><td class=\"small\"> " + valor + " x " + i + " = " + resultado + "</td></tr>";
			}

			tabla += "</table>";
			colHTML.innerHTML = tabla; 
			valor++;		
		}
	}
}

function divisores(){
	var input = prompt("introduce un numero entero");
	if (input == null || input === "") return;
	
	var number = Number(input);
	if(isNaN(number)) divisores();

	number = Math.floor(number);
	var numbers = new Array();
	
	(function divisor(n){
		if(n == 1){
			numbers.push(n);
			return;
		}

		if(number % n == 0) numbers.push(n);
		divisor(n-1);
	})(number);

	var canvas = document.getElementById("canvas");
	canvas.innerHTML =  "<h2 class=\"h2\">Divisores</h2><ul id=\"divisores\" class=\"pagination\"></ul>";
	var drawNumbers = document.getElementById("divisores");
	
	for(var i in numbers) drawNumbers.innerHTML += "<li><a href=\"#\">" + numbers[i] + "</a></li>";
	
}