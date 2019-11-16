<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Products Similarity</title>
		<link rel="stylesheet" type="text/css" href="/js/DataTables/datatables.css"/>
		<link rel="stylesheet" type="text/css" href="/js/jquery-modal/jquery-modal-min.css"/>
		<link rel="stylesheet" type="text/css" href="/css/style.css"/>
		<script type="text/javascript" src="/js/jquery.js"></script> 
		<script type="text/javascript" src="/js/DataTables/datatables.js"></script>
		<script type="text/javascript" src="/js/jquery-modal/jquery-modal-min.js"></script>
		<script type="text/javascript" src="/js/product.js"></script>
		<script type="text/javascript" src="/js/similarity.js"></script>
	</head>
	<body>	
		<div class="error-div hidden-element">
			<p id="error" />
		</div>
		<div id="productTableContent">
 			<product:product></product:product>
		</div>
		<div id="similarityTableContent" class="hidden-element">
			<product:similarity></product:similarity>
		</div>	
	</body>
</html>