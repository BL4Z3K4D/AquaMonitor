package com.aquamonitor.platform.u202312348.shared.application;

import java.util.function.Function;

/** Represents a successful application result or a message-key failure. @author Yazid Said */
public sealed interface Result<T> permits Result.Success, Result.Failure {
    <R> R fold(Function<? super T, ? extends R> onSuccess, Function<String, ? extends R> onFailure);

    /** Successful application result. */
    record Success<T>(T value) implements Result<T> {
        @Override
        public <R> R fold(Function<? super T, ? extends R> onSuccess, Function<String, ? extends R> onFailure) {
            return onSuccess.apply(value);
        }
    }

    /** Failed application result, identified by a localization message key. */
    record Failure<T>(String messageKey) implements Result<T> {
        @Override
        public <R> R fold(Function<? super T, ? extends R> onSuccess, Function<String, ? extends R> onFailure) {
            return onFailure.apply(messageKey);
        }
    }
}
