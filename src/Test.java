import java.util.Random;
public class Test {
    public static void main(String[] args) {
    	HashTableLin h1=new HashTableLin(5, 0.4);
            
    	System.out.println("-------------------Linear Probing Hash:-----------------");
            
		h1.insert(0);
		h1.insert(13);
		h1.insert(26);
		h1.insert(14);
		h1.insert(63);


		System.out.println("--------------------Print Tests----------------");
		h1.printKeys();
		System.out.println("\n");

		h1.printKeysAndIndexes();
		System.out.println("\n");
		System.out.println("-------------------isIn() Tests-----------------");

		System.out.println("isIn(20) - True");
		System.out.println(h1.isIn(20));
		System.out.println("isIn(91) - True");
		System.out.println(h1.isIn(91));
		System.out.println("isIn(86) - False");
		System.out.println(h1.isIn(86));
		System.out.println("isIn(7) - True");
		System.out.println(h1.isIn(7));

		System.out.println("\n");
		System.out.println("-------------------Getters Tests-----------------");
		System.out.println("h1 Number of Keys:");
		System.out.println(h1.getNumKeys());

		System.out.println("h1 Hash Table Size:");
		System.out.println(h1.getSize());

		System.out.println("h1 Hash Table Load Factor:");
		System.out.println(h1.getLoad());
		
		System.out.println("h1 Hash Table Number of Collisions:");
		System.out.println(h1.getNumCol());

		System.out.println("\n");
		System.out.println("-------------------Quadratic Probing Hash:-----------------");

		HashTableQuad h2 = new HashTableQuad(5, 0.4);

		h2.insert(0);
		h2.insert(13);
		h2.insert(26);
		h2.insert(76);
		h2.insert(26);

		System.out.println("--------------------Print Tests----------------");
		h2.printKeys();
		System.out.println("\n");

		h2.printKeysAndIndexes();
		System.out.println("\n");
		System.out.println("-------------------isIn() Tests-----------------");

		System.out.println("isIn(6) - True");
		System.out.println(h2.isIn(6));
		System.out.println("isIn(19) - True");
		System.out.println(h2.isIn(19));
		System.out.println("isIn(86) - False");
		System.out.println(h2.isIn(86));
		System.out.println("isIn(45) - False");
		System.out.println(h2.isIn(45));
		System.out.println("isIn(104) - True");
		System.out.println(h2.isIn(104));

		System.out.println("\n");
		System.out.println("-------------------Getters Tests-----------------");
		System.out.println("h2 Number of Keys:");
		System.out.println(h2.getNumKeys());

		System.out.println("h2 Hash Table Size:");
		System.out.println(h2.getSize());

		System.out.println("h2 Hash Table Load Factor:");
		System.out.println(h2.getLoad());
		
		System.out.println("h2 Hash Table Number of Collisions:");
		System.out.println(h2.getNumCol());
		

		System.out.println("\n");
		System.out.println("Average Linear Probes (Experimental): ");
		linProbesTest();
		System.out.println("\n");
		System.out.println("Average Quadratic Probes (Experimental): ");
		quadProbesTest();
	}
    
