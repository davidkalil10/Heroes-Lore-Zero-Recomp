/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.rms.RecordStore
 */
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.rms.RecordStore;

public final class bh {
    public byte[] var_byte_arr_a = null;
    public int var_int_a = 0;
    public String var_java_lang_String_a = null;

    public bh(String string, byte by2) {
        this.var_java_lang_String_a = string;
        if (by2 == 1) {
            if (string.equals(ah.var_java_lang_String_a)) {
                this.var_byte_arr_a = new byte[ah.var_byte_arr_a.length];
                System.arraycopy(ah.var_byte_arr_a, 0, this.var_byte_arr_a, 0, ah.var_byte_arr_a.length);
                ah.var_byte_arr_a = null;
                ah.var_java_lang_String_a = null;
                return;
            }
            if (!this.a()) {
                throw new IOException("No such file : " + string);
            }
        }
    }

    public final void a(byte[] byArray, int n2, int n3) {
        try {
            this.var_int_a = this.var_int_a;
            System.arraycopy(this.var_byte_arr_a, this.var_int_a, byArray, 0, n3);
            this.var_int_a += n3;
            return;
        }
        catch (Exception exception) {
            System.out.println(this.var_java_lang_String_a);
            exception.printStackTrace();
            return;
        }
    }

    private boolean a() {
        int n2;
        Object object;
        if (this.var_java_lang_String_a == null) {
            return false;
        }
        try {
            object = this.var_java_lang_String_a.getClass().getResourceAsStream(this.var_java_lang_String_a);
            if (object != null) {
                this.var_byte_arr_a = new byte[((InputStream)object).available()];
                ((InputStream)object).read(this.var_byte_arr_a);
                ((InputStream)object).close();
                return true;
            }
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
        }
        while (this.var_java_lang_String_a.startsWith("/")) {
            this.var_java_lang_String_a = this.var_java_lang_String_a.substring(1);
        }
        while ((n2 = this.var_java_lang_String_a.indexOf("/")) > 0) {
            this.var_java_lang_String_a = this.var_java_lang_String_a.substring(0, n2) + "." + this.var_java_lang_String_a.substring(n2 + 1);
        }
        try {
            RecordStore recordStore = RecordStore.openRecordStore((String)this.var_java_lang_String_a, (boolean)true);
            if (recordStore.getNumRecords() == 0) {
                try {
                    recordStore.closeRecordStore();
                }
                catch (Exception exception) {}
                return false;
            }
            this.var_byte_arr_a = recordStore.getRecord(1);
            try {
                recordStore.closeRecordStore();
            }
            catch (Exception exception) {}
            return true;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return false;
        }
    }
}

