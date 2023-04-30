package io.validitron.telesimclient.models;

import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.id

import java.util.*;

import org.springframework.web.bind.annotation.PostMapping;
import io.validitron.telesimclient.models.Patient;
import io.validitron.telesimclient.models.UserInterface;
import io.validitron.telesimclient.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



import javax.ws.rs.core.Response;

public class KeycloakServer {

    String serverUrl = "https://keycloak-uom1.comp90082-2023.vsbox.dev/auth";
    String realm = "master";
    String username = "unimo_admin_2";
    String password = "12345678";
    Keycloak keycloak;

    // For test
//    public static void main(String[] args){
//        KeycloakServer s = new KeycloakServer();
//        s.addNewUser("1234312", "1997-10-01", "kl", "ss",
//                "li@lik.com", "male");
//    }
    public KeycloakServer(){
        // Create Keycloak instance
        keycloak = KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .username(username) // the name of admin role in Keycloak
                .password(password) // password of admin
                .clientId("admin-cli")
                .build();
    }

    public KeycloakServer(String serverUrl, String realm, String username, String password){
        keycloak = KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .username(username) // the name of admin role in Keycloak
                .password(password) // password of admin
                .clientId("admin-cli")
                .build();
    }
    public void addNewUser(String phoneNumber, String birthDate, String firstName, String lastName,
                           String email, String gender, String FHIRId){

        // Create a new user instance
//        UUID uuid = UUID.randomUUID();
        List<UserRepresentation> users = keycloak.realm("master")
                .users().search(phoneNumber);

        System.out.println(phoneNumber);
        // TODO: if the phone number exists
        if (!users.isEmpty()) {
            System.out.println("phone number already exists");
            return;
        }
        System.out.println(phoneNumber);
        UserRepresentation user = new UserRepresentation();
        user.setEnabled(true);
        user.setId(phoneNumber);
        user.setUsername(phoneNumber);
        user.setFirstName(firstName);
        user.setLa);
        user.setEmail(email);
        List<String> list = new ArrayList<>();
        list.add("VirtualDoctor.Patients");
        user.setGroups(list);

        // Add attributes
        Map<String, List<String>> attributes = new HashMap<>();
        attributes.put("birthdate", Arrays.asList(birthDate));
        attributes.put("geRId));
        user.setAttributes(attributes);

        // Add new user to Keycloak
        RealmResource realmResource = keycloak.realm(realm);
        UsersResource usersResource = realmResource.users();
        Response response = usersResource.create(user);
        String userId = CreatedResponseUtil.getCreatedId(response);
        System.out.println("User created with ID: " + userId);

    }


    public void createNewKeycloakConnection(){
        Keycloak newKeycloak = KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .username(username) // the name of admin role in Keycloak
                .password(password) // password of admin
                .clientId("admin-cli")
                .build();

        this.keycloak.close();
        this.keycloak = newKeycloak;
    }

    public Map<String, String> getUserAttribute(String userId) {

        Keycloak kcMaster = this.keycloak;
        RealmResource realmResource = kcMaster.realm(realm);
        UsersResource userResource = realmResource.users();
        Map<String, String> attributeMap = new HashMap<>();
        List<UserRepresentation> userList = userResource.list();

        for (UserRepresentation user : userList) {
            Map<String, List<String>> userAttributesList = user.getAttributes();
            if (userId != null && userId.equals(user.getId())) {
                for (String key : userAttributesList.keySet()) {
                    String attribute = null;
                    if (userAttributesList != null && userAttributesList.get(key) != null && userAttributesList.get(key).size() > 0) {
                        attribute = userAttributesList.get(key).get(0);
                    }
                    attributeMap.put(key, attribute);
                }
            }
        }
        return attributeMap;
    }

    public void signUpNewUser(Patient patient) {
        addNewUser(patient.getPhoneNumber(), patient.getDateOfBirth(), patient.getFirstName(),
                patient.getLastName(), patient.getEmail(), patient.getGender(), patient.getId());
    }

    public boolean isExists(String id){
        List<UserRepresentation> users = keycloak.realm("master")
                .users().search(id);
        if(!users.isEmpty())return true;
        return false;
    }
}
