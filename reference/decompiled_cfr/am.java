/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

public final class am
implements dy {
    public static s[] var_s_arr_a;
    public static byte[] var_byte_arr_a;
    public static byte[] b;

    public static final void a(byte[] byArray, byte by2, byte[] byArray2) {
        byte by3 = byArray[0];
        byte[] byArray3 = e.a("/en/cif/h" + (by3 < 10 ? "0" : "") + by3);
        am.var_s_arr_a[by2] = new s();
        var_s_arr_a[by2].a(byArray3, true);
        byArray3 = new byte[4];
        System.arraycopy(byArray, 1, byArray3, 0, 4);
        byte[] byArray4 = new byte[4];
        System.arraycopy(byArray, 5, byArray4, 0, 4);
        am.a(var_s_arr_a[by2], byArray3, byArray4, byArray2);
        am.var_s_arr_a[by2].var_byte_arr_arr_a = null;
        am.var_byte_arr_a[by2] = byArray[9];
        am.b[by2] = byArray[10];
    }

    private static void a(s s2, byte[] byArray, byte[] byArray2, byte[] byArray3) {
        for (int i2 = 0; i2 < byArray2.length; ++i2) {
            if (byArray2[i2] == 0) continue;
            String string = "/en/" + i2 + "/" + (byArray2[i2] < 10 ? "0" : "") + byArray2[i2];
            byte[] byArray4 = null;
            if (byArray[i2] > 0) {
                byArray4 = e.a(byArray3, byArray[i2] - 1);
            }
            s2.a(i2, string, byArray4);
        }
        s2.var_byte_arr_arr_a = null;
    }
}

