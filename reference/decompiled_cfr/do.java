/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;
import rpg.a;
import rpg.b;
import rpg.e;

public final class do
extends al {
    private byte var_byte_i;
    private byte var_byte_j = (byte)2;
    byte var_byte_a = 0;
    private byte[] var_byte_arr_b;
    private byte[] var_byte_arr_c;
    public byte[] var_byte_arr_a;
    private boolean[] var_boolean_arr_a;
    private boolean[] var_boolean_arr_b;
    private byte[] var_byte_arr_d;
    private cl var_cl_a;
    private o var_o_a;
    private boolean var_boolean_d;
    private boolean var_boolean_e;
    public byte var_byte_g;
    private byte[] O;
    private byte var_byte_k;
    private byte var_byte_l;
    private byte var_byte_m;
    private byte var_byte_n;
    private int[] var_int_arr_a;
    private int[] var_int_arr_b;
    private short[] var_short_arr_a;
    private int[] var_int_arr_c;
    private byte[] P;
    private short var_short_c;
    private byte var_byte_o;
    private int var_int_k;
    private int var_int_l;
    public int var_int_a;
    private byte var_byte_p;
    private byte v;
    short var_short_a;
    public short var_short_b;
    private bm[] var_bm_arr_a;
    private byte w = 0;
    private byte x;
    private boolean var_boolean_f = false;
    private byte y = (byte)-1;
    public int var_int_b = -1;
    private int var_int_m = -1;
    private boolean var_boolean_g = false;
    private boolean var_boolean_h = false;
    public int var_int_e = -1;
    public boolean var_boolean_a = false;
    public int var_int_f = -1;
    public boolean var_boolean_b = false;
    private int var_int_n = 0;
    public int var_int_j = 0;
    public static byte var_byte_h;
    private int var_int_o;
    private byte z = 0;
    private boolean var_boolean_i = true;
    private static int var_int_p;
    private int q = 0;
    public static long var_long_a;
    public static boolean var_boolean_c;
    private byte A = 0;
    private Vector var_java_util_Vector_c;

    private do(short s2, short s3, byte by2, byte by3) {
        super((short)0, (short)0, (byte)8, (byte)9);
    }

    public static do do_a(byte by2) {
        int n2;
        int n3;
        do do_;
        do do_2 = do_ = new do(0, 0, 8, 9);
        do_.var_byte_n = 1;
        do_2.var_short_b = 0;
        do_2.var_short_a = 0;
        do_2.var_byte_arr_b = rpg.e.a("/hero/hsd2");
        do_2.var_bm_arr_a = new bm[7];
        do_2.var_short_arr_a = new short[4];
        do_2.var_int_arr_c = new int[4];
        do_2.P = new byte[6];
        do_2.var_int_arr_a = new int[4];
        do_2.var_int_arr_b = new int[4];
        bs.var_boolean_arr_a = new boolean[4];
        for (n3 = 0; n3 < 4; ++n3) {
            bs.var_boolean_arr_a[n3] = false;
        }
        do_2.v = (byte)100;
        do_2.var_byte_p = (byte)100;
        do_2.var_byte_arr_d = new byte[48];
        do_2.var_byte_arr_c = new byte[20];
        do_2.I();
        n3 = do_2.var_byte_arr_d.length;
        for (n2 = 0; n2 < n3; ++n2) {
            do_2.var_byte_arr_d[n2] = -1;
        }
        n3 = do_2.var_byte_arr_c.length;
        for (n2 = 0; n2 < n3; ++n2) {
            do_2.var_byte_arr_c[n2] = -1;
        }
        ((du)do_2).l = true;
        do_2.z();
        do_2.var_byte_k = 1;
        do_2.var_int_k = 1;
        do_2.var_byte_m = 0;
        do_2.var_int_m = -1;
        do_2.var_int_b = -1;
        do_2.y();
        do_2.J();
        v0.z = 0;
        do_.m(by2);
        do_2 = do_;
        o o2 = new o(do_2);
        o2.void_a();
        o2.f();
        for (n2 = 0; n2 < 2; ++n2) {
            o2.b(n2 + 2);
        }
        o2.d();
        do_2.var_o_a = o2;
        return do_;
    }

    private void m(byte by2) {
        cl cl2 = null;
        switch (by2) {
            case 0: {
                cl2 = new ab(this);
                break;
            }
            case 1: {
                cl2 = new cu(this);
                break;
            }
            case 2: {
                cl2 = new d(this);
                break;
            }
            case 3: {
                cl2 = new ad(this);
                break;
            }
            case 4: {
                cl2 = new ao(this);
                break;
            }
            case 5: {
                cl2 = new dr(this);
            }
        }
        cl2.void_b(by2);
        bq.h();
        this.var_cl_a = cl2;
    }

    public final void void_e(byte by2) {
        for (byte by3 = 0; by3 < 2; by3 = (byte)(by3 + 1)) {
            di.void_a(by3, true);
        }
        di.var_byte_b = by2;
        this.m(by2);
        this.void_a(false);
        rpg.e.c();
    }

    public final void void_a(boolean bl2) {
        int n2;
        int n3 = di.var_byte_b;
        do do_ = this;
        int n4 = n3;
        do do_2 = do_;
        int n5 = 0;
        for (n2 = 0; n2 < n4; ++n2) {
            n5 += 8;
        }
        if (do_2.var_byte_arr_d[n5] < 0) {
            do_2.var_byte_arr_d[n5] = 0;
        }
        if (!do.boolean_g((byte)n4)) {
            for (n2 = 2; n2 < 6; ++n2) {
                do_2.var_byte_arr_d[n5 + n2] = -2;
            }
        }
        n2 = n5 + 6;
        for (n4 = 0; n4 < 2; ++n4) {
            if (do_2.var_byte_arr_d[n2 += n4] >= 0) continue;
            do_2.var_byte_arr_d[n2] = 0;
        }
        n4 = n3;
        do_2 = do_;
        n5 = 0;
        for (n2 = 0; n2 < n4; n2 = (byte)(n2 + 1)) {
            n5 += do.boolean_g((byte)n2) ? 4 : 2;
        }
        n2 = do.boolean_g((byte)n4) ? 4 : 2;
        for (n4 = 0; n4 < n2; ++n4) {
            if (do_2.var_byte_arr_c[n5 + n4] >= 0) continue;
            do_2.var_byte_arr_c[n5 + n4] = 0;
        }
        do_.void_a();
        di.j();
        this.J();
        this.var_o_a.c();
        this.void_i();
        if (bl2) {
            if (di.var_byte_b == 4 || di.var_byte_b == 5) {
                this.var_byte_n = (byte)40;
                this.var_short_a = (short)(this.var_short_a + 156);
                this.var_short_b = (short)(this.var_short_b + 20);
            }
            int n6 = 0;
            do do_3 = this;
            n3 = do_3.var_int_arr_b[n6];
            n6 = 0;
            do_3 = this;
            do_3.var_int_arr_a[n6] = n3;
            n6 = 1;
            do_3 = this;
            n3 = do_3.var_int_arr_b[n6];
            n6 = 1;
            do_3 = this;
            do_3.var_int_arr_a[n6] = n3;
            n6 = 3;
            do_3 = this;
            n3 = do_3.var_int_arr_b[n6];
            n6 = 3;
            do_3 = this;
            do_3.var_int_arr_a[n6] = n3;
        }
    }

    private void y() {
        for (int i2 = 0; i2 < 6; ++i2) {
            int n2 = i2 * 8 + 6;
            this.var_byte_arr_d[n2] = 3;
            this.var_byte_arr_d[n2 + 1] = 3;
        }
    }

    public final byte byte_a(byte by2) {
        by2 = (byte)((di.var_byte_b << 3) + by2 - 4);
        return this.var_byte_arr_d[by2];
    }

    public final void a(byte by2, byte by3) {
        int n2;
        byte by4 = by2 = (byte)((by2 << 3) + by3 - 4);
        this.var_byte_arr_d[by4] = (byte)(this.var_byte_arr_d[by4] + 1);
        by3 = by2;
        do do_ = this;
        int n3 = n2 = do.boolean_g(di.var_byte_b) ? 6 : 2;
        if (by3 % 8 < n2 - 1 && do_.var_byte_arr_d[by3 + 1] == -1) {
            do_.var_byte_arr_d[by3 + 1] = 0;
        }
    }

    public final int int_c(byte by2) {
        return this.var_cl_a.int_c(by2);
    }

    private int int_a(byte by2, int n2, boolean bl2) {
        return this.var_cl_a.a(by2, n2, false);
    }

    public final void void_a(int n2) {
        int n3 = n2;
        this.var_byte_arr_c[n3] = (byte)(this.var_byte_arr_c[n3] + 1);
    }

    final void s() {
        super.s();
        this.A();
    }

    final void void_b(boolean bl2) {
        this.r();
        this.A();
        if (bl2) {
            do do_ = this;
            do_.z();
            do_.s();
            do do_2 = do_;
            if (do_2.var_int_b > 0) {
                do_2.var_int_b = -1;
                do_2.K();
            }
            if (do_2.var_int_m > 0) {
                do_2.var_int_m = -1;
                do_2.L();
            }
            do_.P();
            do_.void_i();
        }
    }

    private void z() {
        this.var_boolean_f = false;
        this.y = (byte)-1;
        this.var_boolean_g = false;
        this.var_boolean_h = false;
        this.var_boolean_a = false;
        this.var_boolean_b = false;
        this.var_int_n = 0;
        this.var_int_f = -1;
        this.var_int_d = -1;
    }

    private void A() {
        this.O = new byte[(di.var_byte_b == 5 ? 6 : 4) + 2];
        this.B();
        this.var_boolean_d = false;
        this.var_boolean_e = false;
        this.w = 0;
        this.x = 0;
        var_byte_h = (byte)-1;
        if (this.var_o_a != null) {
            this.var_o_a.a(false);
        }
        do do_ = this;
        this.z = 0;
    }

    private final void B() {
        for (int i2 = 0; i2 < this.O.length; ++i2) {
            this.O[i2] = -1;
        }
        this.var_byte_l = (byte)-1;
    }

    public final void void_a() {
        this.var_byte_k = this.var_cl_a.byte_b();
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void b(int n2, int n3) {
        block15: {
            if (var_long_a > 0L) {
                ++this.q;
                if (this.q > 5) {
                    this.q = 0;
                } else if (this.q < 2) {
                    return;
                }
            }
            if (!((du)this).l) {
                return;
            }
            n2 = n2 + ((du)this).h + ((du)this).q;
            n3 = n3 + ((du)this).i + this.r - 1;
            if (this.w == 1) {
                n2 += rpg.d.H[this.x] * 3;
                n3 += rpg.d.I[this.x] * 3;
                this.w = (byte)(this.w - 1);
            }
            this.b(n2, n3, false);
            cm cm2 = rpg.a.var_cm_a;
            cm2.a(rpg.e.var_cg_arr_e[this.var_boolean_e ? 1 : 0], n2, n3 + 6, 33);
            switch (this.var_byte_b) {
                case 3: {
                    if (this.var_byte_l < 0) break;
                    this.b(this.O[this.var_byte_l] + 6, n2, n3);
                    break block15;
                }
                case 2: {
                    this.b((int)this.var_byte_j, n2, n3);
                    break block15;
                }
                case 7: {
                    this.var_int_c = 8;
                }
                case 6: {
                    do.a(n2, n3, this.var_int_c);
                    break block15;
                }
                case 9: {
                    this.b(7, n2, n3);
                    break block15;
                }
                case 10: {
                    this.b(5, n2, n3);
                    break block15;
                }
                case 99: {
                    this.b((int)this.var_byte_i, n2, n3);
                    break block15;
                }
            }
            this.b((int)this.var_byte_a, n2, n3);
        }
        this.b(n2, n3, true);
        this.d(n2, n3);
    }

    private final void b(int n2, int n3, int n4) {
        this.var_int_c = rpg.e.var_ca_a.a((byte)n2, this.var_byte_c, this.var_int_c, n3, n4);
    }

    public static void a(int n2, int n3, int n4) {
        rpg.e.var_ca_a.a((byte)4, (byte)1, n4, n2, n3);
    }

    final void void_c() {
        byte by2;
        int n2;
        super.void_c();
        if (var_long_a > 0L) {
            var_boolean_c = true;
        }
        ++this.var_int_c;
        if (di.var_byte_d == 3) {
            if (this.var_byte_m > 0) {
                this.var_byte_m = (byte)(this.var_byte_m - 1);
            }
            if (this.var_int_f > 0) {
                --this.var_int_f;
            }
            do do_ = this;
            switch (do_.var_byte_b) {
                case 1: {
                    do_.var_byte_p = (byte)(do_.var_byte_p - 2);
                    do_.v = (byte)(do_.v - 2);
                    break;
                }
                case 2: {
                    do_.var_byte_p = (byte)(do_.var_byte_p - 1);
                    do_.v = (byte)(do_.v - 1);
                }
            }
            if (do_.var_byte_p <= 0) {
                do_.void_c(do_.var_int_o);
                do_.var_byte_p = (byte)100;
            }
            if (do_.v <= 0) {
                n2 = do_.var_int_o;
                do do_2 = do_;
                do_2.c((byte)1, n2);
                do_.v = (byte)100;
            }
            for (by2 = 0; by2 < 5; by2 = (byte)(by2 + 1)) {
                if (di.var_int_arr_a[by2] < 0) continue;
                byte by3 = by2;
                di.var_int_arr_a[by3] = di.var_int_arr_a[by3] - 1;
            }
            do_ = this;
            if (do_.var_int_b > 0) {
                --do_.var_int_b;
                if (do_.var_int_b == 0) {
                    do_.K();
                }
            }
            if (do_.var_int_m > 0 && do_.var_byte_b != 10) {
                --do_.var_int_m;
                if (do_.var_int_m == 0) {
                    do_.L();
                }
            }
            this.var_o_a.void_b();
        }
        this.t();
        this.C();
        byte by4 = this.var_byte_b;
        if (this.boolean_d()) {
            this.var_boolean_d = false;
        }
        by2 = by4;
        do do_ = this;
        n2 = 0;
        if (do_.var_byte_b != 3 && !do_.var_boolean_d) {
            n2 = df.a(do_) ? 1 : 0;
            do_.var_boolean_d = true;
        }
        if (n2 == 0 && by2 == 2 && do_.var_byte_b == 1) {
            n2 = df.boolean_d() ? 1 : 0;
        }
        if (n2 != 0) {
            do_.void_a((byte)1);
            ((al)do_).e = 0;
            do_.var_int_c = 0;
        }
    }

    public final void void_b() {
        this.A = 1;
    }

    public final void void_d() {
        var_long_a = 5000L;
        this.A = (byte)2;
        int n2 = 0;
        do do_ = this;
        int n3 = do_.var_int_arr_b[n2];
        n2 = 0;
        do_ = this;
        do_.var_int_arr_a[n2] = n3;
        n2 = 1;
        do_ = this;
        n3 = do_.var_int_arr_b[n2];
        n2 = 1;
        do_ = this;
        do_.var_int_arr_a[n2] = n3;
        n2 = 3;
        do_ = this;
        n3 = do_.var_int_arr_b[n2];
        n2 = 3;
        do_ = this;
        do_.var_int_arr_a[n2] = n3;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void C() {
        switch (this.var_byte_b) {
            case 2: {
                do do_ = this;
                this.z = 0;
                this.w();
                this.d(4);
                return;
            }
            case 3: {
                do do_ = this;
                if (do_.var_byte_l < 0) {
                    do_.var_byte_l = 0;
                }
                if (do_.O[do_.var_byte_l] < 100 && do_.var_int_c == do.byte_a(6 + do_.O[do_.var_byte_l])) {
                    if (do_.var_byte_l + 1 >= do_.var_byte_k && do_.O[do_.var_byte_l + 1] < 4 || do_.O[do_.var_byte_l + 1] == -1) {
                        do_.void_b((int)do_.var_byte_l);
                        return;
                    }
                    do_.var_byte_l = (byte)(do_.var_byte_l + 1);
                    do_.var_int_c = 0;
                }
                int n2 = do_.O[do_.var_byte_l];
                if (do_.var_int_c <= 0) {
                    boolean bl2;
                    if (do_.z > 0 && n2 < 4) {
                        do_.void_b((int)do_.var_byte_l);
                        return;
                    }
                    if (n2 >= 100) {
                        n2 = (byte)(do_.O[do_.var_byte_l] - 100);
                        if (do_.var_o_a.boolean_d((byte)n2)) {
                            do_.B();
                            return;
                        }
                        do_.void_b((int)do_.var_byte_l);
                        return;
                    }
                    if (!do_.var_cl_a.boolean_a((byte)n2)) {
                        do_.void_b((int)do_.var_byte_l);
                        do_.k((byte)6);
                        return;
                    }
                    int n3 = n2;
                    do do_2 = do_;
                    n3 = do_2.var_cl_a.int_b((byte)n3);
                    int n4 = 0;
                    do do_3 = do_2;
                    n3 = do_3.var_boolean_arr_a[n4] ? do_2.int_b((byte)0, n3) : n3;
                    n4 = 1;
                    do_3 = do_2;
                    if (n3 > do_3.var_int_arr_a[n4]) {
                        bl2 = false;
                    } else {
                        if (n3 > 0) {
                            n4 = -n3;
                            do_3 = do_2;
                            do_3.c((byte)1, n4);
                        }
                        bl2 = true;
                    }
                    if (!bl2) {
                        do_.void_b((int)do_.var_byte_l);
                        do_.k((byte)2);
                        return;
                    }
                    di.void_b((byte)n2, true);
                    if (do_.var_cl_a.boolean_b((byte)n2)) {
                        do_.void_f();
                    }
                }
                if (do_.var_cl_a.a((byte)n2, do_.var_int_c)) return;
                bq.a((byte)11);
                return;
            }
            case 6: {
                if (this.var_int_c < 8) return;
                this.void_a((byte)7);
                if (!df.boolean_e()) return;
                if (eb.var_boolean_f) {
                    bq.f();
                    di.void_a((byte)9);
                    return;
                }
                di.var_byte_d = (byte)5;
                ax.ax_a().void_a();
                ax.ax_a().c((byte)3);
                ax.ax_a();
                bw.a();
                return;
            }
            case 7: {
                if (this.A == 1) {
                    bq.f();
                    di.void_a((byte)9);
                    this.A = 0;
                    return;
                }
                if (this.A != 2) return;
                this.var_int_arr_a[0] = this.var_int_arr_b[0];
                this.void_a((byte)1);
                this.B();
                this.A = 0;
                return;
            }
            case 0: {
                do do_ = this;
                this.z = 0;
                return;
            }
            case 1: {
                ((al)this).e = 0;
                this.d((int)do.byte_a((int)this.var_byte_a));
                return;
            }
            case 9: {
                if (this.var_int_c < 4) return;
                byte by2 = this.z;
                this.z = 0;
                if (by2 > 0) {
                    di.b((byte)2, by2);
                    di.c((byte)0, (byte)0);
                    return;
                }
                this.D();
                return;
            }
            case 99: {
                this.d((int)do.byte_a((int)this.var_byte_i));
                return;
            }
            case 10: {
                if (this.var_int_c >= do.byte_a(5)) {
                    this.var_o_a.e();
                    this.D();
                    return;
                }
                if (this.var_int_c != 0) return;
                bq.a((byte)0);
                return;
            }
        }
    }

    private void D() {
        byte by2 = di.var_byte_c;
        switch (by2) {
            case 1: 
            case 3: 
            case 9: 
            case 10: {
                this.void_a(by2);
                di.c((byte)0, (byte)0);
                this.var_int_c = 0;
                this.C();
                return;
            }
        }
        this.void_a((byte)1);
    }

    static byte byte_a(int n2) {
        return rpg.e.var_ca_a.a((byte)n2);
    }

    public final int int_d(byte by2) {
        int n2 = this.int_a((byte)1, (int)(by2 = (byte)this.var_cl_a.int_a(by2)));
        if (n2 > 0) {
            return n2;
        }
        return by2;
    }

    final void void_h() {
        if (this.boolean_f()) {
            this.var_int_c = 0;
            this.e((int)((al)this).f);
        }
    }

    final boolean boolean_d(byte by2) {
        if (this.var_byte_m > 0 || this.var_byte_l + 1 >= this.var_byte_k) {
            return false;
        }
        if (this.O[this.var_byte_l + 1] < 4) {
            if (by2 > 0) {
                if (this.var_byte_l >= 0 && this.O[this.var_byte_l] == by2) {
                    return false;
                }
                this.O[this.var_byte_l + 1] = by2;
                return true;
            }
            do do_ = this;
            boolean bl2 = do_.var_int_b > 0 ? (do_.var_byte_l >= 0 && do_.O[do_.var_byte_l] >= 4 && do_.O[do_.var_byte_l] < 6 ? false : do_.var_byte_l < 0 || do_.O[do_.var_byte_l] < 11) : do_.var_byte_l < 0 || do_.O[do_.var_byte_l] < 4;
            if (bl2) {
                switch (di.var_byte_b) {
                    case 3: {
                        this.O[this.var_byte_l + 1] = 0;
                        break;
                    }
                    case 5: {
                        if (this.var_int_b > 0) {
                            this.O[this.var_byte_l + 1] = (byte)(this.var_byte_l + 1 + 6);
                            return true;
                        }
                    }
                    default: {
                        this.O[this.var_byte_l + 1] = (byte)(this.var_byte_l + 1);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void void_f(byte by2) {
        this.O[this.var_byte_l + 1] = by2;
    }

    public final void void_b(int n2) {
        this.var_byte_m = n2 < 2 && this.O[n2] <= 0 ? (byte)2 : (byte)4;
        n2 = this.z;
        if (di.var_byte_b == 3) {
            this.void_a((byte)9);
        } else if (n2 > 0) {
            do do_ = this;
            this.z = 0;
            di.b((byte)2, (byte)n2);
            di.c((byte)0, (byte)0);
        } else {
            this.void_a((byte)1);
        }
        this.var_int_c = 0;
        this.B();
    }

    public final void void_g(byte by2) {
        this.z = by2;
    }

    public final void void_e() {
        this.z = 0;
    }

    public final void void_f() {
        this.void_c(this.byte_b());
    }

    public final int int_a(boolean bl2) {
        int n2 = (bl2 = bl2 ? this.var_int_l : this.var_int_k) ? 1 : 0;
        if (this.var_boolean_b) {
            return (bl2 << 2) / 5;
        }
        return bl2 ? 1 : 0;
    }

    public final int int_b(boolean bl2) {
        int n2;
        bm bm2 = bl2 ? this.bm_a((byte)5) : this.bm_a((byte)3);
        int n3 = this.int_a(bl2);
        if (bm2 != null) {
            n2 = n3 + (bm2.var_short_c - bm2.b);
        }
        return n2;
    }

    /*
     * WARNING - void declaration
     */
    public final int int_c(boolean bl2) {
        void var1_6;
        int n2;
        bm bm2 = bl2 ? this.bm_a((byte)5) : this.bm_a((byte)3);
        int do_ = this.int_a(bl2);
        if (bm2 != null) {
            int n3 = rpg.g.a(1, 100) + this.var_o_a.int_a((byte)4);
            if (n3 > 100) {
                n3 = 100;
            }
            n2 = do_ + (bm2.var_short_c - bm2.b) * n3 / 100;
        }
        if (this.var_int_b > 0) {
            int n4 = 3;
            do do_2 = this;
            void var1_5 = n2 + do_2.var_int_arr_c[n4];
        }
        return (int)var1_6;
    }

    final boolean a(cd cd2, byte by2, int n2, byte by3, byte by4, boolean bl2, boolean bl3, boolean bl4) {
        if (cd2 != null) {
            return cd2.a(this, by2, n2, bl2, by3, by4, bl3, true, bl4);
        }
        return false;
    }

    public final boolean a(byte by2, int n2, byte by3, boolean bl2, boolean bl3, boolean bl4) {
        cd cd2 = this.cd_a();
        return this.a(cd2, by2, n2, this.var_byte_c, by3, bl2, false, false);
    }

    public final boolean a(byte by2, int n2, byte by3, boolean bl2, boolean bl3) {
        by2 = 0;
        byte by4 = this.var_byte_c;
        cd by42 = this.cd_a(by4);
        if (by42 != null) {
            by2 = this.a(by42, (byte)7, n2, by4, by3, false, bl2, false) ? 1 : 0;
        }
        for (byte by5 = 1; by5 <= 3; by5 = (byte)(by5 + 1)) {
            if (this.a(by4, by4, by5, (byte)7, n2, by3, bl2, false)) {
                by2 = 1;
            }
            if (this.a(rpg.d.K[by4], by4, by5, (byte)7, n2, by3, bl2, false)) {
                by2 = 1;
            }
            if (!this.a(rpg.d.J[by4], by4, by5, (byte)7, n2, by3, bl2, false)) continue;
            by2 = 1;
        }
        return by2 != 0;
    }

    private boolean a(byte by2, byte by3, byte by4, byte by5, int n2, byte by6, boolean bl2, boolean bl3) {
        cd cd2 = this.cd_a(by2, by3, (int)by4);
        if (cd2 != null) {
            return this.a(cd2, by5, n2, by3, by6, bl3, bl2, false);
        }
        return false;
    }

    private cd cd_a(byte by2, byte by3, int n2) {
        du du2 = this.a(by2, by3, (byte)n2);
        if (du2 != null && du2 instanceof cd) {
            return (cd)du2;
        }
        return null;
    }

    public final cd cd_b(byte by2) {
        du du2 = du.a(this.s, this.t, by2, (byte)0, (byte)0);
        if (du2 != null && du2 instanceof cd && !(du2 instanceof h)) {
            return (cd)du2;
        }
        return null;
    }

    public final boolean a(byte by2, int n2, byte by3) {
        by2 = 0;
        for (byte by4 = 1; by4 <= 12; by4 = (byte)(by4 + 1)) {
            cd cd2 = this.cd_b(by4);
            if (cd2 == null || !this.a(cd2, (byte)9, n2, by4, by3, false, false, false)) continue;
            by2 = 1;
        }
        return by2 != 0;
    }

    protected final cd cd_a() {
        du du2 = this.a(this.var_byte_c, (du)null);
        if (du2 != null && du2 instanceof cd && !(du2 instanceof h) && !((cd)du2).boolean_b()) {
            return (cd)du2;
        }
        return null;
    }

    private void a(cd cd2) {
        if (cd2 != null) {
            this.var_java_util_Vector_c.addElement(cd2);
        }
    }

    public final Vector java_util_Vector_b(byte by2) {
        this.var_java_util_Vector_c = new Vector(0);
        switch (by2) {
            case 0: {
                this.a(this.cd_a());
                break;
            }
            case 1: {
                this.a(this.cd_a());
                this.a(this.cd_a((byte)(this.var_byte_c + 8)));
                break;
            }
            case 2: {
                this.a(this.cd_a(rpg.d.M[this.var_byte_c]));
                this.a(this.cd_a());
                this.a(this.cd_a(rpg.d.L[this.var_byte_c]));
                break;
            }
            case 3: {
                this.a(this.cd_a(rpg.d.M[this.var_byte_c]));
                this.a(this.cd_a(rpg.d.K[this.var_byte_c]));
                this.a(this.cd_a());
                this.a(this.cd_a(rpg.d.J[this.var_byte_c]));
                this.a(this.cd_a(rpg.d.L[this.var_byte_c]));
                break;
            }
            case 4: {
                for (by2 = 0; by2 < 3; by2 = (byte)(by2 + 1)) {
                    this.a(this.cd_a(rpg.d.M[this.var_byte_c], this.var_byte_c, by2 + 1));
                    this.a(this.cd_a((byte)0, this.var_byte_c, by2 + 1));
                    this.a(this.cd_a(rpg.d.L[this.var_byte_c], this.var_byte_c, by2 + 1));
                }
                break;
            }
        }
        return this.var_java_util_Vector_c;
    }

    final byte byte_b() {
        cd cd2 = this.cd_a();
        if (cd2 == null) {
            if (this.cd_a(rpg.d.M[this.var_byte_c]) != null) {
                return rpg.d.M[this.var_byte_c];
            }
            if (this.cd_a(rpg.d.L[this.var_byte_c]) != null) {
                return rpg.d.L[this.var_byte_c];
            }
            if (this.cd_a(rpg.d.N[this.var_byte_c]) != null) {
                return rpg.d.N[this.var_byte_c];
            }
        }
        return this.var_byte_c;
    }

    public final cd cd_b() {
        cd cd2 = this.cd_c(this.var_byte_c);
        if (cd2 != null) {
            return cd2;
        }
        cd2 = this.cd_c(rpg.d.M[this.var_byte_c]);
        if (cd2 != null) {
            this.void_c(rpg.d.M[this.var_byte_c]);
            return cd2;
        }
        cd2 = this.cd_c(rpg.d.L[this.var_byte_c]);
        if (cd2 != null) {
            this.void_c(rpg.d.L[this.var_byte_c]);
            return cd2;
        }
        cd2 = this.cd_c(rpg.d.N[this.var_byte_c]);
        if (cd2 != null) {
            this.void_c(rpg.d.N[this.var_byte_c]);
            return cd2;
        }
        return cd2;
    }

    private cd cd_c(byte by2) {
        cd cd2 = this.cd_a(by2);
        if (cd2 == null) {
            for (int n2 = 0; n2 < 3 && (cd2 = this.cd_a(by2, by2, n2)) == null && (cd2 = this.cd_a(rpg.d.K[by2], by2, n2)) == null && (cd2 = this.cd_a(rpg.d.J[by2], by2, n2)) == null; n2 = (int)((byte)(n2 + 1))) {
            }
        }
        if (cd2 != null && cd2.boolean_b()) {
            return null;
        }
        return cd2;
    }

    public final void void_c(boolean bl2) {
        this.var_boolean_e = bl2;
    }

    public final boolean a(byte by2, byte by3, byte by4, int n2) {
        boolean bl2 = false;
        this.var_byte_g = (byte)this.a(by3, true, this.var_byte_c);
        if (this.var_byte_g > 0) {
            if (n2 > 0 || n2 == -1 || n2 == -100) {
                if (this.a(by2, n2, by4, false, false, false)) {
                    bl2 = true;
                }
                if (this.var_byte_g != 1) {
                    cd cd2;
                    byte by5 = by4;
                    by4 = this.var_byte_c;
                    by3 = by2;
                    do do_ = this;
                    cd cd3 = do_.cd_a((byte)(by4 + 8));
                    if (cd3 != null && (cd2 = do_.cd_a(by4)) != cd3 ? do_.a(cd3, by3, n2, do_.var_byte_c, by5, false, false, false) : false) {
                        bl2 = true;
                    }
                }
            }
            this.e(16 * this.var_byte_g);
        } else if (this.a(by2, n2, by4, false, false, false)) {
            bl2 = true;
            this.var_byte_g = 0;
        }
        return bl2;
    }

    public final boolean boolean_e(byte by2) {
        this.var_byte_g = (byte)this.a((byte)3, false, this.var_byte_c);
        if (this.var_byte_g > 0) {
            this.e(16 * this.var_byte_g);
        }
        return this.var_byte_g != 3;
    }

    private int a(byte n2, boolean bl2, byte by2) {
        g g2 = di.var_g_a;
        int n3 = this.s;
        int n4 = this.t;
        int n5 = 0;
        for (int i2 = 1; i2 <= n2; ++i2) {
            if ((n3 += rpg.d.H[by2]) < 0 || (n4 += rpg.d.I[by2]) < 0 || n3 >= g.var_byte_c || n4 >= g.var_byte_d) continue;
            if (g2.a((du)this, n3, n4)) {
                if (bl2) continue;
                return n5;
            }
            if (g2.boolean_b(n3, n4) || g2.boolean_c(n3, n4)) {
                return n5;
            }
            n5 = i2;
        }
        return n5;
    }

    final void void_c(int n2) {
        if (n2 < 0) {
            n2 = au.e < 20 ? (n2 /= 2) : (n2 /= 3);
        }
        if (var_long_a > 0L && n2 < 0) {
            n2 = 0;
        }
        this.c((byte)0, bs.var_boolean_b ? 0 : n2);
        if (this.var_int_arr_a[0] <= 0) {
            this.void_a((byte)6);
            this.var_int_c = 0;
        }
    }

    final void h(int n2) {
        this.c((byte)1, n2);
    }

    final void i(int n2) {
        this.c((byte)3, n2);
    }

    private final void F() {
        int n2;
        int n3 = n2 = di.var_byte_b == 5 ? this.int_c((byte)10) : 2;
        do do_ = this;
        do_.c((byte)3, n3);
    }

    public final void void_g() {
        do do_ = this;
        if (do_.var_byte_n > 99 - var_int_p) {
            this.var_byte_n = (byte)99;
            this.var_short_a = (short)(this.var_short_a + (short)(4 * (99 - this.var_byte_n)));
            this.var_short_b = (short)(this.var_short_b + 1 * (99 - this.var_byte_n >> 1));
        } else {
            this.var_byte_n = (byte)(this.var_byte_n + var_int_p);
            this.var_short_a = (short)(this.var_short_a + (short)(4 * var_int_p));
            this.var_short_b = (short)(this.var_short_b + 1 * (var_int_p >> 1));
        }
        this.void_i();
        int n2 = 0;
        do_ = this;
        int n3 = do_.var_int_arr_b[n2];
        n2 = 0;
        do_ = this;
        do_.var_int_arr_a[n2] = n3;
        n2 = 1;
        do_ = this;
        n3 = do_.var_int_arr_b[n2];
        n2 = 1;
        do_ = this;
        do_.var_int_arr_a[n2] = n3;
        n2 = 3;
        do_ = this;
        n3 = do_.var_int_arr_b[n2];
        n2 = 3;
        do_ = this;
        do_.var_int_arr_a[n2] = n3;
    }

    final void j(int n2) {
        if (ax.var_boolean_i || eb.var_boolean_f && this.var_byte_n < 20) {
            n2 <<= 1;
        }
        this.var_int_arr_a[2] = this.var_int_arr_a[2] + (n2 < 0 ? -n2 : n2);
        while (this.var_int_arr_a[2] >= this.var_int_arr_b[2]) {
            this.var_int_arr_a[2] = this.var_int_arr_a[2] - this.var_int_arr_b[2];
            if (this.var_byte_n < 99) {
                this.var_byte_n = (byte)(this.var_byte_n + 1);
                this.void_i();
                this.var_short_a = (short)(this.var_short_a + 4);
                if (this.var_byte_n % 2 == 0) {
                    this.var_short_b = (short)(this.var_short_b + 1);
                }
                this.a(new bu(8));
                if (!di.var_boolean_a) {
                    di.var_boolean_a = true;
                    rpg.b.boolean_a();
                    di.var_boolean_f = true;
                    di.var_byte_arr_a = rpg.e.var_ch_a.a(11);
                }
            }
            this.k(100);
            this.r(100);
            this.var_int_arr_a[3] = 100;
            bs.var_boolean_arr_a[2] = true;
        }
        bs.var_boolean_arr_a[2] = true;
    }

    final void k(int n2) {
        n2 = this.var_int_arr_b[0] * n2 / 100;
        this.void_c(n2);
    }

    private void r(int n2) {
        int n3 = n2 = this.var_int_arr_b[1] * n2 / 100;
        do do_ = this;
        do_.c((byte)1, n3);
    }

    private void c(byte by2, int n2) {
        byte by3 = by2;
        this.var_int_arr_a[by3] = this.var_int_arr_a[by3] + n2;
        if (this.var_int_arr_a[by2] > this.var_int_arr_b[by2]) {
            this.var_int_arr_a[by2] = this.var_int_arr_b[by2];
        } else if (this.var_int_arr_a[by2] < 0) {
            this.var_int_arr_a[by2] = 0;
        }
        bs.var_boolean_arr_a[by2] = true;
    }

    public final void void_i() {
        int n2;
        int n3;
        int n4;
        bm bm2;
        int n5;
        int n6;
        this.var_boolean_i = false;
        Object object = this;
        this.var_boolean_arr_b = new boolean[7];
        for (n6 = 0; n6 < 7; ++n6) {
            ((do)object).var_boolean_arr_b[n6] = false;
        }
        ((do)object).P();
        n6 = 0;
        if (((do)object).boolean_a(2)) {
            ((do)object).s(2);
            n6 = 1;
            ((do)object).O();
        }
        int n7 = n6 = n6 != 0 ? 3 : 0;
        while (n6 < 6) {
            if (n6 != 2 && super.boolean_a(n6)) {
                super.s(n6);
                break;
            }
            ++n6;
        }
        object = new int[4];
        n6 = 10 + (this.var_boolean_arr_b[0] ? 4 : 0);
        for (int i2 = 0; i2 < 4; ++i2) {
            object[i2] = n6 + this.var_short_arr_a[i2];
        }
        bm[] bmArray = this.var_bm_arr_a;
        for (n6 = 0; n6 < 7; ++n6) {
            if (bmArray[n6] == null) continue;
            for (n5 = 0; n5 < 4; ++n5) {
                Object object2 = object;
                int n8 = n5 + 0;
                object2[n8] = object2[n8] + bmArray[n6].int_a(n5 + 0);
                Object object3 = object;
                int n9 = n5 + 0;
                object3[n9] = object3[n9] + bmArray[n6].int_a(n5 + 10);
                Object object4 = object;
                int n10 = n5 + 0;
                object4[n10] = object4[n10] + bmArray[n6].int_a(15);
            }
        }
        this.var_int_arr_c[0] = (int)(object[0] + this.int_a((byte)3, (int)object[0]) + this.var_o_a.a((byte)7, (int)object[0]));
        this.var_int_arr_c[1] = (int)(object[1] + this.int_a((byte)13, (int)object[1]) + this.var_o_a.a((byte)7, (int)object[1]));
        this.var_int_arr_c[2] = (int)(object[2] + this.int_a((byte)8, (int)object[2]) + this.var_o_a.a((byte)7, (int)object[2]));
        this.var_int_arr_c[3] = (int)(object[3] + this.var_o_a.a((byte)7, (int)object[3]));
        if (di.var_byte_b == 5) {
            this.var_int_arr_c[3] = this.var_int_arr_c[3] + this.int_a((byte)11, (int)object[3], false);
        }
        n5 = (bm2 = this.bm_a((byte)3)) != null ? 1 : 0;
        object = this.bm_a((byte)5);
        int n11 = object != null ? 1 : 0;
        int n12 = this.var_int_arr_c[0] + this.var_int_arr_c[1] / 4 + this.int_g((byte)6);
        switch (di.var_byte_b) {
            case 1: {
                n12 += this.var_int_arr_c[1] / 6 - this.var_int_arr_c[0] / 3;
                break;
            }
            case 2: {
                n12 -= this.var_int_arr_c[0] / 2;
                break;
            }
            case 3: {
                n12 -= this.var_int_arr_c[1] / 6 + this.var_int_arr_c[0] / 2;
            }
        }
        int n13 = bs.var_boolean_b ? 9999 : this.int_a((byte)15, this.var_int_arr_c[1]) + this.var_o_a.int_a((byte)1);
        this.var_int_k = n12 + n13;
        this.var_int_l = 0;
        switch (di.var_byte_b) {
            case 0: {
                if (n5 == 0) break;
                this.var_int_k += this.int_a((byte)11, (int)bm2.var_short_c, false);
                break;
            }
            case 2: {
                if (n11 == 0) break;
                this.var_int_l = n12 + n13;
                this.var_boolean_i = true;
                break;
            }
            case 1: 
            case 3: {
                if (n11 == 0) break;
                this.var_int_l = this.int_a((byte)11, n12, false) + n13 + ((bm)object).b;
                this.var_boolean_i = true;
            }
        }
        if (n5 != 0) {
            this.var_int_k += bm2.b;
            this.var_boolean_i = true;
        }
        this.m();
        int n14 = this.int_h((byte)1) + this.int_h((byte)4) + this.int_h((byte)6) + this.int_h((byte)0) + this.int_g((byte)7);
        if (di.var_byte_b == 2) {
            n14 += this.int_h((byte)5);
        } else if (di.var_byte_b == 0) {
            n14 += this.var_int_arr_c[0] / 12;
        }
        this.var_int_a = n14 + this.int_a((byte)9, n14) + this.var_o_a.int_a((byte)0);
        this.G();
        this.H();
        byte by2 = (byte)(90 + this.int_g((byte)14));
        n14 = by2;
        if (by2 > 95) {
            n14 = 95;
        }
        this.void_a((byte)1, n14 += this.int_i((byte)2), false);
        this.void_a((byte)1, n14, true);
        this.var_short_c = (short)(10 + this.var_int_arr_c[2] / 10 + this.int_i((byte)10));
        this.var_byte_o = 0;
        if (di.var_byte_b == 2 && this.bm_a((byte)5) != null) {
            this.var_byte_o = (byte)(5 + this.var_int_arr_c[0] / 5 + (this.int_h((byte)5) >> 1));
            if (this.var_byte_o > 75) {
                this.var_byte_o = (byte)75;
            }
            this.var_byte_o = (byte)(this.var_byte_o + (byte)this.int_c((byte)11));
        }
        n11 = n14 = this.var_byte_n * this.var_byte_n * this.var_byte_n - this.var_byte_n * this.var_byte_n + 80 * this.var_byte_n;
        int n15 = 2;
        do do_ = this;
        do_.var_int_arr_b[n15] = n11;
        n11 = n4 = 5 * this.var_byte_n + 10 * this.var_int_arr_c[3] + this.int_g((byte)4);
        n15 = 1;
        do do_2 = this;
        do_2.var_int_arr_b[n15] = n11;
        int n16 = 10 * this.var_byte_n + 12 * this.var_int_arr_c[2] + this.int_g((byte)9);
        n16 += this.var_o_a.int_a((byte)2);
        if (di.var_byte_b == 2) {
            n16 += this.var_int_arr_c[2] / 5;
        }
        n11 = n16;
        n15 = 0;
        do do_3 = this;
        do_3.var_int_arr_b[n15] = n11;
        n11 = n3 = 100 + this.int_i((byte)19);
        n15 = 3;
        do do_4 = this;
        do_4.var_int_arr_b[n15] = n11;
        for (n2 = 0; n2 < 2; ++n2) {
            if (this.var_int_arr_a[n2] <= this.var_int_arr_b[n2]) continue;
            this.var_int_arr_a[n2] = this.var_int_arr_b[n2];
        }
        for (n2 = 0; n2 < 3; ++n2) {
            if (this.P[n2] <= 100) continue;
            this.P[n2] = 100;
        }
        this.var_int_o = this.var_int_arr_c[3] + this.var_o_a.int_a((byte)3);
        bs.var_boolean_c = true;
    }

    private void G() {
        bm bm2 = this.bm_a((byte)3);
        int n2 = bm2 != null ? 1 : 0;
        bm bm3 = this.bm_a((byte)5);
        boolean bl2 = bm3 != null;
        int n3 = (this.var_int_arr_c[1] >> 3) + this.int_g((byte)5);
        if (di.var_byte_b == 3) {
            n3 += this.var_int_arr_c[1] >> 4;
        }
        if (n3 > 50) {
            n3 = 50;
        }
        int n4 = (n3 += this.int_i((byte)5)) + (n2 != 0 ? bm2.h : (byte)0);
        n2 = n3 + (bl2 ? bm3.h : (byte)0);
        if (n4 > 70) {
            n4 = 70;
        }
        if (n2 > 70) {
            n2 = 70;
        }
        if (this.var_boolean_g) {
            n3 = this.var_o_a.int_b((byte)1);
            n4 += n3;
            n2 += n3;
        }
        this.void_a((byte)2, n4, false);
        this.void_a((byte)2, n2, true);
    }

    private void H() {
        int n2 = this.var_int_arr_c[1] / 5 + this.int_g((byte)8);
        if (di.var_byte_b == 1) {
            n2 += this.var_int_arr_c[1] / 10;
        } else if (di.var_byte_b == 2) {
            n2 -= this.var_int_arr_c[1] / 10;
        }
        if (n2 > 75) {
            n2 = 75;
        }
        if ((n2 += this.int_i((byte)4)) > 80) {
            n2 = 80;
        }
        if (this.var_boolean_h) {
            n2 += this.var_o_a.int_b((byte)2);
        }
        if (n2 > 85) {
            n2 = 85;
        }
        this.void_a((byte)0, n2, false);
        this.void_a((byte)0, n2, true);
    }

    final boolean a(al al2, int n2, byte by2) {
        boolean bl2;
        int n3;
        if (this.var_byte_b == 7 || this.var_byte_b == 6) {
            return false;
        }
        if (al2 instanceof cd) {
            bs.a((cd)al2, true);
        }
        if (di.var_byte_b == 2) {
            if (this.y > 1) {
                this.a(new ak(19));
                if ((n2 *= this.y / 10) <= 0) {
                    n2 = 5;
                }
            }
            if (this.var_boolean_f) {
                n3 = this.int_a((byte)7, this.int_a(true), false);
                this.a(new ak(18));
                al2.a(this, n3, (byte)0, (byte)3);
            }
            if (this.var_byte_o > 0 && rpg.g.a(1, 100) > 100 - this.var_byte_o) {
                this.a(new z(-3));
                return false;
            }
        }
        if ((n3 = n2 * (rpg.g.a(0, 2) + 10) / 10 - this.int_b()) <= 0) {
            n3 = 5;
        }
        al al3 = this;
        n2 = al2.int_a((byte)1) / 8 + al2.byte_a() - al3.var_byte_n;
        al2 = this;
        int n4 = n2;
        byte by3 = 14;
        al3 = al2;
        if (al3.var_boolean_arr_a[by3]) {
            by3 = 14;
            al3 = al2;
            n4 = n2 - super.int_b(by3, 1);
        }
        if (bl2 = rpg.g.a(1, 99) < n4) {
            n3 += n3 / 2;
        }
        if (this.var_int_e > 0) {
            this.var_int_e = 0;
            if ((n3 -= this.var_int_e) <= 0) {
                this.var_int_e = -n3;
                n3 = 0;
            }
        }
        if ((n3 /= 3) <= 0) {
            n3 = 1;
        }
        this.var_int_j = n3;
        this.void_c(-n3);
        this.F();
        this.a(new z(-4, -1, n3));
        this.a(new bu(bl2 ? (byte)3 : 4));
        this.w = 1;
        this.x = by2;
        return true;
    }

    protected final void a(al al2, int n2, byte by2, byte by3) {
        this.void_c(-n2);
        this.a(new z(-4, -1, n2));
        this.a(new bu(2));
    }

    public final void void_h(byte by2) {
        byte by3 = by2;
        this.var_short_arr_a[by3] = (short)(this.var_short_arr_a[by3] + 1);
    }

    public final int int_a(byte by2) {
        return this.var_int_arr_c[by2];
    }

    public final void void_a(byte by2, int n2) {
        this.var_int_arr_a[by2] = n2;
    }

    public final int int_e(byte by2) {
        return this.var_int_arr_a[by2];
    }

    public final int int_c() {
        return this.var_int_arr_a[3];
    }

    public final int int_f(byte by2) {
        return this.var_int_arr_b[by2];
    }

    public final int int_b(byte by2) {
        return this.P[by2];
    }

    private final void void_a(byte by2, int n2, boolean bl2) {
        this.P[by2 + (bl2 ? 3 : 0)] = (byte)n2;
    }

    public final int int_a() {
        int n2 = 0;
        do do_ = this;
        return do_.P[n2];
    }

    public final int a(byte by2, boolean bl2) {
        byte by3;
        if (bl2) {
            int do_ = 2;
            do n4 = this;
            by3 = n4.P[5];
        } else {
            int n2 = 2;
            do do_ = this;
            by3 = do_.P[n2];
        }
        byte by4 = by3;
        int n3 = by3 + (this.var_byte_n - by2);
        if (n3 > 90) {
            return 90;
        }
        return n3;
    }

    public final int int_a(int n2) {
        int n3 = 6;
        do do_ = this;
        if (do_.var_boolean_arr_a[n3]) {
            return n2 + this.int_b((byte)6, n2);
        }
        return n2;
    }

    public final int int_b() {
        if (this.var_boolean_b) {
            return (this.var_int_a << 2) / 5;
        }
        return this.var_int_a;
    }

    public final void void_i(byte by2) {
        cd cd2 = this.cd_a(by2);
        if (cd2 != null) {
            cd2.void_b(by2);
        }
    }

    final void j() {
        bj bj2 = di.bj_a();
        int n2 = 0;
        int n3 = bj2.int_a();
        for (int n4 = 0; n4 < n3; n4 = (int)((byte)(n4 + 1))) {
            as as2 = bj2.as_a(n4);
            if (!(as2 instanceof bm) || ((bm)as2).i < 0) continue;
            this.var_bm_arr_a[((bm)as2).i] = (bm)as2;
            byte by2 = (byte)(n2 + 1);
            n2 = by2;
            if (by2 == 7) break;
        }
    }

    private int int_g(byte by2) {
        int n2 = 0;
        bm[] bmArray = this.var_bm_arr_a;
        for (int i2 = 0; i2 < 7; ++i2) {
            if (bmArray[i2] == null) continue;
            n2 += bmArray[i2].int_a(by2);
        }
        return n2;
    }

    public final byte byte_a() {
        return this.var_byte_n;
    }

    private int int_h(byte by2) {
        if (this.var_bm_arr_a[by2] != null) {
            return this.var_bm_arr_a[by2].var_short_d;
        }
        return 0;
    }

    public final bm bm_a(byte by2) {
        if (by2 < 0) {
            return null;
        }
        return this.var_bm_arr_a[by2];
    }

    public final void a(byte by2, bm bm2) {
        if (bm2 != null) {
            this.j(by2);
            this.var_bm_arr_a[by2] = bm2;
            bm2.i = by2;
        }
    }

    public final void j(byte by2) {
        bm bm2 = this.bm_a(by2);
        if (bm2 != null) {
            this.a(bm2);
        }
    }

    public final void a(bm bm2) {
        if (bm2 != null && bm2.i >= 0) {
            this.var_bm_arr_a[bm2.i] = null;
            bm2.i = (byte)-1;
        }
    }

    public final boolean a(al al2) {
        do do_ = this;
        int n2 = 1;
        do do_2 = do_;
        do_2 = this;
        int n3 = do_.P[n2] + do_2.var_byte_n - al2.byte_a() - al2.int_a((byte)1) / 5;
        if (this.var_boolean_arr_b[4]) {
            n3 += n3 * 5 / 100;
        }
        return (al.var_java_util_Random_a.nextInt() & 0xFF) % 100 < n3;
    }

    private int int_i(byte by2) {
        byte by3 = by2;
        do do_ = this;
        if (do_.var_boolean_arr_a[by3]) {
            by3 = by2;
            do_ = this;
            return do_.int_b(by3, 1);
        }
        return 0;
    }

    private int int_a(byte by2, int n2) {
        byte by3 = by2;
        do do_ = this;
        if (do_.var_boolean_arr_a[by3]) {
            return this.int_b(by2, n2);
        }
        return 0;
    }

    private int int_b(byte by2, int n2) {
        int n3 = by2 * 3;
        by2 = (byte)(this.var_byte_arr_c[by2] + this.var_o_a.int_a((byte)5));
        return n2 * (this.var_byte_arr_b[n3] + this.var_byte_arr_b[n3 + 1] * by2) / this.var_byte_arr_b[n3 + 2];
    }

    public final byte byte_b(byte by2) {
        return this.var_byte_arr_c[by2];
    }

    public final void a(int n2, byte by2) {
        for (int i2 = 0; i2 < 4; ++i2) {
            if (this.var_byte_arr_a[i2] != by2) continue;
            this.var_byte_arr_a[i2] = -1;
        }
        this.l(n2);
        this.var_byte_arr_a[n2] = by2;
        this.var_boolean_arr_a[by2] = true;
        if (by2 == 1) {
            di.j();
        }
    }

    public final void l(int n2) {
        byte by2 = this.var_byte_arr_a[n2];
        if (by2 >= 0) {
            this.var_boolean_arr_a[by2] = false;
        }
        this.var_byte_arr_a[n2] = -1;
    }

    private void I() {
        this.var_byte_arr_a = new byte[4];
        for (int i2 = 0; i2 < 4; ++i2) {
            this.var_byte_arr_a[i2] = -1;
        }
    }

    public final boolean boolean_f(byte by2) {
        return this.var_boolean_arr_a[by2];
    }

    private void J() {
        int n2;
        this.var_boolean_arr_a = new boolean[20];
        for (n2 = 0; n2 < 20; ++n2) {
            this.var_boolean_arr_a[n2] = false;
        }
        for (n2 = 0; n2 < 4; ++n2) {
            if (this.var_byte_arr_a[n2] < 0) continue;
            this.var_boolean_arr_a[this.var_byte_arr_a[n2]] = true;
        }
    }

    public final void k() {
        this.void_b((byte)20, 100);
        this.var_boolean_f = true;
    }

    public final void b(byte by2, byte by3) {
        this.void_b((byte)21, 80);
        this.y = by3;
    }

    private void d(byte by2, int n2) {
        if (this.boolean_b(by2)) {
            this.var_java_util_Vector_b.addElement(new dn(by2, 10, -1));
        }
    }

    protected final void b(at at2) {
        switch (at2.var_byte_a) {
            case 41: 
            case 42: {
                if (this.var_int_e > 0) break;
                at2.var_boolean_a = true;
                return;
            }
            case 37: 
            case 38: {
                if (this.var_int_f > 0) break;
                at2.var_boolean_a = true;
                return;
            }
            case 6: {
                if (at2.var_int_b % 10 != 0) break;
                if (this.var_byte_b == 7 || this.var_byte_b == 6) {
                    at2.var_boolean_a = true;
                    return;
                }
                if (di.var_byte_d != 3) break;
                this.void_c(-this.var_int_n);
            }
        }
    }

    protected final void c(at at2) {
        switch (at2.var_byte_a) {
            case 20: {
                this.var_boolean_f = false;
                return;
            }
            case 21: {
                this.y = (byte)-1;
                return;
            }
            case 31: {
                int n2 = this.var_o_a.int_c((byte)1);
                this.void_a((byte)32, (byte)1, n2);
                this.var_boolean_g = true;
                return;
            }
            case 32: {
                this.var_boolean_g = false;
                this.G();
                return;
            }
            case 33: {
                int n3 = this.var_o_a.int_c((byte)2);
                this.void_a((byte)34, (byte)2, n3);
                this.var_boolean_h = true;
                return;
            }
            case 34: {
                this.var_boolean_h = false;
                this.H();
                return;
            }
            case 44: {
                this.var_boolean_a = false;
                return;
            }
            case 7: {
                this.var_boolean_b = false;
                if (this.var_int_d <= 1) break;
                this.var_int_d = 1;
                return;
            }
            case 6: {
                this.var_int_n = 0;
            }
        }
    }

    private boolean boolean_h(byte by2) {
        int n2;
        for (int i2 = n2 = this.var_java_util_Vector_b.size() - 1; i2 >= 0; --i2) {
            at at2 = (at)this.var_java_util_Vector_b.elementAt(i2);
            if (at2.var_byte_a != by2) continue;
            this.c(at2);
            this.var_java_util_Vector_b.removeElementAt(i2);
        }
        return false;
    }

    public final boolean boolean_a(boolean bl2) {
        block13: {
            if (this.var_byte_b == 7 || this.var_byte_b == 6) {
                return false;
            }
            if (di.var_int_arr_a[4] > 0) {
                return true;
            }
            Object object = di.as_a(bl2);
            if (object == null) {
                return false;
            }
            as as2 = object;
            object = this;
            if (as2 != null && as2.var_byte_a == 20) {
                int n2 = as2.var_byte_b;
                switch (n2) {
                    case 2: {
                        ((do)object).void_c(100);
                        break;
                    }
                    case 8: {
                        n2 = 300;
                        super.c((byte)1, n2);
                        break;
                    }
                    case 4: {
                        super.boolean_h((byte)7);
                        break;
                    }
                    case 5: {
                        super.boolean_h((byte)6);
                        break;
                    }
                    case 6: {
                        ((do)object).void_c(600);
                        break;
                    }
                    case 7: {
                        ((do)object).void_c(1000);
                    }
                    case 3: {
                        n2 = 80;
                        super.c((byte)1, n2);
                        break;
                    }
                    default: {
                        break block13;
                    }
                }
                object = di.bj_a(as2.var_byte_a);
                int n3 = ((bj)object).a(as2);
                ((bj)object).a(n3, 1);
                di.i();
            }
        }
        return true;
    }

    public final void l() {
        byte by2 = di.var_byte_b;
        do do_ = this;
        bj bj2 = di.bj_a((byte)20);
        bj2.a(as.a((byte)20, (byte)2), 5);
        di.a(true, (byte)2);
        byte by3 = di.boolean_a() ? (byte)13 : 12;
        Object object = (bm)as.a(by3, (byte)0);
        di.bj_a().a((as)object, 1);
        do_.a((byte)4, (bm)object);
        byte[] byArray = new byte[]{1, 4, 2, 5, 6, 4};
        object = byArray;
        object = (bm)as.a(byArray[by2], (byte)0);
        di.bj_a().a((as)object, 1);
        do_.a((byte)3, (bm)object);
        byte[] byArray2 = new byte[]{-1, 4, 7, 5, -1, -1};
        object = byArray2;
        by2 = byArray2[by2];
        if (by2 >= 0) {
            object = (bm)as.a(by2, (byte)0);
            di.bj_a().a((as)object, 1);
            do_.a((byte)5, (bm)object);
        }
        this.j();
    }

    public final void m(int n2) {
        byte by2 = this.var_byte_c;
        if (by2 == 1 || by2 == 2) {
            di.var_g_a.void_c(n2, by2);
            return;
        }
        di.var_g_a.void_b(n2, (int)by2);
    }

    public final void m() {
        int n2;
        do do_;
        if (!g.var_boolean_c || !this.var_boolean_i) {
            this.var_byte_a = 1;
            do_ = this;
            n2 = 3;
        } else {
            this.var_byte_a = (byte)(this.var_int_b > 0 ? 8 : 0);
            do_ = this;
            n2 = this.var_int_b > 0 ? 9 : 2;
        }
        do_.var_byte_j = (byte)n2;
    }

    public final void n(int n2) {
        this.var_int_b = n2;
        if (this.var_boolean_arr_b[6]) {
            this.var_int_b += n2 * 50 / 100;
        }
        this.O();
        this.var_byte_a = (byte)8;
        this.var_byte_j = (byte)9;
        this.void_a();
        rpg.e.var_ca_a.a(true);
        this.N();
        this.a(new bu(9));
    }

    private void K() {
        this.var_int_b = -1;
        this.P();
        this.var_byte_a = g.var_boolean_c ? (byte)0 : 1;
        this.var_byte_j = (byte)(g.var_boolean_c ? 2 : 3);
        this.void_a();
        rpg.e.var_ca_a.a(false);
        if (this.var_int_m > 0) {
            this.M();
            rpg.e.var_ca_a.a(true);
            return;
        }
        this.a(new bu(10));
    }

    public final void n() {
        this.var_o_a.e();
        if (this.var_int_b > 0) {
            return;
        }
        this.M();
        rpg.e.var_ca_a.a(true);
    }

    private void L() {
        this.N();
        if (this.var_int_b > 0) {
            return;
        }
        rpg.e.var_ca_a.a(false);
    }

    public final void o(int n2) {
        if (this.var_int_m < n2) {
            this.var_int_m = n2;
        }
    }

    private void M() {
        this.boolean_a((byte)9);
        this.d((byte)45, -1);
        this.d((byte)46, -1);
    }

    private void N() {
        this.boolean_a((byte)10);
        this.boolean_h((byte)45);
        this.boolean_h((byte)46);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final byte[] byte_arr_a() {
        byte[] byArray;
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            int n2;
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)filterOutputStream).writeByte(this.var_byte_n);
            ((DataOutputStream)filterOutputStream).writeShort(this.var_short_a);
            ((DataOutputStream)filterOutputStream).writeShort(this.var_short_b);
            for (n2 = 0; n2 < 4; ++n2) {
                ((DataOutputStream)filterOutputStream).writeInt(this.var_int_arr_a[n2]);
            }
            for (n2 = 0; n2 < 4; ++n2) {
                ((DataOutputStream)filterOutputStream).writeShort(this.var_short_arr_a[n2]);
            }
            ((OutputStream)filterOutputStream).write(this.var_byte_arr_d);
            ((OutputStream)filterOutputStream).write(this.var_byte_arr_c);
            ((OutputStream)filterOutputStream).write(this.var_byte_arr_a);
            byArray = byteArrayOutputStream.toByteArray();
        }
        catch (IOException iOException) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) return null;
                byteArrayOutputStream.close();
                return null;
            }
            catch (IOException iOException2) {
                return null;
            }
        }
        catch (Throwable throwable) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) throw throwable;
                byteArrayOutputStream.close();
                throw throwable;
            }
            catch (IOException iOException) {}
            throw throwable;
        }
        try {
            filterOutputStream.close();
            byteArrayOutputStream.close();
            return byArray;
        }
        catch (IOException iOException) {}
        return byArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = null;
        FilterInputStream filterInputStream = null;
        try {
            int n2;
            byteArrayInputStream = new ByteArrayInputStream(byArray);
            filterInputStream = new DataInputStream(byteArrayInputStream);
            this.var_byte_n = ((DataInputStream)filterInputStream).readByte();
            this.var_short_a = ((DataInputStream)filterInputStream).readShort();
            this.var_short_b = ((DataInputStream)filterInputStream).readShort();
            for (n2 = 0; n2 < 4; ++n2) {
                this.var_int_arr_a[n2] = ((DataInputStream)filterInputStream).readInt();
            }
            for (n2 = 0; n2 < 4; ++n2) {
                this.var_short_arr_a[n2] = ((DataInputStream)filterInputStream).readShort();
            }
            ((DataInputStream)filterInputStream).read(this.var_byte_arr_d);
            ((DataInputStream)filterInputStream).read(this.var_byte_arr_c);
            ((DataInputStream)filterInputStream).read(this.var_byte_arr_a);
            if (di.boolean_a((byte)2)) {
                this.o();
            }
            if (di.boolean_a((byte)1)) {
                this.p();
            }
        }
        catch (IOException iOException) {
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
                if (byteArrayInputStream == null) return;
                byteArrayInputStream.close();
                return;
            }
            catch (IOException iOException2) {
                return;
            }
        }
        catch (Throwable throwable) {
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
                if (byteArrayInputStream == null) throw throwable;
                byteArrayInputStream.close();
                throw throwable;
            }
            catch (IOException iOException) {}
            throw throwable;
        }
        try {
            filterInputStream.close();
            byteArrayInputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public final void o() {
        int n2 = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            if (this.var_short_arr_a[i2] <= 0) continue;
            n2 += this.var_short_arr_a[i2];
            this.var_short_arr_a[i2] = 0;
        }
        this.var_short_a = (short)(this.var_short_a + n2);
    }

    public final void p() {
        byte by2;
        int n2 = 0;
        for (by2 = 0; by2 < 48; ++by2) {
            if (this.var_byte_arr_d[by2] <= 0) continue;
            n2 += this.var_byte_arr_d[by2];
            this.var_byte_arr_d[by2] = 0;
        }
        for (by2 = 0; by2 < 20; ++by2) {
            if (this.var_byte_arr_c[by2] <= 0) continue;
            n2 += this.var_byte_arr_c[by2];
            this.var_byte_arr_c[by2] = 0;
        }
        this.var_short_b = (short)(this.var_short_b + n2);
        this.var_short_b = (short)(this.var_short_b - 36);
        this.y();
        for (by2 = 0; by2 < 2; by2 = (byte)(by2 + 1)) {
            di.void_a(by2, true);
        }
        this.I();
    }

    public final o o_a() {
        return this.var_o_a;
    }

    public final void k(byte by2) {
        this.a(new z(-6, by2, 2));
    }

    public final void p(int n2) {
        int n3 = 0;
        int n4 = 0;
        do do_ = this;
        do_.var_int_arr_a[n4] = n3;
        n3 = 0;
        n4 = 1;
        do_ = this;
        do_.var_int_arr_a[n4] = n3;
        this.k(50);
        this.r(50);
        this.void_b(true);
        this.v();
        ((du)this).h = (short)(this.s << 4);
        ((du)this).i = (short)(this.t << 4);
        this.E();
        this.u();
        this.void_a((byte)1);
    }

    public final boolean boolean_a() {
        return this.var_o_a.boolean_a();
    }

    public final boolean boolean_h() {
        return Math.max(10, 60 - this.var_short_c) < rpg.g.a(0, 99);
    }

    public final boolean boolean_g() {
        byte by2 = 11;
        do do_ = this;
        if (do_.var_boolean_arr_a[by2]) {
            by2 = 11;
            do_ = this;
            int n2 = do_.int_b(by2, 1);
            if (rpg.g.a(1, 99) > 100 - n2) {
                return false;
            }
        }
        return true;
    }

    public final int int_b(int n2) {
        int n3 = n2;
        int n4 = 7;
        do do_ = this;
        if (do_.var_boolean_arr_a[n4]) {
            n3 = this.int_b((byte)7, n2);
        }
        return n3;
    }

    public final void q(int n2) {
        int n3 = 0;
        int n4 = 0;
        if (this.var_boolean_a && n2 > 0) {
            n3 = this.var_o_a.int_a(n2);
        }
        if (this.var_boolean_arr_b[1] && n2 > 0) {
            n3 += n2 * 10 / 100;
        }
        int n5 = 16;
        do do_ = this;
        if (do_.var_boolean_arr_a[n5]) {
            n5 = 16;
            do_ = this;
            n4 = do_.int_b((byte)n5, 1);
        }
        n5 = 17;
        do_ = this;
        if (do_.var_boolean_arr_a[n5]) {
            n5 = 17;
            do_ = this;
            n3 += do_.int_b((byte)n5, 1);
        }
        if (this.var_boolean_arr_b[3] && n2 > 0) {
            n4 += n2 * 5 / 100;
        }
        if (n3 > 0) {
            this.void_c(n3);
        }
        if (n4 > 0) {
            n5 = n4;
            do_ = this;
            do_.c((byte)1, n5);
        }
        this.F();
    }

    public final byte byte_c() {
        byte by2 = 0;
        byte by3 = 12;
        do do_ = this;
        if (do_.var_boolean_arr_a[by3] && rpg.g.a(0, 99) < 25) {
            by3 = 12;
            do_ = this;
            by2 = (byte)(0 + do_.int_b(by3, 1));
        }
        return by2;
    }

    public final int int_c(int n2) {
        int n3 = 18;
        do do_ = this;
        if (do_.var_boolean_arr_a[n3]) {
            return this.int_b((byte)18, n2);
        }
        return n2;
    }

    public final void c(int n2, int n3) {
        if (this.var_byte_b == 7 || this.var_byte_b == 6) {
            return;
        }
        if (this.boolean_b()) {
            return;
        }
        this.var_int_n = this.var_int_arr_b[0] / n3;
        this.boolean_a((byte)6, n2);
    }

    public final void g(int n2) {
        if (this.var_byte_b == 7 || this.var_byte_b == 6) {
            return;
        }
        if (this.var_boolean_arr_b[5]) {
            return;
        }
        if (this.boolean_b()) {
            return;
        }
        if (!this.var_boolean_b) {
            this.var_boolean_b = true;
            this.boolean_a((byte)7, n2);
            this.f(n2);
        }
    }

    private boolean boolean_b() {
        if (di.var_byte_b == 2 && this.y > 1) {
            this.a(new ak(19));
            return true;
        }
        return false;
    }

    private void O() {
        if (((al)this).f <= 8) {
            ((al)this).f = (byte)(((al)this).f << 1);
        }
    }

    private void P() {
        if (this.var_int_d > 1) {
            ((al)this).f = (byte)4;
            return;
        }
        if (this.var_boolean_arr_b[2] || this.var_int_b > 1) {
            ((al)this).f = (byte)16;
            return;
        }
        ((al)this).f = (byte)8;
    }

    private boolean boolean_a(int n2) {
        int n3 = 0;
        for (byte by2 = 0; by2 < 7; by2 = (byte)(by2 + 1)) {
            bm bm2 = this.bm_a(by2);
            if (bm2 == null || bm2.f != n2) continue;
            ++n3;
        }
        return n3 > 2;
    }

    private void s(int n2) {
        switch (n2) {
            case 0: {
                this.var_boolean_arr_b[0] = true;
                return;
            }
            case 1: {
                this.var_boolean_arr_b[1] = true;
                return;
            }
            case 2: {
                this.var_boolean_arr_b[2] = true;
                return;
            }
            case 3: {
                this.var_boolean_arr_b[1] = true;
                this.var_boolean_arr_b[3] = true;
                this.var_boolean_arr_b[4] = true;
                return;
            }
            case 4: {
                this.var_boolean_arr_b[1] = true;
                this.var_boolean_arr_b[4] = true;
                this.var_boolean_arr_b[5] = true;
                return;
            }
            case 5: {
                this.var_boolean_arr_b[4] = true;
                this.var_boolean_arr_b[6] = true;
            }
        }
    }

    public final void l(byte by2) {
        this.var_byte_i = by2;
        this.void_a((byte)99);
    }

    public static boolean boolean_g(byte by2) {
        return by2 < 4;
    }

    protected final void x() {
        if (this.var_int_d == 0 && !((du)this).j && !((du)this).k) {
            this.var_int_d = -1;
            this.P();
        }
    }

    public final void q() {
        if (di.boolean_c() || this.var_byte_b == 3) {
            this.void_b(0);
            this.var_byte_m = 0;
            this.var_o_a.a(false);
        }
        di.e();
    }

    static {
        var_byte_h = (byte)-1;
        var_int_p = 5;
        var_long_a = 0L;
        var_boolean_c = false;
    }
}

