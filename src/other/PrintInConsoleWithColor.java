package other;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-3-1
 * Time: 下午12:54
 * To change this template use File | Settings | File Templates.
 */
public class PrintInConsoleWithColor {
    public interface CLibrary extends Library
    {
        CLibrary Instance=(CLibrary) Native.loadLibrary("PrintfWithColorDll", CLibrary.class);
        int printfc(int color,String b);         //0为默认颜色，1为蓝色，2为绿色，3为红色；
    }


}
