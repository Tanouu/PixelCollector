package com.ethan.ai115.pixelcollector.service;


import com.ethan.ai115.pixelcollector.dto.UserDto;
import com.ethan.ai115.pixelcollector.model.User;

public interface UserService {
    User registerNewUser(UserDto userDto);
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    User findUserByWalletAddress(String walletAddress);
    User updateUser(User user);
    void deleteUser(User user);
    void deleteUserByUsername(String username);
    void deleteUserByEmail(String email);
    void deleteUserByWalletAddress(String walletAddress);
    boolean isUsernameTaken(String username);
    boolean isEmailTaken(String email);
    boolean isWalletAddressTaken(String walletAddress);
    boolean isUserValid(User user);
    boolean isUserValidForUpdate(User user);
    boolean isUserValidForDeletion(User user);
    boolean isUserValidForDeletionByUsername(String username);
    boolean isUserValidForDeletionByEmail(String email);
    boolean isUserValidForDeletionByWalletAddress(String walletAddress);
    boolean isUserValidForUsername(String username);
    boolean isUserValidForEmail(String email);
    boolean isUserValidForWalletAddress(String walletAddress);
    boolean isUserValidForUpdateUsername(String username);
    boolean isUserValidForUpdateEmail(String email);
    boolean isUserValidForUpdateWalletAddress(String walletAddress);
    boolean isUserValidForUpdatePassword(String password);
    boolean isUserValidForUpdateBirthDate(String birthDate);
    boolean isUserValidForUpdate2faEnabled(boolean twoFactorAuthEnabled);
    boolean isUserValidForUpdatePhoto(String photo);

    User loginUser(String username, String password);

    User findUserById(Long userId);

    void updateWalletAddress(Long userId, String walletAddress);
}
