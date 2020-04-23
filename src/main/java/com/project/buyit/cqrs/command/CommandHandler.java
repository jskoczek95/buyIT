package com.project.buyit.cqrs.command;

public interface CommandHandler<C, T> {

    public T handle(C command);

    public boolean isType(C commandType);
}
