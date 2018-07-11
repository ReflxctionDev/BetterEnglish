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
package net.reflxction.betterenglish.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.reflxction.betterenglish.BetterEnglish;
import net.reflxction.betterenglish.config.ConfigManager;
import net.reflxction.betterenglish.utils.ChatColor;
import net.reflxction.betterenglish.utils.Reference;

import java.io.IOException;


/**
 * GUI opened when "/be config" is ran
 */
public class BetterEnglishGUI extends GuiScreen {

    // Config manager for changing BetterEnglish.getSettings()
    private ConfigManager manager = new ConfigManager();

    // Buttons
    private GuiButton buttonEnabled;
    private GuiButton buttonContractions;
    private GuiButton buttonFullStops;
    private GuiButton buttonCapitalization;

    // Called when the GUI is being drawn, useful for drawing text on the GUI
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        drawString(fontRenderer, Reference.CREDITS,
                width / 2 - fontRenderer.getStringWidth("BetterEnglish by Reflxction") / 2, height - 10, mouseY);
    }

    // Called when buttons are getting added
    @Override
    public void initGui() {
        this.buttonList.clear(); // For safety and memory foaming
        this.buttonList.add(this.buttonEnabled = new GuiButton(1, this.width / 2 - 70, this.height / 2 - 80, 140, 20, "Enabled: " + (BetterEnglish.isEnabled() ? ChatColor.RED + "OFF" : ChatColor.GREEN + "ON")));
        this.buttonList.add(this.buttonContractions = new GuiButton(2, this.width / 2 - 70, this.height / 2 - 58, 140, 20, "Fix contractions: " + (BetterEnglish.getSettings().fixContractions() ? ChatColor.RED + "OFF" : ChatColor.GREEN + "ON")));
        this.buttonList.add(this.buttonFullStops = new GuiButton(3, this.width / 2 - 70, this.height / 2 - 36, 140, 20, "Append full-stops: " + (BetterEnglish.getSettings().appendFullStops() ? ChatColor.RED + "OFF" : ChatColor.GREEN + "ON")));
        this.buttonList.add(this.buttonCapitalization = new GuiButton(4, this.width / 2 - 70, this.height / 2 - 14, 140, 20, "Capitalize text: " + (BetterEnglish.getSettings().capitalization() ? ChatColor.RED + "OFF" : ChatColor.GREEN + "ON")));
        super.initGui();
    }

    // Called when a button is clicked
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case 1:
                manager.setEnabled(!BetterEnglish.isEnabled());
                buttonEnabled.displayString = "Enabled: " + (BetterEnglish.isEnabled() ? ChatColor.RED + "OFF" : ChatColor.GREEN + "ON");
                break;
            case 2:
                manager.setContractions(!BetterEnglish.getSettings().fixContractions());
                buttonContractions.displayString = "Fix contractions: " + (BetterEnglish.getSettings().fixContractions() ? ChatColor.RED + "OFF" : ChatColor.GREEN + "ON");
                break;
            case 3:
                manager.setFullStops(!BetterEnglish.getSettings().appendFullStops());
                buttonFullStops.displayString = "Append full-stops: " + (BetterEnglish.getSettings().appendFullStops() ? ChatColor.RED + "OFF" : ChatColor.GREEN + "ON");
                break;
            case 4:
                manager.setCapitalization(!BetterEnglish.getSettings().capitalization());
                buttonCapitalization.displayString = "Capitalize text: " + (BetterEnglish.getSettings().capitalization() ? ChatColor.RED + "OFF" : ChatColor.GREEN + "ON");
                break;
        }
        super.actionPerformed(button);
    }

    // Whether the GUI should pause the game
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

}
