package com.ethan.ai115.pixelcollector.dto;

public class LoginDto {

        private String username;
        private String password;
        private String totp;

        public LoginDto() {
        }

        public LoginDto(String username, String password, String totp) {
            this.username = username;
            this.password = password;
            this.totp = totp;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    public String getTotp() {
        return totp;
    }

    public void setTotp(String totp) {
        this.totp = totp;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", totp='" + totp + '\'' +
                '}';
    }
}
