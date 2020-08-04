import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testPermutation() {

        List<TestCase> testCases = getTestCases();

        for (int i = 0; i < testCases.size(); i++) {
            System.out.printf("case %d\n", i);
            TestCase testCase = testCases.get(i);

            List<List<Integer>> results = Solution.permute(testCase.input);

            assertEquals(listsToString(testCase.expect), listsToString(results));
        }
    }

    private List<TestCase> getTestCases() {
        List<TestCase> testCases = new ArrayList<>();
        testCases.add(new TestCase(new int[]{}, Arrays.asList(Arrays.asList())));
        testCases.add(new TestCase(new int[]{2}, Arrays.asList(Arrays.asList(2))));
        testCases.add(new TestCase(new int[]{1, 2}, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 1))));
        testCases.add(new TestCase(
                new int[]{1, 2, 3},
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 3, 2),
                        Arrays.asList(2, 1, 3),
                        Arrays.asList(2, 3, 1),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(3, 2, 1)
                )));
        testCases.add(new TestCase(
                new int[]{3, 2, 1},
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 3, 2),
                        Arrays.asList(2, 1, 3),
                        Arrays.asList(2, 3, 1),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(3, 2, 1)
                )));
        testCases.add(new TestCase(new int[]{2, 1}, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 1))));
        return testCases;

    }

    private String listsToString(List<List<Integer>> lists) {
        lists.sort(new ListComparator<>());

        StringBuilder sb = new StringBuilder();

        for (List<Integer> ll : lists) {
            sb.append(ll.toString());
            sb.append(";");
        }

        return sb.toString();
    }

    @Test
    public void testListToString() {
        Integer[] list1 = new Integer[]{1, 2, 3, 4};
        Integer[] list2 = new Integer[]{6, 7, 8, 3};

        List<List<Integer>> lists1 = Arrays.asList(Arrays.asList(list1), Arrays.asList(list2));
        List<List<Integer>> lists2 = Arrays.asList(Arrays.asList(list2), Arrays.asList(list1));

        String expect = "[1, 2, 3, 4];[6, 7, 8, 3];";

        assertEquals(expect, listsToString(lists1));
        assertEquals(expect, listsToString(lists2));
    }
}
