/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;

public abstract class bo
extends p {
    protected ch var_ch_a = new ch("/t/n");
    protected byte[] var_byte_arr_a = null;
    protected byte f = 0;

    public bo(n n2) {
        super(n2, (byte)28, (byte)4, (byte)7);
        this.b_ = rpg.a.var_int_b < 240 ? rpg.a.var_int_b - 174 - 33 >> 1 : this.b_;
        this.b_ = this.b_ < 0 ? 0 : this.b_;
    }

    protected boolean boolean_a(as as2) {
        return true;
    }

    protected final void a(cm cm2, bj bj2) {
        int n2 = this.a_ + 70;
        int n3 = this.b_ + 17;
        cm2.a(15723216);
        n.c(cm2, n2 - 1, n3 - 1, 106, 61);
        for (int i2 = 0; i2 < 28; ++i2) {
            as as2 = bj2.as_a(i2);
            int n4 = i2 / 7;
            int n5 = i2 - n4 * 7;
            n5 = n2 + n5 * 15;
            n4 = n3 + n4 * 15;
            if (as2 != null) {
                boolean bl2 = this.boolean_a(as2);
                if (!bl2) {
                    cm2.b(127);
                }
                as2.a(cm2, n5, n4);
                if (!bl2) {
                    cm2.b(255);
                }
                if (as2.c > 1) {
                    n.b(cm2, as2.c, n5 + 14 - 1, n4 + 14 - 7, 8, 0);
                }
                if (!as2.c()) continue;
                cm2.a(0xFF0000);
                cm2.d(n5, n4, 13, 13);
                continue;
            }
            cm2.a(0);
            n.c(cm2, n5, n4, 14, 14);
        }
    }

    protected final void b(cm cm2) {
        int n2 = this.var_byte_a / 7;
        int n3 = this.var_byte_a % 7;
        n3 = this.a_ + 70 + n3 * 15;
        n2 = this.b_ + 17 + n2 * 15;
        bo.b(cm2, n3, n2);
    }

    protected static void b(cm cm2, int n2, int n3) {
        cm2.a(0x660000);
        cm2.d(n2, n3 - 1, 13, 15);
        cm2.e(n2 - 1, n3, n2 - 1, n3 + 14 - 1);
        cm2.e(n2 + 14, n3, n2 + 14, n3 + 14 - 1);
        cm2.a(0xFF0000);
        cm2.e(n2, n3 + 1, n2, n3 + 14 - 1 - 1);
        cm2.e(n2 + 14 - 1, n3 + 1, n2 + 14 - 1, n3 + 14 - 1 - 1);
        cm2.e(n2 + 1, n3, n2 + 14 - 2, n3);
        cm2.e(n2 + 1, n3 + 14 - 1, n2 + 14 - 2, n3 + 14 - 1);
    }

    protected final void a(cm cm2, byte n2, byte by2, boolean bl2) {
        int n3 = this.b_ + 16;
        byte[] byArray = new byte[1];
        byte[] byArray2 = byArray;
        byArray[0] = 65;
        for (int i2 = 0; i2 < n2; ++i2) {
            cm2.a(i2 == by2 ? (bl2 ? 0xFF0000 : 15723216) : 3550755);
            int n4 = n3 + i2 * 10 + 3;
            cm2.a(this.a_ + 50, n4, 11, 12);
            cm2.e(this.a_ + 11 + 50, n4 + 1, this.a_ + 11 + 50, n4 + 9 - 2);
            cm2.a(!bl2 && i2 == by2 ? 3550755 : 0xFFFFFF);
            ac.a(cm2, this.a_ + 2 + 50, n4 - 2, byArray2, 0);
            byArray2[0] = (byte)(byArray2[0] + 1);
        }
    }

    static void a(cm cm2, int n2, int n3, byte[] byArray, int n4) {
        int n5 = 3 + n4 * 15;
        cm2.b(n2 + 10, n3 + (n5 + 174 >> 1), rpg.d.e_ - 20, n5);
        n.b(cm2, n2 + 10, n3 + (n5 + 174 >> 1), rpg.d.e_ - 20, n5);
        cm2.a(0);
        cm2.d(n2 + 10, n3 + (n5 + 174 >> 1), rpg.d.e_ - 20 - 1, n5 - 1);
        cm2.a(0xFFFFFF);
        cm2.d(n2 + 10 + 1, n3 + (n5 + 174 >> 1) + 1, rpg.d.e_ - 20 - 3, n5 - 3);
        cm2.a(0);
        if (n4 < 2) {
            ac.a(cm2, n2 + (rpg.d.e_ >> 1), n3 + (n5 + 174 >> 1) + 2, byArray, 0, 1);
            return;
        }
        ac.a(cm2, n2 + 10 + 5, n3 + (n5 + 174 >> 1) + 2, byArray, 0, 4);
    }
}

