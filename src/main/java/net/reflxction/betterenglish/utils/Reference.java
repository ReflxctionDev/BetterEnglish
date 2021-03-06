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
package net.reflxction.betterenglish.utils;

/**
 * Class which contains mod information.
 */
public class Reference {

    // Mod ID (for Forge initialization)
    public static final String MOD_ID = "betterenglish";

    // Mod name
    public static final String NAME = "Better English";

    // Mod version
    public static final String VERSION = "1.0";

    // Minecraft versions that the mod works on
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";

    // Mod prefix (for sending messages)
    public static final String PREFIX = ChatColor.format("&9[&cBetter English&9] ");

    public static final String CREDITS = ChatColor.format("&9Better&cEnglish &fby &aReflxction");

    // Client proxy handler
    public static final String CLIENT_PROXY = "net.reflxction.betterenglish.proxy.ClientProxy";

    // Server proxy handler
    public static final String SERVER_PROXY = "net.reflxction.betterenglish.proxy.ServerProxy";

}
