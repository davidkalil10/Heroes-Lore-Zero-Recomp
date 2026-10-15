/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;
import rpg.f;

final class be
extends q {
    private static ch a;
    private static cg b;
    private static cg c;
    private int var_int_e = 0;
    private int f = rpg.a.c;
    private int j = rpg.a.d + 1;
    private int k = 5;
    private boolean var_boolean_e;

    public be(n n2) {
        super(n2, (byte)6, (byte)1, (byte)1);
        this.var_boolean_b = true;
        a = new ch("/t/j");
        b = cg.a("/gunsword.png");
        c = cg.a("/wizard.png");
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            this.var_n_a.var_byte_a = di.j;
            a = null;
            b = null;
            c = null;
            this.var_n_a.c();
            return true;
        }
        if (n.f(n2, n3)) {
            if (this.boolean_a(this.var_byte_a)) {
                di.var_byte_b = this.var_byte_a;
                di.void_a(0);
                b = null;
                c = null;
            } else {
                this.var_n_b = new br((n)this, a.a(4), '\u0000');
            }
            return true;
        }
        if (this.d(n2, n3)) {
            this.k = 0;
            this.var_int_e = 0;
            this.var_boolean_e = n.i(n2, n3);
        }
        return true;
    }

    protected final void a(cm cm2) {
        rpg.a.a(cm2, true);
        di.var_byte_b = this.var_byte_a;
        this.a(cm2, (byte)(this.var_byte_a + 6));
        cm2.a(14597755);
        ac.a(cm2, rpg.a.c, rpg.f.d, rpg.e.var_ch_i.a(4), 0, 1);
        if (this.var_n_b != null && this.var_boolean_b) {
            this.b(cm2);
        }
        n.a(cm2, 3);
    }

    protected final void b(cm cm2) {
        cm2.b(this.a_, this.j - 33, rpg.d.e_, 44);
        cm2.a(0);
        cm2.a(this.a_, this.j - 33, rpg.d.e_, 44);
        int n2 = (this.var_byte_a + this.var_byte_b - 1) % this.var_byte_b;
        int n3 = (this.var_byte_a + 1) % this.var_byte_b;
        if (this.k == 5) {
            rpg.e.var_s_a.a((byte)8, (byte)1, 0, this.f, this.j);
            be.a(this.f - 35, this.j - 5, n3);
            be.a(this.f + 35, this.j - 5, n2);
            if (this.var_byte_a >= 4) {
                int n4 = this.j;
                int n5 = this.f;
                int n6 = this.var_int_e;
                n3 = this.var_byte_a;
                be be2 = this;
                if (n3 == 4) {
                    if (!di.var_boolean_g) {
                        be.a(n5, n4, n3);
                    } else if (b != null) {
                        int n7 = rpg.a.var_cm_a.int_a();
                        n3 = rpg.a.var_cm_a.b();
                        int n8 = rpg.a.var_cm_a.c();
                        int n9 = rpg.a.var_cm_a.d();
                        rpg.a.var_cm_a.c(n5 - 28, n4 - 26, 42, 42);
                        int n10 = 0;
                        int n11 = 0;
                        if (n6 < 3) {
                            n10 = n6 == 0 ? 0 : (n6 == 1 ? 42 : 84);
                        } else if (n6 < 6) {
                            n11 = 42;
                            n10 = n6 == 3 ? 0 : (n6 == 4 ? 42 : 84);
                        } else if (n6 < 8) {
                            n11 = 84;
                            n10 = n6 == 6 ? 0 : 42;
                        } else {
                            n6 = 0;
                        }
                        rpg.a.var_cm_a.a(b, n5 - 28 - n10, n4 - 26 - n11, 0);
                        rpg.a.var_cm_a.b(n7, n3, n8, n9);
                    }
                } else if (n3 == 5) {
                    if (!di.var_boolean_h) {
                        be.a(n5, n4, n3);
                    } else if (c != null) {
                        int n12 = rpg.a.var_cm_a.int_a();
                        n3 = rpg.a.var_cm_a.b();
                        int n13 = rpg.a.var_cm_a.c();
                        int n14 = rpg.a.var_cm_a.d();
                        rpg.a.var_cm_a.c(n5 - 17, n4 - 22, 27, 27);
                        int n15 = 0;
                        int n16 = 0;
                        if (n6 < 3) {
                            n15 = n6 == 0 ? 0 : (n6 == 1 ? 27 : 54);
                        } else if (n6 < 6) {
                            n16 = 27;
                            n15 = n6 == 3 ? 0 : (n6 == 4 ? 27 : 54);
                        } else if (n6 < 8) {
                            n16 = 54;
                            n15 = n6 == 6 ? 0 : 27;
                        } else {
                            n6 = 0;
                        }
                        rpg.a.var_cm_a.a(c, n5 - 17 - n15, n4 - 22 - n16, 0);
                        rpg.a.var_cm_a.b(n12, n3, n13, n14);
                    }
                }
                this.var_int_e = n6 + 1;
            } else {
                this.var_int_e = rpg.e.var_s_a.a(this.var_byte_a, (byte)1, this.var_int_e, this.f, this.j) + 1;
            }
        } else if (this.var_boolean_e) {
            int n17 = (n2 + this.var_byte_b - 1) % this.var_byte_b;
            be.a(this.f - 70 + 7 * this.k, this.j - 5, n3);
            be.a(this.f + 7 * this.k, this.j - this.k, n2);
            be.a(this.f + 35 + 7 * this.k, this.j - 5, n17);
            be.a(this.f - 35 + 7 * this.k, this.j - 5 + this.k, (int)this.var_byte_a);
        } else {
            int n18 = (n3 + 1) % this.var_byte_b;
            be.a(this.f - 35 - 7 * this.k, this.j - 5, n18);
            be.a(this.f - 7 * this.k, this.j - this.k, n3);
            be.a(this.f + 70 - 7 * this.k, this.j - 5, n2);
            be.a(this.f + 35 - 7 * this.k, this.j - 5 + this.k, (int)this.var_byte_a);
        }
        if (this.k < 5) {
            ++this.k;
        }
    }

    private static void a(int n2, int n3, int n4) {
        if (n4 >= 6) {
            return;
        }
        if (n4 >= 4) {
            if (n4 == 4) {
                if (b != null) {
                    n4 = rpg.a.var_cm_a.int_a();
                    int n5 = rpg.a.var_cm_a.b();
                    int n6 = rpg.a.var_cm_a.c();
                    int n7 = rpg.a.var_cm_a.d();
                    rpg.a.var_cm_a.c(n2 - 28, n3 - 26, 42, 42);
                    rpg.a.var_cm_a.a(b, n2 - 112, n3 - 110, 0);
                    rpg.a.var_cm_a.b(n4, n5, n6, n7);
                    return;
                }
            } else if (n4 == 5 && c != null) {
                n4 = rpg.a.var_cm_a.int_a();
                int n8 = rpg.a.var_cm_a.b();
                int n9 = rpg.a.var_cm_a.c();
                int n10 = rpg.a.var_cm_a.d();
                rpg.a.var_cm_a.c(n2 - 17, n3 - 22, 27, 27);
                rpg.a.var_cm_a.a(c, n2 - 71, n3 - 76, 0);
                rpg.a.var_cm_a.b(n4, n8, n9, n10);
                return;
            }
        } else {
            rpg.e.var_s_a.a((byte)(n4 + 4), (byte)1, 0, n2, n3);
        }
    }

    static {
        b = null;
        c = null;
    }
}

