<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
 
엑셀업로드 : <br/>
<form name="excelUpForm" id="excelUpForm" enctype="multipart/form-data" method="POST" action="./excelDown.do">
    <input type="file" id="excelFile" name="excleFile" value="엑셀 업로드" />
</form>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

$("#excelUpForm").change(function(){
                var form = $("#excelUpForm")[0];
 
                var data = new FormData(form);
                $.ajax({
                   enctype:"multipart/form-data",
                   method:"POST",
                   url: './excelUp.do',
                   processData: false,   
                   contentType: false,
                   cache: false,
                   data: data,
                   success: function(result){  
                       alert("업로드 성공!!");
                   }
                });
            });
 
</script>
</body>
</html>
