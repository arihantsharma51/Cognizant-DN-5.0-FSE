package mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class FileServiceTest {

    @Test
    public void testProcessFile() {

        FileReader mockFileReader = mock(FileReader.class);

        when(mockFileReader.readFile())
                .thenReturn("Mockito File Content");

        FileService fileService = new FileService(mockFileReader);

        String result = fileService.processFile();

        assertEquals("Processed Mockito File Content", result);
    }

}