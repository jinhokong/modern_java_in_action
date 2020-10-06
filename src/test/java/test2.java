import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class test2 {
    @FunctionalInterface
    public interface Consumer<T>{
        void accept(T t);
    }

    public <T> void forEach(List<T> list, Consumer<T> c){
        for(T t:list){
            c.accept(t);
        }
    }
    @Test
    public void consumer(){
        forEach(
                Arrays.asList(1,2,3,4,5),
                (Integer i) -> System.out.println(i)
        );
    }
}
