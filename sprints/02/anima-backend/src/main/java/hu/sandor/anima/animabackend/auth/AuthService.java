package hu.sandor.anima.animabackend.auth;

import hu.sandor.anima.animabackend.auth.dto.AuthResponse;
import hu.sandor.anima.animabackend.auth.dto.LoginRequest;
import hu.sandor.anima.animabackend.auth.dto.RegisterRequest;
import hu.sandor.anima.animabackend.user.User;
import hu.sandor.anima.animabackend.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public AuthService(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (repo.existsByUsername(request.getUsername()))
            throw new IllegalArgumentException("Username already exists");

        if (repo.existsByEmail(request.getEmail()))
            throw new IllegalArgumentException("Email already exists");

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPasswordHash(encoder.encode(request.getPassword()));

        User saved = repo.save(user);
        return new AuthResponse(saved.getId(), saved.getUsername());
    }

    @Transactional(readOnly = true)
    public AuthResponse login(LoginRequest request) {
        User user = repo.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if (!encoder.matches(request.getPassword(), user.getPasswordHash()))
            throw new IllegalArgumentException("Invalid credentials");

        return new AuthResponse(user.getId(), user.getUsername());
    }
}

