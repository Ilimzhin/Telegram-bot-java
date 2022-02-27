package org.example.api.Message;

import org.example.api.MyTestBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartMessage extends MyTestBot {

    public static SendMessage buildStartSendMessage(String chatId) {
        var sendMessage = new SendMessage();
        var inlineKeyboardMarkup = new InlineKeyboardMarkup();
        var columnList = new ArrayList<List<InlineKeyboardButton>>();
//        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
//        inlineKeyboardButton1.setText("Language");
//        inlineKeyboardButton1.setCallbackData("/language");
//        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
//        keyboardButtonsRow1.add(inlineKeyboardButton1);
//        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
//        rowList.add(keyboardButtonsRow1);
//        inlineKeyboardMarkup.setKeyboard(rowList);
        columnList.add(
                Arrays.asList(
                        InlineKeyboardButton.builder().callbackData("/language").text("language").build()
                )
        );
        columnList.add(
                Arrays.asList(
                        InlineKeyboardButton.builder().callbackData("help").text("Help").build()
                )
        );
        columnList.add(
                Arrays.asList(
                        InlineKeyboardButton.builder().callbackData("Photo").text("Photo").build()
                )
        );
        inlineKeyboardMarkup.setKeyboard(columnList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        sendMessage.setChatId(chatId);
        sendMessage.setText("Main menu: ");
        return sendMessage;
    }
}
