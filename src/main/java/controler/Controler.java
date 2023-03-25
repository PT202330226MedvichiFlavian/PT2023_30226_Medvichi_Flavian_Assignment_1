package controler;
import view.Interfata;
import model.Polinom;

import java.awt.event.*;
public class Controler {

   private String p1;
   private String p2;
   private Interfata view;

   public Controler(Interfata view){
       this.view = view;
       Operatii op = new Operatii();
       this.view.adunarea(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Polinom p1 = new Polinom(view.getPol1());
               Polinom p2 = new Polinom(view.getPol2());
               if(p1.getPol()==null || p2.getPol()==null)
               {
                   view.setRez("Date incorecte");
               }
               else {
                   Polinom rez = op.adunare(p1,p2);
                   view.setRez(rez.toString());
               }
           }
       });
       this.view.scaderea(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Polinom p1 = new Polinom(view.getPol1());
               Polinom p2 = new Polinom(view.getPol2());
               if(p1.getPol()==null || p2.getPol()==null)
               {
                   view.setRez("Date incorecte");
               }
               else {
                   Polinom rez = op.scadere(p1, p2);
                   view.setRez(rez.toString());
               }

           }
       });
       this.view.derivarea(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Polinom p1 = new Polinom(view.getPol1());
               if(p1.getPol()==null)
               {
                   view.setRez("Date incorecte");
               }
               else {
                   Polinom rez = op.derivare(p1);
                   view.setRez(rez.toString());
               }

           }
       });
       this.view.integrarea(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Polinom p1 = new Polinom(view.getPol1());
               if(p1.getPol()==null)
               {
                   view.setRez("Date incorecte");
               }else{
                   Polinom rez = op.integrare(p1);
                   view.setRez(rez.toString());
               }

           }
       });
       this.view.inmultirea(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Polinom p1 = new Polinom(view.getPol1());
               Polinom p2 = new Polinom(view.getPol2());
               if(p1.getPol()==null || p2.getPol()==null)
               {
                   view.setRez("Date incorecte");
               }
               else {
                   Polinom rez = op.inmultire(p1, p2);
                   view.setRez(rez.toString());
               }

           }
       });

       this.view.impartirea(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Polinom p1 = new Polinom(view.getPol1());
               Polinom p2 = new Polinom(view.getPol2());
               if(p1.getPol()==null || p2.getPol()==null)
               {
                   view.setRez("Date incorecte");
               }
               else {
                   Polinom[] rez = op.impartire(p1, p2);
                   if(p2.toString().equals("0"))
                   {
                       view.setRez("Error");
                   }
                   else{
                       view.setRez(rez[0].toString() + " R:" + rez[1].toString());
                   }
               }
           }
       });
   }
}
