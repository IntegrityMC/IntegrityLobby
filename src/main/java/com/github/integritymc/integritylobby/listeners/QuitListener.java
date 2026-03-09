/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.github.integritymc.integritylobby.listeners;

import com.github.integritymc.integritylobby.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.stream.Collectors;

public class QuitListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (Main.getSettings().getQuit().isEnabled())
            event.setQuitMessage(Main.getSettings().getQuit().getMessage().stream().map(s -> PlaceholderAPI.setPlaceholders(event.getPlayer(), s)).collect(Collectors.joining("\n")));
    }
}
