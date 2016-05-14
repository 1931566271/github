

public class ScaleUtil
{
    public static final int    SCALE_DECIMAL     = 10;    //十进制
    public static final int    SCALE_HEX         = 16;    //十六进制
    public static final int    SCALE_OCTAL       = 8;     //八进制
    public static final int    SCALE_BINARY      = 2;     //二进制
    public static final String SCALE_DECIMAL_STR = "十进制"; //十进制
    public static final String SCALE_HEX_STR     = "十六进制"; //十六进制
    public static final String SCALE_OCTAL_STR   = "八进制"; //八进制
    public static final String SCALE_BINARY_STR  = "二进制"; //二进制

    /**
     * 十进制-->十六进制
     * 
     * @param decimValue
     * @return String
     */
    public static String decimal2Hex(int decimValue)
    {
        return Integer.toHexString(decimValue);
    }

    /**
     * 十进制-->二进制
     * 
     * @param decimValue
     * @return
     */
    public static String decimal2Binary(int decimValue)
    {
        return Integer.toBinaryString(decimValue);
    }

    /**
     * 十进制-->八进制
     * 
     * @param decimValue
     * @return
     */
    public static String decimal2Octal(int decimValue)
    {
        return Integer.toOctalString(decimValue);
    }

    /**
     * 将任何进制的数转换为十进制整数
     * 
     * @param value
     * @param radix 基数
     * @return
     */
    public static int toDecimal(String value, int radix)
    {
        if (null == value || "".equals(value))
            return 0;
        try
        {
            return Integer.parseInt(value, radix);
        }
        catch (java.lang.NumberFormatException e)
        {

        }
        return 0;
    }

    /**
     * 十进制整数 转换为 任何进制的数
     * 
     * @param decimValue
     * @param radix 表示基数
     * @return
     */
    public static String decimalTo(int decimValue, int radix)
    {
        if (decimValue <= 0)
            return "";
        StringBuffer target = new StringBuffer();
        int digit = dealer(decimValue, radix);
        for (int i = digit; i > 0; i--)
        {
            int j = getDigPosition(decimValue, radix, i - 1);
            target.append(j);
            decimValue -= Math.pow(radix, i - 1) * j;
        }
        return target.toString();
    }

    /**
     * 获得指定数位上的值
     * 
     * @param decimValue
     * @param radix
     * @param pow+1 表示第pow+1位上的值
     * @return
     */
    public static int getDigPosition(int decimValue, int radix, int pow)
    {
        int i = 0;
        while (true)
        {
            if (Math.pow(radix, pow) * i > decimValue)
            {
                break;
            }
            i++;
        }
        return i - 1;
    }

    /**
     * 获得转换后的位数 到底有多少个数位。
     * 
     * @param value
     * @param radix
     * @return
     */
    public static int dealer(int value, int radix)
    {
        int i = 1;
        while (true)
        {
            double power = Math.pow(radix, i);
            if (power > value)
            {
                return i;
            }
            i++;
        }
    }

    /**
     * oldRadix进制的数 转换为 targetRadix进制的数。
     * 
     * @param rawValue
     * @param oldRadix 原来的基数
     * @param targetRadix 转换成功后的基数
     * @return
     */
    public static String scaleConversion(String rawValue, int oldRadix, int targetRadix)
    {
        if (oldRadix == targetRadix || oldRadix <= 0 || targetRadix <= 0)
            return rawValue;
        return decimalTo(toDecimal(rawValue, oldRadix), targetRadix);
    }

    public static void main(String[] args)
    {
        System.out.println(Integer.valueOf("2200", 7).toString());//ouput "1152"
        System.out.println(decimalTo(784, 7));//ouput "2200"
        System.out.println(scaleConversion("123", 2, 0));
    }

}


