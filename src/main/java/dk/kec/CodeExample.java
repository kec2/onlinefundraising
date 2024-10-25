package dk.kec;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 The task is to implement this interface following these rules:
 * Mapper takes an arguments of T1 and return the value mapped into T2.
 * If the T2 value is valid then return it.
 * Else return the fall-back value.
 */
public interface CodeExample<T1, T2> {
    T2 returnIfValid(Function<T1, T2> mapper,
                     Predicate<T2> validator,
                     Supplier<T2> fallback
    );
}
