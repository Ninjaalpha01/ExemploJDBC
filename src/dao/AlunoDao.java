package dao;

import java.sql.Connection;
import java.util.List;

import entities.Aluno;

public class AlunoDao {
    private Connection conn;

    public AlunoDao(Connection conn) {
        this.conn = conn;
    }

    public void cadastrar() {
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
