<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<title>Employee List</title>
</head>
<body>
<jsp:include page="riskHeader.jsp" />
	<div align="center">
		<h1 style="background-color: lightgreen; color: darkgreen">Employee
			List</h1>
		<table cellspacing="0" cellpadding="6" border="1">
			<tr bgcolor="grey" style="color: white">
				<th>No</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>HireDate</th>
				<th>BirthDate</th>
			</tr>
			<c:forEach var="employee" items="${employeesList}" varStatus="status">
				<tr bgcolor="lightyellow">
					<td><b>${status.index + 1}</b></td>
					<td>${employee.firstName}</td>
					<td>${employee.lastName}</td>
					<td>${employee.gender}</td>
					<td>${employee.hireDate}</td>
					<td>${employee.birthDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>