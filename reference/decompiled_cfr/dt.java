/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;
import rpg.g;

public final class dt
implements dy {
    public static dt[] var_dt_arr_a;
    s var_s_a = null;
    byte[] var_byte_arr_a;
    private byte k;
    byte var_byte_a;
    private byte l;
    private byte[] var_byte_arr_c = new byte[4];
    private byte[] var_byte_arr_d = new byte[6];
    byte var_byte_b;
    byte var_byte_c;
    short var_short_a;
    short var_short_b;
    short var_short_c;
    byte var_byte_d;
    short var_short_d;
    short var_short_e;
    short var_short_f;
    boolean var_boolean_a;
    boolean var_boolean_b;
    boolean var_boolean_c;
    byte var_byte_e;
    public byte var_byte_f;
    byte[] var_byte_arr_b;
    byte g;
    byte h;
    byte i;
    byte j;
    boolean var_boolean_d;

    public static final void a(int n2) {
        var_dt_arr_a = new dt[n2];
    }

    public static final void a(byte by2, short s2, byte[] byArray, byte[] byArray2, byte[] byArray3) {
        byte[] byArray4 = rpg.e.a(byArray, (int)s2);
        if (!rpg.e.boolean_a(byArray4)) {
            dt.var_dt_arr_a[by2] = null;
            return;
        }
        dt dt2 = new dt();
        int n2 = byArray4[0];
        dt2.var_byte_arr_a = new byte[n2];
        System.arraycopy(byArray4, 1, dt2.var_byte_arr_a, 0, n2);
        int n3 = ++n2;
        dt2.k = byArray4[n3];
        int n4 = ++n2;
        dt2.var_byte_a = byArray4[n4];
        int n5 = ++n2;
        dt2.l = byArray4[n5];
        System.arraycopy(byArray4, ++n2, dt2.var_byte_arr_c, 0, 4);
        System.arraycopy(byArray4, n2 += 4, dt2.var_byte_arr_d, 0, 6);
        n2 += 6;
        if (dt2.var_byte_arr_d[0] == 0 && dt2.var_byte_arr_d[1] == 0 && dt2.var_byte_arr_d[2] == 0 && dt2.var_byte_arr_d[3] == 0 && dt2.var_byte_arr_d[4] == 0 && dt2.var_byte_arr_d[5] == 0) {
            dt2.var_byte_arr_d = null;
        }
        dt2.var_byte_b = byArray4[n2++];
        dt2.var_byte_c = byArray4[n2++];
        dt2.var_short_a = rpg.g.short_b(byArray4, n2);
        dt2.var_short_b = rpg.g.short_b(byArray4, n2 += 2);
        dt2.var_short_c = rpg.g.short_b(byArray4, n2 += 2);
        n2 += 2;
        dt2.var_byte_d = byArray4[n2++];
        dt2.var_short_d = rpg.g.short_b(byArray4, n2);
        dt2.var_short_e = rpg.g.short_b(byArray4, n2 += 2);
        dt2.var_short_f = rpg.g.short_b(byArray4, n2 += 2);
        n2 += 2;
        dt2.var_boolean_a = byArray4[n2++] == 1;
        dt2.var_boolean_b = byArray4[n2++] == 1;
        dt2.var_boolean_c = byArray4[n2++] == 1;
        dt2.var_byte_e = byArray4[n2++];
        dt2.var_byte_arr_b = new byte[24];
        System.arraycopy(byArray4, n2, dt2.var_byte_arr_b, 0, 24);
        n2 += 24;
        dt2.g = byArray4[n2++];
        dt2.h = byArray4[n2++];
        dt2.i = byArray4[n2++];
        dt2.j = byArray4[n2++];
        if (dt2.var_byte_a == 5) {
            dt2.j = 0;
        }
        dt2.var_boolean_d = byArray4[n2] == 0;
        dt.var_dt_arr_a[by2] = dt2;
        dt dt3 = dt2;
        if (dt3.l >= 0) {
            dt3.var_s_a = new s();
            byArray4 = rpg.e.a((dt3.k == 0 ? "/en/cif/h" : "/en/cif/a") + (dt3.l < 10 ? "0" : "") + dt3.l);
            dt3.var_s_a.a(byArray4, true);
        }
        if (dt2.var_s_a != null) {
            dt2.a(byArray2, byArray3);
            dt2.var_s_a.var_byte_arr_arr_a = null;
        }
        dt2.var_byte_arr_d = null;
        dt2.var_byte_arr_c = null;
    }

    private void a(byte[] byArray, byte[] object) {
        if (this.var_byte_arr_d == null) {
            return;
        }
        byArray = this.k == 0 ? byArray : object;
        for (int i2 = 0; i2 < 6; ++i2) {
            if (this.var_byte_arr_d[i2] == 0) continue;
            object = "/en/";
            if (this.k == 0) {
                object = (String)object + i2 + "/";
            }
            object = (String)object + (this.var_byte_arr_d[i2] < 10 ? "0" : "") + this.var_byte_arr_d[i2];
            byte[] byArray2 = null;
            if (i2 < this.var_byte_arr_c.length && this.var_byte_arr_c[i2] > 0) {
                byArray2 = rpg.e.a(byArray, this.var_byte_arr_c[i2] - 1);
            }
            this.var_s_a.a(i2, (String)object, byArray2);
        }
    }

    public static final void a() {
        var_dt_arr_a = null;
        av.var_av_a = null;
        av.var_bi_arr_a = null;
        ap.a = null;
        cw.a = null;
    }

    static {
        var_dt_arr_a = null;
    }
}

