import controler.Operatii;
import model.Polinom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Operation_test {
    @Test
    public void test_adunare(){
        Polinom p1 = new Polinom("2x^2+5");
        Polinom p2 = new Polinom("x^2+x");
        Polinom r = new Polinom("0");
        Operatii c = new Operatii();

        r = c.adunare(p1,p2);

        assertEquals("+3x^2+x+5", r.toString());
    }

    @Test
    public void test_scadere(){
        Polinom p1 = new Polinom("x^2+5");
        Polinom p2 = new Polinom("2x^2+x");
        Polinom r = new Polinom("0");
        Operatii c = new Operatii();

        r = c.scadere(p1,p2);

        assertEquals("-x^2-x+5", r.toString());
    }

    @Test
    public void test_inmultire(){
        Polinom p1 = new Polinom("x^3+1");
        Polinom p2 = new Polinom("-x+2");
        Polinom r = new Polinom("0");
        Operatii c = new Operatii();

        r = c.inmultire(p1,p2);

        assertEquals("-x^4+2x^3-x+2", r.toString());
    }

    @Test
    public void test_impartire(){
        Polinom p1 = new Polinom("x^3-2x^2+6x-5");
        Polinom p2 = new Polinom("x^2-1");
        Polinom rez = new Polinom("");
        Operatii c = new Operatii();

        Polinom[] r = c.impartire(p1,p2);
        String s = r[0].toString() + " R:" + r[1].toString();

        assertEquals("+x-2 R:+7x-7", s);
    }

    @Test
    public void test_derivare(){
        Polinom p1 = new Polinom("x^3-2x^2+6x-5");
        Polinom r = new Polinom("0");
        Operatii c = new Operatii();

        r = c.derivare(p1);

        assertEquals("+3x^2-4x+6", r.toString());
    }

    @Test
    public void test_integrare(){
        Polinom p1 = new Polinom("x^3-2x^2");
        Polinom r = new Polinom("0");
        Operatii c = new Operatii();

        r = c.integrare(p1);

        assertEquals("+0,2x^4-0,7x^3", r.toString());
    }

    @Test
    public void test_verif_date(){
        Polinom p1 = new Polinom("x^3-2x^2");

        assertEquals("+x^3-2x^2", p1.toString());
    }
}
