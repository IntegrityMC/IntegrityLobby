/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.github.integritymc.integritylobby.listeners;

import com.github.integritymc.integritylobby.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.stream.Collectors;

public class JoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (Main.getSettings().getJoin().isEnabled())
            event.setJoinMessage(Main.getSettings().getJoin().getMessage().stream().map(s -> PlaceholderAPI.setPlaceholders(player, s)).collect(Collectors.joining("\n")));

        if (Main.getSettings().getMotd().isEnabled())
            player.sendMessage(Main.getSettings().getMotd().getMessage().stream().map(s -> PlaceholderAPI.setPlaceholders(player, s)).collect(Collectors.joining("\n")));
    }
}
