import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private ResourceReader resourceReader;

    void setPort(int port) {
        this.port = port;
    }

    void setWebAppPath(String path) {
        resourceReader = new ResourceReader();
        resourceReader.setWebAppPath(path);
    }

    void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            try (
                    Socket socket = serverSocket.accept()
                ) {
                RequestHandler requestHandler = new RequestHandler(
                        new BufferedReader(new InputStreamReader(socket.getInputStream())),
                        new BufferedOutputStream(socket.getOutputStream())
                );
                requestHandler.setResourceReader(resourceReader);
                requestHandler.handle();
            }
        }
    }
}
