package io.github.tau34.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigLoader {
    public static TCConfig CONFIG;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static File file;

    public static void loadConfig() {
        file = FabricLoader.getInstance().getConfigDir().resolve("tweaked-client.json").toFile();

        if (!file.exists()) {
            CONFIG = new TCConfig();
            saveConfig();
        } else {
            try (FileReader reader = new FileReader(file)) {
                CONFIG = GSON.fromJson(reader, TCConfig.class);
            } catch (IOException e) {
                e.printStackTrace();
                CONFIG = new TCConfig();
            }
        }
    }

    public static void saveConfig() {
        try (FileWriter writer = new FileWriter(file)) {
            GSON.toJson(CONFIG, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
