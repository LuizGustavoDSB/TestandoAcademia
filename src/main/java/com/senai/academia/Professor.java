package com.senai.academia;

public class Professor {

    private String nomeProfessor;
    private String cpfProfessor;
    private String contatoProfessor;
    private String enderecoProfessor;

    public Professor(String nomeProfessor, String cpfProfessor, String contatoProfessor, String enderecoProfessor){
        this.nomeProfessor = nomeProfessor;
        this.cpfProfessor = cpfProfessor;
        this.contatoProfessor = contatoProfessor;
        this.enderecoProfessor = enderecoProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public void setCpfProfessor(String cpfProfessor) {
        this.cpfProfessor = cpfProfessor;
    }

    public void setContatoProfessor(String contatoProfessor) {
        this.contatoProfessor = contatoProfessor;
    }

    public void setEnderecoProfessor(String enderecoProfessor) {
        this.enderecoProfessor = enderecoProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public String getCpfProfessor() {
        return cpfProfessor;
    }

    public String getContatoProfessor() {
        return contatoProfessor;
    }

    public String getEnderecoProfessor() {
        return enderecoProfessor;
    }
}
