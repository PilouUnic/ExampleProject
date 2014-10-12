<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Hotel Booking</title>
<meta name="description" content="">
<meta name="author" content="">

<style type="text/css">
/* Override some defaults */
html, body {
	background-color: #eee;
}

body {
	padding-top: 40px;
	/* 40px to make the container go all the way to the bottom of the topbar */
}

.container>footer p {
	text-align: center; /* center align it with the container */
}

.container {
	width: 820px;
	/* downsize our container to make the content feel a bit tighter and more cohesive. NOTE: this removes two full columns from the grid, meaning you only go to 14 columns and not 16. */
}

/* The white background content wrapper */
.content {
	background-color: #fff;
	padding: 20px;
	margin: 0 -20px 18px;
	/* negative indent the amount of the padding to maintain the grid system */
	-webkit-border-radius: 0 0 6px 6px;
	-moz-border-radius: 0 0 6px 6px;
	border-radius: 0 0 6px 6px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
}

/* Page header tweaks */
.page-header {
	background-color: #f5f5f5;
	padding: 20px 20px 10px;
	margin: -20px -20px 20px;
}

/* Styles you shouldn't keep as they are for displaying this base example only */
.content .span7, .content .span3 {
	min-height: 500px;
}
/* Give a quick and non-cross-browser friendly divider */
.content .span3 {
	margin-left: 0;
	padding-left: 19px;
	border-left: 1px solid #eee;
}
</style>

</head>

<body>

	<div class="container">

		<div class="content">
			<div class="page-header">
				<h1>
					Liste des hotels <small>hotel en base</small>
				</h1>
			</div>
			<div class="row">
				<div class="span3">

					<ul class="nav pills stacked">
						<li><a href="#">Lister</a></li>
						<li><a href="#">Saisir</a></li>
						<li class="active"><a href="#">Rechercher</a></li>
					</ul>
				</div>
				<div class="span7">

					<input id="query" type="text" class="input-medium search-query">
					<button class="btn" id="button">Search</button>

					<c:if test="${not empty hotels}">

						<table class="table table-bordered table-striped">

							<thead>
								<tr>
									<th>#</th>
									<th>Nom</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody id="results">
								<c:forEach items="${hotels}" var="h">
									<tr>
										<td>${h.id}</td>
										<td>${h.name}</td>
										
											<td><spring:url var="urlDelete"
													value="/pages/jsp/delete.do">
													<spring:param name="id" value="${h.id}" />
												</spring:url> <!-- La valeur de href prend la valeur de l'attribut var du spring url -->
												<a href="${urlDelete}" class="btn danger">Delete</a></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
					<c:if test="${empty hotels}">
						<div class="alert, alert-error">No hotel.</div>
					</c:if>
				</div>


			</div>
		</div>

		<footer>
		<p>&copy; Gestion Hotel</p>
		</footer>

	</div>
</body>
</html>