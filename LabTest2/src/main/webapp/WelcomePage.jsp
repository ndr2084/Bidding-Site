<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WELCOME TO LAB TEST 2</title>
    <link rel="stylesheet" type="text/css" href="css/welcome.css">
</head>
<body>
    <div class="form-container">
        <h1>Auction Login Page</h1>
        <div class="form-options">
            <!-- Returning Member Form -->
            <div class="form-box">
                <h2>Returning Member</h2>
                <form action="ServiceSelectorServlet">
                    <label for="email">Email:</label>
                    <input type="text" id="email" name="email" required>

                    <label for="password">Password:</label>
                    <div class="password-field">
                        <input type="password" id="password" name="password" required>
                        <span class="toggle-password" onclick="togglePassword('password', this)">Show</span>
                    </div>

                    <input type="submit" value="Submit">
                </form>
            </div>
            
            <!-- First-Time Member Form -->
            <div class="form-box">
                <h2>First-Time Member</h2>
                <form action="FirstTimeMemberServlet">
                    <label for="firstName">First Name:</label>
                    <input type="text" id="firstName" name="firstName" required>

                    <label for="lastName">Last Name:</label>
                    <input type="text" id="lastName" name="lastName" required>

                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>

                    <label for="password">Password:</label>
                    <div class="password-field">
                        <input type="password" id="registerPassword" name="password" required>
                        <span class="toggle-password" onclick="togglePassword('registerPassword', this)">Show</span>
                    </div>

                    <input type="submit" value="Register">
                </form>
            </div>
        </div>
    </div>

    <script>
        function togglePassword(inputId, toggleElement) {
            const passwordField = document.getElementById(inputId);
            if (passwordField.type === "password") {
                passwordField.type = "text";
                toggleElement.textContent = "Hide"; // Change text to "Hide"
            } else {
                passwordField.type = "password";
                toggleElement.textContent = "Show"; // Change text back to "Show"
            }
        }
    </script>
</body>
</html>
