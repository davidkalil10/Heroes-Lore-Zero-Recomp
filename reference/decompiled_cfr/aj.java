/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

public final class aj {
    private static final String[] var_java_lang_String_arr_a;
    private static final byte[] var_byte_arr_a;
    private static final byte[] var_byte_arr_b;
    private String var_java_lang_String_a;
    private boolean var_boolean_a;
    private boolean var_boolean_b;
    private int var_int_a;
    private int[] var_int_arr_a;
    private byte[] var_byte_arr_c;
    private Object[] var_java_lang_Object_arr_a;
    private char[] var_char_arr_a;
    private int var_int_b;
    private int var_int_c;
    private boolean var_boolean_c = true;
    private static final int[] var_int_arr_b;
    private int d = -1;
    private int e = 1;

    public aj(String string) {
        this.a(string);
    }

    private void a(String object) {
        int n2;
        this.var_int_arr_a = null;
        this.var_byte_arr_c = null;
        this.var_java_lang_Object_arr_a = null;
        this.var_char_arr_a = null;
        this.var_java_lang_String_a = object;
        object = rpg.e.a(this.var_java_lang_String_a.concat(".mpm"));
        this.var_byte_arr_c = aj.byte_arr_a((byte[])object, 0);
        int n3 = 0 + (2 + this.var_byte_arr_c.length);
        aj aj2 = this;
        int n4 = aj.int_a(aj2.var_byte_arr_c, 0);
        aj2.var_boolean_a = (n4 >> 27) % 2 == 1;
        aj2.var_boolean_b = (n4 >> 26) % 2 == 1;
        n4 = aj2.int_a();
        aj2.var_int_a = 0;
        for (n2 = 0; n2 < n4; ++n2) {
            if (aj2.var_int_a >= aj.char_a(aj2.var_byte_arr_c, 8 + n2 * 8) + '\u0001') continue;
            aj2.var_int_a = aj.char_a(aj2.var_byte_arr_c, 8 + n2 * 8) + '\u0001';
        }
        aj2.var_int_arr_a = new int[aj2.var_int_a];
        for (n2 = 0; n2 < n4; ++n2) {
            char c2 = aj.char_a(aj2.var_byte_arr_c, 8 + n2 * 8);
            aj2.var_int_arr_a[c2] = aj2.var_int_arr_a[c2] + 1;
        }
        aj2.var_java_lang_Object_arr_a = new Object[aj2.var_int_a];
        aj2.var_char_arr_a = new char[n4];
        for (n2 = 0; n2 < n4; ++n2) {
            aj2.var_char_arr_a[n2] = aj.char_a(aj2.var_byte_arr_c, 8 + n2 * 8 + 6);
        }
        aj2.var_int_b = aj.b(aj2.var_byte_arr_c, 12);
        aj2.var_int_c = aj.b(aj2.var_byte_arr_c, 13);
        for (int i2 = 0; i2 < this.var_int_a; ++i2) {
            byte[] byArray = aj.byte_arr_a((byte[])object, n3);
            this.var_java_lang_Object_arr_a[i2] = byArray;
            n3 += 2 + byArray.length;
        }
    }

    private static byte[] byte_arr_a(byte[] byArray, int n2) {
        short s2 = (short)((byArray[n2] & 0xFF) << 8 | byArray[n2 + 1] & 0xFF);
        byte[] byArray2 = new byte[s2];
        System.arraycopy(byArray, n2 + 2, byArray2, 0, s2);
        return byArray2;
    }

    public final int int_a() {
        return aj.int_a(this.var_byte_arr_c, 4);
    }

    public final cg cg_a(int n2) {
        byte[] byArray = this.byte_arr_b(n2);
        return cg.a(byArray, 0, byArray.length);
    }

    public final cg[] cg_arr_a() {
        boolean bl2 = true;
        aj aj2 = this;
        this.var_boolean_c = true;
        int n2 = this.int_a();
        cg[] cgArray = new cg[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            cgArray[i2] = this.cg_a(i2);
        }
        return cgArray;
    }

    public final void a(cg[] cgArray, int n2) {
        n2 = 1;
        aj aj2 = this;
        this.var_boolean_c = true;
        int n3 = this.int_a();
        for (int i2 = 0; i2 < n3; ++i2) {
            cgArray[i2 + 0] = this.cg_a(i2);
        }
    }

