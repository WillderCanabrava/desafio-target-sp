package br.com.targetsistemas.distribuidorateste;

import br.com.targetsistemas.geral.DistribuidoraJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DistribuidoraTeste {

    public static void main(String[] args) {
        Gson gson = new Gson();


        try {
            // Lê o arquivo JSON e desserializa para uma lista da classe DistribuidoraJson
            Type listType = new TypeToken<List<DistribuidoraJson>>() {
            }.getType();
            List<DistribuidoraJson> valores;
            valores = gson.fromJson(new FileReader("dados.json"), listType);

            //Exclui os dias com faturamento R$ 0.00 da lista
            List<DistribuidoraJson> valoresValidos = valores.stream()
                    .filter(d -> d.getValor() > 0)
                    .toList();

            // Dia com maior faturamento
            Optional<DistribuidoraJson> maxFaturamento = valoresValidos.stream()
                    .max(Comparator.comparingDouble(DistribuidoraJson::getValor));

            // Dia com o menor faturamento
            Optional<DistribuidoraJson> minFaturamento = valoresValidos.stream()
                    .min(Comparator.comparingDouble(DistribuidoraJson::getValor));


            maxFaturamento.ifPresent(d ->
                    System.out.println("Dia com maior faturamento: dia " + d.getDia() + ", com faturamento de R$ " + d.getValor())
            );

            minFaturamento.ifPresent(d ->
                    System.out.println("Dia com menor faturamento: dia " + d.getDia() + ", com faturamento de R$ " + d.getValor())
            );

            double media = valores.stream()
                    .map(DistribuidoraJson::getValor)
                    .filter(faturamento -> faturamento > 0)
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(Double.NaN);

            // Verifica quantos dias do mês obtiveram faturamento maior que a média mensal
            long diasAcimaDaMedia = valoresValidos.stream()
                    .filter(d -> d.getValor() > media)
                    .count();


            if (!Double.isNaN(media)) {
                System.out.println("Média de faturamento por dia: R$ " + media);
                System.out.println("Número de dias com faturamento maior que a média: " + diasAcimaDaMedia);
            } else {
                System.out.println("Não há valores válidos para calcular a média.");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



