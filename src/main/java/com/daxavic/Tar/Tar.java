package com.daxavic.Tar;

import java.io.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;
import java.util.List;

/**
 * args4j
 * Вариант 6 -- tar (*)
 * Соединяет заданные в командной строке входные текстовые файлы в выходной,
 * указываемый после ключа -out. С ключом -u делает обратную операцию, принимая
 * один входной файл и разбивая его на несколько.
 * Выходной файл тоже является текстовым. Придумать для него формат, позволяющий
 * запоминать имена входных файлов и находить их границы.
 * Command Line: tar -u filename.txt или
 * tar file1.txt file2.txt … -out output.txt.
 * Кроме самой программы, следует написать автоматические тесты к ней.
 */

public class Tar {
    private String[] commandLine; //= new String();

                                //создаём конструктор
    Tar (String commandLine) {
        this.commandLine = commandLine.trim().split(" ");
    }

    public void u() throws IOException {
        File inputFile = new File(commandLine[2]);
        List<String> lines = Files.readAllLines(Paths.get(commandLine[2]));
        int numberOfLines = lines.size();                       // показывает количество строк в исходном файле
        int numberLine = 0;                                     // показывает номер строки в исходном файле
        int n = Integer.parseInt(lines.get(0));                 // показывает, сколько строк занимают названия файлов
        Map<String, Integer> outputFiles = new HashMap<String , Integer>();    // записывается пара: название файла - кол-во строк в файле
        for (int i = 1; i <= n; i++){
            numberLine++;
            String input = lines.get(i);
            List <String> inputLine = Arrays.asList(input.trim().split(";"));
            String name = inputLine.get(0);
            Integer end = Integer.valueOf(inputLine.get(1));
            outputFiles.put(name, end);
        }

        int outputFileLines;
        while (numberLine < numberOfLines - 1) {
            numberLine++;
            String line = lines.get(numberLine);
            outputFileLines = outputFiles.get(line.trim());
            String fileName = line.trim();
            File output = new File("C:\\Users\\davik\\IdeaProjects\\Tar\\src\\" + fileName);
            FileWriter fileWrite = new FileWriter(output);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);
            while (outputFileLines > 0){
                numberLine++ ;
                bufferedWriter.write(lines.get(numberLine));
                bufferedWriter.newLine();
                outputFileLines--;
            }
            bufferedWriter.close();
        }
    }

    public void out() throws IOException {

        int n = commandLine.length - 3;

        File output = new File(commandLine[ commandLine.length - 1 ]);
        RandomAccessFile outputFile = new RandomAccessFile(output , "rw");
        FileWriter fw = new FileWriter(output);
        fw.write(n+"\n");
        String[] fileContent = new String[ n ];                               // имя файла и его содержимое
        String[] fileInfo = new String[ n ];                                  // имя;кол-во строк

        for ( int i = 0; i < n; i++ ) {
            fileContent[ i ] = commandLine[ i + 1 ] + "\n";
            FileReader fr = new FileReader(commandLine[ i + 1 ]);
            Scanner sc = new Scanner(fr);
            while ( sc.hasNextLine() ) {
                fileContent[ i ] += sc.nextLine() + "\n";
            }
            fr.close();
            fileInfo[ i ] = commandLine[ i + 1 ] + ";" + (fileContent[ i ].split("\n").length - 1) + "\n";
        }
        for ( int i = 0; i < n; i++ ) {
            fw.write(fileInfo[ i ]);
        }
        for ( int i = 0; i < n; i++ ) {
            fw.write(fileContent[ i ]);
        }
        fw.close();
    }

}
