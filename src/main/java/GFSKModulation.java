import net.sourceforge.jdistlib.math.Bessel;

class GFSKModulation {

    public Double computeBer(Double SNR,Double h) {
        Double a;
        Double b;
        Double p;
        Double exp;
        p = (Math.sin(2*Math.PI*h))/(2*Math.PI*h);
        a = Math.sqrt((SNR/2)*(1- Math.sqrt(1-(p*p)) ) );
        b = Math.sqrt((SNR/2)*(1+ Math.sqrt(1-(p*p)) ) );
        exp = Math.exp(-SNR/2)*( (0.5*Bessel.i(   a*b,0,false)) + performSeries(a,b));
        return exp;
    }

    private Double performSeries(Double a, Double b) {
        boolean converges = false;
        Double result = 0.0;
        Double prev;
        double k = 0;
        Double percentage = 0.001;
        double prevPerc;
        do{
            k++;
            prev = result;
            result += (Math.pow((a/b),k) * Bessel.i(a*b,k,false));
            // Check convergence.
            prevPerc = ((prev)*percentage)/100;
            converges = ( (result-prev) <= prevPerc);
        }while(!converges);
        return result;
    }
}