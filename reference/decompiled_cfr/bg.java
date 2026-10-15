/*
 * Decompiled with CFR 0.152.
 */
public final class bg {
    private String a = "0123456789abcdef";

    private String a(int n2) {
        String string = "";
        int n3 = 0;
        while (n3 <= 3) {
            string = String.valueOf(string) + this.a.charAt(n2 >> (n3 << 3) + 4 & 0xF) + this.a.charAt(n2 >> (n3 << 3) & 0xF);
            ++n3;
        }
        return string;
    }

    private static int a(int n2, int n3) {
        return (n2 & Integer.MAX_VALUE) + (n3 & Integer.MAX_VALUE) ^ n2 & Integer.MIN_VALUE ^ n3 & Integer.MIN_VALUE;
    }

    private int a(int n2, int n3, int n4, int n5, int n6, int n7) {
        int n8 = bg.a(bg.a(n3, n2), bg.a(n5, n7));
        n3 = n6;
        n2 = n8;
        return bg.a(n8 << n3 | n2 >>> 32 - n3, n4);
    }

    private int a(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        return this.a(n3 & n4 | ~n3 & n5, n2, n3, n6, n7, n8);
    }

    private int b(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        return this.a(n3 & n5 | n4 & ~n5, n2, n3, n6, n7, n8);
    }

    private int c(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        return this.a(n3 ^ n4 ^ n5, n2, n3, n6, n7, n8);
    }

    private int d(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        return this.a(n4 ^ (n3 | ~n5), n2, n3, n6, n7, n8);
    }

