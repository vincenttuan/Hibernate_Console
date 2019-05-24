package book.orm.dao;

import java.util.Set;

public interface IBaseDAO {
    boolean create(Object object);
    boolean update(Object object);
    boolean delete(Class cls, int id);
    Set<Object> queryAll(Class cls);
    Object get(Class cls, int id);
}
