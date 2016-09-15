<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	
	<link rel="stylesheet" href="resources/css/estilos.css">

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script type="text/javascript" src="resources/js/jquery.js"></script>

</head>
<body>
${message}
 	<div ng-app>
		<header>
			<div class="container-header">
				<h4>Crazy Booking</h4>
			</div> 
		</header>
	
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		    </div>
	
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul style="margin-left:10px" class="nav navbar-nav navbar-left">
		      	<li><a href="#">Encuentra Ofertas</a></li>
		        <li><a href="#">Lunas de miel</a></li>
		        <li><a href="#">Mejores Hoteles</a></li>
		        <li><a href="#">Bonito y barato</a></li>
		        <li><a href="#">Casas y apartamentos</a></li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	
		<div class="container">	
	
			<section class="main row">
	
				<article class="col-xs-12 col-sm-8 col-md-7">
				
					<form action="">
	
						<div>
							<h3><span class="glyphicon glyphicon-search">Las mejores ofertas en hoteles</span></h3>
	
						</div>
	
						<div class="form-group form-group-margintop">
							<label for="nombre">Destino, nombre del alojamiento o dirección:</label>		
							<input id="nombre" class="form-control" placeholder="Destino" type="text">
						</div>
				
						<div class="form-group form-group-margintop">
							<label for="option">Elige una option:</label>
							<select name="" id="option" class="form-control">
								<option value="">Option 1</option>
								<option value="">Option 2</option>
								<option value="">Option 3</option>
								<option value="">Option 4</option>
								<option value="">Option 5</option>		
							</select>
						</div>
	
						<div class="form-group form-group-margintop">
							<label for="mensaje">Mensaje:</label>
							<textarea name=""  class="form-control" id="mensaje" placeholder="Escribe aqui tu mensaje:"></textarea>
						</div>
						
						<div class="search_button">
							<button class="btn btn-primary">Buscar</button>
						</div>
	
					</form>	
	
				</article>
	
				<aside class="col-xs-12 col-sm-4 col-md-5">
					<h3>Aside</h3>
					<p>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium, officia dignissimos assumenda dicta dolores perspiciatis fugit, excepturi, quaerat voluptatem distinctio ab aliquid maiores sed itaque doloremque repudiandae fugiat nemo neque!
					</p>
				</aside>
			</section>
	
		</div>
	 	
	
	    <input type="text" ng-model="data.message" />
	    <h1>{{ data.message }}</h1>
	    
    </div>


	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script src="resources/js/lib/angular/angular.js"></script>
</body>
</html>
