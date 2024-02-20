package org.fm.tgbot;

import org.fm.tgbot.entity.ExecBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * @Author: zhufm
 * @Date: 2024-02-20 10:00
 * @Description: 机器人启动类
 */
@SpringBootApplication
public class TgBotDemoApplication {
    public static final Logger logger = LoggerFactory.getLogger(TgBotDemoApplication.class);

    public static void main(String[] args) {
        DefaultBotOptions botOptions = new DefaultBotOptions();
        // 设置代理  vpn 在本地不需要设置
//        botOptions.setProxyHost("127.0.0.1");
//        botOptions.setProxyPort(1080);

        // 注意一下这里，ProxyType是个枚举，看源码你就知道有NO_PROXY,HTTP,SOCKS4,SOCKS5;
        botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);

        DefaultBotSession defaultBotSession = new DefaultBotSession();
        defaultBotSession.setOptions(botOptions);
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(defaultBotSession.getClass());
//            //需要代理
//            ExecBot bot = new ExecBot(botOptions);
//            telegramBotsApi.registerBot(bot);

            // 不需代理
            ExecBot bot1 = new ExecBot();
            // 注册菜单 如果已设置 可以取消
//            bot1.registerCommands();
            telegramBotsApi.registerBot(bot1);
        } catch (TelegramApiException e) {
            logger.error("注册机器人失败", e);
        }

        SpringApplication.run(TgBotDemoApplication.class, args);
        System.out.println("TgBotDemoApplication 启动成功！");
    }
}
