package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.AlunoDao;
import dao.BancoDados;
import entities.Aluno;

public class AlunoService {
    public void cadastrar(Aluno aluno) throws SQLException, IOException {
        Connection conn = BancoDados.conectar();
        new AlunoDao(conn).create(aluno);
    }

    public ArrayList<Aluno> searchAll() throws SQLException, IOException {
        Connection conn = BancoDados.conectar();
        CursoService cursoService = new CursoService();
        ArrayList<Aluno> alunos = new AlunoDao(conn).listar(cursoService);
        
        for (Aluno aluno : alunos) {
            // aluno.setCurso(cursoService.);
        }
        
        return alunos;
    }

    // private Object CursoService(Connection conn2) {
    //     return null;
    // }
}