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