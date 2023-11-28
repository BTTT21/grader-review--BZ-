import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

class IsA implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("a");
  }
}

public class TestListExamples {

  @Test(timeout = 500)
  public void testFilter1() {
    List<String> s = Arrays.asList("a","b","c");
    List<String> expect = Arrays.asList("a");
    List<String> result = ListExamples.filter(s,new IsA());
    assertEquals(expect,result);
  }

  @Test(timeout = 500)
  public void testFilter2() {
    List<String> s = Arrays.asList("Moon","mooon","moo","moon");
    List<String> expect = Arrays.asList("moon");
    List<String> result = ListExamples.filter(s,new IsMoon());
    assertEquals(expect,result);
  }

  @Test(timeout = 500)
  public void testMergeRightEnd1() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeRightEnd2() {
    List<String> left = Arrays.asList("a", "b", "b", "c");
    List<String> right = Arrays.asList("a", "d","d","d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "b", "c", "d", "d", "d");
    assertEquals(expected, merged);
  }

}
