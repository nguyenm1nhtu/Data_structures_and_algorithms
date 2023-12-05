package Bai4;

import Bai2.ListInterface;
import Bai2.SimpleArrayList;

import java.io.*;
import java.util.Scanner;

public class ProgramWordCount {
    private ListInterface<WordCount> list;

    private Scanner scanner;

    public ProgramWordCount() {
        this.list = new SimpleArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public ListInterface<WordCount> getList() {
        return list;
    }

    public void setList(ListInterface<WordCount> list) {
        this.list = list;
    }

    public void perform() {
        String[] strings = input().toLowerCase().split("[\\s]+");

        for (int i = 0; i < strings.length; i++) {
            WordCount wordCount = new WordCount(strings[i].replaceAll("[^a-zA-Z0-9]", ""), 1);
            int index = this.list.indexOf(wordCount);
            if (index >= 0) {
                this.list.get(index).setCount(this.list.get(index).getCount() + 1);
            } else {
                this.list.add(wordCount);
            }
        }
        print();
    }

    private String inputString() {
        System.out.println("Enter string:");
        String str = this.scanner.nextLine();
        return str;
    }

    private String inputFile() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter file path:");
        String path = this.scanner.nextLine();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = reader.readLine();
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            return inputFile();
        } catch (IOException e) {
            return inputFile();
        }
    }

    private String input() {
        try {
            System.out.print("Input from keyboard(1) or from text file(2): ");
            int choose = this.scanner.nextInt();
            if (choose == 1) {
                this.scanner.nextLine();
                return inputString();
            } else if (choose == 2) {
                this.scanner.nextLine();
                return inputFile();
            } else {
                input();
            }
        } catch (Exception e) {
            this.scanner.nextLine();
            input();
        }
        return null;
    }

    private void print() {
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println(this.list.get(i));
        }
    }
}
