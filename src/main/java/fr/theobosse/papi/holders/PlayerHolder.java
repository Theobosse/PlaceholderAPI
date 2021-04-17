package fr.theobosse.papi.holders;

import cn.nukkit.IPlayer;
import fr.theobosse.papi.utils.HolderPlayer;

import java.util.Locale;

public class PlayerHolder extends HolderPlayer {

    public PlayerHolder(String s) {
        super(s);
    }

    @Override
    public String onRequest(String param, IPlayer player) {
        return switch (param.toLowerCase(Locale.ROOT)) {
            case "name" -> player.getName();
            case "isOnline" -> String.valueOf(player.isOnline());
            case "uuid" -> player.getUniqueId().toString();
            default -> "None";
        };
    }
}
