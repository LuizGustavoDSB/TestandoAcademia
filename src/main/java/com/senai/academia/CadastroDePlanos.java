
package com.senai.academia;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CadastroDePlanos {

    public void abrirCadastroPlano() {
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Plano");

        Label labelPlano = new Label("Tipo de Plano:");

        ComboBox<String> comboPlano = new ComboBox<>();
        comboPlano.getItems().addAll("Plano para família", "Plano anual", "Plano semanal", "Plano trimestral", "Plano bianual");
        comboPlano.setPromptText("Selecione o tipo de plano");

        Label labelValor = new Label("Valor do plano:");

        TextField valorField = new TextField();
        valorField.setPromptText("Digite o valor (ex.: 99,90)");

        Button salvarBtn = new Button("Salvar");

        salvarBtn.setOnAction(e -> {
            String tipoPlano = comboPlano.getValue();
            String valor = valorField.getText().trim();

            if (tipoPlano == null || valor.isEmpty()) {
                mostrarAlerta("Erro","Preencha todos os campos!"
                );
                return;
            }

            try {
                double valorNumerico = Double.parseDouble(valor.replace(",", "."));

                if (valorNumerico <= 0) {
                    mostrarAlerta("Erro", "O valor precisa ser maior que zero.");
                    return;
                }

                Plano plano = new Plano(tipoPlano, valorNumerico);

                BancoDeDados.getInstance().adicionarPlano(plano);

                mostrarAlerta(
                        "Sucesso",
                        "Plano '" + tipoPlano
                                + "' cadastrado por R$ "
                                + String.format("%.2f", valorNumerico)
                );


                stage.close();

            } catch (NumberFormatException ex) {
                mostrarAlerta("Erro","Digite um valor numérico válido, como 99,90.");
            }
        });

        VBox layout = new VBox(
                12,
                labelPlano,
                comboPlano,
                labelValor,
                valorField,
                salvarBtn
        );

        layout.setStyle("-fx-padding: 20;");

        stage.setScene(new Scene(layout, 350, 250));
        stage.show();
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
