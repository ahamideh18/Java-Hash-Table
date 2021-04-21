public class HashTableLin {
	private Integer[] table;
    private int numKeys, size;
    private double lf;
    private int probeNum=0;
    private int numCol;
    
    public HashTableLin(int maxNum, double load){
    	int primeSize=(int)(maxNum/load);  //The minimum size is the first prime number after maxSize/load factor
        while(!this.primeCheck(primeSize)){ //The minimum size of the table must be a prime number
            primeSize++; //iterate until a prime number is found
        }
        
        table=new Integer[primeSize];  //A new table of size primeSize is initialized
        
        this.size=primeSize;
        this.numKeys=0; //The initial number of keys in the array is 0
        this.lf=load;  //The load factor is set to load
    }
    
    public void insert(int n) {  //Theta(n) run-time and Theta(1) space complexity
    	int hashVal=n%this.size; //The hash function is x%size
        
        if((double) numKeys/size>=lf){ //If the hash table is full
            this.rehash(); //Call the rehash() function
            this.insert(n); //Call insert again after the size of the array has been doubled
        }
        else{
        	probeNum++;
            while(this.table[hashVal]!=null){ //Probe until empty location is found
            	numCol++;
                if(this.table[hashVal]==n){  //If element is already in table do nothing
                    return;
                }
                if(hashVal<this.size-1){  //Linear probing begins here; If while linear probing the index is in the range of the size of the array
                    hashVal++;  //In linear probing the probe increases by 1 each time
                	probeNum++;
                }
                else{ //If the index of the hash is outside the range of the size of the array insert at 0
                    hashVal=0;
                	probeNum++;
                }
            }
            this.table[hashVal]=n; //Insert the key at the index afer linear probing is complete
            numKeys++;  //the number of keys in the array also increases
        }
    }
    
    private void rehash(){ //Theta(n) run-time
        HashTableLin newHash; 
        newHash=new HashTableLin(this.size*2, this.lf);  //rehash() simply creates a hash table of double the size of the original 
        
        for(int i=0;i<this.size;i++){
            if(this.table[i]!=null){  //Add every element of the original hash to the double-sized hash
                newHash.insert(this.table[i]); //Call insert()
            }
        }
        this.table=newHash.table; //The array of integers is overwritten
        this.size=newHash.size; //The size of the hash is overwritten
        this.numKeys=newHash.numKeys;   //The number of keys is overwritten
    }
    
    public boolean isIn(int n){ //Theta(n) run-time
        int initHashCheck=n%this.size;  //The first hash index to check is the original result of the hash function before probing
        
        while(this.table[initHashCheck]!=null){
            if(this.table[initHashCheck]==n){  //If the item is found return true
                return true;
            }
            if(initHashCheck<(this.size-1)){  //If the hash index is within the range of the size linear probe until it is found
            	initHashCheck++;
            }
            else { //If the hash index is not within the range of the size of the table check at index 0
            	initHashCheck=0;
            }
        }
        return false;  //If not found return 0
    }
    
    public void printKeys(){
        for(int i=0;i<this.size;i++){ //For loop to iterate increasing index of the hash table
            if(this.table[i]!=null){  //If the location in the index is not null
                System.out.print(this.table[i]+", "); //Print just the element
            }
        }
    }
    
    public void printKeysAndIndexes(){
        for(int i=0; i<this.size; i++){ //For loop to iterate increasing index of the hash table
            if(this.table[i] != null){  //If the location in the index is not null
                System.out.println("key = " + this.table[i] + "  -- index = " + i); //Print the element and its index
            }
        }
    }
    
    public double getLoad() { //Get the load factor
        return lf;
    }

    public int getSize() {  //Get the size of the hash table
        return size;
    }

    public int getNumKeys() { //Get the number of keys in the hash table
        return numKeys;
    }
    
    public int getProbeNums() {
    	return probeNum;
    }
    
    public int getNumCol() {
    	return numCol;
    }
    
    private boolean primeCheck(int n) {  //Function to check whther number is prime or not
    	int flag=1, temp;
    	for(int i=2;i<=n/2;i++) //Only have to check until the integer divided by 2
    	{
    		temp=n%i;  
    		if(temp==0) //If the integer divided by i has a modulus of 0 (no remainder) then it is not prime
    		{
    			flag=0; //Set flag as 0
    			break;
    		}
    	}
    	return(flag==1?true:false); //Return true only if flag==1 or the intger is prime
    }
}
