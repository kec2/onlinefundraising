package dk.kec;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CodeInterview<T1, T2> implements CodeExample<T1, T2> {

    T1 input;

    @Override
    public T2 returnIfValid(Function<T1, T2> mapper, Predicate<T2> validator, Supplier<T2> fallback) {
        T2 applied = mapper.apply(getInput());
        if (validator.test(applied)) {
            return applied;
        }
        return fallback.get();
    }

    public void setInput(T1 input) {
        this.input = input;
    }

    public T1 getInput() {
        return input;
    }

    public static void main(String[] args) {
        CodeInterview<Integer, String> codeInterview = new CodeInterview<>();
        codeInterview.setInput(null);

        // Define the mapper, validator, and fallback
        Function<Integer, String> mapper = input -> input != null ? String.valueOf(input) : null;
        Predicate<String> validator = Objects::nonNull;
        Supplier<String> fallback = () -> "Fallback value";

        String mappedValue = codeInterview.returnIfValid(mapper, validator, fallback);
        System.out.println(mappedValue);
    }
}