    public final cg cg_b(int n2) {
        byte[] byArray;
        block7: {
            int n3;
            int n4;
            if (!this.var_boolean_b) {
                return this.cg_a(n2);
            }
            byArray = this.byte_arr_b(n2);
            int n5 = aj.a(byArray, 16, 8, byArray.length);
            int n6 = aj.a(byArray, 0, 8, byArray.length);
            int n7 = aj.int_a(byArray, n6 + 8);
            int n8 = aj.int_a(byArray, n6 + 12);
            n6 = byArray[n6 + 16];
            int n9 = n5;
            int n10 = n6;
            int n11 = n8;
            n5 = n7;
            n6 = n9;
            byte[] byArray2 = byArray;
            aj aj2 = this;
            int n12 = 8 / n10;
            int n13 = (n5 - 1) / n12 + 1;
            int n14 = 255 >> 8 - n10;
            int n15 = n6 + 15;
            int n16 = (n13 + 1) * n11;
            int n17 = n5 / 2;
            int n18 = n15 + n16;
            int n19 = n18 + 4;
            n6 += 4;
            for (n4 = 0; n4 < n11; ++n4) {
                if (byArray2[n15 + (n13 + 1) * n4] == 0) {
                    continue;
                }
                break block7;
            }
            for (int i2 = 0; i2 < n11; ++i2) {
                n4 = n15 + (n13 + 1) * i2 + 1;
                for (int i3 = 0; i3 < n17; ++i3) {
                    n3 = n5 - 1 - i3;
                    int n20 = n4 + i3 / n12;
                    int n21 = n4 + n3 / n12;
                    int n22 = i3 % n12;
                    n3 %= n12;
                    n22 = (byte)((n12 - n22 - 1) * n10);
                    n3 = (byte)((n12 - n3 - 1) * n10);
                    byte by2 = (byte)(byArray2[n20] >> n22 & n14);
                    byte by3 = (byte)(byArray2[n21] >> n3 & n14);
                    byArray2[n20] = (byte)(byArray2[n20] & ~(n14 << n22) | by3 << n22);
                    byArray2[n21] = (byte)(byArray2[n21] & ~(n14 << n3) | by2 << n3);
                }
            }
            aj aj3 = aj2;
            aj2.e = 1;
            n12 = n16;
            n10 = n15;
            byte[] byArray3 = byArray2;
            aj3 = aj2;
            n13 = aj3.e & 0xFFFF;
            n14 = aj3.e >> 16 & 0xFFFF;
            while (n12 > 0) {
                n15 = n12 < 5552 ? n12 : 5552;
                n12 -= n15;
                while (n15-- > 0) {
                    n14 += (n13 += byArray3[n10++] & 0xFF);
                }
                n13 %= 65521;
                n14 %= 65521;
            }
            aj3.e = n14 << 16 | n13;
            aj3 = aj2;
            long l2 = aj3.e;
            System.arraycopy(aj.c((int)l2), 0, byArray2, n18, 4);
            aj3 = aj2;
            aj2.d = -1;
            aj2.a(byArray2, n6, n16 + 15);
            aj3 = aj2;
            n3 = ~aj3.d;
            System.arraycopy(aj.c(n3), 0, byArray2, n19, 4);
        }
        return cg.a(byArray, 0, byArray.length);
    }

    public final void void_a(int n2, int n3) {
        if (!this.var_boolean_a) {
            return;
        }
        int n4 = n3;
        int n5 = n2;
        n2 = 4;
        int n6 = this.var_int_b;
        byte[] byArray = this.var_byte_arr_c;
        aj aj2 = this;
        int n7 = aj.int_a(byArray, n6);
        int n8 = n6 + 8;
        int n9 = n8 + n7;
        int n10 = n5 >> 16;
        byte by2 = (byte)(n5 >> 8);
        n5 = (byte)n5;
        byte by3 = (byte)(n4 >> 16);
        byte by4 = (byte)(n4 >> 8);
        n4 = (byte)n4;
        for (int i2 = 0; i2 < n7 / 3; ++i2) {
            if (byArray[n8 + i2 * 3] != n10 || byArray[n8 + i2 * 3 + 1] != by2 || byArray[n8 + i2 * 3 + 2] != n5) continue;
            byArray[n8 + i2 * 3] = by3;
            byArray[n8 + i2 * 3 + 1] = by4;
            byArray[n8 + i2 * 3 + 2] = n4;
        }
        aj aj3 = aj2;
        aj2.d = -1;
        aj2.a(byArray, n6 + 4, n7 + 4);
        aj3 = aj2;
        n10 = ~aj3.d;
        System.arraycopy(aj.c(n10), 0, byArray, n9, 4);
    }

