/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.github.integritymc.integritylobby.config;

import com.github.integritymc.integritylobby.config.modules.sub.MessageModule;
import com.github.integritymc.integritylobby.config.modules.sub.ScoreboardModule;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Settings {
    private ScoreboardModule scoreboard;
    private MessageModule join;
    private MessageModule motd;
    private MessageModule quit;
}
