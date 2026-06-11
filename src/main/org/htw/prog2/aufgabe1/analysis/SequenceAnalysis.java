package org.htw.prog2.aufgabe1.analysis;

import org.htw.prog2.aufgabe1.files.MutationFile;
import org.htw.prog2.aufgabe1.files.Mutation;
import org.htw.prog2.aufgabe1.files.SequenceFile;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class SequenceAnalysis {
    String reference;
    SequenceFile sequences = new SequenceFile();
    MutationFile mutations = new MutationFile();
    public SequenceAnalysis(String reference, SequenceFile sequences, MutationFile mutations) {
        this.reference = reference;
        this.sequences = sequences;
        this.mutations = mutations;
    }

    public abstract void calculateResistances();

    public HashMap<String, Double> getResistances() {return null;}

    public String getBestDrug() {
        return "";
    }

    public String getDrugDescriptions() {
        return "";
    }
}
