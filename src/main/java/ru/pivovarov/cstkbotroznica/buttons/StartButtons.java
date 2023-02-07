package ru.pivovarov.cstkbotroznica.buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import static ru.pivovarov.cstkbotroznica.config.BotConfig.HELLO_TEXT;

@Component
public class StartButtons extends Buttons {

    public static String buttons(SendMessage sendMessage) {
        int row = 5;
        KeyboardRow[] keyboardRows = setKeyboardRows(sendMessage, row);
        keyboardRows[0].add(new KeyboardButton("Новости"));
        keyboardRows[0].add(new KeyboardButton("Прайсы"));
        keyboardRows[1].add(new KeyboardButton("Акции"));
        keyboardRows[1].add(new KeyboardButton("Регламенты"));
        keyboardRows[2].add(new KeyboardButton("Инструкции"));
        keyboardRows[2].add(new KeyboardButton("Мотивации"));
        keyboardRows[3].add(new KeyboardButton("Кредиты"));
        keyboardRows[3].add(new KeyboardButton("Учебный материал"));
        keyboardRows[4].add(new KeyboardButton("Ваши предложения по улучшению Бота"));
        setKeyboard(sendMessage, keyboardRows, row);
        return HELLO_TEXT;
    }
}
