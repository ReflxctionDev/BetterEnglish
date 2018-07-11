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

import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.reflxction.betterenglish.BetterEnglish;
import net.reflxction.betterenglish.grammar.GrammarBuilder;

/**
 * Class which handles appending the full-stop BEFORE sending a message
 */
public class FullStopListener {

    @SubscribeEvent
    public void onClientChat(ClientChatEvent event) {
        if(BetterEnglish.isEnabled()) {
            GrammarBuilder builder = new GrammarBuilder(event.getOriginalMessage())
                    .appendFullStop(BetterEnglish.getSettings().appendFullStops());
            event.setMessage(builder.getText());
        }
    }
}
