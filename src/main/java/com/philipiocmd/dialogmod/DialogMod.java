package com.philipiocmd.dialogmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DialogMod implements ModInitializer {
    public static final String MOD_ID = "dialogmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing DialogMod");
        registerCommands();
    }

    private void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("dialog")
                .executes(context -> {
                    context.getSource().sendFeedback(() -> Text.literal("Dialog command executed"), false);
                    return 1;
                })
            );
        });
    }
}