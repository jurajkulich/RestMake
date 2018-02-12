package com.example.juraj.restmake.Instances;

/**
 * Created by Juraj on 2/12/2018.
 */

public class User {
    private String firstName;
    private String lastName;
    private String profileDescription;
    private Double rating;
    private String phoneNumber;
    private String birthDate;

    public User() {
        this.firstName = "";
        this.lastName = "";
        this.profileDescription = "";
        this.rating = 0.0;
        this.phoneNumber = "";
        this.birthDate = "";
    }

    public static class UserBuilder {
        private String builderFirstName;
        private String builderLastName;
        private String builderProfileDescription;
        private Double builderRating;
        private String builderPhoneNumber;
        private String builderBirthDate;

        public UserBuilder(String builderFirstName, String builderLastName, String builderBirthDate) {
            this.builderFirstName = builderFirstName;
            this.builderLastName = builderLastName;
            this.builderBirthDate = builderBirthDate;
        }

        public UserBuilder ProfileDescription(String builderProfileDescription) {
            this.builderProfileDescription = builderProfileDescription;
            return this;
        }

        public UserBuilder Rating(double builderRating) {
            this.builderRating = builderRating;
            return this;
        }

        public UserBuilder PhoneNumber(String builderPhoneNumber) {
            this.builderPhoneNumber = builderPhoneNumber;
            return this;
        }
    }


}
