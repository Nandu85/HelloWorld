<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
.imgwrap {
	display: inline-block;
	position: relative;
	
}

.imgwrap .button1 {
	position: absolute;
	z-index: 1;
	right: 20px;
}

.imgwrap img {
	width: 100%;
}

/* .button1 {position:absolute;bottom:0;left:0;}*/
</style>


<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.1/css/bootstrap.min.css" integrity="sha512-T584yQ/tdRR5QwOpfvDfVQUidzfgc2339Lc8uBDtcp/wYu80d7jwBgAxbyMh0a9YM9F8N3tdErpFI8iaGx6x5g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.1/js/bootstrap.min.js" integrity="sha512-UR25UO94eTnCVwjbXozyeVd6ZqpaAE9naiEUBK/A+QDbfSTQFhPGj5lOR6d8tsgbBk84Ggb5A3EkjsOgPRPcKA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script> -->
</head>




<body><form action="Uploadtofile" enctype="multipart/form-data" method="post">
<input name="name"/>
<input type="file" name="Picture" multiple="multiple"/>
<input type="submit">
</form><br /><br />

<!-- <img alt="Not Found" src="images\\abc\\abc1.jpg"><br /><br />
 -->
<div class="imgwrap">

<button class="close button1" onclick="remove()">&times;</button>

<img id="img1" alt="Not Found" src="images\\abc\\abc11.jpg">

</div>

</body>

<script type="text/javascript">
function remove(){
	document.getElementById("img1").style.color="grey"/* filter="blur(5px)" */	
}


</script>
</html>