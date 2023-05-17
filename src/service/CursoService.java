package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BancoDados;
import dao.CursoDao;
import entities.Curso;

public class CursoService {
    public ArrayList<Curso> searchAll() throws SQLException, IOException {
        Connection conn = BancoDados.conectar();
        return new CursoDao(conn).listar();
    }

    public Curso searchByName(String cursoName) throws SQLException, IOException {
        Connection conn = BancoDados.conectar();
        return new CursoDao(conn).searchByName(cursoName);
    }

    public Curso searchByCodigo(int codigoCurso) throws SQLException, IOException {
        Connection conn = BancoDados.conectar();
        return new CursoDao(conn).searchById(codigoCurso);
    }
}
