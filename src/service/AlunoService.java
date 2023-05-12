package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
                    "insert into aluno (nome,  sexo, periodo, coeficiente, data_ingresso, codigo_curso) values (?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getSexo());
            statement.setInt(3, aluno.getPeriodo());
            statement.setDouble(4, aluno.getCoeficiente());
            statement.setString(5, aluno.getDataIngresso());
            statement.setInt(6, aluno.getCurso().getCodigo());

            statement.executeUpdate();
        } finally {
            BancoDados.finalizarStatement(statement);
            BancoDados.desconectar();
        }
    }

    public ArrayList<Aluno> searchAll() throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;
        ArrayList<Aluno> list = new ArrayList<Aluno>();

        try {
            statement = conn.prepareStatement("select * from aluno");
            result = statement.executeQuery();

            while (result.next()) {
                Aluno aluno = new Aluno();

                aluno.setNome(result.getString("nome"));
                aluno.setRegistroAcademico(result.getInt("registro_academico"));
                aluno.setCoeficiente(result.getDouble("coeficiente"));
                aluno.setDataIngresso(result.getString("data_ingresso"));
                aluno.setPeriodo(result.getInt("periodo"));
                aluno.setSexo(result.getString("sexo"));
                aluno.setCurso(new CursoService(conn).searchByCodigo(result.getInt("codigo_curso")));
            }
            return list;
        } finally {
            BancoDados.finalizarStatement(statement);
            BancoDados.finalizarResultSet(result);
            BancoDados.desconectar();
        }
    }

    private Object CursoService(Connection conn2) {
        return null;
    }
}