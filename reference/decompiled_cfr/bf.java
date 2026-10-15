/*
 * Decompiled with CFR 0.152.
 */
public final class bf {
    private byte[] a;

    public final byte[] byte_arr_a(String string) {
        int n2 = string.length();
        if (n2 >= 16) {
            string = string.substring(0, 16);
        } else {
            int n3 = 0;
            while (n3 < 16 - n2) {
                string = string.concat("0");
                ++n3;
            }
        }
        this.a = string.getBytes();
        return this.a;
    }

    public final String java_lang_String_a(String object) {
        String string = "";
        try {
            object = new String(this.a(this.a, bf.byte_arr_a(((String)object).getBytes()), false));
            int n2 = ((String)object).length();
            object = ((String)object).substring(0, n2 - 6);
            return object;
        }
        catch (Exception exception) {
            try {
                object = exception;
                exception.printStackTrace();
            }
            catch (Throwable throwable) {
                object = throwable;
                throw throwable;
            }
        }
        return string;
    }

    private static int int_a(byte[] byArray, int n2) {
        return (byArray[n2] << 8 & 0xFF00) + (byArray[n2 + 1] & 0xFF);
    }

    private static void a(int n2, byte[] byArray, int n3) {
        byArray[n3] = (byte)(n2 >>> 8);
        byArray[n3 + 1] = (byte)n2;
    }

    private static int a(int n2, int n3) {
        if (n2 == 0) {
            n2 = 65537 - n3;
        } else if (n3 == 0) {
            n2 = 65537 - n2;
        } else {
            n2 *= n3;
            n2 = n3 - n2 + ((n3 = n2 & 0xFFFF) < (n2 >>>= 16) ? 1 : 0);
        }
        return n2 & 0xFFFF;
    }

    private int[] int_arr_a(byte[] byArray) {
        int[] nArray = new int[52];
        if (byArray.length < 16) {
            byte[] byArray2 = new byte[16];
            System.arraycopy(byArray, 0, byArray2, byArray2.length - byArray.length, byArray.length);
            byArray = byArray2;
        }
        int n2 = 0;
        while (n2 < 8) {
            nArray[n2] = bf.int_a(byArray, n2 << 1);
            ++n2;
        }
        n2 = 8;
        while (n2 < 52) {
            nArray[n2] = (n2 & 7) < 6 ? ((nArray[n2 - 7] & 0x7F) << 9 | nArray[n2 - 6] >> 7) & 0xFFFF : ((n2 & 7) == 6 ? ((nArray[n2 - 7] & 0x7F) << 9 | nArray[n2 - 14] >> 7) & 0xFFFF : ((nArray[n2 - 15] & 0x7F) << 9 | nArray[n2 - 14] >> 7) & 0xFFFF);
            ++n2;
        }
        return nArray;
    }

    private static int a(int n2) {
        if (n2 < 2) {
            return n2;
        }
        int n3 = 1;
        int n4 = 65537 / n2;
        int n5 = 65537 % n2;
        while (n5 != 1) {
            int n6 = n2 / n5;
            n3 = n3 + n4 * n6 & 0xFFFF;
            if ((n2 %= n5) == 1) {
                return n3;
            }
            n6 = n5 / n2;
            n5 %= n2;
            n4 = n4 + n3 * n6 & 0xFFFF;
        }
        return 1 - n4 & 0xFFFF;
    }

    private static byte[] byte_arr_a(byte[] byArray, int n2) {
        int n3 = byArray.length;
        n2 -= n3 % n2;
        int n4 = n3 + n2;
        byte[] byArray2 = new byte[n4];
        System.arraycopy(byArray, 0, byArray2, 0, n3);
        int n5 = n3;
        while (n5 < n4) {
            byArray2[n5] = (byte)n2;
            ++n5;
        }
        return byArray2;
    }

