package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import entities.Curso;

public class AlunoDaoTeste {
    public static void main(String[] args) {
        try {
            showMenu();
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Entrada de dados invalida.");
        } finally {
            System.out.println("Encerrando...");
        }
    }

    private static void showMenu() throws SQLException, IOException {
        Scanner input = new Scanner(System.in);
        int opc;

        System.out.println("Menu");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Listar alunos");
        System.out.println("3 - Atualizar aluno");
        System.out.println("4 - Encontrar aluno por RA");
        System.out.println("5 - Remover aluno por RA");
        System.out.println("0 - Sair");
        System.out.print("Digite a opcao desejada: ");
        opc = input.nextInt();

        switch (opc) {
            case 1:
                cadastrarAluno();
                break;
            case 2:
                printListaAlunos();
                break;
            case 3:
                atualizarAluno();
                break;
            case 4:
                encontrarAluno();
                break;
            case 5:
                removerAluno();
                break;
            default:
                System.out.println("Opcao invalida.");
                break;
        }

        input.close();
    }

    public static void cadastrarAluno() throws SQLException, IOException {
        System.out.println("Cadastrando aluno...");

        Aluno aluno = registerForm(false);

        Connection conn = BancoDados.conectar();

        new AlunoDao(conn).cadastrar(aluno);

        System.out.println("Cadastro efetuado com sucesso!");
    }

    public static void atualizarAluno() throws SQLException, IOException {
        System.out.println("Atualizando aluno...");

        Aluno aluno = registerForm(true);

        Connection conn = BancoDados.conectar();

        new AlunoDao(conn).atualizar(aluno);

        System.out.println("Atualizacao efetuada com sucesso!");
    }

    private static Aluno registerForm(boolean isAtualizacao) throws SQLException, IOException {
        Scanner input = new Scanner(System.in);
        Aluno aluno = new Aluno();

        if (!isAtualizacao) {
            System.out.println("Escolha qual curso deseja inserir o aluno: ");
            System.out.println("Codigo\t\tNome");
            CursoDaoTeste.getCursoList()
                    .forEach(curso -> System.out.println(curso.getCodigo() + "\t\t" + curso.getNome()));
            Curso curso = null;

            do {
                System.out.print("Digite um codigo de curso valido: ");
                curso = CursoDaoTeste.getCursoById(input.nextInt());
            } while (curso == null);
            aluno.setCurso(curso);
        } else {
            System.out.print("Digite o RA do aluno: ");
            aluno.setRegistroAcademico(input.nextInt());
            input.nextLine();
        }

        System.out.print("Digite o nome do aluno: ");
        aluno.setNome(input.nextLine());

        System.out.print("Digite o periodo do aluno: ");
        aluno.setPeriodo(input.nextInt());

        System.out.print("Digite o coeficiente do aluno: ");
        aluno.setCoeficiente(input.nextDouble());


        input.close();
        return aluno;
    }

    public static void printListaAlunos() throws SQLException, IOException {
        System.out.println("Aluno \t\tRA");
        for (Aluno aluno : getAlunoList()) {
            System.out.println(aluno.getNome() + "\t\t" + aluno.getRegistroAcademico());
        }
    }

    public static List<Aluno> getAlunoList() throws SQLException, IOException {
        List<Aluno> list = null;

        Connection conn = BancoDados.conectar();
        list = new AlunoDao(conn).listar();

        return list;
    }

    public static void removerAluno() throws SQLException, IOException {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o RA do aluno que deseja remover: ");
        int ra = input.nextInt();

        Connection conn = BancoDados.conectar();
        new AlunoDao(conn).remover(ra);

        System.out.println("Aluno removido com sucesso!");
        input.close();
    }

    public static void encontrarAluno() throws SQLException, IOException {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o RA do aluno que deseja encontrar: ");
        int ra = input.nextInt();

        Connection conn = BancoDados.conectar();
        Aluno aluno = new AlunoDao(conn).buscarPorRA(ra);

        if (aluno != null) {
            System.out.println("Aluno encontrado");
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("RA: " + aluno.getRegistroAcademico());
            System.out.println("Periodo: " + aluno.getPeriodo());
            System.out.println("Coeficiente: " + aluno.getCoeficiente());
            // System.out.println("Curso: " + aluno.getCurso().getNome()); //descomentar
            // quando fizer busca curso por codigo
        } else {
            System.out.println("Aluno nao encontrado.");
        }

        input.close();
    }
}
