package br.com.fiap.twoespw.libuncleotidio.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class NucleotidioOutputWriter {

    public void writeWithFileOutputStream(String filename, String output) {
        System.out.println("Escrevendo no arquivo: " + filename);
        System.out.println("Conteúdo a ser gravado:\n" + output);

        File file = new File(filename);
        file.getParentFile().mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
            writer.write(output);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Arquivo não encontrado " + fnfe);
        } catch (IOException ioe) {
            System.out.println("Erro de I/O " + ioe);
        }
    }

    public void writeWithPrintStream(String filename, String output) {
        System.out.println("Escrevendo no arquivo: " + filename);
        System.out.println("Conteúdo a ser gravado:\n" + output);

        File file = new File(filename);
        file.getParentFile().mkdirs();

        try (PrintStream out = new PrintStream(file)) {
            out.println(output);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Arquivo não encontrado " + fnfe);
        }
    }
}
