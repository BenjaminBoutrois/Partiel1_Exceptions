
<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<!-- Début ajout etudiant -->

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />
	
	<% if(session.getAttribute("message")!=null) { %>
	
	<div class="alert alert-secondary alert-dismissible fade show" role="alert">
	  <strong> <%= session.getAttribute("message") %> </strong>
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
	
	<% 
	}
    %>
	

	<!-- Masthead Heading-->
	<h1>Ajouter un étudiant</h1>
	
	
	<div class="">
	
		<div class="pt-4 pb-3">

			<form action="AjoutEtudiantServlet" method="post">

				<div class="form-row was-valided">
				
					<div class="col">
						<div class="md-form md-outline mt-0">
							<label for="firstName">Nom</label>
							<input type="text" id="firstName" name="firstName" class="form-control" required> 
						</div>
					</div>
					
					<div class="col">
						<div class="md-form md-outline mt-0">
							<label for="lastName">Prénom</label>
							<input type="text" id="lastName" name="lastName" class="form-control" required> 
						</div>
					</div>
					
				</div>

				<div class="md-form md-outline mt-0">				
					<label for="mailAdresse">Adresse mail</label>
					<input type="email" size="30" id="mailAdresse" class="form-control" name="mailAdresse" required> 
				</div>
				
				
				<div class="md-form md-outline">	
					<label for="adress">Adresse</label>
					<textarea  id="adress" class="form-control"	name="adress" required></textarea>
				</div>
				
				<div class="md-form md-outline mt-0"  type ="hidden;">
					<label for="numberPhone">Numéro télephone</label>
					<input type="text" pattern="[0-9]{10}"  minlength="10" maxlength="10"
					id="numberPhone" name="numberPhone" class="form-control" required>
				</div>				
				
				<div class="md-form md-outline mt-0">
					<label for="dateOfBirth">Date de naissance - format(yyyy-mm-dd)</label>
					<input type="date" id="dateOfBirth" name="dateOfBirth" class="form-control" required>
				</div>
			
								
				<br/> <br/>
				<div class="text-center mb-2">
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