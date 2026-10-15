/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import rpg.b;
import rpg.c;
import rpg.d;
import rpg.e;

public final class di
implements d {
    public static boolean var_boolean_a;
    public static boolean var_boolean_b;
    public static boolean var_boolean_c;
    public static boolean var_boolean_d;
    public static boolean var_boolean_e;
    public static byte[] var_byte_arr_a;
    public static boolean var_boolean_f;
    private static final byte[] var_byte_arr_c;
    private static final byte[] var_byte_arr_d;
    private static final boolean[] var_boolean_arr_a;
    public static byte var_byte_a;
    public static g var_g_a;
    public static int var_int_a;
    public static int var_int_b;
    public static int var_int_c;
    public static int var_int_d;
    public static boolean var_boolean_g;
    public static boolean var_boolean_h;
    public static boolean var_boolean_i;
    private static byte[] O;
    private static byte[] P;
    private static byte[] Q;
    private static bj var_bj_a;
    private static bj var_bj_b;
    private static bj var_bj_c;
    public static int var_int_e;
    private static int[] var_int_arr_c;
    public static int var_int_f;
    public static long var_long_a;
    public static long var_long_b;
    public static long[] var_long_arr_a;
    private static byte[] R;
    public static byte var_byte_b;
    public static do var_do_a;
    public static h var_h_a;
    public static byte[] var_byte_arr_b;
    public static int[] var_int_arr_a;
    public static int[] var_int_arr_b;
    private static byte[] S;
    private static byte[] T;
    static byte var_byte_c;
    private static byte m;
    public static byte var_byte_d;
    private static byte n;
    public static byte var_byte_e;
    public static byte var_byte_f;
    public static byte var_byte_g;
    public static byte var_byte_h;
    private static final byte[] U;
    public static byte[][] var_byte_arr_arr_a;
    public static byte var_byte_i;
    public static byte j;
    public static byte k;
    public static long var_long_c;
    private static long var_long_d;
    public static byte l;

    static final synchronized void a(byte by2, byte by3, byte by4, byte by5) {
        var_byte_e = by3;
        var_byte_f = by4;
        var_byte_g = by5;
        n = by2;
    }

    public static final synchronized void a(byte by2, byte by3, byte by4) {
        di.a((byte)3, by3, by4, (byte)0);
    }

    public static final synchronized void a(byte by2, byte by3) {
        di.a(by2, by3, (byte)0, (byte)0);
    }

    public static final synchronized void void_a(byte by2) {
        di.a(by2, (byte)0, (byte)0, (byte)0);
    }

    public static final void void_a() {
        if (n == 0) {
            return;
        }
        byte by2 = n;
        n = 0;
        block0 : switch (by2) {
            case 11: {
                bs.bs_a().a((byte)2, false);
                return;
            }
            case 1: {
                bs.bs_a().a((byte)4, false);
                return;
            }
            case 2: {
                var_g_a.a(var_do_a);
                var_do_a.void_b(!g.var_boolean_c || g.var_boolean_f);
                bs.h();
                var_do_a.a((short)(var_byte_e << 4), (short)(var_byte_f << 4));
                var_do_a.void_c(var_byte_g);
                di.a((byte)0, (byte)0, (byte)0, (byte)0);
                var_do_a.void_a((byte)1);
                var_do_a.E();
                var_do_a.u();
                var_g_a.c(var_do_a);
                di.void_c();
                var_int_c = var_int_a;
                var_int_d = var_int_b;
                rpg.c.rpg_c_a().f();
                bs.var_boolean_c = true;
                if (df.boolean_g()) {
                    di.a((byte)3, (byte)4, (byte)1);
                } else {
                    di.a((byte)3, (byte)3, (byte)1);
                }
                if (k == 0) break;
                k = 0;
                di.k();
                return;
            }
            case 3: {
                var_byte_d = var_byte_e;
                switch (var_byte_f) {
                    case 0: {
                        rpg.c.a((int)var_byte_g);
                        break block0;
                    }
                    case 1: {
                        rpg.c.rpg_c_a().f();
                        break block0;
                    }
                    case 2: {
                        rpg.c.rpg_c_a().g();
                        break block0;
                    }
                    case 3: {
                        rpg.c.rpg_c_a().h();
                    }
                }
                return;
            }
            case 6: {
                var_byte_d = (byte)5;
                ax.ax_a().void_a();
                ax.ax_a().c(var_byte_e);
                return;
            }
            case 7: {
                var_byte_d = (byte)3;
                ax.ax_a().g();
                switch (var_byte_e) {
                    case 1: {
                        rpg.e.rpg_e_a().d();
                        bs.bs_a().a((byte)2, false);
                        break block0;
                    }
                    case 2: {
                        di.b(T[0], T[1], T[2], (byte)2);
                    }
                }
                return;
            }
            case 8: {
                int n2;
                by2 = var_byte_e;
                if (by2 == 2) {
                    if (var_byte_h < 2) {
                        var_byte_h = (byte)(var_byte_h + 1);
                    }
                    di.bj_a((byte)19).void_a();
                    var_do_a.void_a((byte)0, var_do_a.int_f((byte)0));
                    var_do_a.void_a((byte)1, var_do_a.int_f((byte)1));
                    var_do_a.void_a((byte)3, var_do_a.int_f((byte)3));
                    di.a((int)S[0], (int)S[1], (int)S[2]);
                    di.n();
                } else {
                    di.f();
                    di.h();
                    var_long_d = rpg.g.a();
                }
                int n3 = by2 == 2 ? 1 : 0;
                int n4 = n3;
                int n5 = n3 != 0 ? 31 : 32;
                for (n2 = 0; n2 < n5; ++n2) {
                    di.O[n2] = 0;
                }
                if (n4 != 0) {
                    for (n2 = n5 << 3; n2 < 250; ++n2) {
                        di.void_d(n2);
                    }
                }
                for (n4 = 0; n4 < 32; ++n4) {
                    di.P[n4] = 0;
                }
                for (n4 = 0; n4 < 140; ++n4) {
                    di.Q[n4] = -1;
                }
                if (n3 == 0) {
                    for (n4 = 0; n4 < 10; ++n4) {
                        di.U[n4] = 0;
                    }
                }
                n4 = 1;
                if (by2 == 0) {
                    var_long_c = 0L;
                    var_byte_h = 0;
                    k = 0;
                    l = 1;
                    var_int_e = 0;
                    di.o();
                    var_do_a.l();
                    var_do_a.void_a(true);
                    di.n();
                    as as2 = as.a((byte)20, (byte)1);
                    var_bj_c.a(as2, 1);
                } else if (by2 == 1) {
                    int n6;
                    if (!di.boolean_a(false)) {
                        n6 = 0;
                    } else {
                        var_do_a.j();
                        var_do_a.void_i();
                        n6 = n4 = 1;
                    }
                }
                if (n4 != 0) {
                    bs.bs_a().a((byte)3, false);
                } else {
                    rpg.b.void_a();
                    i.i_a().var_byte_a = 0;
                    rpg.e.rpg_e_a().d();
                    bs.bs_a().a((byte)2, false);
                    i.i_a().var_n_b = new br((n)i.i_a(), rpg.e.var_ch_i.a(13), '\u0000');
                }
                rpg.b.void_b();
                return;
            }
            case 9: {
                if (rpg.c.var_boolean_b) {
                    bq.b((byte)15, false);
                }
                bs.bs_a().n = 0;
                di.void_c((byte)7);
            }
        }
    }

    public static final void void_a(int n2) {
        di.a((byte)8, (byte)n2);
    }

    public static final void void_b() {
        di.a((byte)3, (byte)2, (byte)3);
    }

    public static final void b(byte by2, byte by3, byte by4, byte by5) {
        var_byte_a = by2;
        di.a((byte)1, by3, by4, by5);
    }

    public static final void void_c() {
        var_int_a = bs.l - ((du)di.var_do_a).h;
        var_int_b = bs.m - ((du)di.var_do_a).i;
    }

    public static final void a(boolean bl2, boolean bl3) {
        if (bl3) {
            byte by2 = di.var_do_a.var_byte_c;
            if (bl2) {
                var_int_b -= var_byte_arr_c[rpg.c.var_byte_c] * rpg.d.I[by2];
                var_int_a -= var_byte_arr_c[rpg.c.var_byte_c] * rpg.d.H[by2];
            }
            if (!var_boolean_arr_a[by2] && var_int_d != var_int_b) {
                var_int_d += (var_int_b - var_int_d + 1) / var_byte_arr_d[rpg.c.var_byte_c] - 1;
            }
            if (var_boolean_arr_a[by2] && var_int_c != var_int_a) {
                var_int_c += (var_int_a - var_int_c + 1) / var_byte_arr_d[rpg.c.var_byte_c] - 1;
            }
            return;
        }
        var_int_c += (var_int_a - var_int_c + 1) / var_byte_arr_d[rpg.c.var_byte_c] - 1;
        var_int_d += (var_int_b - var_int_d + 1) / var_byte_arr_d[rpg.c.var_byte_c] - 1;
    }

    public static final void d() {
        if (var_byte_c != 0 && !((du)di.var_do_a).j && !((du)di.var_do_a).k) {
            di.b(var_byte_c, m);
            di.c((byte)0, (byte)0);
        }
        if (!g.boolean_a()) {
            var_do_a.void_c();
            var_g_a.c(var_do_a);
            cd.C();
            var_g_a.boolean_a(di.var_do_a.s, di.var_do_a.t);
            var_g_a.f();
            var_g_a.d();
            if (!var_boolean_b && di.var_g_a.var_byte_b == 11) {
                var_boolean_b = true;
                rpg.b.boolean_a();
                var_boolean_f = true;
                var_byte_arr_a = rpg.e.var_ch_a.a(12);
            }
        }
    }

    public static final void void_b(byte by2) {
        switch (di.var_do_a.var_byte_b) {
            case 1: {
                di.b((byte)2, by2);
                di.c((byte)0, (byte)0);
                return;
            }
            case 2: {
                if (di.boolean_c()) break;
                di.c((byte)2, by2);
                return;
            }
            case 3: 
            case 9: {
                var_do_a.void_g(by2);
            }
        }
    }

    public static final void e() {
        var_do_a.void_e();
        di.c((byte)1, di.var_do_a.var_byte_c);
    }

    public static final void void_b(int n2) {
        if (!var_do_a.boolean_d((byte)n2)) {
            return;
        }
        switch (di.var_do_a.var_byte_b) {
            case 2: {
                di.c((byte)3, di.var_do_a.var_byte_c);
                return;
            }
            case 1: {
                di.b((byte)3, var_do_a.byte_b());
            }
        }
    }

    public static final void a(int n2, int n3, int n4) {
        di.T[0] = (byte)n4;
        di.T[1] = (byte)n2;
        di.T[2] = (byte)n3;
    }

    private static void n() {
        di.c(rpg.h.a[0], rpg.h.a[1], rpg.h.a[2], rpg.h.a[3]);
    }

    private static void c(byte by2, byte by3, byte by4, byte by5) {
        var_byte_a = by2;
        var_byte_e = by3;
        var_byte_f = by4;
        var_byte_g = by5;
    }

    private static void o() {
        var_do_a = do.do_a(var_byte_b);
    }

    public static final void b(byte by2, byte by3) {
        var_do_a.void_a(by2);
        var_do_a.void_c(by3);
    }

    public static final void c(byte by2, byte by3) {
        var_byte_c = by2;
        m = by3;
    }

    public static final boolean boolean_a(int n2) {
        byte by2 = O[n2 / 8];
        return (by2 >> n2 % 8 & 1) == 1;
    }

    public static final void void_c(int n2) {
        byte by2 = O[n2 / 8];
        di.O[n2 / 8] = (byte)(by2 | 1 << n2 % 8);
        if (n2 == 250 || n2 == 251) {
            switch (n2) {
                case 250: {
                    if (var_boolean_g) break;
                    var_boolean_g = true;
                    rpg.b.boolean_a();
                    return;
                }
                case 251: {
                    if (var_boolean_h) break;
                    var_boolean_h = true;
                    rpg.b.boolean_a();
                }
            }
        }
    }

    private static boolean boolean_c(int n2) {
        byte by2 = U[n2 / 8];
        return (by2 >> n2 % 8 & 1) == 1;
    }

    public static final void void_d(int n2) {
        byte by2 = O[n2 / 8];
        di.O[n2 / 8] = (byte)(by2 & ~(1 << n2 % 8));
    }

    public static final byte byte_a(int n2) {
        byte by2 = P[n2 / 4];
        return (byte)(by2 >> (3 - n2 % 4 << 1) & 3);
    }

    public static final void a(int n2, byte by2) {
        byte by3 = (byte)(192 >> (n2 % 4 << 1));
        di.P[n2 / 4] = (byte)(P[n2 / 4] & ~by3);
        int n3 = n2 / 4;
        P[n3] = (byte)(P[n3] | (byte)(by2 << (3 - n2 % 4 << 1)));
        var_g_a.void_a();
        if (by2 == 2) {
            by2 = di.var_g_a.var_byte_b;
            if (by2 < 0) {
                by2 = (byte)(by2 + 256);
            }
            System.out.println("*************************************");
            System.out.println("finished task " + n2 + " on map " + by2);
            System.out.println("*************************************");
            return;
        }
        if (by2 == 1) {
            by2 = di.var_g_a.var_byte_b;
            if (by2 < 0) {
                by2 = (byte)(by2 + 256);
            }
            System.out.println("#####################################");
            System.out.println("received task " + n2 + " on map " + by2);
            System.out.println("#####################################");
        }
    }

    public static final void b(int n2, byte by2) {
        if (n2 < 0) {
            n2 += 256;
        }
        di.Q[n2] = by2;
    }

    public static final void c(int n2, byte by2) {
        if (Q[n2] < 0) {
            return;
        }
        int n3 = n2;
        Q[n3] = (byte)(Q[n3] - 1);
        if (Q[n2] == 0) {
            di.Q[n2] = -1;
            df.a(by2);
        }
    }

    public static final void void_c(byte by2) {
        var_byte_d = by2;
        if (var_byte_d == 3) {
            bs.var_boolean_c = true;
        }
    }

    public static void f() {
        var_bj_a = new bj(28);
        var_bj_b = new bj(28);
        var_bj_c = new bj(28);
    }

    public static void g() {
        var_bj_a = null;
        var_bj_b = null;
        var_bj_c = null;
    }

    public static bj bj_a(byte by2) {
        switch (by2) {
            case 16: 
            case 18: {
                return var_bj_b;
            }
            case 17: 
            case 19: 
            case 20: {
                return var_bj_c;
            }
        }
        return var_bj_a;
    }

    public static bj bj_a() {
        return var_bj_a;
    }

    public static bj bj_b() {
        return var_bj_c;
    }

    public static bj bj_c() {
        return var_bj_b;
    }

    public static final void e(int n2) {
        if ((var_int_e += n2) < 0) {
            var_int_e = 0;
        } else if (var_int_e > 999999999) {
            var_int_e = 999999999;
        }
        bs.var_boolean_c = true;
    }

    public static void h() {
        var_byte_arr_b = new byte[6];
        var_int_arr_a = new int[6];
        var_int_arr_b = new int[6];
        for (int i2 = 0; i2 < 6; ++i2) {
            di.var_byte_arr_b[i2] = -1;
            di.var_int_arr_a[i2] = -1;
            di.var_int_arr_b[i2] = -1;
        }
    }

    public static void a(boolean bl2, byte by2) {
        if (var_byte_arr_b[bl2 ? 5 : 4] == by2) {
            di.var_byte_arr_b[bl2 ? 5 : 4] = -1;
        }
        di.var_byte_arr_b[bl2 ? 4 : 5] = by2;
        bs.var_boolean_d = true;
    }

    public static as as_a(boolean n2) {
        n2 = var_byte_arr_b[n2 != 0 ? 4 : 5];
        as as2 = null;
        if (n2 > 0) {
            as2 = var_bj_c.as_a((byte)20, (byte)n2);
        }
        return as2;
    }

    public static void d(int n2, byte by2) {
        int n3 = di.boolean_d(n2) ? 0 : 2;
        for (int i2 = 0; i2 < 2; ++i2) {
            if (var_byte_arr_b[i2 + n3] != by2) continue;
            di.var_byte_arr_b[i2 + n3] = -1;
        }
        di.var_byte_arr_b[n2] = by2;
        di.f(n2);
        if (!di.boolean_d(n2)) {
            var_do_a.o_a().b(n2);
        }
    }

    private static boolean boolean_d(int n2) {
        return n2 < 2;
    }

    public static void void_a(byte by2, boolean bl2) {
        int n2 = bl2 ? 0 : 2;
        di.var_byte_arr_b[by2 + n2] = -1;
    }

    public static boolean boolean_a(byte by2, boolean bl2) {
        int n2 = bl2 ? 0 : 2;
        for (int i2 = 0; i2 < 2; ++i2) {
            if (var_byte_arr_b[i2 + n2] != by2) continue;
            return true;
        }
        return false;
    }

    public static boolean boolean_b(int n2) {
        return n2 == 0 || n2 == 1;
    }

    private static void f(int n2) {
        di.g(n2);
        di.var_int_arr_a[n2] = var_int_arr_b[n2];
    }

    public static void void_b(byte by2, boolean bl2) {
        int n2 = bl2 ? 0 : 2;
        for (int i2 = 0; i2 < 2; ++i2) {
            if (var_byte_arr_b[n2 + i2] != by2) continue;
            di.f(n2 + i2);
            return;
        }
    }

    private static void g(int n2) {
        byte by2 = var_byte_arr_b[n2];
        if (by2 < 0) {
            return;
        }
        int n3 = di.var_int_arr_b[n2] = di.boolean_b(n2) ? var_do_a.int_d(by2) : var_do_a.o_a().int_d(by2);
        if (var_int_arr_a[n2] > var_int_arr_b[n2]) {
            di.var_int_arr_a[n2] = var_int_arr_b[n2];
        }
    }

    public static final void i() {
        di.var_int_arr_a[4] = 10;
    }

    public static void j() {
        for (int i2 = 0; i2 < 6; ++i2) {
            di.g(i2);
        }
    }

    public static final boolean boolean_a() {
        return var_byte_b % 2 == 0;
    }

    public static final boolean boolean_b() {
        return var_byte_b == 1 || var_byte_b == 3 || var_byte_b == 2;
    }

    public static final void k() {
        var_long_a = di.var_long_arr_a[di.j] = System.currentTimeMillis();
        var_long_b = di.var_long_arr_a[di.j];
        byte by2 = j;
        rpg.b.c(di.byte_arr_a(by2), by2);
        byte[] byArray = di.byte_arr_a();
        byte[] byArray2 = var_g_a.byte_arr_a();
        byte[] byArray3 = var_do_a.byte_arr_a();
        byte[] byArray4 = var_do_a.o_a().byte_arr_a();
        byte[] byArray5 = new byte[13 + byArray.length + byArray2.length + byArray3.length + byArray4.length + 8];
        rpg.g.a(var_int_f, byArray5, 0);
        byArray5[4] = j;
        rpg.g.a(var_long_b, byArray5, 5);
        int n2 = di.a(byArray, byArray5, 13);
        n2 = di.a(byArray2, byArray5, n2);
        n2 = di.a(byArray3, byArray5, n2);
        di.a(byArray4, byArray5, n2);
        rpg.b.a(byArray5, j);
        di.l();
    }

    public static final boolean boolean_a(boolean bl2) {
        if (!di.boolean_b(j, bl2)) {
            return false;
        }
        if (!di.boolean_c(j)) {
            return false;
        }
        if (!bl2) {
            var_do_a.void_a(false);
        }
        return true;
    }

    /*
     * Loose catch block
     */
    private static final boolean boolean_b(byte by2, boolean bl2) {
        block34: {
            FilterInputStream filterInputStream;
            ByteArrayInputStream byteArrayInputStream;
            block35: {
                block33: {
                    block32: {
                        byte[] byArray = rpg.b.a(by2);
                        byteArrayInputStream = null;
                        filterInputStream = null;
                        byteArrayInputStream = new ByteArrayInputStream(byArray);
                        filterInputStream = new DataInputStream(byteArrayInputStream);
                        ((DataInputStream)filterInputStream).readInt();
                        byte by3 = ((DataInputStream)filterInputStream).readByte();
                        if (by2 == by3) break block32;
                        try {
                            filterInputStream.close();
                            byteArrayInputStream.close();
                        }
                        catch (Exception exception) {}
                        return false;
                    }
                    var_long_b = ((DataInputStream)filterInputStream).readLong();
                    if (!bl2) break block33;
                    try {
                        filterInputStream.close();
                        byteArrayInputStream.close();
                    }
                    catch (Exception exception) {}
                    return true;
                }
                short s2 = ((DataInputStream)filterInputStream).readShort();
                by2 = (byte)s2;
                byte[] byArray = new byte[s2];
                ((DataInputStream)filterInputStream).read(byArray);
                ByteArrayInputStream byteArrayInputStream2 = null;
                FilterInputStream filterInputStream2 = null;
                byteArrayInputStream2 = new ByteArrayInputStream(byArray);
                filterInputStream2 = new DataInputStream(byteArrayInputStream2);
                ((DataInputStream)filterInputStream2).read(O);
                ((DataInputStream)filterInputStream2).read(P);
                ((DataInputStream)filterInputStream2).read(Q);
                ((DataInputStream)filterInputStream2).read(T);
                ((DataInputStream)filterInputStream2).read(var_byte_arr_b);
                ((DataInputStream)filterInputStream2).read(U);
                l = ((DataInputStream)filterInputStream2).readByte();
                try {
                    filterInputStream2.close();
                    byteArrayInputStream2.close();
                }
                catch (Exception exception) {}
                break block35;
                catch (Exception exception) {
                    try {
                        if (filterInputStream2 != null) {
                            filterInputStream2.close();
                        }
                        if (byteArrayInputStream2 != null) {
                            byteArrayInputStream2.close();
                        }
                    }
                    catch (Exception exception2) {}
                }
                catch (Throwable throwable) {
                    try {
                        if (filterInputStream2 != null) {
                            filterInputStream2.close();
                        }
                        if (byteArrayInputStream2 != null) {
                            byteArrayInputStream2.close();
                        }
                    }
                    catch (Exception exception) {}
                    throw throwable;
                }
            }
            short s3 = ((DataInputStream)filterInputStream).readShort();
            byte[] byArray = new byte[s3];
            ((DataInputStream)filterInputStream).read(byArray);
            di.c(byArray[0], byArray[1], byArray[2], byArray[3]);
            di.o();
            short s4 = ((DataInputStream)filterInputStream).readShort();
            byte[] byArray2 = new byte[s4];
            ((DataInputStream)filterInputStream).read(byArray2);
            var_do_a.a(byArray2);
            short s5 = ((DataInputStream)filterInputStream).readShort();
            byte[] byArray3 = new byte[s5];
            ((DataInputStream)filterInputStream).read(byArray3);
            var_do_a.o_a().void_a(byArray3);
            try {
                filterInputStream.close();
                byteArrayInputStream.close();
            }
            catch (Exception exception) {}
            break block34;
            catch (Exception exception) {
                try {
                    if (filterInputStream != null) {
                        filterInputStream.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    break block34;
                }
                catch (Exception exception3) {}
                break block34;
            }
            catch (Throwable throwable) {
                try {
                    if (filterInputStream != null) {
                        filterInputStream.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                }
                catch (Exception exception) {}
                throw throwable;
            }
        }
        return true;
    }

    public static final void l() {
        byte[] byArray = var_bj_a.byte_arr_a();
        byte[] byArray2 = var_bj_b.byte_arr_a();
        byte[] byArray3 = var_bj_c.byte_arr_a();
        byte[] byArray4 = new byte[8];
        rpg.g.a(var_int_e, byArray4, 0);
        byArray4[5] = byArray4[2];
        byArray4[6] = byArray4[3];
        byArray4[2] = (byte)(byArray4[5] | byArray4[6]);
        byArray4[3] = (byte)(byArray4[0] & byArray4[1]);
        byArray4[4] = (byte)(byArray4[0] | byArray4[5]);
        byArray4[7] = (byte)(byArray4[1] & byArray4[6]);
        byte[] byArray5 = new byte[13 + byArray.length + byArray2.length + byArray3.length + 6 + 8];
        rpg.g.a(var_int_f, byArray5, 0);
        byArray5[4] = j;
        rpg.g.a(var_long_a, byArray5, 5);
        int n2 = di.a(byArray, byArray5, 13);
        n2 = di.a(byArray2, byArray5, n2);
        n2 = di.a(byArray3, byArray5, n2);
        System.arraycopy(byArray4, 0, byArray5, n2, 8);
        rpg.b.b(byArray5, j);
    }

    private static int a(byte[] byArray, byte[] byArray2, int n2) {
        int n3 = byArray.length;
        rpg.g.a((short)n3, byArray2, n2);
        System.arraycopy(byArray, 0, byArray2, n2 += 2, n3);
        return n2 += n3;
    }

    /*
     * Loose catch block
     */
    private static boolean boolean_c(byte by2) {
        block19: {
            FilterInputStream filterInputStream;
            ByteArrayInputStream byteArrayInputStream;
            block18: {
                byte by3;
                block17: {
                    byte[] byArray = rpg.b.b(by2);
                    byteArrayInputStream = null;
                    filterInputStream = null;
                    byteArrayInputStream = new ByteArrayInputStream(byArray);
                    filterInputStream = new DataInputStream(byteArrayInputStream);
                    ((DataInputStream)filterInputStream).readInt();
                    by3 = ((DataInputStream)filterInputStream).readByte();
                    if (by2 == by3) break block17;
                    try {
                        filterInputStream.close();
                        byteArrayInputStream.close();
                    }
                    catch (Exception exception) {}
                    return false;
                }
                var_long_a = ((DataInputStream)filterInputStream).readLong();
                short s2 = ((DataInputStream)filterInputStream).readShort();
                by2 = (byte)s2;
                byte[] byArray = new byte[s2];
                ((DataInputStream)filterInputStream).read(byArray);
                var_bj_a.a(byArray);
                short s3 = ((DataInputStream)filterInputStream).readShort();
                byte[] byArray2 = new byte[s3];
                ((DataInputStream)filterInputStream).read(byArray2);
                var_bj_b.a(byArray2);
                short s4 = ((DataInputStream)filterInputStream).readShort();
                byte[] byArray3 = new byte[s4];
                ((DataInputStream)filterInputStream).read(byArray3);
                var_bj_c.a(byArray3);
                byArray3 = new byte[8];
                ((DataInputStream)filterInputStream).read(byArray3);
                by3 = byArray3[2] != (byte)(byArray3[5] | byArray3[6]) ? (byte)1 : 0;
                by3 = by3 != 0 || byArray3[3] != (byte)(byArray3[0] & byArray3[1]) ? (byte)1 : 0;
                by3 = by3 != 0 || byArray3[4] != (byte)(byArray3[0] | byArray3[5]) ? (byte)1 : 0;
                if ((by3 = by3 != 0 || byArray3[7] != (byte)(byArray3[1] & byArray3[6]) ? (byte)1 : 0) == 0) {
                    byArray3[2] = byArray3[5];
                    byArray3[3] = byArray3[6];
                    var_int_e = rpg.g.int_a(byArray3, 0);
                    break block18;
                }
                var_int_e = 0;
            }
            try {
                filterInputStream.close();
                byteArrayInputStream.close();
            }
            catch (Exception exception) {}
            break block19;
            catch (Exception exception) {
                try {
                    if (filterInputStream != null) {
                        filterInputStream.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    break block19;
                }
                catch (Exception exception2) {}
                break block19;
            }
            catch (Throwable throwable) {
                try {
                    if (filterInputStream != null) {
                        filterInputStream.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                }
                catch (Exception exception) {}
                throw throwable;
            }
        }
        return true;
    }

    public static boolean boolean_a(byte by2) {
        return (k & by2) != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final byte[] byte_arr_a(byte by2) {
        byte[] byArray;
        int n2;
        int n3;
        int n4;
        for (n4 = 0; n4 <= 78; ++n4) {
            if (di.byte_a(n4) != 2) continue;
            n3 = n4;
            byte by3 = U[n3 / 8];
            di.U[n3 / 8] = (byte)(by3 | 1 << n3 % 8);
        }
        n4 = 0;
        for (n2 = 11; n2 <= 40; ++n2) {
            if (!di.boolean_c(n2)) continue;
            n4 = (byte)(n4 + 1);
        }
        n4 = (byte)(n4 << 1);
        for (n2 = 0; n2 <= 10; ++n2) {
            if (!di.boolean_c(n2)) continue;
            n4 = (byte)(n4 + 1);
        }
        for (n2 = 50; n2 <= 78; ++n2) {
            if (!di.boolean_c(n2)) continue;
            n4 = (byte)(n4 + 1);
        }
        if (di.boolean_b((byte)4)) {
            n4 = (byte)(n4 + 1);
        }
        if (di.boolean_b((byte)5)) {
            n4 = (byte)(n4 + 1);
        }
        byte by3 = (byte)(n4 + var_byte_h);
        n4 = by3;
        n3 = (byte)(by3 > 100 ? 100 : n4);
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)filterOutputStream).writeInt(var_int_f);
            ((DataOutputStream)filterOutputStream).writeByte(by2);
            ((DataOutputStream)filterOutputStream).writeLong(var_long_arr_a[by2]);
            ((DataOutputStream)filterOutputStream).writeByte(var_byte_b);
            ((DataOutputStream)filterOutputStream).writeByte(var_do_a.byte_a());
            ((DataOutputStream)filterOutputStream).writeByte(n3);
            ((DataOutputStream)filterOutputStream).writeByte(var_byte_h);
            ((DataOutputStream)filterOutputStream).writeByte(k);
            long l2 = rpg.g.a();
            var_long_c += l2 - var_long_d;
            var_long_d = rpg.g.a();
            ((DataOutputStream)filterOutputStream).writeLong(var_long_c);
            byArray = var_g_a.byte_arr_b();
            ((DataOutputStream)filterOutputStream).writeByte(byArray.length);
            ((OutputStream)filterOutputStream).write(byArray);
            byArray = byteArrayOutputStream.toByteArray();
        }
        catch (Exception exception) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) return null;
                byteArrayOutputStream.close();
                return null;
            }
            catch (Exception exception2) {
                return null;
            }
        }
        catch (Throwable throwable) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) throw throwable;
                byteArrayOutputStream.close();
                throw throwable;
            }
            catch (Exception exception) {}
            throw throwable;
        }
        try {
            filterOutputStream.close();
            byteArrayOutputStream.close();
            return byArray;
        }
        catch (Exception exception) {}
        return byArray;
    }

    public static final void m() {
        k = 0;
        var_byte_i = 0;
        var_byte_arr_arr_a = new byte[3][];
        var_int_arr_c = new int[3];
        var_long_arr_a = new long[3];
        R = new byte[3];
        for (byte by2 = 0; by2 < 3; by2 = (byte)(by2 + 1)) {
            di.R[by2] = by2;
            di.var_byte_arr_arr_a[by2] = rpg.b.c(by2);
            if (var_byte_arr_arr_a[by2] == null) continue;
            di.var_int_arr_c[by2] = rpg.g.int_a(var_byte_arr_arr_a[by2], 0);
            di.R[by2] = var_byte_arr_arr_a[by2][4];
            di.var_long_arr_a[by2] = rpg.g.long_a(var_byte_arr_arr_a[by2], 5);
            var_byte_i = (byte)(var_byte_i + 1);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final byte[] byte_arr_a() {
        byte[] byArray;
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((OutputStream)filterOutputStream).write(O);
            ((OutputStream)filterOutputStream).write(P);
            ((OutputStream)filterOutputStream).write(Q);
            ((OutputStream)filterOutputStream).write(T);
            ((OutputStream)filterOutputStream).write(var_byte_arr_b);
            ((OutputStream)filterOutputStream).write(U);
            ((DataOutputStream)filterOutputStream).writeByte(l);
            byArray = byteArrayOutputStream.toByteArray();
        }
        catch (Exception exception) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) return null;
                byteArrayOutputStream.close();
                return null;
            }
            catch (Exception exception2) {
                return null;
            }
        }
        catch (Throwable throwable) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) throw throwable;
                byteArrayOutputStream.close();
                throw throwable;
            }
            catch (Exception exception) {}
            throw throwable;
        }
        try {
            filterOutputStream.close();
            byteArrayOutputStream.close();
            return byArray;
        }
        catch (Exception exception) {}
        return byArray;
    }

    public static boolean boolean_c() {
        return var_byte_c == 3 || var_byte_c == 10;
    }

    public static boolean boolean_b(byte by2) {
        switch (by2) {
            case 4: {
                return var_boolean_g;
            }
            case 5: {
                return var_boolean_h;
            }
        }
        return true;
    }

    static {
        var_byte_arr_a = null;
        var_boolean_f = false;
        var_byte_arr_c = new byte[]{0, 15, 30, 35};
        var_byte_arr_d = new byte[]{1, 2, 3, 3};
        var_boolean_arr_a = new boolean[]{false, false, false, true, true};
        var_boolean_g = false;
        var_boolean_h = false;
        var_boolean_i = true;
        O = new byte[32];
        P = new byte[32];
        Q = new byte[140];
        var_int_arr_c = null;
        var_int_f = 0;
        var_long_a = 0L;
        var_long_b = 0L;
        var_long_arr_a = null;
        R = null;
        var_byte_b = 1;
        var_h_a = null;
        S = new byte[]{0, 22, 26};
        T = new byte[]{1, 20, 2};
        var_byte_c = 0;
        m = 0;
        n = 0;
        U = new byte[10];
        var_byte_arr_arr_a = null;
        var_byte_i = 0;
        j = 0;
        k = 0;
        var_long_c = 0L;
        var_long_d = 0L;
        l = 1;
    }
}

