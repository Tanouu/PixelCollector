package com.ethan.ai115.pixelcollector.dto;

public class RegisterDto {

        private String username;
        private String password;
        private String email;
        private String birthDate;
        private String walletAddress;
        private boolean twoFactorAuthEnabled;
        private String photo;

        public RegisterDto() {
        }

        public RegisterDto(String username, String password, String email, String birthDate, String walletAddress, boolean twoFactorAuthEnabled, String photo) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.birthDate = birthDate;
            this.walletAddress = walletAddress;
            this.twoFactorAuthEnabled = twoFactorAuthEnabled;
            this.photo = photo;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public String getWalletAddress() {
            return walletAddress;
        }

        public void setWalletAddress(String walletAddress) {
            this.walletAddress = walletAddress;
        }

        public boolean isTwoFactorAuthEnabled() {
            return twoFactorAuthEnabled;
        }

        public void setTwoFactorAuthEnabled(boolean twoFactorAuthEnabled) {
            this.twoFactorAuthEnabled = twoFactorAuthEnabled;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        @Override
        public String toString() {
            return "RegisterDto{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", birthDate='" + birthDate + '\'' +
                    ", walletAddress='" + walletAddress + '\'' +
                    ", twoFactorAuthEnabled=" + twoFactorAuthEnabled +
                    ", photo='" + photo + '\'' +
                    '}';
        }

}
