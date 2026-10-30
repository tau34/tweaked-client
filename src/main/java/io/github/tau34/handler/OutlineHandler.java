package io.github.tau34.handler;

import io.github.tau34.config.ConfigLoader;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class OutlineHandler {
    public static void handle(String mes) {
        if (mes.startsWith("add ")) {
            String[] targets = Arrays.stream(mes.substring(4).split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toArray(String[]::new);

            Set<String> set = new LinkedHashSet<>();
            Collections.addAll(set, ConfigLoader.CONFIG.outlineEntities);
            Collections.addAll(set, targets);

            ConfigLoader.CONFIG.outlineEntities = set.toArray(new String[0]);
            ConfigLoader.saveConfig();
        }
        if (mes.startsWith("remove ")) {
            String str = mes.substring(7);
            if (str.equals("*")) {
                ConfigLoader.CONFIG.outlineEntities = new String[0];
                ConfigLoader.saveConfig();
                return;
            }

            String[] targets = Arrays.stream(str.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toArray(String[]::new);

            Set<String> set = new LinkedHashSet<>();
            Collections.addAll(set, ConfigLoader.CONFIG.outlineEntities);
            for (String target : targets) {
                set.remove(target);
            }

            ConfigLoader.CONFIG.outlineEntities = set.toArray(new String[0]);
            ConfigLoader.saveConfig();
        }
    }
}
