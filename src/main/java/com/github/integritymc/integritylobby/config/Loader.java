/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.github.integritymc.integritylobby.config;

import com.github.integritymc.integritylobby.Main;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Loader {
    public Settings load() {
        File file = new File(Main.getInstance().getDataFolder(), "settings.yml");
        if (!file.exists())
            Main.getInstance().saveResource("settings.yml", false);

        LoaderOptions options = new LoaderOptions();
        options.setTagInspector(tag -> true);

        Yaml yaml = new Yaml(new Constructor(Settings.class, options));
        try (InputStream in = new FileInputStream(file)) {
            return yaml.load(in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
