package com.senai.academia;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {

    @FXML
    private void abrirPlanos() {
        CadastroDePlanos cadastro = new CadastroDePlanos();
        cadastro.abrirCadastroPlano();
    }

    @FXML
    private void abrirAlunos() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("cadastro-aluno.fxml")
            );

            Parent tela = loader.load();
            Stage janela = new Stage();
            janela.setTitle("Cadastro de Alunos");
            janela.setScene(new Scene(tela));
            janela.show();

        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoCpf;

    @FXML
    private TextField campoContato;

    @FXML
    private TextField campoEndereco;

    @FXML
    private Label mensagem;

    @FXML
    private void cadastrarAluno() {

        String nome = campoNome.getText();
        String cpf = campoCpf.getText();
        String contato = campoContato.getText();
        String endereco = campoEndereco.getText();

        if (nome.trim().isEmpty() || cpf.trim().isEmpty() || contato.trim().isEmpty()|| endereco.trim().isEmpty()) {
            mensagem.setText("Preencha todos os campos!");

            return;
        }

        Aluno aluno = new Aluno(
                nome, cpf, contato, endereco
        );

        mensagem.setText("Aluno cadastrado com sucesso!\nNome: " + aluno.getNome()
        );

        campoNome.clear();
        campoCpf.clear();
        campoContato.clear();
        campoEndereco.clear();
    }

}
