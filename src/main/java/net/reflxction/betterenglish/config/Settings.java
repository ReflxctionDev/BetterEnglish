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

/**
 * Contains all variables from the config
 */
public class Settings {

    private boolean contractions, fullStops, capitalization;

    public Settings() {
        this.contractions = BetterEnglish.getConfig().get("Grammar", "Contractions", true).getBoolean();
        this.fullStops = BetterEnglish.getConfig().get("Grammar", "FullStops", true).getBoolean();
        this.capitalization = BetterEnglish.getConfig().get("Grammar", "Capitalization", true).getBoolean();
    }

    public boolean fixContractions() {
        return contractions;
    }

    public boolean appendFullStops() {
        return fullStops;
    }

    public boolean capitalization() {
        return capitalization;
    }

    void setContractions(boolean contractions) {
        this.contractions = contractions;
    }

    void setFullStops(boolean fullStops) {
        this.fullStops = fullStops;
    }

    void setCapitalization(boolean capitalization) {
        this.capitalization = capitalization;
    }
}
