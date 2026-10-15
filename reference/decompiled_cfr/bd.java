/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;
import rpg.e;
import rpg.f;

final class bd
extends l {
    private boolean e;

    bd(n n2, boolean bl2) {
        super(n2, (byte)7);
        this.e = bl2;
        this.var_boolean_b = true;
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.f(n2, n3) || n.g(n2, n3)) {
            if (n2 == -7) {
                try {
                    rpg.c.rpg_c_a().j();
                }
                catch (Exception exception) {}
                n.var_boolean_c = false;
                this.var_n_a.var_byte_a = (byte)(this.e ? 1 : 3);
                this.var_n_a.c();
            }
            return true;
        }
        if (n.h(n2, n3)) {
            switch (this.var_byte_a) {
                case -100: {
                    rpg.c.var_byte_a = bd.byte_a(rpg.c.var_byte_a, (byte)10);
                    break;
                }
                case 2: {
                    rpg.c.var_byte_b = bd.byte_a(rpg.c.var_byte_b, (byte)4);
                    break;
                }
                case 3: {
                    rpg.c.var_byte_c = bd.byte_a(rpg.c.var_byte_c, (byte)4);
                    break;
                }
                case 5: {
                    rpg.c.var_byte_d = bd.byte_a(rpg.c.var_byte_d, (byte)2);
                }
            }
            this.c(this.var_byte_a);
            return true;
        }
        if (n.i(n2, n3)) {
            switch (this.var_byte_a) {
                case -100: {
                    byte by2 = rpg.c.var_byte_a;
                    n3 = 10;
                    n2 = by2;
                    rpg.c.var_byte_a = (byte)((by2 + 1) % n3);
                    bq.a((int)rpg.c.var_byte_a);
                    break;
                }
                case 2: {
                    byte by3 = rpg.c.var_byte_b;
                    n3 = 4;
                    n2 = by3;
                    rpg.c.var_byte_b = (byte)((by3 + 1) % n3);
                    break;
                }
                case 3: {
                    byte by4 = rpg.c.var_byte_c;
                    n3 = 4;
                    n2 = by4;
                    rpg.c.var_byte_c = (byte)((by4 + 1) % n3);
                    break;
                }
                case 5: {
                    byte by5 = rpg.c.var_byte_d;
                    n3 = 2;
                    n2 = by5;
                    rpg.c.var_byte_d = (byte)((by5 + 1) % n3);
                }
            }
            this.c(this.var_byte_a);
            return true;
        }
        return this.c(n2, n3);
    }

    private static byte byte_a(byte by2, byte by3) {
        return (byte)((by2 + by3 - 1) % by3);
    }

    private void c(byte by2) {
        switch (by2) {
            case 0: {
                if (rpg.c.var_boolean_b = !rpg.c.var_boolean_b) break;
                bq.b();
                return;
            }
            case 1: {
                if (!(rpg.c.var_boolean_c = !rpg.c.var_boolean_c)) break;
                bq.a((byte)0);
                return;
            }
            case 4: {
                rpg.c.var_boolean_a = !rpg.c.var_boolean_a;
                rpg.c.k();
                return;
            }
            case -100: {
                bq.a((int)rpg.c.var_byte_a);
                if (rpg.c.var_byte_a == 0) {
                    bq.b();
                    return;
                }
                if (rpg.c.var_boolean_b) {
                    bq.var_long_a = 0L;
                    bq.a();
                    break;
                }
                bq.a((byte)0, false);
                bq.var_long_a = System.currentTimeMillis() + 3000L;
                return;
            }
            case 2: {
                rpg.c.a(rpg.c.var_byte_b);
                return;
            }
            case 6: {
                rpg.c.var_boolean_d = !rpg.c.var_boolean_d;
            }
        }
    }

    protected final void a(cm cm2) {
        int n2 = rpg.a.d;
        if (this.e) {
            this.void_a(cm2, false, false, true, false);
            n2 = this.a(cm2, -1, f.b - 2, false);
        } else {
            rpg.a.a(cm2, true);
            n2 = rpg.a.var_int_b <= 208 ? (n2 -= 60) : (n2 -= 32);
        }
        cm2.a(14597755);
        ac.a(cm2, rpg.a.c, f.d, rpg.e.var_ch_b.a(7), 0, 1);
        int n3 = rpg.a.c - 75;
        cm2.a(0xFFFFFF);
        int n4 = 0;
        int n5 = n2;
        while (n4 < 7) {
            ac.a(cm2, n3, n5, rpg.e.var_ch_b.a(n4 + 16), 0);
            ++n4;
            n5 += 15;
        }
        n3 = rpg.a.c + 24 + 25 + 8;
        this.a(cm2, n3, n2, rpg.c.var_boolean_b, (byte)0);
        this.a(cm2, n3, n2 + 14 + 1, rpg.c.var_boolean_c, (byte)1);
        cm2.a(this.var_byte_a == 2 ? 0xFFFFFF : 12630160);
        ac.a(cm2, n3, n2 + 1 + 28 + 2, rpg.e.var_ch_b.a(23 + rpg.c.var_byte_b), 0, 1);
        int n6 = n2 + 1 + 42 + 2;
        int n7 = n3;
        cm cm3 = cm2;
        bd bd2 = this;
        if (rpg.c.var_byte_c == 0) {
            int n8 = 3;
            n7 = n6;
            bd bd3 = bd2;
            cm3.a(bd3.var_byte_a == 3 ? 0xFFFFFF : 12630160);
            ac.a(cm3, rpg.a.c + 24 + 25, n7 + 1, rpg.e.var_ch_b.a(38), 0);
        } else {
            cm3.a(bd2.var_byte_a == 3 ? 0xFFFFFF : 12630160);
            ac.a(cm3, n7, n6, ("" + rpg.c.var_byte_c).getBytes(), 0, 1);
        }
        this.a(cm2, n3, n2 + 56 + 4, rpg.c.var_boolean_a, (byte)4);
        cm2.a(this.var_byte_a == 5 ? 0xFFFFFF : 12630160);
        ac.a(cm2, n3, n2 + 70 + 6, rpg.e.var_ch_b.a(35 + rpg.c.var_byte_d), 0, 1);
        cm2.a(this.var_byte_a == 6 ? 0xFFFFFF : 12630160);
        ac.a(cm2, n3, n2 + 84 + 6, rpg.e.var_ch_b.a(rpg.c.var_boolean_d ? 37 : 38), 0, 1);
        n.a(cm2, 2);
    }

    protected final void b(cm cm2) {
        int n2 = rpg.a.d + 4 + 15 * (this.var_byte_a - 3) + (this.e ? -24 : 14);
        if (rpg.a.var_int_b <= 208 && !this.e) {
            n2 -= 28;
        }
        n2 = this.e ? (n2 += 17) : (n2 += 3);
        n.a(cm2, rpg.a.c + 21, n2, 69, 0xFFFFFF, false);
    }

    private void a(cm cm2, int n2, int n3, boolean bl2, byte by2) {
        cm2.a(this.var_byte_a == by2 ? 0xFFFFFF : 12630160);
        ac.a(cm2, n2, n3 + 1, rpg.e.var_ch_b.a(bl2 ? 37 : 38), 0, 1);
    }
}

