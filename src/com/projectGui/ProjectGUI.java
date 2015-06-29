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
            textArea1.setText("euro  \n");
            makeEurArea();
        });
        USDButton1.addActionListener(e -> {
            textArea1.setText("dolar amerykañski \n");
            makeUsdArea();
        });
        CHFButton.addActionListener(e -> {
            textArea1.setText("frank szwajcarski \n");
            makeChfArea();
        });
        GBPButton.addActionListener(e -> {
            textArea1.setText("funt szterling \n");
            makeGbpArea();
        });
        maxButton.addActionListener(e -> {
            textArea1.setText("");
            makeMaxArea();
        });
        minButton.addActionListener(e -> {
            textArea1.setText("");
            makeMinArea();
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
    public void makeMaxArea(){
        textArea1.setText(makeBase.getMaxEur() + "\n" + makeBase.getMaxUsd() + "\n" + makeBase.getMaxChf() + "\n" + makeBase.getMaxGbp());
    }
    public void makeMinArea(){
        textArea1.setText(makeBase.getMinEur() + "\n" + makeBase.getMinUsd() + "\n" + makeBase.getMinChf() + "\n" + makeBase.getMinGbp());
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