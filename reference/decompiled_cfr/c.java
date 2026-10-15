/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class c {
    private static boolean var_boolean_a;
    private static InputStream var_java_io_InputStream_a;
    private static DataInputStream var_java_io_DataInputStream_a;
    private static OutputStream var_java_io_OutputStream_a;

    public static final boolean a() {
        return false;
    }

    public static final void a(boolean bl2) {
    }

    public static final byte[] a(byte by2, byte[] byArray) {
        int n2 = 5;
        if (byArray != null) {
            n2 = 5 + byArray.length;
        }
        byte[] byArray2 = new byte[n2];
        byte[] byArray3 = byArray2;
        byArray2[0] = (byte)(n2 >>> 24);
        byArray3[1] = (byte)(n2 >> 16);
        byArray3[2] = (byte)(n2 >> 8);
        byArray3[3] = (byte)n2;
        byArray3[4] = by2;
        if (byArray != null) {
            System.arraycopy(byArray, 0, byArray3, 5, byArray.length);
        }
        return byArray3;
    }

    static {
        var_boolean_a = false;
        var_java_io_InputStream_a = null;
        var_java_io_DataInputStream_a = null;
        var_java_io_OutputStream_a = null;
    }
}

