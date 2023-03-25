package controler;

import model.Polinom;

import javax.swing.*;
import java.util.Map;


public class Operatii {

    JFrame frame = new JFrame("JoptionPane Test");
    public Polinom adunare(Polinom a, Polinom b){
        Polinom c = new Polinom("0");
        int e,d;
        double r;
        for (Integer ex : a.pol.keySet()) {
            if(b.pol.containsKey(ex)){//verific daca gasesc cheia in polinomul b
                r = a.pol.get(ex) + b.pol.get(ex);
                c.pol.put(ex, r);
            }else {
                c.pol.put(ex, a.pol.get(ex));//daca cheia nu este in b pun doar exponetul si coeficientul din polinomul a
            }
        }
        for(Map.Entry<Integer, Double> x : b.pol.entrySet()){//parcurgem al doilea polinom si adaugam termenii care nu se afla in primul
            if(!a.pol.containsKey(x.getKey())){
                c.pol.put(x.getKey(), x.getValue());
            }
        }
        return c;
    }

    public Polinom scadere(Polinom a, Polinom b){
        Polinom c = new Polinom("0");
        int e,d;
        double r;
        for (Integer ex : a.pol.keySet()) {
            if(b.pol.containsKey(ex)){//verific daca gasesc cheia in polinomul b
                r = a.pol.get(ex) - b.pol.get(ex);
                c.pol.put(ex, r);
            }else {
                c.pol.put(ex, a.pol.get(ex));//daca cheia nu este in b pun doar exponetul si coeficientul din polinomul a
            }
        }
        for(Map.Entry<Integer, Double> x : b.pol.entrySet()){//parcurgem al doilea polinom si adaugam termenii care nu se afla in primul
            if(!a.pol.containsKey(x.getKey())){
                c.pol.put(x.getKey(), -x.getValue());
            }
        }
        return c;
    }

    public Polinom derivare(Polinom a)
    {
        Polinom c = new Polinom("0");
        for(Map.Entry<Integer, Double> x: a.pol.entrySet()){
            if(x.getValue() != 0 && x.getKey() != 0){
                c.pol.put(x.getKey()-1, (x.getKey())*x.getValue());
            }
    }
        return c;
    }
    public Polinom integrare(Polinom a){
        Polinom c = new Polinom("0");
        for(Map.Entry<Integer,Double> x: a.pol.entrySet()){
            if(x.getKey() == 0)
            {
                c.pol.put(x.getKey()+1, 1.0);
            }
            else{
                c.pol.put(x.getKey()+1, x.getValue()/(x.getKey()+1));
            }
        }
        return c;
    }

    public Polinom inmultire(Polinom a, Polinom b){
        Polinom c = new Polinom("0");
        for(Map.Entry<Integer,Double> x: a.pol.entrySet()){
            for(Map.Entry<Integer, Double> y: b.pol.entrySet())
            {
                int exp  = x.getKey() + y.getKey();
                double coef = x.getValue() * y.getValue();
                if(c.pol.get(exp) != null)
                {
                    double q = c.pol.get(exp) + coef;
                    c.pol.put(exp, q);
                }else{
                    c.pol.put(exp, coef);
                }
            }
        }
        return c;
    }

    private Polinom minim(Polinom a)
    {
        int exp = rank(a);
        double coef = 0.0;
        Polinom rez = new Polinom("0");
        for(Map.Entry<Integer, Double> x: a.pol.entrySet())
        {
            if(x.getKey()<=exp && x.getValue() != 0)
            {
                exp = x.getKey();
                coef = x.getValue();
            }
        }

        rez.pol.put(exp, coef);
        return rez;
    }
    private int rank(Polinom a)//returneaza rank ul maxim la unui polinom
    {
        int max = 0;
        for(Map.Entry<Integer, Double> x: a.pol.entrySet())
        {
            if(x.getKey()>max && x.getValue() != 0)
                max = x.getKey();
        }
        return max;
    }
    public Polinom[] impartire(Polinom a, Polinom b){
        Polinom c = new Polinom("0");
        Polinom d = new Polinom("0");
        Polinom[] v = new Polinom[2];
        Polinom rez = new Polinom("0");
        Polinom dif = new Polinom("0");
        Polinom x = new Polinom("0");
        c=a;
        d=b;
        if(d.toString().equals("0"))
        {
            return null;
        }
        else{
            if(rank(c) < rank(d))
            {
                v[0] = rez;
                v[1] = rez;
                return v;
            }
            else{
                int ed = rank(d);
                dif = d;
                int ok = 1;
                while(rank(c) >= rank(d) && ok == 1 ){
                    int ec = rank(c);
                    rez.pol.put(ec-ed,c.pol.get(ec)/d.pol.get(ed));
                    x = minim(rez);
                    dif = inmultire(d, x);
                    c = scadere(c, dif);
                    if(rank(c)==0)
                        ok = 0;
                }
            }
            v[0] = rez;
            v[1] = c;
            return v;
        }
    }
}
