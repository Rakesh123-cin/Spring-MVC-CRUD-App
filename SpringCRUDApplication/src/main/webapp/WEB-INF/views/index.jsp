<html>
<%@include file="./base.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
	<div class="container mt-3">
		<div class="row">
		
			<div class="col-md-12">
			
				<h1 class="text-center mb-3">Welcome To Product App</h1>
				<table class="table">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">Id</th>
				      <th scope="col">Product Name</th>
				      <th scope="col">Description</th>
				      <th scope="col">Price</th>
				      <th scope="col">Action</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${product}" var="p">
					    <tr>
					      <th scope="row">PRODUCTID${p.id}</th>
					      <td>${p.name }</td>
					      <td>${p.description}</td>
					      <td class="font-weight-bold">&#8377;${p.price}</td>
					      <td>
					      	<a href="delete-product/${p.id}"><i class="fa-sharp-duotone fa-solid fa-trash text-danger"></i></a>
					      	<a href="update-product/${p.id}"><i class="fa-regular fa-pen-to-square"></i></a>
					      </td>
					    </tr>
					</c:forEach>
				  </tbody>
				</table>
				
				<div class="container text-center">
					<a href="add-product" class="btn btn-outline-success">Add Product</a>
				</div>
			</div>
			
		</div>
			
	</div>
</body>
</html>
