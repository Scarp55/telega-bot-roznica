package ru.pivovarov.cstkbotroznica.buttons;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import static ru.pivovarov.cstkbotroznica.buttons.Buttons.setKeyboard;
import static ru.pivovarov.cstkbotroznica.buttons.Buttons.setKeyboardRows;
import static ru.pivovarov.cstkbotroznica.config.BotConfig.NEXT;

public class Regulations {
    public static String buttons(SendMessage sendMessage) {
        int row = 3;
        KeyboardRow[] keyboardRows = setKeyboardRows(sendMessage, row);
        keyboardRows[0].add(new KeyboardButton("Мотивации оплаты труда"));
        keyboardRows[1].add(new KeyboardButton("Калькулятор оплаты труда"));
        keyboardRows[2].add(new KeyboardButton("Вернуться в предыдущее меню"));
        setKeyboard(sendMessage, keyboardRows, row);
        return NEXT;
    }
}
