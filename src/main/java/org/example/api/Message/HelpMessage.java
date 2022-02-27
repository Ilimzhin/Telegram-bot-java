package org.example.api.Message;

import org.example.api.MyTestBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelpMessage extends MyTestBot {

    public static SendMessage buildHelpSendMessage(String chatId) {
//        var sendPhoto = new SendPhoto();
        var sendMessage = new SendMessage();
        var inlineKeyboardMarkup = new InlineKeyboardMarkup();
        var columnList = new ArrayList<List<InlineKeyboardButton>>();
        columnList.add(
                Arrays.asList(
                        InlineKeyboardButton.builder().callbackData("/language").text("language").build(),
                        InlineKeyboardButton.builder().callbackData("Back").text("Back").build()
                )
        );
        columnList.add(
                Arrays.asList(
                        InlineKeyboardButton.builder().callbackData("Main").text("Example 1").build()
                )
        );
        inlineKeyboardMarkup.setKeyboard(columnList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        sendMessage.setChatId(chatId);
        sendMessage.setText("dlinnyi tekst dlya proverki pravilnosti ispol'zovanii teksta условия");
        return sendMessage;
    }
//
//        var sendPhoto = new SendPhoto();
//        var inlineKeyboardMarkup = new InlineKeyboardMarkup();
//        var columnList = new ArrayList<List<InlineKeyboardButton>>();
//        columnList.add(
//                Arrays.asList(
//                        InlineKeyboardButton.builder().callbackData("/language").text("language").build(),
//                        InlineKeyboardButton.builder().callbackData("Back").text("Back").build()
//                )
//        );
//        columnList.add(
//                Arrays.asList(
//                        InlineKeyboardButton.builder().callbackData("Main").text("Example 1").build()
//                )
//        );
//        inlineKeyboardMarkup.setKeyboard(columnList);
//        sendPhoto.setCaption("dlinnyi tekst dlya proverki pravilnosti ispol'zovanii teksta условия");
//        sendPhoto.setChatId(chatId);
//        sendPhoto.setPhoto("https://i.pinimg.com/736x/f1/87/05/f18705f9e9f219646401451aa53efcdc.jpg");
//        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
//
//        return sendPhoto;
//    }
}
