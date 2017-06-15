package com.company;

import weka.classifiers.Classifier;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

/**
 * Created by Pratama Agung on 6/15/2017.
 */
public class SpamClassifier {
    String message;
    Instances instances;

    /**
     * Constructor for class SpamClassifier
     * @param message string which will be classified as spam or not_spam
     */
    public SpamClassifier(String message){
        this.message = message;
    }

    /**
     * Method to make instance of the message
     */
    public void makeInstance() {
        // Create the attributes, class and text
        FastVector fvNominalVal = new FastVector(2);
        fvNominalVal.addElement("spam");
        fvNominalVal.addElement("not_spam");
        Attribute attribute1 = new Attribute("class", fvNominalVal);
        Attribute attribute2 = new Attribute("text",(FastVector) null);
        // Create list of instances with one element
        FastVector fvWekaAttributes = new FastVector(2);
        fvWekaAttributes.addElement(attribute1);
        fvWekaAttributes.addElement(attribute2);
        instances = new Instances("Test relation", fvWekaAttributes, 1);
        // Set class index
        instances.setClassIndex(0);
        // Create and add the instance
        Instance instance = new Instance(2);
        instance.setValue(attribute2, message);
        // Another way to do it:
        // instance.setValue((Attribute)fvWekaAttributes.elementAt(1), text);
        instances.add(instance);
        System.out.println("===== Instance created with reference dataset =====");
    }

    /**
     * Method to classify the message
     * @param classifier result of learning from data set
     */
    public void classify(Classifier classifier) {
        try {
            double[] pred = classifier.distributionForInstance(instances.instance(0));
            System.out.println("===== Classified instance =====");
            String result;
            if (pred[0] > pred [1]){
                result = "spam";
            } else {
                result = "not_spam";
            }
            System.out.println("Message predicted as: " + result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
