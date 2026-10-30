package io.github.tau34;

import io.github.tau34.config.ConfigLoader;
import io.github.tau34.handler.TCHandlers;
import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;

public class TweakedClientMod implements ClientModInitializer {
	private boolean isPausePreventing = false;

	@Override
	public void onInitializeClient() {
		ConfigLoader.loadConfig();
		ClientSendMessageEvents.ALLOW_CHAT.register((message) -> {
			if (message.startsWith("!")) {
				TCHandlers.handleAll(message);
				return false;
			} else {
				return true;
			}
		});

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			boolean shouldPrevent = ConfigLoader.CONFIG.preventPause;
			if (shouldPrevent != isPausePreventing) {
				if (client.options != null) {
					client.options.pauseOnLostFocus = !shouldPrevent;
					isPausePreventing = shouldPrevent;
				}
			}
		});
	}
}
