package br.com.targetsistemas.distribuidorateste;

import br.com.targetsistemas.distribuidorajson.DistribuidoraJson;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class DistribuidoraTeste {

    public static void main(String[] args) {
        Gson gson = new Gson();

        String caminhoDoArquivo = "C:\\Users\\Samsung\\OneDrive\\Área de Trabalho\\desafio_target\\dados.json";

        try (FileReader reader = new FileReader(caminhoDoArquivo)) {

            Type tipoListaDias = new TypeToken<List<DistribuidoraJson>>() {}.getType();

            List<DistribuidoraJson> dias = gson.fromJson(reader, tipoListaDias);

            for (DistribuidoraJson dia : dias) {
                System.out.println("Dia 1: " + dia.getDia());
                System.out.println("Valor dia 1: " + dia.getValor());
            }
        } catch (JsonSyntaxException e) {
            System.err.println("Erro de sintaxe do JSON: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
            }
        }

    }

