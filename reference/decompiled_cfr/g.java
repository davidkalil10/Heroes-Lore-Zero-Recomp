/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.util.Vector;
import rpg.a;
import rpg.c;
import rpg.d;
import rpg.e;

public final class g
implements d {
    private byte[] var_byte_arr_b;
    byte[] var_byte_arr_a;
    private byte[] var_byte_arr_c = new byte[2];
    private cg[] var_cg_arr_a;
    private int var_int_f;
    public byte var_byte_a = (byte)-1;
    private du var_du_a;
    private du var_du_b;
    private du var_du_c;
    private du var_du_d;
    private final byte[] var_byte_arr_d = new byte[]{33, 55, 49, 13, 20};
    du[][] var_du_arr_arr_a;
    public dx[] var_dx_arr_a;
    public dx[] var_dx_arr_b;
    public dx[] var_dx_arr_c;
    bl[] var_bl_arr_a;
    private Vector var_java_util_Vector_a;
    public byte var_byte_b;
    private byte[][] var_byte_arr_arr_a;
    private byte[] O;
    static int var_int_a;
    public static byte var_byte_c;
    public static byte var_byte_d;
    public short var_short_a;
    public short var_short_b;
    int var_int_b;
    int var_int_c;
    private static int j;
    public static boolean var_boolean_a;
    public static boolean var_boolean_b;
    private static byte var_byte_e;
    private cg[] var_cg_arr_b = new cg[3];
    private static int[] var_int_arr_a;
    public static boolean var_boolean_c;
    public boolean var_boolean_d = false;
    public boolean var_boolean_e = true;
    public static boolean var_boolean_f;
    private static boolean g;
    private cg[] var_cg_arr_c;
    private byte[] P;
    private static cg var_cg_b;
    public static cg var_cg_a;
    private int k = -1;
    private int l = -1;
    private static byte[][] i;
    public int var_int_d;
    public int var_int_e;
    private Vector var_java_util_Vector_b = new Vector();
    private static byte var_byte_f;
    private static final int[] var_int_arr_b;

    public static void void_a(int n2, int n3) {
        if (var_cg_b == null) {
            var_cg_b = cg.a("/chest_opened.png");
        }
        int n4 = var_cg_b.int_a() / 2;
        int n5 = var_cg_b.b();
        rpg.a.var_cm_a.a(var_cg_b, n2 - n4, n3 - n5, 0);
    }

    public g(byte by2) {
        this.c(-1);
        this.var_byte_b = by2;
        var_boolean_c = false;
        this.var_boolean_d = false;
        this.var_boolean_e = true;
        this.var_du_a = null;
        this.var_du_b = null;
        this.var_du_c = null;
        this.var_du_d = null;
        var_byte_e = (byte)-1;
        g g2 = this;
        this.var_java_util_Vector_a = null;
        g2.var_java_util_Vector_a = new Vector(3);
        this.void_a();
    }

    public final int int_a(int n2, int n3) {
        for (int i2 = 0; i2 < i.length; ++i2) {
            if (this.var_byte_b == i[i2][0]) {
                for (int i3 = 1; i3 < i[i2].length; i3 += 3) {
                    if (n2 != i[i2][i3] || n3 != i[i2][i3 + 1]) continue;
                    return i[i2][i3 + 2];
                }
                continue;
            }
            if (this.var_byte_b < i[i2][0]) break;
        }
        if (this.var_byte_b == 89) {
            if (n2 == 16 && n3 == 10) {
                return 19;
            }
        } else if (this.var_byte_b == 90) {
            if (n2 == 9 && n3 == 16) {
                return 20;
            }
        } else if (this.var_byte_b == 92 && n2 == 10 && n3 == 13) {
            return 21;
        }
        return -1;
    }

    public final void void_a() {
        try {
            byte by2;
            int n2;
            boolean bl2 = false;
            int n3 = this.var_byte_b;
            if (n3 < 0) {
                n3 += 256;
            }
            Object object = "/mmi/" + n3;
            object = new DataInputStream(object.getClass().getResourceAsStream((String)object));
            byte[] byArray = new byte[((FilterInputStream)object).available()];
            ((DataInputStream)object).read(byArray);
            ((FilterInputStream)object).close();
            for (n2 = 35; n2 > 0 && (by2 = di.byte_a(n2)) != 1; --n2) {
                if (by2 != 2) continue;
                if (eb.var_boolean_f) {
                    n2 = 10;
                    bl2 = true;
                    break;
                }
                n2 = 0;
                break;
            }
            if (n2 < 36 && n2 > 0) {
                if (bl2 && this.var_byte_b == 8) {
                    this.k = 0;
                    this.l = 0;
                } else if (bl2 && this.var_byte_b == 10) {
                    this.k = 5;
                    this.l = 10;
                } else {
                    this.k = byArray[--n2 << 1];
                    this.l = byArray[(n2 << 1) + 1];
                    if (this.k != -1 || this.l != -1) {
                        if (this.k < 0) {
                            this.k += 256;
                        }
                        if (this.l < 0) {
                            this.l += 256;
                        }
                    }
                }
            }
            System.out.println("taskX = " + this.k + " , taskY = " + this.l);
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public final void a(du du2) {
        this.f(du2);
        this.c(du2);
    }

    public final void b(du du2) {
        this.g(du2);
        this.h(du2);
    }

    private final void f(du du2) {
        du2.a = this.var_du_b;
        du2.b = null;
        if (this.var_du_b != null) {
            this.var_du_b.b = du2;
        }
        this.var_du_b = du2;
        if (this.var_du_a == null) {
            this.var_du_a = this.var_du_b;
        }
    }

    private final void g(du du2) {
        du2.a = this.var_du_d;
        du2.b = null;
        if (this.var_du_d != null) {
            this.var_du_d.b = du2;
        }
        this.var_du_d = du2;
        if (this.var_du_c == null) {
            this.var_du_c = this.var_du_d;
        }
    }

    public final void c(du d2) {
        if (d2.a != null && d2.r + d2.i < d2.a.r + d2.a.i) {
            d2.a.b = d2.b;
            if (d2.b == null) {
                this.var_du_b = d2.a;
            } else {
                d2.b.a = d2.a;
            }
            du du2 = d2.a;
            while (du2 != null && d2.r + d2.i < du2.r + du2.i) {
                du2 = du2.a;
            }
            if (du2 == null) {
                du2 = d2;
                d2 = this;
                du2.b = ((g)d2).var_du_a;
                du2.a = null;
                if (((g)d2).var_du_a != null) {
                    ((g)d2).var_du_a.a = du2;
                }
                ((g)d2).var_du_a = du2;
                if (((g)d2).var_du_b == null) {
                    ((g)d2).var_du_b = ((g)d2).var_du_a;
                }
                return;
            }
            du2.b.a = d2;
            d2.b = du2.b;
            du2.b = d2;
            d2.a = du2;
            return;
        }
        if (d2.b != null && d2.r + d2.i > d2.b.r + d2.b.i) {
            d2.m = true;
            d2.b.a = d2.a;
            if (d2.a == null) {
                this.var_du_a = d2.b;
            } else {
                d2.a.b = d2.b;
            }
            du du3 = d2.b;
            while (du3 != null && d2.r + d2.i > du3.r + du3.i) {
                du3 = du3.b;
            }
            if (du3 == null) {
                this.f((du)d2);
                return;
            }
            du3.a.b = d2;
            d2.a = du3.a;
            du3.a = d2;
            d2.b = du3;
        }
    }

    private void h(du d2) {
        if (d2.a != null && d2.r + d2.i < d2.a.r + d2.a.i) {
            d2.a.b = d2.b;
            if (d2.b == null) {
                this.var_du_d = d2.a;
            } else {
                d2.b.a = d2.a;
            }
            du du2 = d2.a;
            while (du2 != null && d2.r + d2.i < du2.r + du2.i) {
                du2 = du2.a;
            }
            if (du2 == null) {
                du2 = d2;
                d2 = this;
                du2.b = ((g)d2).var_du_c;
                du2.a = null;
                if (((g)d2).var_du_c != null) {
                    ((g)d2).var_du_c.a = du2;
                }
                ((g)d2).var_du_c = du2;
                if (((g)d2).var_du_d == null) {
                    ((g)d2).var_du_d = ((g)d2).var_du_c;
                }
                return;
            }
            du2.b.a = d2;
            d2.b = du2.b;
            du2.b = d2;
            d2.a = du2;
            return;
        }
        if (d2.b != null && d2.r + d2.i > d2.b.r + d2.b.i) {
            d2.m = true;
            d2.b.a = d2.a;
            if (d2.a == null) {
                this.var_du_c = d2.b;
            } else {
                d2.a.b = d2.b;
            }
            du du3 = d2.b;
            while (du3 != null && d2.r + d2.i > du3.r + du3.i) {
                du3 = du3.b;
            }
            if (du3 == null) {
                this.g((du)d2);
                return;
            }
            du3.a.b = d2;
            d2.a = du3.a;
            du3.a = d2;
            d2.b = du3;
        }
    }

    public final byte byte_a(int n2, int n3) {
        if (n2 < 0 || n3 < 0 || n2 >= var_byte_c || n3 >= var_byte_d) {
            return 0;
        }
        byte by2 = (byte)(this.var_byte_arr_a[n3 * var_byte_c + n2] & 0x3F);
        n2 = by2;
        if (by2 <= 0) {
            return -1;
        }
        return (byte)n2;
    }

    public static boolean boolean_a(int n2, int n3) {
        return n2 < 0 || n3 < 0 || n2 >= var_byte_c || n3 >= var_byte_d;
    }

    public final void a(byte[] byArray) {
        byte by2;
        byte by3;
        int n2;
        int n3;
        int n4;
        byte by4;
        byte by5;
        int n5;
        int n6;
        var_boolean_f = false;
        g = false;
        df.void_d();
        int n22 = 0;
        byte[] byArray2 = new byte[]{-1, -1};
        if (this.O != null) {
            System.arraycopy(this.O, 0, byArray2, 0, 2);
        }
        ++n22;
        this.var_byte_a = byArray[0];
        if (this.O == null) {
            this.O = new byte[2];
        }
        ++n22;
        this.O[0] = byArray[1];
        ++n22;
        this.O[1] = byArray[2];
        rpg.a.c();
        this.var_byte_arr_arr_a = new byte[2][];
        for (int i2 = 0; i2 < 2; ++i2) {
            byte by8;
            if ((by8 = byArray[n22++]) <= 0) continue;
            this.var_byte_arr_arr_a[i2] = new byte[by8];
            System.arraycopy(byArray, n22, this.var_byte_arr_arr_a[i2], 0, by8);
            n22 += by8;
        }
        Object object = null;
        int by9 = byArray[n22++];
        this.var_cg_arr_c = new cg[by9];
        this.P = new byte[by9];
        int n7 = -1;
        for (n6 = 0; n6 < by9; ++n6) {
            n5 = -1;
            this.P[n6] = byArray[n22++];
            by5 = this.P[n6];
            if (by5 < 0) {
                by5 += 256;
            }
            by4 = by5;
            int by14 = 0;
            for (n4 = 0; n4 < this.var_byte_arr_d.length; ++n4) {
                if (by5 >= (by14 += this.var_byte_arr_d[n4])) continue;
                n5 = n4;
                by4 -= by14 - this.var_byte_arr_d[n4];
                break;
            }
            if (n7 != n5) {
                n7 = n5;
                object = new aj("/m/ob" + n7);
            }
            this.var_cg_arr_c[n6] = ((aj)object).cg_a(by4);
        }
        rpg.a.c();
        var_byte_c = byArray[n22++];
        var_byte_d = byArray[n22++];
        this.var_short_a = (short)(var_byte_c << 4);
        this.var_short_b = (short)(var_byte_d << 4);
        this.var_du_arr_arr_a = new du[var_byte_d][var_byte_c];
        n6 = var_byte_d * var_byte_c;
        this.var_byte_arr_b = new byte[n6];
        System.arraycopy(byArray, n22, this.var_byte_arr_b, 0, n6);
        rpg.a.c();
        this.var_byte_arr_a = new byte[n6];
        System.arraycopy(byArray, n22 += n6, this.var_byte_arr_a, 0, n6);
        n22 += n6;
        int n8 = byArray[n22++] & 0xFF;
        if (n8 > 0) {
            this.var_dx_arr_a = new dx[n8];
            for (n4 = 0; n4 < n8; ++n4) {
                n5 = byArray[n22];
                by5 = (byte)rpg.g.short_a(byArray, n22 + 1);
                by4 = (byte)rpg.g.short_a(byArray, n22 + 3);
                n22 += 5;
                dx dx2 = new dx(this.byte_a((byte)n5), by5, by4);
                this.f(dx2);
                this.c(dx2);
                this.var_dx_arr_a[n4] = dx2;
            }
            rpg.a.c();
        }
        if ((n3 = byArray[n22++] & 0xFF) > 0) {
            this.var_dx_arr_b = new dx[n3];
            for (int i3 = 0; i3 < n3; ++i3) {
                n5 = byArray[n22];
                by5 = (byte)rpg.g.short_a(byArray, n22 + 1);
                by4 = rpg.g.short_a(byArray, n22 + 3);
                n22 += 5;
                this.var_dx_arr_b[i3] = new dx(this.byte_a((byte)n5), by5, by4);
            }
            rpg.a.c();
        }
        if ((n2 = byArray[n22++] & 0xFF) > 0) {
            this.var_dx_arr_c = new dx[n2];
            for (int i4 = 0; i4 < n2; ++i4) {
                n5 = byArray[n22];
                by5 = rpg.g.short_a(byArray, n22 + 1);
                by4 = rpg.g.short_a(byArray, n22 + 3);
                n22 += 5;
                this.var_dx_arr_c[i4] = new dx(this.byte_a((byte)n5), by5, by4);
            }
            rpg.a.c();
        }
        byte by6 = byArray[n22++];
        byte[] byArray3 = new byte[by6];
        if (by6 > 0) {
            var_boolean_c = true;
            dt.a(by6);
            object = rpg.e.a("/en/edf");
            byte[] byArray4 = rpg.e.a("/en/np");
            byte[] byArray5 = rpg.e.a("/en/ep");
            for (n5 = 0; n5 < by6; ++n5) {
                byArray3[n5] = n4 = byArray[n22++];
                rpg.e.a(n5, n4, (byte[])object, byArray4, byArray5);
                rpg.a.c();
            }
        }
        byte by7 = byArray[n22++];
        for (by3 = 0; by3 < by7; ++by3) {
            n4 = byArray[n22 + 1];
            n7 = (n4 & 0x80) == 128 ? byArray[n22 + 3] : -1;
            for (byte by8 = 0; by8 < byArray3.length; by8 = (byte)((byte)(by8 + 1))) {
                if (byArray3[by8] != byArray[n22]) continue;
                cd.void_a((short)((byArray[n22 + 1] & 0x7F) << 4), (short)(byArray[n22 + 2] << 4), byArray[n22], by8);
                dt.var_dt_arr_a[by8].var_byte_f = (byte)n7;
            }
            n22 += 3;
            if ((n4 & 0x80) == 128) {
                ++n22;
            }
            rpg.a.c();
        }
        af.void_a_();
        by3 = byArray[n22++];
        byte[] byArray6 = new byte[by3];
        if (by3 > 0) {
            boolean bl2 = di.boolean_a(252);
            System.arraycopy(byArray, n22, byArray6, 0, by3);
            n22 += by3;
            am.var_s_arr_a = new s[by3];
            am.var_byte_arr_a = new byte[by3];
            am.b = new byte[by3];
            byte[] byArray7 = rpg.e.a("/en/ndf");
            byte[] byArray8 = rpg.e.a("/en/np");
            for (by4 = 0; by4 < by3; by4 = (byte)(by4 + 1)) {
                rpg.e.a(byArray7, bl2 && byArray6[by4] == 1 ? (byte)47 : byArray6[by4], by4, byArray8);
                rpg.a.c();
            }
        }
        if ((by2 = byArray[n22++]) > 0) {
            this.var_bl_arr_a = new bl[by2];
            by4 = 0;
            for (byte by10 = 0; by10 < by2; by10 = (byte)(by10 + 1)) {
                byte by11 = byArray[n22++];
                n4 = byArray[n22];
                int n9 = byArray[n22++] & 0x7F;
                byte by12 = byArray[n22++];
                for (byte by13 = 0; by13 < by3; by13 = (byte)((byte)(by13 + 1))) {
                    if (by11 != byArray6[by13]) continue;
                    by4 = by13;
                    break;
                }
                bl bl3 = new bl((short)(n9 << 4), (short)(by12 << 4), by11, by4);
                this.f(bl3);
                this.c(bl3);
                bl3.u();
                if ((n4 & 0x80) == 128) {
                    bl3.f(byArray[n22++]);
                }
                this.var_bl_arr_a[by10] = bl3;
            }
            rpg.a.c();
        }
        df.void_a(byArray, n22);
        g = true;
        rpg.a.c();
        rpg.e.a(this.O[0], this.O[1]);
        rpg.a.c();
        this.i();
        var_int_a = 10;
    }

    public final void void_b() {
        this.c(0);
        rpg.a.c();
        this.c(1);
        rpg.a.c();
    }

    public final void a(byte by2, byte by3, byte by4) {
        this.var_byte_arr_b[by3 * g.var_byte_c + by2] = (byte)(by4 + 1);
    }

    private final void c(int n2) {
        if (n2 < 0) {
            this.var_int_f = 0;
            this.var_cg_arr_a = null;
            this.var_byte_arr_c[0] = -1;
            this.var_byte_arr_c[1] = -1;
            return;
        }
        if (this.var_byte_arr_c[n2] != this.O[n2]) {
            int n3;
            int n4 = n2 == 0 ? 1 : 0;
            cg[][] cgArrayArray = new cg[2][];
            cg[][] cgArrayArray2 = cgArrayArray;
            cgArrayArray[0] = null;
            cgArrayArray2[1] = null;
            if (this.var_byte_arr_c[n4] >= 0) {
                cgArrayArray2[n4] = new cg[n4 == 0 ? this.var_int_f : this.var_cg_arr_a.length - this.var_int_f];
                for (n3 = 0; n3 < cgArrayArray2[n4].length; ++n3) {
                    cgArrayArray2[n4][n3] = this.var_cg_arr_a[n3 + (n4 == 0 ? 0 : this.var_int_f)];
                }
            }
            this.var_cg_arr_a = null;
            if (this.O[n2] >= 0) {
                aj aj2 = new aj("/m/t" + (this.O[n2] < 10 ? "0" : "") + this.O[n2]);
                cgArrayArray2[n2] = new cg[aj2.int_a()];
                aj2.a(cgArrayArray2[n2], 0);
            }
            this.var_int_f = cgArrayArray2[0] != null ? cgArrayArray2[0].length : 0;
            n3 = this.var_int_f + (cgArrayArray2[1] != null ? cgArrayArray2[1].length : 0);
            this.var_cg_arr_a = new cg[n3];
            for (n4 = 0; n4 < n3; ++n4) {
                this.var_cg_arr_a[n4] = n4 < this.var_int_f ? cgArrayArray2[0][n4] : cgArrayArray2[1][n4 - this.var_int_f];
            }
            this.var_byte_arr_c[n2] = this.O[n2];
        }
    }

    public final void c() {
        int n2;
        Object object;
        this.var_int_d = rpg.c.var_byte_c > 0 ? di.var_int_c : di.var_int_a;
        this.var_int_e = rpg.c.var_byte_c > 0 ? di.var_int_d : di.var_int_b;
        int n3 = bs.j;
        int n4 = bs.k;
        if (this.var_int_d > 0) {
            this.var_int_d = 0;
        }
        if (this.var_int_e > 0) {
            this.var_int_e = 0;
        }
        if (this.var_int_d < n3 - this.var_short_a) {
            this.var_int_d = n3 - this.var_short_a;
        }
        if (this.var_int_e < n4 - this.var_short_b) {
            this.var_int_e = n4 - this.var_short_b;
        }
        if (this.var_int_d > 0) {
            this.var_int_d = n3 - this.var_short_a >> 1;
        }
        if (this.var_int_e > 0) {
            this.var_int_e = n4 - this.var_short_b >> 1;
        }
        if (this.var_int_b != 0 || this.var_int_c != 0) {
            rpg.c.k();
        } else {
            object = this;
            if (var_byte_e == 2) {
                ((g)object).void_b(2, di.var_do_a.var_byte_c == 4 ? 4 : 3);
            } else if (var_byte_e == 1) {
                ((g)object).void_c(2, 2);
            }
        }
        if (this.var_int_b != 0) {
            this.var_int_d += this.var_int_b;
            this.var_int_b = 0;
        }
        if (this.var_int_c != 0) {
            this.var_int_e += this.var_int_c;
            this.var_int_c = 0;
        }
        int n5 = -this.var_int_d / 16;
        int n6 = -this.var_int_e / 16;
        int n7 = (n3 - this.var_int_d - 1) / 16;
        int n8 = (n4 - this.var_int_e - 1) / 16;
        if (n5 < 0) {
            n5 = 0;
        }
        if (n6 < 0) {
            n6 = 0;
        }
        if (n7 >= var_byte_c) {
            n7 = var_byte_c - 1;
        }
        if (n8 >= var_byte_d) {
            n8 = var_byte_d - 1;
        }
        cm cm2 = rpg.a.var_cm_a;
        if (var_boolean_a || var_boolean_b) {
            object = cm2;
            ((cm)object).a(j == 1 ? 0xFFFFFF : 0);
            ((cm)object).b(0, 0, bs.j, bs.k);
            ((cm)object).a(0, 0, bs.j, bs.k);
            if (var_boolean_a) {
                this.a(this.var_int_d, this.var_int_e, false);
                this.a(this.var_int_d, this.var_int_e, true);
                var_boolean_a = false;
                return;
            }
        } else {
            cm2.b(0, 0, n3, n4);
            cm2.a(0x202020);
            cm2.a(0, 0, n3, n4);
        }
        bs.e(cm2);
        if (!var_boolean_b) {
            int n9;
            int n10;
            int n11;
            n2 = this.var_cg_arr_a.length;
            n4 = this.var_int_e + (n6 << 4);
            for (n11 = n6; n11 <= n8; ++n11) {
                n3 = this.var_int_d + (n5 << 4);
                for (n10 = n5; n10 <= n7; ++n10) {
                    n9 = n11 * var_byte_c + n10;
                    int n12 = (this.var_byte_arr_b[n9] & 0x80) != 0 ? this.var_int_f : 0;
                    n12 = n12 + (char)(this.var_byte_arr_b[n9] & 0x7F);
                    if (n12 > 0 && --n12 < n2) {
                        cm2.a(this.var_cg_arr_a[n12], n3, n4, 20);
                    }
                    n3 += 16;
                }
                n4 += 16;
            }
            bs.e(cm2);
            if (this.var_dx_arr_c != null) {
                n11 = this.var_dx_arr_c.length;
                for (n10 = 0; n10 < n11; ++n10) {
                    this.var_dx_arr_c[n10].b(this.var_int_d, this.var_int_e);
                }
            }
            int n13 = n5;
            int n14 = n6;
            int n15 = n7;
            int n16 = n8;
            n2 = this.var_int_e;
            n8 = this.var_int_d;
            n7 = n16;
            n6 = n15;
            n5 = n14;
            n4 = n13;
            cm cm3 = cm2;
            object = this;
            n9 = ((g)object).var_java_util_Vector_b.size();
            if (n9 > 0) {
                bs.e(cm3);
                for (int i2 = n9 - 1; i2 >= 0; --i2) {
                    byte by2;
                    byte[] byArray = (byte[])((g)object).var_java_util_Vector_b.elementAt(i2);
                    if (byArray[5] <= 16 && byArray[5] % 3 != 0 || byArray[0] < n4 || byArray[0] > n6 || byArray[1] < n5 || byArray[1] > n7) continue;
                    n11 = n8 + (byArray[0] << 4);
                    n10 = n2 + (byArray[1] << 4) + 2;
                    cm3.a(rpg.e.var_cg_arr_e[0], n11, n10 + 4, 20);
                    if (byArray[2] == 1) {
                        cm3.a(rpg.e.var_cg_g, n11 + 1, n10 + 2, 20);
                        continue;
                    }
                    int n17 = by2 + ((by2 = byArray[3]) == 20 ? byArray[4] : (byte)0);
                    cm3.a(rpg.e.var_cg_arr_k[n17], n11 + 8, n10 + 16 - 6, 33);
                }
            }
        }
        bs.e(cm2);
        this.a(this.var_int_d, this.var_int_e, false);
        object = this.var_du_a;
        while (object != null) {
            ((du)object).b(this.var_int_d, this.var_int_e);
            object = ((du)object).b;
        }
        object = this.var_du_c;
        while (object != null) {
            ((du)object).b(this.var_int_d, this.var_int_e);
            object = ((du)object).b;
        }
        this.a(this.var_int_d, this.var_int_e, true);
        if (var_boolean_b) {
            var_boolean_b = false;
            return;
        }
        if (this.var_dx_arr_b != null) {
            n2 = this.var_dx_arr_b.length;
            for (int i3 = 0; i3 < n2; ++i3) {
                this.var_dx_arr_b[i3].b(this.var_int_d, this.var_int_e);
            }
        }
        if (di.var_byte_d == 3 || di.var_byte_d == 4) {
            if (var_int_a > 0) {
                --var_int_a;
            }
            if (var_byte_e >= 0) {
                var_byte_e = (byte)(var_byte_e - 1);
            }
        }
        if (!g) {
            cm2.a(0);
            cm2.a(0, 0, 10, 10);
        }
        cm cm4 = cm2;
        object = this;
        if (var_int_a > 0 && ((g)object).var_byte_arr_arr_a != null) {
            cm4.b(255);
            n4 = var_int_a << 2;
            n5 = rpg.a.var_int_a - bs.j >> 1;
            cm4.a(0);
            cm4.a(n5, 0, bs.j, n4);
            cm4.a(n5, bs.k - n4, bs.j, n4);
            cm4.b(60);
            n6 = n4 * 6;
            n7 = 180 - (n6 >> 1);
            cm4.a(n7, n7, n7);
            cm4.a(0, bs.m - 15, rpg.a.var_int_a, 30);
            cm4.b(255);
            if (var_int_a > 6 && var_int_a < 15) {
                n6 = 0xFFFFFF;
            }
            if (((g)object).var_byte_arr_arr_a[0] != null) {
                g.a(cm4, n6, ((g)object).var_byte_arr_arr_a[0], rpg.a.c - var_int_a, bs.m - 3 - 7);
            }
            if (((g)object).var_byte_arr_arr_a[1] != null) {
                g.a(cm4, n6, ((g)object).var_byte_arr_arr_a[1], rpg.a.c + var_int_a, bs.m - 3 + 7);
            }
        }
        for (n4 = 0; n4 < 3; ++n4) {
            if (var_int_arr_a[n4] <= 0) continue;
            int n18 = n4;
            var_int_arr_a[n18] = var_int_arr_a[n18] - 1;
            try {
                if (var_int_arr_a[n4] > 0) {
                    cm4.a(((g)object).var_cg_arr_b[n4], rpg.a.c, bs.k - n4 * (((g)object).var_cg_arr_b[n4].b() + 1), 33);
                    continue;
                }
                ((g)object).var_cg_arr_b[n4] = null;
                continue;
            }
            catch (Exception exception) {
                Exception exception2 = exception;
                exception.printStackTrace();
            }
        }
    }

    private static void a(cm cm2, int n2, byte[] byArray, int n3, int n4) {
        if (byArray == null) {
            return;
        }
        cm2.a(0);
        ac.a(cm2, n3 + 1, n4 - 1, byArray, 0, 1);
        if (n2 > 255) {
            n2 = 255;
        }
        cm2.a(n2, n2, n2);
        ac.a(cm2, n3, n4, byArray, 0, 1);
    }

    private byte byte_a(byte by2) {
        if (this.P == null) {
            return -1;
        }
        for (byte by3 = 0; by3 < this.P.length; by3 = (byte)(by3 + 1)) {
            if (this.P[by3] != by2) continue;
            return by3;
        }
        return -1;
    }

    public final void a(byte by2, int n2, int n3) {
        rpg.a.var_cm_a.a(this.var_cg_arr_c[by2], n2, n3, 33);
    }

    final boolean boolean_b(int n2, int n3) {
        return (this.var_byte_arr_a[n3 * var_byte_c + n2] & 0xC0) != 0;
    }

    final boolean boolean_c(int n2, int n3) {
        return (this.var_byte_arr_a[n3 * var_byte_c + n2] & 0x80) != 0;
    }

    final boolean a(du du2, int n2, int n3) {
        return this.var_du_arr_arr_a[n3][n2] != null && this.var_du_arr_arr_a[n3][n2] != du2;
    }

    final boolean d(int n2, int n3) {
        return this.boolean_b(n2, n3) && (this.var_byte_arr_a[n3 * var_byte_c + n2] & 0x3F) == 0;
    }

    public final boolean a(al al2, int n2, int n3) {
        for (int i2 = 0; i2 < al2.u; ++i2) {
            if (n2 + i2 < 0 || n3 < 0 || n2 + i2 >= var_byte_c - 1 || n3 + i2 >= var_byte_d - 1) {
                return false;
            }
            if (!this.boolean_b(n2 + i2, n3) && !this.a((du)al2, n2 + i2, n3)) continue;
            return false;
        }
        return true;
    }

    final boolean a(al al2, byte by2) {
        return this.a(al2, al2.s + rpg.d.H[by2], al2.t + rpg.d.I[by2]);
    }

    final void d() {
        d d2 = this;
        int n2 = d2.var_java_util_Vector_a.size();
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            at at2 = (at)d2.var_java_util_Vector_a.elementAt(i2);
            if (at2 == null || !at2.var_boolean_a) continue;
            d2.var_java_util_Vector_a.removeElementAt(i2);
        }
        d2 = this.var_du_a;
        while (d2 != null) {
            if (d2 instanceof dx) {
                d2 = ((du)d2).b;
                continue;
            }
            if (d2 instanceof cd && !((du)d2).m) {
                cd cd2 = (cd)d2;
                cd2.void_c();
                d2 = ((du)d2).b;
                this.c(cd2);
                if (cd2.var_byte_b != 7) continue;
                this.d(cd2);
                continue;
            }
            if (d2 instanceof bl && !((du)d2).m) {
                bl bl2 = (bl)d2;
                bl2.void_c();
                d2 = ((du)d2).b;
                this.c(bl2);
                continue;
            }
            if (((du)d2).m) {
                ((du)d2).m = false;
                d2 = ((du)d2).b;
                continue;
            }
            d2 = ((du)d2).b;
        }
        d2 = this.var_du_c;
        while (d2 != null) {
            if (d2 instanceof af && !((du)d2).m) {
                cd cd3 = (cd)d2;
                cd3.void_c();
                d2 = ((du)d2).b;
                this.h(cd3);
                if (cd3.var_byte_b != 7) continue;
                this.e(cd3);
                continue;
            }
            if (((du)d2).m) {
                ((du)d2).m = false;
                d2 = ((du)d2).b;
                continue;
            }
            d2 = ((du)d2).b;
        }
    }

    public final void d(du d2) {
        boolean bl2;
        if (d2 instanceof al) {
            ((al)d2).v();
        }
        du du2 = d2;
        d2 = this;
        du du3 = ((g)d2).var_du_a;
        while (du3 != null && !du3.equals(du2)) {
            du3 = du3.b;
        }
        if (du3 != null) {
            if (du3.a != null) {
                du3.a.b = du3.b;
            } else {
                ((g)d2).var_du_a = du3.b;
            }
            if (du3.b != null) {
                du3.b.a = du3.a;
            } else {
                ((g)d2).var_du_b = du3.a;
            }
            bl2 = true;
        } else {
            bl2 = false;
        }
    }

    public final void e(du d2) {
        boolean bl2;
        if (d2 instanceof al) {
            ((al)d2).v();
        }
        du du2 = d2;
        d2 = this;
        du du3 = ((g)d2).var_du_c;
        while (du3 != null && !du3.equals(du2)) {
            du3 = du3.b;
        }
        if (du3 != null) {
            if (du3.a != null) {
                du3.a.b = du3.b;
            } else {
                ((g)d2).var_du_c = du3.b;
            }
            if (du3.b != null) {
                du3.b.a = du3.a;
            } else {
                ((g)d2).var_du_d = du3.a;
            }
            bl2 = true;
        } else {
            bl2 = false;
        }
    }

    public static void void_a(byte by2) {
        do do_ = di.var_do_a;
        do_.r();
        if (by2 > 0) {
            do_.a(new z(-6, by2));
        }
    }

    public final void void_a(byte by2, byte by3) {
        bl bl2 = this.var_bl_arr_a[by3];
        bl2.r();
        if (by2 > 0) {
            bl2.a(new z(-6, by2));
        }
    }

    public final void b(byte by2, byte by3) {
        bl bl2 = this.var_bl_arr_a[by2 & 0xFF];
        this.var_bl_arr_a[by2 & 0xFF].var_byte_a = by3;
    }

    public final void void_b(int n2, int n3) {
        if (n3 % 2 == 1) {
            this.var_int_b = -n2;
            return;
        }
        this.var_int_b = n2;
    }

    public final void void_c(int n2, int n3) {
        if (n3 % 2 == 0) {
            this.var_int_c = n2;
            return;
        }
        this.var_int_c = -n2;
    }

    public static void a(int n2) {
        j = 1;
        var_boolean_a = true;
    }

    public static void b(int n2) {
        j = 0;
        var_boolean_b = true;
    }

    public static void e() {
        var_boolean_b = false;
        var_boolean_a = false;
    }

    public final void a(byte by2, byte by3, byte by4, byte by5) {
        if (by4 < 0 || by5 < 0 || by4 > 20 || by5 > 28) {
            return;
        }
        byte[] byArray = new byte[]{by2, by3, 0, by4, by5, 126};
        this.var_java_util_Vector_b.insertElementAt(byArray, 0);
    }

    public final void a(byte by2, byte by3, int n2) {
        byte[] byArray = new byte[]{by2, by3, 1, (byte)(n2 / 100), (byte)(n2 % 100), 126};
        this.var_java_util_Vector_b.addElement(byArray);
    }

    public final void f() {
        int n2;
        for (int i2 = n2 = this.var_java_util_Vector_b.size() - 1; i2 >= 0; --i2) {
            byte[] byArray = (byte[])this.var_java_util_Vector_b.elementAt(i2);
            if (byArray[5] > 0) {
                byArray[5] = (byte)(byArray[5] - 1);
                continue;
            }
            this.var_java_util_Vector_b.removeElementAt(i2);
        }
    }

    public final boolean boolean_a(byte by2, byte by3) {
        int n2 = this.var_java_util_Vector_b.size();
        if (n2 <= 0) {
            return false;
        }
        byte[] byArray = null;
        boolean bl2 = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            byArray = (byte[])this.var_java_util_Vector_b.elementAt(i2);
            if (by2 != byArray[0] || by3 != byArray[1]) continue;
            if (byArray[2] == 1) {
                int n3 = byArray[3] * 100 + byArray[4];
                if (ax.j) {
                    n3 <<= 1;
                }
                di.e(n3);
                this.var_java_util_Vector_b.removeElementAt(i2);
                this.a((byte)1, byArray[3], byArray[4], true);
                return true;
            }
            bl2 = true;
            bj bj2 = di.bj_a(byArray[3]);
            if (!bj2.a(byArray[3], byArray[4], 1)) continue;
            bj2.a(as.a(byArray[3], byArray[4]), 1);
            this.var_java_util_Vector_b.removeElementAt(i2);
            this.a((byte)0, byArray[3], byArray[4], true);
            if (byArray[3] == 20) {
                bs.var_boolean_d = true;
            }
            return true;
        }
        if (bl2) {
            this.a(byArray[2], byArray[3], byArray[4], false);
        }
        return false;
    }

    private final void a(byte by2, byte by3, byte by4, boolean bl2) {
        byte[] byArray;
        cg cg2 = cg.a(200, 16);
        cm cm2 = cg2.cm_a();
        cm2.a(0);
        cm2.a(0, 0, 200, 16);
        cm2.a(13682856);
        cm2.d(1, 1, 197, 13);
        cm2.a(0xFFFFFF);
        if (!bl2) {
            by3 = (byte)23;
            switch (by2) {
                case 16: {
                    by3 = (byte)21;
                    break;
                }
                case 18: {
                    by3 = (byte)22;
                }
            }
            byArray = rpg.e.var_ch_g.a(by3);
        } else {
            byte[] byArray2;
            if (by2 == 1) {
                byArray2 = rpg.g.a(("" + (by3 * 100 + by4)).getBytes(), rpg.d.s);
                if (ax.j) {
                    byArray2 = rpg.g.a(byArray2, "x2".getBytes());
                }
            } else {
                as as2 = as.a(by3, by4);
                byArray2 = by3 == 18 ? rpg.g.a(rpg.e.var_ch_g.a(by3), as2.var_byte_arr_a) : as2.var_byte_arr_a;
                if (as2 instanceof bm) {
                    cm2.a(p.c[((bm)as2).e]);
                }
            }
            byArray = byArray2;
        }
        ac.a(cm2, 100, 1, byArray, 0, 1);
        boolean bl3 = false;
        for (int i2 = 0; i2 < 3; ++i2) {
            if (this.var_cg_arr_b[i2] != null) continue;
            this.var_cg_arr_b[i2] = cg2;
            g.var_int_arr_a[i2] = 15;
            bl3 = true;
            break;
        }
        if (!bl3) {
            this.var_cg_arr_b[0] = cg2;
            g.var_int_arr_a[0] = 15;
        }
    }

    public final byte[] byte_arr_a() {
        do do_ = di.var_do_a;
        byte[] byArray = new byte[4];
        byte[] byArray2 = byArray;
        byArray[0] = this.var_byte_b;
        byArray2[1] = do_.s;
        byArray2[2] = do_.t;
        byArray2[3] = do_.var_byte_c;
        return byArray2;
    }

    public final du du_a(int n2, int n3) {
        if (n2 >= 0 && n3 >= 0 && n2 < var_byte_c && n3 < var_byte_d) {
            return this.var_du_arr_arr_a[n3][n2];
        }
        return null;
    }

    public final void a(at at2) {
        this.var_java_util_Vector_a.addElement(at2);
    }

    private void a(int n2, int n3, boolean bl2) {
        int n4;
        for (int i2 = n4 = this.var_java_util_Vector_a.size() - 1; i2 >= 0; --i2) {
            at at2 = (at)this.var_java_util_Vector_a.elementAt(i2);
            if (at2 == null) continue;
            at2.a(n2, n3, bl2);
        }
    }

    public static final void g() {
        var_byte_e = (byte)2;
    }

    public static boolean boolean_a() {
        return var_byte_e > 0;
    }

    public static void h() {
        cd.B();
        dt.a();
    }

    private int a(int n2, int n3, int n4) {
        if (n3 < 0 || n4 < 0 || n3 >= var_byte_c || n4 >= var_byte_d) {
            return -1;
        }
        int n5 = n4;
        n4 = n3;
        g g2 = this;
        int n6 = n4 < 0 || n5 < 0 || n4 >= var_byte_c || n5 >= var_byte_d ? 0 : g2.var_byte_arr_a[n5 * var_byte_c + n4];
        n2 = (n6 & 0x40) != 0 || (n6 & 0x80) != 0 ? var_int_arr_b[(n2 << 1) + 1] : var_int_arr_b[n2 << 1];
        if ((n6 & 0x3F) != 0) {
            n2 = 3767807;
        }
        return n2;
    }

    public final void a(cm cm2) {
        Object object;
        int n2 = var_byte_c * var_byte_f;
        int n3 = var_byte_d * var_byte_f;
        n2 = rpg.a.c - (n2 >> 1);
        n3 = 8 + rpg.a.var_int_b >= 300 ? bs.k - n3 >> 1 : rpg.a.var_int_b - n3 >> 1;
        int n4 = n3;
        if (bs.var_boolean_e || rpg.a.var_boolean_a) {
            object = this.byte_arr_b();
            int n5 = rpg.a.var_int_a - ac.a(object) >> 1;
            int n6 = n2 < n5 - 5 ? n2 : n5 - 5;
            int n7 = n4 - 15 > 0 ? n4 - 15 : 0;
            int n8 = rpg.a.c - n6 << 1;
            int n9 = 15 + var_cg_a.b();
            cm2.a(0);
            cm2.a(0, 0, rpg.a.var_int_a, rpg.a.var_int_b - 33);
            cm2.a(10159117);
            cm2.a(0, 0, rpg.a.var_int_a, 15);
            cm2.a(0x777777);
            ac.a(cm2, n5 + 1, 2, object, 1);
            cm2.a(0xFFFFFF);
            ac.a(cm2, n5, 1, object, 1);
            cm2.a(var_cg_a, n2, n4, 20);
            if (rpg.c.var_boolean_d && this.k >= 0 && this.l >= 0) {
                cm2.a(0xFF0000);
                cm2.b(n6, n7, n8, n9);
                n4 = rpg.e.p.int_a();
                int n10 = rpg.e.p.b();
                n5 = n2 + this.k * var_byte_f;
                n6 = n3 + this.l * var_byte_f;
                cm2.b(n5 + 1, n6, n4, n10);
                cm2.a(rpg.e.p, n5 + 1, n6, 20);
                cm2.b(0, 0, rpg.a.var_int_a, rpg.a.var_int_b);
            }
        }
        object = di.var_do_a;
        cm2.a(rpg.a.e % 2 == 1 ? 0xFF0000 : 0x7F7F7F);
        cm2.a(n2 + object.s * var_byte_f, n3 + object.t * var_byte_f, (int)var_byte_f, (int)var_byte_f);
        if (++rpg.a.e > 99) {
            rpg.a.e = 0;
        }
        if (n.var_cg_a != null) {
            cm2.a(n.var_cg_a, rpg.a.var_int_a - n.var_cg_a.int_a(), rpg.a.var_int_b - n.var_cg_a.b(), 20);
        }
        if (!rpg.c.var_boolean_d || this.k == -1 && this.l == -1) {
            bs.var_boolean_e = false;
        }
    }

    private void i() {
        int n2 = var_byte_c * var_byte_f;
        int n3 = var_byte_d * var_byte_f;
        var_cg_a = cg.a(n2, n3);
        cm cm2 = var_cg_a.cm_a();
        cm2.a(0);
        cm2.a(0, 0, n2, n3);
        int n4 = 2;
        switch (this.O[0]) {
            case 0: 
            case 2: {
                n4 = 0;
                break;
            }
            case 1: 
            case 6: {
                n4 = 1;
            }
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                int n5;
                int n6 = i2;
                int n7 = i3;
                int n8 = n4;
                g g2 = this;
                boolean bl2 = false;
                int n9 = n7 >> 1;
                int n10 = n6 >> 1;
                int n11 = g2.a(n8, n9, n10);
                if (n7 % 2 == 0 && n6 % 2 == 0) {
                    n7 = g2.a(n8, n9 - 1, n10);
                    n5 = g2.a(n8, n9, n10 - 1);
                } else if (n7 % 2 == 1 && n6 % 2 == 0) {
                    n7 = g2.a(n8, n9 + 1, n10);
                    n5 = g2.a(n8, n9, n10 - 1);
                } else if (n7 % 2 == 0 && n6 % 2 == 1) {
                    n7 = g2.a(n8, n9 - 1, n10);
                    n5 = g2.a(n8, n9, n10 + 1);
                } else {
                    n7 = g2.a(n8, n9 + 1, n10);
                    n5 = g2.a(n8, n9, n10 + 1);
                }
                if (n7 == -1) {
                    n7 = n11;
                }
                if (n5 == -1) {
                    n5 = n11;
                }
                if (n11 != n7 && n11 != n5) {
                    bl2 = true;
                }
                if (n11 == 3767807) {
                    bl2 = false;
                }
                if (bl2) {
                    n8 = ((n11 & 0xFF) + (n7 & 0xFF) + (n5 & 0xFF)) / 3;
                    n6 = ((n11 >> 8 & 0xFF) + (n7 >> 8 & 0xFF) + (n5 >> 8 & 0xFF)) / 3;
                    n5 = ((n11 >> 16 & 0xFF) + (n7 >> 16 & 0xFF) + (n5 >> 16 & 0xFF)) / 3;
                    n8 = n8 > 255 ? 255 : n8;
                    n6 = n6 > 255 ? 255 : n6;
                    n5 = n5 > 255 ? 255 : n5;
                    n11 = n8 + (n6 << 8) + (n5 << 16);
                }
                n5 = n11;
                cm2.a(n5);
                cm2.a(i3 << 1, i2 << 1, 2, 2);
            }
            if (i2 % 10 != 1) continue;
            rpg.a.c();
        }
    }

    public final byte[] byte_arr_b() {
        byte[] byArray = this.var_byte_arr_arr_a[0];
        if (this.var_byte_arr_arr_a[1] != null) {
            byArray = rpg.g.a(this.var_byte_arr_arr_a[0], "-".getBytes());
            byArray = rpg.g.a(byArray, this.var_byte_arr_arr_a[1]);
        }
        return byArray;
    }

    public final bl bl_a() {
        for (int i2 = 0; i2 < this.var_bl_arr_a.length; ++i2) {
            bl bl2 = this.var_bl_arr_a[i2];
            if (bl2.g != 1) continue;
            return bl2;
        }
        return null;
    }

    static {
        j = 0;
        var_boolean_a = false;
        var_boolean_b = false;
        var_byte_e = (byte)-1;
        var_int_arr_a = new int[3];
        var_boolean_c = false;
        var_boolean_f = false;
        g = true;
        var_cg_a = null;
        i = new byte[][]{{1, 3, 3, -46}, {2, 1, 4, -45}, {3, 8, 3, -44}, {14, 8, 8, -42}, {20, 5, 5, -41}, {22, 4, 22, -40}, {27, 4, 5, -39, 15, 17, -38}, {28, 16, 4, 9}, {32, 3, 5, -36}, {35, 1, 10, -18}, {40, 17, 6, -43}, {46, 33, 4, -35}, {47, 2, 1, -34}, {52, 4, 13, -33}, {54, 2, 10, -32}, {56, 4, 4, -31}, {58, 1, 27, -30}, {64, 8, 2, -29}, {69, 30, 29, -28}, {75, 3, 6, -27}, {77, 20, 10, -26}, {86, 13, 12, 77}, {96, 11, 6, -21}, {110, 3, 5, -50, 3, 20, -48, 21, 5, -49, 21, 20, -47}, {112, 3, 15, -20}, {118, 4, 17, -19}};
        var_byte_f = (byte)4;
        var_int_arr_b = new int[]{0xBFBFBF, 0x3F3F3F, 12451641, 1588281, 0xBFBFDF, 0x5F5F3F};
    }
}

