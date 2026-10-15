/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.io.Connector
 *  javax.microedition.lcdui.Canvas
 *  javax.microedition.lcdui.Display
 *  javax.microedition.midlet.MIDlet
 *  javax.wireless.messaging.Message
 *  javax.wireless.messaging.MessageConnection
 *  javax.wireless.messaging.TextMessage
 */
import javax.microedition.io.Connector;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.wireless.messaging.Message;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

public final class ds
implements Runnable {
    private static final String[] var_java_lang_String_arr_a;
    private static final byte[][] var_byte_arr_arr_a;
    private static final byte[] var_byte_arr_a;
    private static final byte[][] var_byte_arr_arr_b;
    private static int var_int_a;
    private boolean var_boolean_b = false;
    private String[] var_java_lang_String_arr_b = null;
    private String var_java_lang_String_a;
    private String var_java_lang_String_b;
    private static a var_a_a;
    private int var_int_b;
    private String var_java_lang_String_c = null;
    private String d = null;
    private static MIDlet var_javax_microedition_midlet_MIDlet_a;
    public static boolean var_boolean_a;
    private boolean var_boolean_c = false;

    public ds(MIDlet mIDlet) {
        var_javax_microedition_midlet_MIDlet_a = mIDlet;
        var_a_a = new a(var_javax_microedition_midlet_MIDlet_a);
        this.var_int_b = a.int_a();
        this.var_java_lang_String_c = var_javax_microedition_midlet_MIDlet_a.getAppProperty("EA-Porting-Test-SMS-Mode");
        if (this.var_java_lang_String_c != null) {
            this.var_java_lang_String_c = this.var_java_lang_String_c.trim().length() <= 0 ? null : this.var_java_lang_String_c.toLowerCase().trim();
        }
        this.d = var_javax_microedition_midlet_MIDlet_a.getAppProperty("EA-Porting-Test-SMS-Phone");
        if (this.d != null) {
            if (this.d.trim().length() <= 0) {
                this.d = null;
                return;
            }
            this.d = this.d.toLowerCase().trim();
        }
    }

    public final byte[] byte_arr_a(int n2) {
        byte[] byArray = new byte[2];
        byte[] byArray2 = byArray;
        byArray[0] = var_byte_arr_a[n2];
        byArray2[1] = var_byte_arr_arr_b[this.var_int_b][n2];
        return byArray2;
    }

    public final boolean boolean_a(int n2) {
        System.out.println("send pay : " + n2);
        this.var_boolean_c = false;
        if (this.var_java_lang_String_c != null) {
            return !this.var_java_lang_String_c.equals("false");
        }
        this.var_java_lang_String_arr_b = null;
        var_int_a = var_byte_arr_arr_a[this.var_int_b][n2];
        this.var_java_lang_String_a = var_java_lang_String_arr_a[n2];
        if (this.var_int_b == 0) {
            var_int_a = var_byte_arr_arr_a[1][n2];
            ds ds2 = this;
            String string = a.java_lang_String_a();
            String string2 = a.b();
            String string3 = a.d();
            String string4 = a.c();
            String string5 = a.e();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" 146 ");
            stringBuffer.append("011 ");
            stringBuffer.append("Z600 ");
            stringBuffer.append(string + " ");
            stringBuffer.append(string2 + " ");
            stringBuffer.append(string3 + " ");
            stringBuffer.append(string4 + " ");
            stringBuffer.append(string5 + " ");
            stringBuffer.append(ds2.var_java_lang_String_a + " ");
            stringBuffer.append(0);
            stringBuffer.append(var_int_a + " ");
            stringBuffer.append("Z600");
            ds2.var_java_lang_String_b = stringBuffer.toString();
            this.var_java_lang_String_arr_b = a.a(var_byte_arr_arr_a[this.var_int_b][n2]);
            this.var_java_lang_String_arr_b[0] = this.var_java_lang_String_arr_b[0] + this.var_java_lang_String_b;
        } else if (this.var_int_b == 1) {
            this.var_java_lang_String_arr_b = var_a_a.a(var_int_a, Integer.parseInt("146"));
        }
        if (this.d != null) {
            this.var_java_lang_String_arr_b[1] = this.d;
        }
        this.var_boolean_b = false;
        var_boolean_a = false;
        new Thread(this).start();
        while (!var_boolean_a) {
            try {
                Canvas canvas = (Canvas)Display.getDisplay((MIDlet)var_javax_microedition_midlet_MIDlet_a).getCurrent();
                canvas.repaint();
                canvas.serviceRepaints();
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedException) {
                InterruptedException interruptedException2 = interruptedException;
                interruptedException.printStackTrace();
            }
        }
        return this.var_boolean_b;
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(String[] stringArray) {
        boolean bl2 = true;
        MessageConnection messageConnection = null;
        String string = "sms://" + stringArray[1];
        messageConnection = (MessageConnection)Connector.open((String)string);
        TextMessage textMessage = (TextMessage)messageConnection.newMessage("text");
        textMessage.setAddress(string);
        textMessage.setPayloadText(stringArray[0]);
        messageConnection.send((Message)textMessage);
        if (messageConnection == null) return bl2;
        try {
            messageConnection.close();
            return bl2;
        }
        catch (Exception exception) {}
        return bl2;
        catch (Exception exception) {
            try {
                Exception exception2 = exception;
                exception.printStackTrace();
                bl2 = false;
                if (messageConnection == null) return bl2;
            }
            catch (Throwable throwable) {
                if (messageConnection == null) throw throwable;
                try {
                    messageConnection.close();
                    throw throwable;
                }
                catch (Exception exception3) {}
                throw throwable;
            }
            try {
                messageConnection.close();
                return bl2;
            }
            catch (Exception exception4) {}
            return bl2;
        }
    }

    public final void run() {
        this.var_boolean_b = this.a(this.var_java_lang_String_arr_b);
        var_boolean_a = true;
    }

    static {
        var_java_lang_String_arr_a = new String[]{"01", "06", "03", "03", "03", "15", "10", "10"};
        byte[][] byArrayArray = new byte[][]{{4, 2, 2, 2, 2, 1, 1, 1}, {1, 2, 3, 3, 3, 4, 5, 5}};
        var_byte_arr_arr_a = byArrayArray;
        var_byte_arr_a = byArrayArray[0];
        var_byte_arr_arr_b = new byte[][]{{2, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};
        var_int_a = 1;
        var_javax_microedition_midlet_MIDlet_a = null;
        var_boolean_a = true;
    }
}

