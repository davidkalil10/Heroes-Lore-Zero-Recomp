/*
 * Decompiled with CFR 0.152.
 */
import java.util.Vector;
import rpg.d;
import rpg.e;

public final class h
extends cd {
    private do a = null;
    private short b = (short)-1;

    public static final void a(do al2, short s2) {
        if (di.var_h_a != null) {
            al2 = di.var_h_a;
            di.var_h_a.var_al_a = null;
            ((cd)al2).h(((cd)al2).var_int_j);
            ((h)al2).void_a((byte)8);
            ((h)al2).b = s2;
            return;
        }
        new h((do)al2, s2);
    }

    private h(do do_, short s2) {
        super(((du)do_).h, ((du)do_).i);
        this.a = do_;
        this.n = this.a.byte_a();
        this.var_int_k = this.var_int_j = this.a.int_f((byte)0);
        this.var_short_e = this.d = (short)this.a.var_int_a;
        this.var_short_g = (short)this.a.int_e((byte)1);
        this.var_short_c = (short)-1;
        this.i = 1;
        this.b = s2;
        this.var_boolean_a = true;
        this.var_al_a = null;
        this.var_s_a = rpg.e.var_ca_a;
        this.var_byte_j = (byte)3;
        this.var_byte_k = (byte)2;
        if (this.a((byte)1, (byte)4)) {
            di.var_g_a.a(this);
            di.var_h_a = this;
        }
    }

    protected final boolean a(byte by2, byte by3) {
        this.var_short_a = 0;
        if (this.boolean_a(this.a.s, this.a.t, (byte)1, (byte)4)) {
            this.void_a((byte)8);
            return true;
        }
        this.void_a((byte)7);
        return false;
    }

    public final void b(int n2, int n3) {
        n2 = n2 + ((du)this).h + this.q;
        n3 = n3 + ((du)this).i + this.r + 1;
        if (this.l > 0) {
            this.l = (byte)(this.l - 1);
            if (this.l % 2 == 0) {
                n2 += rpg.d.H[this.m] << 1;
                n3 += rpg.d.I[this.m] << 1;
            }
        }
        if (n2 < -16 || n3 < 0 || n2 > bs.j + 16 || n3 > bs.k + 32) {
            this.var_boolean_a = false;
            return;
        }
        this.var_boolean_a = true;
        this.a(n2, n3, false);
        this.var_s_a.a(this.var_byte_h, this.var_byte_h == 4 ? (byte)1 : this.var_byte_c, this.var_int_c, n2, n3);
        this.b(n2, n3, true);
        this.d(n2, n3);
    }

    protected final void void_a(byte by2) {
        if (by2 != 4) {
            super.void_a(by2);
        }
    }

    protected final void void_a() {
        switch (this.var_byte_b) {
            case 2: {
                this.var_byte_h = (byte)2;
                break;
            }
            case 3: {
                this.var_byte_h = (byte)6;
                break;
            }
            case 6: {
                this.var_byte_h = (byte)4;
                break;
            }
            case 8: {
                this.var_byte_h = (byte)16;
                break;
            }
            default: {
                this.var_byte_h = 0;
            }
        }
        this.var_int_f = this.var_s_a.a(this.var_byte_h);
    }

    public final void void_c() {
        this.b = (short)(this.b - 1);
        if (this.b < 0 && this.var_byte_b != 6 && this.var_byte_b != 7) {
            this.void_a((byte)6);
            return;
        }
        if (!this.var_boolean_a || this.byte_a((du)this.a) > 6 && this.byte_b(this.a) > 6) {
            this.var_al_a = null;
            this.v();
            if (!this.a((byte)1, (byte)8)) {
                this.b = 0;
                return;
            }
        } else {
            super.void_c();
        }
    }

    protected final void void_d() {
        if (this.boolean_j()) {
            this.void_a(0);
        }
    }

    protected final void void_b() {
        if (this.var_al_a == this.a(this.var_byte_c, this.var_al_a)) {
            this.b(this.var_al_a, (int)this.short_a(), this.var_byte_c);
        }
    }

    protected final void void_e() {
        this.void_a((int)this.var_byte_j);
    }

    protected final void void_f() {
        al al2 = null;
        Vector vector = this.java_util_Vector_a((byte)4);
        while (vector.size() > 0) {
            int n2 = (al.var_java_util_Random_a.nextInt() & 0xFF) % vector.size();
            du du2 = (du)vector.elementAt(n2);
            if (du2 instanceof cd && !(du2 instanceof h)) {
                al2 = (al)du2;
                break;
            }
            vector.removeElementAt(n2);
        }
        if (al2 != null && this.boolean_b(al2)) {
            this.var_al_a = al2;
        }
    }

    public final byte byte_a() {
        return this.a.byte_a();
    }

    public final int int_a() {
        return this.a.int_a();
    }

    public final int int_a(byte by2) {
        return this.a.int_a(by2);
    }

    public final boolean a(al al2) {
        return this.a.a(al2);
    }

    protected final boolean boolean_a(int n2) {
        return n2 == 1 || n2 == 4;
    }

    public final void void_g() {
        this.a = null;
        this.b = (short)-1;
        this.void_a((byte)7);
        di.var_h_a = null;
        di.var_g_a.d(this);
    }

    protected final void void_h() {
        if (this.var_al_a == null || this.int_a((du)this.var_al_a) > 1) {
            byte by2 = this.var_byte_c;
            for (int i2 = 0; i2 < 4; ++i2) {
                du du2 = this.a(by2, null);
                if (du2 != null && du2 instanceof cd) {
                    this.var_al_a = (al)du2;
                    this.void_c(by2);
                    this.void_a((byte)3);
                    return;
                }
                by2 = rpg.d.M[by2];
            }
        }
        super.void_h();
    }

    protected final boolean boolean_a(du du2) {
        if (du2 == null) {
            this.var_al_a = null;
            return false;
        }
        if (du2 instanceof al && ((al)du2).var_byte_b == 7) {
            this.var_al_a = null;
            return false;
        }
        if (du2 instanceof cd) {
            for (byte by2 = 1; by2 <= 4; by2 = (byte)(by2 + 1)) {
                if (this.a(by2, du2) != du2) continue;
                this.void_c(by2);
                return true;
            }
        }
        return super.boolean_a(du2);
    }

    public final int int_b() {
        return this.a.int_b();
    }

    public final short short_a() {
        int n2;
        int n3 = n2 = this.var_int_c == 4 ? this.a.int_a(true) : this.a.int_a(false);
        if (!this.a.var_boolean_b && this.var_boolean_h) {
            return (short)((n2 << 2) / 5);
        }
        return (short)n2;
    }
}

