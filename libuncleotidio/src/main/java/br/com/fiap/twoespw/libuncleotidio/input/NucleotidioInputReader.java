package br.com.fiap.twoespw.libuncleotidio.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class NucleotidioInputReader {

    public List<String> readWithFileInputStream(String filename) {
        List<String> lines = new ArrayList<>();

        try (InputStream is = new FileInputStream(filename);
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader reader = new BufferedReader(isr)) {

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("Arquivo não encontrado " + fnfe);
        } catch (IOException ioe) {
            System.out.println("Linha mal formatada " + ioe);
        }

        return lines;
    }

    public List<String> readWithScanner(String filename) {
        List<String> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Arquivo não encontrado " + fnfe);
        }

        return lines;
    }

    public String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira uma sequência de nucleotídeos: ");
        String line = scanner.nextLine();
        return line;
    }
}
