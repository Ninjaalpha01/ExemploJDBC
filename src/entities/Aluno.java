package entities;

public class Aluno {
    private int registroAluno;
    private String nome;
    private Curso curso;
    private int periodo;
    private double coeficiente;

    public Aluno() {

    }

    public int getRegistroAluno() {
        return registroAluno;
    }

    public void setRegistroAluno(int registroAluno) {
        this.registroAluno = registroAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public double getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }

}
