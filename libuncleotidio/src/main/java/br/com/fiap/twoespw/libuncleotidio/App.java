package br.com.fiap.twoespw.libuncleotidio;

import java.util.List;

import br.com.fiap.twoespw.libuncleotidio.input.NucleotidioInputReader;
import br.com.fiap.twoespw.libuncleotidio.output.NucleotidioOutputWriter;

public class App {
    public static void main(String[] args) {
        String inputFilename = "libuncleotidio/entradas/entrada1.txt";
        String outputFilename = "saidas/saida1.txt";

        NucleotidioInputReader nir = new NucleotidioInputReader();
        NucleotidioOutputWriter now = new NucleotidioOutputWriter();
        NucleotidioCounter nc = new NucleotidioCounter();

        List<String> lines = nir.readWithScanner(inputFilename);
        if (!lines.isEmpty()) {
            String line = lines.get(0).toUpperCase();
            String compressed = Compresser.compress(line);
            String output = nc.count(compressed);
            now.writeWithPrintStream(outputFilename, output);
        } else {
            System.out.println("Arquivo de entrada vazio.");
        }
    }
}
