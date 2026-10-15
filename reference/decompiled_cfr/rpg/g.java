/*
 * Decompiled with CFR 0.152.
 */
package rpg;

import java.util.Random;

public final class g {
    private static Random a = new Random();

    public static final byte[] a(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
        System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
        return byArray3;
    }

    public static long long_a(byte[] byArray, int n2) {
        return (long)g.int_a(byArray, n2) << 32 | (long)g.int_a(byArray, n2 + 4) & 0xFFFFFFFFL;
    }

    public static final int int_a(byte[] byArray, int n2) {
        return (byArray[n2] & 0xFF) << 24 | (byArray[n2 + 1] & 0xFF) << 16 | (byArray[n2 + 2] & 0xFF) << 8 | byArray[n2 + 3] & 0xFF;
    }

    public static final int int_b(byte[] byArray, int n2) {
        return (byArray[n2 + 3] & 0xFF) << 24 | (byArray[n2 + 2] & 0xFF) << 16 | (byArray[n2 + 1] & 0xFF) << 8 | byArray[n2] & 0xFF;
    }

    public static final short short_a(byte[] byArray, int n2) {
        return (short)((byArray[n2 + 1] & 0xFF) << 8 | byArray[n2] & 0xFF);
    }

    public static final short short_b(byte[] byArray, int n2) {
        return (short)((byArray[n2] & 0xFF) << 8 | byArray[n2 + 1] & 0xFF);
    }

    public static final void a(int n2, byte[] byArray, int n3) {
        byte[] byArray2 = new byte[]{0, 0, 0, 0};
        byArray2[0] = (byte)(n2 >>> 24);
        byArray2[1] = (byte)(n2 >> 16);
        byArray2[2] = (byte)(n2 >> 8);
        byArray2[3] = (byte)n2;
        System.arraycopy(byArray2, 0, byArray, n3, 4);
    }

    public static final void a(short s2, byte[] byArray, int n2) {
        byArray[n2] = (byte)(s2 >> 8);
        byArray[n2 + 1] = (byte)s2;
    }

    public static void a(long l2, byte[] byArray, int n2) {
        int n3 = (int)(l2 >> 32);
        g.a(n3, byArray, n2);
        n3 = (int)l2;
        g.a(n3, byArray, n2 + 4);
    }

    public static final synchronized int a(int n2, int n3) {
        if ((n3 = n3 - n2 + 1) == 0) {
            return 0;
        }
        n3 = Math.abs(a.nextInt()) % n3;
        return n2 + n3;
    }

    public static final int a(Random random, int n2, int n3) {
        if ((n3 = n3 - n2 + 1) == 0) {
            return 0;
        }
        int n4 = Math.abs(random.nextInt()) % n3;
        return n2 + n4;
    }

    public static final long a() {
        return System.currentTimeMillis() / 1000L;
    }
}

