package blockchain;
import java.io.*;
import java.util.*;
public class SerialUtil {
    public boolean fileExists(String filename){
        try{
            if(!new File(filename).isFile()){
                //System.out.println(filename + " file not found, sincerely serialutil");
                return false;
            }
        }catch(Exception e){
            System.out.print("e.StackTrace()");
        }
        return true;
    }

    public ArrayList<Block> instream(String filename){
        try{
            if(!fileExists(filename)){
                System.out.println("file not found");
            }else{
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream instr = new ObjectInputStream(file);
                ArrayList<Block> alist = (ArrayList<Block>)instr.readObject();
                instr.close();
                file.close();
                return alist;
            }
        }catch(Exception e){
            System.out.print("Xe.StackTrace()");
        }
        return null;
    }

    public void outstream(String filename,ArrayList<Block> alist){
        try{
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream outstr = new ObjectOutputStream(file);
            outstr.writeObject(alist);
            outstr.close();
            file.close();
        }catch(Exception e){
            System.out.print("Ye.StackTrace()");
        }
    }
}
