package edu.uga.cs.ei.finalwebservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Food {

    String name;

    public Food() {
        this.name = "Not Food";
    }

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
