package blockchain;
import java.util.Date;
import java.io.Serializable;
public class Block implements Serializable{

    private long blockid;
    private long timestamp;
    private String prevBlockHash;
    private String blockHash;
    private int difficulty;

    public int getElapsedTime() {
        return elapsedTime;
    }

    private int elapsedTime;

    public String getMagicNumber() {
        return magicNumber;
    }

    private String magicNumber;

    public Block(){

    }

    ///genesis block///
    public Block (int iDifficulty,Long id){
        difficulty=iDifficulty;
        blockid=id;                //id
        timestamp=new Date().getTime();   //timestamp
        prevBlockHash="0";                //previous block has3h
        //blockHash=getHash();        //this block hash
        blockHash=getDifficultHash();
        elapsedTime=(int)(new Date().getTime()-timestamp);
    }

    public Block (Long id,String paramPrevBlockHash){
        blockid=id;                //id
        timestamp=new Date().getTime();   //timestamp
        prevBlockHash=paramPrevBlockHash;                //previous block hash
        blockHash=getHash();        //this block hash
    }

    public Block (int iDifficulty,Long id,String paramPrevBlockHash){
        difficulty=iDifficulty;
        blockid=id;                //id
        timestamp=new Date().getTime();   //timestamp
        prevBlockHash=paramPrevBlockHash;                //previous block hash
        blockHash=getDifficultHash();        //this block hash
        elapsedTime=(int)(new Date().getTime()-timestamp);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public long getId() {
        return blockid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getPrevBlockHash() {
        return prevBlockHash;
    }

    public String getBlockHash() {
        return blockHash;
    }

   private String getHash(){
        String blockData=String.valueOf(blockid)+ timestamp + prevBlockHash;
        StringUtil su = new StringUtil();
        String sHash= StringUtil.applySha256(blockData);
        return sHash;
   }

    private String getHashWithDifficulty(){
        String sDifficulty="";
        for(int i=0;i<difficulty;i++){
            sDifficulty=sDifficulty+"0";
            System.out.println(sDifficulty);
        }
        String blockData=String.valueOf(blockid)+ timestamp + prevBlockHash;
        StringUtil su = new StringUtil();
        String sHash= StringUtil.applySha256(blockData);
        return sHash;
    }

    private String getDifficultHash() {
        String sHash="";
        String sDifficulty="";
        for(int i=0;i<difficulty;i++){
            sDifficulty=sDifficulty+"0";
        }
        for(int i=0;i<Integer.MAX_VALUE;i++){
            String I=String.valueOf(i);
            String blockData=String.valueOf(blockid)+ timestamp + I + prevBlockHash;
            StringUtil su = new StringUtil();
            sHash= StringUtil.applySha256(blockData);
            if(sHash.substring(0,difficulty).equals(sDifficulty)){
                magicNumber=I;
               // System.out.println(I);
               // System.out.println(sHash);
               // System.out.println(sHash.charAt(0));
                break;
            }
            if(1>=Integer.MAX_VALUE-1){
                System.out.println("Max Int");
                System.out.println(i);
            }
        }
        return sHash;
    }
}
