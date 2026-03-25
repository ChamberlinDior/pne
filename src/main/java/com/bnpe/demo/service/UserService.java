package com.bnpe.demo.service;

import com.bnpe.demo.dto.LoginRequest;
import com.bnpe.demo.dto.LoginResponse;
import com.bnpe.demo.dto.UserRequest;
import com.bnpe.demo.dto.UserResponse;
import com.bnpe.demo.exception.ResourceNotFoundException;
import com.bnpe.demo.model.Agence;
import com.bnpe.demo.model.User;
import com.bnpe.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final AgenceService agenceService;

    public UserService(UserRepository userRepository, AgenceService agenceService) {
        this.userRepository = userRepository;
        this.agenceService = agenceService;
    }

    public UserResponse create(UserRequest request) {
        Agence agence = agenceService.findEntityById(request.getAgenceId());

        User user = new User();
        user.setNomComplet(request.getNomComplet());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setAgence(agence);
        user.setActif(true);

        return mapToResponse(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur introuvable."));

        if (!user.isActif()) {
            throw new IllegalArgumentException("Le compte est désactivé.");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Mot de passe incorrect.");
        }

        LoginResponse response = new LoginResponse();
        response.setUserId(user.getId());
        response.setNomComplet(user.getNomComplet());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setAgenceId(user.getAgence().getId());
        response.setAgenceCode(user.getAgence().getCode());
        response.setAgenceNom(user.getAgence().getNom());
        response.setMessage("Connexion de démonstration réussie.");
        return response;
    }

    @Transactional(readOnly = true)
    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();
        List<UserResponse> responses = new ArrayList<>();
        for (User user : users) {
            responses.add(mapToResponse(user));
        }
        return responses;
    }

    @Transactional(readOnly = true)
    public User findEntityById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur introuvable : " + id));
    }

    private UserResponse mapToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setNomComplet(user.getNomComplet());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setAgenceId(user.getAgence().getId());
        response.setAgenceNom(user.getAgence().getNom());
        response.setActif(user.isActif());
        return response;
    }
}