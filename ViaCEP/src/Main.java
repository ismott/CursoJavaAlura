import br.com.israel.viaCep.controller.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class Main {
    void main(String[] args) throws IOException, InterruptedException {
        Request request = new Request();
        Scanner read = new Scanner(System.in);
        System.out.println("Digite o CEP para busca");
        var search = URLEncoder.encode(read.nextLine(), StandardCharsets.UTF_8);
        request.get(search);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter fileWriter = new FileWriter("cep.json");
        fileWriter.write(gson.toJson(request.get(search)));
        fileWriter.close();
    }
}
