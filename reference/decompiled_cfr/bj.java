/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;
import rpg.d;

public final class bj
implements d {
    private Vector var_java_util_Vector_a = new Vector(1);
    public byte var_byte_a;

    public bj(byte by2) {
        this.var_byte_a = by2;
    }

    public final int int_a() {
        return this.var_java_util_Vector_a.size();
    }

    public final as as_a(int n2) {
        if (n2 >= this.var_java_util_Vector_a.size() || n2 < 0) {
            return null;
        }
        return (as)this.var_java_util_Vector_a.elementAt(n2);
    }

    public final int a(as as2) {
        return this.var_java_util_Vector_a.indexOf(as2);
    }

    private boolean a(as as2, byte by2) {
        if (this.var_java_util_Vector_a.size() >= this.var_byte_a) {
            return false;
        }
        as2.c = by2;
        this.var_java_util_Vector_a.addElement(as2);
        return true;
    }

    private final boolean c(byte by2, byte by3, int n2) {
        as as2 = this.as_a(n2);
        return as2 != null && as2.var_byte_a == by2 && as2.var_byte_b == by3;
    }

    public final boolean a(byte by2, byte by3, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        block5: {
            n6 = 0;
            bj bj2 = this;
            n6 = bj2.var_java_util_Vector_a.size();
            for (n5 = 0; n5 < n6; ++n5) {
                if (bj2.var_java_util_Vector_a.elementAt(n5) != null) continue;
                n4 = (byte)n5;
                break block5;
            }
            n4 = n3 = n6 < bj2.var_byte_a ? (int)(n6 + 1) : -1;
        }
        if (n4 != -1) {
            return true;
        }
        if (!bj.a(by2)) {
            return false;
        }
        n5 = this.var_java_util_Vector_a.size();
        for (int i2 = 0; i2 < n5; ++i2) {
            if (!this.c(by2, by3, i2)) continue;
            bj bj3 = this;
            n6 = i2;
            as as2 = bj3.as_a(n6);
            byte by4 = as2 != null ? as2.c : (byte)0;
            n3 = by4;
            if (by4 + n2 <= 99) {
                return true;
            }
            n2 -= 99 - n3;
        }
        return false;
    }

    public final int a(as as2, int n2) {
        if (!this.a(as2.var_byte_a, as2.var_byte_b, n2)) {
            return 0;
        }
        if (!bj.a(as2.var_byte_a)) {
            this.a(as2, (byte)1);
            return 1;
        }
        int n3 = as2.var_byte_b;
        byte by2 = as2.var_byte_a;
        Object object = this;
        Object object2 = new byte[((bj)object).var_byte_a];
        int n4 = 0;
        int n5 = ((bj)object).var_java_util_Vector_a.size();
        for (int n6 = 0; n6 < n5; n6 = (int)((byte)(n6 + 1))) {
            if (!((bj)object).c(by2, (byte)n3, n6)) continue;
            object2[n4++] = n6;
        }
        byte[] byArray = new byte[n4];
        System.arraycopy(object2, 0, byArray, 0, n4);
        byte[] byArray2 = n4 == 0 ? null : byArray;
        object = byArray2;
        if (byArray2 != null) {
            n3 = n2;
            for (n4 = 0; n4 < ((Object)object).length; ++n4) {
                as as3 = this.as_a((int)object[n4]);
                object2 = as3;
                by2 = as3.c;
                if (by2 == 99) continue;
                byte by3 = object2.c = (byte)((n3 += by2) > 99 ? 99 : (byte)n3);
                if ((n3 -= object2.c) > 0) continue;
                return n2;
            }
            if (this.a(as2, (byte)n3)) {
                return n2;
            }
            return n2 - n3;
        }
        if (this.a(as2, (byte)n2)) {
            return n2;
        }
        return 0;
    }

    public final boolean b(byte by2, byte by3, int n2) {
        for (byte by4 = (byte)(this.var_java_util_Vector_a.size() - 1); by4 >= 0; by4 = (byte)(by4 - 1)) {
            as as2;
            if (!this.c(by2, by3, by4) || (as2 = (as)this.var_java_util_Vector_a.elementAt(by4)).c()) continue;
            int n3 = as2.c < n2 ? (int)as2.c : n2;
            this.a((int)by4, n3);
            if ((n2 -= n3) > 0) continue;
            this.void_b();
            return true;
        }
        this.void_b();
        return false;
    }

    public final void a(int n2, int n3) {
        as as2 = this.as_a(n2);
        if (as2 != null) {
            as2.c = (byte)(as2.c - n3);
            if (as2.c <= 0) {
                this.void_a(n2);
            }
        }
    }

    public final void void_a(int n2) {
        this.var_java_util_Vector_a.removeElementAt(n2);
    }

    public final void void_a() {
        for (int i2 = this.var_java_util_Vector_a.size() - 1; i2 >= 0; --i2) {
            as as2 = (as)this.var_java_util_Vector_a.elementAt(i2);
            if (as2.var_byte_a != 19) continue;
            this.var_java_util_Vector_a.removeElementAt(i2);
        }
    }

    public final byte[] a(byte by2, byte by3, boolean bl2, byte by4) {
        bl2 = false;
        int n2 = this.var_java_util_Vector_a.size();
        byte[] byArray = new byte[n2];
        for (int n3 = 0; n3 < n2; n3 = (int)((byte)(n3 + 1))) {
            as as2 = (as)this.var_java_util_Vector_a.elementAt(n3);
            if (as2 == null || as2.var_byte_a != by2 && as2.var_byte_a != by3 || as2 instanceof bm && ((bm)as2).i >= 0 || ((bm)as2).var_byte_d > by4) continue;
            byArray[bl2] = n3;
            bl2 += 1;
        }
        if (!bl2) {
            return null;
        }
        byte[] byArray2 = new byte[bl2];
        System.arraycopy(byArray, 0, byArray2, 0, bl2 ? 1 : 0);
        return byArray2;
    }

    public final int int_a(byte by2, byte by3) {
        return this.a(by2, by3, false);
    }

    public final int a(byte by2, byte by3, boolean bl2) {
        int n2 = 0;
        for (int i2 = 0; i2 < this.var_java_util_Vector_a.size(); ++i2) {
            as as2 = (as)this.var_java_util_Vector_a.elementAt(i2);
            if (bl2 && as2 != null && as2.c() || as2 == null || as2.var_byte_a != by2 || as2.var_byte_b != by3) continue;
            n2 += as2.c;
        }
        return n2;
    }

    public final as as_a(byte by2, byte by3) {
        int n2;
        int n3;
        block2: {
            byte by4 = by3;
            by3 = (byte)20;
            bj bj2 = this;
            int n4 = bj2.var_java_util_Vector_a.size();
            for (int n5 = 0; n5 < n4; n5 = (int)((byte)(n5 + 1))) {
                if (!bj2.c(by3, by4, n5)) continue;
                n3 = n5;
                break block2;
            }
            n3 = n2 = -1;
        }
        if (n3 == -1) {
            return null;
        }
        return (as)this.var_java_util_Vector_a.elementAt(n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final byte[] byte_arr_a() {
        byte[] byArray;
        int n2 = this.var_java_util_Vector_a.size();
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)filterOutputStream).writeByte(n2);
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = (as)this.var_java_util_Vector_a.elementAt(i2);
                if (object == null) {
                    ((DataOutputStream)filterOutputStream).writeByte(0);
                    continue;
                }
                object = as.a((as)object);
                ((DataOutputStream)filterOutputStream).writeByte(((Object)object).length);
                ((OutputStream)filterOutputStream).write((byte[])object);
            }
            byArray = byteArrayOutputStream.toByteArray();
        }
        catch (IOException iOException) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) return null;
                byteArrayOutputStream.close();
                return null;
            }
            catch (IOException iOException2) {
                return null;
            }
        }
        catch (Throwable throwable) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) throw throwable;
                byteArrayOutputStream.close();
                throw throwable;
            }
            catch (IOException iOException) {}
            throw throwable;
        }
        try {
            filterOutputStream.close();
            byteArrayOutputStream.close();
            return byArray;
        }
        catch (IOException iOException) {}
        return byArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = null;
        FilterInputStream filterInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(byArray);
            filterInputStream = new DataInputStream(byteArrayInputStream);
            int n2 = ((DataInputStream)filterInputStream).readByte();
            for (int i2 = 0; i2 < n2; ++i2) {
                byte by2 = ((DataInputStream)filterInputStream).readByte();
                if (by2 == 0) continue;
                Object object = new byte[by2];
                ((DataInputStream)filterInputStream).read((byte[])object);
                as as2 = as.a(object);
                object = as2;
                if (as2 == null) continue;
                this.var_java_util_Vector_a.addElement(object);
            }
        }
        catch (IOException iOException) {
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
                if (byteArrayInputStream == null) return;
                byteArrayInputStream.close();
                return;
            }
            catch (IOException iOException2) {
                return;
            }
        }
        catch (Throwable throwable) {
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
                if (byteArrayInputStream == null) throw throwable;
                byteArrayInputStream.close();
                throw throwable;
            }
            catch (IOException iOException) {}
            throw throwable;
        }
        try {
            filterInputStream.close();
            byteArrayInputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public final byte[] byte_arr_b() {
        int n2;
        byte[] byArray = new byte[7];
        for (n2 = 0; n2 < 7; n2 = (int)((byte)(n2 + 1))) {
            byArray[n2] = -1;
        }
        n2 = this.var_java_util_Vector_a.size();
        int n3 = 0;
        for (int n4 = 0; n4 < n2; n4 = (int)((byte)(n4 + 1))) {
            as as2 = (as)this.var_java_util_Vector_a.elementAt(n4);
            if (as2 == null || !as2.c()) continue;
            byArray[((bm)as2).i] = n4;
            byte by2 = (byte)(n3 + 1);
            n3 = by2;
            if (by2 >= 7) break;
        }
        return byArray;
    }

    private final void void_b() {
        Object object;
        int n2;
        for (n2 = 0; n2 < this.var_java_util_Vector_a.size() - 1; n2 = (int)((byte)(n2 + 1))) {
            as as2 = (as)this.var_java_util_Vector_a.elementAt(n2);
            if (as2 == null || !bj.a(as2.var_byte_a) || as2.c >= 99) continue;
            for (byte by2 = (byte)(n2 + 1); by2 < this.var_java_util_Vector_a.size(); by2 = (byte)(by2 + 1)) {
                object = (as)this.var_java_util_Vector_a.elementAt(by2);
                if (object == null || ((as)object).var_byte_a != as2.var_byte_a || ((as)object).var_byte_b != as2.var_byte_b) continue;
                byte by3 = as2.c;
                byte by4 = ((as)object).c;
                if (by3 + by4 <= 99) {
                    as2.void_a(by4);
                    this.void_a(by2);
                    continue;
                }
                by3 = (byte)(99 - by3);
                as2.void_a(by3);
                ((as)object).c = (byte)(((as)object).c - by3);
            }
        }
        object = this;
        int n3 = 0;
        for (n2 = ((bj)object).var_java_util_Vector_a.size() - 1; n2 >= 0; --n2) {
            as as3 = (as)((bj)object).var_java_util_Vector_a.elementAt(n2);
            if (as3 == null) {
                ((bj)object).var_java_util_Vector_a.removeElementAt(n2);
                continue;
            }
            ++n3;
        }
    }

    private static boolean a(byte by2) {
        return by2 >= 16;
    }
}

