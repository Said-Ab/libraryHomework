package Services;

import models.Library;

public interface LibraryService {
    void saveLibrary(Library library);
    Library getLibrary(long id);
    void updateLibrary(Long id, Library library);
    String deleteLibrary(Long id);




}
