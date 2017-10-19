<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<t:_template>
<script>
$(document).ready(function(){
    $('#tabelaProjetos').DataTable();
});
</script>
    <div class="panel panel-default">
		<div class="panel-heading">
			<div class="clearfix">
	   			<h1 class="panel-title titulo-panel ">Pesquisa de Projetos</h1>
                <a class="btn btn-link link-panel" href="/projetos/novo">Novo Projeto</a>
	   		</div>
	   	</div>
	<div class="panel-body" >
	   			
	   	<table class="table table-striped table-bordered datatable display" id="tabelaProjetos">
      			<thead>
      			
      				<tr>
      					<th class="text-center col-md-1">#</th>
      					<th class="text-center col-md-3">Nome do Projeto</th>
      					<th class="text-center col-md-2">Data do Inicio</th>
      					<th class="text-center col-md-2">Data Previsão Fim</th>
      					<th class="text-center col-md-2">Data Fim</th>
      					<th class="text-center col-md-1">Descrição</th>
      					<th class="text-center col-md-1">Orçamento</th>
      					<th class="text-center col-md-1">Risco</th>
      					<th class="text-center col-md-1">Status</th>
      				</tr>
      			</thead>
      			<tbody>
      			<c:forEach items="${projetos}" var="projeto">
      				<tr>
      					<td class="text-center">${projeto.id}</td>
      					<td>${projeto.nome}</td>
      					<td class="text-center">${projeto.data_inicio}</td>
      					<td class="text-center">${projeto.data_previsao_fim}</td>
      					<td class="text-center">${projeto.data_fim}</td>
      					<td class="text-center">${projeto.descricao}</td>
      					<td class="text-center">${projeto.descricao}</td>
      					<td class="text-center">${projeto.descricao}</td>
      					<td class="text-center">${projeto.descricao}</td>
      					<td class="text-center">${projeto.descricao}</td>
      					<td class="text-center">${projeto.status}</td>
      					<td class="text-center">${projeto.risco}</td>
      					<td class="text-center">${projeto.orcamento}</td>
      				</tr>
      				</c:forEach>
      			</tbody>
      		</table>
	   	</div>
	</div>
	
</t:_template>