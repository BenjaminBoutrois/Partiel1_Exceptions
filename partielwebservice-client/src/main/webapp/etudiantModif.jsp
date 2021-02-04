
<!-- header -->

<%@page import="domaine.Student"%>
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<!-- Début ajout etudiant -->

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	<a class="btn btn-primary mb-5  text-center " href="etudiant.jsp">Liste des étudiants</a>
	

	<!-- Masthead Heading-->
	<h1>Modifier un étudiant</h1>
	
	<div class="">
	
		<div class="pt-4 pb-3">
			<%
				Student student = (Student) session.getAttribute("student");
			%>
			<form action="ModifEtudiantServlet" method="post">

				<div class="form-row">
				
					<div class="col">
						<div class="md-form md-outline mt-0">
							<label for="firstName">Nom</label>
							<input type="text" id="firstName" name="firstName" class="form-control" value="<%=student.getFirstName()%>"> 
						</div>
					</div>
					
					<div class="col">
						<div class="md-form md-outline mt-0">
							<label for="lastName">Prénom</label>
							<input type="text" id="lastName" name="lastName" class="form-control" value="<%=student.getLastName()%>"> 
						</div>
					</div>
					
				</div>

				<div class="md-form md-outline mt-0">
					<label for="mailAdresse"> Adresse mail</label>
					<input type="email" id="mailAdresse" class="form-control" name="mailAdresse" value="<%=student.getMail()%>"> 
					
				</div>
				
				
				<div class="md-form md-outline">
					<label for="adress">Adresse</label>
					<input  id="adress" class="form-control" name="adress" value="<%=student.getAddress()%>" >
					
				</div>
				
				<div class="md-form md-outline mt-0">
					<label for="numberPhone">Numéro téléphone</label>
					<input type="text" pattern="[0-9]{10}"  minlength="10" maxlength="10" id="numberPhone" name="numberPhone" class="form-control" value="<%=student.getPhone()%>">
					
				</div>				
				
				<div class="md-form md-outline mt-0">
					<label for="dateOfBirth">Date de naissance - format(dd-MM-yyyy)</label>
					<input type="date" id="dateOfBirth"  name="dateOfBirth" class="form-control" value="<%=student.getDob()%>">
					
				</div>
				<div class="md-form md-outline mt-0"  style="visibility:hidden;">
					<input type="text" id="id" name="id" class="form-control" value="<%=student.getId()%>">
					<label for="id">id</label>
				</div>	
			
								
				<br/> <br/>
				<div class="text-center ">
					<button type="submit" class="btn btn-primary mb-4">Valider</button>
				</div>

			</form>



		</div>

	</div>
	<!-- Card -->

</div>
<!-- Fin ajout etudiant -->

<!-- footer -->
<%@include file="footer.jsp"%>