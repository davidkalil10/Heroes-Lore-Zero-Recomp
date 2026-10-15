/*
 * Decompiled with CFR 0.152.
 */
final class cb {
    private byte[] var_byte_arr_a = null;
    public short[] var_short_arr_a = null;
    public short var_short_a = 0;
    public m var_m_a = null;

    cb(db db2) {
    }

    public final int a(byte[] byArray, int n2, int n3) {
        this.var_short_a = byArray[n2++];
        if (this.var_short_a < 0) {
            this.var_short_a = (short)(256 + this.var_short_a);
        }
        this.var_short_arr_a = new short[this.var_short_a + 1];
        int n4 = 0;
        this.var_short_arr_a[0] = 0;
        for (short s2 = 0; s2 < this.var_short_a; s2 = (short)(s2 + 1)) {
            short s3 = (short)(byArray[n2] < 0 ? 256 + byArray[n2] : byArray[n2]);
            if (n3 > 1) {
                s3 = (short)(s3 + ((short)(byArray[++n2] < 0 ? 256 + byArray[n2] : byArray[n2]) << 8));
            }
            this.var_short_arr_a[s2 + 1] = n4 = (int)((short)(n4 + s3));
            ++n2;
        }
        this.var_byte_arr_a = null;
        if (n4 > 0) {
            this.var_byte_arr_a = new byte[n4];
            System.arraycopy(byArray, n2, this.var_byte_arr_a, 0, n4);
            n2 += n4;
        }
        this.var_m_a = m.a(this.var_byte_arr_a);
        return n2;
    }
}

