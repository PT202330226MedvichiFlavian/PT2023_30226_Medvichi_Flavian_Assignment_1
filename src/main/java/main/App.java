package main;

import controler.Controler;
import controler.Operatii;
import model.Polinom;
import view.Interfata;

public class App
{
    public static void main( String[] args )
    {
        Interfata i = new Interfata();
        Controler x = new Controler(i);
        Operatii c = new Operatii();
    }
}
