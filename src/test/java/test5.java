import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class test5 {
    @Test
    public void test(){
        List<int[]> pythagoreanTriples= IntStream
                .rangeClosed(1,100)
                .boxed()
                .flatMap(a->
                    IntStream.rangeClosed(a, 100)
                        .filter( b->
                            Math.sqrt( a * a + b * b )%1 == 0
                        )
                    .mapToObj(b->
                        new int[]{ a, b, (int)Math.sqrt( a * a + b * b ) }
                    )
                )
                .limit(2)
                .collect(toList());

        List<int[]> result = Arrays.asList( new int[]{ 3, 4, 5 }, new int[]{ 5, 12, 13 } );

        for( int[] item : pythagoreanTriples ){
            Assert.assertThat(result, CoreMatchers.hasItem(item));
        }
    }
}
