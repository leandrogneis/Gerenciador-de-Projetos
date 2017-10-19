<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<t:_template>
<script>
$(document).ready(function(){
    $('#tabelaPessoas').DataTable();
});
</script>
    <div class="panel panel-default">
		<div class="panel-heading">
			<div class="clearfix">
	   			<h1 class="panel-title titulo-panel ">Pesquisa de Pessoas</h1>
                <a class="btn btn-link link-panel" href="/pessoas/novo">Nova Pessoa</a>
	   		</div>
	   	</div>
	<div class="panel-body" >
	   			
	   	<table class="table table-striped table-bordered datatable display" id="tabelaPessoas">
      			<thead>
      			
      				<tr>
      					<th class="text-center col-md-1">#</th>
      					<th class="text-center col-md-3">Nome</th>
      					<th class="text-center col-md-1">Data de vencimento</th>
      					<th class="text-center col-md-1">CPF</th>
      					<th class="text-center col-md-1">Funcionário</th>
      				</tr>
      			</thead>
      			<tbody>
      			<c:forEach items="${pessoas}" var="pessoa">
      				<tr>
      					<td class="text-center">${pessoa.id}</td>
      					<td>${pessoa.nome}</td>
      					<td class="text-center">${pessoa.dataNascimento}</td>
      					<td class="text-center">${pessoa.cpf}</td>
      					<td class="text-center"><c:if test="${pessoa.funcionario}">Sim</c:if>
      					<c:if test="${!pessoa.funcionario}">Não</c:if>
      					</td>
      				</tr>
      				</c:forEach>
      			</tbody>
      		</table>
	   	</div>
	</div>
	
</t:_template>