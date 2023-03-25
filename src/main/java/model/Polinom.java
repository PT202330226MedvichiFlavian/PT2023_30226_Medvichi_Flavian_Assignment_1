package model;

import javax.swing.*;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    private String polinom;

    public TreeMap<Integer, Double> pol = new TreeMap<Integer, Double>();

    public TreeMap<Integer, Double> getPol() {
        return pol;
    }

    public Polinom(String polinom){
        this.polinom = polinom;
        String verif = "";
        String regex = "([-+]?\\d*\\.?\\d*[x]\\^\\d+|[-+]?\\d*\\.?\\d*[x]|[-+]?\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(polinom);
        double coef = 0;
        int exp = 0;
        while (matcher.find()) {
            String term = matcher.group();
            if(term.matches("[-+]?\\d+")){//termenul este o constanta
                coef = Integer.parseInt(term);
                exp = 0;
            } else if (term.matches("[-+]?[x]")) {//termenul este o singura variabila  fara coef
                if(term.matches("[-][x]")){ coef = -1;}
                else{ coef = 1;}
                exp = 1;
            } else if (term.matches("[-+]?\\d*[x]")) {//termenul are coef !=1 si exp = 1
                String partitie = term.replace("x", "");
                coef = Integer.parseInt(partitie);
                exp = 1;
            } else if (term.matches("[-+]?[x]\\^\\d")) {
                String [] partitie = term.split("\\^");
                if(partitie[0].matches("[-][x]")){ coef = -1;}
                else { coef = 1;}
                exp = Integer.parseInt(partitie[1]);
            }else{
                String [] partitie = term.split("x\\^");
                coef = Integer.parseInt(partitie[0]);
                exp = Integer.parseInt(partitie[1]);
            }
            pol.put(exp, coef);

            verif = verif + verificare(exp,coef);
        }
        if(verif.equals(""))
            verif=verif+"0";
        char car = verif.charAt(0);
        if(car == '+')
            verif =verif.substring(1);

        if(!polinom.equals(verif))
            pol = null;
    }

    private String verificare(int exp, double coef){
        String monom = "";
        DecimalFormat df = new DecimalFormat("#.#");
        if(exp == 0){
            if(coef != 0){
                if(coef>0){
                    monom = monom + "+" + df.format(coef);
                }
                else{ monom = monom + df.format(coef);}
            }
        } else if (exp == 1) {
            if(coef != 0){
                if(coef>0 ){
                    if(coef==1){
                        monom = monom + "+" + "x";
                    }
                    else{
                        monom = monom + "+" + df.format(coef) + "x";}//aci ar trebui sa afiseze doar x fara 1 coef
                }
                else{
                    if(coef==-1){
                        monom = monom + "-" + "x";
                    }
                    else{
                        monom = monom + df.format(coef) + "x";}//aci ar trebui sa afiseze doar x fara 1 coef
                }
            }
        }
        else {
            if(coef != 0){
                if(coef>0){
                    if(coef==1){
                        monom = monom + "+" + "x^" + exp;
                    }
                    else{
                        monom = monom + "+" + df.format(coef) + "x" + "^" + exp;
                    }
                }
                else{
                    if(coef==-1){
                        monom = monom + "-" + "x^" + exp;
                    }
                    else{
                        monom = monom + df.format(coef) + "x" + "^" + exp;}
                }
            }
        }
        return monom;
    }
    public String toString(){
        String s = "";
        String verif = "";
        DecimalFormat df = new DecimalFormat("#.#");
        double coef=0;
        int exp=0;
        for(Map.Entry<Integer, Double> x : pol.entrySet() ){
            String monom="";
            coef = x.getValue();
            exp = x.getKey();
            monom = verificare(exp,coef);
            s = monom + s;
        }
        if(s.equals(""))
            s=s+"0";
        return s;
    }
}
