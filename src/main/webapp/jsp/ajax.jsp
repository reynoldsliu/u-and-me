<!DOCTYPE html>
<html>
<head>
    <title>AJAX and Spring Boot Example</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 800px;
            margin: auto;
            padding: 20px;
            background-color: #ffffff;
            box-shadow: 0px 0px 5px #ccc;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#loadData").click(function() {
                $.ajax({
                    url: "/ajax/data", // Your Spring Boot AJAX endpoint URL
                    type: "GET",
                    success: function(data) {
                        $("#dataContainer").text(data);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <div class="container">
        <h1>AJAX and Spring Boot Example</h1>
        <button id="loadData">Load Data</button>

        <form action="/index" >
            <input type="submit">
        </form>

        <div id="dataContainer"></div>
    </div>
</body>
</html>