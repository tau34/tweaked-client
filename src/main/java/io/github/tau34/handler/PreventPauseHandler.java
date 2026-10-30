package io.github.tau34.handler;

import io.github.tau34.config.ConfigLoader;

public class PreventPauseHandler {
    public static void handle(String mes) {
        if (mes.equals("on")) {
            ConfigLoader.CONFIG.preventPause = true;
            ConfigLoader.saveConfig();
        }
        if (mes.equals("off")) {
            ConfigLoader.CONFIG.preventPause = false;
            ConfigLoader.saveConfig();
        }
        if (mes.equals("toggle")) {
            ConfigLoader.CONFIG.preventPause = !ConfigLoader.CONFIG.preventPause;
            ConfigLoader.saveConfig();
        }
    }
}
