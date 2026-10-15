/*
 * Decompiled with CFR 0.152.
 */
final class cz {
    private int b = 10;
    int var_int_a = 0;
    m[] var_m_arr_a = new m[this.b];

    public cz(db db2) {
    }

    public final void a(m m2) {
        if (this.var_int_a >= this.b) {
            m[] mArray = new m[this.b + 5];
            for (int i2 = 0; i2 < this.b + 5; ++i2) {
                mArray[i2] = i2 < this.var_int_a ? this.var_m_arr_a[i2] : null;
            }
            this.var_m_arr_a = null;
            this.var_m_arr_a = mArray;
            this.b += 5;
        }
        this.var_m_arr_a[this.var_int_a++] = m2;
    }
}

