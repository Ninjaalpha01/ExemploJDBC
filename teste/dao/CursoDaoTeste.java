package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Curso;

public class CursoDaoTeste {
    public static void main(String[] args) {
        try {
            // CursoDaoTeste.cadastrarCursoTeste();
            System.out.println("Cursos:");
            for (Curso curso : CursoDaoTeste.getCursoList()) {
                System.out.println("Curso: " + curso.getNome());   
                System.out.println("Periodo: " + curso.getPeriodo());
                System.out.println();     
            }
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
        }
    }

    public static void cadastrarCursoTeste() throws SQLException, IOException {
        Curso cc = new Curso();
        cc.setCodigo(43);
        cc.setDuracao(3);
        cc.setNome("Analise de Desenvolvimento de Sistemas");
        cc.setPeriodo("2º Periodo");

        Connection conn = BancoDados.conectar();
        new CursoDao(conn).cadastrar(cc);

        System.out.println("Cadastro efetuado com sucesso!");
    }

    public static List<Curso> getCursoList() throws SQLException, IOException {
        List<Curso> list = null;

        Connection conn = BancoDados.conectar();
        list = new CursoDao(conn).listar();
        
        return list;
    }
}
