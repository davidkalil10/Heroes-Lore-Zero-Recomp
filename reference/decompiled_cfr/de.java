/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import rpg.b;
import rpg.e;
import rpg.g;

public abstract class de
extends p
implements Runnable {
    public static String var_java_lang_String_a;
    protected static boolean e;
    protected static int var_int_f;
    protected static bj[] var_bj_arr_a;
    protected boolean var_boolean_f = true;
    protected static byte[] var_byte_arr_a;
    protected static byte[] b;

    public de(n n2, byte by2) {
        super(n2, by2);
    }

    protected final void a() {
        di.var_long_a = di.var_long_arr_a[di.j] = System.currentTimeMillis();
        di.var_long_b = di.var_long_arr_a[di.j];
        di.l();
    }

    public de(n n2, byte by2, byte by3, byte by4) {
        super(n2, by2, by3, by4);
    }

    public final void run() {
        de.h();
        di.m();
    }

    protected final void a(byte[] byArray, boolean bl2, boolean bl3) {
        if (bl2) {
            this.c();
            this.var_n_b = new br((n)this, rpg.e.var_ch_h.a(4));
        }
    }

    public final void g() {
        byte[] byArray = c.a((byte)30, null);
        this.a(byArray, true, false);
    }

    protected static void h() {
        int n2;
        byte[] byArray = rpg.b.byte_arr_b();
        if (byArray == null) {
            byArray = new byte[6];
            var_int_f = 0;
            g.a(0, byArray, 0);
            byArray[4] = 84;
            byArray[5] = 0;
            rpg.b.b(byArray);
        }
        int n3 = 0;
        var_int_f = g.int_a(byArray, 0);
        n3 += 4;
        ++n3;
        int n4 = byArray[4];
        int n5 = (n4 - 1) / 28 + 1;
        if (n5 <= 0) {
            n5 = 1;
        }
        var_bj_arr_a = new bj[n5];
        n5 = 0;
        while (n4 > 0) {
            n2 = Math.min(28, n4);
            n4 -= n2;
            de.var_bj_arr_a[n5++] = new bj((byte)n2);
        }
        ++n3;
        n2 = byArray[5];
        n5 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            n4 = byArray[n3++];
            byte[] byArray2 = new byte[n4];
            System.arraycopy(byArray, n3, byArray2, 0, n4);
            n3 += n4;
            as as2 = as.a(byArray2);
            if (as2 == null) continue;
            var_bj_arr_a[n5].a(as2, (int)as2.c);
            if (var_bj_arr_a[n5].int_a() < de.var_bj_arr_a[n5].var_byte_a) continue;
            ++n5;
        }
    }

    protected static void i() {
        try {
            int n2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(var_int_f);
            dataOutputStream.writeByte(84);
            int n3 = 0;
            for (n2 = 0; n2 < 3; ++n2) {
                n3 += var_bj_arr_a[n2].int_a();
            }
            dataOutputStream.writeByte(n3);
            for (n2 = 0; n2 < 3; ++n2) {
                n3 = var_bj_arr_a[n2].int_a();
                for (int i2 = 0; i2 < n3; ++i2) {
                    Object object = var_bj_arr_a[n2].as_a(i2);
                    if (object == null) continue;
                    object = as.a((as)object);
                    dataOutputStream.writeByte(((Object)object).length);
                    ((OutputStream)dataOutputStream).write((byte[])object);
                }
            }
            rpg.b.b(byteArrayOutputStream.toByteArray());
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public static final void j() {
        if (c.a()) {
            c.a(false);
        }
        di.g();
        var_bj_arr_a = null;
        bq.e();
    }

    protected void b(cm cm2) {
    }

    static {
        var_java_lang_String_a = null;
        e = false;
        var_int_f = 0;
        var_bj_arr_a = null;
        var_byte_arr_a = null;
        b = null;
    }
}

