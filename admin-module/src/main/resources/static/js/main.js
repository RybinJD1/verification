
var rootURL = "http://localhost:8080";

var currentQuestion;

findAll();

$('#btnDelete').hide();


$('#btnSearch').click(function() {
    search($('#searchKey').val());
    return false;
});

$('#btnAdd').click(function() {
    newQuestion();
    return false;
});

$('#btnSave').click(function() {
    if ($('#questionId').val() == '')
        addQuestion();
    else
        updateQuestion();
    return false;
});

$('#btnDelete').click(function() {
    deleteQuestion();
    return false;
});

$('#questionList a').live('click', function() {
    findById($(this).data('identity'));
});


function newQuestion() {
    $('#btnDelete').hide();
    currentQuestion = {};
    renderDetails(currentQuestion);
}

function findAll() {
    console.log('findAll');
    $.ajax({
        type: 'GET',
        url: rootURL + '/question',
        dataType: "json",
        success: renderList
    });
}

function findById(id) {
    console.log('findById: ' + id);
    $.ajax({
        type: 'GET',
        url: rootURL + '/question/' + id,
        dataType: "json",
        success: function(data){
            $('#btnDelete').show();
            console.log('findById success: ' + data.description);
            currentQuestion = data;
            renderDetails(currentQuestion);
        }
    });
}

function addQuestion() {
    console.log('addQuestion');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL,
        dataType: "json",
        data: formToJSON(),
        success: function(data, textStatus, jqXHR){
            alert('Wine created successfully');
            $('#btnDelete').show();
            $('#questionId').val(data.id);
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('addQuestion error: ' + textStatus);
        }
    });
}

function updateQuestion() {
    console.log('updateQuestion');
    $.ajax({
        type: 'PUT',
        contentType: 'application/json',
        url: rootURL + '/' + $('#questionId').val(),
        dataType: "json",
        data: formToJSON(),
        success: function(data, textStatus, jqXHR){
            alert('Wine updated successfully');
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('updateQuestion error: ' + textStatus);
        }
    });
}

function deleteQuestion() {
    console.log('deleteQuestion');
    $.ajax({
        type: 'DELETE',
        url: rootURL + '/' + $('#questionId').val(),
        success: function(data, textStatus, jqXHR){
            alert('Wine deleted successfully');
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('deleteQuestion error');
        }
    });
}

function renderList(data) {
    var list = data == null ? [] : (data instanceof Array ? data : [data]);

    $('#questionList li').remove();
    $.each(list, function(index, question) {
        $('#questionList').append('<li><a href="#" data-identity="' + question.id + '">'+question.description+'</a></li>');
    });
}

function renderDetails(question) {
    $('#questionId').val(question.id);
    $('#description').val(question.description);
}

function formToJSON() {
    var questionId = $('#questionId').val();
    return JSON.stringify({
        "id": questionId == "" ? null : questionId,
        "description": $('#description').val(),
    });
}
