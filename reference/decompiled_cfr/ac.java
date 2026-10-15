/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;

public final class ac {
    private static boolean var_boolean_b;
    public static boolean var_boolean_a;
    private static final byte[] var_byte_arr_a;
    private static final int[] var_int_arr_a;
    public static int var_int_a;
    private static int var_int_b;
    private static String var_java_lang_String_a;
    private static int var_int_c;
    private static byte[][] var_byte_arr_arr_a;
    private static int d;
    private static int[] var_int_arr_b;
    private static byte[] var_byte_arr_b;
    private static byte[] var_byte_arr_c;
    private static int e;

    public static void a(cm cm2, int n2, int n3, byte[] byArray, int n4) {
        ac.a(cm2, n2, n3, 1000, n4, byArray, 0, 0, byArray.length);
    }

    public static void a(cm cm2, int n2, int n3, int n4, int n5, byte[] byArray) {
        ac.a(cm2, n2, n3, n4, n5, byArray, 0, 0, byArray.length);
    }

    public static void a(cm cm2, int n2, int n3, byte[] byArray, int n4, int n5) {
        byte[] byArray2 = byArray;
        int n6 = ac.b(byArray, 0, 0);
        switch (n5) {
            case 4: {
                n6 = 0;
                break;
            }
            case 1: {
                n6 /= 2;
            }
        }
        ac.a(cm2, n2 - n6, n3, 1000, n4, byArray, 0, 0, byArray.length);
    }

    public static void a(cm cm2, int n2, int n3, int n4, int n5, byte[] byArray, int n6, int n7, int n8) {
        ac.a(cm2, n2, n3, n4, byArray, n6, n8, 4);
    }

