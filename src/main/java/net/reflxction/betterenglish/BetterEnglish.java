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
package net.reflxction.betterenglish;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.reflxction.betterenglish.config.Settings;
import net.reflxction.betterenglish.proxy.IProxy;
import net.reflxction.betterenglish.utils.Reference;

import java.io.File;

/**
 * BetterEnglish: A mod which fixes some English mistakes when typing
 */
@Mod(
        modid = Reference.MOD_ID,
        name = Reference.NAME,
        version = Reference.VERSION,
        acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS
)
public class BetterEnglish {

    // Config for saving data
    private static Configuration config;

    // If the mod is enabled
    private static boolean enabled;

    @SidedProxy(
            clientSide = Reference.CLIENT_PROXY,
            serverSide = Reference.SERVER_PROXY
    )
    public static IProxy proxy;

    // Mod settings
    private static Settings settings;

    /*
     * Initialize variables here
     */
    static {
        config = new Configuration(new File("config/better-english.cfg"));
        enabled = config.get("Enabled", "Enabled", true).getBoolean();
        settings = new Settings();
    }

    /**
     * Fired before the mod is loaded into the client
     */
    @EventHandler
    public void onFMLPreInitialization(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    /**
     * Register events and client commands here
     */
    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    /**
     * Fired after the mod has been fully loaded
     */
    @EventHandler
    public void onFMLPostInitialization(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    /**
     * Register server commands here
     */
    @EventHandler
    public void serverStart(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }

    /**
     * @return If the mod is enabled
     */
    public static boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets if the mod is enabled or not
     *
     * @param enabled Boolean to set
     */
    public static void setEnabled(boolean enabled) {
        BetterEnglish.enabled = enabled;
    }

    /**
     * Config
     *
     * @return The mod config that stores everything
     */
    public static Configuration getConfig() {
        return config;
    }

    /**
     * Instance of the mod settings
     *
     * @return ^
     */
    public static Settings getSettings() {
        return settings;
    }

}
