package blockchain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.Serializable;

public class Blockchain implements Serializable {
    private  ArrayList <Block> blockchain = new ArrayList<>();

    public int getHeight() {
        return blockchain.size();
    }

    private int height=0;

    public void addBlock(Block block){
        blockchain.add(block);
    }

    public boolean validateBlockChain(){
        return false;
    }

    public void setBlockchain(ArrayList<Block> blockchain) {
        this.blockchain = blockchain;
    }

    public ArrayList<Block> getBlockchain() {
        return blockchain;
    }

    public String getPrevBlockHash(int height){
        String s="0";
        //Block block=new Block();
        if(!blockchain.isEmpty()&&height>1){
            Block block=blockchain.get(height-2);
            s=block.getBlockHash();
        }
        return s;
    }

    public int getLastInterval(int height){
        int i=0;
        //Block block=new Block();
        if(!blockchain.isEmpty()&&height>1){
            Block block=blockchain.get(height-2);
            i=block.getElapsedTime();
        }
        return i;
    }

    public boolean validate(){
       for(Block block : blockchain){
           String thisBlockPrevHash;
           String previousBlockHash;
           int blockId= (int)block.getId();
           thisBlockPrevHash=block.getPrevBlockHash();
           previousBlockHash=getPrevBlockHash(blockId);
          // System.out.println("this: " + thisBlockPrevHash + "that: " + previousBlockHash);
           if(!thisBlockPrevHash.equals(previousBlockHash))return false;
       }
        return true;
    }

    public void printBlockChain(){
        //Collections.reverse(blockchain);
        for(Block block : blockchain){
            System.out.println("Block:");
            System.out.println("Id: " + block.getId());
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Magic number: " + block.getMagicNumber());
            System.out.println("Hash of the previous block: ");
            System.out.println( block.getPrevBlockHash());
            System.out.println("Hash of the block: ");
            System.out.println(block.getBlockHash());
            System.out.println("Block was generating for " + block.getElapsedTime() + " milliseconds");
            System.out.println("");

        }
    }


}
