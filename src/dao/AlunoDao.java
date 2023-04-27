package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            statement = conn.prepareStatement("insert into aluno (nome, periodo, coeficiente, codigo_curso) values (?, ?, ?, ?)");
            
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

    public List<Aluno> listar() {
        return null;
    }

    public Aluno buscarPorRA(int ra) {
        return null;
    }

    public void atualizar(Aluno aluno) {

    }

    public int excluir(int ra) {
        return 0;
    }
}

