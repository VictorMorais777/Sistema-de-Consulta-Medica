package Controller;

import DAO.ConsultaDAO;
import model.Consulta;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/ControleDAO", urlPatterns = {"/ControleDAO"})
public class ControleDAO extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if (op == null) {
            op = "";
        }

        ConsultaDAO dao = new ConsultaDAO();

        switch (op) {
            case "Listar":
                List<Consulta> lista = dao.listar();
                request.setAttribute("consultas", lista);
                RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
                dispatcher.forward(request, response);
                break;

            case "Editar":
                int id = Integer.parseInt(request.getParameter("id"));
                Consulta consulta = dao.buscarPorId(id);
                request.setAttribute("consulta", consulta);
                RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
                rd.forward(request, response);
                break;

            case "Deletar":
                int idDel = Integer.parseInt(request.getParameter("id"));
                dao.deletar(idDel);
                response.sendRedirect("ControleDAO?op=Listar");
                break;

            case "BuscarPorCpf":
                String cpf = request.getParameter("cpf");
                List<Consulta> consultasPorCpf = dao.buscarPorCpf(cpf);
                request.setAttribute("consultas", consultasPorCpf);
                RequestDispatcher rdCpf = request.getRequestDispatcher("listar.jsp");
                rdCpf.forward(request, response);
                break;

            default:
                response.sendRedirect("index.html");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if (op == null) {
            op = "";
        }

        ConsultaDAO dao = new ConsultaDAO();

        switch (op) {
            case "CadastrarConsulta":
                Consulta c = new Consulta();
                c.setNomePaciente(request.getParameter("txtnome_paciente"));
                c.setCpf(request.getParameter("txtcpf"));
                c.setEspecialidade(request.getParameter("txtespecialidade"));
                c.setMedico(request.getParameter("txtmedico"));
                c.setData(request.getParameter("txtdata"));
                c.setHora(request.getParameter("txthora"));
                c.setTipoConsulta(request.getParameter("txttipo_consulta"));
                c.setStatusPagamento(request.getParameter("txtstatus_pagamento"));
                c.setObservacoes(request.getParameter("txtobservacoes"));
                dao.inserir(c);
                response.sendRedirect("ControleDAO?op=Listar");
                break;

            case "Editar":
                Consulta atualizar = new Consulta();
                atualizar.setId(Integer.parseInt(request.getParameter("id")));
                atualizar.setNomePaciente(request.getParameter("txtnome_paciente"));
                atualizar.setCpf(request.getParameter("txtcpf"));
                atualizar.setEspecialidade(request.getParameter("txtespecialidade"));
                atualizar.setMedico(request.getParameter("txtmedico"));
                atualizar.setData(request.getParameter("txtdata"));
                atualizar.setHora(request.getParameter("txthora"));
                atualizar.setTipoConsulta(request.getParameter("txttipo_consulta"));
                atualizar.setStatusPagamento(request.getParameter("txtstatus_pagamento"));
                atualizar.setObservacoes(request.getParameter("txtobservacoes"));
                dao.atualizar(atualizar);
                response.sendRedirect("ControleDAO?op=Listar");
                break;

            default:
                response.sendRedirect("index.html");
                break;
        }
    }
}
