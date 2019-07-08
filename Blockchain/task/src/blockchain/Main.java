package blockchain;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //final Scanner scanner=new Scanner(System.in);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter how many zeros the hash must starts with: 3");
        int difficulty = scanner.nextInt();
            Blockchain blockchain = new Blockchain();
            Block block = new Block(difficulty,1L);  //genesis blick
            blockchain.addBlock(block);
            for (int i = 2; i < 6; i++) {
                String s = blockchain.getPrevBlockHash(i);
                if (blockchain.getLastInterval(i) < 10) {
                    difficulty++;
                    System.out.println("added difficulty");
                } else {
                    difficulty--;
                    System.out.println("removed difficulty");
                }
                block = new Block(difficulty, (long) i, s);
                blockchain.addBlock(block);
            }
            //System.out.println(blockchain.validate());
            blockchain.printBlockChain();
    }
}

//public class Main {
//    final static String filename="serial_files/blockchain.ser";
//    public static void main(String[] args) {
//        final Scanner scanner=new Scanner(System.in);
//        final int difficulty = scanner.nextInt();
//        SerialUtil serialUtil=new SerialUtil();
//        if(!serialUtil.fileExists(filename)){
//            //System.out.println("file not found");
//            Blockchain blockchain = new Blockchain();
//            Block block = new Block(difficulty,1L);  //genesis blick
//            blockchain.addBlock(block);
//            for (int i = 2; i < 6; i++) {
//                String s = blockchain.getPrevBlockHash(i);
//                block = new Block(difficulty,(long) i, s);
//                blockchain.addBlock(block);
//            }
//            //System.out.println(blockchain.validate());
//            blockchain.printBlockChain();
//            serialUtil.outstream(filename,blockchain.getBlockchain());
//        }else {
//            System.out.println("file found");
//            Blockchain blockchain = new Blockchain();
//            ArrayList<Block> bkchain = (ArrayList<Block>) serialUtil.instream(filename);
//            blockchain.setBlockchain(bkchain);
//            int height = blockchain.getHeight();
//            for (int i = height+1; i < height+5; i++) {
//                String s = blockchain.getPrevBlockHash(i);
//               Block block = new Block(difficulty,(long) i, s);
//                blockchain.addBlock(block);
//            }
//            //System.out.println(blockchain.validate());
//            blockchain.printBlockChain();
//            serialUtil.outstream(filename,blockchain.getBlockchain());
//        }
//    }
//}