package fr.theobosse.papi.holders;

import fr.theobosse.papi.PAPI;
import fr.theobosse.papi.utils.Holder;
import fr.theobosse.papi.utils.Level;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MathHolder extends Holder {

    public MathHolder(String s) {
        super(s);
    }

    @Override
    public String onRequest(String param) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            return String.valueOf(engine.eval(PAPI.format(param)));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return "0";
    }

    @Override
    public Level getLevel() {
        return Level.LOWER;
    }
}
