package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BancoDados;
import entities.Curso;

public class CursoService {
    private Connection conn;

    public CursoService(Connection conn) {
        this.conn = conn;
    }

    public CursoService() {
        try {
            this.conn = BancoDados.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Curso> searchAll() throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;
        ArrayList<Curso> list = new ArrayList<Curso>();

        try {
            statement = conn.prepareStatement("select * from curso order by codigo");
            result = statement.executeQuery();

            while (result.next()) {
                Curso curso = new Curso();

                curso.setCodigo(result.getInt("codigo"));
                curso.setNome(result.getString("nome"));
                curso.setDuracao(result.getInt("duracao"));
                curso.setPeriodo(result.getString("periodo"));

                list.add(curso);
            }
            return list;
        } finally {
            BancoDados.finalizarStatement(statement);
            BancoDados.finalizarResultSet(result);
            BancoDados.desconectar();
        }
    }

    public Curso searchByName(String cursoName) throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = conn.prepareStatement("select * from curso where nome = ?");
            statement.setString(1, cursoName);
            result = statement.executeQuery();

            if (result.next()) {
                Curso curso = new Curso();

                curso.setCodigo(result.getInt("codigo"));
                curso.setNome(result.getString("nome"));
                curso.setDuracao(result.getInt("duracao"));
                curso.setPeriodo(result.getString("periodo"));

                return curso;
            }
        } finally {
            BancoDados.finalizarStatement(statement);
            BancoDados.finalizarResultSet(result);
            BancoDados.desconectar();
        }
        return null;
    }

    public Curso searchByCodigo(int codigoCurso) throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = conn.prepareStatement("select * from curso where codigo_curso = ?");
            statement.setInt(1, codigoCurso);
            result = statement.executeQuery();

            if (result.next()) {
                Curso curso = new Curso();

                curso.setCodigo(result.getInt("codigo"));
                curso.setNome(result.getString("nome"));
                curso.setDuracao(result.getInt("duracao"));
                curso.setPeriodo(result.getString("periodo"));

                return curso;
            }
        } finally {
            BancoDados.finalizarStatement(statement);
            BancoDados.finalizarResultSet(result);
            // BancoDados.desconectar();
        }
        return null;
    }
}
