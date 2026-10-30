package io.github.tau34.handler;

import io.github.tau34.config.ConfigLoader;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class VisionHandler {
    public static void handle(String mes) {
        if (mes.equals("on")) {
            ConfigLoader.CONFIG.nightVision = true;
            ConfigLoader.saveConfig();
        }
        if (mes.equals("off")) {
            ConfigLoader.CONFIG.nightVision = false;
            ConfigLoader.saveConfig();
        }
        if (mes.equals("toggle")) {
            ConfigLoader.CONFIG.nightVision = !ConfigLoader.CONFIG.nightVision;
            ConfigLoader.saveConfig();
        }
    }
}
