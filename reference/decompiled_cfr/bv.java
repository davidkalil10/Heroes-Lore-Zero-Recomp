/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;
import rpg.c;
import rpg.d;
import rpg.e;
import rpg.f;

public final class bv
extends a {
    private byte var_byte_b = 0;
    private static bv var_bv_a;
    private cg var_cg_a;
    private int j;
    private static boolean var_boolean_b;
    private static cg var_cg_b;
    private static long var_long_a;

    public static bv bv_a() {
        if (var_bv_a == null) {
            var_bv_a = new bv();
        }
        return var_bv_a;
    }

    public final void void_a() {
    }

    public final void b() {
        rpg.a.e = 3;
        if (this.var_byte_b == 2) {
            bq.var_long_a = 0L;
            bq.a();
        }
    }

    public static void d() {
        if (var_bv_a != null) {
            var_bv_a = null;
        }
    }

    protected final boolean boolean_a(int n2, int n3) {
        if (n2 != 0) {
            return true;
        }
        n2 = ct.a(n3);
        switch (this.var_byte_b) {
            case 1: {
                break;
            }
            case 4: {
                switch (n2) {
                    case 2: {
                        n3 = 52;
                        break;
                    }
                    case 5: {
                        n3 = 54;
                        break;
                    }
                    case 8: {
                        n3 = 53;
                    }
                }
                switch (n3) {
                    case -6: 
                    case 53: {
                        if (var_boolean_b) {
                            rpg.c.var_byte_a = (byte)3;
                            rpg.c.var_boolean_c = true;
                            rpg.c.var_boolean_b = true;
                            bq.b((byte)0, true);
                        } else {
                            rpg.c.var_byte_a = 0;
                            rpg.c.var_boolean_c = false;
                            rpg.c.var_boolean_b = false;
                            bq.b((byte)0);
                        }
                        this.b((byte)2);
                        break;
                    }
                    case 52: {
                        var_boolean_b = !var_boolean_b;
                        break;
                    }
                    case 54: {
                        var_boolean_b = !var_boolean_b;
                        break;
                    }
                    case -7: {
                        rpg.c.var_byte_a = 0;
                        rpg.c.var_boolean_c = false;
                        rpg.c.var_boolean_b = false;
                        bq.b((byte)0);
                        this.b((byte)2);
                    }
                }
                break;
            }
            case 2: {
                rpg.c.rpg_c_a().d();
            }
        }
        return true;
    }

    protected final void d(cm object) {
        rpg.a.var_cm_a = object;
        switch (this.var_byte_b) {
            case 3: {
                rpg.a.b(rpg.a.var_cm_a);
                break;
            }
            case 1: {
                cf.a();
                cm cm2 = rpg.a.var_cm_a;
                object = this;
                rpg.a.a(cm2, 0);
                rpg.a.var_cm_a.b(((bv)object).j < 25 ? ((bv)object).j * 10 : 255);
                if (((bv)object).var_cg_a != null) {
                    cm2.a(((bv)object).var_cg_a, rpg.a.c, rpg.a.d, 3);
                }
                ++((bv)object).j;
                if (((bv)object).j <= 50) break;
                super.b((byte)4);
                break;
            }
            case 4: {
                cm cm3 = rpg.a.var_cm_a;
                object = this;
                rpg.a.c(cm3);
                eb.f(cm3, rpg.f.c, rpg.a.d + 15, rpg.d.e_, 70);
                cm3.a(15723216);
                cm3.d(rpg.f.c, rpg.a.d + 15, rpg.d.e_ - 1, 69);
                cm3.a(0);
                ac.a(cm3, rpg.a.c, rpg.a.d + 25, rpg.e.var_ch_a.a(26), 0, 1);
                object = cm3;
                int n2 = rpg.a.d + 58;
                ((cm)object).a(0x660000);
                if (var_boolean_b) {
                    ((cm)object).a(rpg.a.c - 50 - 25, n2, 50, 20);
                    ((cm)object).a(0xFFFFFF);
                    ac.a((cm)object, rpg.a.c - 50, n2 + 4, rpg.e.var_ch_a.a(0), 0, 1);
                    ((cm)object).a(0);
                    ac.a((cm)object, rpg.a.c + 50, n2 + 4, rpg.e.var_ch_a.a(1), 0, 1);
                    break;
                }
                ((cm)object).a(rpg.a.c + 25, n2, 50, 20);
                ((cm)object).a(0);
                ac.a((cm)object, rpg.a.c - 50, n2 + 4, rpg.e.var_ch_a.a(0), 0, 1);
                ((cm)object).a(0xFFFFFF);
                ac.a((cm)object, rpg.a.c + 50, n2 + 4, rpg.e.var_ch_a.a(1), 0, 1);
                break;
            }
            case 2: {
                cm cm4 = rpg.a.var_cm_a;
                object = this;
                rpg.a.c(cm4);
                if (((bv)object).j % 10 < 8) {
                    cm4.a(0xFFFFFF);
                    ac.a(cm4, rpg.a.c, rpg.a.d + (rpg.a.d >> 1), rpg.d.C, 0, 1);
                }
                ++((bv)object).j;
                if (((bv)object).j <= 124) break;
                ((bv)object).j = 1;
            }
        }
        rpg.c.e();
    }

    public final void run() {
        if (this.var_byte_b == 3) {
            switch (this.var_byte_a) {
                case 1: {
                    rpg.c.rpg_c_a().i();
                    rpg.b.void_b();
                    rpg.a.c();
                    String string = "/ealogo.png";
                    Object object = this;
                    this.var_cg_a = cg.a(string);
                    rpg.a.c();
                    rpg.e.rpg_e_a().void_a();
                    rpg.a.c();
                    bq.b(0);
                    rpg.a.c();
                    rpg.e.f();
                    rpg.a.c();
                    di.m();
                    rpg.a.c();
                    var_long_a = System.currentTimeMillis() - var_long_a;
                    if (var_long_a < 2000L) {
                        try {
                            Thread.sleep(2000L - var_long_a);
                        }
                        catch (Exception exception) {
                            object = exception;
                            exception.printStackTrace();
                        }
                    }
                    this.b((byte)1);
                }
            }
            this.var_byte_a = (byte)-1;
        }
    }

    public final void a(byte by2) {
        this.var_byte_a = 1;
        this.b((byte)3);
        new Thread(var_bv_a).start();
    }

    private void b(byte by2) {
        this.var_byte_b = by2;
        this.j = 0;
        switch (this.var_byte_b) {
            case 3: {
                rpg.a.a(false);
                return;
            }
        }
        rpg.c.rpg_c_a().h();
    }

    static {
        var_boolean_b = true;
        var_cg_b = null;
        var_long_a = 0L;
    }
}

