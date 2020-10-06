import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

public class test3 {
    @Test
    public void andThen(){
        Function<Integer,Integer> f = x -> x+1;
        Function<Integer,Integer> g = x -> x*2;
        Function<Integer,Integer> h= f.andThen(g);
        int result =h.apply(1);
        Assert.assertEquals(result, 4);
    }

    @Test
    public void compose(){
        Function<Integer,Integer> f = x -> x+1;
        Function<Integer,Integer> g = x -> x*2;
        Function<Integer,Integer> h= f.compose(g);
        int result =h.apply(1);
        Assert.assertEquals(result, 3);
    }
}
