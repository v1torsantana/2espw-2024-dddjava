package br.com.fiap.twoespw.libuncleotidio;

public class Compresser {
    public static String compress(String entrada) {
        StringBuilder resultado = new StringBuilder();

        int count = 1;
        for (int i = 0; i < entrada.length(); i++) {
            if (i + 1 < entrada.length() && entrada.charAt(i) == entrada.charAt(i + 1)) {
                count++;
            } else {
                resultado.append(entrada.charAt(i));
                resultado.append(count);
                count = 1;
            }
        }
        return resultado.toString();
    }
}
