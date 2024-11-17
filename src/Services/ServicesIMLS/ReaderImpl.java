package Services.ServicesIMLS;

import Database.Database;
import models.Library;
import models.Reader;
import Services.ReaderService;

import javax.imageio.spi.ImageReaderWriterSpi;
import java.util.ArrayList;

public class ReaderImpl implements ReaderService {
    @Override
    public void saveReader(Reader reader) {
        Database.readers.add(reader);
    }

    @Override
    public ArrayList<Reader> getAllReaders() {
        return Database.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader : Database.readers) {
            if (reader.getId() == id) {
                return reader;
            }
        }
        return null;
    }

    @Override
    public void updateReader(Long id, Reader reader) {
        for (Reader reader1 : Database.readers) {
            if (reader1.getId() == id) {
                reader1 = reader;
            }
        }
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                for (Reader reader : Database.readers) {
                    if (reader.getId() == readerId) {
library.getReader().add(reader);
                    }
                }

            }
        }
    }
}
