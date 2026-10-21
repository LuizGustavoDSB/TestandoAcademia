
package com.senai.academia;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private static final BancoDeDados INSTANCIA =
            new BancoDeDados();

    private final List<Aluno> alunos = new ArrayList<>();
    private final List<Professor> professores = new ArrayList<>();
    private final List<Plano> planos = new ArrayList<>();

    private BancoDeDados() {
    }

    public static BancoDeDados getInstance() {
        return INSTANCIA;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Plano> getPlanos() {
        return planos;
    }

    public void adicionarPlano(Plano plano) {
        planos.add(plano);
    }
}