    public final String a(String object) {
        int n2 = (((String)object).length() + 8 >> 6) + 1;
        int[] nArray = new int[n2 << 4];
        int n3 = 0;
        while (n3 < n2 << 4) {
            nArray[n3] = 0;
            ++n3;
        }
        n3 = 0;
        while (n3 < ((String)object).length()) {
            int n4 = n3 >> 2;
            nArray[n4] = nArray[n4] | ((String)object).charAt(n3) << (n3 % 4 << 3);
            ++n3;
        }
        int n5 = n3 >> 2;
        nArray[n5] = nArray[n5] | 128 << (n3 % 4 << 3);
        nArray[(n2 << 4) - 2] = ((String)object).length() << 3;
        object = nArray;
        n2 = 1732584193;
        int n6 = -271733879;
        n3 = -1732584194;
        int n7 = 271733878;
        int n8 = 0;
        while (n8 < ((Object)object).length) {
            int n9 = n2;
            int n10 = n6;
            int n11 = n3;
            int n12 = n7;
            n2 = this.a(n2, n6, n3, n7, (int)object[n8], 7, -680876936);
            n7 = this.a(n7, n2, n6, n3, (int)object[n8 + 1], 12, -389564586);
            n3 = this.a(n3, n7, n2, n6, (int)object[n8 + 2], 17, 606105819);
            n6 = this.a(n6, n3, n7, n2, (int)object[n8 + 3], 22, -1044525330);
            n2 = this.a(n2, n6, n3, n7, (int)object[n8 + 4], 7, -176418897);
            n7 = this.a(n7, n2, n6, n3, (int)object[n8 + 5], 12, 1200080426);
            n3 = this.a(n3, n7, n2, n6, (int)object[n8 + 6], 17, -1473231341);
            n6 = this.a(n6, n3, n7, n2, (int)object[n8 + 7], 22, -45705983);
            n2 = this.a(n2, n6, n3, n7, (int)object[n8 + 8], 7, 1770035416);
            n7 = this.a(n7, n2, n6, n3, (int)object[n8 + 9], 12, -1958414417);
            n3 = this.a(n3, n7, n2, n6, (int)object[n8 + 10], 17, -42063);
            n6 = this.a(n6, n3, n7, n2, (int)object[n8 + 11], 22, -1990404162);
            n2 = this.a(n2, n6, n3, n7, (int)object[n8 + 12], 7, 1804603682);
            n7 = this.a(n7, n2, n6, n3, (int)object[n8 + 13], 12, -40341101);
            n3 = this.a(n3, n7, n2, n6, (int)object[n8 + 14], 17, -1502002290);
            n6 = this.a(n6, n3, n7, n2, (int)object[n8 + 15], 22, 1236535329);
            n2 = this.b(n2, n6, n3, n7, (int)object[n8 + 1], 5, -165796510);
            n7 = this.b(n7, n2, n6, n3, (int)object[n8 + 6], 9, -1069501632);
            n3 = this.b(n3, n7, n2, n6, (int)object[n8 + 11], 14, 643717713);
            n6 = this.b(n6, n3, n7, n2, (int)object[n8], 20, -373897302);
            n2 = this.b(n2, n6, n3, n7, (int)object[n8 + 5], 5, -701558691);
            n7 = this.b(n7, n2, n6, n3, (int)object[n8 + 10], 9, 38016083);
            n3 = this.b(n3, n7, n2, n6, (int)object[n8 + 15], 14, -660478335);
            n6 = this.b(n6, n3, n7, n2, (int)object[n8 + 4], 20, -405537848);
            n2 = this.b(n2, n6, n3, n7, (int)object[n8 + 9], 5, 568446438);
            n7 = this.b(n7, n2, n6, n3, (int)object[n8 + 14], 9, -1019803690);
            n3 = this.b(n3, n7, n2, n6, (int)object[n8 + 3], 14, -187363961);
            n6 = this.b(n6, n3, n7, n2, (int)object[n8 + 8], 20, 1163531501);
            n2 = this.b(n2, n6, n3, n7, (int)object[n8 + 13], 5, -1444681467);
            n7 = this.b(n7, n2, n6, n3, (int)object[n8 + 2], 9, -51403784);
            n3 = this.b(n3, n7, n2, n6, (int)object[n8 + 7], 14, 1735328473);
            n6 = this.b(n6, n3, n7, n2, (int)object[n8 + 12], 20, -1926607734);
            n2 = this.c(n2, n6, n3, n7, (int)object[n8 + 5], 4, -378558);
            n7 = this.c(n7, n2, n6, n3, (int)object[n8 + 8], 11, -2022574463);
            n3 = this.c(n3, n7, n2, n6, (int)object[n8 + 11], 16, 1839030562);
            n6 = this.c(n6, n3, n7, n2, (int)object[n8 + 14], 23, -35309556);
            n2 = this.c(n2, n6, n3, n7, (int)object[n8 + 1], 4, -1530992060);
            n7 = this.c(n7, n2, n6, n3, (int)object[n8 + 4], 11, 1272893353);
            n3 = this.c(n3, n7, n2, n6, (int)object[n8 + 7], 16, -155497632);
            n6 = this.c(n6, n3, n7, n2, (int)object[n8 + 10], 23, -1094730640);
            n2 = this.c(n2, n6, n3, n7, (int)object[n8 + 13], 4, 681279174);
            n7 = this.c(n7, n2, n6, n3, (int)object[n8], 11, -358537222);
            n3 = this.c(n3, n7, n2, n6, (int)object[n8 + 3], 16, -722521979);
            n6 = this.c(n6, n3, n7, n2, (int)object[n8 + 6], 23, 76029189);
            n2 = this.c(n2, n6, n3, n7, (int)object[n8 + 9], 4, -640364487);
            n7 = this.c(n7, n2, n6, n3, (int)object[n8 + 12], 11, -421815835);
            n3 = this.c(n3, n7, n2, n6, (int)object[n8 + 15], 16, 530742520);
            n6 = this.c(n6, n3, n7, n2, (int)object[n8 + 2], 23, -995338651);
            n2 = this.d(n2, n6, n3, n7, (int)object[n8], 6, -198630844);
            n7 = this.d(n7, n2, n6, n3, (int)object[n8 + 7], 10, 1126891415);
            n3 = this.d(n3, n7, n2, n6, (int)object[n8 + 14], 15, -1416354905);
            n6 = this.d(n6, n3, n7, n2, (int)object[n8 + 5], 21, -57434055);
            n2 = this.d(n2, n6, n3, n7, (int)object[n8 + 12], 6, 1700485571);
            n7 = this.d(n7, n2, n6, n3, (int)object[n8 + 3], 10, -1894986606);
            n3 = this.d(n3, n7, n2, n6, (int)object[n8 + 10], 15, -1051523);
            n6 = this.d(n6, n3, n7, n2, (int)object[n8 + 1], 21, -2054922799);
            n2 = this.d(n2, n6, n3, n7, (int)object[n8 + 8], 6, 1873313359);
            n7 = this.d(n7, n2, n6, n3, (int)object[n8 + 15], 10, -30611744);
            n3 = this.d(n3, n7, n2, n6, (int)object[n8 + 6], 15, -1560198380);
            n6 = this.d(n6, n3, n7, n2, (int)object[n8 + 13], 21, 1309151649);
            n2 = this.d(n2, n6, n3, n7, (int)object[n8 + 4], 6, -145523070);
            n7 = this.d(n7, n2, n6, n3, (int)object[n8 + 11], 10, -1120210379);
            n3 = this.d(n3, n7, n2, n6, (int)object[n8 + 2], 15, 718787259);
            n6 = this.d(n6, n3, n7, n2, (int)object[n8 + 9], 21, -343485551);
            n2 = bg.a(n2, n9);
            n6 = bg.a(n6, n10);
            n3 = bg.a(n3, n11);
            n7 = bg.a(n7, n12);
            n8 += 16;
        }
        return String.valueOf(this.a(n2)) + this.a(n6) + this.a(n3) + this.a(n7);
    }
}

