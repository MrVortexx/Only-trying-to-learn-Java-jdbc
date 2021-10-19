package jdbc.BaseRepository;

import java.sql.Connection;
import java.util.List;

public interface BaseRepository<T, Y> {
    T create(Y dto);

    List <T> list();
    
    T findById(int id);
    
    T findByUuid(String uuid);

    T findByUuid(String uuid, Connection c);
}
 