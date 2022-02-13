package org.example.api;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
//            Message message = update.getMessage();
            case "/start" -> buildStartSendMessage(chatId);
            case "/start2" -> buildStart2SendMessage(chatId);
            case "/help" -> buildHelpSendMessage(chatId);
            case "/help2" -> buildHelp2SendMessage(chatId);
            case "/language" -> buildChooseLanguageSendMessage(chatId);
            default -> throw new RuntimeException(UNSUPPORTED_COMMAND_ERROR_MESSAGE);
        };
        try {
            execute(sendMessage);
//            setButtons(sendMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void sendMsg(Message message, String text) {
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.enableMarkdown(true);
//        sendMessage.setChatId(message.getChatId().toString());
//        sendMessage.setReplyToMessageId(message.getMessageId());
//        sendMessage.setText(text);
//    }
//
//    public void setButtons(SendMessage sendMessage) {
//
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//        sendMessage.setReplyMarkup(replyKeyboardMarkup);
//
//        replyKeyboardMarkup.setSelective(true);
//        replyKeyboardMarkup.setResizeKeyboard(true);
//        replyKeyboardMarkup.setOneTimeKeyboard(false);
//
//        List<KeyboardRow> keyboardRowList = new ArrayList<>();
//        KeyboardRow keyboardFirstRow = new KeyboardRow();
//
//        keyboardFirstRow.add(new KeyboardButton("/start"));
//        keyboardFirstRow.add(new KeyboardButton("/language"));
//
//
//        keyboardRowList.add(keyboardFirstRow);
//        replyKeyboardMarkup.setKeyboard(keyboardRowList);
//    }

    private SendMessage buildHelp2SendMessage(String chatId) {
        SendMessage sendMessage = new SendMessage();
        Message message = new Message();

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("/start"));
        keyboardFirstRow.add(new KeyboardButton("/start2"));
        keyboardFirstRow.add(new KeyboardButton("/language"));
        keyboardFirstRow.add(new KeyboardButton("/help"));
        keyboardFirstRow.add(new KeyboardButton("/help2"));


        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText("some text example");

        return sendMessage;
    }

    private SendMessage buildStart2SendMessage(String chatId) {
        SendMessage sendMessage = new SendMessage();
        Message message = new Message();

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

//        replyKeyboardMarkup.setSelective(true);
//        replyKeyboardMarkup.setResizeKeyboard(true);
//        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
//        List<KeyboardRow> keyboardRowList = new ArrayList<>();

        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("/start"));
//        keyboardFirstRow.add((KeyboardButton) Arrays.asList(
//                InlineKeyboardButton.builder().callbackData("123").text("123").build().getCallbackData(),
//                InlineKeyboardButton.builder().callbackData("123").text("123").build().getCallbackData()));
//                InlineKeyboardButton.builder().callbackData("/language").text("language").build()));
//        keyboardFirstRow.add(String.valueOf(Arrays.asList(new KeyboardButton("/start"),
//                new KeyboardButton("/start2"))));
        keyboardFirstRow.add(new KeyboardButton("/start2"));
        keyboardFirstRow.add(new KeyboardButton("/language"));
        keyboardFirstRow.add(new KeyboardButton("/help"));
        keyboardFirstRow.add(new KeyboardButton("/help2"));


        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText("Main menu: ");

        return sendMessage;
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
