package jdbc.BaseRepository;

import java.util.List;

public interface BaseRepository<T, Y> {
    T create(Y dto);

    List <T> list();
    
    T findById(int id);
    
    T findByUuid(String uuid);
}
 