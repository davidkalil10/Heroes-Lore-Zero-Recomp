/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;
import rpg.f;

final class w
extends de {
    private byte f = 0;
    private boolean g = true;
    private byte[] c = new byte[9];
    private int e = 0;

    public w(n n2) {
        super(n2, (byte)2, (byte)2, (byte)1);
        this.var_byte_a = 0;
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            if (this.g) {
                this.var_n_a.c();
            } else {
                this.var_byte_d = (byte)2;
                this.var_byte_b = (byte)2;
                this.var_byte_a = this.f;
                this.g = true;
            }
            return true;
        }
        if (n.f(n2, n3)) {
            if (this.g) {
                this.f = this.var_byte_a;
                this.var_byte_a = this.c[this.e];
                this.var_byte_d = (byte)10;
                this.var_byte_b = (byte)10;
                this.g = false;
            } else {
                w w2 = this;
                n3 = 0;
                for (int i2 = w2.c.length - 1; i2 >= 0; --i2) {
                    n3 = n3 * 10 + w2.c[i2];
                }
                int n4 = n3;
                if (n4 != 0) {
                    if (this.f == 0) {
                        n3 = n4 <= di.var_int_e ? 1 : 0;
                    } else {
                        n3 = n4 <= de.var_int_f ? 1 : 0;
                        n4 = 0 - n4;
                    }
                    if (n3 == 0) {
                        this.a(rpg.e.var_ch_h.a(25));
                    } else {
                        di.var_int_e -= n4;
                        di.l();
                        de.var_int_f += n4;
                        de.i();
                    }
                }
            }
            return true;
        }
        if (!this.g) {
            if (n3 == 52 || n2 == 2) {
                ++this.e;
                if (this.e > 8) {
                    this.e = 0;
                }
                this.var_byte_a = this.c[this.e];
                return true;
            }
            if (n3 == 54 || n2 == 5) {
                --this.e;
                if (this.e < 0) {
                    this.e = 8;
                }
                this.var_byte_a = this.c[this.e];
                return true;
            }
        }
        return this.e(n2, n3);
    }

    protected final boolean e(int n2, int n3) {
        if (this.g) {
            return super.e(n2, n3);
        }
        if (n3 == 50 || n2 == 1) {
            this.void_a((byte)4);
            this.c[this.e] = this.var_byte_a;
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            this.void_a((byte)3);
            this.c[this.e] = this.var_byte_a;
            return true;
        }
        return false;
    }

    protected final void a(cm cm2) {
        int n2;
        this.a(cm2, rpg.e.var_ch_h.a(0), true, false);
        int n3 = rpg.f.e - 3;
        int n4 = 0;
        for (n2 = 0; n2 < 2; n2 = (int)((byte)(n2 + 1))) {
            boolean bl2 = this.g ? this.var_byte_a == n2 : this.f == n2;
            n4 = this.b_ + 25 + n2 * 24;
            n.a(cm2, this.a_ + 3, n4, n3 - 3, 18, bl2 ? 0x660000 : 3550755, bl2 ? 0xBD0000 : 7027456);
            cm2.a(bl2 ? 0xFFFFFF : 12630160);
            ac.a(cm2, rpg.a.c, n4, rpg.e.var_ch_h.a(n2 + 20), 0, 1);
        }
        n.a(cm2, this.c, this.a_ + 14, n4 + 25, 7);
        if (!this.g) {
            n.a(cm2, this.a_ + 8, n4 + 21 + 7, 123, 3550755, false);
            n2 = this.a_ + 16 + (8 - this.e) * 7;
            n.c(cm2, n2, n4 + 15 + 6, 12);
        }
        cm2.a(0xFF0000);
        n.c(cm2, this.a_ + 78 + 18, n4 + 15 + 7, 97, 14);
        cm2.a(0xFFFFFF);
        if (this.g) {
            if (this.var_byte_a == 0) {
                ac.a(cm2, this.a_ + 80 + 18, n4 + 15 + 7, rpg.e.var_ch_h.a(48), 0);
            } else {
                ac.a(cm2, this.a_ + 80 + 18, n4 + 15 + 7, rpg.e.var_ch_h.a(49), 0);
            }
        } else if (this.f == 0) {
            ac.a(cm2, this.a_ + 80 + 18, n4 + 15 + 7, rpg.e.var_ch_h.a(48), 0);
        } else {
            ac.a(cm2, this.a_ + 80 + 18, n4 + 15 + 7, rpg.e.var_ch_h.a(49), 0);
        }
        cm2.a(15723216);
        cm2.e(this.a_, n4 + 30 + 10, this.a_ + rpg.d.e_ - 1, n4 + 30 + 10);
        cm2.a(3550755);
        n.c(cm2, this.a_ + 3, n4 + 33 + 10, n3 - 3, 73);
        n2 = this.g ? (this.var_byte_a == 0 ? 1 : 0) : (this.f == 0 ? 1 : 0);
        cm2.a(n2 != 0 ? 9032496 : 12630160);
        ac.a(cm2, rpg.a.c, n4 + 34 + 10 + 5, rpg.e.var_ch_h.a(23), 0, 1);
        n.d(cm2, de.var_int_f, this.a_ + 28 + 20, n4 + 47 + 10 + 10, 7);
        cm2.a(n2 != 0 ? 12630160 : 9032496);
        ac.a(cm2, rpg.a.c, n4 + 63 + 10 + 15, rpg.e.var_ch_h.a(24), 0, 1);
        n.d(cm2, di.var_int_e, this.a_ + 28 + 20, n4 + 76 + 10 + 20, 7);
        cm2.a(0);
        n.c(cm2, rpg.a.c - 6, n4 + 55 + 23, 9, 6);
        cm2.a(9032496);
        if (n2 != 0) {
            cm2.e(rpg.a.c - 2, n4 + 57 + 23, rpg.a.c - 2, n4 + 57 + 23);
            cm2.e(rpg.a.c - 3, n4 + 58 + 23, rpg.a.c - 1, n4 + 58 + 23);
            cm2.e(rpg.a.c - 4, n4 + 59 + 23, rpg.a.c, n4 + 59 + 23);
            return;
        }
        cm2.e(rpg.a.c - 4, n4 + 57 + 23, rpg.a.c, n4 + 57 + 23);
        cm2.e(rpg.a.c - 3, n4 + 58 + 23, rpg.a.c - 1, n4 + 58 + 23);
        cm2.e(rpg.a.c - 2, n4 + 59 + 23, rpg.a.c - 2, n4 + 59 + 23);
    }
}

