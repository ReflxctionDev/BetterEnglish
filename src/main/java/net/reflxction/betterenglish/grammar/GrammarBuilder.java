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

/**
 * Uses chain methods to fix
 */
public class GrammarBuilder {

    // Text to correct for
    private String text;

    // Instance of the corrector
    private GrammarCorrector corrector = new GrammarCorrector();

    /**
     * Creates a builder instance
     *
     * @param text Text to correct for
     */
    public GrammarBuilder(String text) {
        this.text = text;
    }

    /**
     * Corrects contractions
     *
     * @return The string with fixed contractions
     */
    public GrammarBuilder fixContractions(boolean flag) {
        if (flag) {
            text = corrector.fixContractions(text);
        }
        return this;
    }

    /**
     * Capitalizes a string
     *
     * @return Text after being capitalized
     */
    public GrammarBuilder capitalize(boolean flag) {
        if (flag) {
            text = corrector.capitalize(text);
        }
        return this;
    }

    /**
     * Appends a full-stop to the end of the string, after doing some checks.
     *
     * @return Text with a full-stop
     */
    public GrammarBuilder appendFullStop(boolean flag) {
        if (flag) {
            text = corrector.appendFullStop(text);
        }
        return this;
    }

    /**
     * The text after being modified
     *
     * @return ^
     */
    public String getText() {
        return text;
    }

}
