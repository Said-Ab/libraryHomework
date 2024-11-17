package Services.ServicesIMLS;

import Database.Database;
import models.Library;
import Services.LibraryService;

public class LibraryImpl implements LibraryService {
    @Override
    public void saveLibrary(Library library) {
        Database.libraries.add(library);

    }

    @Override
    public Library getLibrary(long id) {
        for (Library library:Database.libraries){
            if(library.getId()==id){
                return library;
            }
        }
        return null;
    }

    @Override
    public void updateLibrary(Long id, Library library) {
        for (Library l:Database.libraries){
            if(l.getId()==id){
                l.setAddress(library.getAddress());
                l.setName(library.getName());
                l.setBooks(library.getBooks());
                l.setReader(library.getReader());
            }
        }

    }

    @Override
    public String deleteLibrary(Long id) {
        Library library=getLibrary(id);
        Database.libraries.remove(library);
        return "success deleted";
    }
}
