/*
 * Decompiled with CFR 0.152.
 */
final class x
extends ea {
    private int var_int_a = 0;
    private int b;
    private final int[] var_int_arr_a = new int[]{1, 2, 3};
    private byte[][] var_byte_arr_arr_a = new byte[][]{"[A]".getBytes(), "[a]".getBytes(), "[1]".getBytes()};

    public x(int n2) {
        super("");
        this.var_int_a = n2;
        this.b = 0;
    }

    public final String java_lang_String_a() {
        return super.java_lang_String_a();
    }

    public final boolean a(int n2, int n3) {
        if (n2 == -6) {
            x x2 = this;
            this.b = (x2.b + 1) % x2.var_int_arr_a.length;
        }
        return true;
    }

    public final byte[] byte_arr_a() {
        return this.var_byte_arr_arr_a[this.b];
    }
}

