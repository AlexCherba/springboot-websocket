var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#userinfo").html("");
}

function connect() {
    var socket = new SockJS('http://127.0.0.1:8091/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/user', function (greeting) {
            console.log('/topic/user greeting:', greeting);
            showGreeting(JSON.parse(greeting.body).name);
        });
        stompClient.subscribe('/topic/news', function (greeting) {
            console.log('/topic/news greeting:', greeting);
            showGreeting(JSON.parse(greeting.body).name);
        });
        stompClient.subscribe('/topic/news', function (greeting) {
            console.log('/topic/news greeting:', greeting);
            showGreeting(JSON.parse(greeting.body).name);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/user", {}, JSON.stringify({'name': $("#name").val()}));
}

function getFriends() {
    var uuid = '0f24d8a4-9176-42a5-bc52-affb483e3308';
    stompClient.send("/app/friends.get_all", {}, uuid);
    //console.log('stompClient.send:', stompClient.send("/app/friends.get_all", {}, uuid));
}

function showGreeting(message) {
    $("#userinfo").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#getfriends" ).click(function() { getFriends(); });
    $( "#send" ).click(function() { sendName(); });
});