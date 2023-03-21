package org.example;

public class App 
{
    public static void main( String[] args )
    {
        Polinom a = new Polinom("10x+1");
        Polinom b = new Polinom("1");
        Polinom rez = new Polinom("");

        //Interfata i = new Interfata();
       // Controler x = new Controler(i);
        Operatii c = new Operatii();

       rez = c.adunare(a, b);
      // System.out.println(rez.pol);

    }
}
