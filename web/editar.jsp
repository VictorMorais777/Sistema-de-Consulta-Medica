<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Consulta"%>
<%
    
    
    Consulta c = (Consulta) request.getAttribute("consulta");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Editar dados do Paciente</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container2">
    <h2>Editar dados do Paciente</h2>
    <form action="ControleDAO" method="post">
        <input type="hidden" name="op" value="Editar">
        <input type="hidden" name="id" value="<%= c.getId() %>">

        <label>Nome do Paciente:</label>
        <input type="text" name="txtnome_paciente" value="<%= c.getNomePaciente() %>" required>

        <label>CPF:</label>
        <input type="text" name="txtcpf" value="<%= c.getCpf() %>" required>

        <label>Especialidade:</label>
        <input type="text" name="txtespecialidade" value="<%= c.getEspecialidade() %>">

        <label>Médico:</label>
        <input type="text" name="txtmedico" value="<%= c.getMedico() %>">

        <label>Data:</label>
        <input type="date" name="txtdata" value="<%= c.getData() %>" required>

        <label>Hora:</label>
        <input type="time" name="txthora" value="<%= c.getHora() %>" required>

        <label>Tipo de Consulta:</label>
        <select name="txttipo_consulta">
            <option value="Presencial" <%= c.getTipoConsulta().equals("Presencial") ? "selected" : "" %>>Presencial</option>
            <option value="Online" <%= c.getTipoConsulta().equals("Online") ? "selected" : "" %>>Online</option>
            <option value="Rotina" <%= c.getTipoConsulta().equals("Rotina") ? "selected" : "" %>>Rotina</option>
            <option value="Retorno" <%= c.getTipoConsulta().equals("Retorno") ? "selected" : "" %>>Retorno</option>
            <option value="Urgência" <%= c.getTipoConsulta().equals("Urgência") ? "selected" : "" %>>Urgência</option>
        </select>

        <label>Status do Pagamento:</label>
        <select name="txtstatus_pagamento">
            <option value="Particular" <%= c.getStatusPagamento().equals("Particular") ? "selected" : "" %>>Particular</option>
            <option value="Convenio" <%= c.getStatusPagamento().equals("Convênio") ? "selected" : "" %>>Convênio</option>

        </select>

        <label>Observações:</label>
        <textarea name="txtobservacoes" rows="4"><%= c.getObservacoes() %></textarea>
        
        <button type="submit">Salvar</button>
    </form>

    <a href="ControleDAO?op=Listar">Voltar</a>
</div>
</body>
</html>
