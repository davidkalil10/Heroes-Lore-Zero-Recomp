/*
 * Decompiled with CFR 0.152.
 */
package rpg;

import java.io.IOException;
import java.io.InputStream;
import rpg.a;
import rpg.d;

public final class e
implements d {
    private static e var_rpg_e_a;
    public static ch var_ch_a;
    public static ch var_ch_b;
    public static ch var_ch_c;
    public static ch var_ch_d;
    public static ca var_ca_a;
    public static s[] var_s_arr_a;
    public static s var_s_a;
    public static cg[] var_cg_arr_a;
    public static cg[] var_cg_arr_b;
    public static cg[] var_cg_arr_c;
    public static cg[] var_cg_arr_d;
    public static cg[] var_cg_arr_e;
    public static cg[] var_cg_arr_f;
    public static ch var_ch_e;
    public static ch var_ch_f;
    public static ch var_ch_g;
    public static ch var_ch_h;
    public static cg var_cg_a;
    public static cg var_cg_b;
    public static cg var_cg_c;
    public static cg var_cg_d;
    public static ch var_ch_i;
    public static ch var_ch_j;
    public static ch var_ch_k;
    private static String var_java_lang_String_a;
    public static cg var_cg_e;
    public static cg var_cg_f;
    public static cg[] var_cg_arr_g;
    public static cg var_cg_g;
    public static cg[] var_cg_arr_h;
    public static cg[] var_cg_arr_i;
    public static cg[] var_cg_arr_j;
    public static cg var_cg_h;
    public static cg var_cg_i;
    public static cg var_cg_j;
    public static cg var_cg_k;
    public static cg var_cg_l;
    public static cg var_cg_m;
    public static cg n;
    public static cg o;
    public static cg p;
    private static cg x;
    public static cg q;
    public static cg r;
    public static cg s;
    public static cg t;
    public static cg u;
    public static cg[] var_cg_arr_k;
    public static cg[] var_cg_arr_l;
    public static cg v;
    public static cg w;
    public static cg[] var_cg_arr_m;
    private static final byte[] var_byte_arr_a;

    public static e rpg_e_a() {
        return var_rpg_e_a;
    }

    public final void void_a() {
        aj aj2 = new aj("/img/sui");
        var_cg_a = cg.a("/imgbox.png");
        var_cg_b = aj2.cg_a(3);
        var_cg_k = aj2.cg_a(4);
        var_cg_c = aj2.cg_a(5);
        var_cg_d = aj2.cg_a(6);
        if (x == null) {
            x = cg.a("/buttonBR.png");
        }
        if (q == null) {
            q = cg.a("/buttonLR.png");
        }
        rpg.a.c();
        var_ch_i = new ch("/t/sm");
        rpg.a.c();
        var_s_a = s.s_a("/hero/hs", "/img/hs");
        rpg.a.c();
        var_cg_e = cg.a("/title.png");
        rpg.a.c();
        if (var_ch_h == null) {
            var_ch_h = new ch("/t/nui");
        }
        aj2 = new aj("/img/gm");
        var_cg_arr_b = new cg[6];
        for (int i2 = 0; i2 < 6; ++i2) {
            rpg.e.var_cg_arr_b[i2] = aj2.cg_a(i2);
        }
        rpg.a.c();
    }

    public final ca ca_a() {
        byte[] byArray = rpg.e.a("/hero/h" + di.var_byte_b);
        ca ca2 = new ca();
        ca2.a(byArray, true);
        for (int i2 = 0; i2 <= 7; ++i2) {
            rpg.e.a(ca2, i2);
        }
        ca2.a();
        return ca2;
    }

    public final void b() {
        int n2;
        aj aj2 = new aj("/img/em");
        var_cg_arr_a = aj2.cg_arr_a();
        aj2 = new aj("/img/gm");
        var_cg_arr_c = new cg[2];
        for (n2 = 0; n2 < 2; ++n2) {
            rpg.e.var_cg_arr_c[n2] = aj2.cg_a(n2 + 6);
        }
        rpg.a.c();
        rpg.e.c();
        rpg.a.c();
        var_cg_arr_h = new cg[8];
        var_cg_arr_i = new cg[4];
        var_cg_arr_j = new cg[2];
        aj2 = new aj("/img/etc");
        var_cg_g = aj2.cg_a(0);
        for (n2 = 0; n2 < 4; ++n2) {
            rpg.e.var_cg_arr_h[n2] = aj2.cg_a(n2 + 1);
            rpg.e.var_cg_arr_i[n2] = cg.a("/miss" + n2 + ".png");
        }
        rpg.e.var_cg_arr_h[4] = cg.a("/yellowNum.png");
        rpg.e.var_cg_arr_h[5] = cg.a("/redNum.png");
        rpg.e.var_cg_arr_h[6] = cg.a("/yellowNumBig.png");
        rpg.e.var_cg_arr_h[7] = cg.a("/redNumBig.png");
        for (n2 = 0; n2 < 2; ++n2) {
            rpg.e.var_cg_arr_j[n2] = cg.a("/block" + n2 + ".png");
        }
        rpg.a.c();
        var_cg_h = aj2.cg_a(11);
        n = aj2.cg_a(12);
        var_cg_i = aj2.cg_a(13);
        var_cg_j = aj2.cg_a(14);
        if (rpg.a.var_int_a > 120 && rpg.a.var_int_a <= 176) {
            var_cg_k = aj2.cg_a(15);
        }
        if (x == null) {
            x = cg.a("/buttonBR.png");
        }
        if (q == null) {
            q = cg.a("/buttonLR.png");
        }
        if (rpg.a.var_int_a == 320) {
            var_cg_l = cg.a("/_imgSkull.png");
        }
        var_cg_m = aj2.cg_a(16);
        aj2.cg_a(17);
        o = cg.a("/ff.png");
        p = cg.a("/minimap1.png");
        rpg.a.c();
        aj2 = new aj("/img/si");
        var_cg_arr_g = aj2.cg_arr_a();
        rpg.a.c();
        var_s_a = new s();
        var_s_a.void_a("/hero/target", "/img/et");
        rpg.a.c();
        bq.g();
        var_ch_j = new ch("/t/qm");
        var_ch_k = new ch("/t/qs");
    }

    public static void c() {
        aj aj2 = new aj("/img/sk");
        var_cg_f = aj2.cg_a(di.var_byte_b);
    }

    public final void d() {
        var_cg_arr_a = null;
        var_cg_arr_f = null;
        var_ca_a = null;
        if (di.var_g_a != null) {
            g.h();
        }
        dt.a();
        var_cg_arr_c = null;
        var_cg_arr_c = null;
        var_cg_f = null;
        n = null;
        o = null;
        var_cg_g = null;
        var_cg_arr_h = null;
        var_cg_arr_i = null;
        var_cg_h = null;
        var_cg_i = null;
        var_cg_j = null;
        var_cg_m = null;
        if (var_cg_k != null) {
            var_cg_k = null;
        }
        if (var_cg_l != null) {
            var_cg_l = null;
        }
        if (x != null) {
            x = null;
        }
        if (q != null) {
            q = null;
        }
        var_cg_arr_g = null;
        di.g();
        var_ch_j = null;
        var_ch_k = null;
    }

    private static void h() {
        var_cg_arr_f = null;
        var_cg_arr_f = new cg[24];
    }

    public final void void_a(byte[] byArray) {
        aj aj2 = null;
        if (var_cg_arr_f == null) {
            rpg.e.h();
        }
        int n2 = -1;
        for (int i2 = 0; i2 < 6; ++i2) {
            if (byArray[i2] < 0) continue;
            int n3 = byArray[i2];
            int n4 = n3 / 4;
            n3 -= n4 << 2;
            if (n4 != n2) {
                n2 = n4;
                aj2 = new aj("/img/f" + n4);
            }
            rpg.e.var_cg_arr_f[byArray[i2]] = aj2.cg_a(n3);
        }
    }

    public static void a(byte by2, byte by3) {
        aj aj2 = new aj("/img/s");
        boolean bl2 = false;
        if (by2 >= 7 && by2 <= 17) {
            bl2 = true;
        }
        if (by3 >= 7 && by3 <= 17) {
            bl2 = true;
        }
        var_cg_arr_e = new cg[2];
        for (by2 = 0; by2 < 2; by2 = (byte)(by2 + 1)) {
            rpg.e.var_cg_arr_e[by2] = aj2.cg_a(by2 + (bl2 ? 2 : 0));
        }
    }

    public static void a(int n2, int n3, byte[] byArray, byte[] byArray2, byte[] byArray3) {
        if (n3 < 0) {
            n3 += 256;
        }
        dt.a((byte)n2, (short)n3, byArray, byArray2, byArray3);
    }

    public static void e() {
        ac.a();
        var_ch_b = new ch("/t/com");
        var_ch_c = new ch("/t/m");
        var_ch_d = new ch("/t/c");
        var_ch_a = new ch("/t/lot");
    }

    public static void f() {
        int n2;
        var_ch_g = new ch("/t/it");
        rpg.a.c();
        var_ch_e = new ch("/t/h");
        var_ch_f = new ch("/t/a");
        rpg.a.c();
        aj aj2 = new aj("/img/glb");
        r = aj2.cg_a(0);
        t = aj2.cg_a(1);
        u = aj2.cg_a(2);
        s = aj2.cg_a(3);
        var_cg_arr_d = new cg[6];
        for (n2 = 0; n2 < 6; ++n2) {
            rpg.e.var_cg_arr_d[n2] = aj2.cg_a(n2 + 4);
        }
        aj2 = new aj("/img/it");
        var_cg_arr_k = aj2.cg_arr_a();
        rpg.a.c();
        aj2 = new aj("/img/gt");
        var_cg_arr_l = new cg[8];
        for (n2 = 0; n2 < 8; ++n2) {
            rpg.e.var_cg_arr_l[n2] = aj2.cg_a(n2);
        }
        v = aj2.cg_a(8);
        w = aj2.cg_a(9);
        var_cg_arr_m = new cg[3];
        for (n2 = 0; n2 < 3; ++n2) {
            rpg.e.var_cg_arr_m[n2] = aj2.cg_a(n2 + 10);
        }
    }

    public static void g() {
        byte[] byArray;
        bq.b();
        bq.f();
        rpg.e.h();
        int n2 = di.var_byte_a;
        if (n2 < 0) {
            n2 += 256;
        }
        System.out.println("go to map : " + n2);
        if (g.var_cg_a != null) {
            g.var_cg_a = null;
        }
        if (di.var_h_a != null) {
            di.var_h_a = null;
        }
        do do_ = di.var_do_a;
        do_.d(true);
        do_.o_a().a(true);
        g.e();
        if (di.var_g_a != null) {
            di.var_g_a.d(do_);
            do_.var_byte_arr_b = null;
            do_.var_byte_a = (byte)null;
            g.h();
            di.var_g_a = null;
        }
        if (am.var_s_arr_a == null) {
            am.var_s_arr_a = null;
        }
        if (am.var_byte_arr_a != null) {
            am.var_byte_arr_a = null;
        }
        if (am.b != null) {
            am.b = null;
        }
        rpg.a.c();
        System.gc();
        Runtime.getRuntime().gc();
        if (n2 < 100) {
            byArray = rpg.e.a("/m/m/" + (n2 < 10 ? "0" : "") + n2 + ".m");
        } else {
            int n3 = n2 % 10;
            byte[] byArray2 = new byte[1];
            byte[] byArray3 = byArray2;
            byArray2[0] = 97;
            byArray3[0] = (byte)(byArray3[0] + ((n2 - n3) / 10 - 10));
            byArray = rpg.e.a("/m/m2/" + new String(byArray3) + n3 + ".m");
        }
        di.var_g_a = new g(di.var_byte_a);
        di.var_g_a.a(byArray);
        di.var_g_a.void_b();
        do_.m();
    }

    /*
     * Loose catch block
     */
    public static final byte[] a(String object) {
        InputStream inputStream;
        block21: {
            block22: {
                inputStream = null;
                inputStream = new Object().getClass().getResourceAsStream((String)object);
                if (inputStream != null) break block21;
                if (!ah.a((String)object)) break block22;
                bh bh2 = new bh((String)object, 1);
                Object object2 = bh2;
                Object object3 = object = (Object)new byte[bh2.var_byte_arr_a != null ? ((bh)object2).var_byte_arr_a.length - ((bh)object2).var_int_a : 0];
                object2 = bh2;
                try {
                    System.arraycopy(((bh)object2).var_byte_arr_a, ((bh)object2).var_int_a, object3, 0, ((Object)object3).length);
                    ((bh)object2).var_int_a += ((Object)object3).length;
                }
                catch (Exception exception) {
                    object2 = exception;
                    exception.printStackTrace();
                }
                v1.var_byte_arr_a = null;
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
                catch (Exception exception) {}
                return object;
            }
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            catch (Exception exception) {}
            return null;
        }
        object = new byte[inputStream.available()];
        inputStream.read((byte[])object);
        Object object4 = object;
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        catch (Exception exception) {}
        return object4;
        catch (IOException iOException) {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            catch (Exception exception) {}
            return null;
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
    }

    public static final byte[] a(String object, int n2) {
        byte[] byArray = null;
        try {
            byte[] byArray2 = rpg.e.a((String)object);
            object = byArray2;
            byArray = rpg.e.a(byArray2, n2);
        }
        catch (Exception exception) {}
        return byArray;
    }

    public static final byte[] a(byte[] byArray, int n2) {
        short s2;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            s2 = rpg.g.short_b(byArray, n3);
            n3 += s2 + 2;
        }
        s2 = rpg.g.short_b(byArray, n3);
        byte[] byArray2 = new byte[s2];
        System.arraycopy(byArray, n3 += 2, byArray2, 0, s2);
        return byArray2;
    }

    public static final boolean boolean_a(byte[] byArray) {
        byte by2 = 0;
        int n2 = byArray.length - 1;
        for (int i2 = 0; i2 < n2; ++i2) {
            by2 = (byte)(by2 + byArray[i2]);
        }
        return by2 == byArray[n2];
    }

    public static final void a(int n2) {
        var_s_a.void_a(var_java_lang_String_a + n2, var_java_lang_String_a + "ed" + n2);
    }

    public static void a(ca ca2, int n2) {
        Object object = di.var_do_a;
        byte by2 = 0;
        byte by3 = 0;
        int n3 = -1;
        if ((object = ((do)object).bm_a(var_byte_arr_a[n2])) != null) {
            by2 = ((as)object).var_byte_a;
            by3 = ((bm)object).g;
            n3 = ((bm)object).a;
            if (by3 < 0) {
                by3 = 0;
            }
        }
        switch (n2) {
            case 0: {
                object = "/hero/" + n2 + "/" + (by3 < 10 ? "0" : "") + by3;
                break;
            }
            case 1: 
            case 2: 
            case 3: {
                object = "/hero/" + n2 + "/" + (di.boolean_a() ? "" : "l") + (by3 < 10 ? "0" : "") + by3;
                break;
            }
            case 4: {
                object = "/hero/" + n2 + "/" + di.var_byte_b;
                break;
            }
            case 5: {
                object = "/hero/eh";
                break;
            }
            case 6: 
            case 7: {
                if (object == null) {
                    ca2.a(n2);
                    return;
                }
                object = "/hero/w/" + by2 + (by3 < 10 ? "0" : "") + by3;
                break;
            }
            default: {
                return;
            }
        }
        byte[] byArray = null;
        if (n3 >= 0) {
            byArray = rpg.e.a("/hero/h.p", n3);
        }
        ca2.a(n2, (String)object, byArray);
    }

    public static void a(byte[] byArray, byte by2, byte by3, byte[] byArray2) {
        byArray = rpg.e.a(byArray, (int)by2);
        am.a(byArray, by3, byArray2);
    }

    static {
        var_rpg_e_a = new e();
        var_s_arr_a = new s[11];
        var_ch_h = null;
        var_java_lang_String_a = "/img/ed/";
        x = null;
        q = null;
        var_byte_arr_a = new byte[]{1, 4, 0, 6, -1, -1, 3, 5};
    }
}

