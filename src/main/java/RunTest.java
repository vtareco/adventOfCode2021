import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunTest {
    public static void main(String[] args) {
        int[] a = new int[]{ 2, 2, 3, 4, 5, 6, 72, 37, 7, 7 };
        System.out.println(getMostPopularElement(a));

        List<Integer> theList = Arrays.asList(1, 3, 4, 4, 2, 3, 3);
        Integer maxOccurredElement = theList.stream()
                .reduce(BinaryOperator.maxBy((o1, o2) -> Collections.frequency(theList, o1) -
                        Collections.frequency(theList, o2))).orElse(null);
        System.out.println(maxOccurredElement);

        Integer[] array1 = {9, 4, 6, 2, 10, 10};
        Integer[] array2 = {14, 3, 6, 9, 10, 15, 17, 9};
        Set hashSet = new HashSet(Arrays.asList(array1));
        Set commonElements = new HashSet();
        for (int i = 0; i < array2.length; i++) {
            if (hashSet.contains(array2[i])) {
                commonElements.add(array2[i]);
            }
        }
        System.out.println("Common elements " + commonElements);
    }

    private static int getMostPopularElement(int[] a) {
        int maxElementIndex = getArrayMaximumElementIndex(a);
        int[] b = new int[a[maxElementIndex] + 1];

        for (int i = 0; i < a.length; i++) {
            ++b[a[i]];
        }

        return getArrayMaximumElementIndex(b);
    }

    private static int getArrayMaximumElementIndex(int[] a) {
        int maxElementIndex = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i] >= a[maxElementIndex]) {
                maxElementIndex = i;
            }
        }

        return maxElementIndex;
    }

}
