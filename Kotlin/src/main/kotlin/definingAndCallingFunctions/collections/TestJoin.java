package definingAndCallingFunctions.collections;

import java.util.ArrayList;

public class TestJoin {

    public static void main(String[] args) {
        /**
         * Пример вызова топ функции из котлина в джава коде
         */
        String joinTest = CustomJoin.joinToString();

        ArrayList<Integer> list = new ArrayList<>();

        /**
         * Пример вызова функции расширения из котлина в джава коде
         */
        CreatingCollectionsKt.customJoinToString(list);
    }

}
