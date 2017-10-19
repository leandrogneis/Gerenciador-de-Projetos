<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="t" %>

<html lang="pt-br">
<head>
	<link rel="stylesheet" type="text/css" href="../static/bootstrap-3.3.5-dist/css/bootstrap.min.css" />
	<link href="../static/css/style.css" rel="stylesheet" />
	<link href="../static/css/datepicker.standalone.min.css" rel="stylesheet" />
	<link href="../static/css/jquery.dataTables.min.css" rel="stylesheet" />
</head>
<body>
 <t:cabecalho />
	<div class="container">
	<jsp:doBody/>
		

	</div>
	<script type="text/javascript" src="../static/lib/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="../static/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
	<script type="text/javascript" src="../static/lib/datepicker.min.js"></script>
	<script type="text/javascript" src="../static/lib/datepicker.pt-BR.min.js"></script>
	<script type="text/javascript" src="../static/lib/jquery.dataTables.min.js"></script>
</body>

</html>