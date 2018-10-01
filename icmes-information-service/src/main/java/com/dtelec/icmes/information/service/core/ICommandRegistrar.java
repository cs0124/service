package com.dtelec.icmes.information.service.core;


@FunctionalInterface
public interface ICommandRegistrar extends AutoCloseable {

    @Override
    default void close() throws Exception {
        cancel();
    }

    boolean cancel();
}