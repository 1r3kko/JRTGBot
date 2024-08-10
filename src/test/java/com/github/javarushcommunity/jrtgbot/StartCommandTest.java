package com.github.javarushcommunity.jrtgbot;

import com.github.javarushcommunity.jrtgbot.command.Command;
import com.github.javarushcommunity.jrtgbot.command.StartCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.javarushcommunity.jrtgbot.command.CommandName.START;
import static com.github.javarushcommunity.jrtgbot.command.StartCommand.START_MESSAGE;

@DisplayName("Unit-level testing for StartCommand")
class StartCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService, telegramUserService);
    }
}