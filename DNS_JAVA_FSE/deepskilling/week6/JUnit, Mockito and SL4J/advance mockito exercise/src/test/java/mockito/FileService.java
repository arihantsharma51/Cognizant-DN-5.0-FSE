package mockito;

public class FileService {

    private FileReader fileReader;

    public FileService(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public String processFile() {

        String data = fileReader.readFile();

        return "Processed " + data;
    }
}