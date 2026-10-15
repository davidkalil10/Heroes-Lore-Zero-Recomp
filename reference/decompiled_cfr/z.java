/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.e;

final class z
extends at {
    private int d;

    z(byte by2) {
        super(by2);
        this.var_int_a = 4;
    }

    z(byte by2, byte by3) {
        super(by2);
        if (this.var_byte_a == -6) {
            this.var_int_a = 2;
            this.c = -1;
            this.d = by3;
            return;
        }
        this.var_int_a = 4;
        this.d = 0;
    }

    z(byte by2, byte by3, int n2) {
        this(by2, by3);
        if (this.var_byte_a == -6) {
            this.c = n2;
            return;
        }
        this.d = n2;
    }

    final void a(int n2, int n3) {
        cm cm2 = rpg.a.var_cm_a;
        switch (this.var_byte_a) {
            case -1: {
                cm2.a(e.var_cg_arr_i[this.var_int_b < 2 ? 3 : 2], n2, n3 - 35 - this.var_int_b * 3, 17);
                return;
            }
            case -2: {
                cm2.a(e.var_cg_arr_i[this.var_int_b < 2 ? 1 : 0], n2, n3 - 35 - this.var_int_b * 3, 17);
                return;
            }
            case -4: {
                n.b(cm2, this.d, n2, n3 - 35 - (this.var_int_b << 2), 1, this.var_int_b < 2 ? 8 : 6);
                return;
            }
            case -5: {
                n.b(cm2, this.d, n2, n3 - 35 - (this.var_int_b << 2), 1, this.var_int_b < 2 ? 7 : 5);
                return;
            }
            case -3: {
                cm2.a(e.var_cg_arr_j[this.var_int_b < 2 ? 0 : 1], n2, n3 - 35 - this.var_int_b * 3, 17);
                return;
            }
            case -6: {
                if (this.d < 8 || this.d == 10) {
                    cm2.a(e.var_cg_arr_a[0], n2, n3 - 36, 3);
                }
                cm2.a(e.var_cg_arr_a[this.d], n2, n3 - 38 + this.var_int_b % 2, 3);
            }
        }
    }
}

