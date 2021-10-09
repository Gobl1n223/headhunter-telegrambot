package com.github.headhunter.headhuntertelegrambot.command;

import com.github.headhunter.headhuntertelegrambot.service.SendBotMessageService;
import com.github.headhunter.headhuntertelegrambot.service.SendBotMessageServiceImpl;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    private final String START_MESSAGE = "Привет я HeadHunter Bot. Я помогу тебе с удобным поиком работы. " +
            "Ты сможешь быстро отправлять своё резюме в компании, с поиском Java Developer(test)";
    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
