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
package net.reflxction.betterenglish.config;

import net.reflxction.betterenglish.BetterEnglish;

public class ConfigManager {
    
    /**
     * Sets if the mod is enabled or not
     *
     * @param b Flag if it should be enabled or not
     */
    public void setEnabled(boolean b) {
        BetterEnglish.setEnabled(b);
        BetterEnglish.getConfig().get("Enabled", "Enabled", true).set(b);
        BetterEnglish.getConfig().save();
    }

    /**
     * Sets if the mod should fix full-stops
     *
     * @param fullStops Boolean to set
     */
    public void setFullStops(boolean fullStops) {
        BetterEnglish.getSettings().setFullStops(fullStops);
        BetterEnglish.getConfig().get("Grammar", "FullStops", true).set(fullStops);
        BetterEnglish.getConfig().save();
    }


    /**
     * Sets if the mod should fix contractions
     *
     * @param contractions Boolean to set
     */
    public void setContractions(boolean contractions) {
        BetterEnglish.getSettings().setContractions(contractions);
        BetterEnglish.getConfig().get("Grammar", "Contractions", true).set(contractions);
        BetterEnglish.getConfig().save();
    }


    /**
     * Sets if the mod should capitalize text
     *
     * @param capitalization Boolean to set
     */
    public void setCapitalization(boolean capitalization) {
        BetterEnglish.getSettings().setCapitalization(capitalization);
        BetterEnglish.getConfig().get("Grammar", "Capitalization", true).set(capitalization);
        BetterEnglish.getConfig().save();
    }

}
