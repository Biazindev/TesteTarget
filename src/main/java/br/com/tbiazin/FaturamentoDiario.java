package br.com.tbiazin;


import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class FaturamentoDiario {
    public static void main(String[] args) throws IOException {
    	String path = "C:/Users/Usuário/Desktop/Teste/dados.json";
        String jsonContent = new String(Files.readAllBytes(Paths.get(path)));
        JSONArray jsonArray = new JSONArray(jsonContent);

        double menor = Double.MAX_VALUE;
        double maior = Double.MIN_VALUE;
        double soma = 0;
        int diasComFaturamento = 0;

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject dia = jsonArray.getJSONObject(i);
            if (!dia.has("valor") || dia.getDouble("valor") == 0) continue;
            double valor = dia.getDouble("valor");
            if (valor < menor) menor = valor;
            if (valor > maior) maior = valor;
            soma += valor;
            diasComFaturamento++;
        }

        double media = soma / diasComFaturamento;
        int diasAcimaMedia = 0;

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject dia = jsonArray.getJSONObject(i);
            if (!dia.has("valor") || dia.getDouble("valor") == 0) continue;
            if (dia.getDouble("valor") > media) diasAcimaMedia++;
        }

        System.out.println("Menor faturamento: " + menor);
        System.out.println("Maior faturamento: " + maior);
        System.out.println("Dias com faturamento acima da média: " + diasAcimaMedia);
    }
}
