/*
 * Decompiled with CFR 0.152.
 */
import rpg.d;

public abstract class db {
    private static cb var_cb_a;
    private static cb b;
    private static cz var_cz_a;
    private static m var_m_a;
    private static byte[] var_byte_arr_a;
    private static int var_int_a;
    private static byte[][] var_byte_arr_arr_a;
    private static boolean var_boolean_a;

    public final int int_a(byte[] object, int n2) {
        db.void_a();
        var_m_a = null;
        var_cz_a = new cz(this);
        var_cb_a = new cb(this);
        b = new cb(this);
        n2 = var_cb_a.a((byte[])object, n2, 1);
        n2 = b.a((byte[])object, n2, 2);
        int n3 = object[n2] < 0 ? 256 + object[n2] : object[n2];
        ++n2;
        var_byte_arr_arr_a = null;
        if (n3 > 0) {
            int n4;
            var_byte_arr_arr_a = new byte[n3][];
            for (n4 = 0; n4 < n3; ++n4) {
                int n5 = object[n2] < 0 ? 256 + object[n2] : object[n2];
                ++n2;
                db.var_byte_arr_arr_a[n4] = new byte[n5];
            }
            for (n4 = 0; n4 < n3; ++n4) {
                System.arraycopy(object, n2, var_byte_arr_arr_a[n4], 0, var_byte_arr_arr_a[n4].length);
                n2 += var_byte_arr_arr_a[n4].length + 1;
            }
        }
        object = var_cz_a;
        var_cz_a.var_int_a = 0;
        return n2;
    }

    public static void void_a() {
        var_cb_a = null;
        b = null;
        var_cz_a = null;
        var_m_a = null;
        var_byte_arr_a = null;
        var_int_a = 0;
        var_byte_arr_arr_a = null;
        var_boolean_a = false;
    }

    protected static boolean boolean_a() {
        return var_cb_a != null && b != null && var_cz_a != null;
    }

    protected static void void_b() {
        var_boolean_a = true;
    }

    public static final byte[] byte_arr_a(int n2) {
        if (var_byte_arr_arr_a == null) {
            return d.p;
        }
        if (n2 >= var_byte_arr_arr_a.length) {
            return d.p;
        }
        return var_byte_arr_arr_a[n2];
    }

    public static final void void_c() {
        var_m_a = null;
    }

    protected static final void void_a(int n2) {
        var_cz_a.a(var_m_a);
        var_m_a = m.a(db.b.var_m_a);
        int n3 = var_int_a;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 += var_byte_arr_a[i2] < 0 ? 256 + var_byte_arr_a[i2] : var_byte_arr_a[i2];
        }
        var_m_a.a(n3, n3 + (var_byte_arr_a[n2] < 0 ? 256 + var_byte_arr_a[n2] : var_byte_arr_a[n2]));
        var_byte_arr_a = null;
    }

    private final boolean a(m m2) {
        boolean bl2 = false;
        while (!m2.boolean_a()) {
            byte by2 = m2.byte_a();
            if (by2 >= 0 && by2 < db.b.var_short_a) {
                m m3 = m.a(db.b.var_m_a);
                m3.a(db.b.var_short_arr_a[by2], (int)db.b.var_short_arr_a[by2 + 1]);
                var_cz_a.a(m3);
                bl2 = true;
                continue;
            }
            if (by2 == -1) {
                int n2;
                int n3 = m2.byte_a();
                byte[] byArray = new byte[n3];
                for (n2 = 0; n2 < n3; ++n2) {
                    byArray[n2] = m2.byte_a();
                }
                m m4 = m.a(m2);
                int n4 = m2.int_a();
                int n5 = m2.int_a();
                for (n2 = 0; n2 < n3; ++n2) {
                    n5 += byArray[n2];
                }
                for (n2 = 0; n2 < n3; ++n2) {
                    m4.a(n4, n4 + byArray[n2]);
                    if (this.a(m4)) {
                        bl2 = true;
                        break;
                    }
                    n4 += byArray[n2];
                }
                m2.a(n5);
                continue;
            }
            if (this.a((byte)(-2 - by2), m2)) continue;
            return bl2;
        }
        return bl2;
    }

    public final boolean boolean_a(int n2) {
        if (var_cb_a == null || b == null) {
            return false;
        }
        if (var_m_a != null) {
            return false;
        }
        if (n2 >= db.var_cb_a.var_short_arr_a.length - 1 || n2 < 0) {
            return false;
        }
        m m2 = db.var_cb_a.var_m_a;
        m2.a(db.var_cb_a.var_short_arr_a[n2], (int)db.var_cb_a.var_short_arr_a[n2 + 1]);
        this.a(m2);
        return db.var_cz_a.var_int_a > 0;
    }

    public final boolean boolean_b() {
        if (var_cb_a == null || b == null) {
            return false;
        }
        if (var_byte_arr_a != null) {
            return true;
        }
        do {
            boolean bl2;
            block13: {
                int n2;
                Object object;
                if (var_m_a == null) {
                    m m2;
                    object = var_cz_a;
                    if (((cz)object).var_int_a > 0) {
                        m m3 = ((cz)object).var_m_arr_a[0];
                        for (n2 = 1; n2 < ((cz)object).var_int_a; ++n2) {
                            ((cz)object).var_m_arr_a[n2 - 1] = ((cz)object).var_m_arr_a[n2];
                        }
                        ((cz)object).var_m_arr_a[((cz)object).var_int_a - 1] = null;
                        --((cz)object).var_int_a;
                        m2 = m3;
                    } else {
                        m2 = var_m_a = null;
                    }
                }
                if (var_m_a == null) continue;
                object = this;
                byte by2 = 0;
                m m4 = var_m_a;
                while (!m4.boolean_a()) {
                    byte by3 = m4.byte_a();
                    n2 = 0;
                    if (by3 == -1) {
                        by2 = m4.byte_a();
                        n2 = m4.byte_a();
                    }
                    if (n2 == 0) {
                        if (((db)object).b(by3, m4)) continue;
                        bl2 = false;
                    } else {
                        byte[] byArray = new byte[n2];
                        var_byte_arr_a = new byte[n2];
                        int n3 = 0;
                        for (int i2 = 0; i2 < n2; ++i2) {
                            byArray[i2] = m4.byte_a();
                            db.var_byte_arr_a[i2] = m4.byte_a();
                            n3 += var_byte_arr_a[i2] < 0 ? 256 + var_byte_arr_a[i2] : var_byte_arr_a[i2];
                        }
                        var_int_a = m4.int_a();
                        ((db)object).a(by2, byArray);
                        m4.a(m4.int_a() + n3);
                        bl2 = false;
                    }
                    break block13;
                }
                var_m_a = null;
                bl2 = true;
            }
            if (bl2) continue;
            return true;
        } while (db.var_cz_a.var_int_a > 0);
        if (var_boolean_a) {
            var_boolean_a = false;
            return this.boolean_a(1);
        }
        return false;
    }

    protected abstract boolean a(byte var1, m var2);

    protected abstract boolean b(byte var1, m var2);

    protected abstract void a(byte var1, byte[] var2);

    static {
        var_cb_a = null;
        b = null;
        var_cz_a = null;
        var_m_a = null;
        var_byte_arr_a = null;
        var_int_a = 0;
        var_byte_arr_arr_a = null;
        var_boolean_a = false;
    }
}

