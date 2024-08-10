package com.github.javarushcommunity.jrtgbot.command;

/**
 * Enumeration for {@link Command}'s.
 */
public enum CommandName {
    STAT("/stat"),
    START("/start"),
    STOP("/stop"),
    NO(""),
    HELP("/help"),
    ADD_GROUP_SUB("/addgroupsub"),
    LIST_GROUP_SUB("/listgroupsub"),
    DELETE_GROUP_SUB("/deletegroupsub"),
    ADMIN_HELP("/ahelp");

    private String commandName="";

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

}