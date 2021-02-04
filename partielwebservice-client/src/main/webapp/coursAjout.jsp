
<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<!-- Début ajout etudiant -->

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	

	<!-- Masthead Heading-->
	<h1>Ajouter un cours</h1>
	
	
	<div class="">
	
		<div class="pt-4 pb-3">

			<form action="AjoutCoursServlet" method="post">

				<div class="form-row">
				
					<div class="col">
						<div class="md-form md-outline mt-0">
							<label for="firstName">Libellé cours</label>
							<input type="text" id="courseTheme" name="courseTheme" class="form-control"> 
						</div>
					</div>
					
					<div class="col">
						<div class="md-form md-outline mt-0">
							<label for="lastName">Nombre d'heures</label>
							<input type="number" id="courseTime" name="courseTime" class="form-control"> 
						</div>
					</div>
					
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