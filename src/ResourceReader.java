import java.io.*;
import java.nio.file.Files;


class ResourceReader {
    private String webAppPath;

    String getWebAppPath() {
        return webAppPath;
    }

    void setWebAppPath(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    byte[] readContent(String uri) throws IOException {
        File file = new File(getWebAppPath()  + uri);
        if (!file.exists()) {
            throw new FileNotFoundException("file (" + file.toString() + ") not found ");
        }
        byte[] array = Files.readAllBytes(file.toPath());
        return array;
    }

}
