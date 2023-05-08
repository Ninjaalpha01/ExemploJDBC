package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.BancoDados;
import entities.Aluno;

public class AlunoService {
    private Connection conn;

    public AlunoService() {
        try {
            this.conn = BancoDados.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cadastrar(Aluno aluno) throws SQLException {
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement(
                    "insert into aluno (nome, registro_academico, sexo, periodo, coeficiente, data_ingresso, codigo_curso) values (?, ?, ?, ?, ?, ?, ?)");
            
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getRegistroAcademico());
            statement.setString(3, aluno.getSexo());
            statement.setInt(4, aluno.getPeriodo());
            statement.setDouble(5, aluno.getCoeficiente());
            statement.setString(6, aluno.getDataIngresso());
            statement.setInt(7, aluno.getCurso().getCodigo());

            statement.executeUpdate();
        } finally {
            BancoDados.finalizarStatement(statement);
            BancoDados.desconectar();
        }
    }
}