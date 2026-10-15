/*
 * Decompiled with CFR 0.152.
 */
import rpg.d;
import rpg.e;

final class bz
extends u {
    private final byte[] var_byte_arr_a = new byte[]{18, 19, 18};
    private final byte[] var_byte_arr_b = new byte[]{3, 3, 7};
    private do var_do_a;
    private byte e;
    private byte f;
    private int var_int_b;

    bz(do do_, byte by2, byte by3, int n2) {
        super(by2, do_.var_byte_c, (byte)(do_.s + rpg.d.H[do_.var_byte_c]), (byte)(do_.t + rpg.d.I[do_.var_byte_c]), true);
        this.var_do_a = do_;
        this.f = this.var_byte_arr_b[by2];
        this.var_int_b = n2;
        this.e = by3;
        this.var_short_a = rpg.e.var_ca_a.a(this.var_byte_arr_a[by2]);
    }

    final void a() {
        if (this.f > 0) {
            this.c(this.s, this.t);
            if (this.c == 2) {
                this.c(this.s + rpg.d.M[this.d], this.t + rpg.d.M[this.d]);
                this.c(this.s + rpg.d.L[this.d], this.t + rpg.d.L[this.d]);
            }
            byte by2 = (byte)(this.s + rpg.d.H[this.d]);
            byte by3 = (byte)(this.t + rpg.d.I[this.d]);
            if (by2 >= 0 && by2 < g.var_byte_c && by3 >= 0 && by3 < g.var_byte_d) {
                if (!di.var_g_a.boolean_b((int)by2, (int)by3)) {
                    this.a((short)(by2 << 4), (short)((by3 << 4) + 1));
                    this.E();
                } else {
                    this.f = 0;
                }
                this.f = (byte)(this.f - 1);
            } else {
                this.var_boolean_a = true;
            }
            di.var_g_a.void_c(2, this.f);
            return;
        }
        this.var_boolean_a = true;
    }

    final void a(int n2, int n3) {
        n2 = n2 + this.h + this.q;
        n3 = n3 + this.i + this.r - (this.var_boolean_b ? u.var_byte_a : u.var_byte_b);
        rpg.e.var_ca_a.a(this.var_byte_arr_a[this.c], this.d, this.var_int_a, n2, n3);
    }

    private void c(int n2, int n3) {
        if (n2 < 0 || n3 < 0 || n2 >= g.var_byte_c || n3 >= g.var_byte_d) {
            return;
        }
        du du2 = di.var_g_a.var_du_arr_arr_a[n3][n2];
        if (du2 != null && du2 instanceof cd && !(du2 instanceof h)) {
            ((cd)du2).a(this.var_do_a, this.e, this.var_int_b, false, this.d, (byte)2, false, true, false);
        }
    }
}

