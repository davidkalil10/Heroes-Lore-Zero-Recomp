/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;

final class t
extends u
implements dy {
    private s var_s_a;
    private int b;
    private byte var_byte_e;
    private cd var_cd_a = null;
    private int c;
    private byte f;
    private byte g;
    private int d;
    private int var_int_e;

    t(byte by2, short s2, short s3, s s4, byte by3, boolean bl2, cd cd2, int n2, byte by4, byte by5) {
        super(by2, (byte)1, s2, s3, bl2);
        this.var_cd_a = cd2;
        this.c = n2;
        this.f = by4;
        this.g = by5;
        this.var_s_a = s4;
        this.var_byte_e = by3;
        this.b = 0;
        this.var_short_a = this.var_s_a.a(this.var_byte_e);
        di.var_g_a.a(this);
        switch (((u)this).c) {
            case 4: {
                this.g = (byte)6;
                this.d = (100 - this.h) / this.g;
                this.var_int_e = (150 - this.i) / this.g;
                return;
            }
            case 5: {
                this.g = (byte)6;
                this.d = (160 - this.h) / this.g;
                this.var_int_e = (150 - this.i) / this.g;
                return;
            }
            case 6: {
                this.g = (byte)3;
                this.d = (230 - this.h) / this.g;
                this.var_int_e = (150 - this.i) / this.g;
            }
        }
    }

    final void a() {
        if (this.var_int_a > this.var_short_a) {
            this.var_int_a = -1;
        }
        if (this.b++ >= this.var_short_a) {
            this.var_boolean_a = true;
        }
        block0 : switch (((u)this).c) {
            case 1: {
                al[] alArray = cd.al_arr_a();
                for (int i2 = 0; i2 < 2; ++i2) {
                    if (alArray[i2] == null || alArray[i2].boolean_h() || alArray[i2].s != this.s || alArray[i2].t != this.t || alArray[i2].boolean_h()) continue;
                    alArray[i2].f(50);
                    alArray[i2].c(60, 30);
                }
                if (!this.var_boolean_a) break;
                this.b = 0;
                this.var_int_a = -1;
                switch (this.var_byte_e) {
                    case 16: {
                        this.var_boolean_a = false;
                        this.var_byte_e = (byte)((al.var_java_util_Random_a.nextInt() & 1) == 0 ? 17 : 18);
                        this.var_short_a = (byte)(Math.abs(al.var_java_util_Random_a.nextInt() & 0xFF) % 8 + 35);
                        return;
                    }
                    case 19: {
                        this.var_boolean_a = true;
                        return;
                    }
                }
                this.var_boolean_a = false;
                this.var_byte_e = (byte)19;
                this.var_short_a = this.var_s_a.a(this.var_byte_e);
                return;
            }
            case 3: {
                if (this.g > 0) {
                    this.g = (byte)(this.g - 1);
                    this.var_boolean_a = false;
                    byte by2 = (byte)(this.s + rpg.d.H[this.f]);
                    byte by3 = (byte)(this.t + rpg.d.I[this.f]);
                    if (!g.boolean_a(by2, by3) && !di.var_g_a.boolean_b((int)by2, (int)by3)) {
                        this.a((short)(by2 << 4), (short)(by3 << 4));
                        this.E();
                        boolean[] blArray = new boolean[]{false, false};
                        al[] alArray = cd.al_arr_a();
                        for (int i3 = 0; i3 < 2; ++i3) {
                            for (int i4 = 0; i4 < this.u; ++i4) {
                                if (alArray[i3] == null || blArray[i3] || alArray[i3].t != this.t || alArray[i3].s != this.s + i4) continue;
                                blArray[i3] = true;
                                this.var_cd_a.b(alArray[i3], this.c, this.f);
                                this.var_boolean_a = true;
                            }
                        }
                        break;
                    }
                    this.var_boolean_a = true;
                    return;
                }
                this.var_boolean_a = true;
                return;
            }
            case 14: {
                if (this.b == 1) {
                    boolean[] blArray = new boolean[]{false, false};
                    al[] alArray = cd.al_arr_a();
                    for (int i5 = 0; i5 < 2; ++i5) {
                        for (int i6 = 0; i6 < this.u; ++i6) {
                            if (alArray[i5] == null || blArray[i5] || alArray[i5].t != this.t || alArray[i5].s != this.s + i6) continue;
                            blArray[i5] = true;
                            this.var_cd_a.b(alArray[i5], this.c, this.f);
                        }
                    }
                    return;
                }
                if (this.b != 2 || this.g <= 1) break;
                this.g = (byte)(this.g - 1);
                byte by4 = (byte)(this.s + rpg.d.H[this.f]);
                byte by5 = (byte)(this.t + rpg.d.I[this.f]);
                if (!g.boolean_a(by4, by5) && !di.var_g_a.boolean_b((int)by4, (int)by5)) {
                    new t(((u)this).c, (short)(by4 << 4), (short)(by5 << 4), this.var_s_a, this.var_byte_e, this.var_boolean_b, this.var_cd_a, this.c, this.f, this.g);
                }
                return;
            }
            case 13: {
                if (this.b != this.g) break;
                boolean[] blArray = new boolean[]{false, false};
                al[] alArray = cd.al_arr_a();
                for (int i7 = 0; i7 < 2; ++i7) {
                    for (int i8 = 0; i8 < this.u; ++i8) {
                        if (alArray[i7] == null || blArray[i7] || alArray[i7].s != this.s + i8 || alArray[i7].t != this.t) continue;
                        blArray[i7] = true;
                        this.var_cd_a.b(alArray[i7], this.c, this.f);
                    }
                }
                return;
            }
            case 9: {
                if (this.b != this.g) break;
                byte by6 = (byte)(this.s - 1);
                byte by7 = (byte)(this.s + 3);
                byte by8 = (byte)(this.t - 3);
                byte by9 = (byte)(this.t + 2);
                al[] alArray = cd.al_arr_a();
                for (int i9 = 0; i9 < 2; ++i9) {
                    if (alArray[i9] == null || alArray[i9].s < by6 || alArray[i9].s > by7 || alArray[i9].t < by8 || alArray[i9].t > by9) continue;
                    this.var_cd_a.b(alArray[i9], this.c, this.f);
                    break block0;
                }
                return;
            }
            case 4: 
            case 5: 
            case 6: {
                if (this.g > 0) {
                    this.var_boolean_a = false;
                    this.g = (byte)(this.g - 1);
                    this.h = (short)(this.h + this.d);
                    this.i = (short)(this.i + this.var_int_e);
                    this.a(this.h, this.i);
                    this.E();
                    return;
                }
                this.var_boolean_a = true;
                new t(7, this.h, (short)(this.i + 16), this.var_s_a, 8, true, this.var_cd_a, this.c, 1, 10);
                new t(7, this.h, this.i, this.var_s_a, 9, true, this.var_cd_a, this.c, 2, 10);
                return;
            }
            case 7: {
                if (this.g > 0) {
                    this.g = (byte)(this.g - 1);
                    this.var_boolean_a = false;
                    byte by10 = (byte)(this.t + rpg.d.I[this.f]);
                    if (by10 >= 0 && by10 < g.var_byte_d) {
                        this.a(this.h, (short)(by10 << 4));
                        this.E();
                        al[] alArray = cd.al_arr_a();
                        for (int i10 = 0; i10 < 2; ++i10) {
                            if (alArray[i10] == null || alArray[i10].s < this.s - 2 || alArray[i10].s >= this.s + 2 || alArray[i10].t != this.t) continue;
                            this.var_cd_a.b(alArray[i10], this.c, this.f);
                            this.var_boolean_a = true;
                            new t(0, alArray[i10].h, alArray[i10].i, this.var_s_a, 10, true, null, 0, 0, 0);
                        }
                        break;
                    }
                    this.var_boolean_a = true;
                    return;
                }
                this.var_boolean_a = true;
            }
        }
    }

    final void a(int n2, int n3) {
        switch (((u)this).c) {
            case 2: {
                n3 = n3 + this.i + this.r;
                while (n3 <= rpg.a.var_int_b) {
                    this.var_s_a.a(this.var_byte_e, (byte)1, this.var_int_a, n2 + this.h + this.q, n3 += 16);
                }
                break;
            }
            case 8: {
                n3 = n3 + this.i + this.r - 8;
                while (n3 > 0) {
                    this.var_s_a.a(this.var_byte_e, (byte)1, this.var_int_a, n2 + this.h + this.q, n3 -= 16);
                }
                break;
            }
            default: {
                this.var_s_a.a(this.var_byte_e, ((u)this).d, this.var_int_a % this.var_short_a, n2 + this.h + this.q + (this.u - 1 << 3), n3 + this.i + this.r);
            }
        }
    }
}

