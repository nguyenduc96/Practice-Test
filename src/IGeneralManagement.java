import java.util.List;

public interface IGeneralManagement<T> {
    void addNew(T t);

    void displayAll();

    void delete(int index);

    void update(int index, T t);

    int findId(String string);

    List<T> readFile(String path);

    void writeFile(String path);
}
