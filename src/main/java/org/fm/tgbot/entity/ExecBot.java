package org.fm.tgbot.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhufm
 * @Date: 2024-02-20 10:33
 * @Description: 执行命令的机器人
 */
public class ExecBot extends TelegramLongPollingBot {
    public static final Logger logger = LoggerFactory.getLogger(TelegramLongPollingBot.class);
    /**
     * 机器人的token 替换成你的机器人token
     */
    private static final String token = "6798597270:AAGViWdEHNF4ppBjibeXUJVGqioofGp5PPY";
    /**
     * 机器人的用户名
     */
    private static final String username = "小艾";

    public ExecBot() {
        this(new DefaultBotOptions());
    }

    public ExecBot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    /**
     * 接收 文本 消息
     *
     * @param update 更新
     */
    @Override
    public void onUpdateReceived(Update update) {
        //我们检查更新是否有消息，消息是否有文本
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            Long chat_id = update.getMessage().getChatId();
            if (message_text.equals("/start")) {
                sendMsg(update.getMessage().getMessageId(), "启动TG BOT", chat_id);
            } else if (message_text.equals("/help")) {
                sendMsg(update.getMessage().getMessageId(), "查看TG BOT帮助", chat_id);
            } else {
                sendMsg(update.getMessage().getMessageId(), "未知命令", chat_id);
            }
        }
    }


//    /**
//     * 发送 视频
//     *
//     * @param update 更新
//     */
//    @Override
//    public void onUpdateReceived(Update update) {
//        try {
//            //发送url地址视频
////            SendVideo sendVideo = SendVideo.builder().chatId(update.getMessage().getChatId().toString()).
////                    video(new InputFile("https://vdept3.bdstatic.com/mda-qbj5gf4quy3zkzq8/720p/h264/1708401154339728600/mda-qbj5gf4quy3zkzq8.mp4?v_from_s=hkapp-haokan-hbf&auth_key=1708427198-0-0-c1c5747dcdabae743795b0f2caff9500&bcevod_channel=searchbox_feed&pd=1&cr=2&cd=0&pt=3&logid=0398615734&vid=11584722074452064420&klogid=0398615734&abtest=116096_1")).build();
//            // 通过fileId发送telegram服务器上的视频文件
////            SendVideo sendVideo =SendVideo.builder().chatId(update.getMessage().getChatId().toString()).video(new InputFile("12313131")).build();
//            //发送本地视频文件
//            SendVideo sendVideo =SendVideo.builder().chatId(update.getMessage().getChatId().toString()).video(new InputFile(new File("C:\\Users\\Administrator\\Desktop\\mda-qbj5gf4quy3zkzq8.mp4"))).build();
//            execute(sendVideo);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * 发送图片
//     *
//     * @param update 更新
//     */
//    @Override
//    public void onUpdateReceived(Update update) {
//        try {
//            //发送url地址图片
//            SendPhoto sendPhoto = SendPhoto.builder().chatId(update.getMessage().getChatId().toString()).photo(new InputFile("https://joelwublog.com/upload/2022/07/bot-2.png")).build();
//            //通过fileId发送telegram服务器上的图片
//            //SendPhoto sendPhoto = SendPhoto.builder().chatId(update.getMessage().getChatId().toString()).photo(new InputFile("12313131")).build();
//            //发送本地图片
//            //SendPhoto sendPhoto = SendPhoto.builder().chatId(update.getMessage().getChatId().toString()).photo(new InputFile(new File("F:\\bot-1.png"))).build();
//            execute(sendPhoto);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 分享电话以及位置
     *
     * @param update 更新
     */
//    @Override
//    public void onUpdateReceived(Update update) {
//        try {
//            List<KeyboardRow> list = new ArrayList<>();
//            KeyboardRow keyboardRow = new KeyboardRow();
//            KeyboardButton keyboardButton1 = KeyboardButton.builder().text("分享电话").requestContact(true).build();
//            KeyboardButton keyboardButton2 = KeyboardButton.builder().text("分享位置").requestLocation(true).build();
//            keyboardRow.add(keyboardButton1);
//            keyboardRow.add(keyboardButton2);
//            list.add(keyboardRow);
//            ReplyKeyboardMarkup keyboardMarkup = ReplyKeyboardMarkup.builder().keyboardRow(keyboardRow).oneTimeKeyboard(true).build();
//            execute(SendMessage.builder().chatId(update.getMessage().getChatId().toString()).text("点击下面按钮分享电话以及位置").replyMarkup(keyboardMarkup).build());
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * 跳转链接
//     *
//     * @param update 更新
//     */
//    @Override
//    public void onUpdateReceived(Update update) {
//        try {
//        SendMessage message = SendMessage.builder()
//                .text("点击可以跳到我的博客：[joelwublog](https://www.joelwublog.com)")
//                .chatId(update.getMessage().getChatId().toString())
//                .parseMode("MarkdownV2")//设置为MarkdownV2语法
//                //.parseMode("HTML")//设置为html语法
//                .build();
//        execute(message);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }


