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
import rpg.d;
import rpg.e;

public final class o
implements d {
    private static final byte[] var_byte_arr_b;
    private byte[] var_byte_arr_c;
    private byte[] var_byte_arr_d;
    private boolean[] var_boolean_arr_a;
    public byte[] var_byte_arr_a;
    private byte var_byte_a;
    private byte var_byte_b = 0;
    private byte var_byte_c;
    private byte[] O;
    private byte[] P;
    private do var_do_a;
    private boolean var_boolean_a = false;
    private final byte[] Q = new byte[]{12, 12, 4, 2};
    private byte var_byte_d;
    private byte e;

    public o(do do_) {
        this.var_do_a = do_;
    }

    final void void_a() {
        this.var_byte_arr_c = new byte[10];
        this.var_byte_arr_d = new byte[10];
        for (int i2 = 4; i2 < 10; ++i2) {
            this.var_byte_arr_d[i2] = -1;
            this.var_byte_arr_c[i2] = -1;
        }
        this.g();
        this.a(false);
        this.var_boolean_a = false;
    }

    private void g() {
        this.var_byte_arr_a = new byte[2];
        for (int i2 = 0; i2 < 2; ++i2) {
            this.var_byte_arr_a[i2] = -1;
        }
    }

    public final void a(boolean bl2) {
        this.h();
        if (bl2) {
            o o2 = this;
            if (o2.var_boolean_a) {
                int n2 = di.var_byte_arr_b[2];
                byte by2 = di.var_byte_arr_b[3];
                for (int i2 = 0; i2 < 10; ++i2) {
                    if (i2 == n2 || i2 == by2 || rpg.e.var_s_arr_a[i2] == null) continue;
                    rpg.e.var_s_arr_a[i2] = null;
                }
                o2.var_boolean_a = false;
            }
        }
    }

    final void void_b() {
        if (this.var_byte_b == 0) {
            return;
        }
        byte by2 = this.var_byte_c = (byte)(this.var_byte_c + 1);
        o o2 = this;
        if (by2 == 0) {
            o.void_b(o2.var_byte_a);
        }
        switch (o2.var_byte_a) {
            case 0: {
                byte by3 = by2;
                o o3 = o2;
                switch (by3) {
                    case 0: {
                        g.a(1);
                        break;
                    }
                    case 1: {
                        int n2;
                        o3.var_do_a.void_f();
                        cd cd2 = o3.var_do_a.cd_a();
                        if (cd2 != null) {
                            n2 = o3.e((byte)0);
                            cd2.a(n2, o3.var_do_a.var_byte_c);
                            cd2.a(new cr(30, 0, 1));
                        }
                    }
                    case 3: 
                    case 5: {
                        int n2 = 2 - by3 / 2 + 1;
                        di.var_g_a.void_c(n2, 1);
                    }
                }
                break;
            }
            case 1: {
                if (by2 != 0) break;
                o.a((byte)31, (byte)1, 1);
                break;
            }
            case 2: {
                if (by2 != 0) break;
                o.a((byte)33, (byte)2, 1);
                break;
            }
            case 3: {
                if (by2 != 0) break;
                int n3 = o2.b((byte)3, o2.var_do_a.int_f((byte)0)) + o2.int_c((byte)3);
                o2.var_do_a.void_c(n3);
                o2.var_do_a.a(new cr(35, 3, 1));
                break;
            }
            case 4: {
                byte by4 = by2;
                o o4 = o2;
                switch (by4) {
                    case 3: 
                    case 7: 
                    case 11: 
                    case 15: {
                        g.a(1);
                        break;
                    }
                    default: {
                        g.b(0);
                    }
                }
                int n4 = 0;
                switch (by4) {
                    case 1: {
                        n4 = -5;
                        break;
                    }
                    case 5: 
                    case 8: 
                    case 10: 
                    case 13: {
                        n4 = 4;
                        break;
                    }
                    case 12: {
                        bq.a((byte)2);
                    }
                    case 9: 
                    case 14: 
                    case 17: 
                    case 19: {
                        n4 = 6;
                        break;
                    }
                    case 20: {
                        n4 = 3;
                    }
                }
                if (n4 != 0) {
                    di.var_g_a.void_c(n4, n4 < 0 ? 2 : 1);
                }
                switch (by4) {
                    case 0: {
                        o4.a((byte)36, (byte)4, 1, false);
                        break;
                    }
                    case 4: 
                    case 8: {
                        bq.a((byte)1);
                    }
                    case 1: 
                    case 6: 
                    case 10: 
                    case 12: 
                    case 14: 
                    case 16: {
                        int n5 = o4.e((byte)4);
                        o4.d(n5);
                    }
                }
                break;
            }
            case 5: {
                if (by2 != 0) break;
                o2.var_do_a.var_int_f = o2.int_c((byte)5);
                o.a((byte)38, (byte)5, -1);
                o.a((byte)37, (byte)5, -1);
                break;
            }
            case 6: {
                int n6;
                byte by5 = by2;
                o o5 = o2;
                switch (by5) {
                    case 0: {
                        o5.a((byte)40, (byte)6, 1, true);
                        break;
                    }
                    case 5: 
                    case 9: {
                        di.var_g_a.void_c(2, 2);
                        break;
                    }
                    case 12: {
                        di.var_g_a.a(new dq(true, 0xFFFF57, o5.Q, o5.var_byte_d << 4, o5.e << 4));
                        break;
                    }
                    case 14: {
                        g.a(1);
                        break;
                    }
                    case 15: 
                    case 16: {
                        g.b(0);
                    }
                    case 17: 
                    case 18: {
                        di.var_g_a.void_c(3 * (19 - by5), 2);
                    }
                }
                if (by5 != 5 && by5 != 9 && by5 != 15) break;
                int n7 = n6 = o5.e((byte)6);
                o o6 = o5;
                for (byte by6 = 1; by6 <= 8; by6 = (byte)(by6 + 1)) {
                    cd cd3 = o6.cd_a(by6);
                    if (cd3 == null) continue;
                    cd3.a(n7, by6);
                    cd3.c(60);
                }
                bq.a(by5 == 15 ? (byte)2 : 3);
                break;
            }
            case 7: {
                if (by2 != 0) break;
                byte by7 = 7;
                o o7 = o2;
                o2.var_do_a.var_int_e = o7.b(by7, 1) + o2.int_c((byte)7);
                o.a((byte)41, (byte)7, -1);
                o.a((byte)42, (byte)7, -1);
                break;
            }
            case 8: {
                byte by8 = by2;
                o o8 = o2;
                switch (by8) {
                    case 0: {
                        o8.a((byte)43, (byte)8, 1, true);
                        break;
                    }
                    case 3: {
                        o8.var_do_a.k(30);
                        g.a(1);
                        break;
                    }
                    case 23: {
                        di.var_g_a.void_c(1, 2);
                        break;
                    }
                    default: {
                        if (by8 <= 4 || by8 >= 22 || by8 % 2 != 1) break;
                        di.var_g_a.void_c(3, 2);
                    }
                }
                if (by8 >= 5 && by8 <= 21) {
                    int n8 = o8.e((byte)8);
                    o8.d(n8);
                }
                if (by8 % 7 != 6) break;
                o.void_b((byte)8);
                break;
            }
            case 9: {
                if (by2 != 0) break;
                int n9 = o2.int_c((byte)9);
                o2.var_do_a.var_boolean_a = true;
                o.a((byte)44, (byte)9, n9);
            }
        }
        if (by2 >= var_byte_arr_b[o2.var_byte_a]) {
            o2.h();
        }
    }

    private void h() {
        this.var_byte_b = 0;
        this.var_byte_c = (byte)-1;
        this.var_byte_a = (byte)-1;
    }

    public final byte byte_a(byte by2) {
        return this.var_byte_arr_c[by2];
    }

    public final byte byte_b(byte by2) {
        return this.var_byte_arr_d[by2];
    }

    public final boolean boolean_a(byte by2) {
        byte by3 = by2;
        this.var_byte_arr_c[by3] = (byte)(this.var_byte_arr_c[by3] + 1);
        return o.boolean_a(this.var_byte_arr_c);
    }

    public final boolean boolean_b(byte by2) {
        byte by3 = by2;
        this.var_byte_arr_d[by3] = (byte)(this.var_byte_arr_d[by3] + 1);
        return o.boolean_a(this.var_byte_arr_d);
    }

    public final boolean boolean_c(byte by2) {
        return this.var_boolean_arr_a[by2];
    }

    public final void a(int n2, byte by2) {
        for (int i2 = 0; i2 < 2; ++i2) {
            if (this.var_byte_arr_a[i2] != by2) continue;
            this.var_byte_arr_a[i2] = -1;
        }
        this.void_a(n2);
        this.var_byte_arr_a[n2] = by2;
        this.var_boolean_arr_a[by2] = true;
    }

    public final void void_a(int n2) {
        byte by2 = this.var_byte_arr_a[n2];
        if (by2 >= 0) {
            this.var_boolean_arr_a[by2] = false;
        }
        this.var_byte_arr_a[n2] = -1;
    }

    public final void c() {
        int n2;
        this.var_boolean_arr_a = new boolean[10];
        for (n2 = 0; n2 < 10; ++n2) {
            this.var_boolean_arr_a[n2] = false;
        }
        for (n2 = 0; n2 < 2; ++n2) {
            if (this.var_byte_arr_a[n2] < 0) continue;
            this.var_boolean_arr_a[this.var_byte_arr_a[n2]] = true;
        }
    }

    private static boolean boolean_a(byte[] byArray) {
        int n2;
        if (byArray[4] >= 0) {
            return false;
        }
        int n3 = 0;
        for (n2 = 0; n2 < 4; ++n2) {
            n3 += byArray[n2];
        }
        if (n3 >= 6) {
            for (n2 = 4; n2 < 10; ++n2) {
                if (byArray[n2] >= 0) continue;
                byArray[n2] = 0;
            }
            return true;
        }
        return false;
    }

    public final void b(int n2) {
        if ((n2 = di.var_byte_arr_b[n2]) < 0) {
            return;
        }
        if (rpg.e.var_s_arr_a[n2] != null) {
            return;
        }
        o.void_a((byte)n2);
        this.var_boolean_a = true;
    }

    public final void d() {
        o.void_a((byte)10);
    }

    private int e(byte by2) {
        byte by3 = by2;
        o o2 = this;
        by2 = (byte)(o2.b(by3, 1) + this.int_c(by2));
        return this.var_do_a.int_c((int)by2);
    }

    public final boolean a(cd cd2) {
        byte by2 = 5;
        o o2 = this;
        int n2 = o2.b(by2, 1);
        if (rpg.g.a(1, 100) > n2) {
            if (cd2 instanceof af) {
                cd2.a(new z(-3));
                return false;
            }
            cd2.a(new cr(39, 5, 1));
            return true;
        }
        return false;
    }

    public static void c(int n2) {
        switch (n2) {
            case 7: {
                g.a(1);
                return;
            }
            case 8: {
                g.b(0);
                return;
            }
            case 9: {
                di.var_g_a.void_c(2, 2);
            }
        }
    }

    public final int int_a(int n2) {
        return this.b((byte)9, n2);
    }

    public final boolean boolean_a() {
        byte by2 = 9;
        o o2 = this;
        return rpg.g.a(1, 100) < o2.a(by2, 1);
    }

    private static void a(byte by2, byte by3, int n2) {
        di.var_do_a.void_a(by2, by3, n2);
    }

    public final int int_a(byte by2) {
        return this.a(by2, 1);
    }

    public final int a(byte by2, int n2) {
        byte by3 = by2;
        o o2 = this;
        if (!o2.var_boolean_arr_a[by3]) {
            return 0;
        }
        int n3 = by2 * 3;
        by3 = by2;
        o2 = this;
        int n4 = this.P[n3] + this.P[n3 + 1] * o2.var_byte_arr_d[by3];
        by2 = (byte)n4;
        return n4 * n2 / this.P[n3 + 2];
    }

    private int b(byte by2, int n2) {
        int n3 = by2 * 8;
        return n2 * (this.O[n3] + this.O[n3 + 1] * this.var_byte_arr_c[by2]) / this.O[n3 + 2];
    }

    public final int int_b(byte by2) {
        return this.b(by2, 1);
    }

    public final int int_c(byte by2) {
        by2 = (byte)(by2 << 3);
        byte by3 = this.O[by2 + 3];
        by2 = this.O[by2 + 7];
        return di.var_do_a.int_a((byte)3) / by3 + by2;
    }

    public final int int_d(byte by2) {
        short s2 = rpg.g.short_b(this.O, (by2 << 3) + 5);
        by2 = (byte)s2;
        return s2;
    }

    public final boolean boolean_d(byte n2) {
        if (n2 < 0) {
            return false;
        }
        if (this.var_byte_b != 0) {
            return false;
        }
        if (this.var_byte_a != -1) {
            return false;
        }
        int n3 = n2;
        o o2 = this;
        n3 = o2.O[(n3 << 3) + 4];
        n3 -= o2.a((byte)8, n3);
        int n4 = n3;
        if (n3 > di.var_do_a.int_c()) {
            this.var_do_a.k((byte)1);
            return false;
        }
        this.var_byte_a = (byte)n2;
        di.var_do_a.i(-n4);
        di.void_b((byte)n2, false);
        n3 = n2;
        o o3 = this;
        switch (n3) {
            case 1: {
                n2 = 7;
                break;
            }
            case 2: {
                n2 = 6;
                break;
            }
            case 5: {
                n2 = 1;
                break;
            }
            case 9: {
                n2 = 8;
                break;
            }
            default: {
                o3.var_do_a.void_a((byte)10);
                o3.var_do_a.var_int_c = 0;
                return true;
            }
        }
        n3 = o3.int_c((byte)n3) * n2;
        o3.var_do_a.o(n3);
        o3.var_do_a.n();
        return false;
    }

    public final void e() {
        this.var_byte_c = (byte)-1;
        this.var_byte_b = 1;
    }

    private void d(int n2) {
        this.b((byte)1, (byte)12, n2);
        this.b((byte)17, (byte)24, n2);
    }

    private void b(byte by2, byte by3, int n2) {
        for (byte by4 = by2; by4 <= by3; by4 = (byte)(by4 + 1)) {
            cd cd2 = this.cd_a(by4);
            if (cd2 == null) continue;
            cd2.boolean_b(n2);
        }
    }

    private cd cd_a(byte by2) {
        du du2 = du.a(this.var_byte_d, this.e, by2, (byte)0, (byte)0);
        if (du2 != null && du2 instanceof cd && !(du2 instanceof h)) {
            return (cd)du2;
        }
        return null;
    }

    private void a(byte by2, byte by3, int n2, boolean bl2) {
        o o2 = this;
        this.var_byte_d = o2.var_do_a.s;
        o2.e = o2.var_do_a.t;
        di.var_g_a.a(new dm(by2, by3, 1, ((du)this.var_do_a).h, ((du)this.var_do_a).i, bl2));
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
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((OutputStream)filterOutputStream).write(this.var_byte_arr_c);
            ((OutputStream)filterOutputStream).write(this.var_byte_arr_d);
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

    private void i() {
        byte by2;
        int n2 = 0;
        for (by2 = 0; by2 < this.var_byte_arr_c.length; ++by2) {
            if (this.var_byte_arr_c[by2] <= 0) continue;
            n2 += this.var_byte_arr_c[by2];
            this.var_byte_arr_c[by2] = 0;
        }
        for (by2 = 0; by2 < this.var_byte_arr_d.length; ++by2) {
            if (this.var_byte_arr_d[by2] <= 0) continue;
            n2 += this.var_byte_arr_d[by2];
            this.var_byte_arr_d[by2] = 0;
        }
        di.var_do_a.var_short_b = (short)(di.var_do_a.var_short_b + n2);
        this.g();
        for (by2 = 0; by2 < 2; by2 = (byte)(by2 + 1)) {
            di.void_a(by2, false);
        }
    }

    /*
     * Loose catch block
     */
    public final void void_a(byte[] object) {
        FilterInputStream filterInputStream;
        ByteArrayInputStream byteArrayInputStream;
        block14: {
            byteArrayInputStream = null;
            filterInputStream = null;
            byteArrayInputStream = new ByteArrayInputStream((byte[])object);
            filterInputStream = new DataInputStream(byteArrayInputStream);
            ((DataInputStream)filterInputStream).read(this.var_byte_arr_c);
            ((DataInputStream)filterInputStream).read(this.var_byte_arr_d);
            ((DataInputStream)filterInputStream).read(this.var_byte_arr_a);
            if (!di.boolean_a((byte)4)) break block14;
            this.i();
        }
        try {
            filterInputStream.close();
            byteArrayInputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
        catch (IOException iOException) {
            try {
                object = iOException;
                iOException.printStackTrace();
            }
            catch (Throwable throwable) {
                try {
                    if (filterInputStream != null) {
                        filterInputStream.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                }
                catch (IOException iOException2) {}
                throw throwable;
            }
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return;
            }
            catch (IOException iOException3) {
                return;
            }
        }
    }

    public final void f() {
        this.O = rpg.e.a("/s/d/a");
        this.P = new byte[30];
        this.P = rpg.e.a("/s/d/p");
    }

    private static void void_a(byte by2) {
        rpg.e.var_s_arr_a[by2] = s.s_a("/s/cif/" + by2, "/s/" + by2);
    }

    private static void void_b(byte by2) {
        switch (by2) {
            case 0: 
            case 4: {
                by2 = 1;
                break;
            }
            case 8: {
                by2 = (byte)2;
                break;
            }
            default: {
                return;
            }
        }
        bq.a(by2);
    }

    public final boolean boolean_b() {
        int n2 = 5 + this.var_do_a.int_a((byte)3);
        byte by2 = 6;
        o o2 = this;
        int n3 = n2 + o2.a(by2, 1);
        return rpg.g.a(0, 99) < n3;
    }

    static {
        var_byte_arr_b = new byte[]{6, 0, 0, 0, 21, 0, 21, 0, 23, 0};
    }
}

