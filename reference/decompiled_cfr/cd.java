/*
 * Decompiled with CFR 0.152.
 */
import java.util.Vector;
import rpg.c;
import rpg.d;

public class cd
extends k
implements dy {
    public short var_short_c;
    protected dt var_dt_a = null;
    protected s var_s_a = null;
    protected byte var_byte_h;
    protected int var_int_f;
    private static Vector var_java_util_Vector_c;
    private short var_short_b = 0;
    protected al var_al_a = null;
    protected byte i;
    private byte var_byte_a;
    protected byte var_byte_j;
    protected byte var_byte_k;
    protected byte l = 0;
    protected byte m = 0;
    private short var_short_j = this.s;
    private short var_short_k = this.t;
    protected byte n;
    protected int var_int_j;
    protected int var_int_k;
    protected short d;
    protected short var_short_e;
    protected short var_short_f;
    protected short var_short_g;
    protected boolean var_boolean_f = false;
    private boolean var_boolean_b = false;
    protected boolean var_boolean_g = false;
    protected boolean var_boolean_h = false;
    private int var_int_b = 0;
    private byte var_byte_g = 0;
    private int var_int_e = 0;
    private byte[] var_byte_arr_a;

    public static final void void_a(short s2, short s3, byte by2, byte by3) {
        short s4 = by2;
        by2 = (byte)s4;
        if (s4 < 0) {
            by2 = (byte)(by2 + 256);
        }
        switch (by2) {
            case 100: 
            case 123: {
                ck.a = by3;
                ck.var_short_b = by2;
                return;
            }
            case 99: 
            case 122: {
                new v(s2, s3, (short)by2, by3);
                return;
            }
            case 101: 
            case 124: {
                new cs(149, 52, (short)by2, by3);
                return;
            }
            case 102: 
            case 125: {
                new cq(100, 85, (short)by2, by3);
                return;
            }
            case 103: 
            case 126: {
                new cq(148, 70, (short)by2, by3);
                return;
            }
            case 104: 
            case 127: {
                new cq(198, 81, (short)by2, by3);
                return;
            }
            case 105: 
            case 128: {
                new an(1, 1, (short)by2, by3);
                return;
            }
            case 106: 
            case 129: {
                new by(168, 56, (short)by2, by3);
                return;
            }
            case 107: 
            case 130: {
                new by(216, 72, (short)by2, by3);
                return;
            }
            case 108: 
            case 131: {
                new by(248, 120, (short)by2, by3);
                return;
            }
            case 119: {
                new av(135, 100, (short)by2, by3);
                return;
            }
            case 120: {
                new bi(s2, s3, (short)by2, by3);
                return;
            }
            case 121: {
                co.a = by3;
                co.var_short_b = by2;
                return;
            }
            case 109: 
            case 111: 
            case 113: {
                new ap(s2, s3, (short)by2, by3);
                return;
            }
            case 110: 
            case 112: 
            case 114: {
                new cw(s2, s3, (short)by2, by3);
                return;
            }
            case 115: {
                new bc(s2, s3, (short)by2, by3);
                return;
            }
            case 116: {
                bc.b = by2;
                bc.g = by3;
                return;
            }
            case 117: 
            case 118: {
                new e(s2, s3, (short)by2, by3);
                return;
            }
        }
        if (dt.var_dt_arr_a[by3].var_byte_a == 4) {
            new ag(s2, s3, (short)by2, by3);
            return;
        }
        if (dt.var_dt_arr_a[by3].var_byte_a == 5) {
            new ci(s2, s3, (short)by2, by3);
            return;
        }
        new cd(s2, s3, by2, by3, dt.var_dt_arr_a[by3].var_s_a, false);
    }

    protected cd(short s2, short s3) {
        super(s2, s3, (byte)8, (byte)7);
        this.void_c((byte)2);
    }

    protected cd(short s2, short s3, short s4, byte by2, s s5, boolean bl2) {
        this(s2, s3);
        this.var_short_c = s4;
        this.var_dt_a = dt.var_dt_arr_a[by2];
        this.var_s_a = s5;
        this.i = this.var_dt_a.j;
        this.var_byte_a = this.var_dt_a.g;
        this.var_byte_j = this.var_dt_a.var_byte_c;
        this.var_byte_k = this.var_dt_a.var_byte_b;
        this.u = (byte)(this.var_dt_a.var_byte_e + 1);
        this.void_d(this.var_dt_a.i);
        if (((al)this).f <= 0) {
            this.void_b(-1);
        }
        if (bl2) {
            this.a((byte)0, this.var_dt_a == null || this.var_dt_a.var_boolean_d ? (byte)8 : 0);
            this.void_i();
            return;
        }
        this.var_short_b = 0;
        cd.a(this);
    }

    protected void void_a(byte by2) {
        super.void_a(by2);
        if (this.var_byte_b == 7 && this.var_short_c != -1) {
            di.c(this.var_short_c, this.var_dt_a != null ? this.var_dt_a.var_byte_f : (byte)-1);
        } else if (this.var_byte_b == 6) {
            this.boolean_i();
        }
        this.void_a();
    }

    protected void void_i() {
        cd cd2;
        int n2;
        super.void_i();
        if (this.var_dt_a != null && this.var_dt_a.var_boolean_a) {
            n2 = 0;
            cd2 = this;
            ((du)this).l = n2;
        }
        this.p();
        cd2 = this;
        n2 = di.var_byte_h > 2 ? 2 : (int)di.var_byte_h;
        if (n2 != 0) {
            byte by2 = cd2.n;
            cd2.n = (byte)((n2 + 1) * by2 / 5 + (n2 == 1 ? 40 : 60));
            cd2.d = (short)(cd2.d * cd2.n / by2);
            cd2.var_short_e = (short)(cd2.var_short_e * cd2.n / by2);
            cd2.var_int_k = cd2.var_int_j = (cd2.var_int_j - 70) * (cd2.n + (n2 == 1 ? 20 : 40)) / by2;
            cd2.var_short_f = (short)((cd2.var_short_f - 13) * cd2.n / by2 + (n2 == 1 ? 20 : 40));
            cd2.var_short_g = (short)((cd2.var_short_g - 10) * cd2.n / by2);
        }
        this.q();
        this.var_al_a = null;
        this.var_byte_arr_a = null;
        this.var_int_e = 0;
        this.var_boolean_b = false;
        this.var_boolean_g = false;
        this.var_boolean_f = false;
        this.var_byte_g = 0;
        this.var_int_b = 0;
        this.var_boolean_h = false;
    }

    protected void p() {
        this.n = this.var_dt_a.var_byte_d;
        short s2 = this.var_dt_a.var_short_d;
        this.var_int_j = s2;
        this.var_int_k = s2;
        this.d = this.var_dt_a.var_short_b;
        this.var_short_e = this.var_dt_a.var_short_c;
        this.var_short_f = this.var_dt_a.var_short_e;
        this.var_short_g = this.var_dt_a.var_short_f;
    }

    protected void q() {
        int n2 = (al.var_java_util_Random_a.nextInt() & 0xFF) % 3;
        this.n = (byte)(this.n + n2);
        this.var_int_j += n2 * 20;
        this.var_int_k = this.var_int_j;
        this.var_short_f = (short)(this.var_short_f + n2 * 3);
    }

    protected int int_c() {
        return this.var_int_k;
    }

    protected int int_d() {
        return this.var_int_j;
    }

    public void b(int n2, int n3) {
        n2 = n2 + ((du)this).h + this.q + (this.u - 1 << 3);
        n3 = n3 + ((du)this).i + this.r + 1;
        if (this.l > 0) {
            this.l = (byte)(this.l - 1);
            n2 += rpg.d.H[this.m] * dy.e[this.l];
            n3 += rpg.d.I[this.m] * dy.e[this.l];
        }
        if (n2 < -16 || n3 < 0 || n2 > bs.j + 16 || n3 > bs.k + 32) {
            this.b(n2, n3 - (this.var_dt_a != null ? (int)this.var_dt_a.h : 0), true);
            this.d(n2, n3);
            this.var_boolean_a = false;
            if (!this.boolean_c()) {
                return;
            }
        }
        this.var_boolean_a = true;
        if (!((du)this).l && !this.boolean_c()) {
            return;
        }
        this.a(n2, n3, this.var_boolean_f);
        n3 = this.int_a(n3);
        this.void_a(n2, n3);
        this.b(n2, n3, true);
        this.d(n2, n3);
    }

    protected int int_a(int n2) {
        if (this.var_boolean_f) {
            if (this.var_int_e >= this.var_byte_arr_a.length) {
                cd cd2 = this;
                this.var_boolean_f = false;
                cd2.var_int_e = 0;
                cd2.var_byte_arr_a = null;
                cd2.boolean_a();
            } else {
                n2 -= this.var_byte_arr_a[this.var_int_e];
                ++this.var_int_e;
            }
        }
        return n2;
    }

    protected boolean boolean_c() {
        return false;
    }

    protected void void_a(int n2, int n3) {
        switch (this.var_byte_b) {
            case 6: {
                rpg.e.var_s_a.a((byte)0, (byte)1, this.var_int_c, n2, n3);
                return;
            }
        }
        this.var_s_a.a(this.var_byte_h, this.var_byte_c, this.var_int_c, n2, n3);
    }

    protected void void_a() {
        int n2;
        cd cd2;
        if (this.var_s_a == null) {
            cd2 = this;
            n2 = 0;
        } else {
            switch (this.var_byte_b) {
                case 0: 
                case 1: 
                case 5: {
                    this.var_byte_h = 0;
                    break;
                }
                case 2: {
                    this.var_byte_h = 1;
                    break;
                }
                case 3: {
                    this.var_byte_h = (byte)2;
                    break;
                }
                case 4: {
                    this.var_byte_h = (byte)3;
                    break;
                }
                case 6: {
                    this.var_byte_h = 0;
                    break;
                }
                default: {
                    this.var_int_f = 0;
                }
            }
            cd2 = this;
            n2 = this.var_byte_b == 6 ? (int)rpg.e.var_s_a.a(this.var_byte_h) : (int)this.var_s_a.a(this.var_byte_h);
        }
        cd2.var_int_f = n2;
    }

    void void_c() {
        super.void_c();
        ++this.var_int_c;
        this.t();
        this.void_l();
        if (this.var_int_c < 0) {
            this.var_int_c = 0;
        }
        this.d(this.var_int_f);
        if (this.var_short_a > 0) {
            this.var_short_a = (short)(this.var_short_a - 1);
        }
        if (this.var_int_a > 0) {
            --this.var_int_a;
        }
    }

    protected void void_h() {
        if (this.var_short_a > 0 && this.boolean_f()) {
            this.boolean_d();
            return;
        }
        this.void_a(this.var_byte_k + this.var_byte_g);
    }

    private static void a(cd cd2) {
        cd2.s();
        var_java_util_Vector_c.addElement(cd2);
    }

    public static final void B() {
        var_java_util_Vector_c.removeAllElements();
    }

    public static final void C() {
        for (int i2 = var_java_util_Vector_c.size() - 1; i2 >= 0; --i2) {
            cd cd2 = (cd)var_java_util_Vector_c.elementAt(i2);
            if (cd2.var_short_b == 0) {
                if (cd2.a((byte)0, cd2.var_dt_a == null || cd2.var_dt_a.var_boolean_d ? (byte)8 : 0)) {
                    cd2.void_i();
                    var_java_util_Vector_c.removeElementAt(i2);
                    continue;
                }
                cd2.var_short_b = (short)10;
                continue;
            }
            if (cd2.var_short_b <= 0) continue;
            cd2.var_short_b = (short)(cd2.var_short_b - 1);
        }
    }

    protected boolean a(byte by2, byte by3) {
        if (this.boolean_a(this.var_short_j, this.var_short_k, by2, by3)) {
            di.var_g_a.a(this);
            return true;
        }
        return false;
    }

    protected void o() {
        byte by2;
        if (this.var_short_c == 0) {
            return;
        }
        byte[] byArray = this.var_dt_a.var_byte_arr_b;
        byte by3 = this.byte_a();
        int n2 = Math.abs(al.var_java_util_Random_a.nextInt()) % 65535;
        if (n2 < 52428) {
            di.var_g_a.a(this.byte_b(), this.t, by3 * 6 + 20 >> 1);
        }
        for (int i2 = 0; i2 < 4; ++i2) {
            by2 = -1;
            byte by4 = -1;
            int n3 = rpg.g.int_a(byArray, i2 * 6 + 2);
            if (n2 >= n3) continue;
            switch (i2) {
                case 0: 
                case 1: {
                    by4 = (byte)rpg.g.a(al.var_java_util_Random_a, byArray[i2 * 6], (int)byArray[i2 * 6 + 1]);
                    by2 = (byte)Math.min(by3 / 4, 14);
                    break;
                }
                case 2: {
                    if (by3 <= 13) {
                        by2 = -1;
                        by4 = -1;
                        break;
                    }
                    by4 = (byte)rpg.g.a(al.var_java_util_Random_a, byArray[i2 * 6], (int)byArray[i2 * 6 + 1]);
                    by2 = (byte)Math.min(by3 / 5 + 13, 28);
                    break;
                }
                case 3: {
                    by4 = byArray[i2 * 6];
                    by2 = byArray[i2 * 6 + 1];
                }
            }
            if (by4 == -1 || by2 == -1) continue;
            di.var_g_a.a(this.byte_b(), this.t, by4, by2);
            return;
        }
        if (n2 < 14500) {
            return;
        }
        if (n2 < 20000) {
            by2 = by3 < 20 ? (byte)2 : 6;
            di.var_g_a.a(this.byte_b(), this.t, (byte)20, by2);
            return;
        }
        if (n2 < 25000 && this.var_short_c < 81) {
            by2 = (byte)Math.min(6 * this.var_short_c / 40, 11);
            di.var_g_a.a(this.byte_b(), this.t, (byte)16, by2);
            return;
        }
        if (n2 < 35000) {
            int cfr_ignored_0 = n2 - (n2 / 2 << 1);
            by2 = false ? (byte)1 : 0;
            di.var_g_a.a(this.byte_b(), this.t, (byte)20, by2);
            return;
        }
        if (n2 < 36500) {
            by2 = (byte)Math.min(3 * this.var_short_c / 10, 27);
            di.var_g_a.a(this.byte_b(), this.t, (byte)18, by2);
            return;
        }
        if (n2 < 38000) {
            byte by5 = (byte)Math.min(this.var_short_c / 6, 15);
            by2 = by5;
            if (by5 > by3 / 5) {
                by2 = (byte)Math.min(by3 / 5, 15);
            }
            di.var_g_a.a(this.byte_b(), this.t, (byte)17, by2);
            return;
        }
    }

    private final byte byte_b() {
        if (this.u == 1) {
            return this.s;
        }
        return (byte)(this.s + (al.var_java_util_Random_a.nextInt() & 1));
    }

    protected void void_l() {
        boolean bl2;
        boolean bl3 = bl2 = !((du)this).j && !((du)this).k;
        if (this.var_byte_b == 6) {
            this.y();
            return;
        }
        if (!this.var_boolean_a && !this.boolean_c()) {
            this.var_al_a = null;
            return;
        }
        switch (this.var_byte_b) {
            case 0: 
            case 1: {
                if (this.var_boolean_g || !bl2 && this.var_int_a != -1) break;
                this.void_k();
                return;
            }
            case 2: {
                if (this.var_int_a != 0 && bl2) {
                    this.void_a(this.var_byte_k + this.var_byte_g);
                    return;
                }
                if (bl2 && this.var_boolean_g) {
                    this.void_a(this.var_byte_k + this.var_byte_g);
                    return;
                }
                if (this.var_short_a == 0 && bl2) {
                    this.void_h();
                    return;
                }
                this.void_j();
                return;
            }
            case 3: {
                if (this.boolean_a(this.var_int_c)) {
                    this.void_b();
                }
                if (!this.boolean_j()) break;
                this.void_e();
                return;
            }
            case 4: {
                if (!this.boolean_j()) break;
                this.void_a((byte)1);
                return;
            }
            case 8: {
                this.void_d();
            }
        }
    }

    protected final boolean boolean_j() {
        return this.var_int_f - this.var_int_c <= 0;
    }

    protected void void_k() {
        if (this.var_short_a <= 0 && !this.var_boolean_f && di.var_byte_d == 3) {
            if (this.var_al_a == null || this.var_al_a.var_byte_b == 6 || this.var_al_a.var_byte_b == 7) {
                this.void_f();
            }
            if (this.var_al_a == null) {
                if (this.var_int_a == 0) {
                    this.a(false);
                    return;
                }
            } else if (!this.a((du)this.var_al_a, this.i)) {
                if (this.boolean_a((du)this.var_al_a)) {
                    this.void_a((byte)3);
                    return;
                }
                this.var_al_a = null;
            }
        }
    }

    protected void void_b() {
        switch (this.var_dt_a.var_byte_a) {
            case 0: {
                if (this.i == 1) {
                    if (this.var_al_a == di.var_do_a || this.var_al_a == di.var_h_a) {
                        if (di.var_do_a == this.a(this.var_byte_c, di.var_do_a)) {
                            this.b(di.var_do_a, (int)this.short_a(), this.var_byte_c);
                        }
                        if (di.var_h_a == null || di.var_h_a != this.a(this.var_byte_c, di.var_h_a)) break;
                        this.b(di.var_h_a, (int)this.short_a(), this.var_byte_c);
                        return;
                    }
                    if (this.var_al_a != this.a(this.var_byte_c, this.var_al_a)) break;
                    this.b(this.var_al_a, (int)this.short_a(), this.var_byte_c);
                    return;
                }
                if (this.i <= 1 || !this.boolean_a((du)this.var_al_a)) break;
                this.b(this.var_al_a, (int)this.short_a(), this.var_byte_c);
                return;
            }
            case 1: {
                new t(3, ((du)this).h, ((du)this).i, this.var_s_a, 4, false, this, this.short_a(), this.var_byte_d, this.i);
                return;
            }
            case 2: {
                int n2 = this.s + rpg.d.H[this.var_byte_d];
                int n3 = this.t + rpg.d.I[this.var_byte_d];
                if (g.boolean_a(n2, n3)) break;
                new t(14, (short)(n2 << 4), (short)(n3 << 4), this.var_s_a, 4, false, this, this.short_a(), this.var_byte_d, this.i);
                return;
            }
            case 3: {
                if (!this.boolean_a((du)this.var_al_a)) break;
                new t(13, this.var_al_a.h, this.var_al_a.i, this.var_s_a, 4, true, this, this.short_a(), this.var_byte_d, 1);
            }
        }
    }

    protected void void_e() {
        this.var_al_a = null;
        this.void_a((int)this.var_byte_j);
    }

    protected void void_d() {
    }

    public void void_g() {
        this.void_a((byte)7);
        short s2 = this.var_dt_a.var_short_a;
        cd cd2 = this;
        this.var_short_b = s2;
        this.o();
        this.n();
        this.void_m();
        if (this.var_short_b > 0) {
            cd.a(this);
        }
    }

    protected void void_m() {
        this.var_al_a = null;
        di.var_g_a.d(this);
    }

    protected final void a(short s2) {
        this.var_short_b = s2;
    }

    protected void y() {
        if (this.boolean_j()) {
            this.void_g();
        }
    }

    protected void n() {
        if (this.var_short_c >= 81 && this.var_short_c <= 97) {
            di.var_do_a.j(100);
            return;
        }
        int n2 = 20 + this.byte_a() - di.var_do_a.byte_a();
        if (n2 < 0) {
            n2 = 0;
        } else if (n2 > 30) {
            n2 = 30;
        }
        di.var_do_a.j(18 * this.byte_a() * n2 / 20);
    }

    protected void void_f() {
        al al2 = di.var_h_a;
        if (al2 != null && this.boolean_b(al2)) {
            this.var_al_a = al2;
            return;
        }
        al2 = di.var_do_a;
        if (al2 != null && this.boolean_b(al2)) {
            this.var_al_a = al2;
        }
    }

    protected boolean boolean_a(du du2) {
        if (du2 == null) {
            return false;
        }
        if (du2 instanceof al && ((al)du2).var_byte_b == 7) {
            this.var_al_a = null;
            return false;
        }
        int n2 = this.int_a(du2);
        return n2 <= this.i;
    }

    protected final boolean boolean_b(du du2) {
        return this.byte_a(du2) <= 5 && this.byte_b(du2) <= 5;
    }

    protected boolean boolean_a(int n2) {
        return n2 == this.var_byte_a;
    }

    public boolean a(al al2) {
        int n2;
        if (di.var_byte_d != 3) {
            return false;
        }
        int n3 = 90 + this.byte_a() - al2.byte_a() - al2.int_a();
        if (n3 < 15) {
            n3 = 15;
        }
        return (n2 = (al.var_java_util_Random_a.nextInt() & 0xFF) % 100) < n3;
    }

    protected void a(al al2, int n2, byte by2, byte by3) {
        if (al2 != null && (this.var_al_a == null || al2 instanceof h)) {
            this.var_al_a = al2;
        }
        if (by3 >= 11) {
            this.a(new ak(by3, by2));
        } else {
            this.a(new bu(by3));
        }
        if (n2 <= 0) {
            n2 = 5;
        }
        this.a(new z(-5, 0, n2));
        this.a(al2, n2);
        if (!this.boolean_a()) {
            this.l = (byte)2;
            this.m = by2;
            if (this.var_byte_b == 1 || this.var_byte_b == 0) {
                this.void_a((byte)4);
            }
        }
    }

    public boolean a(do al2, byte by2, int n2, boolean bl2, byte by3, byte by4, boolean bl3, boolean bl4, boolean bl5) {
        boolean bl6;
        if (this.boolean_b()) {
            return false;
        }
        bs.a(this, false);
        ((du)this).l = true;
        boolean bl7 = bl6 = n2 == -100;
        if (n2 == -2 || !bl6 && bl4 && !al2.a(this)) {
            this.D();
            return false;
        }
        if (n2 == -90) {
            this.a(new z(-3));
            return false;
        }
        if (n2 <= 0) {
            n2 = al2.int_c(bl3);
        }
        n2 = cd.int_a(n2, al2.int_b(this.int_b()));
        if (al2.var_int_f > 0 && al2.o_a().a(this)) {
            if (by2 < 4) {
                do.var_byte_h = (byte)3;
            }
            this.a(al2, this.var_int_k, by3, by4);
            al2.q(n2);
            return true;
        }
        if (bl6 || rpg.g.a(0, 99) < al2.a(this.byte_a(), bl3)) {
            n2 += al2.int_a(n2);
            if (by4 == 2 || by4 == 4) {
                by4 = (byte)(by4 - 1);
            }
            if (!bl5) {
                byte[] byArray = new byte[]{7, 1};
                di.var_g_a.a(new dq(false, 0xFFFFFF, byArray, this.s << 4, this.t << 4));
            }
            rpg.c.k();
            g.g();
            if (by2 < 4 && di.var_byte_b != 3) {
                do.var_byte_h = (byte)10;
            }
        } else if (di.var_byte_b == 0) {
            g.g();
        }
        this.a(al2, n2, by3, by4);
        al2.q(n2);
        by2 = al2.byte_c();
        al2 = this;
        if (by2 > 0) {
            ((cd)al2).var_byte_g = by2;
        }
        if (bl2) {
            this.void_b(by3);
        }
        return true;
    }

    public final void D() {
        this.a(new z(-2));
    }

    public boolean a(int n2, byte by2) {
        if (this.boolean_b()) {
            return false;
        }
        ((du)this).l = true;
        if (n2 == -90) {
            this.a(new z(-3));
            return false;
        }
        o o2 = di.var_do_a.o_a();
        if (o2.boolean_b()) {
            n2 = n2 * 3 >> 1;
        }
        cd cd2 = this;
        this.a(di.var_do_a, cd.int_a(n2, cd2.var_boolean_h ? (cd2.var_short_e << 2) / 5 : cd2.var_short_e), by2, (byte)3);
        return true;
    }

    public final boolean boolean_b(int n2) {
        this.a(n2, rpg.d.N[this.var_byte_c]);
        return true;
    }

    protected final boolean b(al al2, int n2, byte by2) {
        boolean bl2 = !this.a(al2);
        if (bl2) {
            al2.a(new z(al2 instanceof do ? (byte)-1 : -2));
            return false;
        }
        boolean bl3 = al2.a(this, n2, by2);
        n2 = bl3 ? 1 : 0;
        if (bl3 && this.var_dt_a != null) {
            if (this.var_dt_a.var_boolean_b && !al2.boolean_h()) {
                al2.c(60, 30);
            }
            if (this.var_dt_a.var_boolean_c && !al2.boolean_h()) {
                al2.g(50);
            }
        }
        return n2 != 0;
    }

    protected boolean a(al al2, int n2, byte by2) {
        if (this.boolean_b()) {
            return false;
        }
        if (n2 == -90) {
            this.a(new z(-3));
            return false;
        }
        this.a(new bu(1));
        this.a(al2, cd.int_a(n2, this.int_b()), by2, (byte)3);
        return true;
    }

    private static int int_a(int n2, int n3) {
        if ((n2 -= n3) < 5) {
            return 5;
        }
        return n2;
    }

    protected void a(al al2, int n2) {
        boolean bl2 = true;
        al2 = this;
        ((du)this).l = bl2;
        this.var_int_k -= n2 << 1;
        if (this.var_int_k <= 0) {
            this.var_int_k = 0;
        }
    }

    protected void h(int n2) {
        this.var_int_k += n2;
        if (this.var_int_k > this.int_d()) {
            this.var_int_k = this.int_d();
        }
    }

    public final void c(byte[] byArray) {
        this.var_boolean_f = true;
        this.var_al_a = null;
        this.var_short_a = 1;
        this.var_int_e = 0;
        this.var_byte_arr_a = byArray;
        this.boolean_a();
    }

    protected boolean boolean_a() {
        if (this.var_int_k <= 0 && !this.var_boolean_f) {
            this.var_int_k = 0;
            this.void_a((byte)6);
            return true;
        }
        return false;
    }

    protected final boolean boolean_a(short s2, short s3, byte by2, byte by3) {
        g g2 = di.var_g_a;
        int n2 = 0;
        while (++n2 < 10) {
            int n3 = rpg.g.a(al.var_java_util_Random_a, by2, (int)by3);
            int n4 = s2 + rpg.d.H[n3];
            if (!g2.a(this, n4, n3 = s3 + rpg.d.I[n3])) continue;
            by2 = (byte)n3;
            s3 = (short)n4;
            cd cd2 = this;
            cd2.a((short)(s3 << 4), (short)(by2 << 4));
            cd2.E();
            cd2.u();
            return true;
        }
        return false;
    }

    protected final void b(at at2) {
        switch (at2.var_byte_a) {
            case 39: {
                if (!g.boolean_a()) {
                    o.c(at2.var_int_b);
                }
                if (!g.var_boolean_a) break;
                ++at2.var_int_b;
                return;
            }
            case 6: {
                if (at2.var_int_b % 10 != 0 || this.var_int_b <= 0) break;
                this.a(new z(-5, 0, this.var_int_b));
                this.a(null, this.var_int_b);
                this.boolean_a();
            }
        }
    }

    protected final void c(at at2) {
        switch (at2.var_byte_a) {
            case 16: {
                int n2 = di.var_do_a.int_c((byte)8);
                this.var_boolean_b = true;
                this.void_b((byte)17, n2);
                return;
            }
            case 17: {
                this.var_boolean_b = false;
                return;
            }
            case 5: {
                this.var_boolean_g = false;
                this.void_a((byte)1);
                return;
            }
            case 7: {
                this.var_boolean_h = false;
                return;
            }
            case 6: {
                this.var_int_b = 0;
            }
        }
    }

    public final boolean boolean_k() {
        return this.var_boolean_b;
    }

    public byte byte_a() {
        return this.n;
    }

    public int int_a(byte by2) {
        int n2 = 0;
        switch (by2) {
            case 1: {
                n2 = this.var_short_g;
            }
        }
        return n2;
    }

    public int int_b() {
        if (this.var_boolean_h) {
            return (this.d << 2) / 5;
        }
        return this.d;
    }

    public short short_a() {
        if (this.var_boolean_h) {
            return (short)((this.var_short_f << 2) / 5);
        }
        return this.var_short_f;
    }

    public void c(int n2) {
        if (this.boolean_b()) {
            return;
        }
        if (!this.var_boolean_g) {
            this.var_boolean_g = true;
            if (this.var_byte_b != 2) {
                this.void_a((byte)1);
            }
            this.boolean_a((byte)5, n2);
        }
    }

    public void c(int n2, int n3) {
        if (this.boolean_b()) {
            return;
        }
        if (this.var_int_b == 0) {
            this.var_int_b = n3;
            this.boolean_a((byte)6, n2);
        }
    }

    public final void g(int n2) {
        if (this.boolean_b()) {
            return;
        }
        if (!this.var_boolean_h) {
            this.var_boolean_h = true;
            this.boolean_a((byte)7, n2);
            this.f(n2);
        }
    }

    protected final boolean a(byte[] byArray, short s2, boolean bl2) {
        int n2;
        int n3;
        int n4;
        int n5;
        boolean bl3 = false;
        al al2 = di.var_do_a;
        block0: for (n5 = 0; !bl3 && n5 < byArray.length; n5 += 2) {
            n4 = this.s + byArray[n5];
            n3 = this.t + byArray[n5 + 1];
            for (n2 = 0; !bl3 && n2 < this.u; ++n2) {
                if (al2.s != n4 + n2 || al2.t != n3) continue;
                bl3 = this.b(al2, (int)s2, this.var_byte_c);
                if (!bl2 || !bl3 || !di.var_do_a.boolean_g()) continue block0;
                al2.void_b(this.var_byte_c);
                continue block0;
            }
        }
        n5 = 0;
        if (di.var_h_a != null) {
            al2 = di.var_h_a;
            block2: for (n2 = 0; n5 == 0 && n2 < byArray.length; n2 += 2) {
                n4 = this.s + byArray[n2];
                n3 = this.t + byArray[n2 + 1];
                for (int i2 = 0; n5 == 0 && i2 < this.u; ++i2) {
                    if (al2.s != n4 + i2 || al2.t != n3) continue;
                    n5 = this.b(al2, (int)s2, this.var_byte_c) ? 1 : 0;
                    if (!bl2 || n5 == 0) continue block2;
                    al2.void_b((byte)(n2 / 2 + 1));
                    continue block2;
                }
            }
        }
        return bl3 || n5 != 0;
    }

    public final byte[] byte_arr_a() {
        return this.var_dt_a.var_byte_arr_a;
    }

    protected static al[] al_arr_a() {
        return new al[]{di.var_do_a, di.var_h_a};
    }

    static {
        var_java_util_Vector_c = new Vector();
    }
}

