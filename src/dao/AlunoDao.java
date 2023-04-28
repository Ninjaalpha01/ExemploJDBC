package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;

public class AlunoDao {
    private Connection conn;

    public AlunoDao(Connection conn) {
        this.conn = conn;
    }

    public void cadastrar(Aluno aluno) throws SQLException {
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement(
                    "insert into aluno (nome, periodo, coeficiente, codigo_curso) values (?, ?, ?, ?)");

            statement.setString(1, aluno.getNome());
            statement.setInt(2, aluno.getPeriodo());
            statement.setDouble(3, aluno.getCoeficiente());
            statement.setInt(4, aluno.getCurso().getCodigo());

            statement.executeUpdate();
        } finally {
            BancoDados.finalizarStatement(statement);
            BancoDados.desconectar();
        }
    }

    public List<Aluno> listar() throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Aluno> list = new ArrayList<Aluno>();

        try {
            statement = conn.prepareStatement("select * from aluno order by nome");
            result = statement.executeQuery();

            while (result.next()) {
                Aluno aluno = new Aluno();

                aluno.setRegistroAcademico(result.getInt("registro_academico"));
                aluno.setNome(result.getString("nome"));
                aluno.setPeriodo(result.getInt("periodo"));
                aluno.setCoeficiente(result.getDouble("coeficiente"));

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

                aluno.setRegistroAcademico(result.getInt("registro_academico"));
                aluno.setNome(result.getString("nome"));
                aluno.setPeriodo(result.getInt("periodo"));
                aluno.setCoeficiente(result.getDouble("coeficiente"));
                // aluno.setCurso(new CursoDao(conn).buscarPorCodigo(result.getInt("codigo_curso")));

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

            statement.setInt(4, aluno.getRegistroAcademico());

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
