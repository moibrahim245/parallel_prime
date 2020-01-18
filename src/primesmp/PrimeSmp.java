/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primesmp;

import edu.rit.pj2.Loop;
import edu.rit.pj2.Task;

/**
 *
 * @author Mohamed & Alaa
 */
public class PrimeSmp extends Task {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    @Override
    public void main(final String[] args) throws Exception {
        // TODO code application logic here
        if (args.length < 1) {
            usage();
        }
        long startTime=System.nanoTime();
        parallelFor(0, args.length - 1).exec(new Loop() {

            @Override
            public void run(int i) throws Exception {
                if (isPrime(Long.parseLong(args[i]))) {
                    System.out.printf("the number %s is prime%n", args[i]);
                }
            }

        });
        long finishTime=System.nanoTime();
        System.out.println("dauration : "+((finishTime-startTime)/1000000)+" ms");
    }

    private static boolean isPrime(long x) {
        if (x % 2 == 0) {
            return false;
        }
        long p = 3;
        long psqr = p * p;
        while (psqr <= x) {
            if (x % p == 0) return false;
            p+=2;
            psqr = p*p; 
        }
        return true;
    }

    private void usage() {
        throw new IllegalArgumentException();
    }

}
