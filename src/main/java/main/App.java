package main;

import controler.Controler;
import controler.Operatii;
import model.Polinom;
import view.Interfata;

public class App
{
    public static void main( String[] args )
    {
        Polinom a = new Polinom("-10");
        Polinom b = new Polinom("2");
        Polinom rez = new Polinom("0");
        Interfata i = new Interfata();
        Controler x = new Controler(i);
        Operatii c = new Operatii();
    }
}
