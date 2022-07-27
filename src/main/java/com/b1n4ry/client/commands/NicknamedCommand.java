package com.b1n4ry.client.commands;

import com.b1n4ry.client.NicknamedClient;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.MessageType;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.string;
import static net.fabricmc.fabric.api.client.command.v1.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v1.ClientCommandManager.literal;


public class NicknamedCommand {
    static MinecraftClient mc = MinecraftClient.getInstance();
    public static void register() {
        ClientCommandManager.DISPATCHER.register(literal("nicknamed")
                .then(literal("change").then(argument("nickname", string()).executes(ctx -> run(getString(ctx, "nickname")))))
                .then(literal("empty").executes(ctx -> run("      ")))
                .then(literal("on").executes(ctx -> enable(true)))
                .then(literal("off").executes(ctx -> enable(false)))
        );
    }

    private static int run(String text) {
        NicknamedClient.setNick(text);
        mc.inGameHud.addChatMessage(MessageType.SYSTEM, Text.of("[Nicknamed] Changed all nicknames to \"" + text + "\""), mc.player.getUuid());
        return 1;
    }

    private static int enable(boolean enabled) {
        NicknamedClient.setEnabled(enabled);
        if (enabled) mc.inGameHud.addChatMessage(MessageType.SYSTEM, Text.of("[Nicknamed] Mod enabled"), mc.player.getUuid());
        else mc.inGameHud.addChatMessage(MessageType.SYSTEM, Text.of("[Nicknamed] Mod disabled"), mc.player.getUuid());
        return 1;
    }
}
