var mioNumero;
var idChat;
$(document).ready(function(){
    $("body").on("click", ".chat", function(){
        $("#elenco_chat").addClass("hidden");
        $("#singola_chat").removeClass("hidden");
        idChat = $(this).attr("id_chat");
        caricaMessaggi(idChat);
    })

    $("#form").submit(function (event) {
        var array = $(this).serializeArray();
        var messaggio = array[0].value;
        console.log(messaggio);
        $(this).trigger("reset");
        $.ajax({
            url: "http://localhost:8080/messaggio",
            contentType: "application/json",
            method: "POST",
            data: JSON.stringify({
                testo: messaggio,
                mittente: mioNumero,
                chat: idChat
            }),
            success: function () {
                caricaMessaggi(idChat);
            }
        })
    })

    $("#log").submit(function (event) {
        console.log("ciao");
        var array = $(this).serializeArray();
        console.log(array);
        mioNumero = array[0].value;
        console.log(mioNumero);
        $("#log").addClass("hidden");
        $("#elenco_chat").removeClass("hidden");
        caricaChat();
    })

    $("#crea_chat").submit(function (event) {
        var array = $(this).serializeArray();
        var numero = array[0].value;
        $(this).trigger("reset");
        $.ajax({
            url: "http://localhost:8080/chat",
            contentType: "application/json",
            method: "POST",
            data: JSON.stringify({
                utenti: [mioNumero, numero],
                nome_chat: "",
                tipo_chat: "privata",
            }),
            success: function () {
                $(".contChat").empty();
                caricaChat();
                $("#crea_chat").addClass("hidden");
                $("#elenco_chat").removeClass("hidden");
            }
        })
    })

    $("body").on("click", "#back", function(){
        $("#elenco_chat").removeClass("hidden");
        $("#singola_chat").addClass("hidden");
    })

    $("#crea").on("click", function(){
        $("#crea_chat").removeClass("hidden");
        $("#elenco_chat").addClass("hidden");
    })
})

function caricaChat(){
    $.ajax({
        url: "http://localhost:8080/chats/"+mioNumero,
        contentType: "application/json",
        method: "GET",
        success: function(response){
            for(var i=0; i<response.length; i++){
                var foto = response[i].utenti[0].foto;
                var nome = response[i].utenti[0].nome;
                for(var j=0; j<response[i].utenti.length; j++){
                    if(response[i].utenti[j].numero_telefono !== mioNumero){
                        foto = response[i].utenti[j].foto;
                        nome = response[i].utenti[j].nome;
                    }
                }
                $(".contChat").append(`<div class = "chat" id_chat = "${response[i].id_chat}"> <img src = "${foto}" class = "immagine_chat"> <p>${nome}</p> </div>`);
            }
        }
    })
}

function caricaMessaggi(idChat){
    $.ajax({
        url: "http://localhost:8080/chat/"+mioNumero+"/"+idChat,
        contentType: "application/json",
        method: "GET",
        success: function (response) {
            var foto = response.utenti[0].foto;
            var nome = response.utenti[0].nome;
            for(var j=0; j<response.utenti.length; j++){
                if(response.utenti[j].numero_telefono != mioNumero){
                    foto = response.utenti[j].foto;
                    nome = response.utenti[j].nome;
                }
            }
            $("#persona").text(nome);
            $(".header>img").attr("src", foto);
            $(".contMess").empty();
            for(var i=0; i<response.messaggi.length; i++){
                var data = response.messaggi[i].data;
                var ora= data.split(" ")[1].split(":").slice(0, 2).join(":");
                if(response.messaggi[i].mittente.numero_telefono == mioNumero){
                    $(".contMess").append(`<div class = "messaggio_umano">
                            <div class = "messaggio mittente">
                                <p class = "mess">${response.messaggi[i].testo}</p>
                                <p class = "ora">${ora}</p>
                            </div>
                        </div>`);
                }else{
                    $(".contMess").append(`<div class = "messaggio_alieno">
                            <div class = "messaggio destinatario">
                                <p class = "mess">${response.messaggi[i].testo}</p>
                                <p class = "ora">${ora}</p>
                            </div>
                        </div>`);
                }
            }
        }
    })
}