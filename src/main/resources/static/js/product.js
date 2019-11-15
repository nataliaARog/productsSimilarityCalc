$(document).ready(function() {
	$.ajax({
		url: "http://localhost:8082/products", 
		dataType: "json",
		method: "GET",
		success: function(data) {
			$("body").append("<input type='hidden' id='productsListSize' value='"+data.length+"' />");
			
			for(var i=0;i<data.length;i++) {
				$("#productsTable").find("tbody").append(				
					"<tr>"+
						"<td class='column-id'>"+data[i].id+"</td>"+
						"<td>"+data[i].name+"</td>"+
						"<td><a href='#' data-modal onclick='showModal("+i+")'>more info</a></td>"+						
						"<td id='columnTags"+i+"' class='column hidden-element'>"+data[i].tags+"</td>"+
						"<td id='columnTagsVector"+i+"' class='column hidden-element'>"+data[i].tagsVector+"</td>"+
					"</tr>"							
				);
				
				$("body").append(
					"<div class='hidden-element'>"+
						"<input type='hidden' id='id"+i+"' value='"+data[i].id+"' />"+
						"<input type='hidden' id='name"+i+"' value='"+data[i].name+"' />"+
						"<input type='hidden' id='tagsListSize"+i+"' value='"+data[i].tags.length+"' />"+
						"<input type='hidden' id='tagsVectorListSize"+i+"' value='"+data[i].tagsVector.length+"' />"+
						"<div class='hidden-element'>"+
							"<input type='hidden' id='tag"+i+"' value='"+data[i].tags[i]+"' />"+
						"</div>"+
						"<div class='hidden-element'>"+
							"<input type='hidden' id='tagVector"+i+"' value='"+data[i].tagsVector[i]+"' />"+
						"</div>"+
					"</div>"		
				);
				
				$("#columnTags"+i).hide();
				$("#columnTagsVector"+i).hide();
			}
			
			
			$("#productsTable").DataTable({
				ordering: true,
				retrieve: true
			});
			
			$("#productsTable_wrapper").addClass("products-table");
			$(".dataTables_length").remove();
			$(".dataTables_filter").remove();	
			$(".empty-th").remove();					
		},
		error: function(err) {
			
		}
	});	
	
	$(".input-product").on("keypress",function(event) {
		if(event.which != 8 && isNaN(String.fromCharCode(event.which))){
	        event.preventDefault();
	    }
	});	
	
});

function showModal(i) {
	$("#tags").text("");
	$("#tagsVector").text("");
	$("#tags").text($("#columnTags"+i).text());
	$("#tagsVector").text($("#columnTagsVector"+i).text());
	$("#productDetailModal").modal();
}