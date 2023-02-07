package ru.pivovarov.cstkbotroznica.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class BotConfig {

    @Value("${bot.nameTest}")
    String botName;

    @Value("${bot.tokenTest}")
    String botToken;

    public static final String HELLO_TEXT = "Привет\n" +
            "Это библиотека по услугам.\n" +
            "Здесь ты сможешь найти учебный материал, актуальные акции, дайджест, памятки и инструкции по установке или решению проблем.\n" +
            "Я пока наполняюсь знаниями и если тебе нужна какая-то информация то напиши мне и я добавлю её в нужный раздел.";
    public static final String NEXT = "Дальше";
    public static final String ERROR_TEXT = "Данная команда отсутствует, выбери другую или введи /start";
    public static final String GO_BACK = "Вернуться в предыдущее меню";
}
