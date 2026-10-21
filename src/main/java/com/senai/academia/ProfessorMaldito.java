package com.senai.academia;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ProfessorMaldito {

    @FXML
    private TextField campoNomeProfessor;

    @FXML
    private TextField campoCpfProfessor;

    @FXML
    private TextField campoContatoProfessor;

    @FXML
    private TextField campoEnderecoProfessor;

    @FXML
    private Label mensagem;

    @FXML
    private void cadastrarProfessor() {

        String nomeProfessor = campoNomeProfessor.getText();
        String cpfProfessor = campoCpfProfessor.getText();
        String contatoProfessor = campoContatoProfessor.getText();
        String enderecoProfessor = campoEnderecoProfessor.getText();

        if (nomeProfessor.trim().isEmpty() || cpfProfessor.trim().isEmpty() || contatoProfessor.trim().isEmpty() || enderecoProfessor.trim().isEmpty()){
            mensagem.setText("Preencha todos os campos!");
            return;
        }
        Professor professor = new Professor(nomeProfessor, cpfProfessor, contatoProfessor, enderecoProfessor);

        mensagem.setText("Professor cadastrado com sucesso!\n" + "Nome: " + professor.getNomeProfessor());
    }
}