<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .error-container {
            text-align: center;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 90%;
        }

        .error-container h1 {
            font-size: 24px;
            color: red;
            margin-bottom: 10px;
        }

        .error-container p {
            font-size: 16px;
            color: #555;
            margin-bottom: 20px;
        }

        .error-container button {
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 14px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        .error-container button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>Error</h1>
        <p>Invalid username or password :(</p>
        <button onclick="goBack()">Go Back</button>
    </div>

    <script>
        function goBack() {
            // Redirect to WelcomePage.jsp
            window.location.href = "WelcomePage.jsp";
        }
    </script>
</body>
</html>
