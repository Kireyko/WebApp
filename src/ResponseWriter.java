import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

class ResponseWriter {
    final static  byte[] NEW_LINE = "\r\n".getBytes();
    //OutputStream
    static void writeSuccessResponse(BufferedOutputStream writer,  byte[] content) {
        try {

            writer.write("HTTP/1.1 200 OK".getBytes());
            writer.write(NEW_LINE);
            writer.write(NEW_LINE);
            writer.write(content);
            writer.write(NEW_LINE);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeBadRequestResponse(BufferedOutputStream writer) {
        try {
            writer.write("HTTP/1.1 400 BAD_REQUEST".getBytes());
            writer.write(NEW_LINE);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeNotFoundResponse(BufferedOutputStream writer)  {
        try {
            writer.write("HTTP/1.1 404 NOT_FOUND".getBytes());
            writer.write(NEW_LINE);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
