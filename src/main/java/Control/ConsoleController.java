package ConsoleController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ConsoleController implements Runnable {
	private volatile boolean isStop = false;
	
	private static final int Q = 0;
	private static final int A = 1;
	private static final int S = 2;
	private static final int J = 3;
	
	private InputStream is;
	private int type;
	
	public ConsoleController(InputStream is, int type){
		this.is = is;
		this.type = type;
	}
	
	@Override
    public void run() {
        // TODO Auto-generated method stub
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        String s;
        try{
            while((!isStop) && (s = reader.readLine()) != null){
                if(s.length() != 0){
                    if(type == Q){
                        System.out.println("钱夫人>"+s);
                    }else if(type == A){
                        System.out.println("阿土伯>"+s);
                    }else if(type == S){
                        System.out.println("孙小美>"+s);
                    }else if(type == J){
                        System.out.println("金贝贝>"+s);
                    }
                }
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }


	public void stop(){
		isStop = true;
	}
	
	public static void main(String[] args) throws IOException,
	InterruptedException {
	// Process child = Runtime.getRuntime().exec("run.bat");
	         Process child = Runtime.getRuntime().exec( " java  " );
	         OutputStream os = child.getOutputStream();
	         InputStream stdin = child.getInputStream(); //
	         InputStream stderr = child.getErrorStream();
	         Thread tIn = new Thread( new ConsoleController(stdin, Q));
	         Thread tErr = new Thread( new ConsoleController(stderr, A));
	         tIn.start();
	         tErr.start();
	         int result = child.waitFor();
	         tIn.join();
	         tErr.join();
	         if (result == 0 ) {
	        	 System.out.println( " SUCCESS! " );
	         } else {
	        	 System.out.println( " FAILED! " );
	         }
	}
}
