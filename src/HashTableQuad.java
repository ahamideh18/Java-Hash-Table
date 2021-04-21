public class HashTableQuad {
	private Integer[] table;
    private int numKeys, size;
    private double lf;
    private int probeNum;
    private int numCol;
    
    public HashTableQuad(int maxNum, double load){
        int primeSize=(int)(maxNum/load); //The minimum size of the hash table of integers if the maximum number of keys divided by the load factor that is a prime number
        while(!this.primeCheck(primeSize)){  //Prime number check
            primeSize++; //Keep incrementing the size until a prime number if sound
        }
        
        table=new Integer[primeSize];  //The size of the table is set to the primeSize that was found
         
        this.size=primeSize; //Instance field size is set to primeSize
        this.numKeys=0; //Number of keys in hash is initially 0
        this.lf=load; //Load factor of the hash table is set to load
    }
    
    public void insert(int n) {
    	int hashVal=n%this.size; //The original index of the hash function
        int probeIndex=n%this.size; //The probe that is increased
        int nextProbe=0; //nextProbe represents i or the probe that is aded after each unsuccessful probr
        
        if(this.numKeys+1>this.size){ //If the hash is full we have to rehash then recall insert()
            this.rehash(); //Calling rehash()
            this.insert(n);  //Calling insert(n) again
        }
        
        else{ 
        	probeNum++;
            while(this.table[probeIndex]!=null){  //If the original hash index is already filled
                if(this.table[probeIndex]==n){  //The element is already in the hash table do nothing
                    return;
                }
                nextProbe++; //Initially increment by 1 because (h(x)=h(x)+i^2) 
                if((hashVal+Math.pow(nextProbe,2))<(this.size-1)){ //If the probe index is less than the size of the hash table
                    probeIndex=(int)(hashVal+Math.pow(nextProbe,2)); //Increase the probe by i^2
                    probeNum++;
                }
                else{
                    probeIndex=(int)(hashVal+Math.pow(nextProbe,2))%this.size; //If h(x)+i^2 is greater than the size of the array then loop around the list
                    probeNum++;
                }
            }
            this.table[probeIndex]=n;  //Insert the element into the hash table after an empty spot is found
            numKeys++; //The number of keys in the hash table is incremented after the insertion
        }
    }
    
    private void rehash(){
        HashTableQuad newHash; 
        newHash=new HashTableQuad(this.size*2, this.lf); //rehash() simply creates a hash table of double the size of the original 
        
        for(int i=0;i<this.size;i++){
            if(this.table[i]!=null){ //Add every element of the original hash to the double-sized hash
                newHash.insert(this.table[i]); //Call insert()
            }
        }
        this.table=newHash.table; //The array of integers is overwritten
        this.size=newHash.size;  //The size of the hash is overwritten
        this.numKeys=newHash.numKeys;  //The number of keys is overwritten
    }
    
    public boolean isIn(int n){
    	int hashIndex=n%this.size;
        int probeIndex=n%this.size;
        int nextProbe=0;
        
        while(this.table[probeIndex]!=null){
            if(this.table[probeIndex]==n){
                return true;
            }
            nextProbe++;
            if((hashIndex+Math.pow(nextProbe,2))<(this.size-1)){
                probeIndex=(int)(hashIndex+Math.pow(nextProbe,2));
            }
            else{
                probeIndex=(int)(hashIndex+Math.pow(nextProbe,2))%this.size;
            }
        }
        return false;
    }
    
    public void printKeys(){
        for(int i=0;i<this.size;i++){  //For loop to iterate increasing index of the hash table
            if(this.table[i]!=null){  //If the location in the index is not null
                System.out.print(this.table[i]+", ");  //Print just the element
            }
        }
    }
    
    public void printKeysAndIndexes(){
        for(int i=0; i<this.size; i++){    //For loop to iterate increasing index of the hash table
            if(this.table[i] != null){  //If the location in the index is not null
                System.out.println("key = " + this.table[i] + "  -- index = " + i);  //Print the element and its index
            }
        }
    }
    
    public double getLoad() {  //Getter for load factor
        return lf;
    }

    public int getSize() {  //Getter for size of hash table 
        return size;
    }

    public int getNumKeys() {  //Getter for number of keys in the hash
        return numKeys;
    }
    
    public int getProbeNums() {
    	return probeNum;
    }
    
    public int getNumCol() {
    	return numCol;
    }
    
    private boolean primeCheck(int n) {
    	int flag=1, temp;
    	for(int i=2;i<=Math.sqrt(n);i++)
    	{
    		temp=n%i;
    		if(temp==0)
    		{
    			flag=0;
    			break;
    		}
    	}
    	return(flag==1?true:false);
    }
}

