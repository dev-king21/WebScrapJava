// 
// Decompiled by Procyon v0.5.36
// 

package sample;

import java.io.IOException;
import javafx.scene.control.TextArea;
import java.io.OutputStream;

public class Console extends OutputStream
{
    private TextArea output;
    
    public Console(final TextArea ta) {
        this.output = ta;
    }
    
    @Override
    public void write(final int i) throws IOException {
        this.output.appendText(String.valueOf((char)i));
    }
}
