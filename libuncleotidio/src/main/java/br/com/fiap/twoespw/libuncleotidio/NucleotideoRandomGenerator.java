package br.com.fiap.twoespw.libuncleotidio;
import java.util.Random;

public interface NucleotideoRandomGenerator {
    public String generate(int sequenceSize);

    public class RandomNucleotideoGenerator implements NucleotideoRandomGenerator {

        private final char[] nucleotides = {'A', 'C', 'T', 'G'};
        private final Random random = new Random();

        @Override
        public String generate(int sequenceSize) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < sequenceSize; i++) {
                result.append(nucleotides[random.nextInt(nucleotides.length)]);
            }
            return result.toString();
        }
    }

}
