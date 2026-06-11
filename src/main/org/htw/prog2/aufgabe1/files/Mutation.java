package org.htw.prog2.aufgabe1.files;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mutation {
    String variant;
    HashMap<String, Double> resistances;

    public Mutation(String variant, HashMap<String, Double> resistances) {
        this.variant = variant;
        this.resistances = resistances;
    }

    public String getVariant() {
        return variant;
    }

    public HashMap<String, Double> getResistances() {
        return resistances;
    }

    public String getSequence(String reference) {
        StringBuilder newReference = new StringBuilder(reference);
        String pattern = "(\\d+)([a-zA-Z])";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(variant);
        while(m.find()){
            int position = Integer.parseInt(m.group(1)) - 1;
            char aminosaeure = m.group(2).charAt(0);
            newReference.setCharAt(position, aminosaeure);
        }
        return newReference.toString();
    }
}
