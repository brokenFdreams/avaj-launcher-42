package logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static final File file = new File("simulation.txt");
    private static BufferedWriter writer;

    private Logger() {
    }

    public static void log(String message) {
        if (writer == null) {
            try {
                writer = new BufferedWriter(new FileWriter(file));
            } catch (IOException e) {
                System.err.println("Error creating FileWriter - " + e.getMessage());
            }
        }
        try {
            writer.write(message + "\n");
        } catch (IOException e) {
            System.err.println("Error logging to file - " + e.getMessage());
        }
    }

    public static void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing file - " + e.getMessage());
        }
    }
}
