<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Service Result</title>
    <link rel="stylesheet" type="text/css" href="css/end-page.css">
</head>
<body>
    <div class="container">
        <h1>
            The result from Service is: <br> ${serviceResult}
        </h1>
        <form action="WelcomeServlet" method="GET">
            <button type="submit" name="restart" value="True">Re-Compute</button>
        </form>
    </div>
</body>
</html>
