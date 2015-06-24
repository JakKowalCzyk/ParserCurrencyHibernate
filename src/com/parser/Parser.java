package com.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * Created by DK on 2015-06-24.
 */
public class Parser extends JFrame {
    public Parser() {
        values = new ArrayList<>();
        currency = new ArrayList<>();
        document = null;
    }

    public void setTableElements() {
        try {
            document = Jsoup.connect("http://www.money.pl/pieniadze/nbp/srednie/").get();
        }catch (IOException e){
            JOptionPane.showMessageDialog(this, "Problem with connection to site", "Exception", JOptionPane.CLOSED_OPTION, null);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Problem with connection to site", "Exception", JOptionPane.CLOSED_OPTION, null);
        }
        for (org.jsoup.nodes.Element table : document.select("table.tabela")){
            for (org.jsoup.nodes.Element row : table.select("tr.premium")) {
                tableElements = row.select("td");
                if (tableElements.size() > 4) values.add(tableElements.get(3).text());
            }
        }
    }
    public ArrayList<Double> getCurrency(){
        setTableElements();
        for (String v : values) {
            double valuesToCurrency = Double.parseDouble(v.replaceAll(",", "."));
            currency.add(valuesToCurrency);
        }
        return currency;
    }

    private ArrayList<String> values;
    private ArrayList<Double> currency;
    private Document document;
    private Elements tableElements;
}
