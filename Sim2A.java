/* Sim2A.java
 * Purpose: Simulates the A and S allele being passed from one generation to the next, beginning with an equal amount 
 * of each allele. This method simulates environmental conditions where individuals homozygous for the S allele have 
 * a disorder that prevents them from surviving long enough to reproduce.
 */
public class Sim2A {
    
    public static void main(String args[]) {
        //Declares array of booleans representing alleles present. True represents the A allele, while false represents
        //the S allele. Sets first half of array to true and second half to false.
        boolean[] alleles = new boolean[120];
        for (int i = 0; i < 120; i++) {
            if (i < 60) {
                alleles[i] = true;
            }
            else {
                alleles[i] = false;
            }
        }
        
        //Sets initial values for the number of offspring for each genotype.
        int numAA = 0;
        int numAS = 0;
        int numSS = 0;
        
        //Produces 60 offspring using the allele frequency in the parent generation. No individuals with the SS genotype
        //will survive until reproduction.
        for (int i = 0; i < 60; i++) {
            int rand1 = (int)(Math.random() * 120);
            int rand2 = (int)(Math.random() * 120);
            while (rand1 == rand2) {
                rand2 = (int)(Math.random() * 120);
            }
            if (alleles[rand1] && alleles[rand2]) {
                numAA++;
            } else if (!(alleles[rand1]) && !(alleles[rand2])) {
                i--;
            } else {
                numAS++;
            }
        }
        
        //Prints out the number of offspring for each genotype.
        System.out.println("AA: " + numAA);
        System.out.println("AS: " + numAS);
        System.out.println("SS: " + numSS);
    }
}