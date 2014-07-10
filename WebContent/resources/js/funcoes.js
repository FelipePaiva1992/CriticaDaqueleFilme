//Listar Filmes
function listarFilmesNome() {
	var nomeFilme = $('#nomeDoFilme').val();
	$.ajax({
		type : "GET",
		url : "ServletController",
		data : {acao : 1000, nomeFilme : nomeFilme},
		dataType : "json",
		success : function(dataResult) {
			
			$('#idTabelaFilmes').html("");
			
			dataResult = sortByKey(dataResult, 'nmFilme');
			
			for(var i = 0; i< dataResult.length; i++){
				montarTabelaFilmes(dataResult[i]);
			}	
			
			$.mobile.changePage( "#page2", { transition: "slideup", changeHash: false , reverse: true});
				
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(textStatus + "\n" + errorThrown);
		},
		beforeSend: function(){			
            $.mobile.showPageLoadingMsg();
		},
		complete: function(){
		    $.mobile.hidePageLoadingMsg();
		}
	});
}


function sortByKey(array, key) {
    return array.sort(function(a, b) {
        var x = a[key]; var y = b[key];
        return ((x < y) ? -1 : ((x > y) ? 1 : 0));
    });
}

function montarTabelaFilmes(dataResult){
	var mq = window.matchMedia( "(min-width: 400px)" );


	if (mq.matches) {
		html = "";
		html += "<br><br><br>";
		html += "<table style='color: white'>";
		html += "	<tr class='' >";
		html += "		<td rowspan='4' style='text-align: left;'><img width='300' height='410' src='" + dataResult.posterLink + "' valign='text-top' /></td>";
		html += "		<td valign='text-top'><b>Titulo: </b></td>";
		html += "		<td valign='text-top'>" +dataResult.nmFilme + "</td>";
		html += "	</tr>";
		html += "	<tr class=''>";
		html += "		<td valign='text-top'><b>Ano: </b></td>";
		html += "		<td valign='text-top'>"+dataResult.anoFilme+"</td>";
		html += "	</tr>";
		html += "	<tr class=''>";
		html += "		<td valign='text-top'><b>Criticos: </b></td>";
		html += "		<td valign='text-top'>"+dataResult.critFilmeCriticos+"%</td>";
		html += "	</tr>";
		html += "	<tr class=''>";
		html += "		<td valign='text-top'><b>Publico: </b></td>";
		html += "		<td valign='text-top'>"+dataResult.critFilmePublico+"%</td>";
		html += "	</tr>";
		html += "</table>";
		html += "</table>";
	}
	else {
		html = "";
		html += "<br><br><br>";
		html += "<table style='color: white' style='width: 70%'>";
		html += "	<tr class='' >";
		html += "		<td colspan='2' style='text-align: center;'><img  width='150' height='205' src='" + dataResult.posterLink + "' valign='text-top' /></td>";
		html += "	</tr>";
		html += "	<tr class=''>";
		html += "		<td valign='text-top'><b>Titulo: </b></td>";
		html += "		<td valign='text-top'>" +dataResult.nmFilme + "</td>";
		html += "	</tr>";	
		html += "	<tr class=''>";
		html += "		<td valign='text-top'><b>Ano: </b></td>";
		html += "		<td valign='text-top'>"+dataResult.anoFilme+"</td>";
		html += "	</tr>";
		html += "	<tr class=''>";
		html += "		<td valign='text-top'><b>Criticos: </b></td>";
		html += "		<td valign='text-top'>"+dataResult.critFilmeCriticos+"%</td>";
		html += "	</tr>";
		html += "	<tr class=''>";
		html += "		<td valign='text-top'><b>Publico: </b></td>";
		html += "		<td valign='text-top'>"+dataResult.critFilmePublico+"%</td>";
		html += "	</tr>";	
		html += "</table>";
		html += "</table>";
		html += "<hr>";
	}
		
		
		
		$('#idTabelaFilmes').append(html).trigger("create");

	
}