package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Curso;

public class CursoDao {
    private Connection conn;

    public CursoDao(Connection conn) {
        this.conn = conn;
    }

    public void cadastrar(Curso curso) throws SQLException {
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement("insert into curso (nome, periodo, duracao) values (?, ?, ?)");

            statement.setString(1, curso.getNome());
            statement.setString(2, curso.getPeriodo());
            statement.setInt(3, curso.getDuracao());

            statement.executeUpdate();
        } finally {
            BancoDados.finalizarStatement(statement);
            BancoDados.desconectar();
        }
    }

    public List<Curso> listar() throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Curso> list = new ArrayList<Curso>();

        try {
            statement = conn.prepareStatement("select * from curso order by nome");
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

    public Curso buscarPorRA(int ra) {
        return null;
    }

    public void atualizar(Curso aluno) {

    }

    public int excluir(int ra) {
        return 0;
    }
}
