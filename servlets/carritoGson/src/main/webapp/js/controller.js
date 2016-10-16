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
                content += '<article class="article">';
                content += '<h3 class="h3">' + data.message[i].desc + '</h3>';
                content += '<div>';
                content += '<p>Precio ' + data.message[i].price + '€</p>';
                content += '<form class="form-inline add" id="f' + data.message[i].id + '">';
                content += '<input class="form-control amount" type="number" name="amount">';
                content += '<button class="btn btn-success" id="b' + data.message[i].id + '">añadir</button>';
                content += '</form></div></article></section>';
                $("#stock").append(content);
                $("#b" + data.message[i].id + "").on("click", data.message[i], function (data) {

                    var datos = $("#f" + data.data.id).serializeObject();
                    datos.ob = "cart";
                    datos.op = "add";
                    datos.id = data.data.id;
                    $.ajax({
                        url: "processor",
                        type: "GET",
                        dataType: "json",
                        data: datos,
                        success: function(data) {
                            switch (data.message) {
                                case "Item added" :
                                    alert("producto añadido");
                                    break;
                                case "Not there Enough":
                                    alert("no hay suficiente");
                                    break;
                            }
                        },
                        error: function(data) {

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
            if(data.message == "Session Closed"){
                $(location).attr("href","index.jsp");
            }
        },
        error: function (data) {

        }

    });
}