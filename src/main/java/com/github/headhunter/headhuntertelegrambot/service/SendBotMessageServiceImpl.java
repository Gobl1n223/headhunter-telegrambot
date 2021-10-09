package com.github.headhunter.headhuntertelegrambot.service;

import com.github.headhunter.headhuntertelegrambot.bot.HeadHunterTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final HeadHunterTelegramBot headHunterTelegramBot;

    @Autowired
    public SendBotMessageServiceImpl(HeadHunterTelegramBot headHunterTelegramBot) {
        this.headHunterTelegramBot = headHunterTelegramBot;
    }


    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sm = new SendMessage();
        sm.setChatId(chatId);
        sm.enableHtml(true);
        sm.setText(message);

        try {
            headHunterTelegramBot.execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
