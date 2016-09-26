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


function primos(){

	var number = prompt("Introduce un numero positivo");
	if(number == null || number === "") return;
	number = Number(number);
	if(isNaN(number)) primos();

	document.getElementById("canvas").innerHTML = "<h2 class=\"h2\">Numeros primos</h2><ul id=\"numeros\" class=\"pagination\"></ul>";
	var primosHTML = document.getElementById("numeros"); 
	
	(function calc(num){
		var tries = 0;
		for( var i = num; i > 0; i--){

			if(num%i == 0) tries++;
		}

		if(tries == 2) primosHTML.innerHTML += "<li><a href=\"#\">" + num + "</a></li>";
		if(num > 0) calc(num -1); 
	})(number);
}

function factorial(){

	var number = prompt("Introduce un numero positivo");
	if(number == null || number === "") return;
	number = Number(number);
	if(isNaN(number)) factorial();

	var numero = new Array();
	(function calc(num) {
		if(num == 1) return 1;
		var result = num * calc(num - 1);
		numero.push(result);
		return result;
	})(number);

	document.getElementById("canvas").innerHTML = "<table id=\"table\" class=\"table table-bordered\"></table>";
	var table = document.getElementById("table");

	for(var i = 0; i < numero.length; i++){
		var multi = i + 2;
		if(i == 0) {
			table.innerHTML += "<tr><td>1 x " + multi  + " = " + numero[i] + "</td></tr>";
		}else{
			table.innerHTML += "<tr><td>" + numero[i-1] + " x " + multi  + " = " + numero[i] + "</td></tr>";
		}
	}

	table.innerHTML += "<tr><td>Resultado: " + numero[numero.length-1] + "</td></tr>";
}

function estadisticas(){

	var input = prompt("Introduce una frase");
	if(input == null || input === "") return;
	
	var map = {"Caracteres":null,"Palabras":null,"Digitos" :null,
			   "Minusculas" : null,"Mayusculas" : null,"Simbolos" : null};

	var words = input.replace(/\d*/g,"").split(/  */g);
	for(var i in words) if(words[i] === "") words.splice(0,1);

	map["Caracteres"] = input.length;
	map["Palabras"] = words.length;
	map["Digitos"] = input.replace(/\D*/g,"").length;
	map["Minusculas"] = input.replace(/[^a-z]*/g,"").length;
	map["Mayusculas"] = input.replace(/[^A-Z]*/g,"").length;
	map["Simbolos"] = input.replace(/[0-9a-zA-Z\s]*/g,"").length;
	
	var table = "<table class=\"table table-bordered\">";

	for(var i in map) table += "<tr><td>" + i + "</td><td>" + map[i] + "</td></tr>";
	
	table += "</table>";

	document.getElementById("canvas").innerHTML = table;	
}

function palindromo(){
	var input = prompt("Introduce una frase");
	if(input == null || input === "") return;

	var words = input.split(" ");
	var reverse = input.split(" ").reverse().join(" ");
	var twoIntwo = input.match(/.{1,2}/g).reverse().join("");
	var content = "<h2 class=\"h2\">Palindromos</h2>";
	content += "<ul class=\"pagination\">";

	// ------ Comprobacion de palindromos-----------------
	for(var i in words){

		var j = Math.floor(words[i].length/2-1); //Obtiene el indice que esta antes de la mitad.
		
		var word = words[i];
		
		if(word === null) continue; // si meto algun espacio no lo revisa.
		word = word.match(/.{1}/g);
		var matches = 0;
				
		for(var z = j; z>=0; z--) if(word[z] === word[word.length-1-z]) matches++;
		
		if(matches > j) content += "<li><a href=\"#\">" + words[i] + "</a></li>";
	}
	//------- fin de comprobacion --------
	content += "</ul>";
	content += "<h2 class=\"h2\">Frase del reves de 2 en 2</h2>";
	content += "<div class=\"well well-sm\">" + twoIntwo + "</div>";
	content += "<h2 class=\"h2\">Frase del reves por palabras</h2>";
	content += "<div class=\"well well-sm\">" + reverse + "</div>";

	document.getElementById("canvas").innerHTML = content;
}

