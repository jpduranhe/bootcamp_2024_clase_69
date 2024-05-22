<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class ="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Login</h1>
				<form  action="/login" method="post">
			     	<input type="hidden" name="id" value="0">
				  <div class="mb-3">
				    <label for="nombre" class="form-label">Usuario</label>
				    <input type="text" name="username" class="form-control" id="username">
				  </div>
				  <div class="mb-3">
				    <label for="password" class="form-label">Clave</label>
				    <input type="password" name="password" class="form-control" id="password">
				  </div>
				  <button type="submit" class="btn btn-primary">Ingresar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>