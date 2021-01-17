<%@page import="domaine.Course"%>
<%@page import="domaine.Student"%>

<%@page import="java.util.List"%>
<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />
	
	<%
			if(session.getAttribute("message")!=null) {
		%>
	
	<div class="alert alert-secondary alert-dismissible fade show" role="alert">
	  <strong> <%=session.getAttribute("message")%> </strong>
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
	
	<%
			}
		%>
	
	<a class="btn btn-outline-primary mb-3" href="AjoutCoursServlet">Ajouter un cours</a>

	<!-- Masthead Heading-->
	<h1>Liste des cours</h1>

	<div class="table-responsive text-nowrap">
		<!--Table-->

		<table class="table table-striped" id="paginationFull">

			<!--Table head-->
			<thead>
				<tr>
					<th>#</th>
					<th>Désignation</th>
					<th>Heures</th>
					<th>Actions</th>
				</tr>
			</thead>
			<!--Table head-->

			<!--Table body-->
			<tbody>
				<%
					List<Course> listeCourse = (List<Course>) session.getAttribute("courses");
				%>
				<%
					int i = 1;
				%>
				<%
					for (Course course : listeCourse) {
				%>
				<%
					
				%>
				<tr>
					<td scope="row">
						<%=
							i++
						%>
					</td>
					<td><%=course.getThemeCourse()%></td>
					<td><%=course.getNumberHours()%></td>
					<td>
						<a class="btn btn-outline-primary" href="EditerCoursServlet?id=<%=course.getId()%>" >
							<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
							  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
							  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
							</svg>
						</a>				
						<a class="btn btn-outline-danger" href="SupprimerCoursServlet?id=<%=course.getId()%>">
							<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
							  <path fill-rule="evenodd" d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z"/>
							</svg>
						</a>
						<!--  <a href="ViewEtudiantServlet?id=<%=course.getId()%>" style="color:blue">View</a> -->
					</td>
					
				</tr>
				<%
					}
				%>
			</tbody>
			<!--Table body-->


		</table>
		<!--Table-->
	</div>
	

	<!--Section: Live preview-->

</div>




<!-- footer -->
<%@include file="footer.jsp"%>