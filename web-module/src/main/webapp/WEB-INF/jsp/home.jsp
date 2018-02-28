<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
    <div>
        <p class="question-description">Выберите, пожалуйста, </p>
        <ul id="listAnswers"></ul>
    </div>

    <script>
        var list = [];
        $(document).ready(function() {
            $.ajax({
                url: "http://localhost:8080/verification/randomQuestion",
                type: 'GET',
                dataType: "json",
            }).then(function(data) {
                $('.question-description').append(data.description);
                list = data.listAnswers;
                display(list);
                $('.answer-description').append(answer.description)
            })
        });
        function display(list) {
                $.each(list, function (index, answer) {
                    $('#listAnswers').append('<li><a href="#" data-identity="' + answer.flag + '">' + answer.description + '</a></li>');
                });
        }
    </script>
</body>

</html>
