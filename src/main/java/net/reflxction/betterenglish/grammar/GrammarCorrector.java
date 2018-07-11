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
package net.reflxction.betterenglish.grammar;

import net.reflxction.betterenglish.utils.RegexUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Some handy methods to help fix grammar
 */
@SuppressWarnings("SpellCheckingInspection")
class GrammarCorrector {

    private static Map<String, String> contractions = new HashMap<>();

    /**
     * Package-private as only used by {@link GrammarBuilder}.
     *
     * @see GrammarBuilder
     */
    GrammarCorrector() {
    }

    // Put most commonly used English contractions
    static {
        contractions.put("dont", "don't");
        contractions.put("doesnt", "doesn't");
        contractions.put("cant", "can't");
        contractions.put("couldnt", "couldn't");
        contractions.put("wouldnt", "wouldn't");
        contractions.put("im", "I'm");
        contractions.put("i'm", "I'um");
        contractions.put("wasnt", "wasn't");
        contractions.put("werent", "weren't");
        contractions.put("wont", "won't");
        contractions.put("hes", "he's");
        contractions.put("hasnt", "hasn't");
        contractions.put("havent", "haven't");
        contractions.put("youll", "you'll");
        contractions.put("youre", "you're");
        contractions.put("shouldnt", "shouldn't");
        contractions.put("mustnt", "mustn't");
        contractions.put("neednt", "needn't");
        contractions.put("mightnt", "mightn't");
        contractions.put("darent", "daren't");
        contractions.put("didnt", "didn't");
        contractions.put(" i ", " I ");
    }

    /**
     * Corrects contractions
     *
     * @param text Text to fix for
     * @return The string with fixed contractions
     */
    String fixContractions(String text) {
        for (String s : contractions.keySet()) {
            if (RegexUtils.isWholeWorld(s, text)) {
                text = text.replace(s, contractions.get(s));
            }
        }
        return text;
    }

    /**
     * Capitalizes a string
     *
     * @param text Text to capitalize
     * @return Text after being capitalized
     */
    String capitalize(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    /**
     * Appends a full-stop to the end of the string, after doing some checks.
     *
     * @param text Text to append full-stop for
     * @return Text with a full-stop
     */
    String appendFullStop(String text) {
        if (text.isEmpty()) return "";
        char last = text.charAt(text.length() - 1);
        if (Character.isLetter(last) && !text.startsWith("/")) {
            return text.concat(".");
        }
        return text;
    }
}
