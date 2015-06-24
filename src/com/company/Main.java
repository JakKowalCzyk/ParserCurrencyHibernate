package com.company;

import com.parser.Parser;
import com.projectGui.ProjectGUI;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ProjectGUI projectGUI = new ProjectGUI();
                projectGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                projectGUI.setVisible(true);
            }
        });
    }
}
