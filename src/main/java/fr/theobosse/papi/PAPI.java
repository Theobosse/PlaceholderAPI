package fr.theobosse.papi;

import cn.nukkit.IPlayer;
import fr.theobosse.papi.utils.Holder;
import fr.theobosse.papi.utils.HolderPlayer;
import fr.theobosse.papi.utils.Level;

import java.util.ArrayList;
import java.util.HashMap;

public class PAPI {

    private static final HashMap<Level, ArrayList<Holder>> holders = new HashMap<>();
    private static final HashMap<Level, ArrayList<HolderPlayer>> holdersP = new HashMap<>();

    private static void load() {
        if (holdersP.isEmpty() && holders.isEmpty())
            for (Level l : Level.values()) {
                holders.putIfAbsent(l, new ArrayList<>());
                holdersP.putIfAbsent(l, new ArrayList<>());
            }
    }

    public static void addPlaceholderHook(Holder holder) {
        load();
        holders.get(holder.getLevel()).add(holder);
    }

    public static void addPlaceholderHook(HolderPlayer holder) {
        load();
        holdersP.get(holder.getLevel()).add(holder);
    }

    /*public static String format(String s) {
        StringBuilder osb = new StringBuilder(s);
        StringBuilder nsb = new StringBuilder();
        for (int lvl = 1; lvl <= Level.values().length; lvl++) {
            System.out.println(osb);
            if (lvl > 1) {
                osb = nsb;
                nsb = new StringBuilder();
            }

            for (String h : osb.toString().split("%")) {
                String param = "";
                h = "%" + h + "%";
                if (h.contains("{") && h.contains("}")) {
                    String[] sp = h.split("\\{");
                    param = sp[1].replace("}", "");
                    h = sp[0];
                }

                for (Holder holder : getHolders().get(Level.getByID(lvl))) {
                    if (("%" + holder.getS() + "%").equals(h))
                        if (param.equals(""))
                            h = holder.onRequest();
                        else
                            h = holder.onRequest(param);
                    if (h.equals("%%"))
                        h = "";
                }
                nsb.append(h);
            }
        }

        return nsb.toString();
    }*/

    public static String format(String s) {
        StringBuilder sb = new StringBuilder();
        for (String i :  s.split("%")) {
            String param = "";
            if (i.contains("{") && i.contains("}")) {
                String[] sp = i.split("\\{");
                param = sp[1].replace("}", "");
                i = sp[0];
            }

            for (Holder h : getHoldersList())
                if (h.getS().equals(i))
                    if (param.equals(""))
                        i = h.onRequest(param);
                    else
                        i = h.onRequest(param);
            sb.append(i);
        }

        return sb.toString();
    }

    public static String format(String s, IPlayer player) {
        StringBuilder sb = new StringBuilder();
        s = format(s);
        for (String i :  s.split("%")) {
            String param = "";
            if (i.contains("{") && i.contains("}")) {
                String[] sp = i.split("\\{");
                param = sp[1].replace("}", "");
                i = sp[0];
            }

            for (HolderPlayer h : getHoldersPList())
                if (h.getS().equals(i))
                    if (param.equals(""))
                        i = h.onRequest(param, player);
                    else
                        i = h.onRequest(param, player);
            sb.append(i);
        }

        return sb.toString();
    }

    public static HashMap<Level, ArrayList<Holder>> getHolders() {
        return holders;
    }

    public static HashMap<Level, ArrayList<HolderPlayer>> getHoldersP() {
        return holdersP;
    }

    public static ArrayList<Holder> getHoldersList() {
        ArrayList<Holder> list = new ArrayList<>();
        for (ArrayList<Holder> hl : holders.values())
            list.addAll(hl);
        return list;
    }

    public static ArrayList<HolderPlayer> getHoldersPList() {
        ArrayList<HolderPlayer> list = new ArrayList<>();
        for (ArrayList<HolderPlayer> hl : holdersP.values())
            list.addAll(hl);
        return list;
    }
}
