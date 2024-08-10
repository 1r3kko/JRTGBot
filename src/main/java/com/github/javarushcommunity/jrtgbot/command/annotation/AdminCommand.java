package com.github.javarushcommunity.jrtgbot.command.annotation;

import com.github.javarushcommunity.jrtgbot.command.Command;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Mark if {@link Command} can be viewed only by admins.
 */
@Retention(RUNTIME)
public @interface AdminCommand {
}
