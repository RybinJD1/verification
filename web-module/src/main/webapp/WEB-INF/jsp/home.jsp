<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style type="text/css">
        .answer {
            color: #336;
        / Цвет текста /
        }
    </style>
</head>
<body>
<div id="myId">
    <p class="question-description">Выберите, пожалуйста, </p>
    <ul id="listAnswers"></ul>
</div>

<div id="error"></div>
<div id="true"></div>

<script>
    var list = [];

    $(document).ready(function () {
        $.ajax({
            url: "http://localhost:8080/verification/randomQuestion",
            type: 'GET',
            dataType: "json",
        }).then(function (data) {
            $('.question-description').append(data.description);
            list = data.listAnswers;
            display(list, data.description);
            $('.answer-description').append(answer.description)
        })
    });

    function display(list, data) {

        var errorMessage = "Вы ошиблись!";
        var trueMessage = "Вы ответили правильно!";
        var text = "Вы должны были ответить " + data + " и выбрали - ";

        $.each(list, function (index, answer) {
            $('#listAnswers').append('<li><a href="#" class="answer" >' + answer.description + '</a></li>');
        });
        $(".answer").click(function () {

            var value = $(this).text();

            $.each(list, function (index, answer) {
                var description = answer.description;
                var message = '<p>' + text + description + '</p>' + '<br>';
                $("#myId").hide(300);
                if (description === value) {
                    var flag = answer.flag;
                    if (flag === false) {
                        $('#error').append(message + '<p>' + errorMessage + '</p>');
                    } else {
                        $('#true').append(message + '<p>' + trueMessage + '</p>');
                    }
                }
            });
        });
    }

</script>
</body>
