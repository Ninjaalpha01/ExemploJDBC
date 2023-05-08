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
    
    public CursoService() {
        try {
            this.conn = BancoDados.conectar();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        }
    }

    public ArrayList<Curso> buscarTodos() throws SQLException {
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

    public Curso searchByName(String cursoName) {
        return null;
    }
}