function sustituciones(){

	var a = prompt("Introduce la cadena A");
	if( a === "" || a == null) return;
	var b = prompt("Introduce la cadena B");
	if( b === "" || b == null) return;
	var c = prompt("Introduce la cadena C");
	if( c === "" || c == null) return;

	var content = "<h2 class=\"h2\">Cadena A</h2><p>" + a + "</p>";
	content += "<h2 class=\"h2\">Cadena B</h2><p>" + b + "</p>";
	content += "<h2 class=\"h2\">Cadena C</h2><p>" + c + "</p>";
	var arrayB = new Array();
	b = b.split(" ");
	
	for(var i in b)	if(a.match(b[i]) != null)  arrayB.push(a.match(b[i]));
		
	c = c.split(" ");

	for(var i in arrayB) a = a.replace(arrayB[i].join(""),c[i]);
	
	content += "<h2 class=\"h2\">Resultado</h2><p>" + a + "</p>";
	document.getElementById("canvas").innerHTML = content;
}

function romanos(){

	var input = prompt("inserte un numero romano o decimal");
	if(input == null || input === "") return;

	number = Number(input);
	
	if(isNaN(number)){
		number = toDecimal(input);
	}else{
		number = romanize(number);
	}

	function romanize(num) {
  		var lookup = {M:1000,CM:900,D:500,CD:400,C:100,XC:90,L:50,XL:40,X:10,IX:9,V:5,IV:4,I:1};
      	var roman = "";
      	
  		for (var i in lookup ) {
    		while ( num >= lookup[i] ) {
      		roman += i;
      		num -= lookup[i];
    		}
  		}
  		return roman;
	}
	function toDecimal(number){
	 	var decimal = 0;
        var lastNumber = 0;
        number = number.toUpperCase();
        var romanicNumbers = {M:1000,D:500,C:100,X:10,V:5,I:1};
        var char;
        for (var x = number.length - 1; x >= 0 ; x--) {
            char = number.charAt(x);

         	decimal = lastNumber > decimal ? decimal - romanicNumbers[char] : decimal + romanicNumbers[char] ;
         	lastNumber = romanicNumbers[char];

        }
  	    return decimal;
    }

    document.getElementById("canvas").innerHTML = "<div class=\"well well-sm\">" + number + "</div>";
}

function descuentos(){

	var precio = prompt("introduce el precio del articulo");
	if(precio == null || precio === "") return;
	precio = Number(precio);
	if(isNaN(precio)) descuentos();

	var stock = prompt("introduce la cantidad de stock");
	if(stock == null || stock === "") return;
	stock = Number(stock);
	if(isNaN(stock)) descuentos();

	if(precio < 100){
		if(stock < 10) alert("El descuento es de 2% = " + (precio*0.98));
		else if(stock < 100) alert("El descuento es de 10% = " + (precio*0.9));
		else if(stock < 1000) alert("El descuento es de 25% = " + (precio*0.75));
	}else if(precio < 1000){
		if(stock < 10) alert("El descuento es de 4% = " + (precio*0.96));
		else if(stock < 1000)  alert("El descuento es de 8% = " + (precio*0.92));
	}else {
		if(stock < 100) alert("El descuento es de 3% = " + (precio*0.97));
		else if(stock <= 200) alert("El descuento es de 5% = " + (precio*0.95));
		else if(stock > 200)  alert("El descuento es de 7% = " + (precio*0.93));
	}
}

function trim(){

	var input = prompt("introduce una frase");
	if(precio == null || input === "") return;


	var output = "";
	for(var i = 0; i < input.length; i++){

		if(input.charAt(i) != " ") output += input.charAt(i);
	}

	alert(output);
}


