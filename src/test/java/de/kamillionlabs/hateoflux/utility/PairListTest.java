package de.kamillionlabs.hateoflux.utility;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PairListTest {

    @Test
    void givenEmptyPairList_whenAdd_thenElementsAreAdded() {
        PairList<String, Integer> pairList = PairList.of();
        pairList.add("one", 1);
        pairList.add("two", 2);

        assertThat(pairList).hasSize(2);
        assertThat(pairList.getLeft(0)).isEqualTo("one");
        assertThat(pairList.getRight(0)).isEqualTo(1);
        assertThat(pairList.getLeft(1)).isEqualTo("two");
        assertThat(pairList.getRight(1)).isEqualTo(2);
    }

    @Test
    void givenPairListWithElements_whenGetLeftsAndRights_thenCorrectListsReturned() {
        PairList<String, Integer> pairList = PairList.of();
        pairList.add("one", 1);
        pairList.add("two", 2);
        pairList.add("three", 3);

        List<String> lefts = pairList.getLefts();
        List<Integer> rights = pairList.getRights();

        assertThat(lefts).containsExactly("one", "two", "three");
        assertThat(rights).containsExactly(1, 2, 3);
    }

    @Test
    void givenPairsList_whenOfMethodCalled_thenPairListCreated() {
        List<Pair<String, Integer>> pairs = List.of(
                Pair.of("one", 1),
                Pair.of("two", 2),
                Pair.of("three", 3)
        );
        PairList<String, Integer> pairList = PairList.of(pairs);

        assertThat(pairList).hasSize(3);
        assertThat(pairList.getLeft(0)).isEqualTo("one");
        assertThat(pairList.getRight(0)).isEqualTo(1);
        assertThat(pairList.getLeft(1)).isEqualTo("two");
        assertThat(pairList.getRight(1)).isEqualTo(2);
        assertThat(pairList.getLeft(2)).isEqualTo("three");
        assertThat(pairList.getRight(2)).isEqualTo(3);
    }

    @Test
    void givenLeftsAndRightsLists_whenOfMethodCalled_thenPairListCreated() {
        List<String> lefts = List.of("one", "two", "three");
        List<Integer> rights = List.of(1, 2, 3);
        PairList<String, Integer> pairList = PairList.of(lefts, rights);

        assertThat(pairList).hasSize(3);
        assertThat(pairList.getLeft(0)).isEqualTo("one");
        assertThat(pairList.getRight(0)).isEqualTo(1);
        assertThat(pairList.getLeft(1)).isEqualTo("two");
        assertThat(pairList.getRight(1)).isEqualTo(2);
        assertThat(pairList.getLeft(2)).isEqualTo("three");
        assertThat(pairList.getRight(2)).isEqualTo(3);
    }

    @Test
    void givenMap_whenOfMethodCalled_thenPairListCreated() {
        Map<String, Integer> map = Map.of(
                "one", 1,
                "two", 2,
                "three", 3
        );
        PairList<String, Integer> pairList = PairList.of(map);

        assertThat(pairList).hasSize(3);
        assertThat(pairList.getLefts()).containsExactlyInAnyOrder("one", "two", "three");
        assertThat(pairList.getRights()).containsExactlyInAnyOrder(1, 2, 3);
    }

    @Test
    void givenVarargs_whenOfMethodCalled_thenPairListCreated() {
        PairList<String, Integer> pairList = PairList.of(
                "one", 1,
                "two", 2,
                "three", 3
        );

        assertThat(pairList).hasSize(3);
        assertThat(pairList.getLeft(0)).isEqualTo("one");
        assertThat(pairList.getRight(0)).isEqualTo(1);
        assertThat(pairList.getLeft(1)).isEqualTo("two");
        assertThat(pairList.getRight(1)).isEqualTo(2);
        assertThat(pairList.getLeft(2)).isEqualTo("three");
        assertThat(pairList.getRight(2)).isEqualTo(3);
    }

    @Test
    void givenPairListWithElements_whenGetLeft_thenCorrectLeftReturned() {
        PairList<String, Integer> pairList = PairList.of("one", 1, "two", 2, "three", 3);

        assertThat(pairList.getLeft(0)).isEqualTo("one");
        assertThat(pairList.getLeft(1)).isEqualTo("two");
        assertThat(pairList.getLeft(2)).isEqualTo("three");
    }

    @Test
    void givenPairListWithElements_whenGetRight_thenCorrectRightReturned() {
        PairList<String, Integer> pairList = PairList.of("one", 1, "two", 2, "three", 3);

        assertThat(pairList.getRight(0)).isEqualTo(1);
        assertThat(pairList.getRight(1)).isEqualTo(2);
        assertThat(pairList.getRight(2)).isEqualTo(3);
    }

    @Test
    void givenTwoPairs_whenOfMethodCalled_thenPairListCreated() {
        PairList<String, Integer> pairList = PairList.of("one", 1, "two", 2);

        assertThat(pairList).hasSize(2);
        assertThat(pairList.getLeft(0)).isEqualTo("one");
        assertThat(pairList.getRight(0)).isEqualTo(1);
        assertThat(pairList.getLeft(1)).isEqualTo("two");
        assertThat(pairList.getRight(1)).isEqualTo(2);
    }

    @Test
    void givenThreePairs_whenOfMethodCalled_thenPairListCreated() {
        PairList<String, Integer> pairList = PairList.of("one", 1, "two", 2, "three", 3);

        assertThat(pairList).hasSize(3);
        assertThat(pairList.getLeft(0)).isEqualTo("one");
        assertThat(pairList.getRight(0)).isEqualTo(1);
        assertThat(pairList.getLeft(1)).isEqualTo("two");
        assertThat(pairList.getRight(1)).isEqualTo(2);
        assertThat(pairList.getLeft(2)).isEqualTo("three");
        assertThat(pairList.getRight(2)).isEqualTo(3);
    }

    @Test
    void givenFourPairs_whenOfMethodCalled_thenPairListCreated() {
        PairList<String, Integer> pairList = PairList.of("one", 1, "two", 2, "three", 3, "four", 4);

        assertThat(pairList).hasSize(4);
        assertThat(pairList.getLeft(0)).isEqualTo("one");
        assertThat(pairList.getRight(0)).isEqualTo(1);
        assertThat(pairList.getLeft(1)).isEqualTo("two");
        assertThat(pairList.getRight(1)).isEqualTo(2);
        assertThat(pairList.getLeft(2)).isEqualTo("three");
        assertThat(pairList.getRight(2)).isEqualTo(3);
        assertThat(pairList.getLeft(3)).isEqualTo("four");
        assertThat(pairList.getRight(3)).isEqualTo(4);
    }

    @Test
    void givenFivePairs_whenOfMethodCalled_thenPairListCreated() {
        PairList<String, Integer> pairList = PairList.of("one", 1, "two", 2, "three", 3, "four", 4, "five", 5);

        assertThat(pairList).hasSize(5);
        assertThat(pairList.getLeft(0)).isEqualTo("one");
        assertThat(pairList.getRight(0)).isEqualTo(1);
        assertThat(pairList.getLeft(1)).isEqualTo("two");
        assertThat(pairList.getRight(1)).isEqualTo(2);
        assertThat(pairList.getLeft(2)).isEqualTo("three");
        assertThat(pairList.getRight(2)).isEqualTo(3);
        assertThat(pairList.getLeft(3)).isEqualTo("four");
        assertThat(pairList.getRight(3)).isEqualTo(4);
        assertThat(pairList.getLeft(4)).isEqualTo("five");
        assertThat(pairList.getRight(4)).isEqualTo(5);
    }

    @Test
    void givenSixPairs_whenOfMethodCalled_thenPairListCreated() {
        PairList<String, Integer> pairList = PairList.of("one", 1, "two", 2, "three", 3, "four", 4, "five", 5, "six",
                6);

        assertThat(pairList).hasSize(6);
        assertThat(pairList.getLeft(0)).isEqualTo("one");
        assertThat(pairList.getRight(0)).isEqualTo(1);
        assertThat(pairList.getLeft(1)).isEqualTo("two");
        assertThat(pairList.getRight(1)).isEqualTo(2);
        assertThat(pairList.getLeft(2)).isEqualTo("three");
        assertThat(pairList.getRight(2)).isEqualTo(3);
        assertThat(pairList.getLeft(3)).isEqualTo("four");
        assertThat(pairList.getRight(3)).isEqualTo(4);
        assertThat(pairList.getLeft(4)).isEqualTo("five");
        assertThat(pairList.getRight(4)).isEqualTo(5);
        assertThat(pairList.getLeft(5)).isEqualTo("six");
        assertThat(pairList.getRight(5)).isEqualTo(6);
    }

    @Test
    void givenSevenPairs_whenOfMethodCalled_thenPairListCreated() {
        PairList<String, Integer> pairList = PairList.of("one", 1, "two", 2, "three", 3, "four", 4, "five", 5, "six",
                6, "seven", 7);

        assertThat(pairList).hasSize(7);
        assertThat(pairList.getLeft(0)).isEqualTo("one");
        assertThat(pairList.getRight(0)).isEqualTo(1);
        assertThat(pairList.getLeft(1)).isEqualTo("two");
        assertThat(pairList.getRight(1)).isEqualTo(2);
        assertThat(pairList.getLeft(2)).isEqualTo("three");
        assertThat(pairList.getRight(2)).isEqualTo(3);
        assertThat(pairList.getLeft(3)).isEqualTo("four");
        assertThat(pairList.getRight(3)).isEqualTo(4);
        assertThat(pairList.getLeft(4)).isEqualTo("five");
        assertThat(pairList.getRight(4)).isEqualTo(5);
        assertThat(pairList.getLeft(5)).isEqualTo("six");
        assertThat(pairList.getRight(5)).isEqualTo(6);
        assertThat(pairList.getLeft(6)).isEqualTo("seven");
        assertThat(pairList.getRight(6)).isEqualTo(7);
    }

    @Test
    void givenEightPairs_whenOfMethodCalled_thenPairListCreated() {
        PairList<String, Integer> pairList = PairList.of("one", 1, "two", 2, "three", 3, "four", 4, "five", 5, "six",
                6, "seven", 7, "eight", 8);

        assertThat(pairList).hasSize(8);
        assertThat(pairList.getLeft(0)).isEqualTo("one");
        assertThat(pairList.getRight(0)).isEqualTo(1);
        assertThat(pairList.getLeft(1)).isEqualTo("two");
        assertThat(pairList.getRight(1)).isEqualTo(2);
        assertThat(pairList.getLeft(2)).isEqualTo("three");
        assertThat(pairList.getRight(2)).isEqualTo(3);
        assertThat(pairList.getLeft(3)).isEqualTo("four");
        assertThat(pairList.getRight(3)).isEqualTo(4);
        assertThat(pairList.getLeft(4)).isEqualTo("five");
        assertThat(pairList.getRight(4)).isEqualTo(5);
        assertThat(pairList.getLeft(5)).isEqualTo("six");
        assertThat(pairList.getRight(5)).isEqualTo(6);
        assertThat(pairList.getLeft(6)).isEqualTo("seven");
        assertThat(pairList.getRight(6)).isEqualTo(7);
        assertThat(pairList.getLeft(7)).isEqualTo("eight");
        assertThat(pairList.getRight(7)).isEqualTo(8);
    }

    @Test
    void givenNinePairs_whenOfMethodCalled_thenPairListCreated() {
        PairList<String, Integer> pairList = PairList.of("one", 1, "two", 2, "three", 3, "four", 4, "five", 5, "six",
                6, "seven", 7, "eight", 8, "nine", 9);

        assertThat(pairList).hasSize(9);
        assertThat(pairList.getLeft(0)).isEqualTo("one");
        assertThat(pairList.getRight(0)).isEqualTo(1);
        assertThat(pairList.getLeft(1)).isEqualTo("two");
        assertThat(pairList.getRight(1)).isEqualTo(2);
        assertThat(pairList.getLeft(2)).isEqualTo("three");
        assertThat(pairList.getRight(2)).isEqualTo(3);
        assertThat(pairList.getLeft(3)).isEqualTo("four");
        assertThat(pairList.getRight(3)).isEqualTo(4);
        assertThat(pairList.getLeft(4)).isEqualTo("five");
        assertThat(pairList.getRight(4)).isEqualTo(5);
        assertThat(pairList.getLeft(5)).isEqualTo("six");
        assertThat(pairList.getRight(5)).isEqualTo(6);
        assertThat(pairList.getLeft(6)).isEqualTo("seven");
        assertThat(pairList.getRight(6)).isEqualTo(7);
        assertThat(pairList.getLeft(7)).isEqualTo("eight");
        assertThat(pairList.getRight(7)).isEqualTo(8);
        assertThat(pairList.getLeft(8)).isEqualTo("nine");
        assertThat(pairList.getRight(8)).isEqualTo(9);
    }

    @Test
    void givenTenPairs_whenOfMethodCalled_thenPairListCreated() {
        PairList<String, Integer> pairList = PairList.of("one", 1, "two", 2, "three", 3, "four", 4, "five", 5, "six",
                6, "seven", 7, "eight", 8, "nine", 9, "ten", 10);

        assertThat(pairList).hasSize(10);
        assertThat(pairList.getLeft(0)).isEqualTo("one");
        assertThat(pairList.getRight(0)).isEqualTo(1);
        assertThat(pairList.getLeft(1)).isEqualTo("two");
        assertThat(pairList.getRight(1)).isEqualTo(2);
        assertThat(pairList.getLeft(2)).isEqualTo("three");
        assertThat(pairList.getRight(2)).isEqualTo(3);
        assertThat(pairList.getLeft(3)).isEqualTo("four");
        assertThat(pairList.getRight(3)).isEqualTo(4);
        assertThat(pairList.getLeft(4)).isEqualTo("five");
        assertThat(pairList.getRight(4)).isEqualTo(5);
        assertThat(pairList.getLeft(5)).isEqualTo("six");
        assertThat(pairList.getRight(5)).isEqualTo(6);
        assertThat(pairList.getLeft(6)).isEqualTo("seven");
        assertThat(pairList.getRight(6)).isEqualTo(7);
        assertThat(pairList.getLeft(7)).isEqualTo("eight");
        assertThat(pairList.getRight(7)).isEqualTo(8);
        assertThat(pairList.getLeft(8)).isEqualTo("nine");
        assertThat(pairList.getRight(8)).isEqualTo(9);
        assertThat(pairList.getLeft(9)).isEqualTo("ten");
        assertThat(pairList.getRight(9)).isEqualTo(10);
    }
}