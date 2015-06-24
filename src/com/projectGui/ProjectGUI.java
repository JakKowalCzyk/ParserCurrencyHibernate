package com.projectGui;

import com.parser.Parser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by DK on 2015-06-24.
 */
public class ProjectGUI extends JFrame {
    public ProjectGUI() {
        setCurrency();


    }
    public void setCurrency(){
        Parser parser = new Parser();
        currency = parser.getCurrency();
        for (Double v : currency){
            System.out.println(v);
        }
    }

    private ArrayList<Double> currency;

}
