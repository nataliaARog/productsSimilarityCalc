$(document).ready(function() {
	$(".button-product").on("click",function(event) {		
		var id = $(".input-product").val();
		
		$.ajax({
			url: "http://localhost:8082/similarities", 
			dataType: "json",
			data: {"id": id},
			method: "POST",
			success: function(data) {
				for(var i=0;i<data.length;i++) {
					$("#similarityTable").find("tbody").append(				
						"<tr>"+
							"<td class='column-id-similarity'>"+data[i].id+"</td>"+
							"<td class='column-name'>"+data[i].name+"</td>"+
							"<td class='column-similarity'>"+data[i].similarity+"</td>"+					
						"</tr>"							
					);
				}			
				
				$("#productsTable").DataTable({
					ordering: true
				});				
				
				$("#productTableContent").addClass("hidden-element");			
				
				$("#similarityTable").DataTable({
					ordering: true
				});
				
				$("#similarityTable_wrapper").addClass("similarity-table");
				$(".dataTables_length").remove();
				$(".dataTables_filter").remove();
				$("#similarityTable_paginate").remove();
				$("#similarityTableContent").removeClass("hidden-element");
			},
			error: function(err) {
				
			}
		});
	});
			
});