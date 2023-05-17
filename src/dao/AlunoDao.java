package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Aluno;
import service.CursoService;

public class AlunoDao {
    private Connection conn;

    public AlunoDao(Connection conn) {
        this.conn = conn;
    }

    public void create(Aluno aluno) throws SQLException {
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement(
                    "insert into aluno (nome, sexo, periodo, coeficiente, data_ingresso, codigo_curso) values (?, ?, ?, ?, ?, ?)");

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

    public ArrayList<Aluno> listar(CursoService cursoService) throws IOException, SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;
        ArrayList<Aluno> list = new ArrayList<Aluno>();

        try {
            statement = conn.prepareStatement("select * from aluno order by periodo");
            result = statement.executeQuery();

            while (result.next()) {
                Aluno aluno = new Aluno();

                aluno.setNome(result.getString("nome"));
                aluno.setRegistroAcademico(result.getInt("registro_academico"));
                aluno.setCoeficiente(result.getDouble("coeficiente"));
                aluno.setDataIngresso(result.getString("data_ingresso"));
                aluno.setPeriodo(result.getInt("periodo"));
                aluno.setSexo(result.getString("sexo"));
                aluno.getCurso().setCodigo(result.getInt("codigo_curso"));

                list.add(aluno);
            }
            return list;
        } finally {
            BancoDados.finalizarStatement(statement);
            BancoDados.finalizarResultSet(result);
            BancoDados.desconectar();
        }
    }

    public Aluno buscarPorRA(int ra) throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = conn.prepareStatement("select * from aluno where registro_academico = ?");
            statement.setInt(1, ra);
            result = statement.executeQuery();

            if (result.next()) {
                Aluno aluno = new Aluno();

                // aluno.setRegistroAcademico(result.getInt("registro_academico"));
                aluno.setNome(result.getString("nome"));
                aluno.setPeriodo(result.getInt("periodo"));
                aluno.setCoeficiente(result.getDouble("coeficiente"));
                // aluno.setCurso(new
                // CursoDao(conn).buscarPorCodigo(result.getInt("codigo_curso")));

                return aluno;
            }
        } finally {
            BancoDados.finalizarStatement(statement);
            BancoDados.finalizarResultSet(result);
            BancoDados.desconectar();
        }
        return null;
    }

    public void atualizar(Aluno aluno) throws SQLException {
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement(
                    "update aluno set nome = ?, periodo = ?, coeficiente = ? where registro_academico = ?");

            statement.setString(1, aluno.getNome());
            statement.setInt(2, aluno.getPeriodo());
            statement.setDouble(3, aluno.getCoeficiente());

            // statement.setInt(4, aluno.getRegistroAcademico());

            statement.executeUpdate();
        } finally {
            BancoDados.finalizarStatement(statement);
            BancoDados.desconectar();
        }
    }

    public void remover(int ra) throws SQLException {
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement("delete from aluno where registro_academico = ?");
            statement.setInt(1, ra);

            statement.executeUpdate();
        } finally {
            BancoDados.finalizarStatement(statement);
            BancoDados.desconectar();
        }
    }
}