    private byte[] byte_arr_a(int n2) {
        n2 = aj.char_a(this.var_byte_arr_c, 8 + n2 * 8);
        if (this.var_boolean_c && this.var_java_lang_Object_arr_a[n2] == null) {
            aj aj2 = this;
            for (int i2 = 0; i2 < aj2.var_int_a; ++i2) {
                aj2.var_java_lang_Object_arr_a[i2] = null;
            }
            this.var_java_lang_Object_arr_a[n2] = rpg.e.a(this.var_java_lang_String_a.concat("_").concat(String.valueOf(n2)).concat(".mpd"));
        }
        return (byte[])this.var_java_lang_Object_arr_a[n2];
    }

    private byte[] byte_arr_b(int n2) {
        if (this.var_boolean_a) {
            byte[] byArray = this.byte_arr_a(n2);
            int n3 = aj.int_a(this.var_byte_arr_c, 8 + (n2 << 3) + 2);
            int n4 = this.int_a(n2);
            int n5 = 8 + (this.var_byte_arr_c.length - ((aj.int_a(this.var_byte_arr_c, 4) << 3) + 8));
            n5 += n4;
            byte[] byArray2 = new byte[n5 += 12];
            System.arraycopy(var_byte_arr_a, 0, byArray2, 0, 8);
            int n6 = aj.a(byArray, 0, n3, n4);
            if (n6 == -1) {
                return null;
            }
            int n7 = aj.int_a(byArray, n6) + 12;
            System.arraycopy(byArray, n6, byArray2, 8, n7);
            int n8 = n7 + 8;
            block3: for (int i2 = 0; i2 < 18; ++i2) {
                if (!this.boolean_a(n2, i2)) continue;
                switch (i2) {
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 9: 
                    case 10: {
                        n6 = aj.a(byArray, i2, n3, n4);
                        if (n6 == -1) continue block3;
                        n7 = aj.int_a(byArray, n6) + 12;
                        System.arraycopy(byArray, n6, byArray2, n8, n7);
                        n8 += n7;
                    }
                }
            }
            n6 = this.var_int_b;
            n7 = aj.int_a(this.var_byte_arr_c, n6) + 12;
            System.arraycopy(this.var_byte_arr_c, n6, byArray2, n8, n7);
            n8 += n7;
            n6 = this.var_int_c;
            if (n6 != -1) {
                n7 = aj.int_a(this.var_byte_arr_c, n6) + 12;
                System.arraycopy(this.var_byte_arr_c, n6, byArray2, n8, n7);
                n8 += n7;
            }
            if (this.boolean_a(n2, 14) && (n6 = aj.a(byArray, 14, n3, n4)) != -1) {
                n7 = aj.int_a(byArray, n6) + 12;
                System.arraycopy(byArray, n6, byArray2, n8, n7);
                n8 += n7;
            }
            if (this.boolean_a(n2, 15) && (n6 = aj.a(byArray, 15, n3, n4)) != -1) {
                n7 = aj.int_a(byArray, n6) + 12;
                System.arraycopy(byArray, n6, byArray2, n8, n7);
                n8 += n7;
            }
            n6 = aj.a(byArray, 16, n3, n4);
            n7 = aj.int_a(byArray, n6) + 12;
            System.arraycopy(byArray, n6, byArray2, n8, n7);
            System.arraycopy(var_byte_arr_b, 0, byArray2, n8 += n7, 12);
            return byArray2;
        }
        byte[] byArray = this.byte_arr_a(n2);
        int n9 = aj.int_a(this.var_byte_arr_c, 8 + (n2 << 3) + 2);
        int n10 = this.int_a(n2);
        int n11 = n10 + 8;
        byte[] byArray3 = new byte[n11 += 12];
        System.arraycopy(var_byte_arr_a, 0, byArray3, 0, 8);
        System.arraycopy(byArray, n9, byArray3, 8, n10);
        int n12 = n10 + 8;
        System.arraycopy(var_byte_arr_b, 0, byArray3, n12, 12);
        return byArray3;
    }

