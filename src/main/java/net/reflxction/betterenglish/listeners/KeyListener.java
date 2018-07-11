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
package net.reflxction.betterenglish.listeners;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiTextField;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.reflxction.betterenglish.BetterEnglish;
import net.reflxction.betterenglish.grammar.GrammarBuilder;
import net.reflxction.betterenglish.utils.ReflectUtils;

/**
 * Listener which listens to characters written in the chat box
 */
@SuppressWarnings("ConstantConditions")
public class KeyListener {

    @SubscribeEvent
    public void onTickClientTick(ClientTickEvent event) {
        if (BetterEnglish.isEnabled()) {
            try {
                if (FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {
                    if (check(ReflectUtils.getMainTextField())) {
                        final GuiTextField field = ReflectUtils.getMainTextField();
                        String text = field.getText();
                        GrammarBuilder builder = new GrammarBuilder(text);
                        text = builder
                                .capitalize(BetterEnglish.getSettings().capitalization())
                                .fixContractions(BetterEnglish.getSettings().fixContractions())
                                .getText();
                        ReflectUtils.getMainTextField().setText(text);
                    }
                }
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private boolean check(GuiTextField field) {
        return
                // If the text field is available (for safety)
                field != null &&
                        // There is text inside it
                        !field.getText().isEmpty();
    }
}
