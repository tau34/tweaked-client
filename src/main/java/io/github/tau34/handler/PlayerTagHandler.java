package io.github.tau34.handler;

import io.github.tau34.config.ConfigLoader;

public class PlayerTagHandler {
    public static void handle(String mes) {
        if (mes.equals("on")) {
            ConfigLoader.CONFIG.playerTag = true;
            ConfigLoader.saveConfig();
        }
        if (mes.equals("off")) {
            ConfigLoader.CONFIG.playerTag = false;
            ConfigLoader.saveConfig();
        }
        if (mes.equals("toggle")) {
            ConfigLoader.CONFIG.playerTag = !ConfigLoader.CONFIG.playerTag;
            ConfigLoader.saveConfig();
        }
    }
}
