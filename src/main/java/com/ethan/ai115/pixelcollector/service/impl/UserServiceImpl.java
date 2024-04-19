package com.ethan.ai115.pixelcollector.service.impl;

import com.ethan.ai115.pixelcollector.model.User;
import com.ethan.ai115.pixelcollector.repository.UserRepository;
import com.ethan.ai115.pixelcollector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User registerNewUser(User user) {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByWalletAddress(String walletAddress) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void deleteUserByUsername(String username) {

    }

    @Override
    public void deleteUserByEmail(String email) {

    }

    @Override
    public void deleteUserByWalletAddress(String walletAddress) {

    }

    @Override
    public boolean isUsernameTaken(String username) {
        return false;
    }

    @Override
    public boolean isEmailTaken(String email) {
        return false;
    }

    @Override
    public boolean isWalletAddressTaken(String walletAddress) {
        return false;
    }

    @Override
    public boolean isUserValid(User user) {
        return false;
    }

    @Override
    public boolean isUserValidForUpdate(User user) {
        return false;
    }

    @Override
    public boolean isUserValidForDeletion(User user) {
        return false;
    }

    @Override
    public boolean isUserValidForDeletionByUsername(String username) {
        return false;
    }

    @Override
    public boolean isUserValidForDeletionByEmail(String email) {
        return false;
    }

    @Override
    public boolean isUserValidForDeletionByWalletAddress(String walletAddress) {
        return false;
    }

    @Override
    public boolean isUserValidForUsername(String username) {
        return false;
    }

    @Override
    public boolean isUserValidForEmail(String email) {
        return false;
    }

    @Override
    public boolean isUserValidForWalletAddress(String walletAddress) {
        return false;
    }

    @Override
    public boolean isUserValidForUpdateUsername(String username) {
        return false;
    }

    @Override
    public boolean isUserValidForUpdateEmail(String email) {
        return false;
    }

    @Override
    public boolean isUserValidForUpdateWalletAddress(String walletAddress) {
        return false;
    }

    @Override
    public boolean isUserValidForUpdatePassword(String password) {
        return false;
    }

    @Override
    public boolean isUserValidForUpdateBirthDate(String birthDate) {
        return false;
    }

    @Override
    public boolean isUserValidForUpdate2faEnabled(boolean twoFactorAuthEnabled) {
        return false;
    }

    @Override
    public boolean isUserValidForUpdatePhoto(String photo) {
        return false;
    }

    @Override
    public User loginUser(String username, String password) {
        return null;
    }

    @Override
    public User findUserById(Long userId) {
        return null;
    }
}
