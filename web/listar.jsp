<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Consulta"%>
<%
    List<Consulta> lista = (List<Consulta>) request.getAttribute("consultas");
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>LISTA DE CONSULTA</title>
    <link rel="stylesheet" href="style.css">
    <script>
        function confirmarExclusao(id) {
            if (confirm("Deseja realmente excluir esta consulta?")) {
                window.location.href = "ControleDAO?op=Deletar&id=" + id;
            }
        }

        function editar(id) {
            window.location.href = "ControleDAO?op=Editar&id=" + id;
        }
    </script>
</head>
<body>
<div class="container1">
    <h1>CONSULTAS</h1>

    <!-- Buscar por CPF -->
    <h3>BUSCAR CONSULTA PELO CPF</h3>
    <form action="ControleDAO" method="get">
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" required />
        <input type="hidden" name="op" value="BuscarPorCpf" />
        <button type="submit">BUSCAR</button>
    </form>

    <!-- Lista de Consultas -->
    <h2>CONSULTAS CADASTRADAS</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Paciente</th>
            <th>CPF</th>
            <th>Especialidade</th>
            <th>Médico</th>
            <th>Data</th>
            <th>Hora</th>
            <th>Tipo</th>
            <th>Pagamento</th>
            <th>Observações</th>
            <th>Ações</th>
        </tr>
        <%
            if (lista != null && !lista.isEmpty()) {
                for (Consulta c : lista) {
        %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getNomePaciente() %></td>
            <td><%= c.getCpf() %></td>
            <td><%= c.getEspecialidade() %></td>
            <td><%= c.getMedico() %></td>
            <td><%= c.getData() %></td>
            <td><%= c.getHora() %></td>
            <td><%= c.getTipoConsulta() %></td>
            <td><%= c.getStatusPagamento() %></td>
            <td><%= c.getObservacoes() %></td>
              <td>
<button class="btn-editar" onclick="editar(<%= c.getId() %>)">Editar</button>
<button class="btn-deletar" onclick="confirmarExclusao(<%= c.getId() %>)">Deletar</button>

</td>

        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="11">Nenhuma consulta encontrada.</td>
        </tr>
        <% } %>
    </table>

    <br>
    <a href="index.html">VOLTAR PARA O CADASTRO </a>
</div>
</body>
</html>

