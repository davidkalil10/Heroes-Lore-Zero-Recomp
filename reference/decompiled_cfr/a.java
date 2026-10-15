/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.midlet.MIDlet
 */
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;
import javax.microedition.midlet.MIDlet;

public final class a {
    private static Hashtable var_java_util_Hashtable_a;
    private static String[][] var_java_lang_String_arr_arr_a;
    private static String[][] var_java_lang_String_arr_arr_b;
    private static String[][] var_java_lang_String_arr_arr_c;
    private static String[][] var_java_lang_String_arr_arr_d;
    private static String var_java_lang_String_a;
    private static String var_java_lang_String_b;
    private static String var_java_lang_String_c;
    private static String var_java_lang_String_d;
    private static String e;
    private static int[] var_int_arr_a;
    private static int var_int_a;
    private static int[][] var_int_arr_arr_a;

    static {
        var_java_util_Hashtable_a = new Hashtable();
        var_java_lang_String_arr_arr_a = new String[2][];
        var_java_lang_String_arr_arr_b = new String[2][];
        var_java_lang_String_arr_arr_c = new String[1][];
        var_java_lang_String_arr_arr_d = new String[1][];
        var_java_lang_String_a = "Fr";
        var_java_lang_String_b = "Sec";
        var_java_lang_String_c = "N7610";
        var_java_lang_String_d = "Idx";
        e = "0";
        var_int_arr_a = new int[3];
        var_int_a = 0;
        var_int_arr_arr_a = new int[2][];
    }

    public a(MIDlet mIDlet) {
        this.a(mIDlet);
    }

    private static final String[] a(String string, String string2) {
        int n2;
        if (string == null) {
            System.out.println(" split. aStr == null");
            return null;
        }
        if (string.length() <= 0 || string2 == null) {
            return new String[]{string};
        }
        if (string2.length() <= 0) {
            return new String[]{string};
        }
        String[] stringArray = null;
        String string3 = string;
        int[] nArray = new int[string3.length()];
        int[] nArray2 = new int[string3.length()];
        int n3 = 0;
        boolean bl2 = false;
        int n4 = 0;
        do {
            n2 = 0;
            int n5 = n4 + string2.length();
            if (n5 <= string3.length() && string3.substring(n4, n5).equals(string2)) {
                n2 = 1;
            }
            if (n2 != 0) {
                if (bl2) {
                    bl2 = false;
                    nArray2[n3++] = n4;
                }
                n4 = n5;
                continue;
            }
            if (!bl2) {
                bl2 = true;
                nArray[n3] = n4;
            }
            ++n4;
        } while (n4 < string3.length());
        if (bl2) {
            nArray2[n3++] = string3.length();
        }
        if (n3 > 0) {
            stringArray = new String[n3];
            n2 = 0;
            while (n2 < n3) {
                stringArray[n2] = string.substring(nArray[n2], nArray2[n2]);
                ++n2;
            }
        }
        return stringArray;
    }

    private static final String java_lang_String_a(String string) {
        if (string == null || string.length() < 32) {
            System.out.println("des. aStr ==null or aStr length < 32");
            return null;
        }
        try {
            Object object = new bf();
            ((bf)object).byte_arr_a("a4s3d5f1");
            object = ((bf)object).java_lang_String_a(string.substring(0, string.length() - 32));
            int n2 = 0;
            int n3 = 0;
            while (n3 < ((String)object).length()) {
                if (!(((String)object).charAt(n3) >= 'a' && ((String)object).charAt(n3) <= 'z' || ((String)object).charAt(n3) >= 'A' && ((String)object).charAt(n3) <= 'Z' || ((String)object).charAt(n3) >= '0' && ((String)object).charAt(n3) <= '9' || ((String)object).charAt(n3) == ';' || ((String)object).charAt(n3) == ',')) {
                    n2 = n3;
                    break;
                }
                ++n3;
            }
            object = ((String)object).substring(0, n2);
            if (new bg().a((String)object).equals(string.substring(string.length() - 32))) {
                return object;
            }
            return null;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return null;
        }
    }

