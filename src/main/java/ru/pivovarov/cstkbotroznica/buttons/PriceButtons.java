package ru.pivovarov.cstkbotroznica.buttons;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import static ru.pivovarov.cstkbotroznica.buttons.Buttons.setKeyboard;
import static ru.pivovarov.cstkbotroznica.buttons.Buttons.setKeyboardRows;
import static ru.pivovarov.cstkbotroznica.config.BotConfig.NEXT;

public class PriceButtons {
    public static String buttons(SendMessage sendMessage) {
        int row = 3;
        KeyboardRow[] keyboardRows = setKeyboardRows(sendMessage, row);
        keyboardRows[0].add(new KeyboardButton("Услуги шиномонтажа"));
        keyboardRows[1].add(new KeyboardButton("Услуги по правке дисков"));
        keyboardRows[2].add(new KeyboardButton("Вернуться в предыдущее меню"));
        setKeyboard(sendMessage, keyboardRows, row);
        return NEXT;
    }
}
