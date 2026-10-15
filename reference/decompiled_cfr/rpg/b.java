/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.rms.RecordStore
 */
package rpg;

import javax.microedition.rms.RecordStore;
import rpg.g;

public final class b {
    private static final String[] var_java_lang_String_arr_a;
    private static final String[] var_java_lang_String_arr_b;
    private static final String[] c;
    private static final byte[][] var_byte_arr_arr_a;
    private static final byte[][] var_byte_arr_arr_b;

    public static final void void_a() {
        try {
            di.m();
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public static final boolean a(byte[] byArray, byte by2) {
        return rpg.b.a(var_java_lang_String_arr_a[by2], byArray, var_byte_arr_arr_a[by2]);
    }

    public static final byte[] a(byte by2) {
        return rpg.b.a(var_java_lang_String_arr_a[by2], var_byte_arr_arr_a[by2]);
    }

    public static final boolean b(byte[] byArray, byte by2) {
        return rpg.b.a(var_java_lang_String_arr_b[by2], byArray, var_byte_arr_arr_b[by2]);
    }

    public static final byte[] b(byte by2) {
        return rpg.b.a(var_java_lang_String_arr_b[by2], var_byte_arr_arr_b[by2]);
    }

    public static final boolean c(byte[] byArray, byte by2) {
        return rpg.b.a(c[by2], byArray, var_byte_arr_arr_b[by2]);
    }

    public static final byte[] c(byte by2) {
        return rpg.b.a(c[by2], var_byte_arr_arr_b[by2]);
    }

    public static final boolean a(byte[] byArray) {
        return rpg.b.a("HOL.OPT", byArray, var_byte_arr_arr_b[0]);
    }

    public static final byte[] byte_arr_a() {
        return rpg.b.a("HOL.OPT", var_byte_arr_arr_b[0]);
    }

    public static final boolean b(byte[] byArray) {
        return rpg.b.a("HOL.storage", byArray, var_byte_arr_arr_b[0]);
    }

    public static final byte[] byte_arr_b() {
        return rpg.b.a("HOL.storage", var_byte_arr_arr_b[0]);
    }

    public static final boolean boolean_a() {
        byte[] byArray = new byte[16];
        byte[] byArray2 = byArray;
        byArray[0] = ax.var_byte_g;
        byArray2[1] = ax.var_byte_h;
        byArray2[2] = ax.var_byte_i;
        byArray2[3] = ax.var_boolean_h ? (byte)1 : 0;
        byArray2[4] = ax.var_boolean_i ? (byte)1 : 0;
        byArray2[5] = ax.j ? (byte)1 : 0;
        byArray2[6] = eb.var_boolean_f ? (byte)1 : 0;
        byArray2[7] = eb.g;
        byArray2[8] = (byte)(di.var_boolean_g ? 1 : 0);
        byArray2[9] = (byte)(di.var_boolean_h ? 1 : 0);
        byArray2[10] = (byte)(di.var_boolean_i ? 1 : 0);
        byArray2[11] = (byte)(di.var_boolean_a ? 1 : 0);
        byArray2[12] = (byte)(di.var_boolean_b ? 1 : 0);
        byArray2[13] = (byte)(di.var_boolean_c ? 1 : 0);
        byArray2[14] = (byte)(di.var_boolean_d ? 1 : 0);
        byArray2[15] = (byte)(di.var_boolean_e ? 1 : 0);
        return rpg.b.a("HOL.gamestore", byArray2, var_byte_arr_arr_b[0]);
    }

    public static final void void_b() {
        Object object = rpg.b.a("HOL.gamestore", var_byte_arr_arr_b[0]);
        if (object == null) {
            rpg.b.boolean_a();
            return;
        }
        try {
            ax.var_byte_g = object[0];
            ax.var_byte_h = object[1];
            ax.var_byte_i = object[2];
            ax.var_boolean_h = object[3] == 1;
            ax.var_boolean_i = object[4] == 1;
            ax.j = object[5] == 1;
            eb.var_boolean_f = object[6] == 1;
            eb.g = object[7];
            di.var_boolean_g = object[8] == 1;
            di.var_boolean_h = object[9] == 1;
            di.var_boolean_i = object[10] == 1;
            di.var_boolean_a = object[11] == 1;
            di.var_boolean_b = object[12] == 1;
            di.var_boolean_c = object[13] == 1;
            di.var_boolean_d = object[14] == 1;
            di.var_boolean_e = object[15] == 1;
            return;
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
            rpg.b.boolean_a();
            return;
        }
    }

    private static final boolean a(String object, byte[] object2, byte[] byArray) {
        boolean bl2;
        bh bh2 = null;
        try {
            int n2;
            byte[] byArray2 = new byte[2 + ((byte[])object2).length + 5];
            byte[] byArray3 = byArray;
            byte[] byArray4 = new byte[((byte[])object2).length];
            int n3 = 0;
            for (n2 = 0; n2 < ((byte[])object2).length; ++n2) {
                if (++n3 == byArray3.length) {
                    n3 = 0;
                }
                byArray4[n2] = (byte)(object2[n2] ^ byArray3[n3]);
            }
            object2 = byArray4;
            g.a((short)(byArray2.length - 2), byArray2, 0);
            System.arraycopy(object2, 0, byArray2, 2, ((byte[])object2).length);
            object2 = rpg.b.a(object2, ((byte[])object2).length, byArray[0]);
            byArray2[byArray2.length - 5] = object2[0];
            byArray2[byArray2.length - 4] = object2[1];
            byArray2[byArray2.length - 3] = object2[2];
            byArray2[byArray2.length - 2] = object2[3];
            byArray2[byArray2.length - 1] = object2[4];
            bh2 = new bh((String)object, 0);
            n2 = byArray2.length;
            boolean bl3 = false;
            byArray3 = byArray2;
            object2 = bh2;
            if (bh2.var_java_lang_String_a != null) {
                while (object2.var_java_lang_String_a.startsWith("/")) {
                    object2.var_java_lang_String_a = object2.var_java_lang_String_a.substring(1);
                }
                while ((n3 = object2.var_java_lang_String_a.indexOf("/")) > 0) {
                    object2.var_java_lang_String_a = object2.var_java_lang_String_a.substring(0, n3) + "." + object2.var_java_lang_String_a.substring(n3 + 1);
                }
                if (byArray3 == null || n2 != byArray3.length) {
                    object2.var_byte_arr_a = new byte[n2];
                    System.arraycopy(byArray3, 0, object2.var_byte_arr_a, 0, n2);
                } else {
                    object2.var_byte_arr_a = byArray3;
                }
                try {
                    object = RecordStore.openRecordStore((String)object2.var_java_lang_String_a, (boolean)true);
                    if (object.getNumRecords() == 0) {
                        object.addRecord(object2.var_byte_arr_a, 0, object2.var_byte_arr_a.length);
                    } else {
                        object.setRecord(1, object2.var_byte_arr_a, 0, object2.var_byte_arr_a.length);
                    }
                    object.closeRecordStore();
                }
                catch (Exception exception) {
                    object = exception;
                    exception.printStackTrace();
                }
            }
            object2 = bh2;
            bh2.var_byte_arr_a = null;
            bh2 = null;
            bl2 = true;
        }
        catch (Exception exception) {
            bl2 = false;
            if (bh2 != null) {
                try {
                    object2 = bh2;
                    bh2.var_byte_arr_a = null;
                }
                catch (Exception exception2) {}
            }
        }
        catch (Throwable throwable) {
            if (bh2 != null) {
                try {
                    object2 = bh2;
                    bh2.var_byte_arr_a = null;
                }
                catch (Exception exception) {}
            }
            throw throwable;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final byte[] a(String object, byte[] object2) {
        bh bh2 = null;
        Object object3 = null;
        try {
            bh2 = new bh((String)object, 1);
            object3 = new byte[2];
            bh2.a((byte[])object3, 0, 2);
            object3 = new byte[(object3[0] & 0xFF) << 8 | object3[1] & 0xFF];
            bh2.a((byte[])object3, 0, ((byte[])object3).length);
            Object by2 = object2[0];
            object = object3;
            int n2 = ((byte[])object3).length;
            byte[] byArray = rpg.b.a((byte[])object, n2 - 5, (byte)by2);
            object3 = !(object[n2 - 1] == byArray[4] && object[n2 - 2] == byArray[3] && object[n2 - 3] == byArray[2] && object[n2 - 4] == byArray[1] && object[n2 - 5] == byArray[0]) ? null : rpg.b.a(object3, (byte[])object2);
        }
        catch (Exception exception) {
            object3 = null;
            if (bh2 == null) return object3;
            try {
                object2 = bh2;
                bh2.var_byte_arr_a = null;
                return object3;
            }
            catch (Exception exception2) {
                return object3;
            }
        }
        catch (Throwable throwable) {
            if (bh2 == null) throw throwable;
            try {
                object2 = bh2;
                bh2.var_byte_arr_a = null;
                throw throwable;
            }
            catch (Exception exception) {}
            throw throwable;
        }
        try {
            object2 = bh2;
            bh2.var_byte_arr_a = null;
            return object3;
        }
        catch (Exception exception) {
            return object3;
        }
    }

    private static byte[] a(byte[] object, byte[] byArray) {
        if (((byte[])object).length <= 0) {
            return null;
        }
        int n2 = ((byte[])object).length - 5;
        byte[] byArray2 = new byte[n2];
        int n3 = 0;
        try {
            for (int i2 = 0; i2 < n2; ++i2) {
                if (++n3 == byArray.length) {
                    n3 = 0;
                }
                byArray2[i2] = (byte)(object[i2] ^ byArray[n3]);
            }
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
            return null;
        }
        return byArray2;
    }

    private static final byte[] a(byte[] byArray, int n2, byte by2) {
        byte[] byArray2 = new byte[]{0, 0, 0, 0, 0};
        byte[] byArray3 = byArray2;
        byArray2[2] = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            byArray3[0] = (byte)(byArray3[0] + byArray[i2]);
            byArray3[1] = (byte)(byArray3[1] + (byte)(byArray[i2] << 1));
            byArray3[3] = (i2 & 1) == 1 ? (byte)(byArray3[3] + byArray[i2]) : (byte)(byArray3[3] - byArray3[1]);
            byArray3[4] = (byte)(byArray3[4] + (byte)(byArray[i2] ^ by2));
        }
        return byArray3;
    }

    static {
        var_java_lang_String_arr_a = new String[]{"HOL.gamedata1", "HOL.gamedata2", "HOL.gamedata3"};
        var_java_lang_String_arr_b = new String[]{"HOL.item1", "HOL.item2", "HOL.item3"};
        c = new String[]{"HOL.slot1", "HOL.slot2", "HOL.slot3"};
        var_byte_arr_arr_a = new byte[][]{{54, 15, 39, 72, 95}, {46, 37, 30, 14, 62, 80}, {26, 27, 60, 58, 70}};
        var_byte_arr_arr_b = new byte[][]{{62, 35, 7, 1, 85, 38, 41}, {2, 78, 24, 7, 16, 91}, {84, 87, 4, 57, 83}};
    }
}

