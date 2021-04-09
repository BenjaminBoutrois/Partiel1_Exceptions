<%@page import="java.util.ArrayList"%>
<%@page import="domaine.User"%>
<%@page import="domaine.Student"%>
<%@page import="java.util.List"%>

<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	
		<a href="etudiantAjout.jsp" class="btn btn-primary mb-4"><i style="color: white"class="fas fa-user-plus"></i> Ajout d'un étudiant</a>

	<form action="RechercheEtudiantServlet" method="post">

		<div class="form-row">

			<div class="col">
				<div class="md-form md-outline mt-0">
					<label for="firstNameR">Prénom</label>
					<input type="text" id="firstNameR" name="firstNameR"
						class="form-control" placeholder="Entrer le prénom d'un étudiant"> 
				</div>
			</div>

			<div class="col">
				<div class="md-form md-outline mt-0">
				<label for="lastNameR">Nom</label>
					<input type="text" id="lastNameR" name="lastNameR"
						class="form-control" placeholder="Entrer le nom d'un étudiant"> 
				</div>
			</div>
			
				<div class="md-form md-outline mt-0" style="padding-top	:30px">
					<button type="submit" class="btn btn-primary mb-4"> <i style="color: white" class="fas fa-search"></i> Recherche</button>
				</div>
		</div>
	</form>

	<!-- Masthead Heading-->
	<%
		List<Student> listEtudiant =  (List<Student>) session.getAttribute("students");
		if (user.getProfil().equalsIgnoreCase("D")) {
			
		%>
		<h1>Liste des étudiants</h1>
		<%} else {	%>
		<h1>Informations sur un étudiant</h1>
		<%} %>
	

	<div class="table-responsive text-nowrap">
		<!--Table-->

		<table class="table table-striped" id="paginationFull">

			<!--Table head-->
			<thead>
				<tr>

					<th id="ID" name="ID">Id</th>
					<th style="width: 150px;">Prénom</th>
					<th>Nom</th>
					<th>E-mail</th>
					<th>Adresse</th>
					<th style="width: 70px;">Telephone</th>
					<th style="width: 70px;">Date de naissance</th>
					<th style="text-align: center">Action</th>
				</tr>
			</thead>
			<!--Table head-->

			<!--Table body-->
			<tbody>
				<%
					int i = 0;
				for (Student student : listEtudiant) {
				%>

				<tr>
					<td><%=student.getId()%></td>
					<td><%=student.getFirstName()%></td>
					<td><%=student.getLastName()%></td>
					<td><%=student.getMail()%></td>
					<td><%=student.getAddress()%></td>
					<td><%=student.getPhone()%></td>
					<td><%=student.getDob()%></td>
					<td style="text-align: center">
						
						
								<a style="padding: 5px; color: #1ABC9C" href="EditerEtudiantServlet?id=<%=student.getId()%>" > <i class="fas fa-user-edit"></i> </a>				
								
								<a style="padding: 5px; color: #ca5151" href="SupprimerEtudiantServlet?id=<%=student.getId()%>"> <i class="fas fa-user-times"></i></a>
								
								<a style="padding: 5px; color: #51afca"href="ViewEtudiantServlet?id=<%=student.getId()%>"> <i class="fas fa-eye"></i></a>
						
								<a href="EtudiantCoursServlet?id=<%=student.getId()%>" style="color:#2b3d51"><i class="fas fa-address-book"></i></a> 

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
<style>
	#view:hover{
	background-color: #1abc9c47;
	}
</style>
<%@include file="footer.jsp"%>