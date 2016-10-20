$(document).ready(init);

var ajax = {
    url: "",
    type: "GET",
    dataType: "json",
    data: null,
    success: null,
    error: null
};
$.fn.serializeObject = function ()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = encodeURIComponent(this.value) || '';
        }
    });
    return o;
};

function init() {
    $("#button").on("click", login);
    paintItemMenuSelected();
    //routes();
    //Path.root("#/home");
    //Path.listen();
}

function login() {
    var data = $("#form").serializeObject();
    if (data.pwd == undefined) {
        $("#panelError").css("display:block");
        $("#errorMessage").html("Debes introducir una contraseña");
        return false;
    }
    if (data.username == undefined) {
        $("#panelError").css("display:block");
        $("#errorMessage").html("Debes introducir un nombre");
        return false;
    }
    data.pwd = forge_sha256(data.pwd);

    ajax.url = "login";
    ajax.data = data;
    ajax.success = function (source) {

        if (source.status == 200) {
            switch (source.message) {
                case true :
                    $(location).attr("href", "shop.jsp");
                    break;
                case "User_No_Found":
                    $("#panelError").show();
                    $("#errorMessage").html("Usuario no encontrado");
                    break;
                case "Pass_No_Found":
                    $("#panelError").show();
                    $("#errorMessage").html("Contraseña erronea");
                    break;
            }
        } else {
            alert(source.message);
        }
    };
    ajax.error = function (source) {

    };
    $.ajax(ajax);
    return false;



}

function fillStock() {
    $.ajax({
        url: "processor",
        type: "GET",
        dataType: "json",
        data: "ob=product&op=list",
        success: function (data) {
            if (data.status != 200) {
                alert("No se pudo obtener los productos")
                return;
            }
            $("#stock").empty();
            var id;
            for (var i = 0; i < data.message.length; i++) {

                var content = '<section class="col-md-4">';
                content += '<article class=" panel panel-default">';
                content += '<section class="panel-heading">';
                content += '<h3 class="h3">' + data.message[i].desc + '</h3>';
                content += '</section>';
                content += '<section class="panel-body">';
                content += '<img class="image" src="http://www.brainstormerbingo.com/Images/upload-empty.png">';
                content += '<div class="content">';
                content += '<p>Precio: ' + data.message[i].price + '€</p>'
                content += '<p>Cantidad: ' + data.message[i].amount + '</p>'
                content += '<form class="form-inline add" id="f' + data.message[i].id + '">';
                content += '<input class="form-control amount input-sm" type="number" name="amount" min="1">';
                content += '<button type="submit"class="btn btn-success input-sm" id="b' + data.message[i].id + '">añadir</button>';
                content += '</form></div></section></article></section>';
                $("#stock").append(content);
                $("#f" + data.message[i].id + "").submit(data.message[i], function (data) {

                    var datos = $("#f" + data.data.id).serializeObject();
                    datos.ob = "cart";
                    datos.op = "add";
                    datos.id = data.data.id;
                    $.ajax({
                        url: "processor",
                        type: "GET",
                        dataType: "json",
                        data: datos,
                        success: function (data) {
                            switch (data.message) {
                                case "Item added" :
                                    alert("producto añadido");
                                    break;
                                case "Not there Enough":
                                    alert("no hay suficiente");
                                    break;
                            }
                        },
                        error: function (data) {

                        }
                    });
                    return false;
                });
            }
        },
        error: function (data) {

        }
    });


}

function closeSession() {
    $.ajax({
        url: "processor",
        type: "GET",
        dataType: "json",
        data: "ob=close",
        success: function (data) {
            if (data.message == "Session Closed") {
                $(location).attr("href", "index.jsp");
            }
        },
        error: function (data) {

        }

    });
}

function updateTotalCart() {
    var tdTotal = $(".totalPrice").toArray();
    if(tdTotal.length == 0) {
        $("#buy").addClass("disabled");
        $("#buy").attr("onclick","");
        $("#empty").addClass("disabled");
        $("#empty").attr("onclick","");
    }
    var total = 0;
    for (var i = 0; i < tdTotal.length; i++) {
        total += Number(tdTotal[i].innerHTML);
    }
    $("#siniva").text(total.toFixed(2));
    var totaliva = total * 1.21;
    $("#coniva").text(totaliva.toFixed(2));
}