    private byte[] a(byte[] byArray, byte[] byArray2, boolean bl2) {
        byArray = bf.byte_arr_a(byArray, 16);
        byArray2 = bf.byte_arr_a(byArray2, 8);
        int byArray3 = byArray2.length;
        int n2 = byArray3 / 8;
        byte[] byArray4 = new byte[byArray3];
        int n3 = 0;
        while (n3 < n2) {
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            byte[] by2;
            int[] nArray;
            Object object = new byte[16];
            Object[] objectArray = new byte[8];
            System.arraycopy(byArray, 0, object, 0, 16);
            System.arraycopy(byArray2, n3 << 3, objectArray, 0, 8);
            int n9 = 0;
            byte[] byArray5 = objectArray;
            objectArray = object;
            object = this;
            byte[] byArray6 = new byte[8];
            byte[] n10 = objectArray;
            objectArray = object;
            if (n9 != 0) {
                nArray = super.int_arr_a(n10);
            } else {
                byte[] byArray7 = objectArray;
                objectArray = super.int_arr_a(n10);
                by2 = byArray7;
                n8 = 52;
                n7 = 0;
                int[] nArray2 = new int[52];
                ++n7;
                int n11 = bf.a(objectArray[0]);
                ++n7;
                byte by3 = objectArray[1];
                n6 = 0 - by3 & 0xFFFF;
                ++n7;
                by3 = objectArray[2];
                n5 = 0 - by3 & 0xFFFF;
                ++n7;
                n4 = bf.a(objectArray[3]);
                --n8;
                nArray2[51] = n4;
                --n8;
                nArray2[50] = n5;
                --n8;
                nArray2[49] = n6;
                --n8;
                nArray2[48] = n11;
                n9 = 1;
                while (n9 < 8) {
                    n11 = objectArray[n7++];
                    n6 = objectArray[n7++];
                    nArray2[--n8] = n6;
                    nArray2[--n8] = n11;
                    n11 = bf.a(objectArray[n7++]);
                    by3 = objectArray[n7++];
                    n6 = 0 - by3 & 0xFFFF;
                    by3 = objectArray[n7++];
                    n5 = 0 - by3 & 0xFFFF;
                    n4 = bf.a(objectArray[n7++]);
                    nArray2[--n8] = n4;
                    nArray2[--n8] = n6;
                    nArray2[--n8] = n5;
                    nArray2[--n8] = n11;
                    ++n9;
                }
                n11 = objectArray[n7++];
                n6 = objectArray[n7++];
                nArray2[--n8] = n6;
                nArray2[--n8] = n11;
                n11 = bf.a(objectArray[n7++]);
                by3 = objectArray[n7++];
                n6 = 0 - by3 & 0xFFFF;
                by3 = objectArray[n7++];
                n5 = 0 - by3 & 0xFFFF;
                n4 = bf.a(objectArray[n7]);
                nArray2[--n8] = n4;
                nArray2[--n8] = n5;
                nArray2[--n8] = n6;
                nArray2[--n8] = n11;
                nArray = nArray2;
            }
            objectArray = nArray;
            by2 = byArray6;
            n10 = byArray5;
            Object[] n92 = objectArray;
            objectArray = object;
            int objectArray2 = 0;
            n8 = bf.int_a(n10, 0);
            n7 = bf.int_a(n10, 2);
            int nArray2 = bf.int_a(n10, 4);
            int byArray7 = bf.int_a(n10, 6);
            n6 = 0;
            while (n6 < 8) {
                n8 = bf.a(n8, (int)n92[objectArray2++]);
                n7 += n92[objectArray2++];
                nArray2 += n92[objectArray2++];
                byArray7 = bf.a(byArray7, (int)n92[objectArray2++]);
                n5 = n7 &= 0xFFFF;
                n4 = nArray2 &= 0xFFFF;
                nArray2 ^= n8;
                n7 ^= byArray7;
                nArray2 = bf.a(nArray2, (int)n92[objectArray2++]);
                n7 += nArray2;
                n7 &= 0xFFFF;
                n7 = bf.a(n7, (int)n92[objectArray2++]);
                nArray2 += n7;
                n8 ^= n7;
                byArray7 ^= (nArray2 &= 0xFFFF);
                n7 ^= n4;
                nArray2 ^= n5;
                ++n6;
            }
            bf.a(bf.a(n8, (int)n92[objectArray2++]), by2, 0);
            bf.a(nArray2 + n92[objectArray2++], by2, 2);
            bf.a(n7 + n92[objectArray2++], by2, 4);
            bf.a(bf.a(byArray7, (int)n92[objectArray2]), by2, 6);
            object = byArray6;
            System.arraycopy(byArray6, 0, byArray4, n3 << 3, 8);
            ++n3;
        }
        return byArray4;
    }

    private static byte[] byte_arr_a(byte[] byArray) {
        if (byArray.length % 2 != 0) {
            throw new IllegalArgumentException("Length Not Double Num");
        }
        byte[] byArray2 = new byte[byArray.length / 2];
        int n2 = 0;
        while (n2 < byArray.length) {
            String string = new String(byArray, n2, 2);
            byArray2[n2 / 2] = (byte)Integer.parseInt(string, 16);
            n2 += 2;
        }
        return byArray2;
    }
}

