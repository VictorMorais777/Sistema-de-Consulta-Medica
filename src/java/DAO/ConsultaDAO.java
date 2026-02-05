package DAO;

import model.Consulta;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    public void inserir(Consulta c) {
        String sql = "INSERT INTO consultas (nome_paciente, cpf, especialidade, medico, data, hora, tipo_consulta, status_pagamento, observacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getNomePaciente());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEspecialidade());
            stmt.setString(4, c.getMedico());
            stmt.setString(5, c.getData());
            stmt.setString(6, c.getHora());
            stmt.setString(7, c.getTipoConsulta());
            stmt.setString(8, c.getStatusPagamento());
            stmt.setString(9, c.getObservacoes());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Consulta> listar() {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consultas ORDER BY id DESC";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Consulta c = new Consulta();
                c.setId(rs.getInt("id"));
                c.setNomePaciente(rs.getString("nome_paciente"));
                c.setCpf(rs.getString("cpf"));
                c.setEspecialidade(rs.getString("especialidade"));
                c.setMedico(rs.getString("medico"));
                c.setData(rs.getString("data"));
                c.setHora(rs.getString("hora"));
                c.setTipoConsulta(rs.getString("tipo_consulta"));
                c.setStatusPagamento(rs.getString("status_pagamento"));
                c.setObservacoes(rs.getString("observacoes"));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Consulta buscarPorId(int id) {
        String sql = "SELECT * FROM consultas WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Consulta c = new Consulta();
                    c.setId(rs.getInt("id"));
                    c.setNomePaciente(rs.getString("nome_paciente"));
                    c.setCpf(rs.getString("cpf"));
                    c.setEspecialidade(rs.getString("especialidade"));
                    c.setMedico(rs.getString("medico"));
                    c.setData(rs.getString("data"));
                    c.setHora(rs.getString("hora"));
                    c.setTipoConsulta(rs.getString("tipo_consulta"));
                    c.setStatusPagamento(rs.getString("status_pagamento"));
                    c.setObservacoes(rs.getString("observacoes"));
                    return c;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizar(Consulta c) {
        String sql = "UPDATE consultas SET nome_paciente=?, cpf=?, especialidade=?, medico=?, data=?, hora=?, tipo_consulta=?, status_pagamento=?, observacoes=? WHERE id=?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getNomePaciente());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEspecialidade());
            stmt.setString(4, c.getMedico());
            stmt.setString(5, c.getData());
            stmt.setString(6, c.getHora());
            stmt.setString(7, c.getTipoConsulta());
            stmt.setString(8, c.getStatusPagamento());
            stmt.setString(9, c.getObservacoes());
            stmt.setInt(10, c.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM consultas WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Consulta> buscarPorCpf(String cpf) {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consultas WHERE cpf = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Consulta c = new Consulta();
                c.setId(rs.getInt("id"));
                c.setNomePaciente(rs.getString("nome_paciente"));
                c.setCpf(rs.getString("cpf"));
                c.setEspecialidade(rs.getString("especialidade"));
                c.setMedico(rs.getString("medico"));
                c.setData(rs.getString("data"));
                c.setHora(rs.getString("hora"));
                c.setTipoConsulta(rs.getString("tipo_consulta"));
                c.setStatusPagamento(rs.getString("status_pagamento"));
                c.setObservacoes(rs.getString("observacoes"));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}