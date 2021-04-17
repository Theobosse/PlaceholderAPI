/*
 * This file is part of PlaceholderAPI
 *
 * PlaceholderAPI
 * Copyright (c) 2015 - 2020 PlaceholderAPI Team
 *
 * PlaceholderAPI free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlaceholderAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package fr.theobosse.papi.utils;

import cn.nukkit.IPlayer;

public abstract class HolderPlayer {
  private final String s;

  public HolderPlayer(String s) {
    this.s = s;
  }

  public String onRequest(IPlayer player) {
    return null;
  }

  public String onRequest(String param, IPlayer player) {
    return null;
  }

  public String getS() {
    return s;
  }

  public Level getLevel() {
    return Level.NORMAL;
  }

}
