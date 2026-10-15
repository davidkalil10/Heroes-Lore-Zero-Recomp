/*
 * Decompiled with CFR 0.152.
 */
final class m {
    private byte[] var_byte_arr_a = null;
    private int var_int_a = 0;
    private int b = 0;

    public static m a(m m2) {
        m m3 = m2;
        m2 = new m();
        new m().var_byte_arr_a = m3.var_byte_arr_a;
        m2.var_int_a = m3.var_int_a;
        m2.b = m3.b;
        return m2;
    }

    public static m a(byte[] object) {
        byte[] byArray = object;
        object = new m();
        new m().var_byte_arr_a = byArray;
        byArray = object;
        byArray.a(0, byArray.var_byte_arr_a != null ? byArray.var_byte_arr_a.length : 0);
        return object;
    }

    private m() {
    }

    public final void a(int n2) {
        this.var_int_a = n2;
    }

    public final void a(int n2, int n3) {
        this.var_int_a = n2;
        this.b = n3;
    }

    public final int int_a() {
        return this.var_int_a;
    }

    public final void a(byte[] byArray, int n2) {
        if (this.var_byte_arr_a != null) {
            System.arraycopy(this.var_byte_arr_a, this.var_int_a, byArray, 0, n2);
            this.var_int_a += n2;
        }
    }

    public final byte byte_a() {
        if (this.var_byte_arr_a != null) {
            return this.var_byte_arr_a[this.var_int_a++];
        }
        return 0;
    }

    public final short short_a() {
        short s2;
        if (this.var_byte_arr_a == null) {
            return 0;
        }
        if ((s2 = (short)this.var_byte_arr_a[this.var_int_a++]) < 0) {
            s2 = (short)(s2 + 256);
        }
        return (short)(s2 + (this.var_byte_arr_a[this.var_int_a++] << 8));
    }

    public final int b() {
        if (this.var_byte_arr_a == null) {
            return 0;
        }
        int n2 = this.var_byte_arr_a[this.var_int_a++];
        int n3 = this.var_byte_arr_a[this.var_int_a++];
        if (n2 < 0) {
            n2 += 256;
        }
        if (n3 < 0) {
            n3 += 256;
        }
        return n2 += n3 << 8;
    }

    public final boolean boolean_a() {
        return this.var_int_a >= this.b;
    }
}

