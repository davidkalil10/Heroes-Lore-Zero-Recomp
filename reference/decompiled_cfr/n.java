/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;

public abstract class n
implements d {
    protected static final int[] var_int_arr_a;
    protected static final int[] var_int_arr_b;
    protected n var_n_a;
    protected n var_n_b;
    protected byte var_byte_a;
    protected byte var_byte_b;
    protected byte var_byte_c;
    protected byte var_byte_d;
    protected byte var_byte_e;
    private boolean var_boolean_e;
    boolean var_boolean_a;
    boolean var_boolean_b;
    protected int a_;
    protected int b_;
    private static cg var_cg_b;
    public static final cg var_cg_a;
    public static boolean var_boolean_c;
    public static int c_;
    protected int d_ = -1;
    protected boolean var_boolean_d = false;

    public static void a(cm cm2, int n2) {
        int n3 = cm2.int_a();
        int n4 = cm2.b();
        int n5 = cm2.c();
        int n6 = cm2.d();
        cm2.b(0, 0, rpg.a.var_int_a, rpg.a.var_int_b);
        try {
            if ((n2 & 1) != 0) {
                cm2.a(var_cg_b, 0, rpg.a.var_int_b, 36);
            }
            if ((n2 & 2) != 0) {
                cm2.a(var_cg_a, rpg.a.var_int_a, rpg.a.var_int_b, 40);
            }
            if (var_boolean_c) {
                cm2.a(rpg.e.var_cg_k, rpg.a.var_int_a < 240 ? -32 : 0, rpg.a.var_int_b, 36);
            }
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
        cm2.b(n3, n4, n5, n6);
    }

    abstract boolean boolean_a(int var1, int var2);

    protected abstract void a(cm var1);

    public n(n n2, byte by2, byte by3, byte by4) {
        this.var_n_a = n2;
        this.var_n_b = null;
        this.var_boolean_e = true;
        this.var_boolean_a = true;
        this.var_boolean_b = false;
        this.var_byte_b = by2;
        this.var_byte_d = by3;
        this.var_byte_c = by4;
        this.var_byte_a = 0;
        this.a_ = rpg.a.var_int_a - rpg.d.e_ >> 1;
        this.b_ = rpg.a.var_int_b - 174 >> 1;
    }

    public n(n n2, byte by2) {
        this(null, 8, 1, 1);
    }

    void void_a(byte by2, byte by3) {
        this.c();
    }

    final void c() {
        this.var_n_b = null;
        if (bs.bs_a() != null) {
            bs.bs_a();
            bs.e();
        }
        this.d();
    }

    void d() {
        this.var_boolean_a = true;
        if (this.var_n_a != null) {
            this.var_n_a.d();
        }
    }

    public final void e() {
        while (true) {
            n2.var_boolean_a = true;
            if (n2.var_n_b == null) break;
            n n2 = n2.var_n_b;
        }
    }

    public final void c(cm cm2) {
        if (rpg.a.var_boolean_a) {
            this.e();
            rpg.a.var_boolean_a = false;
        }
        this.d(cm2);
    }

    final void d(cm cm2) {
        boolean bl2 = false;
        if (this.d_ >= 0) {
            --this.d_;
            if (this.d_ < 0 && this.var_n_b == null) {
                this.var_boolean_a = true;
                boolean bl3 = this.var_boolean_d = !this.var_boolean_d;
            }
        }
        if (this.var_boolean_a) {
            this.var_boolean_a = false;
            this.a(cm2);
            bl2 = true;
        }
        if (this.var_n_b == null) {
            if (this.var_boolean_e) {
                if (!bl2) {
                    this.a(cm2);
                }
                this.var_boolean_e = false;
            }
            if (this.var_boolean_b) {
                this.b(cm2);
            }
        } else {
            this.var_n_b.d(cm2);
        }
        if (this.var_boolean_b) {
            this.var_byte_e = (byte)(this.var_byte_e + 1);
            this.b();
        }
    }

    protected void b() {
        if (this.var_byte_e >= var_int_arr_b.length) {
            this.var_byte_e = 0;
        }
    }

    protected void b(cm cm2) {
    }

    public final void a(cm cm2, int n2, int n3, int n4, int n5) {
        cm2.a(var_int_arr_b[this.var_byte_e]);
        cm2.d(n2, n3, n4, n5);
    }

    final boolean b(int n2, int n3) {
        if (this.var_n_b != null && this.var_n_b.boolean_a(n2, n3)) {
            return true;
        }
        this.var_boolean_a = true;
        return false;
    }

    protected final boolean c(int n2, int n3) {
        if (n3 == 50 || n2 == 1) {
            this.void_b((byte)3);
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            this.void_b((byte)4);
            return true;
        }
        return false;
    }

    protected final boolean d(int n2, int n3) {
        if (n3 == 52 || n2 == 2) {
            this.void_b((byte)3);
            return true;
        }
        if (n3 == 54 || n2 == 5) {
            this.void_b((byte)4);
            return true;
        }
        return false;
    }

    protected boolean e(int n2, int n3) {
        if (n3 == 50 || n2 == 1) {
            this.void_a((byte)3);
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            this.void_a((byte)4);
            return true;
        }
        return false;
    }

    protected final void void_a(byte by2) {
        if (by2 == 4) {
            this.var_byte_a = (byte)(this.var_byte_a + this.var_byte_c);
            if (this.var_byte_a >= this.var_byte_b) {
                this.var_byte_a = (byte)(this.var_byte_a - this.var_byte_c * this.var_byte_d);
                if (this.var_byte_a < 0) {
                    this.var_byte_a = 0;
                    return;
                }
            }
        } else {
            this.var_byte_a = (byte)(this.var_byte_a - this.var_byte_c);
            if (this.var_byte_a < 0) {
                this.var_byte_a = (byte)(this.var_byte_c * this.var_byte_d + this.var_byte_a);
                if (this.var_byte_a >= this.var_byte_b) {
                    this.var_byte_a = (byte)(this.var_byte_b - 1);
                }
            }
        }
    }

    public static final boolean f(int n2, int n3) {
        return n2 == 8 || n3 == 53 || n2 == -6;
    }

    protected static boolean g(int n2, int n3) {
        return n3 == 0 || n2 == -7;
    }

    protected static boolean h(int n2, int n3) {
        return n2 == 2 || n3 == 52;
    }

    protected static boolean i(int n2, int n3) {
        return n2 == 5 || n3 == 54;
    }

    protected final void f() {
        this.var_boolean_b = true;
        this.var_byte_e = 0;
    }

    protected final void void_b(byte by2) {
        if (by2 == 4) {
            this.var_byte_a = (byte)(this.var_byte_a + 1);
            if (this.var_byte_a >= this.var_byte_b) {
                this.var_byte_a = 0;
                return;
            }
        } else {
            this.var_byte_a = (byte)(this.var_byte_a - 1);
            if (this.var_byte_a < 0) {
                this.var_byte_a = (byte)(this.var_byte_b - 1);
            }
        }
    }

    protected static final void b(cm cm2, int n2, int n3, int n4, int n5) {
        n4 = n4 / 20 + 1;
        n5 = n5 / 20 + 1;
        for (int i2 = 0; i2 < n4; ++i2) {
            for (int i3 = 0; i3 < n5; ++i3) {
                cm2.a(rpg.e.u, n2 + i2 * 20, n3 + i3 * 20, 20);
            }
        }
    }

    protected static final void c(cm cm2, int n2, int n3, int n4, int n5) {
        cm2.a(n2 + 1, n3, n4 - 2, n5);
        cm2.d(n2, n3 + 1, n4 - 1, n5 - 3);
    }

    protected static final void a(cm cm2, int n2, int n3, int n4, int n5, int n6, int n7) {
        cm2.a(n7);
        cm2.d(n2, n3 - 1, n4 - 1, n5 - 1);
        cm2.d(n2 - 1, n3, n4 + 1, n5 - 3);
        cm2.a(n6);
        cm2.a(n2, n3, n4, n5 - 2);
    }

    protected final void void_a(cm cm2, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        if (bl3) {
            this.a(cm2, ax.var_ch_a.a(ax.var_byte_f), bl4, bl5);
            return;
        }
        this.a(cm2, null, bl4, bl5);
    }

    protected final void a(cm cm2, boolean bl2, boolean bl3, byte[] byArray, boolean bl4) {
        this.a(cm2, null, true, bl4);
        cm2.a(14597755);
        ac.a(cm2, rpg.a.c, this.b_ - 1, byArray, 0, 1);
    }

    protected final void a(cm cm2, byte[] byArray, boolean bl2, boolean bl3) {
        if (rpg.a.var_int_a > 120) {
            cm2.b(this.a_ - 2, this.b_ - 2, rpg.d.e_ + 4, 178);
            cm2.a(0);
            cm2.a(this.a_ - 2, this.b_ - 2, rpg.d.e_ + 4, 178);
        }
        cm2.b(this.a_, this.b_, rpg.d.e_, 174);
        if (bl2) {
            n.b(cm2, this.a_, this.b_ + 13, rpg.d.e_ + 14, 161);
        }
        cm2.a(3550755);
        cm2.a(this.a_, this.b_, rpg.d.e_, 13);
        cm2.a(15723216);
        cm2.e(this.a_, this.b_ + 13, this.a_ + rpg.d.e_, this.b_ + 13);
        if (byArray != null) {
            cm2.a(14597755);
            ac.a(cm2, rpg.a.c, this.b_ + -2, byArray, 0, 1);
        }
        if (bl3) {
            n.a(cm2, this.a_ + 1, this.b_ + 1, 1, true);
            n.a(cm2, this.a_ + rpg.d.e_ - 2, this.b_ + 1, 3, false);
        }
    }

    private static void a(cm cm2, int n2, int n3, int n4, boolean bl2) {
        int n5;
        cm2.a(13682856);
        for (int i2 = 0; i2 < 2; ++i2) {
            n5 = n2 + (bl2 ? i2 : -i2);
            cm2.e(n5, n3 + 2 - i2, n5, n3 + 9 - 3 + i2);
        }
        n5 = bl2 ? n2 + 2 : n2 - 9 + 1;
        cm2.a(n5, n3, 7, 9);
        n.b(cm2, n4, n5 + 1, n3 + 1, 4, 0);
    }

    protected final void a(cm cm2, byte by2, boolean bl2, int n2, boolean bl3) {
        int n3 = this.b_ + 16;
        int n4 = (rpg.a.var_int_a - 105 >> 1) - 12;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5;
            cg[] cgArray;
            cm cm3;
            cm2.a(i2 == by2 ? (bl2 ? 0xFF0000 : 15723216) : 3550755);
            int n6 = n3 + i2 * 13;
            cm2.a(n4, n6, 11, 11);
            cm2.e(n4 + 11, n6 + 1, n4 + 11, n6 + 11 - 2);
            if (bl3) {
                cm3 = cm2;
                cgArray = rpg.e.var_cg_arr_b;
                n5 = i2 + (by2 == i2 ? 3 : 0);
            } else {
                cm3 = cm2;
                cgArray = rpg.e.var_cg_arr_b;
                n5 = by2 == i2 ? 3 : 0;
            }
            cm3.a(cgArray[n5], n4 + 1, n6 + 1, 20);
        }
    }

    protected static void a(cm cm2, int n2, int n3, int n4) {
        cm2.a(15723216);
        cm2.d(n2, n3 - 1, rpg.d.e_ - 1, n4 + 1);
        cm2.a(3550755);
        cm2.a(n2, n3, rpg.d.e_, n4);
    }

    protected final void b(cm cm2, int n2, int n3, int n4) {
        int n5 = n.int_a(n4);
        rpg.a.a(cm2);
        cm2.a(rpg.e.t, n2 - n5, n3, 24);
        n.b(cm2, n4, n2, n3, 8, 0);
    }

    protected static int int_a(int n2) {
        int n3 = 1;
        do {
            n3 += 4;
        } while ((n2 /= 10) != 0);
        return n3;
    }

    protected static void a(cm cm2, int n2, int n3, int n4, int n5, boolean bl2) {
        cm2.a(n5);
        for (n5 = 0; n5 < 3; ++n5) {
            cm2.e(n2 + n5, n3 - n5, n2 + n5, n3 + n5);
            cm2.e(n2 + n4 - n5 - 1, n3 - n5, n2 + n4 - n5 - 1, n3 + n5);
        }
    }

    protected static void c(cm cm2, int n2, int n3, int n4) {
        for (int i2 = 0; i2 < 3; ++i2) {
            cm2.e(n2 - i2, n3 + i2, n2 + i2, n3 + i2);
            cm2.e(n2 - 2 + i2, n3 + n4 + i2, n2 + 2 - i2, n3 + n4 + i2);
        }
    }

    protected static void a(cm cm2, byte[] byArray, int n2, int n3, int n4) {
        cg cg2 = rpg.e.r;
        int n5 = cg2.int_a() / 10;
        int n6 = cg2.b();
        for (int i2 = 0; i2 < 9; ++i2) {
            cm2.b(n2 + i2 * n4, n3, n5, n6);
            cm2.a(cg2, n2 + i2 * n4 - byArray[9 - i2 - 1] * n5, n3, 20);
        }
        rpg.a.a(cm2);
    }

    protected static void d(cm cm2, int n2, int n3, int n4, int n5) {
        byte[] byArray = new byte[9];
        cg cg2 = rpg.e.r;
        int n6 = cg2.int_a() / 10;
        int n7 = cg2.b();
        int n8 = 0;
        do {
            byte by2 = (byte)(n2 % 10);
            int n9 = n8;
            n8 = (byte)(n8 + 1);
            byArray[n9] = by2;
        } while ((n2 /= 10) != 0);
        for (n2 = 0; n2 < 9; ++n2) {
            cm2.b(n3 + n2 * 7, n4, n6, n7);
            cm2.a(cg2, n3 + n2 * 7 - byArray[9 - n2 - 1] * n6, n4, 20);
        }
        rpg.a.a(cm2);
    }

    protected static void d(cm cm2, int n2, int n3, int n4) {
        n.b(cm2, n2, n3 + 8, n4, 8, 0);
        cm2.b(n3 + 10, n4, 7, 7);
        cm2.a(rpg.e.w, n3 + 10, n4, 20);
        cm2.b(0, 0, rpg.a.var_int_a, rpg.a.var_int_b);
    }

    public static final void b(cm cm2, int n2, int n3, int n4, int n5, int n6) {
        cg cg2;
        byte[] byArray = new byte[9];
        boolean bl2 = false;
        if (n6 == 0) {
            cg2 = rpg.e.r;
        } else {
            cg2 = rpg.e.var_cg_arr_h[n6 - 1];
            bl2 = true;
        }
        int n7 = cg2.int_a() / 10;
        int n8 = n7 - 1;
        int n9 = cg2.b();
        int n10 = 0;
        do {
            byte by2 = (byte)(n2 % 10);
            int n11 = n10;
            n10 = (byte)(n10 + 1);
            byArray[n11] = by2;
        } while ((n2 /= 10) != 0);
        n2 = n3;
        if (n5 == 1) {
            n2 = n3 - n10 * n8 / 2;
        } else if (n5 == 8) {
            n2 = n3 - n10 * n8;
        }
        for (n3 = 0; n3 < n10; ++n3) {
            if (bl2) {
                bs.e(cm2);
                cm2.c(n2 + n3 * n8, n4, n7, n9);
            } else {
                cm2.b(n2 + n3 * n8, n4, n7, n9);
            }
            cm2.a(cg2, n2 + n3 * n8 - byArray[n10 - n3 - 1] * n7, n4, 20);
        }
        if (n6 == 0) {
            rpg.a.a(cm2);
            return;
        }
        bs.e(cm2);
    }

    protected static void c(cm cm2, int n2, int n3, int n4, int n5, int n6) {
        cm2.a(n6);
        cm2.a(n2, n3 + 1, n4, n5 - 2);
        cm2.e(n2 + 1, n3, n2 + n4 - 2, n3);
        cm2.e(n2 + 1, n3 + n5 - 1, n2 + n4 - 2, n3 + n5 - 1);
    }

    protected static void d(cm cm2, int n2, int n3, int n4, int n5, int n6) {
        cm2.a(0xFF0000);
        cm2.e(n2, n3 + 1, n2, n3 + 13 - 2);
        cm2.e(n2 + 40 - 1, n3 + 1, n2 + 40 - 1, n3 + 13 - 2);
        cm2.e(n2 + 1, n3, n2 + 40 - 2, n3);
        cm2.e(n2 + 1, n3 + 13 - 1, n2 + 40 - 2, n3 + 13 - 1);
    }

    protected final void a(cm cm2, int n2, int n3, int n4, byte[] byArray, boolean bl2) {
        n.c(cm2, n2, n3, n4, 14, bl2 ? 0x660000 : 3550755);
        cm2.a(13682856);
        ac.a(cm2, n2 + (n4 >> 1), n3 + 1, byArray, 0, 1);
    }

    protected final void e(cm cm2, int n2, int n3, int n4, int n5) {
        if (n5 < 2) {
            return;
        }
        n5 = 60 / n5;
        cm2.a(0);
        cm2.a(n2, n3, 4, 60);
        cm2.a(0x7F7F7F);
        cm2.d(n2, n3, 4, 60);
        cm2.a(n2, n3 + n4 * n5, 4, n5);
        n.c(cm2, n2 + 2, n3 - 4, 66);
    }

    static {
        var_int_arr_a = new int[]{0x660000, 0x3F3F3F, 0x996600, 39168, 39321, 0x990099};
        var_int_arr_b = new int[]{0x990000, 0xFF0000};
        var_cg_b = cg.a("/sks/ok.png");
        var_cg_a = cg.a("/sks/back.png");
        var_boolean_c = false;
        c_ = 0;
    }
}

