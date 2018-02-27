$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/greeting"
    }).then(function(data, status, jqxhr) {
       $('.answer-id').append(data.id);
       $('.answer-description').append(data.content);
       console.log(jqxhr);
    });
});
