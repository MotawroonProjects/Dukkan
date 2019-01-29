package com.appzone.dukkan.models;

import java.io.Serializable;

public class UserModel implements Serializable{

    private String token;
    private User user;

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }

    public class User implements Serializable
    {
        private int id;
        private String name;
        private String phone;
        private String alternative_phone;
        private int gender;
        private String avatar;
        private String email;
        private String id_image;
        private String license;
        private String car_license;
        private String car_front;
        private String car_back;
        private int active;
        private String role;
        private double rate;
        private int coupon;
        private int points;


        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public String getAlternative_phone() {
            return alternative_phone;
        }

        public int getGender() {
            return gender;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getEmail() {
            return email;
        }

        public String getId_image() {
            return id_image;
        }

        public String getLicense() {
            return license;
        }

        public String getCar_license() {
            return car_license;
        }

        public String getCar_front() {
            return car_front;
        }

        public String getCar_back() {
            return car_back;
        }

        public int getActive() {
            return active;
        }

        public String getRole() {
            return role;
        }

        public double getRate() {
            return rate;
        }

        public int getCoupon() {
            return coupon;
        }

        public int getPoints() {
            return points;
        }
    }
}
