/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;
import rpg.f;

final class r
extends b {
    private boolean var_boolean_e;
    private byte var_byte_f;
    private byte[] var_byte_arr_a;
    private byte[] b;
    private short[] var_short_arr_a;
    private int var_int_e;
    private boolean var_boolean_f;

    r(n n2, boolean bl2) {
        super(n2, (byte)7);
        this.var_boolean_e = bl2;
        this.var_byte_a = 0;
        this.var_byte_f = 0;
        this.var_int_e = this.var_boolean_e || rpg.a.var_int_a < 176 ? rpg.f.g : (rpg.a.var_int_a < 240 ? 120 : rpg.f.g);
        this.c(this.var_byte_f);
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.f(n2, n3) || n.g(n2, n3)) {
            if (n2 == -7) {
                this.var_n_a.var_byte_a = (byte)(this.var_boolean_e ? 2 : 4);
                this.var_n_a.c();
                n.var_boolean_c = false;
            }
            return true;
        }
        if (n2 == 2 || n3 == 52) {
            this.var_byte_f = (byte)((this.var_byte_f + 7 - 1) % 7);
            this.var_boolean_f = true;
            return true;
        }
        if (n2 == 5 || n3 == 54) {
            this.var_byte_f = (byte)((this.var_byte_f + 1) % 7);
            this.var_boolean_f = true;
            return true;
        }
        return this.c(n2, n3);
    }

    private void c(byte by2) {
        this.var_boolean_f = false;
        this.var_byte_arr_a = rpg.e.var_ch_e.a(by2);
        this.b = rpg.e.var_ch_e.a(by2 + 7);
        short[] sArray = new short[20];
        int n2 = 0;
        for (int i2 = 0; i2 < this.b.length; i2 += ac.a(this.b, i2, this.var_int_e, 5)) {
            sArray[n2++] = (short)i2;
        }
        this.var_short_arr_a = new short[n2];
        System.arraycopy(sArray, 0, this.var_short_arr_a, 0, this.var_short_arr_a.length);
        this.var_byte_b = (byte)this.var_short_arr_a.length;
        this.var_byte_a = 0;
    }

    protected final void a(cm cm2) {
        short s2;
        int n2;
        if (this.var_boolean_f) {
            this.c(this.var_byte_f);
        }
        int n3 = rpg.a.d;
        if (this.var_boolean_e) {
            this.void_a(cm2, false, false, true, false);
            if (this.var_byte_f == 9) {
                cm2.a(4217367);
            } else {
                cm2.a(0);
            }
            n2 = this.b_ + 14;
            n.c(cm2, this.a_ + 2, n2, rpg.d.e_ - 4, 14);
            cm2.e(this.a_, n2 += 15, this.a_ + rpg.d.e_ - 1, n2);
            n.c(cm2, this.a_ + 2, n2 += 2, rpg.d.e_ - 4, 134);
            n3 -= 43;
        } else {
            rpg.a.a(cm2, true);
            n3 -= 36;
            if (this.var_byte_f == 9) {
                cm2.a(4217367);
                n.c(cm2, rpg.a.var_int_a - this.var_int_e - 8 >> 1, n3 + 27 - 2, this.var_int_e + 8, 94);
            }
        }
        cm2.a(14597755);
        ac.a(cm2, rpg.a.c, rpg.f.d, rpg.e.var_ch_b.a(8), 0, 1);
        ac.a(cm2, rpg.a.c, rpg.f.d + 15, this.var_byte_arr_a, 0, 1);
        n.a(cm2, rpg.a.c - (rpg.f.f >> 1), rpg.f.d + 20, rpg.f.f, 0xFFFFFF, false);
        cm2.a(0xCCCCCC);
        n2 = this.var_short_arr_a[this.var_byte_a];
        short s3 = s2 = this.var_byte_a == this.var_byte_b - 1 ? (short)this.b.length : this.var_short_arr_a[this.var_byte_a + 1];
        if (this.b[0] == 33) {
            if (n2 == 0) {
                n2 = 1;
            }
            ac.var_boolean_a = false;
        }
        int n4 = rpg.a.var_int_a - this.var_int_e >> 1;
        ac.a(cm2, n4, n3 + 27, this.var_int_e, 1, this.b, n2, 0, s2 - n2);
        ac.var_boolean_a = true;
        this.a(cm2, this.a_ + rpg.d.e_ - 10, n3 + 17, this.var_byte_a + 1, this.var_byte_b, 8);
        this.e(cm2, n4 + this.var_int_e + 2, n3 + 25, this.var_byte_a, this.var_byte_b);
        n.a(cm2, 2);
    }
}

