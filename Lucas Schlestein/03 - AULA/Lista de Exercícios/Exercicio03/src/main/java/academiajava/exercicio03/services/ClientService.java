package academiajava.exercicio03.services;

import academiajava.exercicio03.entities.Client;

public class ClientService {

    public boolean authenticate(Client client, String input, String password) {
        return (input.equals(client.getEmail()) || input.equalsIgnoreCase(client.getName())) && password.equals(client.getPassword());
    }

}
