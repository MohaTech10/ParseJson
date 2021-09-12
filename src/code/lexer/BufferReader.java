package code.lexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

///Simple interface for file reader: takes a path read and send you String output
public class BufferReader {
    private BufferReader() {
    }

    public static String read(String path) {
        var output = new StringBuilder();
        try {
            var openFile = new File(path);
            var inout = new Scanner(openFile);
            while (inout.hasNextLine()) {
                output.append(inout.nextLine());
            }
            inout.close();
        } catch (FileNotFoundException e) {
            System.out.println("File may not exist");
            e.printStackTrace();
        }
        return output.toString();
    }
}
