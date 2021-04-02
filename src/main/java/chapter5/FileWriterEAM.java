package chapter5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;

public class FileWriterEAM {
    private final FileWriter writer;

    private FileWriterEAM(final String fileName) throws IOException {
        writer = new FileWriter(fileName);
    }

    private void close() throws IOException {
        System.out.println("closing resources");
        writer.close();
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }
    /*Since the programmers can't directly create an instance of
     * FileWriterEAM, we need a factory method for them to use.
     * */


    /*use() demonstrates EAM pattern  since creation and cleanup surround the action without
     * letting programmers care about it.*/
    public static void use(final String fileName,
                           final UseInstance<FileWriterEAM, IOException> block) throws IOException {
        final FileWriterEAM fileWriterEAM = new FileWriterEAM(fileName);
        try {
            block.accept(fileWriterEAM);
        } finally {
            fileWriterEAM.close();
        }
    }

    public static void main(String[] args) throws IOException {

        UseInstance<FileWriterEAM,IOException> uWriter =
                writer->writer.writeStuff("Hi.");

        FileWriterEAM.use("src/main/resources/eam.txt", uWriter);
    }
}
