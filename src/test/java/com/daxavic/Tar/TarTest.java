package com.daxavic.Tar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;



public class TarTest {


        private void assertFileContent(String inputFile1, String inputFile2) throws FileNotFoundException {
            Scanner scanner1 = new Scanner(new File(inputFile1));
            Scanner scanner2 = new Scanner(new File(inputFile2));

            List<String> firstFile = new ArrayList<String>();
            List<String> secondFile = new ArrayList<String>();

            while (scanner1.hasNextLine())
                firstFile.add(scanner1.nextLine());

            while (scanner2.hasNextLine())
                secondFile.add(scanner2.nextLine());

            assertEquals(firstFile, secondFile);
        }

        @After
        public void reset() {
            Tar tar = null;
        }

    @Test
    public void uTest() throws Exception{
            Tar tar = new Tar("tar -u C:\\Users\\davik\\IdeaProjects\\Tar\\src\\files\\tests\\u\\input.txt");
            assertFileContent("C:\\Users\\davik\\IdeaProjects\\Tar\\src\\files\\testFiles\\file1.txt",
                    "C:\\Users\\davik\\IdeaProjects\\Tar\\src\\files\\tests\\u\\file1.txt");
            assertFileContent("C:\\Users\\davik\\IdeaProjects\\Tar\\src\\files\\testFiles\\file2.txt",
                    "C:\\Users\\davik\\IdeaProjects\\Tar\\src\\files\\tests\\u\\file2.txt");
            assertFileContent("C:\\Users\\davik\\IdeaProjects\\Tar\\src\\files\\testFiles\\file3.txt",
                    "C:\\Users\\davik\\IdeaProjects\\Tar\\src\\files\\tests\\u\\file3.txt");
    }

    @Test
    public void outTest() throws Exception{
            Tar tar = new Tar("tar C:\\Users\\davik\\IdeaProjects\\Tar\\src\\files\\tests\\out\\file1.txt " +
                    "C:\\Users\\davik\\IdeaProjects\\Tar\\src\\files\\tests\\out\\file2.txt " +
                    "C:\\Users\\davik\\IdeaProjects\\Tar\\src\\files\\tests\\out\\file3.txt " +
                    "-out C:\\Users\\davik\\IdeaProjects\\Tar\\src\\files\\tests\\out\\output.txt");
            assertFileContent("C:\\Users\\davik\\IdeaProjects\\Tar\\src\\files\\testFiles\\output.txt",
                    "C:\\Users\\davik\\IdeaProjects\\Tar\\src\\files\\tests\\out\\output.txt");
        }

}
