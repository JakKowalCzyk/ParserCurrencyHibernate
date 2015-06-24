package com.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by DK on 2015-06-24.
 */
public class Parser {
    public Parser() {
        values = new ArrayList<>();
        currency = new ArrayList<>();
        document = null;
    }

    public void setTableElements() {
        try {
            document = Jsoup.connect("http://www.money.pl/pieniadze/nbp/srednie/").get();
        }catch (IOException e){
            e.printStackTrace();
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
