package com.philipiocmd.dialogmod.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class DialogCommand implements Command<ServerCommandSource> {
    @Override
    public int run(CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(() -> Text.literal("Dialog command executed"), false);
        return 1;
    }
}