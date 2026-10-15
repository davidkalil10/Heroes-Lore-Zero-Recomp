/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

public final class ch {
    private Object[] var_java_lang_Object_arr_a;
    private short var_short_a;

    public ch(String object) {
        object = e.a(((String)object).concat(".tdf"));
        int n2 = 0;
        ++n2;
        this.var_short_a = (short)(object[0] & 0xFF);
        this.var_java_lang_Object_arr_a = new Object[this.var_short_a];
        for (int i2 = 0; i2 < this.var_short_a; ++i2) {
            int n3 = (object[n2++] & 0xFF) << 8;
            this.var_java_lang_Object_arr_a[i2] = new byte[n3 += object[n2++] & 0xFF];
            System.arraycopy(object, n2, this.var_java_lang_Object_arr_a[i2], 0, n3);
            n2 += n3;
        }
    }

    public final byte[] a(int n2) {
        return (byte[])this.var_java_lang_Object_arr_a[n2];
    }

    public final byte[][] a(int n2, int n3) {
        return this.a(new int[]{n2, n3});
    }

    public final byte[][] a(int n2, int n3, int n4) {
        return this.a(new int[]{n2, n3, n4});
    }

    public final byte[][] a(int n2, int n3, int n4, int n5) {
        return this.a(new int[]{n2, n3, n4, 25});
    }

    public final byte[][] a(int[] nArray) {
        byte[][] byArrayArray = new byte[nArray.length][];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            byArrayArray[i2] = (byte[])(nArray[i2] < 0 ? null : this.a(nArray[i2]));
        }
        return byArrayArray;
    }
}

