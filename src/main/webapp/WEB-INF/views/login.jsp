<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
        rel="stylesheet"  type="text/css" />

<!-- <style>
.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style> -->

<!-- <form class="form-signin" role="form" action="j_spring_security_check"
	method="POST"> 

	<h2 class="form-signin-heading">Please sign in</h2>

	<input type="text" name="j_username" class="form-control"
		placeholder="Name"> <input type="password" name="j_password"
		class="form-control" placeholder="Password" required>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
		in</button>
<!-- </form> -->

<form class="form-horizontal"  role="form" action="j_spring_security_check"
	method="POST">
      <h2 class="form-signin-heading">Please sign in</h2>
      
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-2 control-label">Pseudo</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" name="j_username"
				placeholder="Name">
		</div>
	</div>
	
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-4">
			<input type="password" class="form-control" name="j_password"
				placeholder="Password">
		</div>
	</div>
	
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Sign in</button>
		</div>
	</div>
</form>
