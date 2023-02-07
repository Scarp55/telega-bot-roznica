package ru.pivovarov.cstkbotroznica.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.pivovarov.cstkbotroznica.buttons.*;
import ru.pivovarov.cstkbotroznica.config.BotConfig;
import ru.pivovarov.cstkbotroznica.model.Chat;

import java.util.HashMap;

import static ru.pivovarov.cstkbotroznica.config.BotConfig.ERROR_TEXT;


@Component
@AllArgsConstructor
public class BotService extends TelegramLongPollingBot {

    HashMap<String, Chat> chats;

    final BotConfig config;

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }


    @Override
    public void onUpdateReceived(Update update) {

        String chatId = update.getMessage().getChatId().toString();
        String inputMsg = update.getMessage().getText();
        if (!chats.containsKey(chatId)) {
            chats.put(chatId, new Chat(chatId, inputMsg, "/start"));
        }

        Chat chat = chats.get(chatId);
        chat.setInputMsg(inputMsg);

        SendMessage sendMessage = new SendMessage();

        String sendText;

        String msg;

        if (chat.getInputMsg().equals("Вернуться в предыдущее меню")){
            msg = chat.getPreviousMsg();
        } else {
            msg = chat.getInputMsg();
        }

        switch (msg) {
            case "/start" -> {
                sendText = StartButtons.buttons(sendMessage);
                chat.setPreviousMsg("/start");
            }
            case "Новости" -> {
                sendText = "Новости";
                chat.setPreviousMsg("/start");
            }
            case "Прайсы" -> {
                sendText = PriceButtons.buttons(sendMessage);
                chat.setPreviousMsg("/start");
            }
            case "Акции" -> {
                sendText = Promo.buttons(sendMessage);
                chat.setPreviousMsg("/start");
            }
            case "Регламенты" -> {
                sendText = Regulations.buttons(sendMessage);
                chat.setPreviousMsg("/start");
            }
            case "Инструкции" -> {
                sendText = Instructions.buttons(sendMessage);
                chat.setPreviousMsg("/start");
            }
            case "Мотивации" -> {
                sendText = Motivations.buttons(sendMessage);
                chat.setPreviousMsg("/start");
            }
            case "Кредиты" -> {
                sendText = Credits.buttons(sendMessage);
                chat.setPreviousMsg("/start");
            }
            case "Учебный материал" -> {
                sendText = Tutorial.buttons(sendMessage);
                chat.setPreviousMsg("/start");
            }
            case "Ваши предложения по улучшению Бота" -> {
                sendText = "Ваши предложения и пожелания";
                chat.setPreviousMsg("/start");
            }
            default -> sendText = ERROR_TEXT;
        }

        sendMessage.setChatId(chat.getChatId());
        sendMessage.setProtectContent(true);
        sendMessage.setText(sendText);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
