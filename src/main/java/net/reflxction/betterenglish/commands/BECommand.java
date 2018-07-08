/*
 * * Copyright 2018 github.com/ReflxctionDev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.reflxction.betterenglish.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.reflxction.betterenglish.BetterEnglish;
import net.reflxction.betterenglish.utils.ChatColor;
import net.reflxction.betterenglish.utils.ConfigManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which handles command input for "/be" and "/betterenglish"
 */
public class BECommand implements ICommand {

    private ConfigManager config = new ConfigManager();

    @Override
    public String getName() {
        return "betterenglish";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/betterenglish <toggle>";
    }

    @Override
    public List<String> getAliases() {
        List<String> aliases = new ArrayList<>();
        aliases.add("be");
        return aliases;
    }


    @Override
    public void execute(MinecraftServer server, ICommandSender executor, String[] args) throws CommandException {
        switch (args.length) {
            case 0:
                sendMessage("&cIncorrect command usage. Try " + getUsage(executor));
                break;
            case 1:
                if (args[0].equalsIgnoreCase("toggle")) {
                    config.setEnabled(!BetterEnglish.isEnabled());
                }
        }
    }

    /**
     * Check if the given ICommandSender has permission to execute this command
     *
     * @param server Server instance
     * @param sender Command sender
     */
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    /**
     * Get a list of options for when the user presses the TAB key
     *
     * @param server    Server instance
     * @param sender    Command sender
     * @param args      Extra arguments
     * @param targetPos Player position
     */
    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
        List<String> tabs = new ArrayList<>();
        tabs.add("betterenglish");
        tabs.add("be");
        return tabs;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return true;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }

    /**
     * Sends a message to the client, chat-formatted
     *
     * @param message Message to send
     */
    private void sendMessage(String message) {
        if (Minecraft.getMinecraft().player != null) { // For safety :>
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(ChatColor.format(message)));
        }
    }

}
