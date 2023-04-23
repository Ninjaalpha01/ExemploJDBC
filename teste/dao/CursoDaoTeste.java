package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Curso;

public class CursoDaoTeste {
    public static void main(String[] args) {
        try {
            CursoDaoTeste.cadastrarCursoTeste();
            System.out.println("Cursos:");
            for (Curso curso : CursoDaoTeste.getCursoList()) {
                System.out.println("Curso: " + curso.getNome());
                System.out.println("Periodo: " + curso.getPeriodo());
                System.out.println();
            }
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Entrada de dados invalida.");
        } finally {
            System.out.println("Encerrando...");
        }
    }

    public static void cadastrarCursoTeste() throws SQLException, IOException {
        Connection conn = BancoDados.conectar();
        System.out.println("Cadastrando curso...");

        new CursoDao(conn).cadastrar(registerForm());

        System.out.println("Cadastro efetuado com sucesso!");
    }

    private static Curso registerForm() {
        Scanner input = new Scanner(System.in);
        Curso curso = new Curso();

        System.out.print("Digite o codigo do curso: ");
        curso.setCodigo(input.nextInt());

        System.out.print("Digite a duracao do curso: ");
        curso.setDuracao(input.nextInt());
        input.nextLine();

        System.out.print("Digite o nome do curso: ");
        curso.setNome(input.nextLine());

        System.out.print("Digite o periodo do curso: ");
        curso.setPeriodo(input.nextLine());

        input.close();
        return curso;
    }

    public static List<Curso> getCursoList() throws SQLException, IOException {
        List<Curso> list = null;

        Connection conn = BancoDados.conectar();
        list = new CursoDao(conn).listar();

        return list;
    }
}
