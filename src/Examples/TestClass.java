
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author jaimin
 */
public class TestClass {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        
        String[] c_c = {"91","81","61","7","78","ab"};
        String[] o_c = {"99","82","98","45","ac"};
        sb.append("100\n");
        
        for(int i=0;i<50;i++){
            for(int j=0;j<100;j++){
                sb.append(c_c[i%6]+" "+o_c[j%5]+randomNum(8)+"\n");
            }
        }
        for(int i=0;i<50;i++){
            for(int j=0;j<100;j++){
                sb.append(c_c[i%6]+" "+o_c[j%5]+randomNum(8)+"\n");
            }
        }
        System.out.print(sb);
    }
       
    

    static String randomNum(int len){
        String num = "0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ ) 
            sb.append( num.charAt( rnd.nextInt(num.length()) ) );
        return sb.toString();
    }
    
    static String randomSt(int len){
        String num = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ ) 
            sb.append( num.charAt( rnd.nextInt(num.length()) ) );
        return sb.toString();
    }

}
    
