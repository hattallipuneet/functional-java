package java8default;

public interface Sail {

    default void cruise() {
        System.out.println("FastFly::cruise");
    }

    default void turn() {
        System.out.println("FastFly::turn");
    }
}