    private int int_a(int n2) {
        byte[] byArray = this.byte_arr_a(n2);
        int n3 = aj.int_a(this.var_byte_arr_c, 8 + (n2 << 3) + 2);
        n2 = n2 == this.int_a() - 1 || aj.char_a(this.var_byte_arr_c, 8 + (n2 << 3)) != aj.char_a(this.var_byte_arr_c, 8 + (n2 + 1 << 3)) ? byArray.length : aj.int_a(this.var_byte_arr_c, 8 + (n2 + 1 << 3) + 2);
        return n2 - n3;
    }

    private static int a(byte[] byArray, int n2, int n3, int n4) {
        String string = var_java_lang_String_arr_a[n2];
        n4 = n4 == -1 ? byArray.length : n3 + n4;
        while (n3 < n4) {
            if (byArray[n3 + 4] == string.charAt(0) && byArray[n3 + 5] == string.charAt(1) && byArray[n3 + 6] == string.charAt(2) && byArray[n3 + 7] == string.charAt(3)) {
                return n3;
            }
            n3 += aj.int_a(byArray, n3) + 12;
        }
        return -1;
    }

    private static int int_a(byte[] byArray, int n2) {
        if (byArray.length - 4 < n2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int n3 = 0 + ((byArray[n2] & 0xFF) << 24);
        n3 += (byArray[n2 + 1] & 0xFF) << 16;
        n3 += (byArray[n2 + 2] & 0xFF) << 8;
        return n3 += byArray[n2 + 3] & 0xFF;
    }

    private static char char_a(byte[] byArray, int n2) {
        if (byArray.length - 2 < n2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        char c2 = (char)(0 + ((byArray[n2] & 0xFF) << 8));
        c2 = (char)(c2 + (byArray[n2 + 1] & 0xFF));
        return c2;
    }

    private boolean boolean_a(int n2, int n3) {
        n2 = this.var_char_arr_a[n2];
        if (n3 <= 0 || n3 > 16) {
            return false;
        }
        return (n2 >> n3 - 1 & 1) == 1;
    }

    private static int b(byte[] byArray, int n2) {
        String string = var_java_lang_String_arr_a[n2];
        int n3 = byArray.length;
        for (int i2 = 0; i2 < n3 - 3; ++i2) {
            if (byArray[i2] != string.charAt(0) || byArray[i2 + 1] != string.charAt(1) || byArray[i2 + 2] != string.charAt(2) || byArray[i2 + 3] != string.charAt(3)) continue;
            return i2 - 4;
        }
        return -1;
    }

    private static byte[] c(int n2) {
        byte[] byArray = new byte[4];
        byte[] byArray2 = byArray;
        byArray[0] = (byte)(n2 >>> 24);
        byArray2[1] = (byte)(n2 >> 16);
        byArray2[2] = (byte)(n2 >> 8);
        byArray2[3] = (byte)n2;
        return byArray2;
    }

    private void a(byte[] byArray, int n2, int n3) {
        for (int i2 = n2; i2 < n3 + n2; ++i2) {
            this.d = this.d >>> 8 & 0xFFFFFF ^ var_int_arr_b[(this.d ^ byArray[i2]) & 0xFF];
        }
    }

    static {
        var_java_lang_String_arr_a = new String[]{"IHDR", "cHRM", "gAMA", "iCCP", "sBIT", "sRGB", "tEXt", "zTXt", "iTXt", "pHYs", "sPLT", "tIME", "PLTE", "tRNS", "hIST", "bKGD", "IDAT", "IEND"};
        var_byte_arr_a = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        var_byte_arr_b = new byte[]{0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
        var_int_arr_b = new int[256];
        for (int n2 = 0; n2 < 256; n2 = (int)((short)(n2 + 1))) {
            int n3 = n2;
            for (int n4 = 1; n4 < 9; n4 = (int)((byte)(n4 + 1))) {
                n3 = (n3 & 1) == 1 ? n3 >>> 1 ^ 0xEDB88320 : n3 >>> 1;
            }
            aj.var_int_arr_b[n2] = n3;
        }
    }
}

