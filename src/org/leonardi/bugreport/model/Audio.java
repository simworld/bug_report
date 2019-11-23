package org.leonardi.bugreport.model;

import org.leonardi.bugreport.AbstractBug;

import java.util.ArrayList;

public class Audio extends AbstractBug {

    private String stringID;
    private String rerecording;

    public ArrayList globalGet() {

        //populating generic object data
        bugArray.add(getBugID());
        bugArray.add(getDate());
        bugArray.add(getPriority());
        bugArray.add(getSummary());
        bugArray.add(getDescription());
        bugArray.add(getStepToReproduce());
        bugArray.add(getActual());
        bugArray.add(getExpected());
        bugArray.add(getStringID());
        bugArray.add(getRerecording());

        return bugArray;
    }

    public void globalSet(ArrayList<String> details) {

        this.priority = details.get(0);
        this.summary = details.get(1);
        this.description = details.get(2);
        this.stepToReproduce = details.get(3);
        this.actual = details.get(4);
        this.expected = details.get(5);
        this.stringID = details.get(6);
        this.rerecording = details.get(7);
        this.date = dateToString();

    }

    private String getStringID() {
        return stringID;
    }

    public void setStringID(String stringID) {
        this.stringID = stringID;
    }

    private String getRerecording() {
        return rerecording;
    }

    public void setRerecording(String rerecording) {
        this.rerecording = rerecording;
    }


}

