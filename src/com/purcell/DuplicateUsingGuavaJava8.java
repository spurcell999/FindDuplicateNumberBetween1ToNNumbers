package com.purcell;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateUsingGuavaJava8 {

    public Set<Integer> findDuplicates(List<Integer> input) {
        List<Integer> copy = new ArrayList<Integer>(input);

        for (Integer value: new HashSet<Integer>(input)) {
            copy.remove(value);
        }

        return new HashSet<Integer>(copy);

    }

  /*  public Set<Integer> findDuplicates(List<Integer> input) {
        // google core library (guava)
        LinkedHashMultiset<Integer> duplicates = LinkedHashMultiset.create(input);

        duplicates.entrySet().removeIf(entry -> entry.getCount() == 1);

        return duplicates.elementSet();

    }
*/

    /* streams:
    private <T> Set<T> findDuplicates(Collection<T> collection) {
    Set<T> uniques = new HashSet<>();
    return collection.stream()
        .filter(e -> !uniques.add(e))
        .collect(Collectors.toSet());
}
     */


    public static void main (String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i=1; i<5; i++) {
            numbers.add(i);
        }

        // add duplicate
        numbers.add(3);

        DuplicateUsingGuavaJava8 dn = new DuplicateUsingGuavaJava8();
        System.out.println("Duplicate Number: " + dn.findDuplicates(numbers));

    }
}
