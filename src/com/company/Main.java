package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String getSMS(){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter yout message:");
            return reader.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) throws Exception{
        Learner learner = new Learner();
        learner.loadDataset("data/spam_training.arff");
        learner.evaluate();
        learner.learn();

        SpamClassifier spamClassifier = new SpamClassifier(getSMS());
        spamClassifier.makeInstance();
        spamClassifier.classify(learner.getClassifier());
    }
}
