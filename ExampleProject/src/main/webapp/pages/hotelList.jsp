<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Hotel view</title>
<meta name="description" content="">
<meta name="author" content="">

<link href="../js/jquery-ui.css" rel="stylesheet">
<script src="../js/jquery-2.1.1.min.js"></script>
<script src="../js/jquery-ui.js"></script>
</head>

<script type="text/javascript">
	$(document).ready(function() {

		$('#cbxHotel').change(function() {
			$('#cbxCity').prop('disabled', false);
			var value = $('#cbxHotel').val();			
			alert('value : ' + value);	

			$.ajax({
                type: "GET",
                url: "/ExampleProject/pages/getCitiesByHotel",
                data: {"hotelId": value },
                dataType: 'json',
                success: function(data){
                     alert('success');
                     alert(data);
                     // Permet de vider la combo avant remplissage via AJAX
                     $('#cbxCity').empty();
                     $.each(data, function(index, value) {
                         $('#cbxCity').append($('<option>').text(value).val(index));
                     });
                }
            });
		})
		
	});

</script>

<body>

	<table border="0">
		<tr>
			<td>Hotel :</td>
			<td><form:select path="hotels" id="cbxHotel">
					<spring:message code="label.select.hotel.default.value" text="default text" var="hotelDefaultValue" />
					<form:option label="${hotelDefaultValue}" value="${hotelDefaultValue}" />
					<form:options items="${hotels}" id="id" itemValue="name"
						itemLabel="name" />
				</form:select></td>
		</tr>
		<tr>
			<td>City :</td>
			<td><form:select path="cities" id="cbxCity" disabled="true">
					<spring:message code="label.select.city.default.value" text="default text" var="cityDefaultValue" />

				</form:select></td>
		</tr>
	</table>


</body>
</html>