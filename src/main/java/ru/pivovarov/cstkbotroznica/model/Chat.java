package ru.pivovarov.cstkbotroznica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    String chatId;
    String inputMsg;
    String previousMsg;
}
