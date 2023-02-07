package ru.pivovarov.cstkbotroznica.buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Buttons {
    static KeyboardRow[] setKeyboardRows(SendMessage sendMessage, int row) {

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        KeyboardRow[] keyboardRows = new KeyboardRow[row];
        for (int i = 0; i < row; i++) {
            keyboardRows[i] = new KeyboardRow();
        }

        return keyboardRows;
    }

    static void setKeyboard(SendMessage sendMessage, KeyboardRow[] keyboardRows, int row) {

        List<KeyboardRow> keyboard = new ArrayList<>(row);
        keyboard.addAll(Arrays.asList(keyboardRows).subList(0, row));
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }
}
