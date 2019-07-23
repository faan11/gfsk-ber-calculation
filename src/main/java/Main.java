public class Main {
    public static void main(String[] args) {
        /*
            Testing purpose
         */
        Double h = 0.31;
        //do{
        //    h+=0.01;
        for (double SNR = 0; SNR < 21;SNR++){
            System.out.println(SNR+ " "+Math.pow(10,SNR/10)+" "+ GFSKModulation.computeBer(Math.pow(10,SNR/10),h));
        }

        //}while(h<0.5);
    }
}
