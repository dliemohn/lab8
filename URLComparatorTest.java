import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class URLComparatorTest {

    @Test
    public void testScore() throws IOException  {
        WebPageIndex wpi = new WebPageIndex("http://www.cs.oberlin.edu/~jdonalds");
        System.out.println(wpi.getUrl());
        ArrayList<String> query = new ArrayList<String>();
        query.add("Oberlin");
        URLComparator test = new URLComparator(query);
        assertEquals("should be 3", 3, test.score(wpi));
    }

    @Test
    public void testCompare() throws IOException{
        WebPageIndex wpi1 = new WebPageIndex("http://www.cs.oberlin.edu/~jdonalds");
        WebPageIndex wpi2 = new WebPageIndex("http://www.cs.oberlin.edu/~bob");
        ArrayList<String> query = new ArrayList<String>();
        query.add("Oberlin");
        URLComparator test = new URLComparator(query);
        assertEquals("should be 0", 0, test.compare(wpi1, wpi2));
    }

}