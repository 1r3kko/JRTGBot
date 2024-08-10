package com.github.javarushcommunity.jrtgbot.bot;

import com.github.javarushcommunity.jrtgbot.command.CommandContainer;
import com.github.javarushcommunity.jrtgbot.javarushclient.JavaRushGroupClient;
import com.github.javarushcommunity.jrtgbot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

import static com.github.javarushcommunity.jrtgbot.command.CommandName.NO;

@Component
public class JavarushTelegramBot extends TelegramLongPollingBot {
    public static String COMMAND_PREFIX = "/";
    private final CommandContainer commandContainer;

    @Value("${bot.username}")
    private String name;

    @Autowired
    public JavarushTelegramBot(@Value("${bot.token}") String botToken, TelegramUserService telegramUserService, JavaRushGroupClient javaRushGroupClient, GroupSubService groupSubService,
                               @Value("#{'${bot.admins}'.split(',')}") List<String> admins, StatisticsService statisticsService) {
        super(botToken);
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this), telegramUserService, javaRushGroupClient, groupSubService, admins, statisticsService);
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.findCommand(commandIdentifier, update.getMessage().getFrom().getUserName()).execute(update);
            } else {
                commandContainer.findCommand(NO.getCommandName(), update.getMessage().getFrom().getUserName()).execute(update);
            }
        }
    }
}