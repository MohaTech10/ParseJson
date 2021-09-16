package code.ast;


import java.util.List;

public interface JsonRoot<T> {
    boolean push(T element);
    List<T> elements();
}
