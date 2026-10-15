/*
 * Decompiled with CFR 0.152.
 */
import rpg.d;
import rpg.e;

final class av
extends af {
    private byte[] O = null;
    private byte[] P = null;
    public static av var_av_a;
    public static bi[] var_bi_arr_a;
    private byte g;
    private byte o;
    private boolean i = false;
    private final byte[] Q = new byte[]{-22, 24, 35, 24};
    private final byte[] R = new byte[]{-30, 9, 50, 9};
    private byte[] S = new byte[]{-2, 4, 1, 3};
    private byte[] T = new byte[]{6, 12, 8, 13};

    public av(short s2, short s3, short s4, byte by2) {
        super((short)135, (short)100, s4, by2, dt.var_dt_arr_a[by2].var_s_a);
        this.O = rpg.e.a(af.var_byte_arr_a, 12);
        this.P = rpg.e.a(af.var_byte_arr_a, 14);
        this.var_byte_arr_b = rpg.e.a(af.var_byte_arr_a, 15);
        this.var_byte_arr_c = rpg.e.a(af.var_byte_arr_a, 16);
        this.var_byte_arr_d = rpg.e.a(af.var_byte_arr_a, 17);
        this.a(this.O);
        this.var_int_b = -1;
        var_av_a = this;
        this.void_c((byte)1);
        this.void_a((byte)1);
    }

    protected final void void_a() {
        this.var_byte_h = this.var_byte_b == 3 ? this.P[this.var_byte_a] : (byte)0;
        this.var_int_f = this.var_s_a.a(this.var_byte_h);
    }

    protected final void void_a(int n2, int n3) {
        this.var_s_a.a(this.var_byte_h, (byte)1, this.var_int_c, n2, n3);
    }

    protected final void void_k() {
        if (this.var_short_a <= 0 && !this.var_boolean_f) {
            av av2 = this;
            this.var_int_b = (av2.var_int_b + 1) % av2.var_byte_arr_b.length;
            av2.var_byte_a = av2.var_byte_arr_b[av2.var_int_b];
            if (av2.var_byte_a == 4 && !av2.i) {
                av2.var_int_b = (av2.var_int_b + 1) % av2.var_byte_arr_b.length;
                av2.var_byte_a = av2.var_byte_arr_b[av2.var_int_b];
            }
            switch (av2.var_byte_a) {
                case 3: {
                    av2.i = false;
                }
            }
            av2.void_a((byte)3);
            this.void_a((byte)3);
        }
    }

    private final boolean boolean_l() {
        return this.var_byte_h == 7;
    }

    public final boolean a(do do_, byte by2, int n2, boolean bl2, byte by3, byte by4, boolean bl3, boolean bl4, boolean bl5) {
        if (!this.boolean_l()) {
            return super.a(do_, by2, -90, bl2, by3, by4, bl3, bl4, bl5);
        }
        return super.a(do_, by2, n2, bl2, by3, by4, bl3, bl4, bl5);
    }

    public final boolean a(int n2, byte by2) {
        if (!this.boolean_l()) {
            return super.a(-90, by2);
        }
        return super.a(n2, by2);
    }

    protected final boolean a(al al2, int n2, byte by2) {
        if (!this.boolean_l()) {
            return super.a(al2, -90, by2);
        }
        return super.a(al2, n2, by2);
    }

    protected final boolean boolean_a(int n2) {
        switch (this.var_byte_a) {
            case 0: 
            case 1: {
                if (n2 == 6) {
                    di.var_g_a.void_c(1, 1);
                    if (this.var_byte_a == 0) {
                        new t(0, (short)(((du)this).h + this.Q[0]), (short)(((du)this).i + this.Q[1]), this.var_s_a, 11, false, var_bi_arr_a[0], this.short_a(), 2, 1);
                        break;
                    }
                    new t(0, (short)(((du)this).h + this.Q[2]), (short)(((du)this).i + this.Q[3]), this.var_s_a, 11, false, var_bi_arr_a[1], this.short_a(), 2, 1);
                    break;
                }
                if (n2 != 7) break;
                di.var_g_a.void_c(1, 2);
                break;
            }
            case 2: {
                if (n2 == 6) {
                    di.var_g_a.void_c(2, 2);
                    new t(0, (short)(((du)this).h + this.Q[0]), (short)(((du)this).i + this.Q[1]), this.var_s_a, 11, false, var_bi_arr_a[0], this.short_a(), 2, 1);
                    new t(0, (short)(((du)this).h + this.Q[2]), (short)(((du)this).i + this.Q[3]), this.var_s_a, 12, false, var_bi_arr_a[1], this.short_a(), 2, 1);
                    break;
                }
                if (n2 == 7) {
                    di.var_g_a.void_c(2, 1);
                    break;
                }
                if (n2 == 8) {
                    di.var_g_a.void_c(1, 2);
                    break;
                }
                if (n2 != 9) break;
                di.var_g_a.void_c(1, 1);
                break;
            }
            case 3: {
                if (this.i || n2 <= 2) break;
                do do_ = this.var_do_a;
                if (((du)do_).j || ((du)do_).k) break;
                new t(0, (short)(((du)this).h + this.R[0]), (short)(((du)this).i + this.R[1]), this.var_s_a, 13, false, var_bi_arr_a[0], this.short_a(), 2, 1);
                new t(0, (short)(((du)this).h + this.R[2]), (short)(((du)this).i + this.R[3]), this.var_s_a, 13, false, var_bi_arr_a[1], this.short_a(), 2, 1);
                this.i = true;
                this.g = do_.s;
                this.o = do_.t;
                for (int n3 = 1; n3 <= 4; n3 = (int)((byte)(n3 + 1))) {
                    this.a((byte)(this.g + rpg.d.H[n3]), (byte)(this.o + rpg.d.I[n3]), false);
                }
                break;
            }
            case 4: {
                if (n2 == 5) {
                    new t(0, (short)(this.g << 4), (short)(this.o << 4), this.var_s_a, 16, false, this, this.short_a(), 2, 1);
                    break;
                }
                if (n2 != 7) break;
                new t(8, (short)(this.g << 4), (short)(this.o << 4), this.var_s_a, 17, false, this, this.short_a(), 2, 1);
                break;
            }
            case 5: {
                if (n2 <= 3 || n2 % 2 != 0) break;
                new t(13, ((du)this.var_do_a).h, ((du)this.var_do_a).i, this.var_s_a, 15, true, this, this.short_a(), 0, 6);
                break;
            }
            case 6: {
                if (n2 != 7) break;
                new t(9, (short)(((du)this).h + 8), (short)(this.t + 4 << 4), this.var_s_a, 14, true, this, this.short_a(), 0, 15);
            }
        }
        return n2 == this.var_byte_arr_d[this.var_byte_a];
    }

    protected final void void_b() {
        al[] alArray = cd.al_arr_a();
        switch (this.var_byte_a) {
            case 0: 
            case 1: {
                int n2 = (al.var_java_util_Random_a.nextInt() & 0xFF) % (this.T[1] - this.T[0] + 1) + this.T[0];
                int n3 = (al.var_java_util_Random_a.nextInt() & 0xFF) % (this.T[3] - this.T[2] + 1) + this.T[2];
                if (g.boolean_a(n2, n3)) break;
                this.a((byte)n2, (byte)n3, true);
                return;
            }
            case 2: {
                for (int i2 = 0; i2 < 2; ++i2) {
                    if (alArray[i2] == null) continue;
                    al al2 = alArray[i2];
                    av av2 = this;
                    if (!(al2.s >= av2.s + av2.S[0] && al2.s <= av2.s + av2.S[1] && al2.t >= av2.t + av2.S[2] && al2.t <= av2.t + av2.S[3])) continue;
                    this.b(alArray[i2], (int)this.short_a(), (byte)2);
                }
                return;
            }
            case 4: {
                for (int i3 = 0; i3 < 2; ++i3) {
                    if (alArray[i3] == null || this.g != alArray[i3].s || this.o != alArray[i3].t) continue;
                    this.b(alArray[i3], (int)this.short_a(), (byte)2);
                }
                g g2 = di.var_g_a;
                for (int n4 = 1; n4 <= 4; n4 = (int)((byte)(n4 + 1))) {
                    du du2 = g2.du_a((int)((byte)(this.g + rpg.d.H[n4])), (int)((byte)(this.o + rpg.d.I[n4])));
                    if (du2 == null || !(du2 instanceof co)) continue;
                    ((co)du2).void_a((byte)6);
                }
                break;
            }
        }
    }

    protected final void void_m() {
        di.var_g_a.d(this);
        this.b(this.O);
        var_bi_arr_a[0].void_m();
        var_bi_arr_a[1].void_m();
        var_bi_arr_a = null;
    }

    public static final void a(bi bi2) {
        if (var_bi_arr_a == null) {
            var_bi_arr_a = new bi[2];
        }
        av.var_bi_arr_a[av.var_bi_arr_a[0] == null ? 0 : 1] = bi2;
        if (var_bi_arr_a[0] != null && var_bi_arr_a[1] != null && av.var_bi_arr_a[0].s > av.var_bi_arr_a[1].s) {
            av.var_bi_arr_a[1] = var_bi_arr_a[0];
            av.var_bi_arr_a[0] = bi2;
        }
    }

    private final void a(byte by2, byte by3, boolean bl2) {
        al[] alArray = cd.al_arr_a();
        for (int i2 = 0; i2 < 2; ++i2) {
            if (alArray[i2] == null || alArray[i2].s != by2 || alArray[i2].t != by3) continue;
            alArray[i2].void_b((byte)2);
        }
        new co((short)(by2 << 4), (short)(by3 << 4), bl2);
    }

    static {
        var_av_a = null;
        var_bi_arr_a = null;
    }
}

