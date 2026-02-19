<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>Home Page</title>
	
	<link rel="stylesheet" href="https://cdn.datatables.net/2.3.7/css/dataTables.dataTables.css" />
	<script
	  src="https://code.jquery.com/jquery-4.0.0.js"
	  integrity="sha256-9fsHeVnKBvqh3FB2HYu7g2xseAZ5MlN6Kz/qnkASV8U="
	  crossorigin="anonymous">
	</script>
	<script src="https://cdn.datatables.net/2.3.7/js/dataTables.js"></script>
</head>

<body>
   	<script type="text/javascript">
	    function sendAjaxRequest() {
	    	var requestData = {
	    		studentName: document.getElementById('studentName').value,
	    		draw: 1
	    	};
	    	
	    	$.ajax({
	    		type: "GET",
	    		url: "/getTable",
	    		data: requestData,
	    		contentType: "application/json",
	    		dataType: "json",
	    		success: function(response) {
	    			$('#resultTable').DataTable({
	    	            "data": response.data,
	    	            "columns": [
	    	            	// mapped to attributes in data object (reviewerNameAndScore in this case)
	    	                { "data": "score" },
	    	                { "data": "reviewerFirstName" },
	    	                { "data": "reviewerLastName" },
	    	            ]
	    	        });
	    		},
	    		error: function(error) {
                    alert("Error: " + error.responseText);
                }
	    	})
	        
	    }
	</script>
	
	<h2>Reviewers and Scores</h2>>
	
	<input type="text" id="studentName" name="studentName">
	<button onclick="sendAjaxRequest()">Get Scores!</button>
	
	<table id="resultTable" class="display" style="width:100%">
        <thead>
            <tr>
                <th>Score</th>
                <th>Reviewer First Name</th>
                <th>Reviewer Last Name</th>
            </tr>
        </thead>
    </table>
</body>
</html>