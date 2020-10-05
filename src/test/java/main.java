import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

import static org.junit.Assert.assertArrayEquals;

public class main {
    @Test
    public void lambda_is_working(){
        File[] hiddenFiles1=new File(".").listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);

        assertArrayEquals(hiddenFiles1,hiddenFiles2);
    }
}
