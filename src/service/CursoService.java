package service;

import java.util.ArrayList;

import entities.Curso;

public class CursoService {
    private ArrayList<Curso> cursos;
    
    public CursoService() {
        this.cursos = new ArrayList<Curso>();

        this.cursos.add(new Curso(1, "Ciencia da Computacao", "integral", 4));
        this.cursos.add(new Curso(2, "Analise e Desenvolvimento de Sistemas", "noturno", 3));
        this.cursos.add(new Curso(3, "Engenharia da Computacao", "integral", 5));
    }

    public ArrayList<Curso> buscarTodos() {
        return this.cursos;
    }
}
