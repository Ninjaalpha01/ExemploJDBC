package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import entities.Curso;
import dao.CursoDao;

public class AlunoDaoTeste {
    public static void main(String[] args) {
        try {
            AlunoDaoTeste.cadastrarAlunoTeste();
            System.out.println("Alunos:");
            for (Aluno aluno : AlunoDaoTeste.getAlunoList()) {
                System.out.println("Aluno: " + aluno.getNome());
                System.out.println("RA: " + aluno.getRegistroAluno());
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

    public static void cadastrarAlunoTeste() throws SQLException, IOException {
        Connection conn = BancoDados.conectar();
        System.out.println("Cadastrando aluno...");

        new AlunoDao(conn).cadastrar(registerForm(conn));

        System.out.println("Cadastro efetuado com sucesso!");
    }

    private static Aluno registerForm(Connection conn) throws SQLException, IOException {
        Aluno aluno = new Aluno();
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o nome do aluno: ");
        aluno.setNome(input.nextLine());

        System.out.print("Digite o periodo do aluno: ");
        aluno.setPeriodo(input.nextInt());

        System.out.print("Digite o coeficiente do aluno: ");
        aluno.setCoeficiente(input.nextDouble());

        System.out.println("Escolha qual curso deseja inserir o aluno: ");
        System.out.println("Codigo\t\tNome");
        CursoDaoTeste.getCursoList().forEach(curso -> System.out.println(curso.getCodigo() + "\t\t" + curso.getNome()));
        
        System.out.print("Digite o codigo do curso: ");
        Curso curso = CursoDaoTeste.getCursoById(input.nextInt());
        aluno.setCurso(curso);
        System.out.println("Escolhido: " + aluno.getCurso().getNome());

        input.close();
        return aluno;
    }

    public static List<Aluno> getAlunoList() {
        return null;
    }
}
