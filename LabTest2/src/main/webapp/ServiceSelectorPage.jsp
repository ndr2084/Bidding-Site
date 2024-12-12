<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Processor 1</title>
 <link rel="stylesheet" type="text/css" href="css/selection.css">
  <script>
        function selectPanel(panelId) {
            // Deselect all panels
            document.querySelectorAll('.panel-option').forEach(panel => {
                panel.classList.remove('selected');
            });

            // Select the clicked panel
            const selectedPanel = document.getElementById(panelId);
            selectedPanel.classList.add('selected');

            // Set the hidden input value to the selected panel's value
            document.getElementById('selectedOption').value = panelId;
        }
    </script>
</head>
<body bgcolor = "#f0f0f0">
	<div class="form-container">
        <h2>Welcome ${firstName} ${lastName}. Select a game! </h2>

        <form action="ServiceInvokerServlet" method="GET">
            <p>Please select the service you want to invoke:</p>

            <!-- Hidden input to store the selected value -->
            <input type="hidden" id="selectedOption" name="checked" value="">

            <!-- Panels for selection -->
            <div class="panel-group">
                <div id="S1" class="panel-option" onclick="selectPanel('S1')">
                    Dutch Auction		
                </div>
                <div id="S2" class="panel-option" onclick="selectPanel('S2')">
                    Forward Auction
                </div>
            </div>

            <input type="submit" value="Select Service">
         </form>
    </div>
</body>
</html>