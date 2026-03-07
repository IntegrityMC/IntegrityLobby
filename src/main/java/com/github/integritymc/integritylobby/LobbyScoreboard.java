/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.github.integritymc.integritylobby;

import com.github.integritymc.integrityscoreboard.adapter.SidebarAdapter;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class LobbyScoreboard implements SidebarAdapter {
    @Override
    public String getTitle(Player player) {
        return Main.getSettings().getScoreboard().getTitle();
    }

    @Override
    public List<String> getLines(Player player) {
        return Main.getSettings().getScoreboard().getLines().stream().map(s -> PlaceholderAPI.setPlaceholders(player, s)).collect(Collectors.toList());
    }
}
