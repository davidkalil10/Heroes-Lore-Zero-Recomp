/*
 * Decompiled with CFR 0.152.
 */
public final class ca
extends s {
    private cg[][] b;

    public final void a() {
        this.b = new cg[4][];
        aj aj2 = new aj("/hero/0/t");
        this.b[0] = aj2.cg_arr_a();
        int n2 = aj2.int_a();
        cg[] cgArray = new cg[n2];
        byte[] byArray = this.var_byte_arr_arr_a[0];
        n2 = byArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            cgArray[byArray[i2]] = aj2.cg_b(byArray[i2]);
        }
        this.b[1] = cgArray;
    }

    public final void a(boolean bl2) {
        int n2 = 2;
        if (bl2) {
            if (this.var_cg_arr_arr_a[0] != this.b[0]) {
                this.b[2] = this.var_cg_arr_arr_a[0];
                this.b[3] = this.var_cg_arr_arr_a[0 + this.var_byte_a];
            }
            n2 = 0;
        }
        this.var_cg_arr_arr_a[0] = this.b[n2];
        this.var_cg_arr_arr_a[0 + this.var_byte_a] = this.b[n2 + 1];
    }

    public final void a(int n2) {
        if (n2 >= this.var_byte_a) {
            return;
        }
        if (this.var_cg_arr_arr_a[n2] != null) {
            this.var_cg_arr_arr_a[n2] = null;
        }
        if (this.var_cg_arr_arr_a[n2 + this.var_byte_a] != null) {
            this.var_cg_arr_arr_a[n2 + this.var_byte_a] = null;
        }
    }
}

