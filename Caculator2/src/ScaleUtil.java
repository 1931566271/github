

public class ScaleUtil
{
    public static final int    SCALE_DECIMAL     = 10;    //ʮ����
    public static final int    SCALE_HEX         = 16;    //ʮ������
    public static final int    SCALE_OCTAL       = 8;     //�˽���
    public static final int    SCALE_BINARY      = 2;     //������
    public static final String SCALE_DECIMAL_STR = "ʮ����"; //ʮ����
    public static final String SCALE_HEX_STR     = "ʮ������"; //ʮ������
    public static final String SCALE_OCTAL_STR   = "�˽���"; //�˽���
    public static final String SCALE_BINARY_STR  = "������"; //������

    /**
     * ʮ����-->ʮ������
     * 
     * @param decimValue
     * @return String
     */
    public static String decimal2Hex(int decimValue)
    {
        return Integer.toHexString(decimValue);
    }

    /**
     * ʮ����-->������
     * 
     * @param decimValue
     * @return
     */
    public static String decimal2Binary(int decimValue)
    {
        return Integer.toBinaryString(decimValue);
    }

    /**
     * ʮ����-->�˽���
     * 
     * @param decimValue
     * @return
     */
    public static String decimal2Octal(int decimValue)
    {
        return Integer.toOctalString(decimValue);
    }

    /**
     * ���κν��Ƶ���ת��Ϊʮ��������
     * 
     * @param value
     * @param radix ����
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
     * ʮ�������� ת��Ϊ �κν��Ƶ���
     * 
     * @param decimValue
     * @param radix ��ʾ����
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
     * ���ָ����λ�ϵ�ֵ
     * 
     * @param decimValue
     * @param radix
     * @param pow+1 ��ʾ��pow+1λ�ϵ�ֵ
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
     * ���ת�����λ�� �����ж��ٸ���λ��
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
     * oldRadix���Ƶ��� ת��Ϊ targetRadix���Ƶ�����
     * 
     * @param rawValue
     * @param oldRadix ԭ���Ļ���
     * @param targetRadix ת���ɹ���Ļ���
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


