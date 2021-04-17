package fr.theobosse.papi;

import fr.theobosse.papi.holders.MathHolder;
import fr.theobosse.papi.utils.Holder;

public class Test {

    public static void main(String... args) {
        loadPAPI();
        System.out.println(PAPI.format("Bienvenue %player{name}% sur le serveur %server{display}% ! -> %Math{%test% + (5 * 6) / 2}% %test%"));
        PAPI.getHoldersList().forEach(System.out::print);
    }

    public static void loadPAPI() {
        PAPI.addPlaceholderHook(new MathHolder("Math"));
        PAPI.addPlaceholderHook(new Holder("player") {
            @Override
            public String onRequest(String params) {
                if (params.equals("name"))
                    return "theobosse";
                return "None";
            }
        });

        PAPI.addPlaceholderHook(new Holder("server") {
            @Override
            public String onRequest(String params) {
                if (params.equals("display"))
                    return "WAS";
                return "Null";
            }
        });

        PAPI.addPlaceholderHook(new Holder("test") {
            @Override
            public String onRequest() {
                return "50";
            }

            @Override
            public String onRequest(String param) {
                return "50";
            }
        });
    }

    public static String transform(String s) {
        StringBuilder sb = new StringBuilder();
        for (String i :  s.split("%")) {
            String param = "";
            if (i.contains("{") && i.contains("}")) {
                String[] sp = i.split("\\{");
                param = sp[1].replace("}", "");
                i = sp[0];
            }

            for (Holder h : PAPI.getHoldersList())
                if (h.getS().equals(i))
                    if (param.equals(""))
                        i = h.onRequest();
                    else
                        i = h.onRequest(param);
            sb.append(i);
        }

        return sb.toString();
    }

}
