package br.com.fiap.twoespw.libuncleotidio;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import br.com.fiap.twoespw.libuncleotidio.input.NucleotidioInputReader;
import br.com.fiap.twoespw.libuncleotidio.output.NucleotidioOutputWriter;

public class App {
    public static void main(String[] args) {
        String inputFilename = "libuncleotidio/entradas/entrada1.txt";
        String outputFilename = "saidas/saida1.txt";

        NucleotidioInputReader nir = new NucleotidioInputReader();
        NucleotidioOutputWriter now = new NucleotidioOutputWriter();
        NucleotidioCounter nc = new NucleotidioCounter();
        NucleotideoRandomGenerator randomGenerator = new NucleotideoRandomGenerator.RandomNucleotideoGenerator();

        int sequenceSize = 10;//ALTERÁVEL
        String randomSequence = randomGenerator.generate(sequenceSize);
        System.out.println("Sequência de nucleotídeos aleatórios: " + randomSequence);


        Map<Character, Integer> nucleotideCount = countNucleotides(randomSequence);
        System.out.println("Contagem de nucleotídeos:");
        for (Map.Entry<Character, Integer> entry : nucleotideCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

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

    public static Map<Character, Integer> countNucleotides(String sequence) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char nucleotide : sequence.toCharArray()) {
            countMap.put(nucleotide, countMap.getOrDefault(nucleotide, 0) + 1);
        }
        return countMap;
    }
}
