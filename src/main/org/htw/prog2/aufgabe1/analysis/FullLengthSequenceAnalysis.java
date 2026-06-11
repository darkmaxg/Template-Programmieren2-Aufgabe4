package org.htw.prog2.aufgabe1.analysis;

import org.htw.prog2.aufgabe1.files.Mutation;
import org.htw.prog2.aufgabe1.files.MutationFile;
import org.htw.prog2.aufgabe1.files.SequenceFile;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FullLengthSequenceAnalysis extends SequenceAnalysis{
    public HashMap<String, Double> resistances = new HashMap<>();
    public FullLengthSequenceAnalysis(String reference, SequenceFile sequences, MutationFile mutations) {
        super(reference, sequences, mutations);
        calculateResistances();
    }

    @Override
    public void calculateResistances() {
        LinkedList<String> drugsList = mutations.getDrugs();
        for(String drug : drugsList){
            resistances.put(drug, 0.0);
        }
        LinkedList<Mutation> mutationList = mutations.getMutations();
        for(Mutation m : mutationList){
            String sequence = m.getSequence(reference);
            if(sequences.containsSequence(sequence)){
                for(Map.Entry<String, Double> entry : m.getResistances().entrySet()){
                    String drug = entry.getKey();
                    Double resistance = entry.getValue();
                    if(resistance > resistances.get(drug)){
                        resistances.put(drug, resistance);
                    }
                }
            }
        }
    }

    @Override
    public HashMap<String, Double> getResistances() {
        if(resistances.isEmpty()){
            calculateResistances();
        }
        return resistances;
    }

    @Override
    public String getBestDrug() {
        if(resistances.isEmpty()){
            calculateResistances();
        }
        String bestDrug = "";
        double tmpMin = 100000000.0;
        for(Map.Entry<String, Double> set : resistances.entrySet()){
            Double value = set.getValue();
            if(value != null){
                if(value < tmpMin){
                    tmpMin = value;
                    bestDrug = set.getKey();
                }
            }
        }
        return bestDrug;
    }

    @Override
    public String getDrugDescriptions() {
        if(resistances.isEmpty()){
            calculateResistances();
        }
        return "";
    }
}