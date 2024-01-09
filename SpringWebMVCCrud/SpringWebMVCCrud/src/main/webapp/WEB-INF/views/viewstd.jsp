<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Student List</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>User Name</th>
		<th>Email</th>
		<th>Password</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="std" items="${list}">
		<tr>
			<td>${std.sId}</td>
			<td>${std.sUserName}</td>
			<td>${std.email}</td>
			<td>${std.pass}</td>
			<td><a href="editstd/${std.id}">Update</a></td>
			<td><a href="deletestd/${std.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="stdform">Add New Student</a>