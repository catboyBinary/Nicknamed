package com.b1n4ry.client;

import com.b1n4ry.client.commands.NicknamedCommand;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v1.*;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.impl.command.client.ClientCommandInternals;
import net.fabricmc.fabric.impl.registry.sync.FabricRegistryClientInit;
import net.minecraft.client.MinecraftClient;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class NicknamedClient implements ClientModInitializer {
    public static String nick = "b1n4ry";
    public static boolean enabled = true;

    public static void setNick(String nick) {
        NicknamedClient.nick = nick;
    }

    public static String getNick() {
        return nick;
    }

    public static void setEnabled(boolean enabled) {
        NicknamedClient.enabled = enabled;
    }

    public static boolean isEnabled() {
        return enabled;
    }

    @Override
    public void onInitializeClient() {
        NicknamedCommand.register();
    }
}