function temperaturas(){

	var content = "<table style=\"width: auto !important\" class=\"table table-bordered\">";
	content += "<tr><th>°Celsius</th><th>°Fahrenheit</th></tr>";

	for(var i = -100; i<=100; i++){
		var t = i * 1.8 + 32;
		content += "<tr><td>" + i + "</td><td>" + t.toFixed(2) + "</td></tr>";
	}

	content += "</table>";
	document.getElementById("canvas").innerHTML = content;
}

function discurso(){

	var input = prompt("Introduce un numero positivo");
	if(input == null || input === "") return;
	input = Number(input);
	if(isNaN(input)) discurso();

	var grupoUno = ["No obstante",
					"Por otra parte",
					"Asimismo",
					"Sin embargo no hemos de olvidar que",
					"De igual manera",
					"La práctica prueba que",
					"Y no es menos cierto que",
					"Las experiencias, ricas y diversas, muestran que",
					"Y aún así",
					"No obstante",
					"Incluso, bien pudiéramos atrevernos a sugerir que",
					"Es obvio señalar que",
					"De hecho",
					"También cabe añadir en este punto que"];

	var grupoDos = ["la realización de las premisas del programa",
					"la complejidad de los estudios de los dirigentes",
					"el aumento constante, en cantidad y en extensión, de nuestra actividad",
					"la estructura actual de la organización",
					"el nuevo modelo de actividad de la organización",
					"el desarrollo continuo de distintas formas de actividad",
					"nuestra actividad de información y propaganda",
					"el reforzamiento y desarrollo de las estructuras",
					"la consulta con los numerosos militantes",
					"el inicio de la acción general de formación de las actitudes",
					"un relanzamiento específico de todos los sectores implicados",
					"la superación de experiencias difíciles",
					"una aplicación indiscriminada de los factores confluyentes",
					"el proceso consensuado de unas y otras aplicaciones concurrentes"];

	var grupoTres = ["nos obliga a un exhaustivo análisis",
					 "cumple un rol esencial en la formación",
					 "exige la precisión y la determinación",
					 "ayuda a la preparación y a la realización",
					 "garantiza la participación de un grupo importante en la formación",
					 "cumple deberes importantes en la determinación",
					 "facilita la creación",
					 "obstaculiza la apreciación de la importancia",
					 "ofrece un ensayo interesante de verificación",
					 "implica el proceso de reestructuración y modernización",
					 "habrá de significar un auténtico y eficaz punto de partida",
					 "permite en todo caso explicitar las razones fundamentales",
					 "asegura, en todo caso, un proceso muy sensible de inversión",
					 "deriva de una manera indirecta",
					 "dirige hacia la incidencia superadora"];

	var grupoCuatro = [ "de las condiciones financieras y administrativas existentes.",
						"de las directivas de desarrollo para el futuro.",
						"del sistema de participación general.",
						"de las actitudes de los miembros hacia sus deberes ineludibles.",
						"de las nuevas proposiciones.",
						"de las direcciones educativas en el sentido del progreso.",
						"del sistema de formación de cuadros que corresponda a las necesidades.",
						"de las condiciones de las actividades apropiadas.",
						"del modelo de desarrollo.",
						"de las formas de acción.",
						"de las básicas premisas adoptadas.",
						"de toda una casuística de amplio espectro.",
						"de los elementos generadores.",
						"de toda una serie de criterios ideológicamente sistematizados en un frente común de actuación regeneradora."];

	var discurso = "<p>Me gustaría comenzar este discurso destacando que";

	var num1,num2,num3,num4;
	function randomizer(){
		num1 = Math.floor(Math.random() * grupoUno.length);
		num2 = Math.floor(Math.random() * grupoDos.length);
		num3 = Math.floor(Math.random() * grupoTres.length);
		num4 = Math.floor(Math.random() * grupoCuatro.length);
	}

	var counter = 0;

	while(counter < input && input > 1){
		randomizer();
		var dot = Math.floor(Math.random()*2);

		if(counter >= 5 && dot) discurso += "</p><p>";

		if(counter != 0 && counter < input) discurso += " " + grupoUno[num1];
		counter++;
		if(counter < input) discurso += " " + grupoDos[num2];
		counter++;
		if(counter < input) discurso += " " + grupoTres[num3];
		counter++;
		if(counter < input) discurso += " " + grupoCuatro[num4];
		counter++;
	}
	discurso += "</p>";
	document.getElementById("canvas").innerHTML =  discurso;
}

