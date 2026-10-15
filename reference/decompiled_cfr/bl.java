/*
 * Decompiled with CFR 0.152.
 */
public final class bl
extends k {
    private static final byte[] var_byte_arr_a;
    byte var_byte_a;
    byte g;
    private byte h;
    private byte i;
    private byte j;
    private byte k;

    public bl(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, (byte)8, (byte)8);
        this.g = by2;
        this.var_byte_a = by3;
        this.var_byte_b = 1;
        this.i = 0;
        this.var_byte_c = (byte)2;
        this.h = 0;
        this.var_short_a = 0;
        this.void_d(am.var_byte_arr_a[this.var_byte_a]);
        if (this.f <= 0) {
            this.void_b(-1);
        }
        this.j = this.s;
        this.k = this.t;
        for (s2 = 0; s2 < 4; s2 = (short)((byte)(s2 + 1))) {
            if (!this.boolean_d(var_byte_arr_a[s2])) continue;
            this.void_c(var_byte_arr_a[s2]);
            return;
        }
    }

    private boolean boolean_d(byte by2) {
        return (am.b[this.var_byte_a] & 1 << by2) != 0;
    }

    public final void e(byte by2) {
        if (this.boolean_d(by2)) {
            this.void_c(by2);
            return;
        }
        if (by2 != 1 && this.boolean_d((byte)2)) {
            this.void_c((byte)2);
        }
    }

    public final void b(int n2, int n3) {
        if ((n2 = n2 + ((du)this).h + this.q) + 16 < 0 || n2 > bs.j + 16) {
            this.var_boolean_a = false;
            return;
        }
        if ((n3 = n3 + ((du)this).i + this.r) + 16 < 0 || n3 > bs.k + 16) {
            this.var_boolean_a = false;
            return;
        }
        this.var_boolean_a = true;
        if (!this.l) {
            return;
        }
        this.a(n2, n3, false);
        this.var_int_c = am.var_s_arr_a[this.var_byte_a].a(this.i, this.var_byte_c, this.var_int_c, n2, n3);
        this.d(n2, n3);
    }

    protected final boolean boolean_b() {
        return false;
    }

    final void void_c() {
        super.void_c();
        ++this.var_int_c;
        bl bl2 = this;
        if (bl2.l) {
            int n2;
            int n3 = n2 = !((du)bl2).j && !((du)bl2).k ? 1 : 0;
            if (bl2.var_boolean_a || bl2.var_byte_b == 2 || bl2.boolean_a()) {
                switch (bl2.var_byte_b) {
                    case 2: {
                        if (bl2.var_short_a == 0 && n2 != 0) {
                            if (bl2.boolean_a() && bl2.boolean_c()) {
                                n2 = bl2.var_int_c;
                                bl2.a(di.var_do_a, (byte)1);
                                if (bl2.var_byte_b == 2) {
                                    bl2.void_j();
                                    bl2.var_int_c = n2;
                                    break;
                                }
                                bl2.void_a(16);
                                break;
                            }
                            bl2.void_a(16);
                            break;
                        }
                        bl2.void_j();
                        break;
                    }
                    case 0: 
                    case 1: {
                        if (bl2.var_short_a != 0 || n2 == 0) break;
                        bl2.void_k();
                    }
                }
            }
        }
        this.d((int)am.var_s_arr_a[this.var_byte_a].a(this.i));
        if (this.var_short_a > 0) {
            this.var_short_a = (short)(this.var_short_a - 1);
        }
    }

    protected final void void_h() {
        this.void_a(16);
    }

    public final void f(byte by2) {
        this.h = by2;
    }

    public final byte byte_b() {
        if (this.var_byte_b == 1) {
            return this.h;
        }
        return -1;
    }

    protected final boolean boolean_e() {
        if (di.var_byte_d == 4) {
            return false;
        }
        return super.boolean_e();
    }

    protected final void u() {
        if (this.g != 1 && this.g != 47) {
            super.u();
        }
    }

    protected final void v() {
        if (this.g != 1 && this.g != 47) {
            super.v();
        }
    }

    protected final boolean boolean_a() {
        if (di.var_byte_d == 4) {
            return false;
        }
        return this.g == 1 || this.g == 47;
    }

    protected final void void_a(int n2) {
        this.var_short_a = this.boolean_a() ? (short)0 : (short)n2;
        this.void_a((byte)1);
        this.var_int_c = 0;
    }

    private boolean boolean_c() {
        int n2 = this.int_a((du)di.var_do_a);
        return n2 > 2 || !((du)di.var_do_a).j && !((du)di.var_do_a).k;
    }

    protected final void void_k() {
        if (this.var_int_a == 0) {
            if (this.boolean_a()) {
                if (this.boolean_c()) {
                    this.a(di.var_do_a, (byte)1);
                    return;
                }
            } else if (this.l && di.var_byte_d == 3) {
                if (this.s == this.j && this.t == this.k) {
                    byte by2 = am.b[this.var_byte_a];
                    byte by3 = this.var_byte_c;
                    if (by2 == 30) {
                        by3 = (byte)((al.var_java_util_Random_a.nextInt() & 0xFF) % 4 + 1);
                    } else if (by2 == 6) {
                        by3 = (byte)((al.var_java_util_Random_a.nextInt() & 0xFF) % 2 + 1);
                    } else if (by2 == 24) {
                        by3 = (byte)((al.var_java_util_Random_a.nextInt() & 0xFF) % 2 + 3);
                    }
                    this.void_a(by3, (al.var_java_util_Random_a.nextInt() & 0xFF) % 3);
                    return;
                }
                if (this.s != this.j) {
                    byte by4 = this.s > this.j ? (byte)3 : 4;
                    this.void_a(by4, Math.abs(this.s - this.j));
                    return;
                }
                if (this.t != this.k) {
                    byte by5 = this.t > this.k ? (byte)1 : 2;
                    this.void_a(by5, Math.abs(this.t - this.k));
                }
            }
        }
    }

    public final void void_a(byte by2) {
        if (by2 == 2 && this.f == 0) {
            this.void_d((byte)8);
        } else if (by2 == 1) {
            this.void_d(am.var_byte_arr_a[this.var_byte_a]);
        }
        super.void_a(by2);
        this.i = this.var_byte_b == 2 ? (byte)1 : 0;
    }

    final byte byte_a(int n2) {
        return am.var_s_arr_a[this.var_byte_a].a((byte)n2);
    }

    public final void g(byte by2) {
        this.void_a((byte)99);
        this.i = by2;
    }

    static {
        var_byte_arr_a = new byte[]{2, 3, 4, 1};
    }
}

