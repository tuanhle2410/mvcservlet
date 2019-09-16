var table_header = '<thead><tr>'
table_header += '<th>ID</th>';
table_header += '<th>Name</th>';
table_header += '<th>Date of Birth</th>';
table_header += '<th>Gender</th>';
table_header += '<th>Enrol Date</th>';
table_header += '<th>Actions</th>';
table_header += '</tr></thead>';

$(document).ready(function() {
	pagination(datas);

	$("a.edit").click(function() {
		$id = $(this).attr('data-id');
		$item = null;
		$.each(datas, function(key, data) {
			if (data.id == $id) {
				$item = data;
			}
		});
		$radios = $('input:radio[name=gender]');
		$('#id').val($item.id);
		$('#name').val($item.name);
		$('#doB').val($item.doB);
		switch ($item.gender) {
		case "female":
			$radios.filter('[value=0]').prop('checked', true);
			break;
		case "male":
			$radios.filter('[value=1]').prop('checked', true);
			break;
		case "other":
			$radios.filter('[value=2]').prop('checked', true);
			break;
		}
		$('#enrollDate').val($item.enrollDate);
		console.log($item);
	});

	$("a.delete").click(function() {
		$id = $(this).attr('data-id');
		$item = null;
		$.each(datas, function(key, data) {
			if (data.id == $id) {
				$item = data;
			}
		});
		document.getElementById('hdnDelete').value = $item.id;
	});
});

function pagination(datas) {
	$('#pagination')
			.pagination(
					{
						dataSource : datas,
						pageSize : 10,
						showGoInput : true,
						showGoButton : true,
						callback : function(datas, pagination) {
							// template method of yourself
							var html = table_header;
							html += '<tbody>';
							$
									.each(
											datas,
											function(index, item) {
												html += '<tr>';
												html += ' <td>' + item.id
														+ '</td>';
												html += '<td>' + item.name
														+ '</td>';
												html += '<td>' + item.doB
														+ '</td>';
												html += '<td>' + item.gender
														+ '</td>';
												html += '<td>'
														+ item.enrollDate
														+ '</td>';
												html += '<td>';
												html += '<a href="#editEmployeeModal" class="edit" data-toggle="modal" data-id="'
														+ item.id
														+ '"><i class="editBtn material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>';
												html += '<a href="#deleteEmployeeModal" class="delete" data-toggle="modal" data-id="'
														+ item.id
														+ '"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>';
												html += '</td>';
												html += '</tr>';
											});

							html += '</tbody>';
							$('#data-container').html(html);
						}
					})
};

function searchFn() {

	// Activate tooltips
	// $('[data-toggle="tooltip"]').tooltip();

	// Filter table rows based on searched term
	$("#search").on("keyup", function() {
		var term = $(this).val().toLowerCase();
		$("table tbody tr").each(function() {
			$row = $(this);
			var name = $row.find("td:nth-child(2)").text().toLowerCase();
			console.log(name);
			if (name.search(term) < 0) {
				$row.hide();
			} else {
				$row.show();
			}
		});
	});
}