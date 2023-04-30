package io.validitron.telesimclient.models;
import org.json.JSONArray;
import org.json.JSONObject;

public class Patient implements UserInterface {
    private String id;
    private String firstName;
    private String lastName;
    private

    private String dateOfBirth; // dd/mm/yyyy
    private String gender;// male; female; not to tell
    private String email;
    private String state;
    private String address;
    private String medicalHistory;
    private String allergies;
    private String medicine;


    public Patient() {
    }

    public Patient(String id, String firstName, String lastName, String phoneNumber, String dateOfBirth, String gender, String email, String state, String address, String medicalHistory, String allergies, String medicine) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.state = state;
        this.address = address;
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
        this.medicine = medicine;
    }

    public String getId() {
        return id;
    }

    public ing id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
    public String getLastName() {
        return lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    @Override
    public String search() {
        return null;
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String delete() {
        return null;
    }

    @Override
    public String add() {
        return null;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                ", address='" + address + '\'' +
                ", medicalHistory='" + medicalHistory + '\'' +
                ", allergies='" + allergies + '\'' +
                ", medicine='" + medicine + '\'' +
                '}';
    }
    public String getJsonString() {
        return "{\n" +
                " \"resourceType\": \"Patient\",\n" +
                " \"name\": [\n" +
                " {\n" +
                " \"given\": [\n" +
                " \"" + firstName + "\",\n" +
                " \"" + firstName + "\"\n" +
                " ],\n" +
                " \"family\": \"" + lastName + "\"\n" +
                " }\n" +
                " ],\n" +
                " \"birthDate\": \""+dateOfBirth+"\",\n" +
                " \"telecom\": [\n" +
                " {\n" +
                " \"system\": \"phone\",\n" +
                " \"value\": \"" + phoneNumber + "\"\n" +
                " },\n" +
                " {\n" +
                " \"system\": \"email\",\n" +
                " \"value\": \"" + email + "\"\n" +
                " }\n" +
                " ],\n" +
                " \"gender\": \"" + gender + "\",\n" +
                " \"address\": [\n" +
                " {\n" +
                " \"line\": [\n" +
                " \"" + address + "\"\n" +
                " ],\n" +
                " \"city\": \"Anytown\",\n" +
                " \"state\": \"" + state + "\",\n" +
                " \"postalCode\": \"12345\",\n" +
                " \"country\": \"US\"\n" +
                " }\n" +
                " ],\n" +
                " \"extension\": [\n" +
                " {\n" +
                " \"url\": \"http://hl7.org/fhir/StructureDefinition/patient-allergyInfo\",\n" +
                " \"valueString\": \"" + allergies +"\"\n" +
                " },\n" +
                " {\n" +
                " \"url\": \"http://hl7.org/fhir/StructureDefinition/patient-medicalHistory\",\n" +
                " \"valueString\": \"" + medicalHistory + "\"\n" +
                " },\n" +
                " {\n" +
                " \"url\": \"http://hl7.org/fhir/StructureDefinition/patient-currentMedication\",\n" +
                " \"valueString\": \"" + medicine + "\"\n" +
                " }\n" +
                " ]\n" +
                "}\n";
    }
    public JSONObject getJSON() {
        try {
            JSONObject patient = new JSONObject();
            patient.put("resourceType", "Patient");

            // Add name
            JSONArray nameArray = new JSONArray();
            JSONObject name = new JSONObject();
            JSONArray given = new JSONArray();
            given.put(this.firstName);
            name.put("family", this.lastName);
            name.put("given", given);
            nameArray.put(name);
            patient.put("name", nameArray);

            // Add birthDate
            patient.put("birthDate", this.dateOfBirth);

            // Add telecom
            JSONArray telecomArray = new JSONArray();
            JSONObject phone = new JSONObject();
            phone.put("system", "phone");
            phone.put("value", this.phoneNumber);
            telecomArray.put(phone);
            JSONObject email = new JSONObject();
            email.put("system", "email");
            email.put("value", this.email);
            telecomArray.put(email);
            patient.put("telecom", telecomArray);

            // Add gender
            patient.put("gender", this.gender);

            // Add address
            JSONArray addressArray = new JSONArray();
            JSONObject address = new JSONObject();
            JSONArray line = new JSONArray();
            line.put(this.address);
            address.put("line", line);
            address.put("state", this.state);
            addressArray.put(address);
            patient.put("address", addressArray);

            // Add extension
            JSONArray extensionArray = new JSONArray();
            JSONObject allergyInfo = new JSONObject();
            String allergyInfoString = "allergy";
            allergyInfo.put("url", allergyInfoString);
            allergyInfo.put("valueString", this.allergies);
            extensionArray.put(allergyInfo);
            JSONObject medicalHistory = new JSONObject();
            String medicalHistoryString = "medical";
            medicalHistory.put("url", medicalHistoryString);
            medicalHistory.put("valueString", this.medicalHistory);
            extensionArray.put(medicalHistory);

            JSONObject medicine = new JSONObject();
            String medicineString = "medicine";
            medicine.put("url", medicineString);
            medicine.put("valueString", this.medicine);
            extensionArray.put(medicine);

            patient.put("extension", extensionArray);

            return patient;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
