package org.example.api;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTestBot extends TelegramLongPollingBot {


    private static final String TOKEN = "1902343382:AAH-9WJsU26dge0ag2ziFgNj2i8MsefRBA0";
    private static final String USERNAME = "LearnTaskBot";


    private static final String UNSUPPORTED_COMMAND_ERROR_MESSAGE = "Soryan no idite na hui servis ne dostupen chego blyat ne ponyatogo idi mamke svoei skafni dushniila ebannaya";

    public String getBotToken() {
        return TOKEN;
    }

    public String getBotUsername() {
        return USERNAME;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            handleMessage(update);
        }
//        else if (update.getCallbackQuery() != null && update.getCallbackQuery().getMessage().hasText()) {
//            handleCallback(update.getCallbackQuery());
//        }
    }


//    @SneakyThrows
//    private void handleCallback(CallbackQuery callbackQuery) {
//        final var chatId = callbackQuery.getMessage().getChatId();
//
//        final var sendMessage = switch (callbackQuery.getMessage().getMessageId().toString()) {
////            case "/help" -> buildHelpSendMessage(chatId);
//            case "/start" -> buildStartSendMessage(chatId);
//            default -> throw new RuntimeException(UNSUPPORTED_COMMAND_ERROR_MESSAGE);
//        };
//        try {
//            execute(sendMessage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    private void handleMessage(Update update) {
        final var chatId = update.getMessage().getChatId().toString();
//        final var chatId1 = update.getCallbackQuery().getMessage().getChatId();


        final var sendMessage = switch (update.getMessage().getText()) {
            case "/start" -> buildStartSendMessage(chatId);
            case "/help" -> buildHelpSendMessage(chatId);
            case "/language" -> buildChooseLanguageSendMessage(chatId);
            default -> throw new RuntimeException(UNSUPPORTED_COMMAND_ERROR_MESSAGE);
        };
        try {
            execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private SendMessage buildStartSendMessage(String chatId) {
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

    private SendMessage buildHelpSendMessage(String chatId) {
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

    private SendMessage buildChooseLanguageSendMessage(String chatId) {
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