    private static int int_a(String object) {
        int n2 = 0;
        try {
            n2 = Integer.parseInt((String)object);
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
        }
        return n2;
    }

    private static String a(byte[] byArray) {
        String string;
        try {
            string = new String(byArray, "utf-8");
        }
        catch (Exception exception) {
            try {
                string = new String(byArray, "UTF-8");
            }
            catch (Exception exception2) {
                string = new String(byArray);
            }
        }
        return string;
    }

    private static String[] a(int n2, String object) {
        try {
            if (var_java_util_Hashtable_a.isEmpty()) {
                System.out.println("is empty");
            }
            if (var_java_util_Hashtable_a.containsKey(object)) {
                object = (Vector)var_java_util_Hashtable_a.get(object);
                if (n2 >= 0 && n2 < ((Vector)object).size()) {
                    return (String[])((Vector)object).elementAt(n2);
                }
                return null;
            }
            return null;
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
            return null;
        }
    }

    private void void_a() {
        InputStream inputStream = new Object().getClass().getResourceAsStream("/cpid.txt");
        if (inputStream != null) {
            try {
                try {
                    Object object = new byte[inputStream.available()];
                    inputStream.read((byte[])object);
                    object = a.a(object);
                    System.out.println("cpidListStr=" + (String)object);
                    object = a.a((String)object, "\n");
                    System.out.println("splitArray.length=" + (object != null ? ((byte[])object).length : 0));
                    int n2 = 0;
                    while (n2 < (object != null ? ((byte[])object).length : 0)) {
                        String[] stringArray = a.a((String)object[n2], ",");
                        System.out.println("lineArray=" + stringArray.length);
                        System.out.println("lineArray[0]=" + stringArray[0]);
                        System.out.println("lineArray[1]=" + stringArray[1]);
                        System.out.println("lineArray[2]=" + stringArray[2].length() + "," + stringArray[2].trim().length());
                        String string = stringArray[0].trim();
                        Object object2 = a.java_lang_String_a(stringArray[1].trim());
                        String string2 = a.java_lang_String_a(stringArray[2].trim());
                        stringArray = new String[]{object2, string2};
                        System.out.println("cpid=" + string + ",code=" + (String)object2 + ",dest=" + string2);
                        if (!var_java_util_Hashtable_a.containsKey(string)) {
                            object2 = new Vector<String[]>();
                            ((Vector)object2).addElement(stringArray);
                            var_java_util_Hashtable_a.put(string, object2);
                            System.out.println("put.cpid=" + string + ",CodeDestV.size()=" + ((Vector)object2).size());
                        } else {
                            object2 = (Vector)var_java_util_Hashtable_a.get(string);
                            System.out.println("old.size()=" + ((Vector)object2).size());
                            ((Vector)object2).addElement(stringArray);
                            System.out.println("old.size.2()=" + ((Vector)object2).size());
                            var_java_util_Hashtable_a.remove(string);
                            var_java_util_Hashtable_a.put(string, object2);
                            System.out.println("put.cpid=" + string + ",old.size()=" + ((Vector)object2).size());
                            System.out.println("cpid=" + string + ",cpidHashtable=" + ((Vector)var_java_util_Hashtable_a.get(string)).size());
                        }
                        ++n2;
                    }
                }
                catch (Exception exception) {
                    Exception exception2 = exception;
                    exception.printStackTrace();
                    try {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return;
                    }
                    catch (Exception exception3) {
                        return;
                    }
                }
            }
            catch (Throwable throwable) {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
                catch (Exception exception) {}
                throw throwable;
            }
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                return;
            }
            catch (Exception exception) {}
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void a(MIDlet var1_1) {
        block55: {
            try {
                try {
                    var2_3 /* !! */  = var1_1 /* !! */ .getAppProperty("ChannelFirst");
                    if (var2_3 /* !! */  != null) {
                        a.var_java_lang_String_a = var2_3 /* !! */ ;
                    }
                    if ((var2_3 /* !! */  = var1_1 /* !! */ .getAppProperty("ChannelSecond")) != null) {
                        a.var_java_lang_String_b = var2_3 /* !! */ ;
                    }
                    if ((var2_3 /* !! */  = var1_1 /* !! */ .getAppProperty("InterChannel")) != null) {
                        a.var_java_lang_String_d = var2_3 /* !! */ ;
                    }
                    if ((var2_3 /* !! */  = var1_1 /* !! */ .getAppProperty("Term")) != null) {
                        a.var_java_lang_String_c = var2_3 /* !! */ ;
                    }
                    if ((var2_3 /* !! */  = var1_1 /* !! */ .getAppProperty("QQ")) != null) {
                        a.e = var2_3 /* !! */ ;
                    }
                    var1_1 /* !! */ .getAppProperty("GameCenterName");
                    var1_1 /* !! */ .getAppProperty("GameCenterUrl");
                    a.java_lang_String_a(var1_1 /* !! */ .getAppProperty("FreeCode"));
                    a.java_lang_String_a(var1_1 /* !! */ .getAppProperty("FreeDest"));
                    var2_3 /* !! */  = a.java_lang_String_a(var1_1 /* !! */ .getAppProperty("SmsCode1"));
                    var3_8 = a.java_lang_String_a(var1_1 /* !! */ .getAppProperty("SmsCode2"));
                    var4_14 = a.java_lang_String_a(var1_1 /* !! */ .getAppProperty("SmsDest1"));
                    var5_15 = a.java_lang_String_a(var1_1 /* !! */ .getAppProperty("SmsDest2"));
                    a.var_java_lang_String_arr_arr_a[0] = a.a((String)var2_3 /* !! */ , ";");
                    a.var_java_lang_String_arr_arr_a[1] = a.a(var3_8, ";");
                    a.var_java_lang_String_arr_arr_b[0] = a.a(var4_14, ";");
                    a.var_java_lang_String_arr_arr_b[1] = a.a(var5_15, ";");
                    var2_3 /* !! */  = var1_1 /* !! */ .getAppProperty("LogoLinkReco");
                    var2_3 /* !! */  = a.a((String)var2_3 /* !! */ , ";");
                    var3_9 = 0;
                    if (true) ** GOTO lbl37
                    do {
                        a.var_int_arr_a[var3_9] = a.int_a(var2_3 /* !! */ [var3_9]);
                        ++var3_9;
lbl37:
                        // 2 sources

                        if (var2_3 /* !! */  != null) {
                            if (var2_3 /* !! */ .length > 3) {
                                v0 = 3;
                                continue;
                            }
                            v0 = var2_3 /* !! */ .length;
                            continue;
                        }
                        v0 = 0;
                    } while (var3_9 < v0);
                    var3_10 = var1_1 /* !! */ .getAppProperty("FeeMode");
                    if (var3_10 != null) {
                        a.var_int_a = a.int_a(var3_10);
                    }
                    var2_3 /* !! */  = a.java_lang_String_a(var1_1 /* !! */ .getAppProperty("DoCode"));
                    var1_1 /* !! */  = a.java_lang_String_a(var1_1 /* !! */ .getAppProperty("DoDest"));
                    a.var_java_lang_String_arr_arr_c[0] = a.a((String)var2_3 /* !! */ , ";");
                    a.var_java_lang_String_arr_arr_d[0] = a.a((String)var1_1 /* !! */ , ";");
                    break block55;
                }
                catch (NullPointerException v1) {
                    var2_4 = v1;
                    v1.printStackTrace();
                    var2_5 = 1;
                    if (a.var_java_lang_String_arr_arr_a[0] == null || a.var_java_lang_String_arr_arr_b[0] == null) {
                        var2_5 = 0;
                    } else if (a.var_java_lang_String_arr_arr_a[0].length != a.var_java_lang_String_arr_arr_b[0].length) {
                        var2_5 = 0;
                    }
                    if (var2_5 == 0) {
                        a.var_java_lang_String_arr_arr_a[0] = null;
                        a.var_java_lang_String_arr_arr_b[0] = null;
                        a.var_java_lang_String_arr_arr_a[0] = new String[2];
                        a.var_java_lang_String_arr_arr_b[0] = new String[2];
                        a.var_java_lang_String_arr_arr_a[0][0] = "62";
                        a.var_java_lang_String_arr_arr_a[0][1] = "63";
                        a.var_java_lang_String_arr_arr_b[0][0] = "106662267";
                        a.var_java_lang_String_arr_arr_b[0][1] = "106662269";
                    }
                    var2_5 = 1;
                    if (a.var_java_lang_String_arr_arr_a[1] == null || a.var_java_lang_String_arr_arr_b[1] == null) {
                        var2_5 = 0;
                    } else if (a.var_java_lang_String_arr_arr_a[1].length != a.var_java_lang_String_arr_arr_b[1].length) {
                        var2_5 = 0;
                    }
                    if (var2_5 == 0) {
                        a.var_java_lang_String_arr_arr_a[1] = null;
                        a.var_java_lang_String_arr_arr_b[1] = null;
                        a.var_java_lang_String_arr_arr_a[1] = new String[1];
                        a.var_java_lang_String_arr_arr_b[1] = new String[1];
                        a.var_java_lang_String_arr_arr_a[1][0] = "JG";
                        a.var_java_lang_String_arr_arr_b[1][0] = "1066170073";
                    }
                    var2_5 = 1;
                    if (a.var_java_lang_String_arr_arr_c[0] == null || a.var_java_lang_String_arr_arr_d[0] == null) {
                        var2_5 = 0;
                    } else if (a.var_java_lang_String_arr_arr_c[0].length != a.var_java_lang_String_arr_arr_d[0].length) {
                        var2_5 = 0;
                    }
                    if (var2_5 == 0) {
                        a.var_java_lang_String_arr_arr_c[0] = null;
                        a.var_java_lang_String_arr_arr_d[0] = null;
                        this.void_a();
                    }
                    var2_5 = 0;
                    ** while (var2_5 < 2)
                }
            }
            catch (Throwable var1_2) {
                var2_6 = 1;
                if (a.var_java_lang_String_arr_arr_a[0] == null || a.var_java_lang_String_arr_arr_b[0] == null) {
                    var2_6 = 0;
                } else if (a.var_java_lang_String_arr_arr_a[0].length != a.var_java_lang_String_arr_arr_b[0].length) {
                    var2_6 = 0;
                }
                if (var2_6 == 0) {
                    a.var_java_lang_String_arr_arr_a[0] = null;
                    a.var_java_lang_String_arr_arr_b[0] = null;
                    a.var_java_lang_String_arr_arr_a[0] = new String[2];
                    a.var_java_lang_String_arr_arr_b[0] = new String[2];
                    a.var_java_lang_String_arr_arr_a[0][0] = "62";
                    a.var_java_lang_String_arr_arr_a[0][1] = "63";
                    a.var_java_lang_String_arr_arr_b[0][0] = "106662267";
                    a.var_java_lang_String_arr_arr_b[0][1] = "106662269";
                }
                var2_6 = 1;
                if (a.var_java_lang_String_arr_arr_a[1] == null || a.var_java_lang_String_arr_arr_b[1] == null) {
                    var2_6 = 0;
                } else if (a.var_java_lang_String_arr_arr_a[1].length != a.var_java_lang_String_arr_arr_b[1].length) {
                    var2_6 = 0;
                }
                if (var2_6 == 0) {
                    a.var_java_lang_String_arr_arr_a[1] = null;
                    a.var_java_lang_String_arr_arr_b[1] = null;
                    a.var_java_lang_String_arr_arr_a[1] = new String[1];
                    a.var_java_lang_String_arr_arr_b[1] = new String[1];
                    a.var_java_lang_String_arr_arr_a[1][0] = "JG";
                    a.var_java_lang_String_arr_arr_b[1][0] = "1066170073";
                }
                var2_6 = 1;
                if (a.var_java_lang_String_arr_arr_c[0] == null || a.var_java_lang_String_arr_arr_d[0] == null) {
                    var2_6 = 0;
                } else if (a.var_java_lang_String_arr_arr_c[0].length != a.var_java_lang_String_arr_arr_d[0].length) {
                    var2_6 = 0;
                }
                if (var2_6 == 0) {
                    a.var_java_lang_String_arr_arr_c[0] = null;
                    a.var_java_lang_String_arr_arr_d[0] = null;
                    this.void_a();
                }
                var2_6 = 0;
                ** while (var2_6 < 2)
            }
lbl-1000:
            // 1 sources

            {
                a.var_int_arr_arr_a[var2_5] = new int[a.var_java_lang_String_arr_arr_a[var2_5].length];
                var3_11 = 0;
                while (var3_11 < a.var_java_lang_String_arr_arr_a[var2_5].length) {
                    a.var_int_arr_arr_a[var2_5][var3_11] = 0;
                    ++var3_11;
                }
                ++var2_5;
                continue;
            }
lbl104:
            // 1 sources

            return;
lbl-1000:
            // 1 sources

            {
                a.var_int_arr_arr_a[var2_6] = new int[a.var_java_lang_String_arr_arr_a[var2_6].length];
                var3_12 = 0;
                while (var3_12 < a.var_java_lang_String_arr_arr_a[var2_6].length) {
                    a.var_int_arr_arr_a[var2_6][var3_12] = 0;
                    ++var3_12;
                }
                ++var2_6;
                continue;
            }
lbl154:
            // 1 sources

            throw var1_2;
        }
        var2_7 = 1;
        if (a.var_java_lang_String_arr_arr_a[0] == null || a.var_java_lang_String_arr_arr_b[0] == null) {
            var2_7 = 0;
        } else if (a.var_java_lang_String_arr_arr_a[0].length != a.var_java_lang_String_arr_arr_b[0].length) {
            var2_7 = 0;
        }
        if (var2_7 == 0) {
            a.var_java_lang_String_arr_arr_a[0] = null;
            a.var_java_lang_String_arr_arr_b[0] = null;
            a.var_java_lang_String_arr_arr_a[0] = new String[2];
            a.var_java_lang_String_arr_arr_b[0] = new String[2];
            a.var_java_lang_String_arr_arr_a[0][0] = "62";
            a.var_java_lang_String_arr_arr_a[0][1] = "63";
            a.var_java_lang_String_arr_arr_b[0][0] = "106662267";
            a.var_java_lang_String_arr_arr_b[0][1] = "106662269";
        }
        var2_7 = 1;
        if (a.var_java_lang_String_arr_arr_a[1] == null || a.var_java_lang_String_arr_arr_b[1] == null) {
            var2_7 = 0;
        } else if (a.var_java_lang_String_arr_arr_a[1].length != a.var_java_lang_String_arr_arr_b[1].length) {
            var2_7 = 0;
        }
        if (var2_7 == 0) {
            a.var_java_lang_String_arr_arr_a[1] = null;
            a.var_java_lang_String_arr_arr_b[1] = null;
            a.var_java_lang_String_arr_arr_a[1] = new String[1];
            a.var_java_lang_String_arr_arr_b[1] = new String[1];
            a.var_java_lang_String_arr_arr_a[1][0] = "JG";
            a.var_java_lang_String_arr_arr_b[1][0] = "1066170073";
        }
        var2_7 = 1;
        if (a.var_java_lang_String_arr_arr_c[0] == null || a.var_java_lang_String_arr_arr_d[0] == null) {
            var2_7 = 0;
        } else if (a.var_java_lang_String_arr_arr_c[0].length != a.var_java_lang_String_arr_arr_d[0].length) {
            var2_7 = 0;
        }
        if (var2_7 == 0) {
            a.var_java_lang_String_arr_arr_c[0] = null;
            a.var_java_lang_String_arr_arr_d[0] = null;
            this.void_a();
        }
        var2_7 = 0;
        while (var2_7 < 2) {
            a.var_int_arr_arr_a[var2_7] = new int[a.var_java_lang_String_arr_arr_a[var2_7].length];
            var3_13 = 0;
            while (var3_13 < a.var_java_lang_String_arr_arr_a[var2_7].length) {
                a.var_int_arr_arr_a[var2_7][var3_13] = 0;
                ++var3_13;
            }
            ++var2_7;
        }
    }

    public static String[] a(int n2) {
        if (n2 != 1 && n2 != 2) {
            n2 = 2;
        }
        int n3 = 0;
        int n4 = 100000;
        boolean bl2 = true;
        int n5 = 0;
        while (n5 < var_int_arr_arr_a[n2 - 1].length) {
            if (var_int_arr_arr_a[n2 - 1][n5] <= n4) {
                n3 = n5;
                n4 = var_int_arr_arr_a[n2 - 1][n5];
            }
            if (var_int_arr_arr_a[n2 - 1][n5] != 0) {
                bl2 = false;
            }
            ++n5;
        }
        if (bl2) {
            Random random = new Random();
            n3 = Math.abs(random.nextInt()) % 100 % var_java_lang_String_arr_arr_a[n2 - 1].length;
            System.out.println("Random minId :" + n3);
        }
        if (n3 < 0 || n3 >= var_java_lang_String_arr_arr_a[n2 - 1].length) {
            n3 = 0;
        }
        String[] stringArray = new String[2];
        String[] stringArray2 = stringArray;
        stringArray[0] = var_java_lang_String_arr_arr_a[n2 - 1][n3];
        stringArray2[1] = var_java_lang_String_arr_arr_b[n2 - 1][n3];
        int[] nArray = var_int_arr_arr_a[n2 - 1];
        int n6 = n3;
        nArray[n6] = nArray[n6] + 1;
        return stringArray2;
    }

    public static String java_lang_String_a() {
        return var_java_lang_String_a;
    }

    public static String b() {
        return var_java_lang_String_b;
    }

    public static String c() {
        return var_java_lang_String_c;
    }

    public static String d() {
        return var_java_lang_String_d;
    }

    public static String e() {
        return e;
    }

    public static int int_a() {
        return var_int_a;
    }

    public final String[] a(int n2, int n3) {
        if (n2 == 0) {
            return null;
        }
        try {
            if (var_java_lang_String_arr_arr_c[0] != null && --n2 >= 0 && n2 < var_java_lang_String_arr_arr_c[0].length) {
                if (var_java_lang_String_arr_arr_c[0][n2] != null && var_java_lang_String_arr_arr_d[0][n2] != null && var_java_lang_String_arr_arr_c[0][n2].length() > 0 && var_java_lang_String_arr_arr_d[0][n2].length() > 0) {
                    String[] stringArray = new String[2];
                    String[] stringArray2 = stringArray;
                    stringArray[0] = var_java_lang_String_arr_arr_c[0][n2];
                    stringArray2[1] = var_java_lang_String_arr_arr_d[0][n2];
                    return stringArray2;
                }
                return this.b(n2, n3);
            }
            return this.b(n2, n3);
        }
        catch (Exception exception) {
            return null;
        }
    }

    private String[] b(int n2, int n3) {
        String string = Integer.toString(n3);
        return a.a(n2, string);
    }
}

