package CodeMonk;



import com.sun.imageio.plugins.common.BogusColorSpace;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaimin
 */
public class GoldString {
    
    public static void main(String[] args) throws IOException{
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        
        int t = in.readInt();
        
        BigInteger arr[]=new BigInteger[3501];
		arr[0]=arr[1]=new BigInteger("2");
		for(int i=2;i<3501;i++){
			arr[i]=arr[i-1].multiply(new BigInteger(""+i));
			arr[i]=arr[i].divide(new BigInteger(""+((i+1)/2)));
		}
                
        while(t-->0){
            String s = in.readString();
            int i=0;
            BigInteger num = new BigInteger(s);
            for(;i<3501;i++){
                if(arr[i].equals(num)){
                    break;
                }
            }
            if(i<3501){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        
        System.out.print(sb);
        
    }
    
    static final class InputReader{
        private final InputStream stream;
        private final byte[] buf=new byte[1024];
        private int curChar;
        private int numChars;
        public InputReader(InputStream stream){this.stream=stream;}
        private int read()throws IOException{
            if(curChar>=numChars){
                curChar=0;
                numChars=stream.read(buf);
                if(numChars<=0)
                    return -1;
            }
            return buf[curChar++];
        }
        public final int readInt(){return (int)readLong();}
        public final long readLong(){
            int c = 0;
            try {
                c = read();
            } catch (IOException ex) {}
            while(isSpaceChar(c)){
                try {
                    c=read();
                } catch (IOException ex) {}
                }
            boolean negative=false;
            if(c=='-'){
                negative=true;
                try {
                    c=read();
                } catch (IOException ex) {}
            }
            long res=0;
            do{
                if(c<'0'||c>'9');
                res*=10;
                res+=(c-'0');
                try {
                    c=read();
                } catch (IOException ex) {}
            }while(!isSpaceChar(c));
            return negative?(-res):(res);
        }
        
        public final String readString(){
            int c = 0;
            try {
                c = read();
            } catch (IOException ex) {}
            while(isSpaceChar(c))try {
                c=read();
                } catch (IOException ex) {}
            StringBuilder res=new StringBuilder();
            do{
                res.append((char)c);
                try {
                    c=read();
                } catch (IOException ex) {}
            }while(!isSpaceChar(c));
            return res.toString();
        }
        private boolean isSpaceChar(int c){
            return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
        }
    }
}
