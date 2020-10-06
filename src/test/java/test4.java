import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class test4 {
    @Test
    public void test(){
        String[] arrayOfWords = {"hello", "world"};

        List<String> words = Arrays.stream(arrayOfWords).map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        List<String> result = Arrays.asList("h","e","l","o","w","r","d");

        Assert.assertEquals(words,result);
    }
}
