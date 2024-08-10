package com.github.javarushcommunity.jrtgbot;

import com.github.javarushcommunity.jrtgbot.command.Command;
import com.github.javarushcommunity.jrtgbot.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.javarushcommunity.jrtgbot.command.CommandName.NO;
import static com.github.javarushcommunity.jrtgbot.command.NoCommand.NO_MESSAGE;

@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}