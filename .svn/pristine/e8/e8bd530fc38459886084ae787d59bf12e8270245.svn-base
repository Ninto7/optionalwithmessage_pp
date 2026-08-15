package de.uniwue.jpp.errorhandling;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface OptionalWithMessage<T> {

    boolean isPresent();
    boolean isEmpty();
    T get();
    T orElse(T def);
    T orElseGet(Supplier<? extends T> supplier);
    String getMessage();
    <S> OptionalWithMessage<S> map(Function<T, S> f);
    <S> OptionalWithMessage<S> flatMap(Function<T, OptionalWithMessage<S>> f);
    Optional<String> consume(Consumer<T> c);
    Optional<String> tryToConsume(Function<T, Optional<String>> c);

    static <T> OptionalWithMessage<T> of(T val) {
        throw new UnsupportedOperationException();
    }

    static <T> OptionalWithMessage<T> ofMsg(String msg) {
        throw new UnsupportedOperationException();
    }

    static <T> OptionalWithMessage<T> ofNullable(T val, String msg) {
        throw new UnsupportedOperationException();
    }

    static <T> OptionalWithMessage<T> ofOptional(Optional<T> opt, String msg) {
        throw new UnsupportedOperationException();
    }

    static <T> OptionalWithMessage<List<T>> sequence(List<OptionalWithMessage<T>> list) {
        throw new UnsupportedOperationException();
    }
}
