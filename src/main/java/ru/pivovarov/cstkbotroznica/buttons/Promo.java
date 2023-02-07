package ru.pivovarov.cstkbotroznica.buttons;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import static ru.pivovarov.cstkbotroznica.buttons.Buttons.setKeyboard;
import static ru.pivovarov.cstkbotroznica.buttons.Buttons.setKeyboardRows;
import static ru.pivovarov.cstkbotroznica.config.BotConfig.NEXT;

public class Promo {
    public static String buttons(SendMessage sendMessage) {
        int row = 4;
        KeyboardRow[] keyboardRows = setKeyboardRows(sendMessage, row);
        keyboardRows[0].add(new KeyboardButton("Шины со скидкой"));
        keyboardRows[0].add(new KeyboardButton("Диски со скидкой"));
        keyboardRows[1].add(new KeyboardButton("Услуги со скидкой"));
        keyboardRows[1].add(new KeyboardButton("Гарантия производителя"));
        keyboardRows[2].add(new KeyboardButton("Бесплатный шиномонтаж от производителя"));
        keyboardRows[3].add(new KeyboardButton("Вернуться в предыдущее меню"));
        setKeyboard(sendMessage, keyboardRows, row);
        return NEXT;
    }
}