    static double linProbesTest(){
        double avg1=0, avg2=0, avg3=0, avg4=0, avg5=0, avg6=0, avg7=0, avg8=0, avg9=0;
        Random rand = new Random();
        
        HashTableLin testTable1,testTable2,testTable3,testTable4,testTable5,testTable6,testTable7,testTable8,testTable9;
        
        //0.1
        for(int i=0; i<100; i++){
            testTable1 = new HashTableLin(100000, 0.1);
            testTable2 = new HashTableLin(100000, 0.2);
            testTable3 = new HashTableLin(100000, 0.3);
            testTable4 = new HashTableLin(100000, 0.4);
            testTable5 = new HashTableLin(100000, 0.5);
            testTable6 = new HashTableLin(100000, 0.6);
            testTable7 = new HashTableLin(100000, 0.7);
            testTable8 = new HashTableLin(100000, 0.8);
            testTable9 = new HashTableLin(100000, 0.9);
            for(int j=0; j<100000; j++){
                testTable1.insert(rand.nextInt(2147483647));
                testTable2.insert(rand.nextInt(2147483647));
                testTable3.insert(rand.nextInt(2147483647));
                testTable4.insert(rand.nextInt(2147483647));
                testTable5.insert(rand.nextInt(2147483647));
                testTable6.insert(rand.nextInt(2147483647));
                testTable7.insert(rand.nextInt(2147483647));
                testTable8.insert(rand.nextInt(2147483647));
                testTable9.insert(rand.nextInt(2147483647));
            }
            avg1+=testTable1.getProbeNums();
            avg2+=testTable2.getProbeNums();
            avg3+=testTable3.getProbeNums();
            avg4+=testTable4.getProbeNums();
            avg5+=testTable5.getProbeNums();
            avg6+=testTable6.getProbeNums();
            avg7+=testTable7.getProbeNums();
            avg8+=testTable8.getProbeNums();
            avg9+=testTable9.getProbeNums();
            
        }
        avg1=avg1/(100*100000);avg2=avg2/(100*100000);avg3=avg3/(100*100000);avg4=avg4/(100*100000);avg5=avg5/(100*100000);avg6=avg6/(100*100000);avg7=avg7/(100*100000);avg8=avg8/(100*100000);avg9=avg9/(100*100000);
        System.out.println("0.1: " + avg1 + "; 0.2: " + avg2 + "; 0.3: " + avg3 + "; 0.4: " + avg4 + "; 0.5: " + avg5 + "; 0.6: " + avg6 + "; 0.7: " + avg7 + "; 0.8: " + avg8 + "; 0.9: " + avg9);
        return (avg1 + avg2 + avg3 + avg4 + avg5 + avg6 + avg7 + avg8 + avg9)/9;
    }
    
    static double quadProbesTest(){
        double avg1=0, avg2=0, avg3=0, avg4=0, avg5=0, avg6=0, avg7=0, avg8=0, avg9=0;
        Random rand = new Random();
        
        HashTableQuad testTable1,testTable2,testTable3,testTable4,testTable5,testTable6,testTable7,testTable8,testTable9;
        
        //0.1
        for(int i=0; i<100; i++){
            testTable1 = new HashTableQuad(100000, 0.1);
            testTable2 = new HashTableQuad(100000, 0.2);
            testTable3 = new HashTableQuad(100000, 0.3);
            testTable4 = new HashTableQuad(100000, 0.4);
            testTable5 = new HashTableQuad(100000, 0.5);
            testTable6 = new HashTableQuad(100000, 0.6);
            testTable7 = new HashTableQuad(100000, 0.7);
            testTable8 = new HashTableQuad(100000, 0.8);
            testTable9 = new HashTableQuad(100000, 0.9);
            for(int j=0; j<100000; j++){
                testTable1.insert(rand.nextInt(2147483647));
                testTable2.insert(rand.nextInt(2147483647));
                testTable3.insert(rand.nextInt(2147483647));
                testTable4.insert(rand.nextInt(2147483647));
                testTable5.insert(rand.nextInt(2147483647));
                testTable6.insert(rand.nextInt(2147483647));
                testTable7.insert(rand.nextInt(2147483647));
                testTable8.insert(rand.nextInt(2147483647));
                testTable9.insert(rand.nextInt(2147483647));
            }
            avg1+=testTable1.getProbeNums();
            avg2+=testTable2.getProbeNums();
            avg3+=testTable3.getProbeNums();
            avg4+=testTable4.getProbeNums();
            avg5+=testTable5.getProbeNums();
            avg6+=testTable6.getProbeNums();
            avg7+=testTable7.getProbeNums();
            avg8+=testTable8.getProbeNums();
            avg9+=testTable9.getProbeNums();
            
        }
        avg1=avg1/(100*100000);avg2=avg2/(100*100000);avg3=avg3/(100*100000);avg4=avg4/(100*100000);avg5=avg5/(100*100000);avg6=avg6/(100*100000);avg7=avg7/(100*100000);avg8=avg8/(100*100000);avg9=avg9/(100*100000);
        System.out.println("0.1: " + avg1 + "; 0.2: " + avg2 + "; 0.3: " + avg3 + "; 0.4: " + avg4 + "; 0.5: " + avg5 + "; 0.6: " + avg6 + "; 0.7: " + avg7 + "; 0.8: " + avg8 + "; 0.9: " + avg9);
        return (avg1 + avg2 + avg3 + avg4 + avg5 + avg6 + avg7 + avg8 + avg9)/9;
    }
}