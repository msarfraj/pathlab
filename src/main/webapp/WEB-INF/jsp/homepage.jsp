<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="navbar.jsp"/>
<div class="content">
	<div class="container">
		<div class="starter-template">
			<h2>Login to continue:</h2>
		<form action="/login" method="post" >
			<div class="data">
				<div class="row">
					<div class="block_text">Email Id</div>
					<div class="block_input">
						<input type="text" name="userId" />
					</div>
				</div>
				<div class="row">
					<div class='block_text'>Password</div>
					<div class='block_input'>
						<input type="password" name="password" />
					</div>
				</div>
				<span class="submit"><input type="submit" value="Submit"></span>
				</div>
		</form>
		</div>

	</div>
</div>
<jsp:include page="footer.jsp"/>
</body>

</html>