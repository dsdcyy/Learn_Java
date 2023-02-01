import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {

    }
    @Test
    public void test(){
        DAO<User> dao = new DAO<>();
        dao.save("1",new User(1001,"jack"));
        dao.save("2",new User(1002,"Tom"));
        dao.save("3",new User(1003,"Sixth"));
        System.out.println(dao.get("1"));
        dao.update("1",new User(1003,"jerry"));
        dao.delete("1");
        System.out.println(dao.list());
    }
}

class DAO<T> {
    Map<String,T> m = new HashMap<>();

    //    private Set<Map.Entry<String, T>> entries = m.entrySet();
    public void save(String id, T  entity) {
        m.put(id, entity);
    }
    public T get(String id) {
        return m.get(id);
    }
    public void update(String id, T entity) {
        m.put(id, entity);
    }
    public List<T> list() {
        return new ArrayList<>(m.values());
    }
    public void delete(String id) {
        m.remove(id);
    }
}

class User{
    private int id;
    private String name;
    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}