//    /**
//     * 键盘
//     *
//     * @param update
//     */
//    @Override
//    public void onUpdateReceived(Update update) {
//        if (update.getCallbackQuery().getData().equals("opt1")) {
//            try {
//                KeyboardButton button1 = KeyboardButton.builder().text("1").build();
//                KeyboardButton button2 = KeyboardButton.builder().text("2").build();
//                KeyboardButton button3 = KeyboardButton.builder().text("3").build();
//                KeyboardButton button4 = KeyboardButton.builder().text("4").build();
//                KeyboardRow keyboardRow1 = new KeyboardRow();
//                KeyboardRow keyboardRow2 = new KeyboardRow();
//                keyboardRow1.add(button1);
//                keyboardRow1.add(button2);
//                keyboardRow2.add(button3);
//                keyboardRow2.add(button4);
//                List<KeyboardRow> keyboardRows = new ArrayList<>();
//                Collections.addAll(keyboardRows, keyboardRow1, keyboardRow2);
//                ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder().keyboard(keyboardRows).build();
//                SendMessage message = SendMessage.builder().replyMarkup(replyKeyboardMarkup).text("你选择了A").chatId(update.getCallbackQuery().getFrom().getId().toString()).build();
//                execute(message);
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    /**
     * 常用的功能
     * 内联菜单
     * @param update 更新
     */
//    @Override
//    public void onUpdateReceived(Update update) {
//        InlineKeyboardButton button1 = InlineKeyboardButton.builder().text("A").callbackData("opt1").build();
//        InlineKeyboardButton button2 = InlineKeyboardButton.builder().text("B").callbackData("opt2").build();
//        InlineKeyboardButton button3 = InlineKeyboardButton.builder().text("C").callbackData("opt3").build();
//        InlineKeyboardButton button4 = InlineKeyboardButton.builder().text("D").callbackData("opt4").build();
//        List<InlineKeyboardButton> list1 = new ArrayList<>();
//        List<InlineKeyboardButton> list2 = new ArrayList<>();
//        List<InlineKeyboardButton> list3 = new ArrayList<>();
//        List<InlineKeyboardButton> list4 = new ArrayList<>();
//        list1.add(button1);
//        list2.add(button2);
//        list3.add(button3);
//        list4.add(button4);
//        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
//        Collections.addAll(rowList, list1, list2, list3, list4);
//        InlineKeyboardMarkup inlineKeyboardMarkup = InlineKeyboardMarkup.builder().keyboard(rowList).build();
//
//        SendMessage message = SendMessage.builder()
//                .text("请选择一个选项!")
//                .chatId(update.getMessage().getChatId().toString())
//                .replyMarkup(inlineKeyboardMarkup)
//                .build();
//        try {
//            execute(message);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }


    /**
     * 注册命令 注册机器人菜单
     */
    public void registerCommands() {
        List<BotCommand> commands = Arrays.asList(
                new BotCommand("/start", "启动TG BOT"),
                new BotCommand("/help", "查看TG BOT简介"));
        SetMyCommands setMyCommands = new SetMyCommands();
        setMyCommands.setCommands(commands);
        try {
            execute(setMyCommands);
        } catch (TelegramApiException e) {
            logger.error("tg 机器人注册菜单失败", e);
        }
    }

    /**
     * 回复普通文本消息
     *
     * @param text   消息内容
     * @param chatId 用户ID
     */
    private void sendMsg(Integer messageId, String text, Long chatId) {
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(chatId));
        response.setText(text);
        response.setReplyToMessageId(messageId);
        try {
            execute(response);
        } catch (TelegramApiException e) {
            logger.error("tg 机器人发送消息失败, text: {}, chatId: {}", text, chatId, e);
        }
    }

}