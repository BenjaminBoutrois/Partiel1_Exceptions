
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
							<label for="firstName">First Name</label>
							<input type="text" id="firstName" name="firstName" class="form-control" value="<%=student.getFirstName()%>"> 
						</div>
					</div>
					
					<div class="col">
						<div class="md-form md-outline mt-0">
							<label for="lastName">Last Name</label>
							<input type="text" id="lastName" name="lastName" class="form-control" value="<%=student.getLastName()%>"> 
						</div>
					</div>
					
				</div>

				<div class="md-form md-outline mt-0">
					<label for="mailAdresse">Mail Adress</label>
					<input type="text" id="mailAdresse" class="form-control" name="mailAdresse" value="<%=student.getMail()%>"> 
					
				</div>
				
				
				<div class="md-form md-outline">
					<label for="adress">Address</label>
					<input  id="adress" class="form-control" name="adress" value="<%=student.getAddress()%>" >
					
				</div>
				
				<div class="md-form md-outline mt-0">
					<label for="numberPhone">NumberPhone</label>
					<input type="text" id="numberPhone" name="numberPhone" class="form-control" value="<%=student.getPhone()%>">
					
				</div>				
				
				<div class="md-form md-outline mt-0">
					<label for="dateOfBirth">Birth Date - format(yyyy-mm-dd)</label>
					<input type="date" id="dateOfBirth" name="dateOfBirth" class="form-control" value="<%=student.getDob()%>">
					
				</div>
				<div class="md-form md-outline mt-0"  style="visibility:hidden;">
					<input type="text" id="id" name="id" class="form-control" value="<%=student.getId()%>">
					<label for="id">id</label>
				</div>	
			
								
				<br/> <br/>
				<div class="text-center ">
					<button type="submit" class="btn btn-primary mb-4">Submit</button>
				</div>

			</form>



		</div>

	</div>
	<!-- Card -->

</div>
<!-- Fin ajout etudiant -->

<!-- footer -->
<%@include file="footer.jsp"%>