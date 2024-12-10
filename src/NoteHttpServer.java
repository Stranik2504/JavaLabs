import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
public class NoteHttpServer {
    private static final int PORT = 44;
    private static final List<String> notes = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Note HTTP Server запущен на порту " + PORT);
            // new
            System.out.println("http://localhost:" + PORT + "/");
            

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    handleClient(clientSocket);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка запуска сервера: " + e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
        
        String line = in.readLine();
        if (line == null) return;
        
        String[] requestParts = line.split(" ");
        String method = requestParts[0];
        String path = requestParts[1];

        if (method.equals("GET") && path.equals("/")) {
            // to links to notes and calculator
            sendHttpResponse(out, 200, "<html><body><h1>Home</h1>"
                    + "<a href='/notes'>Notes</a><br>"
                    + "<a href='/calculator'>Calculator</a>"
                    + "</body></html>");
        } else if (method.equals("GET") && path.equals("/notes")) {
            handleGetNotes(out);
        } else if (method.equals("POST") && path.startsWith("/add note")) { 
            String note = extractBodyNote(in);
            handleAddNote(note, out);
        } 
        else if (method.equals("POST") && path.startsWith("/delete-note")) {
            handleDeleteLastNote(out);
        } else if (method.equals("GET") && path.equals("/calculator")) { // New
            sendHttpResponse(out, 200, "<html><body><h1>Calculator</h1><form method='GET' action='/calculate'>"
                    + "<input type='number' name='a' required> <select name='op'>"
                    + "<option value='+'>+</option><option value='-'>-</option><option value='*'>*</option><option value='/'>/</option>"
                    + "</select> <input type='number' name='b' required> <button type='submit'>Calculate</button>"
                    + "</form></body></html>");
        } else if (method.equals("GET") && path.startsWith("/calculate")) { // New
            if (!path.startsWith("/calculate?")) {
                badCalculation(out);
                out.flush();
            }

            var example = path.replace("/calculate?", "");
            handleCalculate(example, out);
        } else {
            handleNotFound(out);
        }
        
        out.flush();
    }

    private static void handleGetNotes(PrintWriter out) {
        StringBuilder response = new StringBuilder();
        
        response.append("<html><body><h1>Notes</h1><ul>");
        for (String note : notes) {
            response.append("<li>").append(note).append("</li>");
        }
        response.append("</ul>");
        
        response.append("<form method='POST' action='/add-note'>") 
                    .append("<input type='text' name='note' placeholder='Add note' required>")
                    .append("<button type='submit'>Add</button>")
                .append("</form>");
        response.append("<form method='POST' action='/delete-note'>")
                    .append("<button type='submit'>Delete Last Note</button>")
                .append("</form>");
        response.append("</body></html>");
        
        sendHttpResponse(out, 200, response.toString());
    }

    // New
    private static void handleCalculate(String example, PrintWriter out) {
        try {
            String[] parts = example.split("&");
            if (parts.length != 3) {
                badCalculation(out);
                return;
            }
            
            parts = Arrays.stream(parts).sorted().toList().toArray(new String[0]);
            
            String[] aParts = parts[0].split("=");
            String[] bParts = parts[1].split("=");
            String[] opParts = parts[2].split("=");
            
            if (aParts.length != 2 || bParts.length != 2 || opParts.length != 2) {
                badCalculation(out);
                return;
            }

            double a;
            double b;
            
            if (aParts[0].equals("a")) {
                a = Double.parseDouble(aParts[1]);
            } else if (bParts[0].equals("a")) {
                a = Double.parseDouble(bParts[1]);
            } else {
                badCalculation(out);
                return;
            }

            if (aParts[0].equals("b")) {
                b = Double.parseDouble(aParts[1]);
            } else if (bParts[0].equals("b")) {
                b = Double.parseDouble(bParts[1]);
            } else {
                badCalculation(out);
                return;
            }

            String op = opParts[1];
            op = java.net.URLDecoder.decode(op, StandardCharsets.UTF_8);
            
            double result;
            
            switch (op) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    badCalculation(out);
                    return;
            }
            
            StringBuilder response = new StringBuilder();
            response.append("<html><body><h1>Result</h1>")
                    .append("<p>").append(a).append(" ").append(op).append(" ").append(b).append(" = ").append(result).append("</p>")
                    .append("<a href='/calculator'>Back to Calculation</a>")
                    .append("</body></html>");
            
            sendHttpResponse(out, 200, response.toString());
        }
        catch (Exception e) {
            badCalculation(out);
        }
    }

    private static void handleAddNote(String note, PrintWriter out) {
        if (note != null && !note.isEmpty()) {
            notes.add(note);
            sendHttpRedirect(out, "/notes");
        } else {
            sendHttpResponse(out, 400, "<html><body><h1>Invalid note</h1><a href='/notes'>Back to Notes</a></body></html>"); 
        }
    }

    private static void handleDeleteLastNote(PrintWriter out) {
        if (!notes.isEmpty()) {
            notes.remove(notes.size() - 1);
            
            sendHttpRedirect(out, "/notes");
        } else {
            sendHttpResponse(out, 400, "<html><body><h1>No notes to delete</h1><a href='/notes'>Back to Notes</a></body></html>"); 
        }
    }

    private static void handleNotFound(PrintWriter out) {
        sendHttpResponse(out, 404, "<html><body><h1>404 Not Found</h1></body></html>");
    }

    private static String extractBodyNote(BufferedReader in) throws IOException {
        String bodyString = extractBody(in);
        String[] parts = bodyString.split("=");
        return parts.length > 1 ? parts[1].replace("+", " ") : null;
    }

    private static String extractBody(BufferedReader in) throws IOException {
        StringBuilder body = new StringBuilder();
        String line;

        while (!(line = in.readLine()).isEmpty()) {
            // Считываем заголовки 
        }

        while (in.ready() && (line = in.readLine()) != null) {
            body.append(line);
        }

        return body.toString();
    }
    
    private static void badCalculation(PrintWriter out) {
        sendHttpResponse(out, 400, "<html><body><h1>Invalid calculation</h1><a href='/calculator'>Back to Calculation</a></body></html>");
    }

    private static void sendHttpResponse(PrintWriter out, int statusCode, String body) {
        out.println("HTTP/1.1 " + statusCode + " OK");
        out.println("Content-Type: text/html");
        out.println("Content-Length: " + body.length());
        out.println();
        out.println(body);
    }

    private static void sendHttpRedirect(PrintWriter out, String location) {
        out.println("HTTP/1.1 302 Found");
        out.println("Location: " + location);
        out.println("Content-Length: 0");
        out.println();
    }
}