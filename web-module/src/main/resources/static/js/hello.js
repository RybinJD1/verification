$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080//randomQuestion"
    }).then(function(data) {
       $('.question-id').append(data.id);
       $('.question-description').append(data.description);
    });
});
