package com.company;

public class Controller {
    private Learner learner;

    public Controller(){
        learner = new Learner();
        learner.loadDataset("data/spam_training.arff");
        learner.evaluate();
        learner.learn();
    }
    public int test(String message){
        SpamClassifier spamClassifier = new SpamClassifier(message);
        spamClassifier.makeInstance();
        return spamClassifier.classify(learner.getClassifier());
    }
}
