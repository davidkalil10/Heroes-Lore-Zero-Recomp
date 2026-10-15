/*
 * Decompiled with CFR 0.152.
 */
import rpg.RPGHeroEx;
import rpg.a;
import rpg.d;
import rpg.e;
import rpg.f;

public final class i
extends n
implements f {
    private static i a = null;

    public static i i_a() {
        if (a == null) {
            a = new i();
        }
        return a;
    }

    public static void void_a() {
        if (a != null) {
            a = null;
        }
        di.var_byte_arr_arr_a = null;
        System.gc();
        Runtime.getRuntime().gc();
    }

    public i() {
        super(null, (byte)8);
        this.var_byte_a = di.var_byte_i > 0 ? (byte)1 : 0;
        this.f();
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (this.d(n2, n3)) {
            while (this.var_byte_a == 1 && di.var_byte_i <= 0 || this.var_byte_a == 6 && cf.var_java_lang_String_a.equals("off")) {
                if (n2 == 5 || n3 == 54) {
                    this.var_byte_a = (byte)(this.var_byte_a + 1);
                    continue;
                }
                this.var_byte_a = (byte)(this.var_byte_a - 1);
            }
            this.f();
            return true;
        }
        if (n.f(n2, n3)) {
            n3 = this.var_byte_a;
            i i2 = this;
            switch (n3) {
                case 0: 
                case 1: {
                    i2.var_n_b = new au(i2, (byte)n3);
                    break;
                }
                case 3: {
                    i2.var_n_b = new bd((n)i2, false);
                    break;
                }
                case 4: {
                    i2.var_n_b = new r((n)i2, false);
                    break;
                }
                case 5: {
                    i2.var_n_b = new j(i2);
                    break;
                }
                case 6: {
                    i2.var_n_b = new cf(i2);
                    break;
                }
                case 2: {
                    i2.var_n_b = new au(i2, (byte)n3);
                    break;
                }
                case 7: {
                    byte[] byArray = rpg.d.u;
                    v0.var_n_b = new bt((n)i2, byArray, 3, false, true);
                }
            }
            return true;
        }
        return false;
    }

    final void void_a(byte by2, byte by3) {
        this.c();
        if (by2 == 3 && by3 == 0) {
            switch (this.var_byte_a) {
                case 7: {
                    RPGHeroEx.a.destroyApp(true);
                }
            }
        }
    }

    protected final void a(cm cm2) {
        bs.bs_a();
        rpg.a.c(cm2);
        if (!this.var_boolean_b) {
            this.b(cm2);
        }
    }

    protected final void b(cm cm2) {
        int n2;
        if (this.var_byte_e < 8) {
            n2 = 30 * this.var_byte_e;
            cm2.a(n2, n2, n2);
        } else {
            cm2.a(0xFFFFFF);
        }
        n2 = rpg.a.d + (rpg.a.d >> 1) - 3;
        cm2.a(rpg.e.var_cg_a, rpg.a.c, n2, 17);
        ac.a(cm2, rpg.a.c, n2 + 3, rpg.e.var_ch_c.a(this.var_byte_a), 0, 1);
    }

    protected final void b() {
        if (this.var_byte_e > 8) {
            this.var_boolean_b = false;
        }
    }
}

