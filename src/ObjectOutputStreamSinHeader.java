/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacionfinal;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author paveg
 */
public class ObjectOutputStreamSinHeader extends ObjectOutputStream{

    public ObjectOutputStreamSinHeader(OutputStream out) throws IOException {
        super(out);
    }

    public ObjectOutputStreamSinHeader() throws IOException, SecurityException {
    }

    @Override
    protected void writeStreamHeader() throws IOException {
    }
    
   
    

}