    public static void a(cm cm2, int n2, int n3, int n4, byte[] byArray, int n5, int n6, int n7) {
        try {
            if (!var_boolean_b) {
                return;
            }
            int n8 = n5;
            int n9 = n2;
            switch (n7) {
                case 4: {
                    n9 = n2;
                    break;
                }
                case 1: {
                    n9 = n2 - (ac.b(byArray, n5, n4) >> 1);
                }
            }
            int n10 = 0;
            while (n8 < byArray.length && n8 < n5 + n6) {
                int n11;
                int n12;
                int n13;
                int n14;
                int n15;
                int n16;
                block27: {
                    n16 = byArray[n8];
                    for (n15 = 0; n15 < var_byte_arr_a.length; ++n15) {
                        if (n16 != var_byte_arr_a[n15]) continue;
                        n14 = var_int_arr_a[n15];
                        break block27;
                    }
                    n14 = n16 = -1;
                }
                if (n14 != -1 && var_boolean_a) {
                    cm2.a(n16);
                    ++n8;
                    continue;
                }
                if (n10 == 0 && byArray[n8] == 32) {
                    ++n8;
                    continue;
                }
                n15 = var_int_b >> 2;
                int n17 = var_java_lang_String_a.indexOf((char)byArray[n8]);
                if (n17 >= 0 && n17 < var_byte_arr_b.length) {
                    n15 = var_byte_arr_b[n17];
                }
                int n18 = 0;
                if (byArray[n8] == 32) {
                    n16 = n10;
                    for (n13 = n8 + 1; n13 < byArray.length && byArray[n13] != 32 && byArray[n13] != 59; ++n13) {
                        n12 = var_int_b >> 2;
                        n11 = var_java_lang_String_a.indexOf((char)byArray[n13]);
                        if (n11 >= 0 && n11 < var_byte_arr_b.length) {
                            n12 = var_byte_arr_b[n11];
                        }
                        if (n16 + n12 > n4 - 7) {
                            n18 = 1;
                            break;
                        }
                        n16 += n12;
                    }
                }
                if (n10 + n15 > n4 || byArray[n8] == 59 || n18 != 0) {
                    n10 = 0;
                    n3 += var_int_a + 2;
                    if (byArray[n8] == 59) {
                        ++n8;
                    }
                    switch (n7) {
                        case 4: {
                            n9 = n2;
                            break;
                        }
                        case 1: {
                            n9 = n2 - (ac.b(byArray, n8, n4) >> 1);
                        }
                    }
                    continue;
                }
                if (n17 >= 0 && n17 < e) {
                    n13 = 0;
                    n12 = 0;
                    n11 = 0;
                    while (n11 < var_byte_arr_arr_a[n17].length) {
                        n16 = 7 - var_byte_arr_c[n17];
                        n18 = var_byte_arr_b[n17];
                        while (n18 > 0) {
                            if (n16 < 0) {
                                ++n11;
                                n16 = 7;
                            }
                            if ((var_byte_arr_arr_a[n17][n11] & 1 << n16) != 0) {
                                cm2.e(n9 + n12, n3 + n13, n9 + n12, n3 + n13);
                            }
                            ++n12;
                            --n18;
                            --n16;
                        }
                        n11 += n11 + 1 & 1;
                        ++n11;
                        ++n13;
                        n12 = 0;
                    }
                }
                n9 += n15;
                n10 += n15;
                ++n8;
            }
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public static final int a(byte[] byArray, int n2, int n3, int n4) {
        int n5 = n2;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        while (n6 < n4 && n2 < byArray.length) {
            if (byArray[n2] == 32) {
                n7 = n2;
            }
            if (byArray[n2] == 32 && n8 == 0) {
                ++n2;
                continue;
            }
            if ((byArray[n2] & 0xF0) == 240) {
                if (n8 + var_int_b > n3) {
                    ++n6;
                    n8 = 0;
                    continue;
                }
                n8 += var_int_b + 1;
                n2 += 2;
                continue;
            }
            if ((byArray[n2] & 0x80) != 0) {
                if (n8 + 8 > n3) {
                    ++n6;
                    n8 = 0;
                    continue;
                }
                n8 += 9;
                n2 += 2;
                continue;
            }
            if (ac.a(byArray[n2])) {
                if (byArray[n2] == 59) {
                    ++n6;
                    n8 = 0;
                }
                ++n2;
                continue;
            }
            int n9 = var_int_b >> 2;
            int n10 = var_java_lang_String_a.indexOf((char)byArray[n2]);
            if (n10 >= 0 && n10 < var_byte_arr_b.length) {
                n9 = var_byte_arr_b[n10];
            }
            if (n8 + n9 > n3 - 7) {
                ++n6;
                n8 = 0;
                n2 = n7;
                continue;
            }
            n8 += n9;
            ++n2;
        }
        return n2 - n5;
    }

    public static final int a(byte[] byArray, int n2, int n3) {
        n3 = n2 + n3;
        boolean bl2 = false;
        while (n3 < byArray.length) {
            if (byArray[n3] == 32 || ac.a(byArray[n3])) {
                ++n3;
                continue;
            }
            if ((byArray[n3] & 0x80) != 0) {
                if (bl2) {
                    return n3 + 2 - n2;
                }
                bl2 = true;
                n3 += 2;
                continue;
            }
            if (bl2) {
                return n3 + 1 - n2;
            }
            bl2 = true;
            ++n3;
        }
        return byArray.length - n2;
    }

    public static final int a(byte[] byArray, int n2) {
        int n3 = 0;
        int n4 = ac.a(byArray, 0, n2, 0);
        while (n4 < byArray.length) {
            n4 = ac.a(byArray, 0, n2, ++n3);
        }
        return n3;
    }

    public static final int a(byte[] byArray) {
        return ac.b(byArray, 0, 0);
    }

    public static final int b(byte[] byArray, int n2, int n3) {
        int n4 = 1;
        while (n2 < byArray.length) {
            int n5 = n4;
            if ((byArray[n2] & 0xF0) == 240) {
                n4 += var_int_b + 1;
                n2 += 2;
            } else if ((byArray[n2] & 0x80) != 0) {
                n4 += 9;
                n2 += 2;
            } else {
                if (byArray[n2] == 59) break;
                if (ac.a(byArray[n2])) {
                    ++n2;
                } else {
                    int n6 = var_int_b >> 2;
                    int n7 = var_java_lang_String_a.indexOf((char)byArray[n2]);
                    if (n7 >= 0 && n7 < var_byte_arr_b.length) {
                        n6 = var_byte_arr_b[n7];
                    }
                    n4 += n6;
                    ++n2;
                }
            }
            if (n3 <= 0 || n4 <= n3) continue;
            return n5;
        }
        if (n4 == 1) {
            return 0;
        }
        return n4;
    }

    private static final boolean a(byte by2) {
        if (by2 == 59) {
            return true;
        }
        for (int i2 = 0; i2 < var_byte_arr_a.length; ++i2) {
            if (by2 != var_byte_arr_a[i2]) continue;
            return true;
        }
        return false;
    }

    public static final void a() {
        if (var_boolean_b) {
            return;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream("".getClass().getResourceAsStream("/dotFontSmall.dat"));
            e = dataInputStream.readInt();
            var_byte_arr_b = new byte[e];
            var_byte_arr_c = new byte[e];
            var_java_lang_String_a = dataInputStream.readUTF();
            var_int_c = var_java_lang_String_a.length();
            var_java_lang_String_a = var_java_lang_String_a.substring(0, e);
            int n2 = dataInputStream.readInt() - 2;
            var_int_b = dataInputStream.readByte();
            var_int_a = dataInputStream.readByte();
            var_int_arr_b = new int[var_int_b * var_int_a];
            d = (var_int_b >> 3) + ((var_int_b & 7) == 0 ? 0 : 1);
            int n3 = var_int_a * d;
            if (n3 * var_int_c != n2) {
                System.out.println("************************************\n");
                System.out.println("       DOT FONT LOAD ERROR!!!");
                System.out.println("\n************************************");
            } else {
                var_byte_arr_arr_a = new byte[var_int_c][n3];
                for (n2 = 0; n2 < var_int_c; ++n2) {
                    dataInputStream.read(var_byte_arr_arr_a[n2]);
                }
                for (n2 = 0; n2 < e; ++n2) {
                    int n4;
                    int n5;
                    int n6;
                    int n7 = 0;
                    for (n3 = 0; n3 < var_byte_arr_arr_a[n2].length; ++n3) {
                        n6 = 7;
                        n5 = var_int_b;
                        while (n5 > 0) {
                            if (n6 < 0) {
                                ++n3;
                                n6 = 7;
                            }
                            ac.var_int_arr_b[n7] = (var_byte_arr_arr_a[n2][n3] & 1 << n6) != 0 ? 1 : 0;
                            ++n7;
                            --n5;
                            --n6;
                        }
                    }
                    n7 = 0;
                    n3 = var_int_b - 1;
                    for (n6 = 0; n6 < var_int_b; ++n6) {
                        n5 = 0;
                        for (n4 = 0; n4 < var_int_arr_b.length; n4 += var_int_b) {
                            if (var_int_arr_b[n6 + n4] != 1) continue;
                            n5 = 1;
                            break;
                        }
                        if (n5 == 0) continue;
                        n7 = n6;
                        break;
                    }
                    for (n6 = var_int_b - 1; n6 >= 0; --n6) {
                        n5 = 0;
                        for (n4 = 0; n4 < var_int_arr_b.length; n4 += var_int_b) {
                            if (var_int_arr_b[n6 + n4] != 1) continue;
                            n5 = 1;
                            break;
                        }
                        if (n5 == 0) continue;
                        n3 = n6;
                        break;
                    }
                    ac.var_byte_arr_c[n2] = (byte)n7;
                    ac.var_byte_arr_b[n2] = (byte)(n3 - n7 + 2);
                    if (var_byte_arr_c[n2] + var_byte_arr_b[n2] > var_int_b) {
                        ac.var_byte_arr_b[n2] = (byte)(var_int_b - var_byte_arr_c[n2]);
                    }
                    if (var_java_lang_String_a.substring(n2, n2 + 1).equals(".")) {
                        int n8 = n2;
                        var_byte_arr_c[n8] = (byte)(var_byte_arr_c[n8] - 1);
                        int n9 = n2;
                        var_byte_arr_b[n9] = (byte)(var_byte_arr_b[n9] + 3);
                        continue;
                    }
                    if (!var_java_lang_String_a.substring(n2, n2 + 1).equals(" ")) continue;
                    ac.var_byte_arr_c[n2] = 0;
                    ac.var_byte_arr_b[n2] = 6;
                }
            }
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
        var_boolean_b = true;
    }

    static {
        var_boolean_b = false;
        var_boolean_a = true;
        var_byte_arr_a = new byte[]{38, 124, 36, 123, 125, 94, 92};
        var_int_arr_a = new int[]{0xFFFFFF, 0xFFFF00, 1630207, 0xFF9F3F, 14597755, 65280, 0x7F7F7F};
        e = 0;
    }
}

