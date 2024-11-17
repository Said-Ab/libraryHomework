package Services;

import models.Reader;

import java.util.ArrayList;

public interface ReaderService {
    void saveReader(Reader reader);

    ArrayList<Reader> getAllReaders();

    Reader getReaderById(Long id);

    void updateReader(Long id, Reader reader);

    void assignReaderToLibrary(Long readerId,Long libraryId);
}
