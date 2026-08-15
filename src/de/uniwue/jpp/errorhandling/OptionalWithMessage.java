package de.uniwue.jpp.errorhandling;

import java.util.ArrayList;
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
        if(val == null) throw new NullPointerException();
        return new OptionalWithMessageVal<T>(val, null);
    }

    static <T> OptionalWithMessage<T> ofMsg(String msg) {
        if (msg == null) throw new NullPointerException();
        return new OptionalWithMessageMsg<T>(msg);
    }

    static <T> OptionalWithMessage<T> ofNullable(T val, String msg) {
        if (msg==null) throw new NullPointerException();
        if(val==null) return new OptionalWithMessageMsg<T>(msg);
        return new OptionalWithMessageVal<T>(val, msg);
    }

    static <T> OptionalWithMessage<T> ofOptional(Optional<T> opt, String msg) {
        if (opt== null || msg ==null) throw new NullPointerException();
        if(opt.isEmpty()) return new OptionalWithMessageMsg<T>(msg);
        return new OptionalWithMessageVal<>(opt.get(), msg);
    }

    static <T> OptionalWithMessage<List<T>> sequence(List<OptionalWithMessage<T>> list) {
        List<T> val = new ArrayList<>();
        List<String> mes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isEmpty()){
                mes.add(list.get(i).getMessage());
            }else {
                val.add(list.get(i).get());
            }
        }
        if (mes.isEmpty()){
            return new OptionalWithMessageVal<List<T>>(val, null);
        }else {
            String erro = mes.get(0);
            for (int i = 1; i < mes.size() ; i++) {
               erro = erro + System.lineSeparator() + mes.get(i);
            }
            return new OptionalWithMessageMsg<List<T>>(erro);
        }
    }
}
