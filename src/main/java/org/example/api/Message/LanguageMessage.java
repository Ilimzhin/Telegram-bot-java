package org.example.api.Message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LanguageMessage {

    public static SendMessage buildChooseLanguageSendMessage(String chatId) {
        var sendMessage = new SendMessage();
        var inlineKeyboardMarkup = new InlineKeyboardMarkup();
        var columnList = new ArrayList<List<InlineKeyboardButton>>();
        columnList.add(
                Arrays.asList(
                        InlineKeyboardButton.builder().callbackData("Russian").text("Russian").build(),
                        InlineKeyboardButton.builder().callbackData("English").text("English").build()
                )
        );
        columnList.add(
                Arrays.asList(
                        InlineKeyboardButton.builder().callbackData("Kyrgyz").text("Kyrgyz").build(),
                        InlineKeyboardButton.builder().callbackData("Ukrain").text("Ukrain").build()
                )
        );
        columnList.add(
                Arrays.asList(
                        InlineKeyboardButton.builder().callbackData("Germany").text("Germany").build(),
                        InlineKeyboardButton.builder().callbackData("Franch").text("Franch").build()
                )
        );
        inlineKeyboardMarkup.setKeyboard(columnList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        sendMessage.setChatId(chatId);
        sendMessage.setText("Choose language: ");
        return sendMessage;
    }
}
