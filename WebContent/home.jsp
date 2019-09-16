<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.ArrayList"
    import="vn.topica.itlab4.dto.Student"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Student</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Student Management</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css"/>
</head>
<body>
<div class="container">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-6">
							<h2>Student <b>Management</b></h2>
							
						</div>
						<div class="col-sm-6">
							<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Student</span></a>
							
                            <div class="search-box">
                                <div class="input-group">
                                    <input type="text" id="search" class="form-control" placeholder="Search by Name" onkeyup="return searchFn()">
                                    <span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
                                    <div id="livesearch"></div>
                                </div>
                            </div>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover" id="data-container">
					
				</table>
				<div id="pagination">
				</div>
			</div>
		</div>
		<!-- Add Modal HTML -->
		<div id="addEmployeeModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="add" method="post">
						<div class="modal-header">
							<h4 class="modal-title">Add Student</h4>
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Name</label>
								<input type="text" class="form-control" name="name" required>
							</div>
							<div class="form-group">
								<label>Date of Birth</label>
								<input type="text" class="form-control" name="doB" required>
							</div>
							<div class="form-group">
								<label>Gender</label></br>
								<div class="form-check">
								<input class="form-check-input" type="radio" name="gender" value=0 checked="checked">
								<label class="form-check-label">Female</label>
								</div>
								<div class="form-check">
								<input class="form-check-input" type="radio" name="gender" value=1>
								<label class="form-check-label">Male</label>
								</div>
								<div class="form-check">
								<input class="form-check-input" type="radio" name="gender" value=2>
								<label class="form-check-label">Other</label>
								</div>
							</div>
							<div class="form-group">
								<label>Enroll Date</label>
								<input type="text" class="form-control" name="enrollDate" required>
							</div>
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
							<input type="submit" class="btn btn-success" value="Add">
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Edit Modal HTML -->
		<div id="editEmployeeModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="edit" method="post">
						<div class="modal-header">
							<h4 class="modal-title">Edit Student</h4>
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>ID</label>
								<input id="id" type="text" class="form-control" name="id" readonly required>
							</div>
							<div class="form-group">
								<label>Name</label>
								<input id="name" type="text" class="form-control" name="name" required>
							</div>
							<div class="form-group">
								<label>Date of Birth</label>
								<input id="doB" type="text" class="form-control" name="doB" required>
							</div>
							<div class="form-group">
								<label>Gender</label></br>
								<div class="form-check">
								<input class="form-check-input" type="radio" name="gender" value=0 checked="checked">
								<label class="form-check-label">Female</label>
								</div>
								<div class="form-check">
								<input class="form-check-input" type="radio" name="gender" value=1>
								<label class="form-check-label">Male</label>
								</div>
								<div class="form-check">
								<input class="form-check-input" type="radio" name="gender" value=2>
								<label class="form-check-label">Other</label>
								</div>
							</div>
							<div class="form-group">
								<label>Enroll Date</label>
								<input id="enrollDate" type="text" class="form-control" name="enrollDate" required>
							</div>
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
							<input type="submit" class="btn btn-info" value="Save">
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Delete Modal HTML -->
		<div id="deleteEmployeeModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="delete" method="post">
						<div class="modal-header">
							<h4 class="modal-title">Delete Student</h4>
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<p>Are you sure you want to delete these Records?</p>
							<p class="text-warning"><small>This action cannot be undone.</small></p>
							<input type="hidden" id="hdnDelete" name="hdnDelete" value=""></input>
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
							<input type="submit" class="btn btn-danger" value="Delete">
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>

	<%ArrayList<Student> studentList =  
		(ArrayList<Student>)request.getAttribute("data");%>
	<script>
		var datas = [
		<% for(Student s:studentList){ %>
			{
				id:"<%=s.getId()%>",
				name:"<%=s.getName()%>",
				doB:"<%=s.getDoB()%>",
				gender:"<%=s.genderToString(s.getGender())%>",
				enrollDate:"<%=s.getEnrollDate()%>",
			},
		<%}%>
		]
	</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/pagination.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
</html>