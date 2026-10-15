/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;

public abstract class k
extends al {
    protected boolean var_boolean_a = false;
    protected short var_short_a = 0;
    protected int var_int_a = 0;

    public k(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, (byte)8, by3);
    }

    protected void void_h() {
    }

    protected void void_i() {
        this.void_a(0);
        this.var_java_util_Vector_b.removeAllElements();
        this.var_java_util_Vector_a.removeAllElements();
        if (this.var_int_a > 0) {
            this.var_int_a = 0;
        }
    }

    protected final void a(boolean bl2) {
        byte by2;
        if (this.var_int_a != 0) {
            return;
        }
        if ((al.var_java_util_Random_a.nextInt() & 0xFF) % 6 == 0) {
            this.void_a((byte)((al.var_java_util_Random_a.nextInt() & 0xFF) % 4 + 1), 0);
            return;
        }
        int n2 = 0;
        while (!di.var_g_a.a(this, by2 = (byte)((al.var_java_util_Random_a.nextInt() & 0xFF) % 4 + 1)) && ++n2 < 5) {
        }
        this.void_a(by2, (al.var_java_util_Random_a.nextInt() & 0xF) % 2 + (bl2 ? 1 + this.u : 1));
    }

    protected final void void_a(byte by2, int n2) {
        if (this.f > 0) {
            this.var_short_a = (short)(16 / this.f * n2);
        }
        this.void_c(by2);
        if (n2 > 0) {
            this.void_a((byte)2);
        }
    }

    protected void void_a(int n2) {
        this.var_short_a = (short)n2;
        this.void_a((byte)1);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected final boolean a(du du2, byte by2) {
        byte by3;
        byte by4 = this.byte_a(du2);
        byte by5 = this.byte_b(du2);
        byte by6 = by4;
        if (du2.s > this.s) {
            by6 = 0 - by4;
        }
        byte by7 = by5;
        if (du2.t > this.t) {
            by7 = 0 - by5;
        }
        byte by8 = 0;
        byte by9 = 0;
        if (by7 != 0) {
            byte by10 = by8 = by7 > 0 ? (byte)1 : 2;
        }
        if (by6 != 0) {
            by9 = by6 > 0 ? (byte)3 : 4;
        }
        by6 = 0;
        if (by4 < by5) {
            by7 = by8;
            by3 = by9;
        } else {
            by7 = by9;
            by3 = by8;
        }
        g g2 = di.var_g_a;
        if (by4 + by5 <= by2) {
            if (by2 > 1 && by4 != by5 && by4 * by5 != 0) {
                if (g2.a(this, by3)) {
                    this.void_a(by3, 1);
                    return true;
                }
                if (!g2.a(this, by7)) return false;
                this.void_a(by7, 1);
                return true;
            }
            this.void_c(by7);
            if (by4 != by5) return false;
            this.var_byte_d = (byte)((by8 << 1) + by9);
            return false;
        }
        if (this.var_int_a != 0) return false;
        by8 = 0;
        by9 = g2.a(this, this.var_byte_c) ? 1 : 0;
        if ((this.var_byte_c == by7 || this.var_byte_c == by3) && this.var_byte_c != 0 && by9 != 0) {
            by8 = 1;
            by6 = this.var_byte_c;
        } else if (by3 != 0 && rpg.d.N[this.var_byte_c] != by3 && g2.a(this, by3)) {
            by8 = 1;
            by6 = by3;
        } else if (by7 != 0 && rpg.d.N[this.var_byte_c] != by7 && g2.a(this, by7)) {
            by8 = 1;
            by6 = by7;
        } else {
            if (this.boolean_c(by7)) {
                this.var_short_a = (short)(16 / this.f << 1);
                return true;
            }
            if (this.boolean_c(by3)) {
                this.var_short_a = (short)(16 / this.f << 1);
                return true;
            }
        }
        if (by8 != 0) {
            if (this instanceof bl && ((bl)this).boolean_a()) {
                this.void_a(by6, by6 == 3 || by6 == 4 ? by4 - (by2 - 1) : by5 - (by2 - 1));
                return by8 != 0;
            } else {
                this.void_a(by6, 1);
            }
            return by8 != 0;
        } else {
            this.a(true);
        }
        return by8 != 0;
    }

    protected final void void_j() {
        if (this.var_short_a > 0) {
            this.w();
        }
        this.boolean_d();
    }

    protected void void_k() {
        this.a(false);
    }

    public final void void_b(int n2) {
        this.var_int_a = n2;
    }

    protected boolean boolean_b() {
        return this.var_byte_b == 7 || this.var_byte_b == 6;
    }

    protected void a(int n2, int n3, boolean bl2) {
        if (this.boolean_b()) {
            return;
        }
        cm cm2 = rpg.a.var_cm_a;
        if (this.u == 1) {
            cm2.a(rpg.e.var_cg_arr_e[bl2 ? 1 : 0], n2, n3 + 6, 33);
            return;
        }
        cm2.a(rpg.e.var_cg_arr_e[bl2 ? 1 : 0], n2 - 2, n3 + 6, 33);
        cm2.a(rpg.e.var_cg_arr_e[bl2 ? 1 : 0], n2 + 2, n3 + 6, 33);
    }
}

