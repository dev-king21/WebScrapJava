// 
// Decompiled by Procyon v0.5.36
// 

package bot.utils;

import java.io.UnsupportedEncodingException;

public class Base64
{
    public static final int DEFAULT = 0;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int CRLF = 4;
    public static final int URL_SAFE = 8;
    public static final int NO_CLOSE = 16;
    
    public static byte[] decode(final String str, final int flags) {
        return decode(str.getBytes(), flags);
    }
    
    public static byte[] decode(final byte[] input, final int flags) {
        return decode(input, 0, input.length, flags);
    }
    
    public static byte[] decode(final byte[] input, final int offset, final int len, final int flags) {
        final Decoder decoder = new Decoder(flags, new byte[len * 3 / 4]);
        if (!decoder.process(input, offset, len, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (decoder.op == decoder.output.length) {
            return decoder.output;
        }
        final byte[] temp = new byte[decoder.op];
        System.arraycopy(decoder.output, 0, temp, 0, decoder.op);
        return temp;
    }
    
    public static String encodeToString(final byte[] input, final int flags) {
        try {
            return new String(encode(input, flags), "US-ASCII");
        }
        catch (UnsupportedEncodingException e) {
            throw new AssertionError((Object)e);
        }
    }
    
    public static String encodeToString(final byte[] input, final int offset, final int len, final int flags) {
        try {
            return new String(encode(input, offset, len, flags), "US-ASCII");
        }
        catch (UnsupportedEncodingException e) {
            throw new AssertionError((Object)e);
        }
    }
    
    public static byte[] encode(final byte[] input, final int flags) {
        return encode(input, 0, input.length, flags);
    }
    
    public static byte[] encode(final byte[] input, final int offset, final int len, final int flags) {
        final Encoder encoder = new Encoder(flags, null);
        int output_len = len / 3 * 4;
        if (encoder.do_padding) {
            if (len % 3 > 0) {
                output_len += 4;
            }
        }
        else {
            switch (len % 3) {
                case 1: {
                    output_len += 2;
                    break;
                }
                case 2: {
                    output_len += 3;
                    break;
                }
            }
        }
        if (encoder.do_newline && len > 0) {
            output_len += ((len - 1) / 57 + 1) * (encoder.do_cr ? 2 : 1);
        }
        encoder.output = new byte[output_len];
        encoder.process(input, offset, len, true);
        assert encoder.op == output_len;
        return encoder.output;
    }
    
    private Base64() {
    }
    
    abstract static class Coder
    {
        public byte[] output;
        public int op;
        
        public abstract boolean process(final byte[] p0, final int p1, final int p2, final boolean p3);
        
        public abstract int maxOutputSize(final int p0);
    }
    
    static class Decoder extends Coder
    {
        private static final int[] DECODE;
        private static final int[] DECODE_WEBSAFE;
        private static final int SKIP = -1;
        private static final int EQUALS = -2;
        private int state;
        private int value;
        private final int[] alphabet;
        
        public Decoder(final int flags, final byte[] output) {
            this.output = output;
            this.alphabet = (((flags & 0x8) == 0x0) ? Decoder.DECODE : Decoder.DECODE_WEBSAFE);
            this.state = 0;
            this.value = 0;
        }
        
        @Override
        public int maxOutputSize(final int len) {
            return len * 3 / 4 + 10;
        }
        
        @Override
        public boolean process(final byte[] input, final int offset, int len, final boolean finish) {
            if (this.state == 6) {
                return false;
            }
            int p = offset;
            len += offset;
            int state = this.state;
            int value = this.value;
            int op = 0;
            final byte[] output = this.output;
            final int[] alphabet = this.alphabet;
            while (p < len) {
                if (state == 0) {
                    while (p + 4 <= len && (value = (alphabet[input[p] & 0xFF] << 18 | alphabet[input[p + 1] & 0xFF] << 12 | alphabet[input[p + 2] & 0xFF] << 6 | alphabet[input[p + 3] & 0xFF])) >= 0) {
                        output[op + 2] = (byte)value;
                        output[op + 1] = (byte)(value >> 8);
                        output[op] = (byte)(value >> 16);
                        op += 3;
                        p += 4;
                    }
                    if (p >= len) {
                        break;
                    }
                }
                final int d = alphabet[input[p++] & 0xFF];
                switch (state) {
                    case 0: {
                        if (d >= 0) {
                            value = d;
                            ++state;
                            continue;
                        }
                        if (d != -1) {
                            this.state = 6;
                            return false;
                        }
                        continue;
                    }
                    case 1: {
                        if (d >= 0) {
                            value = (value << 6 | d);
                            ++state;
                            continue;
                        }
                        if (d != -1) {
                            this.state = 6;
                            return false;
                        }
                        continue;
                    }
                    case 2: {
                        if (d >= 0) {
                            value = (value << 6 | d);
                            ++state;
                            continue;
                        }
                        if (d == -2) {
                            output[op++] = (byte)(value >> 4);
                            state = 4;
                            continue;
                        }
                        if (d != -1) {
                            this.state = 6;
                            return false;
                        }
                        continue;
                    }
                    case 3: {
                        if (d >= 0) {
                            value = (value << 6 | d);
                            output[op + 2] = (byte)value;
                            output[op + 1] = (byte)(value >> 8);
                            output[op] = (byte)(value >> 16);
                            op += 3;
                            state = 0;
                            continue;
                        }
                        if (d == -2) {
                            output[op + 1] = (byte)(value >> 2);
                            output[op] = (byte)(value >> 10);
                            op += 2;
                            state = 5;
                            continue;
                        }
                        if (d != -1) {
                            this.state = 6;
                            return false;
                        }
                        continue;
                    }
                    case 4: {
                        if (d == -2) {
                            ++state;
                            continue;
                        }
                        if (d != -1) {
                            this.state = 6;
                            return false;
                        }
                        continue;
                    }
                    case 5: {
                        if (d != -1) {
                            this.state = 6;
                            return false;
                        }
                        continue;
                    }
                }
            }
            if (!finish) {
                this.state = state;
                this.value = value;
                this.op = op;
                return true;
            }
            switch (state) {
                case 1: {
                    this.state = 6;
                    return false;
                }
                case 2: {
                    output[op++] = (byte)(value >> 4);
                    break;
                }
                case 3: {
                    output[op++] = (byte)(value >> 10);
                    output[op++] = (byte)(value >> 2);
                    break;
                }
                case 4: {
                    this.state = 6;
                    return false;
                }
            }
            this.state = state;
            this.op = op;
            return true;
        }
        
        static {
            DECODE = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
            DECODE_WEBSAFE = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        }
    }
    
    static class Encoder extends Coder
    {
        public static final int LINE_GROUPS = 19;
        private static final byte[] ENCODE;
        private static final byte[] ENCODE_WEBSAFE;
        private final byte[] tail;
        int tailLen;
        private int count;
        public final boolean do_padding;
        public final boolean do_newline;
        public final boolean do_cr;
        private final byte[] alphabet;
        
        public Encoder(final int flags, final byte[] output) {
            this.output = output;
            this.do_padding = ((flags & 0x1) == 0x0);
            this.do_newline = ((flags & 0x2) == 0x0);
            this.do_cr = ((flags & 0x4) != 0x0);
            this.alphabet = (((flags & 0x8) == 0x0) ? Encoder.ENCODE : Encoder.ENCODE_WEBSAFE);
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = (this.do_newline ? 19 : -1);
        }
        
        @Override
        public int maxOutputSize(final int len) {
            return len * 8 / 5 + 10;
        }
        
        @Override
        public boolean process(final byte[] input, final int offset, int len, final boolean finish) {
            final byte[] alphabet = this.alphabet;
            final byte[] output = this.output;
            int op = 0;
            int count = this.count;
            int p = offset;
            len += offset;
            int v = -1;
            switch (this.tailLen) {
                case 1: {
                    if (p + 2 <= len) {
                        v = ((this.tail[0] & 0xFF) << 16 | (input[p++] & 0xFF) << 8 | (input[p++] & 0xFF));
                        this.tailLen = 0;
                        break;
                    }
                    break;
                }
                case 2: {
                    if (p + 1 <= len) {
                        v = ((this.tail[0] & 0xFF) << 16 | (this.tail[1] & 0xFF) << 8 | (input[p++] & 0xFF));
                        this.tailLen = 0;
                        break;
                    }
                    break;
                }
            }
            if (v != -1) {
                output[op++] = alphabet[v >> 18 & 0x3F];
                output[op++] = alphabet[v >> 12 & 0x3F];
                output[op++] = alphabet[v >> 6 & 0x3F];
                output[op++] = alphabet[v & 0x3F];
                if (--count == 0) {
                    if (this.do_cr) {
                        output[op++] = 13;
                    }
                    output[op++] = 10;
                    count = 19;
                }
            }
            while (p + 3 <= len) {
                v = ((input[p] & 0xFF) << 16 | (input[p + 1] & 0xFF) << 8 | (input[p + 2] & 0xFF));
                output[op] = alphabet[v >> 18 & 0x3F];
                output[op + 1] = alphabet[v >> 12 & 0x3F];
                output[op + 2] = alphabet[v >> 6 & 0x3F];
                output[op + 3] = alphabet[v & 0x3F];
                p += 3;
                op += 4;
                if (--count == 0) {
                    if (this.do_cr) {
                        output[op++] = 13;
                    }
                    output[op++] = 10;
                    count = 19;
                }
            }
            if (finish) {
                if (p - this.tailLen == len - 1) {
                    int t = 0;
                    v = (((this.tailLen > 0) ? this.tail[t++] : input[p++]) & 0xFF) << 4;
                    this.tailLen -= t;
                    output[op++] = alphabet[v >> 6 & 0x3F];
                    output[op++] = alphabet[v & 0x3F];
                    if (this.do_padding) {
                        output[op++] = 61;
                        output[op++] = 61;
                    }
                    if (this.do_newline) {
                        if (this.do_cr) {
                            output[op++] = 13;
                        }
                        output[op++] = 10;
                    }
                }
                else if (p - this.tailLen == len - 2) {
                    int t = 0;
                    v = ((((this.tailLen > 1) ? this.tail[t++] : input[p++]) & 0xFF) << 10 | (((this.tailLen > 0) ? this.tail[t++] : input[p++]) & 0xFF) << 2);
                    this.tailLen -= t;
                    output[op++] = alphabet[v >> 12 & 0x3F];
                    output[op++] = alphabet[v >> 6 & 0x3F];
                    output[op++] = alphabet[v & 0x3F];
                    if (this.do_padding) {
                        output[op++] = 61;
                    }
                    if (this.do_newline) {
                        if (this.do_cr) {
                            output[op++] = 13;
                        }
                        output[op++] = 10;
                    }
                }
                else if (this.do_newline && op > 0 && count != 19) {
                    if (this.do_cr) {
                        output[op++] = 13;
                    }
                    output[op++] = 10;
                }
                assert this.tailLen == 0;
                assert p == len;
            }
            else if (p == len - 1) {
                this.tail[this.tailLen++] = input[p];
            }
            else if (p == len - 2) {
                this.tail[this.tailLen++] = input[p];
                this.tail[this.tailLen++] = input[p + 1];
            }
            this.op = op;
            this.count = count;
            return true;
        }
        
        static {
            ENCODE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
            ENCODE_WEBSAFE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        }
    }
}
