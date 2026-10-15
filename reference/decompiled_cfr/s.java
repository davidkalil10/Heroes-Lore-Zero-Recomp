/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;
import rpg.g;

public class s
implements d {
    private byte[] var_byte_arr_a;
    private int[] var_int_arr_a;
    private byte[] b;
    protected byte var_byte_a;
    public byte[][] var_byte_arr_arr_a;
    protected cg[][] var_cg_arr_arr_a;

    public final void a(int n2, String object, byte[] byArray) {
        int n3;
        object = new aj((String)object);
        if (byArray != null) {
            int n4 = 0;
            ++n4;
            n3 = byArray[0];
            for (int n5 = 0; n5 < n3; n5 = (byte)(n5 + 1)) {
                int n6 = g.int_b(byArray, n4);
                int n7 = g.int_b(byArray, n4 += 4);
                n4 += 4;
                ((aj)object).void_a(n6, n7);
            }
        }
        this.var_cg_arr_arr_a[n2] = ((aj)object).cg_arr_a();
        byte[] byArray2 = this.var_byte_arr_arr_a[n2];
        if (byArray2 != null) {
            this.var_cg_arr_arr_a[n2 + this.var_byte_a] = new cg[((aj)object).int_a()];
            for (n3 = 0; n3 < byArray2.length; ++n3) {
                this.var_cg_arr_arr_a[n2 + this.var_byte_a][byArray2[n3]] = ((aj)object).cg_b(byArray2[n3]);
            }
        }
    }

    public final void a(byte[] byArray, boolean bl2) {
        int n2;
        int n3;
        int n4 = byArray[0];
        int n5 = n4 + 1;
        this.var_byte_a = n4;
        this.var_cg_arr_arr_a = new cg[n4 * (bl2 ? 2 : 1)][];
        this.var_byte_arr_arr_a = new byte[n4][];
        for (n3 = 0; n3 < n4; ++n3) {
            n2 = byArray[n5++];
            byte by2 = byArray[n5++];
            this.var_byte_arr_arr_a[n3] = new byte[n2];
            System.arraycopy(byArray, n5, this.var_byte_arr_arr_a[n3], 0, n2);
            n5 += by2 + n2;
        }
        n3 = byArray[n5++];
        this.var_int_arr_a = new int[n3];
        this.b = new byte[n3];
        n4 = n5;
        for (n2 = 0; n2 < n3; ++n2) {
            this.var_int_arr_a[n2] = n5 - n4;
            this.b[n2] = byArray[n5++];
            for (int i2 = 0; i2 < this.b[n2]; ++i2) {
                for (int i3 = 0; i3 < 4; ++i3) {
                    byte by3 = byArray[n5++];
                    n5 += by3 * 4;
                }
            }
        }
        n2 = n5 - n4;
        this.var_byte_arr_a = new byte[n2];
        System.arraycopy(byArray, n4, this.var_byte_arr_a, 0, n2);
    }

    public final int a(byte n2, byte by2, int n3, int n4, int n5) {
        int n6;
        int n7 = this.var_int_arr_a[n2];
        ++n7;
        if (n3 >= this.b[n2] || n3 < 0) {
            n3 = 0;
        }
        for (n6 = 0; n6 < n3; ++n6) {
            for (int i2 = 0; i2 < 4; ++i2) {
                n2 = this.var_byte_arr_a[n7++];
                n7 += n2 << 2;
            }
        }
        for (n6 = 0; n6 < by2 - 1; ++n6) {
            n2 = this.var_byte_arr_a[n7++];
            n7 += n2 << 2;
        }
        n2 = this.var_byte_arr_a[n7++];
        cm cm2 = rpg.a.var_cm_a;
        for (int i3 = 0; i3 < n2; ++i3) {
            n6 = this.var_byte_arr_a[n7] & 0x7F;
            cg[] cgArray = this.var_cg_arr_arr_a[n6 += this.var_byte_arr_a[n7] >> 7 == 0 ? (byte)0 : this.var_byte_a];
            n6 = this.var_byte_arr_a[n7 + 1];
            if (cgArray != null && cgArray[n6] != null) {
                cm2.a(cgArray[n6], n4 + this.var_byte_arr_a[n7 + 2], n5 + this.var_byte_arr_a[n7 + 3], 20);
            }
            n7 += 4;
        }
        return n3;
    }

    public final byte a(byte by2) {
        return this.b[by2];
    }

    public final void void_a(String object, String string) {
        object = e.a((String)object);
        this.a((byte[])object, false);
        object = new aj(string);
        this.var_cg_arr_arr_a[0] = ((aj)object).cg_arr_a();
    }

    public static s s_a(String object, String string) {
        object = e.a((String)object);
        s s2 = new s();
        s2.a((byte[])object, true);
        s2.a(0, string, null);
        return s2;
    }
}

