$(document).ready(function() {	
	/*
	 * Ajax post that send the chosen product id to has the characteristcs checked and calculate
	 * to return the three most similar products list
	 * A table of three most similar products is build here 
	 * If the Ajax fail, a error mesage is shown on the screen
	 */
	
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
				
				$("tr").last().find("td").addClass("last-row");				
				$("#productTableContent").addClass("hidden-element");
				$("#similarityTableContent").removeClass("hidden-element");
			},
			error: function(xhr) {
				var msg= JSON.parse(xhr.responseText);
				$("#error").text(msg);
				$("#error").parent().removeClass("hidden-element");
			}
		});
	});
			
});