package io.github.tau34.handler;

import java.util.function.Consumer;

public enum TCHandlers {
    OUTLINE("outline", OutlineHandler::handle),
    VISION("vision", VisionHandler::handle),
    PREVENT_PAUSE("prevent-pause", PreventPauseHandler::handle),
    PLAYER_TAG("player-tag", PlayerTagHandler::handle);

    private final Consumer<String> handler;
    private final String name;

    TCHandlers(String name, Consumer<String> handler) {
        this.name = name;
        this.handler = handler;
    }

    public static void handleAll(String mes) {
        for (TCHandlers value : values()) {
            String head = "! " + value.name + " ";
            if (mes.startsWith(head)) {
                value.handler.accept(mes.substring(head.length()));
            }
        }
    }
}
