package com.daxavic.Tar;

import java.io.IOException;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

/**
 * Вариант 6 -- tar (*)
 * Соединяет заданные в командной строке входные текстовые файлы в выходной,
 * указываемый после ключа -out. С ключом -u делает обратную операцию, принимая
 * один входной файл и разбивая его на несколько.
 * Выходной файл тоже является текстовым. Придумать для него формат, позволяющий
 * запоминать имена входных файлов и находить их границы.
 * Command Line: tar -u filename.txt или
 * tar file1.txt file2.txt … -out output.txt.txt.
 * Кроме самой программы, следует написать автоматические тесты к ней.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().dMain(args[0]);
    }


    public void dMain(String comandLine) throws IOException{
        String[] arg = comandLine.split(" ");
        Tar tar = new Tar(comandLine);
    }
}





























  /**  public static void main(String[] args) {
       /** boolean isOutputFile = false;
        String inputFileName = "";
        String outputFileName = "";*/
      /** boolean flagOut = false;
       boolean flagU = false;
       String inputFileName = "";
        String outputFileName = "";
        if ( args.length == 0 ) {
            System.out.println("Объединение текстовых файлов\n" +
                    "tar file1.txt file2.txt … -out output.txt.txt\n\n " +
                    "Параметры:\n" +
                    "Флаг -out означает, что входные текстовые файлы соединяются в выходной.\n\n");
            System.out.println("Разбиение текстового файла\n" +
                    "tar -u filename.txt\n\n" +
                    "Параматры:\n" +
                    "Флаг -u означает, что выходной файл разбивается на несколько файлов");
        } else {
            for ( int i = 0; i < args.length; i++ ) {
                if (args[ i ].equals("-out")) flagOut = true;
                if (args[i].equals("-u")) flagU = true;
                }
                if ((flagOut || flagU) == false) throw new IllegalArgumentException();

            }
        }
    }
*/