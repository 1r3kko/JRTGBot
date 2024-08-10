package com.github.javarushcommunity.jrtgbot.command;

import com.github.javarushcommunity.jrtgbot.service.SendBotMessageService;
import com.github.javarushcommunity.jrtgbot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Stop {@link Command}.
 */
public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STOP_MESSAGE = "Деактивировал все ваши подписки \uD83D\uDE1F.";

    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), STOP_MESSAGE);
        telegramUserService.findByChatId(update.getMessage().getChatId())
                .ifPresent(it -> {
                    it.setActive(false);
                    telegramUserService.save(it);
                });
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), STOP_MESSAGE);
    }
}