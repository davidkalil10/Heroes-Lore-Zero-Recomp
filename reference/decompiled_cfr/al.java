/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import java.util.Vector;
import rpg.d;

public abstract class al
extends du {
    protected Vector var_java_util_Vector_a;
    protected Vector var_java_util_Vector_b;
    protected byte var_byte_b;
    protected byte var_byte_c;
    protected byte var_byte_d;
    protected byte e = 0;
    protected int var_int_c;
    protected byte f = (byte)8;
    protected int var_int_d = -1;
    protected static Random var_java_util_Random_a;

    public al(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, by2, by3);
        al al2 = this;
        this.var_byte_b = 1;
        al2.var_int_c = 0;
        al2.var_byte_d = al2.var_byte_c;
        al2.var_int_d = -1;
        al2.s();
    }

    final void r() {
        this.var_java_util_Vector_a = new Vector(3);
    }

    void s() {
        this.r();
        this.var_java_util_Vector_b = new Vector(3);
    }

    void void_a(byte by2) {
        this.var_byte_b = by2;
        this.var_int_c = -1;
    }

    final void void_c(byte by2) {
        this.var_byte_c = this.var_byte_d = by2;
    }

    final void d(int n2) {
        if (this.var_int_c >= n2) {
            this.var_int_c = 0;
        }
    }

    final void a(at at2) {
        int n2 = at2.var_byte_a;
        al al2 = this;
        if (at.a((byte)n2)) {
            for (int i2 = n2 = al2.var_java_util_Vector_a.size() - 1; i2 >= 0; --i2) {
                at at3 = (at)al2.var_java_util_Vector_a.elementAt(i2);
                if (!at.a(at3.var_byte_a)) continue;
                at3.var_boolean_a = true;
            }
        }
        this.var_java_util_Vector_a.addElement(at2);
    }

    void void_b(byte by2, int n2) {
        if (this.boolean_b(by2)) {
            this.var_java_util_Vector_b.addElement(new ak(by2, n2));
        }
    }

    void void_a(byte by2, byte by3, int n2) {
        if (this.boolean_b(by2)) {
            this.var_java_util_Vector_b.addElement(new cr(by2, by3, n2));
        }
    }

    boolean boolean_a(byte by2) {
        if (this.boolean_b(by2)) {
            this.var_java_util_Vector_b.addElement(new bu(by2));
            return true;
        }
        return false;
    }

    boolean boolean_a(byte by2, int n2) {
        if (this.boolean_b(by2)) {
            this.var_java_util_Vector_b.addElement(new bu(by2, n2));
            return true;
        }
        return false;
    }

    final boolean boolean_b(byte by2) {
        for (int i2 = this.var_java_util_Vector_b.size() - 1; i2 >= 0; --i2) {
            at at2 = (at)this.var_java_util_Vector_b.elementAt(i2);
            if (at2.var_byte_a != by2) continue;
            return false;
        }
        return true;
    }

    protected final void t() {
        for (int i2 = this.var_java_util_Vector_b.size() - 1; i2 >= 0; --i2) {
            at at2 = (at)this.var_java_util_Vector_b.elementAt(i2);
            if (at2.var_boolean_a) {
                this.c(at2);
                this.var_java_util_Vector_b.removeElementAt(i2);
                continue;
            }
            this.b(at2);
        }
    }

    protected void b(at at2) {
    }

    protected void c(at at2) {
    }

    void void_c() {
        if (this.var_int_d > 0) {
            --this.var_int_d;
        }
        this.x();
    }

    final boolean boolean_d() {
        if (this.var_byte_b == 2 || this.var_byte_b == 5) {
            if (!this.boolean_e()) {
                this.e(this.f);
                return true;
            }
            this.void_h();
        }
        return false;
    }

    protected boolean boolean_e() {
        if (this.j || this.k) {
            return false;
        }
        if (!di.var_g_a.a(this, this.var_byte_c)) {
            this.void_a((byte)1);
            return true;
        }
        return false;
    }

    protected final void e(int n2) {
        this.v();
        this.h = (short)(this.h + rpg.d.H[this.var_byte_c] * n2);
        this.i = (short)(this.i + rpg.d.I[this.var_byte_c] * n2);
        this.E();
        this.u();
    }

    abstract void void_h();

    protected void u() {
        g g2 = di.var_g_a;
        for (byte by2 = 0; by2 < this.u; by2 = (byte)(by2 + 1)) {
            g2.var_du_arr_arr_a[this.t][this.s + by2] = this;
            if (this.k) {
                g2.var_du_arr_arr_a[this.t + 1][this.s + by2] = this;
                continue;
            }
            if (!this.j) continue;
            g2.var_du_arr_arr_a[this.t][this.s + 1 + by2] = this;
        }
    }

    protected void v() {
        g g2 = di.var_g_a;
        for (byte by2 = 0; by2 < this.u; by2 = (byte)(by2 + 1)) {
            g2.var_du_arr_arr_a[this.t][this.s + by2] = null;
            if (this.k) {
                g2.var_du_arr_arr_a[this.t + 1][this.s + by2] = null;
                continue;
            }
            if (!this.j) continue;
            g2.var_du_arr_arr_a[this.t][this.s + 1 + by2] = null;
        }
    }

    protected final void d(int n2, int n3) {
        for (int i2 = this.var_java_util_Vector_a.size() - 1; i2 >= 0; --i2) {
            at at2 = (at)this.var_java_util_Vector_a.elementAt(i2);
            at2.a(n2, n3, true);
            if (!at2.var_boolean_a) continue;
            this.var_java_util_Vector_a.removeElementAt(i2);
        }
    }

    protected final void b(int n2, int n3, boolean bl2) {
        for (int i2 = this.var_java_util_Vector_b.size() - 1; i2 >= 0; --i2) {
            at at2 = (at)this.var_java_util_Vector_b.elementAt(i2);
            at2.a(n2, n3, bl2);
        }
    }

    protected final du a(byte by2, du du2) {
        int n2;
        int n3 = this.t + rpg.d.I[by2];
        if (n3 < 0 || n3 >= g.var_byte_d) {
            return null;
        }
        g g2 = di.var_g_a;
        for (int i2 = 0; i2 < this.u && (n2 = this.s + rpg.d.H[by2] + i2) >= 0 && n2 < g.var_byte_c; ++i2) {
            du du3 = g2.var_du_arr_arr_a[n3][n2];
            if (du3 == this || du3 == null || du2 != null && (du2 == null || du3 != du2)) continue;
            return du3;
        }
        return null;
    }

    protected final boolean boolean_f() {
        return this.boolean_c(this.var_byte_c);
    }

    protected final boolean boolean_c(byte by2) {
        int n2 = this.s + rpg.d.H[by2];
        byte by3 = this.t + rpg.d.I[by2];
        if (n2 >= g.var_byte_c || by3 >= g.var_byte_d || n2 < 0 || by3 < 0) {
            return false;
        }
        if (!di.var_g_a.d(n2, by3)) {
            return false;
        }
        g g2 = di.var_g_a;
        by3 = rpg.d.L[by2];
        byte by4 = rpg.d.M[by2];
        byte by5 = rpg.d.J[by2];
        byte by6 = rpg.d.K[by2];
        if (g2.a(this, by4) && g2.a(this, by6)) {
            this.e = by2;
            this.void_a((byte)2);
            this.void_c(by4);
            return true;
        }
        if (g2.a(this, by3) && g2.a(this, by5)) {
            this.e = by2;
            this.void_a((byte)2);
            this.void_c(by3);
            return true;
        }
        return false;
    }

    protected final void w() {
        if (this.e != 0 && !this.j && !this.k) {
            this.void_c(this.e);
            this.e = 0;
        }
    }

    protected void void_b(byte by2) {
        if (di.var_g_a.a(this, by2)) {
            this.v();
            this.h = (short)(this.h + (rpg.d.H[by2] << 4));
            this.i = (short)(this.i + (rpg.d.I[by2] << 4));
            this.E();
            this.u();
        }
    }

    public boolean a(al al2) {
        return true;
    }

    public int int_b(byte by2) {
        return 0;
    }

    public int int_a() {
        return 0;
    }

    public byte byte_a() {
        return 1;
    }

    public int int_a(byte by2) {
        return 0;
    }

    public int int_b() {
        return 0;
    }

    boolean a(al al2, int n2, byte by2) {
        return false;
    }

    boolean a(do do_, byte by2, int n2, boolean bl2, byte by3, byte by4, boolean bl3, boolean bl4, boolean bl5) {
        return false;
    }

    protected final void void_d(byte by2) {
        this.f = by2;
    }

    protected final cd cd_a(byte by2) {
        du du2 = this.a(by2, null);
        if (du2 != null && du2 instanceof cd && !(du2 instanceof h)) {
            return (cd)du2;
        }
        return null;
    }

    protected final void f(int n2) {
        if (this.var_int_d > 0) {
            return;
        }
        this.var_int_d = n2;
        byte by2 = (byte)(this.f >> 1);
        al al2 = this;
        this.f = by2;
    }

    protected void x() {
        if (this.var_int_d == 0 && !this.j && !this.k) {
            this.var_int_d = -1;
            byte by2 = (byte)(this.f << 1);
            al al2 = this;
            this.f = by2;
        }
    }

    protected void a(al al2, int n2, byte by2, byte by3) {
    }

    public boolean boolean_g() {
        return true;
    }

    public boolean boolean_h() {
        return false;
    }

    public void c(int n2, int n3) {
    }

    public void g(int n2) {
    }

    protected final boolean boolean_i() {
        int n2;
        int n3 = 0;
        for (int i2 = n2 = this.var_java_util_Vector_b.size() - 1; i2 >= 0; --i2) {
            at at2 = (at)this.var_java_util_Vector_b.elementAt(i2);
            if (at2 == null) continue;
            at2.var_boolean_a = true;
            this.c(at2);
            this.var_java_util_Vector_b.removeElementAt(i2);
            ++n3;
        }
        return n3 > 0;
    }

    protected final Vector java_util_Vector_a(byte by2) {
        int n2;
        int n3;
        int n4;
        Vector<du> vector = new Vector<du>(4);
        g g2 = di.var_g_a;
        int n5 = this.s - 4;
        if (n5 < 0) {
            n5 = 0;
        }
        if ((n4 = this.t - 4) < 0) {
            n4 = 0;
        }
        if ((n3 = this.s + 4 + 1) > g2.var_du_arr_arr_a[0].length) {
            n3 = g2.var_du_arr_arr_a[0].length;
        }
        if ((n2 = this.t + 4) > g2.var_du_arr_arr_a.length) {
            n2 = g2.var_du_arr_arr_a.length;
        }
        while (n4 < n2) {
            for (int i2 = n5; i2 < n3; ++i2) {
                if (g2.var_du_arr_arr_a[n4][i2] == null || g2.var_du_arr_arr_a[n4][i2] == this || !(g2.var_du_arr_arr_a[n4][i2] instanceof al)) continue;
                vector.addElement(g2.var_du_arr_arr_a[n4][i2]);
            }
            ++n4;
        }
        return vector;
    }

    static {
        var_java_util_Random_a = new Random();
    }
}

