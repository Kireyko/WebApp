import java.io.*;

class RequestHandler {
    private BufferedReader reader;
    private BufferedOutputStream writer;
    private ResourceReader resourceReader;

    ResourceReader getResourceReader() {
        return resourceReader;
    }

    void setResourceReader(ResourceReader resourceReader) {
        this.resourceReader = resourceReader;
    }

    RequestHandler(BufferedReader reader, BufferedOutputStream writer) {
        this.reader = reader;
        this.writer = writer;
    }

    void handle() {
        if (reader != null) {
            Request request;
            try {
                request = RequestParser.parseRequest(reader);
                System.out.println(request);

                ResponseWriter.writeSuccessResponse(writer, resourceReader.readContent(request.getUri()));
            } catch (FileNotFoundException e) {
                ResponseWriter.writeNotFoundResponse(writer);
                System.out.println("FileNotFoundException");
            } catch (IOException e) {
                ResponseWriter.writeBadRequestResponse(writer);
                System.out.println("IOException");
            }
        }


    }

}