function fillCarrito() {

    $.ajax({
        url: "processor",
        type: "GET",
        dataType: "json",
        data: "ob=cart&op=list",
        success: function (data) {
            $("#carro").empty;
            for (var i = 0; i < data.message.length; i++) {
                var item = data.message[i];
                var content = '<tr id="tr' + item.id + '">';
                content += "<td>" + item.desc + "</td>";
                content += "<td>" + item.amount + "</td>";
                content += "<td>" + item.price + "</td>";
                content += "<td class='totalPrice'>" + (item.price * item.amount).toFixed(2) + "</td>";
                content += '<td><button class="btn btn-danger" id="b' + item.id + '">';
                content += '<span class="glyphicon glyphicon-remove"></span>';
                content += "</button></td>";
                content += "</tr>";
                $("#carro").append(content);
                $("#b" + data.message[i].id).on("click", data.message[i], function (p) {
                    $.ajax({
                        url: "processor",
                        type: "GET",
                        dataType: "json",
                        data: "ob=cart&op=drop&id=" + p.data.id,
                        success: function (data) {
                            if (data.message == "Item droped") {
                                $("#tr" + p.data.id).empty();
                                updateTotalCart();
                            }
                        }
                    });
                });

            }
            updateTotalCart();
        },
        error: function (data) {

        }

    });
}

function checkout() {

    $.ajax({
        url: "processor",
        type: "GET",
        dataType: "json",
        data: "ob=cart&op=checkout",
        success: function (data) {
            if (data.message == "CheckOut OK") {
                var content = '<div class="alert alert-success">';
                content += "<strong>Bien!</strong> La compra ha sido satisfactoria.</div>";
                $("#content").empty().append(content);
            } else {
                alert(data.message);
            }
        }
    });


}

function getCheckouts() {

    $.ajax({
        url: "processor",
        type: "GET",
        dataType: "json",
        data: "ob=purchases&op=list",
        success: function (data) {
            if (data.status == 200) {
                $("#pedidos").empty();
                for (var i = 0; i < data.message.length; i++) {
                    var pedido = data.message[i];
                    var content = "<tr>";
                    content += "<td>" + pedido.id + "</td>";
                    content += "<td>" + pedido.date + "</td>";
                    content += "<td>" + pedido.amountItems + "</td>";
                    content += "<td>" + (pedido.totalPrice * 1.21).toFixed(2) + "</td>";
                    content += "</tr>";
                    $("#pedidos").append(content);
                }
            } else {
                alert(data.message);
            }
        }
    });
}

function empty() {
    $.ajax({
        url: "processor",
        type: "GET",
        dataType: "json",
        data: "ob=cart&op=empty",
        success: function (data) {
            if (data.message == "Items droped") {
                $("#carro").empty();
                updateTotalCart();
            }
        },
        error: function (data) {

        }

    });
}

function routes() {

    Path.map("#/home").to(function () {
        $(location).attr("href", "shop.jsp");
        $('.nav li').removeClass('active');
        $("#home").attr("class", "active");

        return false;
    });

    Path.map("#/carrito").to(function () {
        $(location).attr("href", "carrito.jsp");
        $('.nav li').removeClass('active');
        $("#carro").attr("class", "active");
        return false;
    });

    Path.map("#/pedidos").to(function () {
        $(location).attr("href", "pedidos.jsp");
        $('.nav li').removeClass('active');
        $("#pedido").attr("class", "active");
        return false;
    });

}

function paintItemMenuSelected() {
    var page = $(location).attr('pathname');
    $('.nav li').removeClass('active');

    switch (page) {
        case "/shop.jsp":
            $("#shop").attr("class", "active");
            break;
        case "/carrito.jsp":
            $("#carrito").attr("class", "active");
            break;
        case "/pedidos.jsp":
            $("#pedido").attr("class", "active");
            break;
    }

}