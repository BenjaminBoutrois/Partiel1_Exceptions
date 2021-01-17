<%@page import="domaine.Student"%>
<%@page import="java.util.List"%>

<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	
	<!-- Masthead Heading-->
	<h1>Les informations de l'étudiant</h1>

	
		<div class="row">
			<div class="col-8">
				<div class="card">
		  			<div class="form-row">
		  				<div style="padding: 20px" class="col-6">
							<% Student student = (Student) session.getAttribute("student"); %>
							<label style="font-weight: bold"> <i style="color: #1ABC9C" class="fas fa-user-circle"></i> Prénom</label><br>
							<%=student.getFirstName()%>
							<br/><br/>
							<label style="font-weight: bold"> <i style="color: #1ABC9C" class="fas fa-home"></i> Adresse</label><br>
							<%=student.getAddress()%>
							<br/><br/>
							<label style="font-weight: bold"> <i style="color: #1ABC9C" class="fas fa-at"></i> E-mail</label><br>
							<%=student.getMail()%>
						</div>
						<div style="padding: 20px" class="col-6">
							<label style="font-weight: bold"> <i style="color: #1ABC9C" class="fas fa-user-circle"></i> Nom</label><br>
							<%=student.getLastName()%>
							<br/><br/>
							<label style="font-weight: bold"> <i style="color: #1ABC9C" class="fas fa-phone-alt"></i> Téléphone</label><br>
							<%=student.getPhone()%>
							<br/><br/>
							<label style="font-weight: bold"> <i style="color: #1ABC9C" class="fas fa-birthday-cake"></i> Date de naissance</label><br>
							<%=student.getDob()%>
						</div>
		  			</div>
				</div>
			</div>
		</div>
	

	<!--Section: Live preview-->

</div>




<!-- footer -->
<script>
</script>
<%@include file="footer.jsp"%>