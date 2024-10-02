package br.com.fiap.twoespw.libuncleotidio;

public class NucleotidioCounter {

    public String count(String entrada) {
        int frequenciaA = 0;
        int frequenciaC = 0;
        int frequenciaT = 0;
        int frequenciaG = 0;

        for (char nucleotideo : entrada.toCharArray()) {
            switch (nucleotideo) {
                case 'A': frequenciaA++; break;
                case 'C': frequenciaC++; break;
                case 'T': frequenciaT++; break;
                case 'G': frequenciaG++; break;
            }
        }

        return "Tamanho da Sequência: " + entrada.length() + "\n"
                + "A: " + frequenciaA + "\n"
                + "C: " + frequenciaC + "\n"
                + "T: " + frequenciaT + "\n"
                + "G: " + frequenciaG + "\n";
    }
}
