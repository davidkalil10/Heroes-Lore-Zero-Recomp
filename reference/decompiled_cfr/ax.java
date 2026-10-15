/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;
import rpg.d;
import rpg.f;

public final class ax
extends l {
    private static ax var_ax_a;
    public static ch var_ch_a;
    public static byte var_byte_f;
    public static ch b;
    public static ch c;
    public static boolean e;
    public static boolean var_boolean_f;
    public static boolean var_boolean_g;
    public static boolean var_boolean_h;
    public static boolean var_boolean_i;
    public static boolean j;
    public static byte var_byte_g;
    public static byte var_byte_h;
    public static byte var_byte_i;
    public static boolean k;

    public static ax ax_a() {
        if (var_ax_a == null) {
            var_ax_a = new ax();
        }
        return var_ax_a;
    }

    public ax() {
        super(null, (byte)8);
        if (eb.var_boolean_f && this.var_byte_a == -1) {
            this.var_byte_a = 0;
        }
    }

    public final void void_a() {
        if (var_ch_a == null) {
            var_ch_a = new ch("/t/gm");
        }
        e = di.var_byte_h > 0 || di.byte_a(4) == 2;
        rpg.c.rpg_c_a().h();
        var_boolean_f = false;
        var_boolean_g = false;
    }

    public final void c(byte by2) {
        switch (by2) {
            case 1: {
                this.var_byte_a = (byte)2;
                this.d((byte)2);
                var_boolean_f = false;
                var_boolean_g = false;
                return;
            }
            case 2: {
                this.var_byte_a = (byte)7;
                this.d((byte)7);
                ((dh)this.var_n_b).a();
                var_boolean_f = true;
                var_boolean_g = false;
                return;
            }
            case 3: {
                this.var_byte_a = (byte)-1;
                this.d((byte)-1);
                var_boolean_g = true;
            }
        }
    }

    public final void g() {
        this.var_byte_a = 0;
        var_ax_a = null;
        var_ch_a = null;
        if (b != null) {
            b = null;
        }
        if (c != null) {
            c = null;
        }
        dp.g();
        if (this.var_n_b != null) {
            this.var_n_b = null;
        }
        System.gc();
        Runtime.getRuntime().gc();
        rpg.c.rpg_c_a().f();
        bs.var_boolean_c = true;
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n3 >= 49 && n3 <= 56) {
            this.var_byte_a = n3 == 48 ? (byte)9 : (byte)(n3 - 49);
            this.d(this.var_byte_a);
        } else if (n.g(n2, n3)) {
            di.a((byte)7, (byte)0);
        } else if (n.f(n2, 49)) {
            this.d(this.var_byte_a);
        } else if (this.c(n2, 49)) {
            if (eb.var_boolean_f && this.var_byte_a == -1) {
                this.c(n2, 49);
            } else if (!var_boolean_h && this.var_byte_a == -2) {
                this.c(n2, 49);
            }
        }
        return true;
    }

    private final void d(byte by2) {
        var_byte_f = by2;
        switch (by2) {
            case 0: {
                this.var_n_b = new dc(this);
                return;
            }
            case 1: {
                this.var_n_b = new cy(this, 0);
                return;
            }
            case 2: {
                this.var_n_b = new dp(this);
                return;
            }
            case 3: {
                this.var_n_b = new y(this);
                return;
            }
            case 4: {
                this.var_n_b = new ce(this);
                return;
            }
            case 5: {
                this.var_n_b = new ai(this);
                return;
            }
            case 7: {
                this.var_n_b = new dh(this);
                return;
            }
            case 6: {
                di.a((byte)3, (byte)8, (byte)3);
                bs.var_boolean_e = true;
                return;
            }
            case -2: {
                this.var_n_b = new cn(this);
                return;
            }
            case -1: {
                this.var_n_b = new bw(this);
            }
        }
    }

    public final void e(cm cm2) {
        if (k) {
            k = false;
            di.var_g_a.c();
        }
        this.d(cm2);
    }

    protected final void a(cm cm2) {
        if (var_boolean_f || var_boolean_g) {
            return;
        }
        if (rpg.a.var_int_a > 120) {
            cm2.a(0);
            cm2.b((rpg.a.var_int_a - rpg.d.e_ >> 1) - 2, this.b_ - 2, rpg.d.e_ + 4, 178);
            cm2.a((rpg.a.var_int_a - rpg.d.e_ >> 1) - 2, this.b_ - 2, rpg.d.e_ + 4, 178);
        }
        cm2.b(rpg.a.var_int_a - rpg.d.e_ >> 1, this.b_, rpg.d.e_, 174);
        n.b(cm2, rpg.a.var_int_a - rpg.d.e_ >> 1, this.b_, rpg.d.e_ + 12, 174);
        int n2 = rpg.d.e_ - 9;
        int n3 = rpg.f.h >> 1;
        int n4 = rpg.a.var_int_a - n2 >> 1;
        int n5 = this.b_ + 5 + 24;
        cm2.a(15723216);
        cm2.d(n4 + 1, n5 + 1, n2, n3);
        cm2.a(0);
        cm2.d(n4, n5, n2, n3);
        ac.a(cm2, rpg.a.c, this.b_ + 3, var_ch_a.a(40), 0, 1);
        this.a(cm2, 0, rpg.f.h, true);
        n.a(cm2, 3);
    }

    static {
        e = false;
        var_boolean_f = false;
        var_boolean_g = false;
        var_boolean_h = false;
        var_boolean_i = false;
        j = false;
        var_byte_g = 0;
        var_byte_h = 0;
        var_byte_i = 0;
        k = false;
    }
}

