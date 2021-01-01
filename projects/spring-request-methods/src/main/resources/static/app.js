$(document).ready(function() {
    $("#get_button").click(function() {
        ajaxCall("GET", "/api/employees");
    });

    $("#post_button").click(function() {
        ajaxCall("POST", "/api/employees");
    });

    $("#wrong_uri_button").click(function() {
        ajaxCall("PUT", "/api/employees");
    });

    $("#delete_uri_button").click(function() {
        ajaxCall("DELETE", "/api/employees");
    });

    var successFunction = function(data) {
        var employees = "";
        data.forEach(function(index) {
            employees = employees + " "+data[index].name;

        });
        console.log(employees);
        console.log(JSON.stringify(data));
    };
    var errorFunction = function(data) {
        console.log('error '+JSON.stringify(data));
    };


    var ajaxCall =  function (method_type, request_url) {
        $.ajax({
            url: request_url,
            method: method_type,
            type: "JSON",
            contentType: 'application/json; charset=utf-8',
            success: successFunction,
            error: errorFunction
        })};
});