function tablaMultiplicada(){
	var input1 = prompt("Introduce el numero de filas");

	var input2 = prompt("Introduce el numero de columnas");


	var content = "<table class=\"table table-bordered\">";
	
	for(var i = 1; i <= input1; i++){
		content += "<tr>";

		for (var j = 1; j <= input2; j++) {
			var res = i*j;
			content += "<td>" + res + "</td>"; 
			
		}
		content += "</tr>";
	}

	content += "</table>";
	document.getElementById("canvas").innerHTML = content;
}

function factura(){
	
	var factura = { "id": 12546565,
					"fecha": "26/09/2016",
					"cliente": {
						"nombre": "Berto Romero",
						"direccion": "C/ Alcala",
						"NIF": "54698785A",
						"telefono": 963698752,
						"cuenta_pago": 25466587855452122
					},
					"productos": [{
						"producto": {
							"codigo": 12346546,
							"descripcion": "Champu pro V"
						},
						"cantidad": 2,
						"precioUnidad": 1.25,
						"precioTotal": 2.50
					}, {
						"producto": {
							"codigo": 2546452,
							"descripcion": "Detergente ropa suave"
						},
						"cantidad": 3,
						"precioUnidad": 1,
						"precioTotal": 3},
					{
						"producto": {
							"codigo": 12454625,
							"descripcion": "Patatas fritas Lays 25g"
						},
						"cantidad": 5,
						"precioUnidad": 0.25,
						"precioTotal": 1.25
					}
						],
					"sumaImporte": 6.75,
					"iva": 25,
					"totalIva": 8.44,
					"fechaVencimiento": "26/09/2016"};


	var table = "<table class=\"table table-bordered\">";

	table += "<tr><td><b>Nº Factura</b> " + factura.id + "</td><td><b>Fecha:</b> " + factura.fecha + "</td></tr>";
	table += "<tr><th>Nombre</th><th>Direccion</th><th>NIF o CIF</th><th>Telefono</th><th>Cuenta de pago</th></tr>";
	table += "<tr><td>" + factura.cliente.nombre + "</td><td>" + factura.cliente.direccion + "</td><td>" + factura.cliente.NIF + 
			 "</td><td>" + factura.cliente.telefono + "</td><td>" + factura.cliente.cuenta_pago + "</td></tr>";
   	table += "<tr><th>Codigo</th><th>Descripcion</th><th>Cantidad</th><th>Precio/Unidad</th><th>Precio Total</th></tr>";


   	for(var i  in factura.productos){
   		table += "<tr><td>" + factura.productos[i].producto.codigo + "</td><td>" + factura.productos[i].producto.descripcion + 
   				 "</td><td>" + factura.productos[i].cantidad + "</td><td>" + factura.productos[i].precioUnidad + "</td><td>" + factura.productos[i].precioTotal + "</td></tr>";
   	}
   
   	table += "<tr><td colspan=\"3\"></td><th>Fecha Vencimiento</th><td>" + factura.fechaVencimiento + "</td></tr>";
	table += "<tr><td colspan=\"3\"></td><th>Suma Importe</th><td>" + factura.sumaImporte + "</td></tr>";
	table += "<tr><td colspan=\"3\"></td><th>Iva Aplicabe</th><td>" + factura.iva + "%</td></tr>";
	table += "<tr><td colspan=\"3\"></td><th>Total con IVA</th><td>" + factura.totalIva + "</td></tr>";
   	table += "</table>";


   	document.getElementById("canvas").innerHTML = table;
}