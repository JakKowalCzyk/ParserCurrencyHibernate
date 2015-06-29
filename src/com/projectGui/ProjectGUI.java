package com.projectGui;

import com.base.*;
import javax.swing.*;
import java.util.List;

/**
 * Created by JK on 2015-06-24.
 */
public class ProjectGUI extends JFrame {
    public ProjectGUI() {
        makeBase = new MakeBase();
        EURButton.addActionListener(e -> {
            textArea1.setText("");

            makeEurArea();
        });
        USDButton1.addActionListener(e -> {
            textArea1.setText("");
            makeUsdArea();
        });
        CHFButton.addActionListener(e -> {
            textArea1.setText("");
            makeChfArea();
        });
        GBPButton.addActionListener(e -> {
            textArea1.setText("");
            makeGbpArea();
        });
        setContentPane(panel1);
        pack();
    }

    public void makeEurArea() {
        euRbases = makeBase.getEuRbasesList();
        for (EURbase ez : euRbases) {
            String dateAndValue = toString(ez.getDateSql(), ez.getValueOfEur());
            textArea1.setText(textArea1.getText().trim() + "\n" + dateAndValue);
        }
    }

    public void makeUsdArea() {
        usDbases = makeBase.getUsDbasesList();
        for (USDbase us : usDbases) {
            String dateAndValue = toString(us.getDateSql(), us.getValueOfUSD());
            textArea1.setText(textArea1.getText().trim() + "\n" + dateAndValue);
        }
    }

    public void makeChfArea() {
        chFbases = makeBase.getChFbasesList();
        for (CHFbase ch : chFbases) {
            String dateAndValue = toString(ch.getDateSql(), ch.getValueOfChf());
            textArea1.setText(textArea1.getText().trim() + "\n" + dateAndValue);
        }
    }

    public void makeGbpArea() {
        gbPbases = makeBase.getGbPbasesList();
        for (GBPbase gb : gbPbases) {
            String dateAndValue = toString(gb.getDateSql(), gb.getValueOfGbp());
            textArea1.setText(textArea1.getText().trim() + "\n" + dateAndValue);
        }
    }

    public String toString(java.sql.Date sqlDate, double valueOfCurrency) {
        return sqlDate + "  -  " + valueOfCurrency;
    }


    private List<EURbase> euRbases;
    private List<USDbase> usDbases;
    private List<CHFbase> chFbases;
    private List<GBPbase> gbPbases;
    private MakeBase makeBase;
    private JTextArea textArea1;
    private JPanel panel1;
    private JButton EURButton;
    private JButton minButton;
    private JButton USDButton1;
    private JButton CHFButton;
    private JButton GBPButton;
    private JButton maxButton;

}