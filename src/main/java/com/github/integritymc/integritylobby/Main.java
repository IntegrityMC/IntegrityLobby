/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.github.integritymc.integritylobby;

import com.github.integritymc.integritylobby.config.Loader;
import com.github.integritymc.integritylobby.config.Settings;
import com.github.integritymc.integritylobby.listeners.JoinListener;
import com.github.integritymc.integritylobby.listeners.QuitListener;
import com.github.integritymc.integrityscoreboard.api.IntegrityScoreboard;
import com.github.integritymc.integrityscoreboard.api.IntegrityScoreboardAPI;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    @Getter public static Main instance;
    @Getter public static Settings settings;
    @Getter public IntegrityScoreboardAPI scoreboardAPI;

    @Override
    public void onEnable() {
        //INSTANCE
        instance = this;

        //CUSTOM CONFIG LOADER
        Loader loader = new Loader();
        settings = loader.load();

        //LOAD INTEGRITY SCOREBOARD API
        scoreboardAPI = IntegrityScoreboard.create(this).adapter(new LobbyScoreboard()).updateInterval(4L).autoManagePlayers(true).enable();

        //REGISTER LISTENER
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new QuitListener(), this);
    }

    @Override
    public void onDisable() {
        //SHUTDOWN INTEGRITY SCOREBOARD API
        scoreboardAPI.shutdown();
    }
}
