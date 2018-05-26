import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

class RequestParser {

    static Request parseRequest(BufferedReader reader) throws IOException {
        Request request = new Request();
        String value= reader.readLine();
        if ((value!=null)&&(!value.isEmpty())){
            injectsUriAndMethod(request, value);
            injectsHeaders(request,reader);
        }

        return request;
    }

    private static void injectsUriAndMethod(Request request, String line) {
        String[] statusLine = line.split(" ");
        request.setMethod(HttpMethod.getByName(statusLine[0]));
        request.setUri(statusLine[1]);
    }

    private static void injectsHeaders(Request request, BufferedReader reader) throws IOException {
        String value;
        HashMap<String, String> map = new HashMap<>();
        while (!(value = reader.readLine()).isEmpty()) {
            String[] headers = value.split(":");
            map.put(headers[0], headers[1].trim());
        }
        request.setHeaders(map);
    }
}